package mtn.minecraft_layer.net.minecraft.entity.ai;

import mtn.minecraft_layer.net.minecraft.entity.passive.EntityOcelot;

/**
 * Dummy stand-in for {@code net.minecraft.entity.ai.EntityAIOcelotSit}
 * (Forge 1.7.10). IronChest's {@code IronChestAIOcelotSit} extends this.
 */
public class EntityAIOcelotSit extends EntityAIBase {

    // TODO(mtn-layer): make the ocelot sit on the block if it is an iron
    //   chest; placeholder accepts any ocelot.
    public EntityAIOcelotSit(EntityOcelot ocelot, float speed) {
    }
}
