package com.sumobob567.balanced_automation.util;

import com.sumobob567.balanced_automation.BalancedAutomation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> AUTOMATION_ENERGY_SOURCES = tag("automation_energy_sources");
        public static final TagKey<Block> FORGE_ORES = forgeTag("ores");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(BalancedAutomation.MODID, name));
        }
        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath("forge", name));
        }
    }

    public static class Items {

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(BalancedAutomation.MODID, name));
        }
    }
}
