package mtn.minecraft_layer.net.minecraft.client.renderer.texture;

import mtn.minecraft_layer.net.minecraft.util.ResourceLocation;

/**
 * Stand-in for {@code net.minecraft.client.renderer.texture.TextureManager}
 * (Forge 1.7.10) — binds {@link ResourceLocation} textures for rendering.
 * Wired to the Fabric client's native texture manager when available.
 */
public class TextureManager {

    public static final TextureManager INSTANCE = new TextureManager();

    public void bindTexture(ResourceLocation location) {
        // TODO(mtn-layer): bind via the Fabric client's RenderSystem texture
        //  location for the given path.
    }

    public void bindTexture(String path) {
        bindTexture(new ResourceLocation(path));
    }

    /** Forge 1.7.10 alias of bindTexture. */
    public void bind(ResourceLocation location) {
        bindTexture(location);
    }
}
