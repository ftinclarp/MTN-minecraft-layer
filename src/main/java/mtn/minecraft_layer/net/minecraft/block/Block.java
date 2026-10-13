package mtn.minecraft_layer.net.minecraft.block;

import mtn.minecraft_layer.net.minecraft.block.material.Material;
import mtn.minecraft_layer.net.minecraft.creativetab.CreativeTabs;
import mtn.minecraft_layer.net.minecraft.entity.Entity;
import mtn.minecraft_layer.net.minecraft.entity.EntityLivingBase;
import mtn.minecraft_layer.net.minecraft.entity.player.EntityPlayer;
import mtn.minecraft_layer.net.minecraft.item.Item;
import mtn.minecraft_layer.net.minecraft.item.ItemStack;
import mtn.minecraft_layer.net.minecraft.tileentity.TileEntity;
import mtn.minecraft_layer.net.minecraft.util.IIcon;
import mtn.minecraft_layer.net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import mtn.minecraft_layer.net.minecraft.client.renderer.texture.IIconRegister;

import java.util.ArrayList;
import java.util.List;

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

    // ---------------- 1.7.10 Block override surface (Batch 3) ----------------
    // All bodies are safe defaults; the real implementations live on the
    // Fabric side. Methods exist only so Iron Chest's @Overrides compile.

    /** Forge 1.7.10: opaque blocks cull neighbours. */
    public boolean isOpaqueCube() {
        // TODO(mtn-layer): true unless the block is a transparent tile block.
        return false;
    }

    /** Forge 1.7.10: whether the block renders as a standard cube. */
    public boolean renderAsNormalBlock() {
        // TODO(mtn-layer): true for full-cube blocks, false for tile renderers.
        return false;
    }

    /** Forge 1.7.10: render type id (IRenderBlockHandler etc.). */
    public int getRenderType() {
        // TODO(mtn-layer): real render-type id.
        return 0;
    }

    /** Forge 1.7.10: create the tile entity. Subclasses override. */
    public TileEntity createTileEntity(World world, int metadata) {
        // TODO(mtn-layer): build the real block-entity from metadata.
        return null;
    }

    /** Forge 1.7.10: called when an adjacent block is added. */
    public void onBlockAdded(World world, int x, int y, int z) {
        // TODO(mtn-layer): neighbour-update logic.
    }

    /** Forge 1.7.10: called when a player places the block. */
    public void onBlockPlacedBy(World world, int x, int y, int z,
            EntityLivingBase entityliving, ItemStack itemStack) {
        // TODO(mtn-layer): store placement/facing on the tile entity.
    }

    /** Forge 1.7.10: damage value for the dropped item. */
    public int damageDropped(int metadata) {
        // TODO(mtn-layer): return the dropped stack's damage.
        return 0;
    }

    /** Forge 1.7.10: called when the block is broken. */
    public void breakBlock(World world, int x, int y, int z,
            Block blockRemoved, int metadata) {
        // TODO(mtn-layer): drop contents / invalidate the tile entity.
    }

    /** Forge 1.7.10: register block-side icons. */
    public void registerBlockIcons(IIconRegister iconRegister) {
        // TODO(mtn-layer): register the block's textures.
    }

    /** Forge 1.7.10: return the icon for a side+meta. */
    public IIcon getIcon(int side, int metadata) {
        // TODO(mtn-layer): resolve the icon texture.
        return null;
    }

    /** Forge 1.7.10: add this block's sub-items (CreativeTabs browsing). */
    public void getSubBlocks(Item item, CreativeTabs tab, List<ItemStack> list) {
        // TODO(mtn-layer): add a stack per subtype.
    }

    /** Forge 1.7.10: does the block emit a comparator signal. */
    public boolean hasComparatorInputOverride() {
        // TODO(mtn-layer): true when the tile entity provides a signal.
        return false;
    }

    /** Forge 1.7.10: comparator signal strength for the given meta. */
    public int getComparatorInputOverride(World world, int x, int y, int z,
            int side) {
        // TODO(mtn-layer): forward to the tile entity.
        return 0;
    }

    /** Forge 1.7.10: set the block's bounding box. */
    public Block setBlockBounds(float minX, float minY, float minZ,
            float maxX, float maxY, float maxZ) {
        // TODO(mtn-layer): store the AABB for culling/collision.
        return this;
    }

    /** Forge 1.7.10: blocks resist explosions (called with the blast origin). */
    public float getExplosionResistance(Entity entity, World world, int x, int y, int z,
            double explosionX, double explosionY, double explosionZ) {
        // TODO(mtn-layer): return blockResistance unless overridden.
        return blockResistance;
    }

    // ---- Forge 1.7.10 rotation extension hooks (ForgeDirection comes from
    //      the literal net.minecraftforge.* package) ----

    /** Forge 1.7.10: valid rotation axes (Renewable power tools). */
    public ForgeDirection[] getValidRotations(World world, int x, int y, int z) {
        // TODO(mtn-layer): return the axes this block can be rotated on.
        return new ForgeDirection[0];
    }

    /** Forge 1.7.10: rotate the block around the given axis. */
    public boolean rotateBlock(World world, int x, int y, int z, ForgeDirection axis) {
        // TODO(mtn-layer): apply rotation to the block/tile.
        return false;
    }
}
