package mtn.minecraft_layer.net.minecraft.inventory;

import mtn.minecraft_layer.net.minecraft.item.ItemStack;

/**
 * Dummy stand-in for {@code net.minecraft.inventory.ISidedInventory}
 * (Forge 1.7.10). Extends {@link IInventory} with per-side access.
 */
public interface ISidedInventory extends IInventory {
    int[] getAccessibleSlotsFromSide(int side);

    boolean canInsertItem(int i, ItemStack stack, int side);

    boolean canExtractItem(int i, ItemStack stack, int side);
}
