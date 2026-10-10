package mtn.minecraft_layer.net.minecraft.inventory;

import mtn.minecraft_layer.net.minecraft.item.ItemStack;

/**
 * Dummy stand-in for {@code net.minecraft.inventory.Slot}
 * (Forge 1.7.10). Binds a slot index to an {@link IInventory}.
 */
public class Slot {
    public final IInventory inventory;
    public final int slotIndex;
    public int xDisplayPosition;
    public int yDisplayPosition;

    public Slot(IInventory inventory, int slotIndex, int x, int y) {
        this.inventory = inventory;
        this.slotIndex = slotIndex;
        this.xDisplayPosition = x;
        this.yDisplayPosition = y;
    }

    public ItemStack getStack() {
        return inventory.getStackInSlot(slotIndex);
    }

    public void putStack(ItemStack stack) {
        inventory.setInventorySlotContents(slotIndex, stack);
    }

    public int getSlotIndex() {
        return slotIndex;
    }

    public boolean isItemValid(ItemStack stack) {
        return inventory.isItemValidForSlot(slotIndex, stack);
    }
}
