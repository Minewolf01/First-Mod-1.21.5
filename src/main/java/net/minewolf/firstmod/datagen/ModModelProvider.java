package net.minewolf.firstmod.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.*;
import net.minecraft.client.render.model.json.ModelVariant;
import net.minecraft.client.render.model.json.WeightedVariant;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.Pool;
import net.minecraft.util.collection.Weighted;
import net.minewolf.firstmod.block.ModBlocks;
import net.minewolf.firstmod.item.ModItems;
import net.minewolf.firstmod.block.custom.AluminumLampBlock;
import net.minewolf.firstmod.item.equipment.ModEquipmentAssetKeys;

import java.util.Arrays;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool aluminumPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ALUMINUM_BLOCK);
        aluminumPool.stairs(ModBlocks.ALUMINUM_STAIRS);
        aluminumPool.slab(ModBlocks.ALUMINUM_SLAB);

        aluminumPool.button(ModBlocks.ALUMINUM_BUTTON);
        aluminumPool.pressurePlate(ModBlocks.ALUMINUM_PRESSURE_PLATE);

        aluminumPool.fence(ModBlocks.ALUMINUM_FENCE);
        aluminumPool.fenceGate(ModBlocks.ALUMINUM_FENCE_GATE);
        aluminumPool.wall(ModBlocks.ALUMINUM_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.ALUMINUM_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.ALUMINUM_TRAPDOOR);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BUFFALO_MEAT_LUMP);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGIC_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ALUMINUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_ALUMINUM_ORE);

        WeightedVariant lampOffIdentifier = createWeightedVariant(TexturedModel.CUBE_ALL.upload(ModBlocks.ALUMINUM_LAMP, blockStateModelGenerator.modelCollector));
        WeightedVariant lampOnIdentifier = createWeightedVariant(blockStateModelGenerator.createSubModel(ModBlocks.ALUMINUM_LAMP, "_on", Models.CUBE_ALL, TextureMap::all));
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockModelDefinitionCreator.of(ModBlocks.ALUMINUM_LAMP).with(
                createBooleanModelMap(AluminumLampBlock.CLICKED, lampOnIdentifier, lampOffIdentifier))
        );
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.BUFFALO_MEAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_BUFFALO_MEAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.WAND, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_ALUMINUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.ALUMINUM_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.ALUMINUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ALUMINUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ALUMINUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ALUMINUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ALUMINUM_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ALUMINUM_HAMMER, Models.HANDHELD);

        itemModelGenerator.registerArmor(ModItems.ALUMINUM_HELMET, ModEquipmentAssetKeys.ALUMINUM, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.ALUMINUM_CHESTPLATE, ModEquipmentAssetKeys.ALUMINUM, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.ALUMINUM_LEGGINGS, ModEquipmentAssetKeys.ALUMINUM, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.ALUMINUM_BOOTS, ModEquipmentAssetKeys.ALUMINUM, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);

    }

    public static BlockStateVariantMap<WeightedVariant> createBooleanModelMap(BooleanProperty property, WeightedVariant trueModel, WeightedVariant falseModel) {
        return BlockStateVariantMap.models(property).register(true, trueModel).register(false, falseModel);
    }

    public static ModelVariant createModelVariant(Identifier id) {
        return new ModelVariant(id);
    }

    public static WeightedVariant createWeightedVariant(ModelVariant variant) {
        return new WeightedVariant(Pool.of(variant));
    }

    public static WeightedVariant createWeightedVariant(ModelVariant... variants) {
        return new WeightedVariant(Pool.of(Arrays.stream(variants).map(variant -> new Weighted<>(variant, 1)).toList()));
    }

    public static WeightedVariant createWeightedVariant(Identifier id) {
        return createWeightedVariant(createModelVariant(id));
    }
}
