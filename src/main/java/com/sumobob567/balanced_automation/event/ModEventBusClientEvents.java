package com.sumobob567.balanced_automation.event;

import com.sumobob567.balanced_automation.BalancedAutomation;
import com.sumobob567.balanced_automation.entity.client.ModModelLayers;
import com.sumobob567.balanced_automation.entity.client.SlayerModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BalancedAutomation.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.SLAYER_LAYER, SlayerModel::createBodyLayer);
    }
}
