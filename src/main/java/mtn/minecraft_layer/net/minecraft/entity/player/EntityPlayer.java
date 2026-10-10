package mtn.minecraft_layer.net.minecraft.entity.player;

/**
 * Dummy stand-in for {@code net.minecraft.entity.player.EntityPlayer}
 * (Forge 1.7.10). Minimal — enough to satisfy {@code IInventory}
 * method signatures.
 */
public class EntityPlayer {
    public mtn.minecraft_layer.net.minecraft.world.World worldObj;

    public String getCommandSenderName() {
        return "Player";
    }

    public void addChatMessage(String msg) {
    }
}
