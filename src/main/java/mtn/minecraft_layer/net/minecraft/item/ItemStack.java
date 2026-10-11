package mtn.minecraft_layer.net.minecraft.item;

import mtn.minecraft_layer.net.minecraft.nbt.NBTTagCompound;

/**
 * Dummy stand-in for {@code net.minecraft.item.ItemStack} (Forge 1.7.10)
 * matching the real API surface: a public {@code stackSize} field (no
 * getCount/setCount), typed goods from an {@link Item}, and an optional NBT tag.
 */
public class ItemStack {
    private final Item item;
    public int stackSize;
    private int damage;
    private NBTTagCompound tag;
    /** Optional real Mojang stack carried through the bridge so identity+count round-trips. */
    private net.minecraft.world.item.ItemStack fabricStack;

    public ItemStack(Item item) {
        this(item, 1);
    }

    public ItemStack(Item item, int count) {
        this.item = item;
        this.stackSize = count;
    }

    public ItemStack(Item item, int count, int damage) {
        this.item = item;
        this.stackSize = count;
        this.damage = damage;
    }

    public Item getItem() {
        return item;
    }

    public boolean isEmpty() {
        return item == null || stackSize <= 0;
    }

    public int getMaxStackSize() {
        return 64;
    }

    public int getItemDamage() {
        return damage;
    }

    public void setItemDamage(int d) {
        damage = d;
    }

    public NBTTagCompound getTagCompound() {
        return tag;
    }

    public void setTagCompound(NBTTagCompound t) {
        tag = t;
    }

    public boolean hasTagCompound() {
        return tag != null;
    }

    public net.minecraft.world.item.ItemStack getFabricStack() {
        return fabricStack;
    }

    public void setFabricStack(net.minecraft.world.item.ItemStack s) {
        this.fabricStack = s;
        if (s != null) {
            this.stackSize = s.getCount();
        }
    }

    public ItemStack copy() {
        ItemStack s = new ItemStack(item, stackSize, damage);
        s.tag = tag;
        s.fabricStack = fabricStack;
        return s;
    }

    public boolean isItemEqual(ItemStack other) {
        return other != null && other.item == item;
    }

    public boolean isItemEqualIgnoreDamage(ItemStack other) {
        return other != null && other.item == item;
    }

    @Override
    public String toString() {
        return "ItemStack{" + item + " x" + stackSize + "}";
    }
}
