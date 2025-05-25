package net.themilkturtle.imitation.block.custom;


import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;

import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.themilkturtle.imitation.sound.ModSounds;


public class battery_cell extends HorizontalDirectionalBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;


    public battery_cell(Properties pProperties) {
        super(pProperties);
    }

    private static final VoxelShape SHAPE = Block.box(6,0,6, 10,11,10);

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }
        @Override
        public void onRemove(BlockState oldState, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
            // Only trigger if the block is actually being replaced
            if (!oldState.is(newState.getBlock())) {
                if (!level.isClientSide) {
                    level.playSound(null, pos, ModSounds.BATTERY_CELL_BREAK.get(), SoundSource.BLOCKS, 0.4f, 1f);

                    if (level instanceof ServerLevel serverLevel) {
                        serverLevel.sendParticles(
                                ParticleTypes.CRIT,
                                pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                                20,
                                0.25, 0.25, 0.25,
                                0.01
                        );
                    }
                }
            }

            // Always call super
            super.onRemove(oldState, level, pos, newState, isMoving);
        }


    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }
}
