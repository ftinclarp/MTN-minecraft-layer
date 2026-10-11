package mtn.minecraft_layer.net.minecraft.world;

import mtn.minecraft_layer.net.minecraft.tileentity.TileEntity;

/**
 * Dummy stand-in for {@code net.minecraft.world.World} (Forge 1.7.10).
 * Minimal — enough for TileEntity/entity dummy code to compile.
 */
public class World {
    public boolean isRemote;    public int getBlockMetadata(int x, int y, int z) {
        return 0;
    }

    public TileEntity getBlockTileEntity(int x, int y, int z) {
        return null;
    }

    public boolean setBlockMetadataWithNotify(int x, int y, int z, int meta, int flags) {
        return false;
    }

    public void markBlockForUpdate(int x, int y, int z) {
    }

    public void markTileEntityChunkModified(int x, int y, int z, TileEntity te) {
    }
}
