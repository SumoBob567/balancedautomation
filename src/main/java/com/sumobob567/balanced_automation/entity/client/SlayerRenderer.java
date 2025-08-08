package com.sumobob567.balanced_automation.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.sumobob567.balanced_automation.BalancedAutomation;
import com.sumobob567.balanced_automation.entity.SlayerAutomatonEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SlayerRenderer extends MobRenderer<SlayerAutomatonEntity, SlayerModel<SlayerAutomatonEntity>> {
    public SlayerRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new SlayerModel<>(pContext.bakeLayer(ModModelLayers.SLAYER_LAYER)), 1.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(SlayerAutomatonEntity slayerAutomatonEntity) {
        return ResourceLocation.fromNamespaceAndPath(BalancedAutomation.MODID, "textures/entity/slayer_automaton.png");
    }

    @Override
    public void render(SlayerAutomatonEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {



        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
