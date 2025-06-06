package net.minewolf.firstmod.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minewolf.firstmod.FirstMod;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_ALUMINUM_TOOL = createTag("needs_aluminum_tool");
        public static final TagKey<Block> INCORRECT_FOR_ALUMINUM_TOOL = createTag("incorrect_for_aluminum_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(FirstMod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");
        public static final TagKey<Item> ALUMINUM_TOOL_MATERIAL = createTag("aluminum_tool_material");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(FirstMod.MOD_ID, name));
        }
    }
}
