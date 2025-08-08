package com.sumobob567.balanced_automation.item.custom;


import com.sumobob567.balanced_automation.block.AutomatonCoreBlock;
import com.sumobob567.balanced_automation.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

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
        BlockState state = level.getBlockState(clickPosition);
        Block currentBlock = level.getBlockState(clickPosition).getBlock();

        if (WAND_MAP.containsKey(currentBlock)) {
            if (!level.isClientSide()) {
                level.setBlockAndUpdate(clickPosition, WAND_MAP.get(currentBlock).defaultBlockState());

                pContext.getItemInHand().hurtAndBreak(1, player, p -> p.broadcastBreakEvent(player.getUsedItemHand()));


                level.playSound(null, clickPosition, SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);
            }
        }

        if (!level.isClientSide()) {
            if(state.hasProperty(AutomatonCoreBlock.MODE)) {
                int currentMode = state.getValue(AutomatonCoreBlock.MODE);
                if (!player.isShiftKeyDown()) {
                    int nextMode = (currentMode + 1) % 4;
                    level.setBlock(clickPosition, state.setValue(AutomatonCoreBlock.MODE, nextMode), 3);
                }
                else {
                    BlockPos below = clickPosition.below();
                    BlockPos north = clickPosition.north();
                    BlockPos south = clickPosition.south();
                    BlockPos west = clickPosition.west();
                    BlockPos east = clickPosition.east();

                    boolean baseValid = level.getBlockState(below).is(ModBlocks.AUTOMATION_BLOCK.get());
                    boolean northSouthValid = level.getBlockState(north).is(ModBlocks.AUTOMATION_BLOCK.get())
                            && level.getBlockState(south).is(ModBlocks.AUTOMATION_BLOCK.get());
                    boolean eastWestValid = level.getBlockState(east).is(ModBlocks.AUTOMATION_BLOCK.get())
                            && level.getBlockState(west).is(ModBlocks.AUTOMATION_BLOCK.get());
                    boolean armsValid = northSouthValid || eastWestValid;

                    if (baseValid && armsValid && (currentMode != 0)) {
                        level.setBlock(clickPosition, Blocks.AIR.defaultBlockState(), 3);
                        level.setBlock(below, Blocks.AIR.defaultBlockState(), 3);
                        if (northSouthValid) {
                            level.setBlock(north, Blocks.AIR.defaultBlockState(), 3);
                            level.setBlock(south, Blocks.AIR.defaultBlockState(), 3);
                        } else {
                            level.setBlock(east, Blocks.AIR.defaultBlockState(), 3);
                            level.setBlock(west, Blocks.AIR.defaultBlockState(), 3);
                        }
                        if (currentMode == 1) {
                            player.sendSystemMessage(Component.literal("Summoning Slayer"));
                        } else if (currentMode == 2) {
                            player.sendSystemMessage(Component.literal("Summoning Farmer"));
                        } else if (currentMode == 3) {
                            player.sendSystemMessage(Component.literal("Summoning Sorter"));
                        }
                    }

                }
            }
        }

        return InteractionResult.SUCCESS;

    }
}
