package tfar.xpcraftingtable.rei;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.plugin.common.displays.crafting.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.*;
import org.jetbrains.annotations.Nullable;
import tfar.xpcraftingtable.recipe.ShapedXPRecipe;

import java.util.Collections;
import java.util.List;

public class XPShapedDisplay extends DefaultCustomShapedDisplay implements XPDisplay{
    protected  int xp;
    public XPShapedDisplay(@Nullable Recipe<?> possibleRecipe, List<EntryIngredient> input, List<EntryIngredient> output, int width, int height,int xp) {
        super(possibleRecipe, input, output, width, height);
        this.xp = xp;
    }

    public XPShapedDisplay(@Nullable ResourceLocation location, @Nullable Recipe<?> possibleRecipe, List<EntryIngredient> input, List<EntryIngredient> output, int width, int height) {
        super(location, possibleRecipe, input, output, width, height);
    }

    public XPShapedDisplay(ShapedXPRecipe shapedXPRecipe) {
        this(shapedXPRecipe,
                EntryIngredients.ofIngredients(shapedXPRecipe.getIngredients()),
                Collections.singletonList(EntryIngredients.of(shapedXPRecipe.getResultItem()))
                ,shapedXPRecipe.getRecipeWidth()
                ,shapedXPRecipe.getRecipeHeight()
                ,shapedXPRecipe.getXP()
        );
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
