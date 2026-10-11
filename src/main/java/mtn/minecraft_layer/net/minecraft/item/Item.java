package mtn.minecraft_layer.net.minecraft.item;

import mtn.minecraft_layer.net.minecraft.creativetab.CreativeTabs;

/**
 * Dummy stand-in for {@code net.minecraft.item.Item} (Forge 1.7.10).
 * No real registration — only exists so ported mod code compiles.
 */
public class Item {
    private String unlocalizedName;
    private String textureName;
    private CreativeTabs creativeTab;

    public Item() {
    }

    public Item setUnlocalizedName(String name) {
        this.unlocalizedName = name;
        return this;
    }

    public String getUnlocalizedName() {
        return unlocalizedName == null ? "item.null" : "item." + unlocalizedName;
    }

    public Item setTextureName(String name) {
        this.textureName = name;
        return this;
    }

    public String getTextureName() {
        return textureName;
    }

    public Item setCreativeTab(CreativeTabs tab) {
        this.creativeTab = tab;
        return this;
    }

    public CreativeTabs getCreativeTab() {
        return creativeTab;
    }

    /** Forge 1.7.10: convenience used by {@code StatCollector}. */
    public String getUnlocalizedName(ItemStack stack) {
        return getUnlocalizedName();
    }

    public String getUnlocalizedNameInefficiently(ItemStack stack) {
        return getUnlocalizedName();
    }
}
