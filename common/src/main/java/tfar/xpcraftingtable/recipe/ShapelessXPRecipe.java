package tfar.xpcraftingtable.recipe;

import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapelessRecipe;
import tfar.xpcraftingtable.ModRecipeSerializers;

public class ShapelessXPRecipe extends ShapelessRecipe {
    protected final int xp;

    public ShapelessXPRecipe(ResourceLocation pId, String pGroup, ItemStack pResult, NonNullList<Ingredient> pIngredients, int xp) {
        super(pId, pGroup, pResult, pIngredients);
        this.xp = xp;
    }


    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipeSerializers.SHAPELESS;
    }


    public static class XPSerializer extends Serializer {

        @Override
        public ShapelessXPRecipe fromJson(ResourceLocation location, JsonObject json) {
            ShapelessRecipe shapelessRecipe = super.fromJson(location, json);
            int xp = GsonHelper.getAsInt(json,"xp");
            return new ShapelessXPRecipe(shapelessRecipe.getId(),shapelessRecipe.getGroup(),shapelessRecipe.getResultItem(),shapelessRecipe.getIngredients(),xp);
        }

        @Override
        public ShapelessXPRecipe fromNetwork(ResourceLocation $$0, FriendlyByteBuf $$1) {
            ShapelessRecipe shapelessRecipe = super.fromNetwork($$0, $$1);
            int xp = $$1.readInt();
            return new ShapelessXPRecipe(shapelessRecipe.getId(),shapelessRecipe.getGroup(),shapelessRecipe.getResultItem(),shapelessRecipe.getIngredients(),xp);
        }

        @Override
        public void toNetwork(FriendlyByteBuf $$0, ShapelessRecipe $$1) {
            super.toNetwork($$0, $$1);
            $$0.writeInt(((ShapelessXPRecipe)$$1).xp);
        }
    }
}
