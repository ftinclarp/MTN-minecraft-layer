package mtn.minecraft_layer.net.minecraft.client.gui.inventory;

import mtn.minecraft_layer.net.minecraft.entity.player.InventoryPlayer;
import mtn.minecraft_layer.net.minecraft.inventory.IInventory;

/**
 * Dummy stand-in for {@code net.minecraft.client.gui.inventory.GuiChest}
 * (Forge 1.7.10). Exists only so the rewritten example compiles; the forge
 * layer ignores it and opens a Fabric screen directly.
 */
public class GuiChest {
    public GuiChest(InventoryPlayer playerInv, IInventory chestInv) {
    }

    public GuiChest(IInventory playerInv, IInventory chestInv, boolean par) {
    }
}
