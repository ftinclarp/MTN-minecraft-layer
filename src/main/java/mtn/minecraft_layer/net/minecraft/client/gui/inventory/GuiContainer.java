package mtn.minecraft_layer.net.minecraft.client.gui.inventory;

import mtn.minecraft_layer.net.minecraft.client.gui.GuiScreen;
import mtn.minecraft_layer.net.minecraft.inventory.Container;

/**
 * Stand-in for {@code net.minecraft.client.gui.inventory.GuiContainer}
 * (Forge 1.7.10). Compatibility shim: the real Fabric GUI is a HandledScreen
 * adapter (forge layer) that wraps a ported GUIChest; this class provides the
 * Forge-1.7.10 surface IronChest's GUIChest extends (xSize/ySize/background
 * hook).
 */
public abstract class GuiContainer extends GuiScreen {

    public int xSize = 176;
    public int ySize = 166;

    public Container inventorySlots;

    public GuiContainer(Container inventorySlots) {
        this.inventorySlots = inventorySlots;
    }

    /** If the container lives on the client. */
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
    }

    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
    }
}
