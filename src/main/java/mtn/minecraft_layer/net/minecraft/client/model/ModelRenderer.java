package mtn.minecraft_layer.net.minecraft.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import org.joml.Matrix4f;

import java.util.ArrayList;
import java.util.List;

/**
 * Bridge for {@code net.minecraft.client.model.ModelRenderer} (Forge 1.7.10).
 *
 * <p>Records the cube geometry the mod registers via {@link #addBox} (with
 * {@link #setTextureOffset(int, int)} and {@link #setTextureSize(int, int)}
 * that the mod sets) and, in {@link #render(float)}, emits that geometry as
 * actual textured quads through the active Fabric render context — the current
 * {@link PoseStack} and the {@link VertexConsumer} for the dispatcher's
 * currently-bound texture, installed by the forge-layer {@code ForgeTESRBridge}.
 *
 * <p>This keeps the mod's rendering code intact: the mod calls
 * {@code addBox(...)}, {@code setRotationPoint(...)} and sets
 * {@code rotateAngleX/Y/Z} exactly as in Forge 1.7.10, and the layer draws it.
 */
public class ModelRenderer {

    /** Rotation pivot point in model space. Set by the mod. */
    public float rotationPointX;
    public float rotationPointY;
    public float rotationPointZ;

    /** Rotation in radians around each axis. Set by the mod (e.g. lid). */
    public float rotateAngleX;
    public float rotateAngleY;
    public float rotateAngleZ;

    /** Additional offsets applied by the renderer. */
    public float offsetX;
    public float offsetY;
    public float offsetZ;

    public float textureWidth = 64.0F;
    public float textureHeight = 64.0F;
    public boolean mirror;

    private final String boxName;
    private final List<Cube> cubes;

    /** UV origin set by the mod via setTextureOffset() before addBox(). */
    private float textureOffsetX;
    private float textureOffsetY;

    public ModelRenderer() {
        this(null);
    }

    public ModelRenderer(String boxName) {
        this.boxName = boxName;
        this.cubes = new ArrayList<>();
    }

    public void addBox(float x, float y, float z, int width, int height, int depth) {
        addBox(x, y, z, width, height, depth, 0.0F);
    }

    public void addBox(float x, float y, float z, int width, int height, int depth,
                       float scaleFactor) {
        cubes.add(new Cube(x, y, z, width, height, depth, scaleFactor,
                textureOffsetX, textureOffsetY));
    }

    /**
     * Renders this part into the current Fabric render context, applying the
     * 1.7.10 pivot + rotation ordering.
     */
    public void render(float scale) {
        mtn.minecraft_layer.net.minecraft.client.renderer.tileentity
                .TileEntityRendererDispatcher dispatcher =
                mtn.minecraft_layer.net.minecraft.client.renderer.tileentity
                        .TileEntityRendererDispatcher.instance;
        PoseStack matrices = dispatcher.getCurrentPoseStack();
        if (matrices == null || cubes.isEmpty()) {
            return;
        }
        matrices.pushPose();

        // 1.7.10 ModelRenderer.render(float):
        //   translate(offset) -> translate(rotationPoint) ->
        //   rotate(Z then Y then X) -> (mirror flip).
        matrices.translate(offsetX, offsetY, offsetZ);
        matrices.translate(rotationPointX * scale,
                rotationPointY * scale, rotationPointZ * scale);
        if (rotateAngleZ != 0.0F) {
            matrices.mulPose(Axis.ZP.rotation(rotateAngleZ));
        }
        if (rotateAngleY != 0.0F) {
            matrices.mulPose(Axis.YP.rotation(rotateAngleY));
        }
        if (rotateAngleX != 0.0F) {
            matrices.mulPose(Axis.XP.rotation(rotateAngleX));
        }
        if (mirror) {
            matrices.scale(-1.0F, 1.0F, 1.0F);
        }

        // The 1.0-body scale factor (0.0625) applied once here: all cubes are
        // in raw pixel coordinates and are transformed by the pose matrix we
        // pass into emit. Applying it at this level (as the user suggested)
        // keeps the whole cube list on a single scale and makes the size
        // correct (1 block for a 16-px cube).
        matrices.scale(scale, scale, scale);

        for (Cube cube : cubes) {
            cube.render(matrices, dispatcher, textureWidth, textureHeight);
        }

        matrices.popPose();
    }

