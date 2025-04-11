package net.minewolf.firstmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minewolf.firstmod.item.ModItems;
import net.minewolf.firstmod.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.BUFFALO_MEAT)
                .add(ModItems.COOKED_BUFFALO_MEAT)
                .add(Items.BEEF)
                .add(Items.COOKED_BEEF);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.ALUMINUM_SWORD);

        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.ALUMINUM_PICKAXE)
                .add(ModItems.ALUMINUM_HAMMER);

        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.ALUMINUM_AXE);

        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.ALUMINUM_SHOVEL);

        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.ALUMINUM_HOE);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.ALUMINUM_HELMET)
                .add(ModItems.ALUMINUM_CHESTPLATE)
                .add(ModItems.ALUMINUM_LEGGINGS)
                .add(ModItems.ALUMINUM_BOOTS);
    }
}
