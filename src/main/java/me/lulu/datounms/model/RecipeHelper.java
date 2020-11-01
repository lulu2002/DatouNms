package me.lulu.datounms.model;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.mineacademy.fo.MinecraftVersion;

/**
 * 2019-06-22 下午 10:59
 */
public class RecipeHelper {

    public static ShapedRecipe getNewShapedRecipe(ItemStack result) {
        if (MinecraftVersion.atLeast(MinecraftVersion.V.v1_12))
            return new ShapedRecipe(NamespacedKey.randomKey(), result);
        return new ShapedRecipe(result);
    }
}