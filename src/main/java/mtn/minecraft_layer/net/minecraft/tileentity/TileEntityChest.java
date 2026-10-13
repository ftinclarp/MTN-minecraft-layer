package mtn.minecraft_layer.net.minecraft.tileentity;

/**
 * Dummy stand-in for {@code net.minecraft.tileentity.TileEntityChest}
 * (Forge 1.7.10). Just enough for {@code instanceof} checks and the
 * reflection handle used by ItemChestChanger.
 */
public class TileEntityChest extends TileEntity {
    // In Forge 1.7.10 the inventory field is "field 0" of this class;
    // accessed reflectively by IronChest's ItemChestChanger.
    // TODO(mtn-layer): hold a real ItemStack[] backed by the Fabric inventory.
    public mtn.minecraft_layer.net.minecraft.item.ItemStack[] chestContents;
}
