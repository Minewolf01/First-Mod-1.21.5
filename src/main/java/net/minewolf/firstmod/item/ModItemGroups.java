package net.minewolf.firstmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minewolf.firstmod.FirstMod;
import net.minewolf.firstmod.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup FOOD_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(FirstMod.MOD_ID, "food"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.BUFFALO_MEAT))
                    .displayName(Text.translatable("itemgroup.firstmod.food"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.BUFFALO_MEAT);
                        entries.add(ModItems.COOKED_BUFFALO_MEAT);
                        entries.add(ModItems.WAND);
                    })
                    .build());

    public static final ItemGroup FOOD_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(FirstMod.MOD_ID, "food_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.BUFFALO_MEAT_LUMP))
                    .displayName(Text.translatable("itemgroup.firstmod.food_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.BUFFALO_MEAT_LUMP);
                        entries.add(ModBlocks.MAGIC_BLOCK);
                    })
                    .build());

    public static final ItemGroup MINERALS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(FirstMod.MOD_ID, "minerals"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.ALUMINUM_INGOT))
                    .displayName(Text.translatable("itemgroup.firstmod.minerals"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.ALUMINUM_ORE);
                        entries.add(ModBlocks.DEEPSLATE_ALUMINUM_ORE);
                        entries.add(ModItems.RAW_ALUMINUM);
                        entries.add(ModItems.ALUMINUM_INGOT);
                        entries.add(ModBlocks.ALUMINUM_BLOCK);
                    })
                    .build());

    public static final ItemGroup DECORATIVE_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(FirstMod.MOD_ID, "decorative_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.ALUMINUM_BLOCK))
                    .displayName(Text.translatable("itemgroup.firstmod.decorative_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.ALUMINUM_BLOCK);

                        entries.add(ModBlocks.ALUMINUM_TRAPDOOR);
                        entries.add(ModBlocks.ALUMINUM_DOOR);

                        entries.add(ModBlocks.ALUMINUM_BUTTON);
                        entries.add(ModBlocks.ALUMINUM_PRESSURE_PLATE);

                        entries.add(ModBlocks.ALUMINUM_FENCE);
                        entries.add(ModBlocks.ALUMINUM_FENCE_GATE);
                        entries.add(ModBlocks.ALUMINUM_WALL);

                        entries.add(ModBlocks.ALUMINUM_SLAB);
                        entries.add(ModBlocks.ALUMINUM_STAIRS);

                        entries.add(ModBlocks.ALUMINUM_LAMP);
                    })
                    .build());

    public static final ItemGroup TOOLS_AND_COMBAT_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(FirstMod.MOD_ID, "tools_and_combat"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.ALUMINUM_HAMMER))
                    .displayName(Text.translatable("itemgroup.firstmod.tools_and_combat"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.ALUMINUM_SHOVEL);
                        entries.add(ModItems.ALUMINUM_PICKAXE);
                        entries.add(ModItems.ALUMINUM_AXE);
                        entries.add(ModItems.ALUMINUM_HOE);
                        entries.add(ModItems.ALUMINUM_SWORD);
                        entries.add(ModItems.ALUMINUM_HAMMER);

                        entries.add(ModItems.ALUMINUM_HELMET);
                        entries.add(ModItems.ALUMINUM_CHESTPLATE);
                        entries.add(ModItems.ALUMINUM_LEGGINGS);
                        entries.add(ModItems.ALUMINUM_BOOTS);
                    })
                    .build());

    public static void registerItemGroups() {FirstMod.LOGGER.info("Registering Item Groups for " + FirstMod.MOD_ID);}
}
