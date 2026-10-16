package mtn.minecraft_layer.net.minecraft.client;

import mtn.minecraft_layer.net.minecraft.client.renderer.texture.TextureManager;
import mtn.minecraft_layer.net.minecraft.world.World;

/**
 * Stand-in for {@code net.minecraft.client.Minecraft} (Forge 1.7.10) — the
 * client main-class facade. Thread across layers: the forge-layer
 * {@code FMLClientHandler} returns one of these to the ported mod, wiring
 * {@code theWorld} to the Fabric client's world so
 * {@code getClientWorld().theWorld} works.
 */
public class Minecraft {

    public World theWorld;
    private World world;

    private static final Minecraft INSTANCE = new Minecraft();

    public static Minecraft getMinecraft() {
        return INSTANCE;
    }

    public boolean isDedicatedServer() {
        return false;
    }

    public TextureManager getTextureManager() {
        return TextureManager.INSTANCE;
    }

    /** Forge 1.7.10: the client's current world (sideserver=null). */
    public World getTheWorld() {
        return theWorld;
    }

    public void setTheWorld(World world) {
        this.theWorld = world;
        this.world = world;
    }

    /** Forge 1.7.10: open a GUI screen managed by the ported GUIChest. */
    public void displayGuiScreen(Object gui) {
        // TODO(mtn-layer): wrap the ported Forge GuiContainer in a Fabric
        //  HandledScreen adapter so the chest GUI actually opens in-game.
    }
}
