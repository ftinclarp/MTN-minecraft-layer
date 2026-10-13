package mtn.minecraft_layer.net.minecraft.item;

import mtn.minecraft_layer.net.minecraft.block.Block;
import mtn.minecraft_layer.net.minecraft.creativetab.CreativeTabs;
import mtn.minecraft_layer.net.minecraft.entity.player.EntityPlayer;
import mtn.minecraft_layer.net.minecraft.util.IIcon;
import mtn.minecraft_layer.net.minecraft.world.World;
import mtn.minecraft_layer.net.minecraft.client.renderer.texture.IIconRegister;

/**
 * Dummy stand-in for {@code net.minecraft.item.Item} (Forge 1.7.10).
 * No real registration — only exists so ported mod code compiles.
 */
public class Item {
    private String unlocalizedName;
    private String textureName;
    private CreativeTabs creativeTab;

    // Forge 1.7.10 fields set by ItemChestChanger.registerIcons
    public IIcon itemIcon;

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

    // ---------------- Batch 3: Forge 1.7.10 Item surface ----------------

    /** Forge 1.7.10: returns the block's item, or null if none. */
    public static Item getItemFromBlock(Block block) {
        // TODO(mtn-layer): return ItemBlock for the given block.
        return null;
    }

    /** Forge 1.7.10: cap the stack size. */
    public Item setMaxStackSize(int max) {
        // TODO(mtn-layer): store and enforce max stack size.
        return this;
    }

    /** Forge 1.7.10: cap the durability. */
    public Item setMaxDamage(int max) {
        // TODO(mtn-layer): store the durability cap.
        return this;
    }

    /** Forge 1.7.10: flag that sub-types share a class. */
    public Item setHasSubtypes(boolean subtypes) {
        // TODO(mtn-layer): store the subtype flag.
        return this;
    }

    /** Forge 1.7.10: whether this item has subtypes. */
    public boolean getHasSubtypes() {
        // TODO(mtn-layer): return the stored subtype flag.
        return false;
    }

    /** Forge 1.7.10: damage for a given metadata. */
    public int getMetadata(int metadata) {
        // TODO(mtn-layer): return the damage value.
        return 0;
    }

    /** Forge 1.7.10: client-side icon registration. */
    public void registerIcons(IIconRegister iconRegister) {
        // TODO(mtn-layer): register the item's icons.
    }

    /** Forge 1.7.10: hook used by ItemChestChanger to place/upgrade. */
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world,
            int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        // TODO(mtn-layer): real first-use placement logic.
        return false;
    }
}
