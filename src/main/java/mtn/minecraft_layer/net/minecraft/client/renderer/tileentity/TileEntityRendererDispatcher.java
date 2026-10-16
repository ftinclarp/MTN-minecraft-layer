package mtn.minecraft_layer.net.minecraft.client.renderer.tileentity;

import java.util.HashMap;
import java.util.Map;
import mtn.minecraft_layer.net.minecraft.tileentity.TileEntity;
import mtn.minecraft_layer.net.minecraft.util.ResourceLocation;
import mtn.minecraft_layer.net.minecraft.world.World;

/**
 * Stand-in for {@code net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher}
 * (Forge 1.7.10) — holds the registered per-class renderers and the world
 * render origin the ported IronChest renderer reads through
 * {@code field_147501_a.field_147560_j} etc.
 */
public class TileEntityRendererDispatcher {

    public static final TileEntityRendererDispatcher instance =
            new TileEntityRendererDispatcher();

    /** Render origin (world coords) — read by IronChest via SRG names. */
    public double field_147560_j;
    public double field_147561_k;
    public double field_147558_l;
    /** Client world — read by the ported renderer for entity context. */
    public World field_147550_f;

    private final Map<Class<? extends TileEntity>, TileEntitySpecialRenderer<?>> renderers =
            new HashMap<>();

    public TileEntityRendererDispatcher() {
        field_147560_j = 0.0D;
        field_147561_k = 0.0D;
        field_147558_l = 0.0D;
        field_147550_f = new World();
        // TODO(mtn-layer): populating field_147550_f from the Fabric client
        //  world happens in the forge-layer ForgeTESRBridge during render.
    }

    public void bindTileEntitySpecialRenderer(Class<? extends TileEntity> clazz,
                                              TileEntitySpecialRenderer<?> renderer) {
        renderers.put(clazz, renderer);
        renderer.field_147501_a = this;
    }

    public TileEntitySpecialRenderer<?> getSpecialRenderer(Class<? extends TileEntity> clazz) {
        return renderers.get(clazz);
    }

    /** Forge 1.7.10: render the tile entity at block-relative coordinates. */
    public void renderTileEntityAt(TileEntity te, double x, double y, double z,
                                   float partialTicks) {
        TileEntitySpecialRenderer renderer = renderers.get(te.getClass());
        if (renderer != null) {
            renderer.renderTileEntityAt(te, x, y, z, partialTicks);
        }
    }

    public void bindTexture(ResourceLocation location) {
        // TODO(mtn-layer): bind via the Fabric client's RenderSystem for the path.
    }
}
