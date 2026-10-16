package mtn.minecraft_layer.net.minecraft.client.renderer.tileentity;

import mtn.minecraft_layer.net.minecraft.block.Block;

/**
 * Stand-in for {@code net.minecraft.client.renderer.tileentity.TileEntityRendererChestHelper}
 * (Forge 1.7.10) — renders a chest in an item/entity context. IronChest
 * overrides {@link #renderChest} and installs an instance into the static
 * {@link #instance} field.
 */
public class TileEntityRendererChestHelper {

    public static TileEntityRendererChestHelper instance = new TileEntityRendererChestHelper();

    public void renderChest(Block block, int meta, float partialTicks) {
        // TODO(mtn-layer): item/entity chest rendering — the forge-layer bridge
        //  renders the model via Fabric ModelPart.
    }

    public void renderChest(Block block, int meta, float partialTicks,
                            TileEntityRendererDispatcher dispatcher) {
        renderChest(block, meta, partialTicks);
    }
}
