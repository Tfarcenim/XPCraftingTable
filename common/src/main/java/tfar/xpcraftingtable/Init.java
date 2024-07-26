package tfar.xpcraftingtable;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public class Init {

    public static final Block BLOCK = new XPCraftingTableBlock(BlockBehaviour.Properties.of(Material.WOOD));
    public static final Item ITEM = new BlockItem(BLOCK,new Item.Properties());

}
