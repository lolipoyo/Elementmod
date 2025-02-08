package com.github.lolipoyo.elementmod.block.gui.container;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class MachineBlockMenu extends AbstractContainerMenu {

    private final Container container;

    public MachineBlockMenu(int a, Inventory inventory){
        this(a, inventory, new SimpleContainer(10));
    }

    public MachineBlockMenu(int a, Inventory inventory, Container container) {
        super(ElementContainerTypes.DISASSEMBLE_MACHINE_BLOCK.get(), a);
        this.container = container;
        checkContainerSize(container, 10);
        container.startOpen(inventory.player);

        for (int i = 0; i < 3; i++) {
            this.addSlot(new Slot(container, i, 24, 34));
            for (int j = 0; j < 3; j++) {
                this.addSlot(new Slot(container, i + j + 1, 97 + j * 18, 34));
            }
        }

        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 9; l++) {
                this.addSlot(new Slot(inventory, l + 9 + k * 9, 8 + l * 18, 84 + k + 18));
            }
        }

        for (int m = 0; m < 9; m++) {
            this.addSlot(new Slot(inventory , m, 8 + m * 18, 142));
        }
    }

    @Override
    public ItemStack quickMoveStack(Player player, int a) {
        ItemStack $$2 = ItemStack.EMPTY;
        Slot $$3 = (Slot)this.slots.get(a);
        if ($$3 != null && $$3.hasItem()) {
            ItemStack $$4 = $$3.getItem();
            $$2 = $$4.copy();
            if (a < this.container.getContainerSize()) {
                if (!this.moveItemStackTo($$4, this.container.getContainerSize(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo($$4, 0, this.container.getContainerSize(), false)) {
                return ItemStack.EMPTY;
            }

            if ($$4.isEmpty()) {
                $$3.setByPlayer(ItemStack.EMPTY);
            } else {
                $$3.setChanged();
            }
        }

        return $$2;
    }

    @Override
    public boolean stillValid(Player player) {
        return this.container.stillValid(player);
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        this.container.stopOpen(player);
    }
}
