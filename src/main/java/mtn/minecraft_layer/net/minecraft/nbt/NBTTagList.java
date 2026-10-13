package mtn.minecraft_layer.net.minecraft.nbt;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy stand-in for {@code net.minecraft.nbt.NBTTagList} (Forge 1.7.10).
 * In-memory list-backed; enough to compile and exercise ported mod code.
 */
public class NBTTagList implements NBTBase {
    private final List<Object> list = new ArrayList<>();

    /** Forge 1.7.10: accepts any NBT tag (broadened from NBTTagCompound). */
    public void appendTag(NBTBase tag) {
        list.add(tag);
    }

    public int tagCount() {
        return list.size();
    }

    public NBTTagCompound getCompoundTagAt(int i) {
        Object v = list.get(i);
        return v instanceof NBTTagCompound ? (NBTTagCompound) v : new NBTTagCompound();
    }
}
