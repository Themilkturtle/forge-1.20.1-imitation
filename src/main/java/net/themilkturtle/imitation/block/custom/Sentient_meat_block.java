package net.themilkturtle.imitation.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.themilkturtle.imitation.sound.ModSounds;

public class Sentient_meat_block extends Block {
    public Sentient_meat_block(Properties pProperties) {
        super(pProperties);

    }


    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos,
                                 Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {

        pLevel.playSound(pPlayer,pPos, ModSounds.SENTIENT_MEAT_BLOCK_GROAN.get(), SoundSource.BLOCKS, 0.2f, 1f);

        return InteractionResult.SUCCESS;
    }
}