    public void render() {
        render(0.0625F);
    }

    public void setRotationPoint(float x, float y, float z) {
        this.rotationPointX = x;
        this.rotationPointY = y;
        this.rotationPointZ = z;
    }

    public void setTextureOffset(int u, int v) {
        this.textureOffsetX = u;
        this.textureOffsetY = v;
    }

    public void setTextureSize(int w, int h) {
        this.textureWidth = w;
        this.textureHeight = h;
    }

    public String boxName() {
        return boxName;
    }

    /** One axis-aligned cube, in model units, mapped onto a sheet slice. */
    private static final class Cube {
        final float x, y, z;
        final int w, h, d;
        final float u0, v0;

        Cube(float x, float y, float z, int w, int h, int d,
             float scale, float u0, float v0) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.w = w;
            this.h = h;
            this.d = d;
            this.u0 = u0;
            this.v0 = v0;
        }

        void render(PoseStack matrices,
                    mtn.minecraft_layer.net.minecraft.client.renderer.tileentity
                            .TileEntityRendererDispatcher dispatcher,
                    float tw, float th) {
            VertexConsumer consumer = dispatcher.getCurrentVertexConsumer();
            if (consumer == null) {
                return;
            }
            int light = dispatcher.getCurrentLight();
            int overlay = dispatcher.getCurrentOverlay();
            // Capture the current pose so raw cube pixel coords are transformed
            // by the model matrix (including the scale above).
            Matrix4f poseMatrix = matrices.last().pose();
            float x0 = this.x, y0 = this.y, z0 = this.z;
            float x1 = this.x + this.w, y1 = this.y + this.h, z1 = this.z + this.d;

            // Helper layout from the classic 1.7.10 ModelBox (64-wide sheet).
            //   top (+Y) strip:    u0, v0..v0+w? use u horizontally, v vertically.
            // We reproduce the well-known layout where each face uses slices:
            //   top   : (u0 + d -> u0 + d + w) across x, (v0 -> v0 + d) across z
            //   bottom: (u0 + d + w -> u0 + 2d + w) across x, (v0 + d -> v0) ...
            //   front (+Z): (u0 + d -> u0 + d + w) across x, (v0 + d -> v0 + d + h) across y
            //   back  (-Z): (u0 -> u0 + w) across x, (v0 + d -> v0 + d + h) across y
            //   left  (-X): (u0 -> u0 + d) across z, (v0 + d -> v0 + d + h) across y
            //   right (+X): (u0 + d + w -> u0 + 2d + w) across z, (v0 + d -> v0 + d + h) across y

            float uTop = (u0 + d) / tw;
            float vTop = v0 / th;
            float uTopR = (u0 + d + w) / tw;
            float vTopD = (v0 + d) / th;

            float uBot = (u0 + d + w) / tw;
            float vBot = (v0 + d + w - d) / th; // bottom strips v go the other way
            float uBotR = (u0 + 2 * d + w) / tw;

            float uFrontL = (u0 + d) / tw;
            float uFrontR = (u0 + d + w) / tw;
            float vFrontTop = (v0 + d) / th;
            float vFrontBot = (v0 + d + h) / th;
            float uBackL = u0 / tw;
            float uBackR = (u0 + w) / tw;

            float uLeftL = u0 / tw;
            float uLeftR = (u0 + d) / tw;
            float vSideTop = (v0 + d) / th;
            float vSideBot = (v0 + d + h) / th;
            float uRightL = (u0 + d + w) / tw;
            float uRightR = (u0 + 2 * d + w) / tw;

            // top (+Y)
            quad(consumer, poseMatrix, light, overlay,
                    x0, y1, z0, uTop, vTopD, 0, 1, 0,
                    x1, y1, z0, uTopR, vTopD, 0, 1, 0,
                    x1, y1, z1, uTopR, vTop, 0, 1, 0,
                    x0, y1, z1, uTop, vTop, 0, 1, 0);
            // bottom (-Y)
            quad(consumer, poseMatrix, light, overlay,
                    x0, y0, z1, uBot, vBot, 0, -1, 0,
                    x1, y0, z1, uBotR, vBot, 0, -1, 0,
                    x1, y0, z0, uBotR, vBot + (float) d / th, 0, -1, 0,
                    x0, y0, z0, uBot, vBot + (float) d / th, 0, -1, 0);
            // front (+Z)
            quad(consumer, poseMatrix, light, overlay,
                    x0, y1, z1, uFrontL, vFrontTop, 0, 0, 1,
                    x1, y1, z1, uFrontR, vFrontTop, 0, 0, 1,
                    x1, y0, z1, uFrontR, vFrontBot, 0, 0, 1,
                    x0, y0, z1, uFrontL, vFrontBot, 0, 0, 1);
            // back (-Z)
            quad(consumer, poseMatrix, light, overlay,
                    x0, y1, z0, uBackL, vFrontTop, 0, 0, -1,
                    x1, y1, z0, uBackR, vFrontTop, 0, 0, -1,
                    x1, y0, z0, uBackR, vFrontBot, 0, 0, -1,
                    x0, y0, z0, uBackL, vFrontBot, 0, 0, -1);
            // left (-X)
            quad(consumer, poseMatrix, light, overlay,
                    x0, y1, z1, uLeftL, vSideTop, -1, 0, 0,
                    x0, y1, z0, uLeftR, vSideTop, -1, 0, 0,
                    x0, y0, z0, uLeftR, vSideBot, -1, 0, 0,
                    x0, y0, z1, uLeftL, vSideBot, -1, 0, 0);
            // right (+X)
            quad(consumer, poseMatrix, light, overlay,
                    x1, y1, z0, uRightL, vSideTop, 1, 0, 0,
                    x1, y1, z1, uRightR, vSideTop, 1, 0, 0,
                    x1, y0, z1, uRightR, vSideBot, 1, 0, 0,
                    x1, y0, z0, uRightL, vSideBot, 1, 0, 0);
        }

