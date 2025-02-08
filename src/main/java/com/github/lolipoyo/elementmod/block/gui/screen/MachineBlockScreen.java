package com.github.lolipoyo.elementmod.block.gui.screen;

import com.github.lolipoyo.elementmod.block.gui.container.MachineBlockMenu;
import com.github.lolipoyo.elementmod.main.ElementMod;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class MachineBlockScreen extends AbstractContainerScreen<MachineBlockMenu> {

    private static final ResourceLocation DISASSEMBLE_MACHINE_BLOCK_TEXTURE = ResourceLocation.fromNamespaceAndPath(ElementMod.MOD_ID, "textures/gui/container/disassemble_machine_gui.png");

    private static final Component INVENTORY_TITLE = Component.translatable("container." + ElementMod.MOD_ID + ".inventory");

    public MachineBlockScreen(MachineBlockMenu menu, Inventory inventory, Component component) {
        super(menu, inventory, component);
        //GUIの名前ラベル変更
        this.titleLabelX = 65;
        this.titleLabelY = 5;
        //this.inventoryLabelX = ?;
        //this.inventoryLabelY = this.imageHeight - ?;
    }

    //画像に何か文字をつける場合
//    @Override
//    public void render(GuiGraphics graphics, int w, int h, float f) {
//        super.render(graphics, w, h, f);
//        int setW = (this.width - this.imageWidth)/2;
//        int setH = (this.height - this.imageHeight)/2;
//        String[] st = {"x", "y", "z"};
//        for (int i = 0; i < 3; i++) {
//            Component text = Component.literal(st[i]).withStyle(ChatFormatting.BOLD);
//            graphics.drawString(this.font,text,setW + 40,setH + 18 + 21*i,0x000000,false);
//        }
//    }

    @Override
    protected void renderBg(GuiGraphics graphics, float f, int w, int h) {
        int setW = (this.width - this.imageWidth)/2;
        int setH = (this.height - this.imageHeight)/2;
        graphics.blit(DISASSEMBLE_MACHINE_BLOCK_TEXTURE,setW,setH,0,0,this.imageWidth,this.imageHeight);

    }

    @Override
    protected void renderLabels(GuiGraphics graphics, int w, int h) {
        graphics.drawString(this.font, this.title, this.titleLabelX, this.titleLabelY, 0x000000, false);
        graphics.drawString(this.font, INVENTORY_TITLE, this.inventoryLabelX, this.inventoryLabelY, 0x000000, false);
    }
}
