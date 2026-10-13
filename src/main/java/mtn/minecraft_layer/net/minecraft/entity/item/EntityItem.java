package mtn.minecraft_layer.net.minecraft.entity.item;

import mtn.minecraft_layer.net.minecraft.entity.Entity;
import mtn.minecraft_layer.net.minecraft.item.ItemStack;
import mtn.minecraft_layer.net.minecraft.world.World;

/**
 * Dummy stand-in for {@code net.minecraft.entity.item.EntityItem}
 * (Forge 1.7.10). Carries an {@link ItemStack} on the ground.
 */
public class EntityItem extends Entity {

    private ItemStack itemStack;

    // TODO(mtn-layer): spawn the item entity into the world with no motion;
    //   used by the single-arg path in the chest renderer.
    public EntityItem(World world) {
        this(world, 0.0D, 0.0D, 0.0D, null);
    }

    // TODO(mtn-layer): spawn a real item entity in the world at the given
    //   position with the given stack.
    public EntityItem(World world, double x, double y, double z, ItemStack stack) {
        this.posX = x;
        this.posY = y;
        this.posZ = z;
        this.itemStack = stack;
    }

    public ItemStack getEntityItem() {
        return this.itemStack;
    }
}
