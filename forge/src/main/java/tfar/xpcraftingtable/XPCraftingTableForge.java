package tfar.xpcraftingtable;

import net.minecraftforge.fml.common.Mod;

@Mod(XPCraftingTable.MOD_ID)
public class XPCraftingTableForge {
    
    public XPCraftingTableForge() {
    
        // This method is invoked by the Forge mod loader when it is ready
        // to load your mod. You can access Forge and Common code in this
        // project.
    
        // Use Forge to bootstrap the Common mod.
        XPCraftingTable.LOG.info("Hello Forge world!");
        XPCraftingTable.init();
        
    }
}