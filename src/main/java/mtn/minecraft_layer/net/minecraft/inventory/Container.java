package mtn.minecraft_layer.net.minecraft.inventory;

import mtn.minecraft_layer.net.minecraft.entity.player.EntityPlayer;
import mtn.minecraft_layer.net.minecraft.item.ItemStack;

/**
 * Dummy stand-in for {@code net.minecraft.inventory.Container}
 * (Forge 1.7.10). Holds slots; interaction/staging logic is a stub for
 * R2 (real slot sync belongs with the GUI round).
 */
public abstract class Container {
    protected final java.util.List<Slot> inventorySlots = new java.util.ArrayList<>();

    public Slot addSlotToContainer(Slot slot) {
        inventorySlots.add(slot);
        return slot;
    }

    public void onContainerClosed(EntityPlayer player) {
    }

    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }

    public ItemStack transferStackInSlot(EntityPlayer player, int index) {
        return null;
    }

    public void detectAndSendChanges() {
    }

    public java.util.List<Slot> getInventorySlots() {
        return inventorySlots;
    }

    /**
     * Forge 1.7.10: try to merge a stack into slots {@code [start, end)}.
     * Stub — always reports "nothing moved".
     */
    public boolean mergeItemStack(ItemStack stack, int start, int end, boolean reversed) {
        // TODO(mtn-layer): real shift-click merge across the slot range.
        return false;
    }

    /**
     * Forge 1.7.10: comparator signal strength from an {@link IInventory}.
     */
    public static int calcRedstoneFromInventory(IInventory inventory) {
        // TODO(mtn-layer): count filled slots / stack-size ratios.
        return 0;
    }
}
