package tfar.xpcraftingtable.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import tfar.xpcraftingtable.Init;
import tfar.xpcraftingtable.XPCraftingTable;

public class ModBlockstateProvider extends BlockStateProvider {


    public ModBlockstateProvider(DataGenerator pOutput, ExistingFileHelper helper) {
        super(pOutput, XPCraftingTable.MOD_ID,helper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(Init.BLOCK,models().getExistingFile(mcLoc("block/fletching_table")));
    }
}
