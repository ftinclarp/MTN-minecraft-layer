package mtn.minecraft_layer.net.minecraft.creativetab;

/**
 * Dummy stand-in for {@code net.minecraft.creativetab.CreativeTabs}
 * (Forge 1.7.10). Holds the tab constants used by ported mod code.
 */
public class CreativeTabs {
    public static final CreativeTabs tabBlock = new CreativeTabs();
    public static final CreativeTabs tabMisc = new CreativeTabs();
    public static final CreativeTabs tabDecorations = new CreativeTabs();
    public static final CreativeTabs tabRedstone = new CreativeTabs();
    public static final CreativeTabs tabTransport = new CreativeTabs();
    public static final CreativeTabs tabBrewing = new CreativeTabs();
    public static final CreativeTabs tabMaterials = new CreativeTabs();
    public static final CreativeTabs tabCombat = new CreativeTabs();
    public static final CreativeTabs tabTools = new CreativeTabs();
    public static final CreativeTabs tabFood = new CreativeTabs();
    public static final CreativeTabs tabAllSearch = new CreativeTabs();
    public static final CreativeTabs tabInventory = new CreativeTabs();
    public static final CreativeTabs tabHotbar = new CreativeTabs();

    private final String label;

    public CreativeTabs() {
        this.label = null;
    }

    public CreativeTabs(String label) {
        this.label = label;
    }

    public String getTabLabel() {
        return label == null ? "?" : label;
    }

    public String getTranslatedTabLabel() {
        return getTabLabel();
    }
}
