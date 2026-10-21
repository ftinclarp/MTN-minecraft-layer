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

    /** Forge 1.7.10: bind texture + draw an axis-aligned texture quad. */
    public void drawTexturedModalRect(int x, int y, int u, int v, int width, int height) {
        // Draw through the active Fabric GuiGraphics (installed by the
        // forge-layer GUI bridge before calling the ported draw method).
        Object active = mc == null ? null : mc.getActiveGuiGraphics();
        mtn.minecraft_layer.net.minecraft.client.renderer.texture.TextureManager tm =
                mc == null ? null : mc.getTextureManager();
        if (active instanceof net.minecraft.client.gui.GuiGraphics g
                && tm != null && tm.getBound() != null) {
            // Convert the layered ResourceLocation (domain/path) to a Mojang
            // ResourceLocation for the vanilla GuiGraphics.
            mtn.minecraft_layer.net.minecraft.util.ResourceLocation layered = tm.getBound();
            net.minecraft.resources.ResourceLocation loc =
                    net.minecraft.resources.ResourceLocation.fromNamespaceAndPath(
                            layered.getResourceDomain(), layered.getResourcePath());
            // GuiGraphics.blit(tex, x, y, u, v, w, h, texW, texH) — same contract
            // as the 1.7.10 drawTexturedModalRect.
            g.blit(loc, x, y, u, v, width, height, 256, 256);
        }
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
    }

    public void initGui() {
    }
}
