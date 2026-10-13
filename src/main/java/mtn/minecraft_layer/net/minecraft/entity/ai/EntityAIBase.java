package mtn.minecraft_layer.net.minecraft.entity.ai;

/**
 * Dummy stand-in for {@code net.minecraft.entity.ai.EntityAIBase}
 * (Forge 1.7.10). Base class for all AI tasks.
 */
public abstract class EntityAIBase {

    // TODO(mtn-layer): schedule actual AI ticking once entities exist on the
    //   Fabric side.
    public boolean continueExecuting() {
        return false;
    }
}
