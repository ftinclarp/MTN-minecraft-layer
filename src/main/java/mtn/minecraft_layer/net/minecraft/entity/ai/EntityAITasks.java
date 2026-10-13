package mtn.minecraft_layer.net.minecraft.entity.ai;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy stand-in for {@code net.minecraft.entity.ai.EntityAITasks}
 * (Forge 1.7.10). Holds a task list that IronChest walks and mutates.
 */
public class EntityAITasks {

    public List<EntityAITaskEntry> taskEntries = new ArrayList<EntityAITaskEntry>();

    /**
     * Dummy stand-in for {@code EntityAITasks.EntityAITaskEntry}.
     * Mutable so IronChest can swap in its own AI task.
     */
    public static class EntityAITaskEntry {
        public int priority;
        public EntityAIBase action;

        public EntityAITaskEntry() {
        }
    }
}
