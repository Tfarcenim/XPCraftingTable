package tfar.xpcraftingtable;

import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

// This class is part of the common project meaning it is shared between all supported loaders. Code written here can only
// import and access the vanilla codebase, libraries used by vanilla, and optionally third party libraries that provide
// common compatible binaries. This means common code can not directly use loader specific concepts such as Forge events
// however it will be compatible with all supported mod loaders.
public class XPCraftingTable {

    public static final String MOD_ID = "xpcraftingtable";
    public static final String MOD_NAME = "XPCraftingTable";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

    public static final MutableComponent COMPONENT =  Component.translatable("category.xpcraftingtable.xp_crafting");

     public static final String XP_TOOLTIP = "category.xpcraftingtable.xp_crafting.xp";

    // The loader specific projects are able to import and use any code from the common project. This allows you to
    // write the majority of your code here and load it from your loader specific projects. This example has some
    // code that gets invoked by the entry point of the loader specific projects.
    public static void init() {
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID,path);
    }

    public static Stream<Block> getKnownBlocks() {
        return getKnown(Registry.BLOCK);
    }
    public static Stream<Item> getKnownItems() {
        return getKnown(Registry.ITEM);
    }

    public static <V> Stream<V> getKnown(Registry<V> registry) {
        return registry.stream().filter(o -> registry.getKey(o).getNamespace().equals(MOD_ID));
    }

}