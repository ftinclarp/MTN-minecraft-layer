package mtn.minecraft_layer.net.minecraft.entity.player;

/**
 * Dummy stand-in for {@code net.minecraft.entity.player.EntityPlayer}
 * (Forge 1.7.10). Minimal — enough to satisfy {@code IInventory}
 * method signatures.
 */
public class EntityPlayer {
    public mtn.minecraft_layer.net.minecraft.world.World worldObj;
    public mtn.minecraft_layer.net.minecraft.entity.player.InventoryPlayer inventory;

    public String getCommandSenderName() {
        return "Player";
    }

    public void addChatMessage(String msg) {
    }

    /** Forge 1.7.10 network GUI entry; the forge layer pokes this to open a screen. */
    public void openGui(Object mod, int modGuiId,
            mtn.minecraft_layer.net.minecraft.world.World world,
            int x, int y, int z) {
    }
}
