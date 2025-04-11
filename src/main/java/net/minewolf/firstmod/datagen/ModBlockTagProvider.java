package net.minewolf.firstmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minewolf.firstmod.block.ModBlocks;
import net.minewolf.firstmod.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.MAGIC_BLOCK)
                .add(ModBlocks.ALUMINUM_BLOCK)
                .add(ModBlocks.ALUMINUM_LAMP)

                .add(ModBlocks.ALUMINUM_ORE)
                .add(ModBlocks.DEEPSLATE_ALUMINUM_ORE)


                .add(ModBlocks.ALUMINUM_FENCE)
                .add(ModBlocks.ALUMINUM_FENCE_GATE)

                .add(ModBlocks.ALUMINUM_WALL)

                .add(ModBlocks.ALUMINUM_DOOR)
                .add(ModBlocks.ALUMINUM_TRAPDOOR)

                .add(ModBlocks.ALUMINUM_PRESSURE_PLATE)
                .add(ModBlocks.ALUMINUM_BUTTON)

                .add(ModBlocks.ALUMINUM_SLAB)
                .add(ModBlocks.ALUMINUM_STAIRS);

        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(ModBlocks.BUFFALO_MEAT_LUMP);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.MAGIC_BLOCK)
                .add(ModBlocks.ALUMINUM_BLOCK)
                .add(ModBlocks.ALUMINUM_LAMP)

                .add(ModBlocks.ALUMINUM_ORE)
                .add(ModBlocks.DEEPSLATE_ALUMINUM_ORE)

                .add(ModBlocks.ALUMINUM_FENCE)
                .add(ModBlocks.ALUMINUM_FENCE_GATE)

                .add(ModBlocks.ALUMINUM_WALL)

                .add(ModBlocks.ALUMINUM_DOOR)
                .add(ModBlocks.ALUMINUM_TRAPDOOR)

                .add(ModBlocks.ALUMINUM_PRESSURE_PLATE)
                .add(ModBlocks.ALUMINUM_BUTTON)

                .add(ModBlocks.ALUMINUM_SLAB)
                .add(ModBlocks.ALUMINUM_STAIRS);

        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.ALUMINUM_FENCE);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.ALUMINUM_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.ALUMINUM_WALL);

        getOrCreateTagBuilder(BlockTags.DOORS)
                .add(ModBlocks.ALUMINUM_DOOR);

        getOrCreateTagBuilder(BlockTags.TRAPDOORS)
                .add(ModBlocks.ALUMINUM_TRAPDOOR);

        getOrCreateTagBuilder(BlockTags.PRESSURE_PLATES)
                .add(ModBlocks.ALUMINUM_PRESSURE_PLATE);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_ALUMINUM_TOOL)
                .addTags(BlockTags.NEEDS_IRON_TOOL);
    }
}
