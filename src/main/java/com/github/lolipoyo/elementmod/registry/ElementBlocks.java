package com.github.lolipoyo.elementmod.registry;

import com.github.lolipoyo.elementmod.block.BlockElementBlock;
import com.github.lolipoyo.elementmod.block.BlockMachineBlock;
import com.github.lolipoyo.elementmod.main.ElementMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ElementBlocks {

    public static class Blocks {

        public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ElementMod.MOD_ID);

        //ブロックを登録
        public static final RegistryObject<Block> MAGNESIUM_BLOCK = BLOCKS.register("magnesium_block", BlockElementBlock::new);
        public static final RegistryObject<Block> DISASSEMBLE_MACHINE_BLOCK = BLOCKS.register("disassemble_machine_block", BlockMachineBlock::new);
    }

    public static class BlockItems {

        public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ElementMod.MOD_ID);

        //ブロックアイテムを登録
        public static final RegistryObject<Item> MAGNESIUM_BLOCK = BLOCK_ITEMS.register("magnesium_block",
                () -> new BlockItem(Blocks.MAGNESIUM_BLOCK.get(), new Item.Properties()));
        public static final RegistryObject<Item> DISASSEMBLE_MACHINE_BLOCK = BLOCK_ITEMS.register("disassemble_machine_block",
                () -> new BlockItem(Blocks.DISASSEMBLE_MACHINE_BLOCK.get(), new Item.Properties()));
    }
}
