package com.github.lolipoyo.elementmod.block;

import com.github.lolipoyo.elementmod.block.entity.MachineBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class BlockMachineBlock extends BaseEntityBlock {

    public BlockMachineBlock() {
        super(Properties.of().strength(3.0F, 150F));
    }


    @Override
    public InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult result) {

        BlockEntity be = world.getBlockEntity(pos);
        MachineBlockEntity mb = (MachineBlockEntity) be;

        if (player.isSteppingCarefully()){
            player.moveTo(pos.getX() + 0.5, pos.getY() + mb.getCount(), pos.getZ() + 0.5);
        } else {
            mb.increment();
            if (!world.isClientSide){
                player.displayClientMessage(Component.literal("Count:" + mb.getCount()), true);
            }
            //音鳴らす場合
            //world.playSound(player, pos, SoundEvents.xxxxxxx, SoundSource.BLOCKS);
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    protected void onRemove(BlockState state, Level world, BlockPos pos, BlockState blockState, boolean bool) {
        super.onRemove(state, world, pos, blockState, bool);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new MachineBlockEntity(pos, state);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return null;
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }
}

