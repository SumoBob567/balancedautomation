package com.sumobob567.balanced_automation.block;

import com.sumobob567.balanced_automation.BalancedAutomation;
import com.sumobob567.balanced_automation.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BalancedAutomation.MODID);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    public static final RegistryObject<Block> AUTOMATION_BLOCK = registerBlock("automation_block", AutomationBlock::new);
    public static final RegistryObject<Block> AUTOMATION_ORE = registerBlock("automation_ore", AutomationOreBlock::new);
    public static final RegistryObject<Block> AUTOMATION_DEEPSLATE_ORE = registerBlock("automation_deepslate_ore", AutomationDeepslateOreBlock::new);

    // Add more blocks here...
}