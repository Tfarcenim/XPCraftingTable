package tfar.xpcraftingtable.recipe;

import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.ShapedRecipe;
import tfar.xpcraftingtable.ModRecipeSerializers;
import tfar.xpcraftingtable.ModRecipeTypes;

public class ShapedXPRecipe extends ShapedRecipe implements XPRecipe {
    protected final int xp;

    public ShapedXPRecipe(ResourceLocation $$0, String $$1, int $$2, int $$3, NonNullList<Ingredient> $$4, ItemStack $$5,int xp) {
        super($$0, $$1, $$2, $$3, $$4, $$5);
        this.xp = xp;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipeTypes.XP_CRAFTING;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipeSerializers.SHAPED;
    }

    @Override
    public int getXP() {
        return xp;
    }


    public static class XPSerializer extends Serializer {

        @Override
        public ShapedXPRecipe fromJson(ResourceLocation location, JsonObject json) {
            ShapedRecipe shapedRecipe = super.fromJson(location, json);
            int xp = GsonHelper.getAsInt(json,"xp");
            return new ShapedXPRecipe(shapedRecipe.getId(),shapedRecipe.getGroup(),shapedRecipe.getWidth(),shapedRecipe.getHeight(), shapedRecipe.getIngredients(), shapedRecipe.getResultItem(),xp);
        }

        @Override
        public ShapedXPRecipe fromNetwork(ResourceLocation $$0, FriendlyByteBuf $$1) {
            ShapedRecipe shapedRecipe = super.fromNetwork($$0, $$1);
            int xp = $$1.readInt();
            return new ShapedXPRecipe(shapedRecipe.getId(),shapedRecipe.getGroup(),shapedRecipe.getWidth(),shapedRecipe.getHeight(), shapedRecipe.getIngredients(), shapedRecipe.getResultItem(),xp);
        }

        @Override
        public void toNetwork(FriendlyByteBuf $$0, ShapedRecipe $$1) {
            super.toNetwork($$0, $$1);
            $$0.writeInt(((ShapedXPRecipe)$$1).xp);
        }
    }
}
