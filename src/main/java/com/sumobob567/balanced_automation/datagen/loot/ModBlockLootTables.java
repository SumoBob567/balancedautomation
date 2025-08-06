package com.sumobob567.balanced_automation.datagen.loot;


import com.sumobob567.balanced_automation.block.ModBlocks;
import com.sumobob567.balanced_automation.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    protected LootTable.Builder createDeepslateOreDrops(Block pBlock, Item pItem) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(pItem)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.AUTOMATION_BLOCK.get());

        this.add(ModBlocks.AUTOMATION_DEEPSLATE_ORE.get(),
                block -> createDeepslateOreDrops(ModBlocks.AUTOMATION_DEEPSLATE_ORE.get(), ModItems.AUTOMATION_CRYSTAL.get()));
        this.add(ModBlocks.AUTOMATION_ORE.get(),
                block -> createOreDrop(ModBlocks.AUTOMATION_ORE.get(), ModItems.AUTOMATION_CRYSTAL.get()));
    }


    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
