package mtn.minecraft_layer.net.minecraft.client.renderer.tileentity;

import mtn.minecraft_layer.net.minecraft.tileentity.TileEntity;
import mtn.minecraft_layer.net.minecraft.util.ResourceLocation;

/**
 * Stand-in for {@code net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer}
 * (Forge 1.7.10) — base class of per-tile-entity renderers. The Fabric
 * {@code ForgeTESRBridge} in the forge layer is what actually invokes
 * {@link #renderTileEntityAt} from a real {@code BlockEntityRenderer}.
 */
public abstract class TileEntitySpecialRenderer<T extends TileEntity> {

    /**
     * The dispatcher (1.7.10 SRG name kept for the IronChest port, which reads
     * {@code this.field_147501_a.field_147560_j} etc. for the render origin).
     */
    public TileEntityRendererDispatcher field_147501_a;

    /**
     * The current {@code PoseStack} installed by the forge-layer
     * {@code ForgeTESRBridge} before it calls {@link #renderTileEntityAt}.
     * The MTN-lwjgl transformer rewrites the mod's GL11
     * ({@code glPushMatrix/glTranslatef/glRotatef/scalef}) to
     * {@code matrices.pushPose()/translate()/mulPose()/scale()}, which resolve
     * to this field on the ported renderer's base class. This keeps the mod's
     * code unchanged — the field lives in the layer.
     */
    public com.mojang.blaze3d.vertex.PoseStack matrices;

    /** Render this tile entity at the given block-relative coordinates. */
    public abstract void renderTileEntityAt(T te, double x, double y, double z,
                                            float partialTicks);

    /** Forge 1.7.10: bind a texture for the following render calls. */
    protected void bindTexture(ResourceLocation location) {
        if (field_147501_a != null) {
            field_147501_a.bindTexture(location);
        }
    }

    /** Forge 1.7.10: bind texture (ResourceLocation overload). */
    protected void bindTexture(ResourceLocation location, TileEntity te) {
        bindTexture(location);
    }
}
