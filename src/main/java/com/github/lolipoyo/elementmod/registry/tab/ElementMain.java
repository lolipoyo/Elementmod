package com.github.lolipoyo.elementmod.registry.tab;

import com.github.lolipoyo.elementmod.registry.ElementBlocks;
import com.github.lolipoyo.elementmod.registry.ElementItems;
import net.minecraft.world.item.Item;

public class ElementMain {

    //クリエイトタブにアイテムを追加
    public static final Item[] items = {
            ElementItems.HYDROGEN.get(),
            ElementBlocks.BlockItems.MAGNESIUM_BLOCK.get(),
            ElementBlocks.BlockItems.DISASSEMBLE_MACHINE_BLOCK.get()
    };
}
