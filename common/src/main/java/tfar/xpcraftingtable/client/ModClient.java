package tfar.xpcraftingtable.client;

import net.minecraft.client.gui.screens.MenuScreens;
import tfar.xpcraftingtable.Init;
import tfar.xpcraftingtable.XPCraftingScreen;

public class ModClient {

    public static void setup() {
        MenuScreens.register(Init.MENU_TYPE, XPCraftingScreen::new);
    }

}
