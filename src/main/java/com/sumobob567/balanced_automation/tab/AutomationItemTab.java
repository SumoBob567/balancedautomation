package com.sumobob567.balanced_automation.tab;

import com.sumobob567.balanced_automation.block.ModBlocks;
import com.sumobob567.balanced_automation.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class AutomationItemTab extends CreativeModeTab {
    public AutomationItemTab() {
        super(
                CreativeModeTab.builder()
                        .icon(() -> new ItemStack(ModItems.AUTOMATION_CRYSTAL.get()))

                        .title(Component.translatable("creativetab.balanced_automation.automation_items"))
                        .displayItems((itemDisplayParameters, output) -> {
                            output.accept(ModItems.AUTOMATION_CRYSTAL.get());
                            output.accept(ModItems.AUTOMATION_WAND.get());
                            output.accept(ModBlocks.AUTOMATION_BLOCK.get());
                            output.accept(ModBlocks.AUTOMATION_ORE.get());
                            output.accept(ModBlocks.AUTOMATION_DEEPSLATE_ORE.get());
                        })
        );

    }
}
