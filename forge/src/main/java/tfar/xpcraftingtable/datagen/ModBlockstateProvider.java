package tfar.xpcraftingtable.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Blocks;
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
        simpleBlock(Init.BLOCK,models().getBuilder("xp_crafting_table")
                .parent(models().getExistingFile(mcLoc("block/lectern")))
                .texture("base",blockTexture(Blocks.GOLD_BLOCK))
                .texture("bottom",blockTexture(Blocks.GOLD_BLOCK))
                .texture("sides",blockTexture(Blocks.OBSIDIAN))
                .texture("front",blockTexture(Blocks.OBSIDIAN))
                .texture("top",blockTexture(Blocks.WARPED_PLANKS))


        );
    }
}
