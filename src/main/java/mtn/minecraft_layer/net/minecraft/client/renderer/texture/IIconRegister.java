package mtn.minecraft_layer.net.minecraft.client.renderer.texture;

import mtn.minecraft_layer.net.minecraft.util.IIcon;

/**
 * Dummy stand-in for {@code net.minecraft.client.renderer.texture.IIconRegister}
 * (Forge 1.7.10). Registers an icon by name and hands back an {@link IIcon}.
 */
public interface IIconRegister {
    IIcon registerIcon(String name);
}
