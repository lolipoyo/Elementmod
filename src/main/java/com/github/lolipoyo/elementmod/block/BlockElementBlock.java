package com.github.lolipoyo.elementmod.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;

public class BlockElementBlock extends Block {

    public BlockElementBlock() {
        super(Properties.of()
                .strength(5.0F, 150)
                .sound(SoundType.STONE)
                .requiresCorrectToolForDrops()
        );
    }
}
