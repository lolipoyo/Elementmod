package com.github.lolipoyo.elementmod.block.entity;

import com.github.lolipoyo.elementmod.main.ElementMod;
import com.github.lolipoyo.elementmod.registry.ElementBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ElementBlockEntityTypes {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ElementMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<MachineBlockEntity>> DISASSEMBLE_MACHINE_BLOCK = BLOCK_ENTITY_TYPES.register("disassemble_machine_block", ()->set(MachineBlockEntity::new, ElementBlocks.Blocks.DISASSEMBLE_MACHINE_BLOCK.get()));
    private static <T extends BlockEntity> BlockEntityType<T> set (BlockEntityType.BlockEntitySupplier<T> entity, Block block){
        return BlockEntityType.Builder.of(entity, block).build(null);
    }
}
