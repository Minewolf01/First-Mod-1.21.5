package net.minewolf.firstmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minewolf.firstmod.FirstMod;
import net.minewolf.firstmod.block.custom.MagicBlock;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minewolf.firstmod.block.custom.AluminumLampBlock;

import java.util.function.Function;


public class ModBlocks {
    public static final Block BUFFALO_MEAT_LUMP = register("buffalo_meat_lump",
            Block::new, AbstractBlock.Settings.create().sounds(BlockSoundGroup.MUDDY_MANGROVE_ROOTS).strength(1f),
            true);

    public static final Block MAGIC_BLOCK = register("magic_block",
            MagicBlock::new, AbstractBlock.Settings.create().sounds(BlockSoundGroup.AMETHYST_BLOCK).strength(1f).requiresTool(),
            true);

    public static final Block ALUMINUM_ORE = register("aluminum_ore",
            settings -> new ExperienceDroppingBlock(ConstantIntProvider.create(0), settings),
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE).strength(2f).resistance(2f).requiresTool(),
            true);

    public static final Block DEEPSLATE_ALUMINUM_ORE = register("deepslate_aluminum_ore",
            settings -> new ExperienceDroppingBlock(ConstantIntProvider.create(0), settings),
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.DEEPSLATE).strength(3.5f).resistance(2f).requiresTool(),
            true);

    public static final Block ALUMINUM_BLOCK = register("aluminum_block",
            Block::new, AbstractBlock.Settings.create().mapColor(MapColor.IRON_GRAY).requiresTool().strength(5.1F, 5.0F).sounds(BlockSoundGroup.IRON),
            true);

    public static final Block ALUMINUM_STAIRS = registerStairsBlock("aluminum_stairs",
            ALUMINUM_BLOCK, AbstractBlock.Settings.create().mapColor(MapColor.IRON_GRAY).requiresTool().strength(5.1F, 5.0F).sounds(BlockSoundGroup.IRON),
            true);

    public static final Block ALUMINUM_SLAB = register("aluminum_slab",
            SlabBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.IRON_GRAY).requiresTool().strength(5.1F, 5.0F).sounds(BlockSoundGroup.IRON),
            true);

    public static final Block ALUMINUM_BUTTON = register("aluminum_button",
            settings -> new ButtonBlock(BlockSetType.IRON, 20, settings), AbstractBlock.Settings.create().mapColor(MapColor.IRON_GRAY).requiresTool()
                    .strength(5.1F, 5.0F).sounds(BlockSoundGroup.IRON).noCollision(),
            true);

    public static final Block ALUMINUM_PRESSURE_PLATE = register("aluminum_pressure_plate",
            settings -> new PressurePlateBlock(BlockSetType.IRON, settings), AbstractBlock.Settings.create().mapColor(MapColor.IRON_GRAY).solid()
                    .instrument(NoteBlockInstrument.IRON_XYLOPHONE).noCollision().strength(5.1F).pistonBehavior(PistonBehavior.DESTROY),
            true);

    public static final Block ALUMINUM_FENCE = register("aluminum_fence",
            FenceBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.IRON_GRAY).requiresTool().strength(5.1F, 5.0F).sounds(BlockSoundGroup.IRON),
            true);

    public static final Block ALUMINUM_WALL = register("aluminum_wall",
            WallBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.IRON_GRAY).requiresTool().strength(5.1F, 5.0F).sounds(BlockSoundGroup.IRON),
            true);

    public static final Block ALUMINUM_FENCE_GATE = register("aluminum_fence_gate",
            settings -> new FenceGateBlock(WoodType.MANGROVE, settings), AbstractBlock.Settings.create().mapColor(MapColor.IRON_GRAY).solid()
                    .strength(5.1F, 5.0F),
            true);

    public static final Block ALUMINUM_DOOR = register("aluminum_door",
            settings -> new DoorBlock(BlockSetType.COPPER, settings), AbstractBlock.Settings.create()
                    .instrument(NoteBlockInstrument.IRON_XYLOPHONE).strength(5.1F).resistance(5f).pistonBehavior(PistonBehavior.DESTROY).nonOpaque().sounds(BlockSoundGroup.IRON),
            true);

    public static final Block ALUMINUM_TRAPDOOR = register("aluminum_trapdoor",
            settings -> new TrapdoorBlock(BlockSetType.COPPER, settings), AbstractBlock.Settings.create().requiresTool().strength(5.1F).resistance(5f)
                    .instrument(NoteBlockInstrument.IRON_XYLOPHONE).nonOpaque().sounds(BlockSoundGroup.IRON),
            true);

    public static final Block ALUMINUM_LAMP = register("aluminum_lamp",
            AluminumLampBlock::new, AbstractBlock.Settings.create().requiresTool().strength(5.1f).resistance(5f).sounds(BlockSoundGroup.IRON).luminance(state -> state.get(AluminumLampBlock.CLICKED) ? 15 : 0),
            true);


    private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem) {
        RegistryKey<Block> blockKey = keyOfBlock(name);
        Block block = blockFactory.apply(settings.registryKey(blockKey));
        if (shouldRegisterItem) {
            RegistryKey<Item> itemKey = keyOfItem(name);
            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }
        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static Block registerStairsBlock(String name, Block block, AbstractBlock.Settings abstractBlockSettings, boolean shouldRegisterItem) {
        return register(name, settings -> new StairsBlock(block.getDefaultState(), settings), abstractBlockSettings, shouldRegisterItem);
    }

    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(FirstMod.MOD_ID, name));
    }

    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(FirstMod.MOD_ID, name));
    }

    public static void registerModBlocks() {
        FirstMod.LOGGER.info("Registering Mod Blocks for " + FirstMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.BUFFALO_MEAT_LUMP);
        });
    }
}
