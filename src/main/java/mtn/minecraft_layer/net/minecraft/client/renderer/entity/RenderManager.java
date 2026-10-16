package mtn.minecraft_layer.net.minecraft.client.renderer.entity;

/**
 * Stand-in for {@code net.minecraft.client.renderer.entity.RenderManager}
 * (Forge 1.7.10). Singleton facade; IronChest reads
 * {@code RenderManager.instance} to hand to {@link RenderItem#setRenderManager}.
 */
public class RenderManager {

    public static final RenderManager instance = new RenderManager();

    public RenderManager() {
    }
}
