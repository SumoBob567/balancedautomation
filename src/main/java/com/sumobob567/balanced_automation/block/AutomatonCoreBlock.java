package com.sumobob567.balanced_automation.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.Nullable;

public class AutomatonCoreBlock extends Block{
    public static final IntegerProperty MODE = IntegerProperty.create("type", 0, 3);

    public AutomatonCoreBlock() {
        super(BlockBehaviour.Properties.of()
                .strength(5F)
                .requiresCorrectToolForDrops()
                .sound(SoundType.GLASS)
        );
        this.registerDefaultState(this.stateDefinition.any().setValue(MODE, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(MODE);
    }

}
