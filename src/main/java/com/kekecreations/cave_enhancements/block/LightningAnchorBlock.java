package com.kekecreations.cave_enhancements.block;

import com.kekecreations.cave_enhancements.block.entity.LightningAnchorBlockEntity;
import com.kekecreations.cave_enhancements.block.entity.ReceiverBlockEntity;
import com.kekecreations.cave_enhancements.block.entity.RoseQuartzChimesBlockEntity;
import com.kekecreations.cave_enhancements.registry.ModBlockEntities;
import com.kekecreations.cave_enhancements.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.PushReaction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@ParametersAreNonnullByDefault
public class LightningAnchorBlock extends BaseEntityBlock {
    public LightningAnchorBlock(Properties settings){
        super(settings);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new LightningAnchorBlockEntity(pos, state);
    }

    @Override
    public @NotNull RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, ModBlockEntities.LIGHTNING_ANCHOR.get(), (world1, pos, state1, entity) -> LightningAnchorBlockEntity.tick(world1, pos, entity));
    }

    @Override
    public @NotNull PushReaction getPistonPushReaction(BlockState state) {
        return PushReaction.IGNORE;
    }
}
