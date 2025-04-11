package net.minewolf.firstmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minewolf.firstmod.FirstMod;
import net.minewolf.firstmod.item.custom.HammerItem;
import net.minewolf.firstmod.item.custom.WandItem;

import java.util.function.Function;

public class ModItems {
    public static final Item BUFFALO_MEAT = registerItem("buffalo_meat", Item::new, new Item.Settings()
            .food(ModFoodComponents.BUFFALO_MEAT));
    public static final Item COOKED_BUFFALO_MEAT = registerItem("cooked_buffalo_meat", Item::new, new Item.Settings()
            .food(ModFoodComponents.COOKED_BUFFALO_MEAT));

    public static final Item WAND = registerItem("wand", WandItem::new, new Item.Settings().maxCount(1).maxDamage(69));
    public static final Item ALUMINUM_HAMMER = registerToolItem("aluminum_hammer", settings -> new HammerItem(
            ModToolMaterial.ALUMINUM, 1F, -2.8F, settings));

    public static final Item RAW_ALUMINUM = registerItem("raw_aluminum", Item::new, new Item.Settings());
    public static final Item ALUMINUM_INGOT = registerItem("aluminum_ingot", Item::new, new Item.Settings());

    public static final Item ALUMINUM_SWORD = register("aluminum_sword", new Item.Settings().sword(
            ModToolMaterial.ALUMINUM, 3F, -2.4F).fireproof());
    public static final Item ALUMINUM_PICKAXE = register("aluminum_pickaxe", new Item.Settings().pickaxe(
            ModToolMaterial.ALUMINUM, 1F, -2.8F).fireproof());
    public static final Item ALUMINUM_SHOVEL = registerToolItem("aluminum_shovel", settings -> new ShovelItem(
            ModToolMaterial.ALUMINUM, 1.5F, -3F, settings));
    public static final Item ALUMINUM_AXE = registerToolItem("aluminum_axe", settings -> new AxeItem(
            ModToolMaterial.ALUMINUM, 5.5F, -3.05F, settings));
    public static final Item ALUMINUM_HOE = registerToolItem("aluminum_hoe", settings -> new HoeItem(
            ModToolMaterial.ALUMINUM, -2.5F, -0.5F, settings));

    public static final Item ALUMINUM_HELMET = register("aluminum_helmet", new Item.Settings().armor(ModArmorMaterials.ALUMINUM, EquipmentType.HELMET));
    public static final Item ALUMINUM_CHESTPLATE = register("aluminum_chestplate", new Item.Settings().armor(ModArmorMaterials.ALUMINUM, EquipmentType.CHESTPLATE));
    public static final Item ALUMINUM_LEGGINGS = register("aluminum_leggings", new Item.Settings().armor(ModArmorMaterials.ALUMINUM, EquipmentType.LEGGINGS));
    public static final Item ALUMINUM_BOOTS = register("aluminum_boots", new Item.Settings().armor(ModArmorMaterials.ALUMINUM, EquipmentType.BOOTS));

    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(FirstMod.MOD_ID, name));
        return Items.register(registryKey, factory, settings);
    }

    public static Item registerToolItem(String name, Function<Item.Settings, Item> factory) {
        return registerItem(name, factory, new Item.Settings());
    }

    public static Item register(String name, Item.Settings settings) {
        return registerItem(name, Item::new, settings);
    }

    public static void registerModItems() {
        FirstMod.LOGGER.info("Registering Mod Items for " + FirstMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(BUFFALO_MEAT);
            fabricItemGroupEntries.add(COOKED_BUFFALO_MEAT);
        });
    }
}
