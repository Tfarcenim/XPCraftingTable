package tfar.xpcraftingtable;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class XPCraftingTableBlock extends Block {
    public XPCraftingTableBlock(Properties $$0) {
        super($$0);
    }

    private static final Component CONTAINER_TITLE = Component.translatable("container.crafting");

    public InteractionResult use(BlockState $$0, Level $$1, BlockPos $$2, Player $$3, InteractionHand $$4, BlockHitResult $$5) {
        if ($$1.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            $$3.openMenu($$0.getMenuProvider($$1, $$2));
            $$3.awardStat(Stats.INTERACT_WITH_CRAFTING_TABLE);
            return InteractionResult.CONSUME;
        }
    }

    public MenuProvider getMenuProvider(BlockState $$0, Level $$1, BlockPos $$2) {
        return new SimpleMenuProvider(($$2x, $$3, $$4) -> {
            return new XPCraftingMenu($$2x, $$3, ContainerLevelAccess.create($$1, $$2));
        }, CONTAINER_TITLE);
    }

}
