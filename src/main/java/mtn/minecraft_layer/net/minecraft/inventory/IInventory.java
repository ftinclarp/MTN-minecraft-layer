package mtn.minecraft_layer.net.minecraft.inventory;

import mtn.minecraft_layer.net.minecraft.entity.player.EntityPlayer;
import mtn.minecraft_layer.net.minecraft.item.ItemStack;

/**
 * Dummy stand-in for {@code net.minecraft.inventory.IInventory}
 * (Forge 1.7.10). Ported mod code implements this; the registry's
 * {@code FabricInventoryAdapter} bridges it to a vanilla
 * {@code net.minecraft.world.Container}.
 */
public interface IInventory {
    int getSizeInventory();

    ItemStack getStackInSlot(int i);

    ItemStack decrStackSize(int i, int count);

    ItemStack getStackInSlotOnClosing(int i);

    void setInventorySlotContents(int i, ItemStack stack);

    String getInventoryName();

    boolean hasCustomInventoryName();

    int getInventoryStackLimit();

    void markDirty();

    boolean isUseableByPlayer(EntityPlayer player);

    void openInventory();

    void closeInventory();

    boolean isItemValidForSlot(int i, ItemStack stack);
}
