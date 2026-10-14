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

    /** Forge 1.7.10: block metadata at this position. */
    public int getBlockMetadata() {
        // TODO(mtn-layer): return world.getBlockMetadata(x, y, z).
        return 0;
    }

    /** Forge 1.7.10: handle a block event packet from the server. */
    public boolean receiveClientEvent(int eventId, int eventParam) {
        // TODO(mtn-layer): apply the event payload to the tile entity.
        return false;
    }

    /**
     * Forge 1.7.10: returns the packet sent to the client when this tile entity
     * is created/re-synced, or null for no custom description packet. Mods override
     * this (e.g. IronChest generates a network message via its channel). The layer
     * itself ships the wire-tagged update through the Fabric bridge.
     */
    public mtn.minecraft_layer.net.minecraft.network.Packet getDescriptionPacket() {
        return null;
    }
}
