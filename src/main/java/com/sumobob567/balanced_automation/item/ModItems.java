package com.sumobob567.balanced_automation.item;

import com.sumobob567.balanced_automation.BalancedAutomation;
import com.sumobob567.balanced_automation.item.custom.AutomationWandItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BalancedAutomation.MODID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static final RegistryObject<Item> AUTOMATION_CRYSTAL =
            ITEMS.register("automation_crystal", AutomationCrystalItem::new);
    public static final RegistryObject<Item> AUTOMATION_WAND =
            ITEMS.register("automation_wand", AutomationWandItem::new);

}
