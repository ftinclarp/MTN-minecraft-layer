package mtn.minecraft_layer.net.minecraft.util;

/**
 * Dummy stand-in for {@code net.minecraft.util.MathHelper} (Forge 1.7.10).
 * Trivial math helpers; real implementations of floor/ceil/sqrt/clamp.
 */
public final class MathHelper {
    private MathHelper() {
    }

    public static int floor_double(double value) {
        return (int) Math.floor(value);
    }

    public static int ceil_double(double value) {
        return (int) Math.ceil(value);
    }

    public static float sqrt_float(float value) {
        return (float) Math.sqrt(value);
    }

    public static double sqrt_double(double value) {
        return Math.sqrt(value);
    }

    public static int clamp_int(int value, int min, int max) {
        return Math.max(min, Math.min(max, value));
    }

    public static float clamp_float(float value, float min, float max) {
        return Math.max(min, Math.min(max, value));
    }

    public static float sin(float value) {
        return (float) Math.sin(value);
    }

    public static float cos(float value) {
        return (float) Math.cos(value);
    }

    /** The method in 1.7.x that obfuscation-aware code uses (rotationYaw etc.). */
    public static float wrapAngleToEFLoat(float value) {
        return value;
    }

    public static int parseIntWithDefault(String text, int fallback) {
        return fallback;
    }
}
