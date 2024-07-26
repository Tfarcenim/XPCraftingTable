package tfar.xpcraftingtable.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import tfar.xpcraftingtable.datagen.data.ModBlockTagsProvider;
import tfar.xpcraftingtable.datagen.data.ModLootTableProvider;
import tfar.xpcraftingtable.datagen.data.ModRecipeProvider;

public class ModDatagen {

    public static void gather(GatherDataEvent event) {
        boolean client = event.includeClient();
        DataGenerator dataGenerator = event.getGenerator();
        DataGenerator dataGeneratorPackOutput = dataGenerator;
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        dataGenerator.addProvider(client,new ModBlockstateProvider(dataGeneratorPackOutput,existingFileHelper));
        dataGenerator.addProvider(client,new ModLangProvider(dataGeneratorPackOutput));
        dataGenerator.addProvider(true, ModLootTableProvider.create(dataGeneratorPackOutput));
        dataGenerator.addProvider(true,new ModBlockTagsProvider(dataGeneratorPackOutput,existingFileHelper));
        dataGenerator.addProvider(true,new ModRecipeProvider(dataGeneratorPackOutput));

    }
}
