package com.sumobob567.balanced_automation.datagen;

import com.sumobob567.balanced_automation.BalancedAutomation;
import com.sumobob567.balanced_automation.block.ModBlocks;
import com.sumobob567.balanced_automation.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> AUTOMATION_SMELTABLES = List.of(
            ModBlocks.AUTOMATION_ORE.get(),
            ModBlocks.AUTOMATION_DEEPSLATE_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreBlasting(pWriter, AUTOMATION_SMELTABLES,
                RecipeCategory.MISC,
                ModItems.AUTOMATION_CRYSTAL.get(), 1f, 100, "automation");
        oreSmelting(pWriter, AUTOMATION_SMELTABLES,
                RecipeCategory.MISC,
                ModItems.AUTOMATION_CRYSTAL.get(), 1f, 200, "automation");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.AUTOMATION_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.AUTOMATION_CRYSTAL.get())
                .unlockedBy(getHasName(ModItems.AUTOMATION_CRYSTAL.get()), has(ModItems.AUTOMATION_CRYSTAL.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.AUTOMATION_WAND.get())
                .pattern(" AA")
                .pattern(" SA")
                .pattern("S  ")
                .define('A', ModItems.AUTOMATION_CRYSTAL.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.AUTOMATION_CRYSTAL.get()), has(ModItems.AUTOMATION_CRYSTAL.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.AUTOMATION_CRYSTAL.get(), 9)
                .requires(ModBlocks.AUTOMATION_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.AUTOMATION_BLOCK.get()), has(ModBlocks.AUTOMATION_BLOCK.get()))
                .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike),
                    has(itemlike)).save(pFinishedRecipeConsumer,
                      BalancedAutomation.MODID+ ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
