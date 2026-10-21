package mtn.minecraft_layer.net.minecraft.client.renderer.tileentity;

import java.util.HashMap;
import java.util.Map;
import mtn.minecraft_layer.net.minecraft.tileentity.TileEntity;
import mtn.minecraft_layer.net.minecraft.util.ResourceLocation;
import mtn.minecraft_layer.net.minecraft.world.World;

/**
 * Stand-in for {@code net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher}
 * (Forge 1.7.10) — holds the registered per-class renderers and the world
 * render origin the ported IronChest renderer reads through
 * {@code field_147501_a.field_147560_j} etc.
 *
 * <p>Also carries the <em>current Fabric render context</em> for the ported
 * {@code ModelRenderer} bridge: the {@link PoseStack} and the strip of the
 * currently-bound texture's {@code RenderType} are installed by the forge-layer
 * {@code ForgeTESRBridge} right before delegating
 * ({@code matri...}). {@link ModelRenderer} reads them to emit quads.
 */
public class TileEntityRendererDispatcher {

    public static final TileEntityRendererDispatcher instance =
            new TileEntityRendererDispatcher();

    /** Render origin (world coords) — read by IronChest via SRG names. */
    public double field_147560_j;
    public double field_147561_k;
    public double field_147558_l;
    /** Client world — read by the ported renderer for entity context. */
    public World field_147550_f;

    private final Map<Class<? extends TileEntity>, TileEntitySpecialRenderer<?>> renderers =
            new HashMap<>();

    // ---- current Fabric render context (set by forge-layer bridge) ----
    private com.mojang.blaze3d.vertex.PoseStack currentPoseStack;
    private net.minecraft.client.renderer.MultiBufferSource currentConsumers;
    private net.minecraft.resources.ResourceLocation currentTexture;
    private int currentLight;
    private int currentOverlay;
    private boolean contextInstalled;

    public TileEntityRendererDispatcher() {
        field_147560_j = 0.0D;
        field_147561_k = 0.0D;
        field_147558_l = 0.0D;
        field_147550_f = new World();
        // TODO(mtn-layer): populating field_147550_f from the Fabric client
        //  world happens in the forge-layer ForgeTESRBridge during render.
    }

    public void bindTileEntitySpecialRenderer(Class<? extends TileEntity> clazz,
                                              TileEntitySpecialRenderer<?> renderer) {
        renderers.put(clazz, renderer);
        renderer.field_147501_a = this;
    }

    public TileEntitySpecialRenderer<?> getSpecialRenderer(Class<? extends TileEntity> clazz) {
        return renderers.get(clazz);
    }

    /** Forge 1.7.10: render the tile entity at block-relative coordinates. */
    public void renderTileEntityAt(TileEntity te, double x, double y, double z,
                                   float partialTicks) {
        TileEntitySpecialRenderer renderer = renderers.get(te.getClass());
        if (renderer != null) {
            renderer.renderTileEntityAt(te, x, y, z, partialTicks);
        }
    }

    public void bindTexture(ResourceLocation location) {
        if (location != null) {
            currentTexture = net.minecraft.resources.ResourceLocation
                    .fromNamespaceAndPath(location.getResourceDomain(),
                            location.getResourcePath());
        }
    }

    // ---- current-context API for the ModelRenderer bridge ----

    /** Install the Fabric render context for the current frame. */
    public void installRenderContext(com.mojang.blaze3d.vertex.PoseStack matrices,
                                     net.minecraft.client.renderer.MultiBufferSource consumers) {
        installRenderContext(matrices, consumers, 0xF000F0, 0);
    }

    /** Install the Fabric render context including per-vertex light/overlay. */
    public void installRenderContext(com.mojang.blaze3d.vertex.PoseStack matrices,
                                     net.minecraft.client.renderer.MultiBufferSource consumers,
                                     int light, int overlay) {
        this.currentPoseStack = matrices;
        this.currentConsumers = consumers;
        this.currentLight = light;
        this.currentOverlay = overlay;
        this.contextInstalled = true;
    }

    /** Clears the context after a render (defensive: nothing holds it). */
    public void clearRenderContext() {
        this.currentPoseStack = null;
        this.currentConsumers = null;
        this.currentTexture = null;
        this.currentLight = 0xF000F0;
        this.currentOverlay = 0;
        this.contextInstalled = false;
    }

    public com.mojang.blaze3d.vertex.PoseStack getCurrentPoseStack() {
        return currentPoseStack;
    }

    public boolean isContextInstalled() {
        return contextInstalled;
    }

    public net.minecraft.resources.ResourceLocation getCurrentTexture() {
        return currentTexture;
    }

    public int getCurrentLight() {
        return currentLight;
    }

    public int getCurrentOverlay() {
        return currentOverlay;
    }

    /**
     * Returns a {@code VertexConsumer} for the currently-bound texture's
     * {@code RenderType} (entity cutout), obtained from the installed
     * {@code MultiBufferSource}; {@code null} when no context/texture is set.
     */
    public com.mojang.blaze3d.vertex.VertexConsumer getCurrentVertexConsumer() {
        if (currentConsumers == null || currentTexture == null) {
            return null;
        }
        return currentConsumers.getBuffer(
                net.minecraft.client.renderer.RenderType.entityCutout(currentTexture));
    }
}
