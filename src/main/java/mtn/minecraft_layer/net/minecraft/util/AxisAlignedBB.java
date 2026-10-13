package mtn.minecraft_layer.net.minecraft.util;

/**
 * Dummy stand-in for {@code net.minecraft.util.AxisAlignedBB} (Forge 1.7.10).
 * Minimal axis-aligned bounding box with real but trivial math. Enough for
 * Iron Chest's player-detection AABB logic to compile.
 */
public class AxisAlignedBB {
    public double minX;
    public double minY;
    public double minZ;
    public double maxX;
    public double maxY;
    public double maxZ;

    private AxisAlignedBB(double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        this.minX = minX;
        this.minY = minY;
        this.minZ = minZ;
        this.maxX = maxX;
        this.maxY = maxY;
        this.maxZ = maxZ;
    }

    public static AxisAlignedBB getBoundingBox(double minX, double minY, double minZ,
                                                double maxX, double maxY, double maxZ) {
        return new AxisAlignedBB(minX, minY, minZ, maxX, maxY, maxZ);
    }

    /**
     * Expands the box `by` on every axis, mutating and returning {@code this}
     * (fluent). This is a deliberate no-op-math-free choice for the layer: it
     * only needs to compile.
     */
    public AxisAlignedBB expand(double by) {
        this.minX -= by;
        this.minY -= by;
        this.minZ -= by;
        this.maxX += by;
        this.maxY += by;
        this.maxZ += by;
        return this;
    }

    public AxisAlignedBB addCoord(double ox, double oy, double oz) {
        return new AxisAlignedBB(
                Math.min(minX, minX + ox), Math.min(minY, minY + oy), Math.min(minZ, minZ + oz),
                Math.max(maxX, maxX + ox), Math.max(maxY, maxY + oy), Math.max(maxZ, maxZ + oz));
    }

    public AxisAlignedBB offset(double ox, double oy, double oz) {
        return new AxisAlignedBB(minX + ox, minY + oy, minZ + oz, maxX + ox, maxY + oy, maxZ + oz);
    }
}
