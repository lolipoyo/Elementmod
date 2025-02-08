package com.github.lolipoyo.elementmod.block.entity;

import com.github.lolipoyo.elementmod.block.gui.container.MachineBlockMenu;
import com.github.lolipoyo.elementmod.main.ElementMod;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class MachineBlockEntity extends RandomizableContainerBlockEntity {

    //0を宣言
    private int count = 0;

    private NonNullList<ItemStack> items = NonNullList.withSize(10, ItemStack.EMPTY);

    public MachineBlockEntity(BlockPos pos, BlockState state) {
        super(ElementBlockEntityTypes.DISASSEMBLE_MACHINE_BLOCK.get(),pos,state);
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        //数字カウント
        tag.putInt("t-count", count);

        ContainerHelper.saveAllItems(tag, this.items, registries);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        //数字カウント
        this.count = tag.getInt("t-count");

        ContainerHelper.loadAllItems(tag, this.items, registries);
    }

    //数字カウント
    public void increment(){
        this.count++;
    }

    public int getCount(){
        return this.count;
    }

    //MachineBlock用
    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> list) {
        this.items = list;
    }

    @Override
    public int getContainerSize() {
        return this.items.size();
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container." + ElementMod.MOD_ID + ".disassemble_machine_block");
    }

    @Override
    protected AbstractContainerMenu createMenu(int a, Inventory inventory) {
        return new MachineBlockMenu(a, inventory, this);
    }

}
