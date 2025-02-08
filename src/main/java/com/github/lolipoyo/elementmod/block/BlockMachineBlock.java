package com.github.lolipoyo.elementmod.block;

import com.github.lolipoyo.elementmod.block.entity.MachineBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Containers;
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
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult result) {

        BlockEntity be = world.getBlockEntity(pos);
        MachineBlockEntity mb = (MachineBlockEntity) be;

        if (world.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
                player.openMenu(state.getMenuProvider(world, pos));
                return InteractionResult.CONSUME;
            }
            //音鳴らす場合
            //world.playSound(player, pos, SoundEvents.xxxxxxx, SoundSource.BLOCKS);
    }

    @Override
    protected void onRemove(BlockState state, Level world, BlockPos pos, BlockState blockState, boolean bool) {
        BlockEntity be = world.getBlockEntity(pos);
        MachineBlockEntity entity = (MachineBlockEntity)be;
        super.onRemove(state, world, pos, blockState, bool);
        Containers.dropContents(world, pos, entity);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new MachineBlockEntity(pos, state);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return null;
    }
}

