package tfar.xpcraftingtable;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class XPCraftingScreen extends AbstractContainerScreen<XPCraftingMenu> {
    private static final ResourceLocation CRAFTING_TABLE_LOCATION = new ResourceLocation("textures/gui/container/crafting_table.png");

    public XPCraftingScreen(XPCraftingMenu $$0, Inventory $$1, Component $$2) {
        super($$0, $$1, $$2);
        this.titleLabelX = 29;
    }

    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBackground(pPoseStack);
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        this.renderTooltip(pPoseStack, pMouseX, pMouseY);
    }

    @Override
    protected void renderLabels(PoseStack matrices, int $$1, int $$2) {
        super.renderLabels(matrices, $$1, $$2);
        int xp = menu.getXPRequired();
        if (xp > -1) {
            Component component = Component.translatable("container.repair.cost",xp);
            int $$8 = this.imageWidth - 8 - this.font.width(component) - 2;
            this.font.drawShadow(matrices,component, $$8, 72, menu.canPickup() ? 0x80ff20 : 0xff6060);
        }
    }

    protected void renderBg(PoseStack pPoseStack, float pPartialTick, int pX, int pY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, CRAFTING_TABLE_LOCATION);
        int i = this.leftPos;
        int j = (this.height - this.imageHeight) / 2;
        this.blit(pPoseStack, i, j, 0, 0, this.imageWidth, this.imageHeight);
    }

}
