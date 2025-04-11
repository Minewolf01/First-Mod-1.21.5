package net.minewolf.firstmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minewolf.firstmod.block.ModBlocks;
import net.minewolf.firstmod.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {
                //RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);

                List<ItemConvertible> COOKED_BUFFALO_MEAT = List.of(ModItems.BUFFALO_MEAT);
                offerSmelting(COOKED_BUFFALO_MEAT, RecipeCategory.FOOD, ModItems.COOKED_BUFFALO_MEAT, 0.4f, 180, "buffalo_meat");
                offerSmoking(COOKED_BUFFALO_MEAT, RecipeCategory.FOOD, ModItems.COOKED_BUFFALO_MEAT, 0.5f, 90, "buffalo_meat");
                offerCampfireCooking(COOKED_BUFFALO_MEAT, RecipeCategory.FOOD, ModItems.COOKED_BUFFALO_MEAT, 0.4f, 500, "buffalo_meat");

                List<ItemConvertible> ALUMINUM_INGOT = List.of(ModItems.RAW_ALUMINUM, ModBlocks.ALUMINUM_ORE, ModBlocks.DEEPSLATE_ALUMINUM_ORE);
                offerSmelting(ALUMINUM_INGOT, RecipeCategory.MISC, ModItems.ALUMINUM_INGOT, 0.8f, 190, "aluminum");
                offerBlasting(ALUMINUM_INGOT, RecipeCategory.MISC, ModItems.ALUMINUM_INGOT, 0.9f, 95, "aluminum");
                offerSmoking(ALUMINUM_INGOT, RecipeCategory.MISC, ModItems.ALUMINUM_INGOT, 0.5f, 99999999, "aluminum");
                offerCampfireCooking(ALUMINUM_INGOT, RecipeCategory.MISC, ModItems.ALUMINUM_INGOT, 0.3f, 999999999, "aluminum");

                // อัด Item Buffalo Meat
                createShaped(RecipeCategory.MISC, ModBlocks.BUFFALO_MEAT_LUMP)
                        .pattern("RRR")
                        .pattern("RRR")
                        .pattern("RRR")
                        .input('R', ModItems.BUFFALO_MEAT)
                        .criterion(hasItem(ModItems.BUFFALO_MEAT), conditionsFromItem(ModItems.BUFFALO_MEAT))
                        .offerTo(exporter);
                // คลาย Block Buffalo Meat Lump
                createShapeless(RecipeCategory.MISC, ModItems.BUFFALO_MEAT, 9)
                        .input(ModBlocks.BUFFALO_MEAT_LUMP)
                        .criterion(hasItem(ModBlocks.BUFFALO_MEAT_LUMP), conditionsFromItem(ModBlocks.BUFFALO_MEAT_LUMP))
                        .offerTo(exporter, "buffalo_meat_from_buffalo_meat_lump");

                // อัด Item Aluminum Ingot
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ALUMINUM_BLOCK)
                        .pattern("RRR")
                        .pattern("RRR")
                        .pattern("RRR")
                        .input('R', ModItems.ALUMINUM_INGOT)
                        .criterion(hasItem(ModItems.ALUMINUM_INGOT), conditionsFromItem(ModItems.ALUMINUM_INGOT))
                        .offerTo(exporter);
                // บลาย Block Aluminum Block
                createShapeless(RecipeCategory.MISC, ModItems.ALUMINUM_INGOT, 9)
                        .input(ModBlocks.ALUMINUM_BLOCK)
                        .criterion(hasItem(ModBlocks.ALUMINUM_BLOCK), conditionsFromItem(ModBlocks.ALUMINUM_BLOCK))
                        .offerTo(exporter, "aluminum_ingot_from_aluminum_block");

                createDoorRecipe(ModBlocks.ALUMINUM_DOOR, Ingredient.ofItem(ModItems.ALUMINUM_INGOT))
                        .criterion(hasItem(ModItems.ALUMINUM_INGOT), conditionsFromItem(ModItems.ALUMINUM_INGOT))
                        .offerTo(exporter);
                createTrapdoorRecipe(ModBlocks.ALUMINUM_TRAPDOOR, Ingredient.ofItem(ModItems.ALUMINUM_INGOT))
                        .criterion(hasItem(ModItems.ALUMINUM_INGOT), conditionsFromItem(ModItems.ALUMINUM_INGOT))
                        .offerTo(exporter);

                // คราฟ Aluminum Fence Gate
                createShaped(RecipeCategory.DECORATIONS, ModBlocks.ALUMINUM_FENCE_GATE, 3)
                        .pattern("ERE")
                        .pattern("ERE")
                        .input('R', ModBlocks.ALUMINUM_BLOCK)
                        .input('E', ModItems.ALUMINUM_INGOT)
                        .criterion(hasItem(ModBlocks.ALUMINUM_BLOCK), conditionsFromItem(ModBlocks.ALUMINUM_BLOCK))
                        .criterion(hasItem(ModItems.ALUMINUM_INGOT), conditionsFromItem(ModItems.ALUMINUM_INGOT))
                        .offerTo(exporter);
                // คราฟ Aluminum Fence
                createShaped(RecipeCategory.DECORATIONS, ModBlocks.ALUMINUM_FENCE, 3)
                        .pattern("RER")
                        .pattern("RER")
                        .input('R', ModBlocks.ALUMINUM_BLOCK)
                        .input('E', ModItems.ALUMINUM_INGOT)
                        .criterion(hasItem(ModBlocks.ALUMINUM_BLOCK), conditionsFromItem(ModBlocks.ALUMINUM_BLOCK))
                        .criterion(hasItem(ModItems.ALUMINUM_INGOT), conditionsFromItem(ModItems.ALUMINUM_INGOT))
                        .offerTo(exporter);
                // คราฟ Aluminum Wall
                createShaped(RecipeCategory.DECORATIONS, ModBlocks.ALUMINUM_WALL, 10)
                        .pattern("RRR")
                        .pattern("RRR")
                        .input('R', ModBlocks.ALUMINUM_BLOCK)
                        .criterion(hasItem(ModBlocks.ALUMINUM_BLOCK), conditionsFromItem(ModBlocks.ALUMINUM_BLOCK))
                        .offerTo(exporter);

                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ALUMINUM_SLAB, Ingredient.ofItem(ModBlocks.ALUMINUM_BLOCK))
                        .criterion(hasItem(ModBlocks.ALUMINUM_BLOCK), conditionsFromItem(ModBlocks.ALUMINUM_BLOCK))
                        .offerTo(exporter);
                createStairsRecipe(ModBlocks.ALUMINUM_STAIRS, Ingredient.ofItem(ModBlocks.ALUMINUM_BLOCK))
                        .criterion(hasItem(ModBlocks.ALUMINUM_BLOCK), conditionsFromItem(ModBlocks.ALUMINUM_BLOCK))
                        .offerTo(exporter);
                createButtonRecipe(ModBlocks.ALUMINUM_BUTTON, Ingredient.ofItem(ModItems.ALUMINUM_INGOT))
                        .criterion(hasItem(ModItems.ALUMINUM_INGOT), conditionsFromItem(ModItems.ALUMINUM_INGOT))
                        .offerTo(exporter);

                // คราฟ Aluminum Pressure Plate
                createShaped(RecipeCategory.REDSTONE, ModBlocks.ALUMINUM_PRESSURE_PLATE, 32)
                        .pattern("RR")
                        .pattern("EE")
                        .input('R', ModBlocks.ALUMINUM_BLOCK)
                        .input('E', Blocks.REDSTONE_BLOCK)
                        .criterion(hasItem(Blocks.REDSTONE_BLOCK), conditionsFromItem(Blocks.REDSTONE_BLOCK))
                        .criterion(hasItem(ModBlocks.ALUMINUM_BLOCK), conditionsFromItem(ModBlocks.ALUMINUM_BLOCK))
                        .offerTo(exporter);

                // คราฟ Aluminum Lamp
                createShaped(RecipeCategory.REDSTONE, ModBlocks.ALUMINUM_LAMP)
                        .pattern("ARA")
                        .pattern("RGR")
                        .pattern("ARA")
                        .input('A', ModItems.ALUMINUM_INGOT)
                        .input('R', Items.REDSTONE)
                        .input('G', Items.GLOWSTONE)
                        .criterion(hasItem(ModItems.ALUMINUM_INGOT), conditionsFromItem(ModItems.ALUMINUM_INGOT))
                        .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                        .criterion(hasItem(Items.GLOWSTONE), conditionsFromItem(Items.GLOWSTONE))
                        .offerTo(exporter);

                // คราฟ Aluminum Hammer
                createShaped(RecipeCategory.TOOLS, ModItems.ALUMINUM_HAMMER)
                        .pattern("RRR")
                        .pattern("RRR")
                        .pattern(" E ")
                        .input('R', ModItems.ALUMINUM_INGOT)
                        .input('E', Items.STICK)
                        .criterion(hasItem(ModItems.ALUMINUM_INGOT), conditionsFromItem(ModItems.ALUMINUM_INGOT))
                        .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                        .offerTo(exporter);
            }

            public void offerSmoking(List<ItemConvertible> inputs, RecipeCategory category, ItemConvertible output, float experience, int cookingTime, String group) {
                offerMultipleOptions(RecipeSerializer.SMOKING, SmokingRecipe::new, inputs, category, output, experience, cookingTime, group, "_from_smoking");
            }

            public void offerCampfireCooking(List<ItemConvertible> inputs, RecipeCategory category, ItemConvertible output, float experience, int cookingTime, String group) {
                offerMultipleOptions(RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new, inputs, category, output, experience, cookingTime, group, "_from_campfire_cooking");
            }
        };
    }

    @Override
    public String getName() {
        return "";
    }
}
