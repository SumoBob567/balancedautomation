package com.sumobob567.balanced_automation.datagen;

import com.sumobob567.balanced_automation.block.ModBlocks;
import com.sumobob567.balanced_automation.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import com.sumobob567.balanced_automation.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, "balancedautomation", existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Blocks.AUTOMATION_ENERGY_SOURCES)
                .add(ModBlocks.AUTOMATION_BLOCK.get());
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.AUTOMATION_BLOCK.get())
                .add(ModBlocks.AUTOMATON_CORE.get())
                .add(ModBlocks.AUTOMATION_ORE.get())
                .add(ModBlocks.AUTOMATION_DEEPSLATE_ORE.get());
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.AUTOMATION_BLOCK.get())
                .add(ModBlocks.AUTOMATON_CORE.get())
                .add(ModBlocks.AUTOMATION_ORE.get())
                .add(ModBlocks.AUTOMATION_DEEPSLATE_ORE.get());
        this.tag(ModTags.Blocks.FORGE_ORES)
                .add(ModBlocks.AUTOMATION_ORE.get())
                .add(ModBlocks.AUTOMATION_DEEPSLATE_ORE.get());
    }
}
