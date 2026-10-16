package mtn.minecraft_layer.net.minecraft.client.model;

/**
 * Stand-in for {@code net.minecraft.client.model.ModelRenderer} (Forge 1.7.10)
 * — a data holder for one model part. It carries the rotation/translation
 * state that mods set (e.g. {@code chestLid.rotateAngleX}), but in v1 it is
 * NOT the thing that draws: the Fabric ModelPart bridge in the forge layer
 * bypasses this class entirely.
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
    public float textureHeight = 32.0F;
    public boolean mirror;

    private final String boxName;

    public ModelRenderer() {
        this(null);
    }

    public ModelRenderer(String boxName) {
        this.boxName = boxName;
    }

    public void addBox(float x, float y, float z, int width, int height, int depth) {
        // TODO(mtn-layer): register the box with the Fabric ModelPart bridge so
        //  the part actually renders. No-op data-holder for v1.
    }

    public void addBox(float x, float y, float z, int width, int height, int depth,
                       float scaleFactor) {
        addBox(x, y, z, width, height, depth);
    }

    public void render(float scale) {
        // TODO(mtn-layer): emit quad geometry for this part through the active
        //  Fabric VertexConsumer. No-op data-holder for v1 — the bridge
        //  bypasses ModelRenderer.
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
    }

    public void setTextureSize(int w, int h) {
        this.textureWidth = w;
        this.textureHeight = h;
    }

    public String boxName() {
        return boxName;
    }
}
