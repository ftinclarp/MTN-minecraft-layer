package mtn.minecraft_layer.net.minecraft.nbt;

/**
 * Dummy stand-in for {@code net.minecraft.nbt.NBTTagString} (Forge 1.7.10).
 * Trivial string wrapper — enough to compile typical {@code new NBTTagString(...)}.
 */
public class NBTTagString implements NBTBase {
    private final String value;

    public NBTTagString(String value) {
        this.value = value;
    }

    public String getString() {
        return value;
    }

    @Override
    public String toString() {
        return "NBTTagString(\"" + value + "\")";
    }
}
