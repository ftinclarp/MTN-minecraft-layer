package mtn.minecraft_layer.net.minecraft.tileentity;

import mtn.minecraft_layer.net.minecraft.block.Block;
import mtn.minecraft_layer.net.minecraft.nbt.NBTTagCompound;

/**
 * Dummy stand-in for {@code net.minecraft.tileentity.TileEntity}
 * (Forge 1.7.10). Holds world/coord state and forwards NBT read/write.
 * Real Fabric side is handled by the registry's
 * {@code FabricBlockEntityAdapter}.
 */
public class TileEntity {
    public mtn.minecraft_layer.net.minecraft.world.World worldObj;
    public int xCoord;
    public int yCoord;
    public int zCoord;

    public void updateEntity() {
    }

    public void readFromNBT(NBTTagCompound nbt) {
    }

    public void writeToNBT(NBTTagCompound nbt) {
    }

    public boolean canUpdate() {
        return true;
    }

    public void invalidate() {
    }

    public void onChunkUnload() {
    }

    public void markDirty() {
    }

    public Block getBlockType() {
        return null;
    }
}
