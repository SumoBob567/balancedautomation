package com.sumobob567.balanced_automation.item;

import com.sumobob567.balanced_automation.BalancedAutomation;
import com.sumobob567.balanced_automation.entity.ModEntities;
import com.sumobob567.balanced_automation.item.custom.AutomationWandItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
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

    public static RegistryObject<Item> SLAYER_SPAWN_EGG = ITEMS.register("slayer_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.SLAYER, 0x26005c, 0x6423a1, new Item.Properties()));

}
