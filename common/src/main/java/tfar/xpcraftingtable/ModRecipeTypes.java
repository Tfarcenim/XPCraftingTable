package tfar.xpcraftingtable;

import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.RecipeType;

public class ModRecipeTypes {
    public static final RecipeType<CraftingRecipe> XP_CRAFTING = new RecipeType<>() {
        @Override
        public String toString() {
            return XPCraftingTable.MOD_ID+":xp_crafting";
        }
    };
}
