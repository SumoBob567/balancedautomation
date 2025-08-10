package com.sumobob567.balanced_automation.datagen;

import com.sumobob567.balanced_automation.BalancedAutomation;
import com.sumobob567.balanced_automation.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, "balancedautomation", existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.AUTOMATION_CRYSTAL);
        simpleItem(ModItems.AUTOMATION_WAND);

        withExistingParent(ModItems.SLAYER_SPAWN_EGG.getId().getPath(), ResourceLocation.parse("item/template_spawn_egg"));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(), mcLoc("item/generated"))
                .texture("layer0", modLoc("item/" + item.getId().getPath()));
    }



}
