package mtn.minecraft_layer.net.minecraft.client.renderer.texture;

import mtn.minecraft_layer.net.minecraft.client.Minecraft;
import mtn.minecraft_layer.net.minecraft.util.ResourceLocation;

/**
 * Stand-in for {@code net.minecraft.client.renderer.texture.TextureManager}
 * (Forge 1.7.10) — binds {@link ResourceLocation} textures for rendering.
 * Wired to the Fabric client's native texture manager when available.
 */
public class TextureManager {

    public static final TextureManager INSTANCE = new TextureManager();

    /** The texture the GUI draws next (the one last bound via {@link #bindTexture}). */
    private ResourceLocation bound;

    public void bindTexture(ResourceLocation location) {
        this.bound = location;
        // TODO(mtn-layer): bind via the Fabric client's RenderSystem texture
        //  location for the given path.
    }

    /** The last bound texture, for GUI drawing. */
    public ResourceLocation getBound() {
        return bound;
    }

    public void bindTexture(String path) {
        bindTexture(new ResourceLocation(path));
    }

    /** Forge 1.7.10 alias of bindTexture. */
    public void bind(ResourceLocation location) {
        bindTexture(location);
    }
}
