package com.sumobob567.balanced_automation.datagen;

import com.sumobob567.balanced_automation.block.AutomatonCoreBlock;
import com.sumobob567.balanced_automation.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, "balancedautomation", exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.AUTOMATION_BLOCK);
        blockWithItem(ModBlocks.AUTOMATION_ORE);
        blockWithItem(ModBlocks.AUTOMATION_DEEPSLATE_ORE);
        integerPropertyBlock(
                ModBlocks.AUTOMATON_CORE.get(),
                AutomatonCoreBlock.MODE,
                "automaton_core" // texture base name
        );
    }

    private void blockWithItem(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }

    private void integerPropertyBlock(Block block, IntegerProperty property, String textureBaseName) {
        getVariantBuilder(block).forAllStates(state -> {
            int value = state.getValue(property);
            return ConfiguredModel.builder()
                    .modelFile(models().cubeAll(
                            name(block) + "_" + property.getName() + value,
                            modLoc("block/" + textureBaseName + "_" + value)
                    ))
                    .build();
        });

        simpleBlockItem(block, cubeAll(block));
    }

    private String name(Block block) {
        return key(block).getPath();
    }

    private ResourceLocation key(Block block) {
        return block.builtInRegistryHolder().key().location();
    }
}