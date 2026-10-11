package mtn.minecraft_layer.net.minecraft.block;

import mtn.minecraft_layer.net.minecraft.block.material.Material;
import mtn.minecraft_layer.net.minecraft.creativetab.CreativeTabs;
import mtn.minecraft_layer.net.minecraft.entity.player.EntityPlayer;
import mtn.minecraft_layer.net.minecraft.item.ItemStack;
import mtn.minecraft_layer.net.minecraft.world.World;

import java.util.ArrayList;

/**
 * Dummy stand-in for {@code net.minecraft.block.Block} (Forge 1.7.10).
 * No real registration — only exists so ported mod code compiles.
 */
public class Block {
    protected final Material blockMaterial;
    private String unlocalizedName;
    private String textureName;
    private CreativeTabs creativeTab;
    private float blockHardness;
    private float blockResistance;
    private String harvestToolClass;
    private int harvestLevel;
    public SoundType stepSound;

    public Block(Material material) {
        this.blockMaterial = material;
        this.stepSound = soundTypeStone;
    }

    // ---------------- sound type ----------------

    /** Nested 1.7.10 {@code Block.SoundType} stand-in. */
    public static class SoundType {
        public final String soundName;
        public final float volume;
        public final float frequency;

        public SoundType(String soundName, float volume, float frequency) {
            this.soundName = soundName;
            this.volume = volume;
            this.frequency = frequency;
        }

        public float getVolume() {
            return volume;
        }

        public float getPitch() {
            return frequency;
        }

        public String getBreakSound() {
            return soundName;
        }

        public String getStepResourcePath() {
            return "step." + soundName;
        }
    }

    public static final SoundType soundTypeStone = new SoundType("stone", 1.0F, 1.0F);
    public static final SoundType soundTypeWood = new SoundType("wood", 1.0F, 1.0F);
    public static final SoundType soundTypeGravel = new SoundType("gravel", 1.0F, 1.0F);
    public static final SoundType soundTypeGrass = new SoundType("grass", 1.0F, 1.0F);
    public static final SoundType soundTypePiston = new SoundType("stone", 1.0F, 1.0F);
    public static final SoundType soundTypeMetal = new SoundType("metal", 1.0F, 1.0F);
    public static final SoundType soundTypeGlass = new SoundType("glass", 1.0F, 1.0F);
    public static final SoundType soundTypeCloth = new SoundType("cloth", 1.0F, 1.0F);
    public static final SoundType soundTypeSand = new SoundType("sand", 1.0F, 1.0F);
    public static final SoundType soundTypeSnow = new SoundType("snow", 1.0F, 1.0F);
    public static final SoundType soundTypeLadder = new SoundType("ladder", 1.0F, 1.0F);
    public static final SoundType soundTypeAnvil = new SoundType("anvil", 1.0F, 1.0F);

    public Block setBlockName(String name) {
        this.unlocalizedName = name;
        return this;
    }

    public String getUnlocalizedName() {
        return unlocalizedName == null ? "tile.null" : "tile." + unlocalizedName;
    }

    public Block setBlockTextureName(String name) {
        this.textureName = name;
        return this;
    }

    public String getTextureName() {
        return textureName;
    }

    public Block setCreativeTab(CreativeTabs tab) {
        this.creativeTab = tab;
        return this;
    }

    public CreativeTabs getCreativeTabToDisplayOn() {
        return creativeTab;
    }

    public Block setHardness(float hardness) {
        this.blockHardness = hardness;
        return this;
    }

    public Block setResistance(float resistance) {
        this.blockResistance = resistance;
        return this;
    }

    public float getBlockHardness() {
        return blockHardness;
    }

    public float getBlockResistance() {
        return blockResistance;
    }

    public Block setHarvestLevel(String toolClass, int level) {
        this.harvestToolClass = toolClass;
        this.harvestLevel = level;
        return this;
    }

    public Block setStepSound(SoundType sound) {
        this.stepSound = sound;
        return this;
    }

    public SoundType getStepSound() {
        return stepSound;
    }

    public Material getMaterial() {
        return blockMaterial;
    }

    /**
     * Called when a player right-clicks this block. Forge 1.7.10 signature.
     * Default returns false (no interaction). Subclasses override.
     */
    public boolean onBlockActivated(World world, int x, int y, int z,
            EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        return false;
    }

    /** Forge 1.7.10 drop list hook. Default: empty (adapters supply the block). */
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z,
            int metadata, int fortune) {
        return new ArrayList<>();
    }
}
