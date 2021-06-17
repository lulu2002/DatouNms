package me.lulu.datounms.model;

import me.lulu.datounms.DaTouNMS;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

/**
 * 2019-06-22 下午 10:59
 */
public class RecipeHelper {

    public static ShapedRecipe getNewShapedRecipe(ItemStack result) {
        if (isAtLeast1_12(DaTouNMS.getNmsVersion()))
            return new ShapedRecipe(NamespacedKey.randomKey(), result);
        return new ShapedRecipe(result);
    }

    private static boolean isAtLeast1_12(String nmsVersion) {
        return Integer.parseInt(nmsVersion.split("_")[1]) >= 12;
    }
}
