package com.sumobob567.balanced_automation.tab;

import com.sumobob567.balanced_automation.BalancedAutomation;
import com.sumobob567.balanced_automation.block.ModBlocks;
import com.sumobob567.balanced_automation.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BalancedAutomation.MODID);

    public static final RegistryObject<CreativeModeTab> AUTOMATION_ITEMS_TAB =
            CREATIVE_MODE_TABS.register("automation_items_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("creativetab.balancedautomation.automation_items"))
                    .icon(() -> new ItemStack(ModItems.AUTOMATION_CRYSTAL.get()))
                    .displayItems((params, output) -> {
                        output.accept(ModItems.AUTOMATION_CRYSTAL.get());
                        output.accept(ModItems.AUTOMATION_WAND.get());
                        output.accept(ModItems.SLAYER_SPAWN_EGG.get());
                        output.accept(ModBlocks.AUTOMATION_BLOCK.get());
                        output.accept(ModBlocks.AUTOMATON_CORE.get());
                        output.accept(ModBlocks.AUTOMATION_ORE.get());
                        output.accept(ModBlocks.AUTOMATION_DEEPSLATE_ORE.get());
                    })
                    .build()
            );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
