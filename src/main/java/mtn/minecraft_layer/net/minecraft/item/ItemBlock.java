package mtn.minecraft_layer.net.minecraft.item;

import mtn.minecraft_layer.net.minecraft.block.Block;

/**
 * Dummy stand-in for {@code net.minecraft.item.ItemBlock} (Forge 1.7.10).
 * Used by {@code GameRegistry.registerBlock(Block, Class<? extends ItemBlock>, String)}.
 */
public class ItemBlock extends Item {
    protected final Block block;

    public ItemBlock(Block block) {
        this.block = block;
    }

    public Block getBlock() {
        return block;
    }
}
