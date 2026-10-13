package mtn.minecraft_layer.net.minecraft.entity;

/**
 * Dummy stand-in for {@code net.minecraft.entity.Entity} (Forge 1.7.10).
 * Base class carrying the common transform/position fields the Iron Chest
 * code touches. No real physics — straight stub.
 */
public abstract class Entity {
    public double posX;
    public double posY;
    public double posZ;
    public double motionX;
    public double motionY;
    public double motionZ;
    public float rotationYaw;
    public float rotationPitch;
    public int ticksExisted;

    public Entity() {
    }

    // TODO(mtn-layer): keep entity in the Fabric world's entity storage and
    //   tick it; for now every "dummy" Entity stays inert.
    public void onUpdate() {
    }

    // TODO(mtn-layer): return the real axis-aligned bounding box of this
    //   entity; placeholder returns at origin.
    public mtn.minecraft_layer.net.minecraft.util.AxisAlignedBB getBoundingBox() {
        return mtn.minecraft_layer.net.minecraft.util.AxisAlignedBB
                .getBoundingBox(posX, posY, posZ, posX, posY, posZ);
    }

    // TODO(mtn-layer): write real entity NBT data.
    public void writeToNBT(mtn.minecraft_layer.net.minecraft.nbt.NBTTagCompound nbt) {
    }

    // TODO(mtn-layer): read real entity NBT data.
    public void readFromNBT(mtn.minecraft_layer.net.minecraft.nbt.NBTTagCompound nbt) {
    }
}
