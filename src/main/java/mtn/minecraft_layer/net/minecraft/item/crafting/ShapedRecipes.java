package mtn.minecraft_layer.net.minecraft.item.crafting;

import mtn.minecraft_layer.net.minecraft.item.ItemStack;

/**
 * Stand-in for {@code net.minecraft.item.crafting.ShapedRecipes} (Forge
 * 1.7.10). Base class for shaped crafting recipes: it holds the result and a
 * simple rectangular (width × height) ingredient grid. Recipes are never
 * matched in-game at this layer — the class exists so {@code ShapedOreRecipe}
 * (forge-layer) has a faithful base and so the ported mod's calls compile.
 */
public class ShapedRecipes {

    protected final ItemStack recipeOutput;
    protected final int recipeWidth;
    protected final int recipeHeight;

    public ShapedRecipes(ItemStack output) {
        this(output, 0, 0);
    }

    public ShapedRecipes(ItemStack output, int width, int height) {
        this.recipeOutput = output;
        this.recipeWidth = width;
        this.recipeHeight = height;
    }

    public ItemStack getRecipeOutput() {
        return recipeOutput;
    }

    public int getRecipeWidth() {
        return recipeWidth;
    }

    public int getRecipeHeight() {
        return recipeHeight;
    }
}
