package mtn.minecraft_layer.net.minecraft.client.model;

import mtn.minecraft_layer.net.minecraft.entity.Entity;

/**
 * Stand-in for {@code net.minecraft.client.model.ModelBase} (Forge 1.7.10).
 * Base class of all entity/block models. Renders are a no-op by default; real
 * drawing is expected to be wired through the Fabric render context
 * (see {@code ForgeTESRBridge} in the forge layer).
 */
public abstract class ModelBase {

    /** Texture dimensions, used to map model UVs onto the sheet. */
    public float textureWidth = 64.0F;
    public float textureHeight = 32.0F;

    public java.util.List<ModelRenderer> boxList = new java.util.ArrayList<>();

    /** Forge 1.7.10: default model render (subclasses override). */
    public void render(float scale, float yaw, float pitch, float headYaw, float headPitch, float tick) {
        // TODO(mtn-layer): real geometry/pose handling belongs in the
        //  Fabric ModelPart bridge. Subclasses override this.
    }

    public void renderAll() {
    }

    /** Forge 1.7.10: entity model render entry point. */
    public void render(Entity entity, float x, float y, float z, float yaw, float pitch) {
        this.render(x, y, z, yaw, pitch, 0.0F);
    }
}
