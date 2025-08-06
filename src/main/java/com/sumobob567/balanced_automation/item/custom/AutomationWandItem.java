package com.sumobob567.balanced_automation.item.custom;


import com.sumobob567.balanced_automation.block.ModBlocks;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.Map;

public class AutomationWandItem extends Item {
    private static final Map<Block, Block> WAND_MAP =
            Map.of(
                    ModBlocks.AUTOMATION_BLOCK.get(), ModBlocks.AUTOMATION_ORE.get()
            );

    public AutomationWandItem() {
        super(new Properties()
                .stacksTo(1)
                .durability(100)


        );
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Player player = pContext.getPlayer();
        var clickPosition = pContext.getClickedPos();
        Block currentBlock = level.getBlockState(clickPosition).getBlock();

        if (WAND_MAP.containsKey(currentBlock)) {
            if (!level.isClientSide()) {
                level.setBlockAndUpdate(clickPosition, WAND_MAP.get(currentBlock).defaultBlockState());

                pContext.getItemInHand().hurtAndBreak(1, player, p -> p.broadcastBreakEvent(player.getUsedItemHand()));

                level.playSound(null, clickPosition, SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);
            }
        }
        return InteractionResult.SUCCESS;

    }
}
