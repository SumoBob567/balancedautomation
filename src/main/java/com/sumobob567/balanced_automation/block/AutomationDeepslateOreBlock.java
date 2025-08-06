package com.sumobob567.balanced_automation.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;

public class AutomationDeepslateOreBlock extends DropExperienceBlock {
    public AutomationDeepslateOreBlock() {
        super(Properties.of()

                        .strength(5f)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.DEEPSLATE), UniformInt.of(3,5)

                );
    }
}