package mtn.minecraft_layer.net.minecraft.util;

/**
 * Dummy stand-in for {@code net.minecraft.util.StatCollector} (Forge 1.7.10).
 * Returns the localization key as-is.
 */
public final class StatCollector {
    private StatCollector() {
    }

    public static String translateToLocal(String key) {
        return key;
    }

    public static String translateToLocalFormatted(String key, Object... args) {
        return key;
    }
}
