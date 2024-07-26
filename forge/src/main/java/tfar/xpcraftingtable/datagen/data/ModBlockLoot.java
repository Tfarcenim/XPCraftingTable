package tfar.xpcraftingtable.datagen.data;

import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import tfar.xpcraftingtable.Init;
import tfar.xpcraftingtable.XPCraftingTable;

public class ModBlockLoot extends BlockLoot {


    @Override
    protected void addTables() {
        dropSelf(Init.BLOCK);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return XPCraftingTable.getKnownBlocks().toList();
    }
}
