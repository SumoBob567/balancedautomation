package com.sumobob567.balanced_automation.entity;

import com.sumobob567.balanced_automation.BalancedAutomation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, BalancedAutomation.MODID);

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

    public static final RegistryObject<EntityType<SlayerAutomatonEntity>> SLAYER =
            ENTITY_TYPES.register("slayer", () -> EntityType.Builder.of(SlayerAutomatonEntity::new, MobCategory.CREATURE)
                    .sized(2f, 2f).build("slayer"));
}
