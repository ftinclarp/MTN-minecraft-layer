package mtn.minecraft_layer.net.minecraft.tileentity;

/**
 * Dummy stand-in for {@code net.minecraft.tileentity.TileEntityChest}
 * (Forge 1.7.10). Just enough for {@code instanceof} checks and the
 * reflection handle used by ItemChestChanger.
 */
public class TileEntityChest extends TileEntity implements mtn.minecraft_layer.net.minecraft.inventory.IInventory {
    // In Forge 1.7.10 the inventory field is "field 0" of this class;
    // accessed reflectively by IronChest's ItemChestChanger.
    // TODO(mtn-layer): hold a real ItemStack[] backed by the Fabric inventory.
    public mtn.minecraft_layer.net.minecraft.item.ItemStack[] chestContents;

    // Used by ItemChestChanger / ContainerIronChest neighbour checks.
    public int numPlayersUsing;

    // ---------------- IInventory / Forge 1.7.10 TileEntityChest surface --------
    // All bodies are safe defaults; ItemChestChanger only needs returns/states.

    @Override
    public int getSizeInventory() {
        // TODO(mtn-layer): real size (double chest consider both halves).
        return chestContents == null ? 0 : chestContents.length;
    }

    @Override
    public mtn.minecraft_layer.net.minecraft.item.ItemStack getStackInSlot(int i) {
        // TODO(mtn-layer): return the slot contents.
        return null;
    }

    @Override
    public mtn.minecraft_layer.net.minecraft.item.ItemStack decrStackSize(int i, int count) {
        // TODO(mtn-layer): shrink the slot by count.
        return null;
    }

    @Override
    public mtn.minecraft_layer.net.minecraft.item.ItemStack getStackInSlotOnClosing(int i) {
        // TODO(mtn-layer): return+clear the slot on container close.
        return null;
    }

    @Override
    public void setInventorySlotContents(int i, mtn.minecraft_layer.net.minecraft.item.ItemStack stack) {
        // TODO(mtn-layer): write the slot contents.
    }

    @Override
    public String getInventoryName() {
        // TODO(mtn-layer): localised chest name.
        return "container.chest";
    }

    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        // TODO(mtn-layer): real stack limit.
        return 64;
    }

    @Override
    public void markDirty() {
        super.markDirty();
    }

    @Override
    public boolean isUseableByPlayer(mtn.minecraft_layer.net.minecraft.entity.player.EntityPlayer player) {
        // TODO(mtn-layer): distance check.
        return true;
    }

    @Override
    public void openInventory() {
    }

    @Override
    public void closeInventory() {
    }

    @Override
    public boolean isItemValidForSlot(int i, mtn.minecraft_layer.net.minecraft.item.ItemStack stack) {
        return true;
    }

    /** Forge 1.7.10: refresh block-state dependent fields after placement. */
    public void updateContainingBlockInfo() {
        // TODO(mtn-layer): refresh adjacent-chest state.
    }

    /** Forge 1.7.10: initial double-chest link-up. */
    public void checkForAdjacentChests() {
        // TODO(mtn-layer): find the neighbouring chest.
    }
}