        /** Emit one quad (4 vertices, each with position + uv + normal + light). */
        void quad(VertexConsumer consumer, Matrix4f pose, int light, int overlay,
                  float x0, float y0, float z0, float u0, float v0, float nx0, float ny0, float nz0,
                  float x1, float y1, float z1, float u1, float v1, float nx1, float ny1, float nz1,
                  float x2, float y2, float z2, float u2, float v2, float nx2, float ny2, float nz2,
                  float x3, float y3, float z3, float u3, float v3, float nx3, float ny3, float nz3) {
            vertex(consumer, pose, light, overlay, x0, y0, z0, u0, v0, nx0, ny0, nz0);
            vertex(consumer, pose, light, overlay, x1, y1, z1, u1, v1, nx1, ny1, nz1);
            vertex(consumer, pose, light, overlay, x2, y2, z2, u2, v2, nx2, ny2, nz2);
            vertex(consumer, pose, light, overlay, x3, y3, z3, u3, v3, nx3, ny3, nz3);
        }

        static void vertex(VertexConsumer consumer, Matrix4f pose, int light, int overlay,
                           float x, float y, float z,
                           float u, float v, float nx, float ny, float nz) {
            consumer.addVertex(pose, x, y, z)
                    .setColor(1.0F, 1.0F, 1.0F, 1.0F)
                    .setUv(u, v)
                    .setUv1(overlay & 0xFFFF, overlay >> 16 & 0xFFFF)
                    .setUv2(light & 0xFFFF, light >> 16 & 0xFFFF)
                    .setNormal(nx, ny, nz);
        }
    }
}
