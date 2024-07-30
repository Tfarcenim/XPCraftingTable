package tfar.xpcraftingtable.rei;

import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryStacks;
import me.shedaniel.rei.plugin.client.categories.crafting.DefaultCraftingCategory;
import me.shedaniel.rei.plugin.common.displays.crafting.DefaultCraftingDisplay;
import net.minecraft.network.chat.Component;
import tfar.xpcraftingtable.Init;
import tfar.xpcraftingtable.XPCraftingTable;

import java.util.List;

public class XPCraftingCategory extends DefaultCraftingCategory {


    @Override
    public CategoryIdentifier<? extends DefaultCraftingDisplay<?>> getCategoryIdentifier() {
        return ReiPlugin.XP_CRAFTING;
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(Init.ITEM);
    }

    @Override
    public Component getTitle() {
        return XPCraftingTable.COMPONENT;
    }

    @Override
    public List<Widget> setupDisplay(DefaultCraftingDisplay<?> display, Rectangle bounds) {
        List<Widget> widgets = super.setupDisplay(display, bounds);
        XPDisplay xpDisplay = (XPDisplay) display;
        widgets.add(Widgets.createLabel(new Point(bounds.x + 90, bounds.getMaxY() - 15),Component.translatable(XPCraftingTable.XP_TOOLTIP,xpDisplay.getXP()))
                .color(0xFF007f00, 0xFF447f44).noShadow().leftAligned());
        return widgets;
    }
}
