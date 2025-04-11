package net.minewolf.firstmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minewolf.firstmod.block.ModBlocks;
import net.minewolf.firstmod.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.MAGIC_BLOCK);
        addDrop(ModBlocks.BUFFALO_MEAT_LUMP);

        addDrop(ModBlocks.ALUMINUM_BLOCK);
        addDrop(ModBlocks.ALUMINUM_LAMP);

        addDrop(ModBlocks.ALUMINUM_TRAPDOOR);
        addDrop(ModBlocks.ALUMINUM_DOOR, doorDrops(ModBlocks.ALUMINUM_DOOR));

        addDrop(ModBlocks.ALUMINUM_BUTTON);
        addDrop(ModBlocks.ALUMINUM_PRESSURE_PLATE);

        addDrop(ModBlocks.ALUMINUM_FENCE);
        addDrop(ModBlocks.ALUMINUM_FENCE_GATE);
        addDrop(ModBlocks.ALUMINUM_WALL);

        addDrop(ModBlocks.ALUMINUM_SLAB, slabDrops(ModBlocks.ALUMINUM_SLAB));
        addDrop(ModBlocks.ALUMINUM_STAIRS);

        addDrop(ModBlocks.ALUMINUM_ORE, oreDrops(ModBlocks.ALUMINUM_ORE, ModItems.RAW_ALUMINUM));
        addDrop(ModBlocks.DEEPSLATE_ALUMINUM_ORE, oreDrops(ModBlocks.DEEPSLATE_ALUMINUM_ORE, ModItems.RAW_ALUMINUM));

        //addDrop(ModBlocks.BUFFALO_MEAT_LUMP, multipleOreDrops(ModBlocks.BUFFALO_MEAT_LUMP, ModBlocks.BUFFALO_MEAT_LUMP.asItem(), 1, 2));
    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrop, float maxDrop) {
        RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(
                drop,
                (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
                        drop,
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrop, maxDrop)))
                                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }
}
