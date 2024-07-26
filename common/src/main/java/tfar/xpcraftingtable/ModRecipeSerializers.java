package tfar.xpcraftingtable;

import tfar.xpcraftingtable.recipe.ShapedXPRecipe;
import tfar.xpcraftingtable.recipe.ShapelessXPRecipe;

public class ModRecipeSerializers {
    public static final ShapelessXPRecipe.XPSerializer SHAPELESS = new ShapelessXPRecipe.XPSerializer();
    public static final ShapedXPRecipe.XPSerializer SHAPED = new ShapedXPRecipe.XPSerializer();
}
