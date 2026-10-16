package mtn.minecraft_layer.net.minecraft.client.renderer;

/**
 * Stand-in for {@code net.minecraft.client.renderer.RenderBlocks} (Forge 1.7.10).
 * Forge 1.7.10 used this to render block models in legacy pipelines; the
 * IronChest renderer only instantiates it (field kept for parity) and does the
 * visible work through {@code ModelChest} + the Fabric ModelPart bridge.
 */
public class RenderBlocks {

    /** IronChest keeps a field of this type; no real block-view rendering in v1. */
    public boolean useInventoryTint = true;

    public RenderBlocks() {
    }
}
