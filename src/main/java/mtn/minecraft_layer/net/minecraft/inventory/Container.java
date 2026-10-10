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

    protected Slot addSlotToContainer(Slot slot) {
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
}
