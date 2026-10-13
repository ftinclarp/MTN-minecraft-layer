package mtn.minecraft_layer.net.minecraft.init;

import mtn.minecraft_layer.net.minecraft.block.Block;
import mtn.minecraft_layer.net.minecraft.block.material.Material;

/**
 * Dummy stand-in for {@code net.minecraft.init.Blocks} (Forge 1.7.10).
 * A handful of named block constants backed by the dummy {@link Block};
 * enough to compile typical {@code Blocks.X} references.
 */
public class Blocks {
    public static final Block air = new Block(Material.air);
    public static final Block stone = new Block(Material.rock);
    public static final Block dirt = new Block(Material.ground);
    public static final Block glass = new Block(Material.glass);
    public static final Block obsidian = new Block(Material.rock);
    public static final Block chest = new Block(Material.wood);
}
