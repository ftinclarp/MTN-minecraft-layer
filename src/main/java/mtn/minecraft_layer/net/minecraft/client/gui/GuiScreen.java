package mtn.minecraft_layer.net.minecraft.client.gui;

import mtn.minecraft_layer.net.minecraft.client.Minecraft;

/**
 * Stand-in for {@code net.minecraft.client.gui.GuiScreen} (Forge 1.7.10).
 * Compatibility shim: real screen drawing on Fabric is done by a
 * {@code HandledScreen} adapter (forge layer) that wraps a ported
 * {@code GuiContainer}. Holds the minimal fields IronChest's GUIChest reads.
 */
public class GuiScreen {

    public Minecraft mc;
    public int width = 320;
    public int height = 240;
    public boolean allowUserInput = false;

    /** Forge 1.7.10: bind texture + draw an axis-aligned 9-slice quad. */
    public void drawTexturedModalRect(int x, int y, int u, int v, int width, int height) {
        // TODO(mtn-layer): real GUI surface drawing through the Fabric renderer.
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
    }

    public void initGui() {
    }
}
