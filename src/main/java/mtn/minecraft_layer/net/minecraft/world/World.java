package mtn.minecraft_layer.net.minecraft.world;

import mtn.minecraft_layer.net.minecraft.block.Block;
import mtn.minecraft_layer.net.minecraft.entity.Entity;
import mtn.minecraft_layer.net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import mtn.minecraft_layer.net.minecraft.util.AxisAlignedBB;

import java.util.List;
import java.util.Random;

/**
 * Dummy stand-in for {@code net.minecraft.world.World} (Forge 1.7.10).
 * Minimal — enough for TileEntity/entity dummy code to compile.
 */
public class World {
    public boolean isRemote;
    public Random rand = new Random();

    public int getBlockMetadata(int x, int y, int z) {
        return 0;
    }

    public TileEntity getTileEntity(int x, int y, int z) {
        return null;
    }

    public boolean setBlockMetadataWithNotify(int x, int y, int z, int meta, int flags) {
        return false;
    }

    public void markBlockForUpdate(int x, int y, int z) {
    }

    public void markTileEntityChunkModified(int x, int y, int z, TileEntity te) {
    }

    // ---------------- Batch 3 additions ----------------

    public boolean setBlock(int x, int y, int z, Block block) {
        // TODO(mtn-layer): place the block (meta 0, flags 3).
        return false;
    }

    public boolean setBlock(int x, int y, int z, Block block, int meta, int flags) {
        // TODO(mtn-layer): place the block with meta+flags, notify neighbours.
        return false;
    }

    public void setTileEntity(int x, int y, int z, TileEntity te) {
        // TODO(mtn-layer): attach the tile entity to the block entity manager.
    }

    public boolean addBlockEvent(int x, int y, int z, Block block, int eventId, int eventParam) {
        // TODO(mtn-layer): enqueue a block event for the tick loop.
        return false;
    }

    public boolean isSideSolid(int x, int y, int z, ForgeDirection side) {
        // TODO(mtn-layer): whether the given face is solid.
        return false;
    }

    public void playSoundEffect(double x, double y, double z, String sound, float volume, float pitch) {
        // TODO(mtn-layer): play the sound event.
    }

    public void spawnEntityInWorld(Entity entity) {
        // TODO(mtn-layer): add the entity to the world.
    }

    public List getEntitiesWithinAABB(Class entityClass, AxisAlignedBB aabb) {
        // TODO(mtn-layer): query entities intersecting the box.
        return java.util.Collections.EMPTY_LIST;
    }
}
