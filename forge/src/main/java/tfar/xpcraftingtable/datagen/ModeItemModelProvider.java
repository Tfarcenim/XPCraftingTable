package tfar.xpcraftingtable.datagen;

import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import tfar.xpcraftingtable.Init;
import tfar.xpcraftingtable.XPCraftingTable;

public class ModeItemModelProvider extends ItemModelProvider {
    public ModeItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, XPCraftingTable.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        makeSimpleBlockItem(Init.ITEM);
    }

    protected void makeSimpleBlockItem(Item item, ResourceLocation loc) {
        String s = Registry.ITEM.getKey(item).toString();
        getBuilder(s)
                .parent(getExistingFile(loc));
    }

    protected void makeSimpleBlockItem(Item item) {
        makeSimpleBlockItem(item,XPCraftingTable.id("block/" + Registry.ITEM.getKey(item).getPath()));
    }

}
