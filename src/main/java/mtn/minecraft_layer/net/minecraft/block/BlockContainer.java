package mtn.minecraft_layer.net.minecraft.block;

import mtn.minecraft_layer.net.minecraft.entity.player.EntityPlayer;
import mtn.minecraft_layer.net.minecraft.tileentity.TileEntity;
import mtn.minecraft_layer.net.minecraft.world.World;

/**
 * Dummy stand-in for {@code net.minecraft.block.BlockContainer}
 * (Forge 1.7.10). Base class for blocks that hold a TileEntity.
 */
public abstract class BlockContainer extends Block {

    protected BlockContainer(String name) {
        super(name);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z,
            EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        // Default: no-op. Subclasses override.
        return false;
    }

    /** Forge 1.7.10 contract: subclasses create their tile entity here. */
    public TileEntity createNewTileEntity(World world, int meta) {
        return null;
    }
}
