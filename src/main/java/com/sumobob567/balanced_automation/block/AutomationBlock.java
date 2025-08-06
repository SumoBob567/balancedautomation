package com.sumobob567.balanced_automation.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;

public class AutomationBlock extends Block {
    public AutomationBlock() {
        super(Properties.of()

                .strength(4F)
                .requiresCorrectToolForDrops()
                .sound(SoundType.AMETHYST)

        );
    }
}