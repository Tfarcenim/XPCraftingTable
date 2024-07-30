package tfar.xpcraftingtable.rei;

import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.client.registry.transfer.TransferHandlerRegistry;
import me.shedaniel.rei.api.client.registry.transfer.simple.SimpleTransferHandler;
import me.shedaniel.rei.api.common.util.EntryStacks;
import me.shedaniel.rei.forge.REIPluginCommon;
import me.shedaniel.rei.plugin.common.BuiltinPlugin;
import net.minecraft.world.inventory.CraftingMenu;
import net.minecraft.world.item.crafting.CraftingRecipe;
import tfar.xpcraftingtable.Init;
import tfar.xpcraftingtable.ModRecipeTypes;
import tfar.xpcraftingtable.XPCraftingMenu;
import tfar.xpcraftingtable.XPCraftingScreen;
import tfar.xpcraftingtable.recipe.XPRecipe;


@REIPluginCommon
public class ReiClientPlugin<XP extends CraftingRecipe & XPRecipe> implements REIClientPlugin {

  @Override
  public void registerCategories(CategoryRegistry registry) {

    registry.add(new XPCraftingCategory());


            registry.addWorkstations(ReiPlugin.XP_CRAFTING, EntryStacks.of(Init.ITEM));
  }

  @Override
  public void registerTransferHandlers(TransferHandlerRegistry registry) {
    registry.register(SimpleTransferHandler.create(XPCraftingMenu.class, ReiPlugin.XP_CRAFTING,
            new SimpleTransferHandler.IntRange(1, 10)));
  }

  @Override
  public void registerScreens(ScreenRegistry registry) {
    registry.registerContainerClickArea(new Rectangle(88, 32, 28, 23), XPCraftingScreen.class, ReiPlugin.XP_CRAFTING);
  }

  @Override
  public void registerDisplays(DisplayRegistry registry) {
    registry.registerRecipeFiller(CraftingRecipe.class, ModRecipeTypes.XP_CRAFTING, (CraftingRecipe recipe) -> ReiPlugin.withXP((XP)recipe));
  }
}
