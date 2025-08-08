package com.sumobob567.balanced_automation.event;

import com.sumobob567.balanced_automation.BalancedAutomation;
import com.sumobob567.balanced_automation.entity.ModEntities;
import com.sumobob567.balanced_automation.entity.SlayerAutomatonEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BalancedAutomation.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.SLAYER.get(), SlayerAutomatonEntity.createAttributes().build());
    }
}
