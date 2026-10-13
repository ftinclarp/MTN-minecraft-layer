package mtn.minecraft_layer.net.minecraft.entity.passive;

import mtn.minecraft_layer.net.minecraft.entity.EntityLivingBase;
import mtn.minecraft_layer.net.minecraft.entity.ai.EntityAITasks;

/**
 * Dummy stand-in for {@code net.minecraft.entity.passive.EntityOcelot}
 * (Forge 1.7.10). Minimal — enough for IronChest's gradle-based AI tasks
 * to compile.
 */
public class EntityOcelot extends EntityLivingBase {

    // Real MC version has `tasks` on EntityLivingBase; exposed here for the
    // ocelot handler that walks taskEntries.
    public EntityAITasks tasks;

    public EntityOcelot() {
    }
}
