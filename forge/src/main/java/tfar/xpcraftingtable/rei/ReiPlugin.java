package tfar.xpcraftingtable.rei;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.plugins.REIServerPlugin;
import me.shedaniel.rei.forge.REIPluginCommon;
import me.shedaniel.rei.plugin.common.displays.crafting.DefaultCraftingDisplay;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.Recipe;
import tfar.xpcraftingtable.XPCraftingTable;
import tfar.xpcraftingtable.recipe.ShapedXPRecipe;
import tfar.xpcraftingtable.recipe.ShapelessXPRecipe;
import tfar.xpcraftingtable.recipe.XPRecipe;

@REIPluginCommon
public class ReiPlugin implements REIServerPlugin {
    public static final CategoryIdentifier<DefaultCraftingDisplay<?>> XP_CRAFTING = CategoryIdentifier.of(XPCraftingTable.MOD_ID, "xp_crafting");

    public static <XP extends CraftingRecipe & XPRecipe> DefaultCraftingDisplay<Recipe<?>> withXP(XP recipe) {
        if (recipe instanceof ShapelessXPRecipe shapelessXPRecipe) {
            return new XPShapelessDisplay(shapelessXPRecipe);
        } else if (recipe instanceof ShapedXPRecipe shapedXPRecipe) {
            return new XPShapedDisplay(shapedXPRecipe);
        }
        return null;
    }
}
