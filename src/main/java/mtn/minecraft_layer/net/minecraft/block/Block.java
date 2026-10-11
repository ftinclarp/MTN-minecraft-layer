package mtn.minecraft_layer.net.minecraft.block;

import mtn.minecraft_layer.net.minecraft.entity.player.EntityPlayer;
import mtn.minecraft_layer.net.minecraft.world.World;

/**
 * Dummy stand-in for {@code net.minecraft.block.Block} (Forge 1.7.10).
 * No real registration — only exists so ported mod code compiles.
 */
public class Block {
    private final String name;

    public Block(String name) {
        this.name = name;
    }

    public String getUnlocalizedName() {
        return name;
    }

    /**
     * Called when a player right-clicks this block. Forge 1.7.10 signature.
     * Default returns false (no interaction). Subclasses override.
     */
    public boolean onBlockActivated(World world, int x, int y, int z,
            EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        return false;
    }
}
