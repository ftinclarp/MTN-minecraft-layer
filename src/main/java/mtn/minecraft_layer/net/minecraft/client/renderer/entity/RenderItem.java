package mtn.minecraft_layer.net.minecraft.client.renderer.entity;

import mtn.minecraft_layer.net.minecraft.entity.item.EntityItem;
import mtn.minecraft_layer.net.minecraft.item.ItemStack;

/**
 * Stand-in for {@code net.minecraft.client.renderer.entity.RenderItem}
 * (Forge 1.7.10). IronChest subclasses it to tweak the mini item/block counts
 * and calls {@link #doRender} for the transparent-chest floating-items effect
 * (crystal chest — out of scope for v1). Kept as a real-signature stub; the
 * forge-layer bridge plugs into the Fabric item renderer when wired.
 */
public class RenderItem {

    public byte getMiniBlockCount(ItemStack stack, byte original) {
        return original;
    }

    public byte getMiniItemCount(ItemStack stack, byte original) {
        return original;
    }

    public boolean shouldBob() {
        return true;
    }

    public boolean shouldSpreadItems() {
        return true;
    }

    public void setRenderManager(RenderManager manager) {
        // TODO(mtn-layer): the bridge consults the facade manager.
    }

    /** IronChest: render an item entity (floating items in the crystal chest). */
    public void doRender(EntityItem entity, double x, double y, double z,
                         float yOffset, float partialTicks) {
        // TODO(mtn-layer): crystal-chest floating items are out of scope for v1;
        //  wire through the Fabric item renderer later.
    }
}
