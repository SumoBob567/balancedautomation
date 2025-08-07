package com.sumobob567.balanced_automation.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;

public class AutomationOreBlock extends DropExperienceBlock {
    public AutomationOreBlock() {
        super(Properties.of()

                        .strength(4f)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.STONE), UniformInt.of(2,4)

                );
    }
}