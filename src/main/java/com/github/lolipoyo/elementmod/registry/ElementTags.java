package com.github.lolipoyo.elementmod.registry;

import com.github.lolipoyo.elementmod.main.ElementMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ElementTags {

    public static class Blocks {
        private static TagKey<Block> tag (String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(ElementMod.MOD_ID, name));
        }
    }

    public static class Items {

        public static final TagKey<Item> ELEMENT_SERIES = tag("element_series");
        private static TagKey<Item> tag (String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(ElementMod.MOD_ID, name));
        }
    }
}
