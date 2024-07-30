package tfar.xpcraftingtable.rei;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.plugin.common.displays.crafting.DefaultCustomShapelessDisplay;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import org.jetbrains.annotations.Nullable;
import tfar.xpcraftingtable.recipe.ShapelessXPRecipe;

import java.util.Collections;
import java.util.List;

public class XPShapelessDisplay extends DefaultCustomShapelessDisplay implements XPDisplay {
    protected int xp;

    public XPShapelessDisplay(ShapelessXPRecipe recipe) {
        this(
                recipe,
                EntryIngredients.ofIngredients(recipe.getIngredients()),
                Collections.singletonList(EntryIngredients.of(recipe.getResultItem())),
                recipe.getXP()
        );
    }

    public XPShapelessDisplay(@Nullable Recipe<?> possibleRecipe, List<EntryIngredient> input, List<EntryIngredient> output,int xp) {
        super(possibleRecipe, input, output);
        this.xp = xp;
    }

    public XPShapelessDisplay(@Nullable ResourceLocation location, @Nullable Recipe<?> possibleRecipe, List<EntryIngredient> input, List<EntryIngredient> output) {
        super(location, possibleRecipe, input, output);
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return ReiPlugin.XP_CRAFTING;
    }

    @Override
    public int getXP() {
        return xp;
    }
}
