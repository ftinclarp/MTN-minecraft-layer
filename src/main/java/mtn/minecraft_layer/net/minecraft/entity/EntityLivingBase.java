package mtn.minecraft_layer.net.minecraft.entity;

/**
 * Dummy stand-in for {@code net.minecraft.entity.EntityLivingBase}
 * (Forge 1.7.10). Concrete stub so the mod's parameter types bind.
 */
public class EntityLivingBase extends Entity {
    public EntityLivingBase() {
    }

    // TODO(mtn-layer): real health/damage handling once entities exist on
    //   the Fabric side.
    public float getHealth() {
        return 0.0F;
    }

    // TODO(mtn-layer): real health/damage handling once entities exist on
    //   the Fabric side.
    public void setHealth(float health) {
    }

    // TODO(mtn-layer): check the entity is on the client side and not dead.
    public boolean isEntityAlive() {
        return true;
    }
}
