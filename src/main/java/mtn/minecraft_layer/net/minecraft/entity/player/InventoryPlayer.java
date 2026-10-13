package mtn.minecraft_layer.net.minecraft.entity.player;

import mtn.minecraft_layer.net.minecraft.inventory.IInventory;
import mtn.minecraft_layer.net.minecraft.item.ItemStack;

/**
 * Dummy stand-in for {@code net.minecraft.entity.player.InventoryPlayer}
 * (Forge 1.7.10). Implements {@link IInventory} so ported containers can pass
 * {@code player.inventory} to container constructors. Holds 36 slots (27 main
 * + 9 hotbar) with a fixed stack limit of 64; item contents are stubs.
 */
public class InventoryPlayer implements IInventory {

    private final ItemStack[] stacks = new ItemStack[36];

    /** Forge 1.7.10: owning player (used by ContainerIronChest). */
    public EntityPlayer player;

    @Override
    public int getSizeInventory() {
        return stacks.length;
    }

    @Override
    public ItemStack getStackInSlot(int i) {
        if (i < 0 || i >= stacks.length) {
            return null;
        }
        return stacks[i];
    }

    @Override
    public ItemStack decrStackSize(int i, int count) {
        if (i < 0 || i >= stacks.length || stacks[i] == null) {
            return null;
        }
        ItemStack stack = stacks[i];
        stacks[i] = null;
        return stack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int i) {
        if (i < 0 || i >= stacks.length || stacks[i] == null) {
            return null;
        }
        ItemStack stack = stacks[i];
        stacks[i] = null;
        return stack;
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack stack) {
        if (i >= 0 && i < stacks.length) {
            stacks[i] = stack;
        }
    }

    @Override
    public String getInventoryName() {
        return "container.inventory";
    }

    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public void markDirty() {
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return true;
    }

    @Override
    public void openInventory() {
    }

    @Override
    public void closeInventory() {
    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack stack) {
        return true;
    }
}
