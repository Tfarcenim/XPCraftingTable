package tfar.xpcraftingtable.datagen.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import tfar.xpcraftingtable.Init;
import tfar.xpcraftingtable.XPCraftingTable;

import javax.annotation.Nullable;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(DataGenerator generatorIn,  @Nullable ExistingFileHelper existingFileHelper) {
        super(generatorIn, XPCraftingTable.MOD_ID, existingFileHelper);
    }


    @Override
    protected void addTags() {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(Init.BLOCK);
    }
}
