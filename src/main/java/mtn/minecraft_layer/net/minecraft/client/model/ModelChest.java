package mtn.minecraft_layer.net.minecraft.client.model;

/**
 * Bridge for {@code net.minecraft.client.model.ModelChest} (Forge 1.7.10) — the
 * vanilla chest geometry used by the ported IronChest TESR.
 *
 * <p>The geometry reproduces the 1.7.10 chest: a lid (rotated by the mod via
 * {@code rotateAngleX}), the box below it and the knob. {@link #renderAll()}
 * delegates to each part's {@link ModelRenderer} bridge, which emits real quads
 * through the active Fabric render context.
 */
public class ModelChest extends ModelBase {

    public ModelRenderer chestLid;
    public ModelRenderer chestBelow;
    public ModelRenderer chestKnob;
    public ModelRenderer chestLid2;

    public ModelChest() {
        this.textureWidth = 64;
        this.textureHeight = 64;

        chestLid = new ModelRenderer("chest-lid");
        chestLid.setTextureSize(64, 64);
        chestLid.setTextureOffset(0, 0);
        chestLid.addBox(0.0F, -5.0F, -14.0F, 14, 5, 14, 0.0F);
        chestLid.setRotationPoint(1.0F, 7.0F, 15.0F);

        chestBelow = new ModelRenderer("chest-below");
        chestBelow.setTextureSize(64, 64);
        chestBelow.setTextureOffset(0, 19);
        chestBelow.addBox(0.0F, 0.0F, 0.0F, 14, 10, 14, 0.0F);
        chestBelow.setRotationPoint(1.0F, 6.0F, 1.0F);

        chestKnob = new ModelRenderer("chest-knob");
        chestKnob.setTextureSize(64, 64);
        chestKnob.setTextureOffset(14, 0);
        chestKnob.addBox(-1.0F, -2.0F, -15.0F, 2, 4, 1, 0.0F);
        chestKnob.setRotationPoint(8.0F, 7.0F, 15.0F);

        // Not part of the classic vanilla model; kept for structural parity with
        // older layer scaffolding.
        chestLid2 = null;
    }

    @Override
    public void renderAll() {
        float scale = 0.0625F;
        chestBelow.render(scale);
        chestLid.render(scale);
        chestKnob.render(scale);
    }
}
