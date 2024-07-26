package tfar.xpcraftingtable;

import net.minecraft.core.MappedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.RegisterEvent;
import tfar.xpcraftingtable.client.ModClientForge;
import tfar.xpcraftingtable.datagen.ModDatagen;

@Mod(XPCraftingTable.MOD_ID)
public class XPCraftingTableForge {
    
    public XPCraftingTableForge() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(ModDatagen::gather);
        bus.addListener(this::register);
        if (FMLEnvironment.dist.isClient()) {
            ModClientForge.init(bus);
        }
        // This method is invoked by the Forge mod loader when it is ready
        // to load your mod. You can access Forge and Common code in this
        // project.
    
        // Use Forge to bootstrap the Common mod.
        XPCraftingTable.init();
        ModRecipeTypes.class.getName();
    }

    private void register(RegisterEvent event) {
        event.register(Registry.BLOCK_REGISTRY,XPCraftingTable.id("xp_crafting_table"),() -> Init.BLOCK);
        event.register(Registry.ITEM_REGISTRY,XPCraftingTable.id("xp_crafting_table"),() -> Init.ITEM);
        event.register(Registry.MENU_REGISTRY,XPCraftingTable.id("xp_crafting_table"),() -> Init.MENU_TYPE);

        ((MappedRegistry< RecipeSerializer<?>>)Registry.RECIPE_SERIALIZER).unfreeze();
        event.register(Registry.RECIPE_SERIALIZER_REGISTRY,XPCraftingTable.id("shapeless"),() -> ModRecipeSerializers.SHAPELESS);
        event.register(Registry.RECIPE_SERIALIZER_REGISTRY,XPCraftingTable.id("shaped"),() -> ModRecipeSerializers.SHAPED);

    }

}