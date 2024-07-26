package tfar.xpcraftingtable.inventory;

import net.minecraft.core.NonNullList;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.inventory.ResultSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import tfar.xpcraftingtable.XPCraftingMenu;
import tfar.xpcraftingtable.recipe.XPRecipe;

public class XPRequiredSlot extends ResultSlot {
    private final XPCraftingMenu xpCraftingMenu;
    protected final Player player;
    private final CraftingContainer craftingContainer;

    public XPRequiredSlot(Player player, XPCraftingMenu xpCraftingMenu, CraftingContainer craftingContainer, Container $$2, int $$3, int $$4, int $$5) {
        super(player, craftingContainer, $$2, $$3, $$4, $$5);
        this.xpCraftingMenu = xpCraftingMenu;
        this.player = player;
        this.craftingContainer = craftingContainer;
    }

    @Override
    public boolean mayPickup(Player $$0) {
        return xpCraftingMenu.canPickup();
    }

    @Override
    protected void checkTakeAchievements(ItemStack $$0) {
        if (removeCount > 0) {
            player.giveExperiencePoints(removeCount * -((XPRecipe)xpCraftingMenu.current).getXP());
        }
        super.checkTakeAchievements($$0);
    }

    @Override
    public void onTake(Player $$0, ItemStack $$1) {
        this.checkTakeAchievements($$1);
        NonNullList<ItemStack> $$2 = $$0.level.getRecipeManager().getRemainingItemsFor(RecipeType.CRAFTING, this.craftingContainer, $$0.level);

        for(int $$3 = 0; $$3 < $$2.size(); ++$$3) {
            ItemStack $$4 = this.craftingContainer.getItem($$3);
            ItemStack $$5 = $$2.get($$3);
            if (!$$4.isEmpty()) {
                this.craftingContainer.removeItem($$3, 1);
                $$4 = this.craftingContainer.getItem($$3);
            }

            if (!$$5.isEmpty()) {
                if ($$4.isEmpty()) {
                    this.craftingContainer.setItem($$3, $$5);
                } else if (ItemStack.isSame($$4, $$5) && ItemStack.tagMatches($$4, $$5)) {
                    $$5.grow($$4.getCount());
                    this.craftingContainer.setItem($$3, $$5);
                } else if (!this.player.getInventory().add($$5)) {
                    this.player.drop($$5, false);
                }
            }
        }
    }
}
