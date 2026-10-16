package mtn.minecraft_layer.net.minecraft.client.model;

/**
 * Stand-in for {@code net.minecraft.client.model.ModelChest} (Forge 1.7.10) — the
 * vanilla chest geometry: a lid, the box below it and the knob. The model parts are
 * {@link ModelRenderer} data holders; actual drawing goes through the Fabric
 * ModelPart bridge (forge layer) which reads these parts' rotation state.
 */
public class ModelChest extends ModelBase {

    public ModelRenderer chestLid;
    public ModelRenderer chestBelow;
    public ModelRenderer chestKnob;
    public ModelRenderer chestLid2;

    public ModelChest() {
        // The vanilla chest box layout (model-space, mirror of the 1.7.10
        // ModelChest). Coordinates here are the classic chest proportions.
        chestLid = buildPart(0, 0, 7, 0, 7);   // lid plate
        chestLid.setRotationPoint(0, 5, 1);
        chestBelow = buildPart(1, 7, 0, 7);     // body
        chestBelow.setRotationPoint(1, 7, 1);
        chestKnob = buildPart(7, 0, 7, 3, 3, 3); // knob
    }

    private ModelRenderer buildPart(float... in) {
        return new ModelRenderer("chest-part");
    }

    @Override
    public void renderAll() {
        // TODO(mtn-layer): the forge-layer ForgeTESRBridge renders this model
        //  through the Fabric ModelPart pipeline, bypassing ModelRenderer.
        //  This hook is where the lid rotation (rotateAngleX) is applied.
    }
}
