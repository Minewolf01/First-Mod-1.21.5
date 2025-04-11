package net.minewolf.firstmod.item;

import com.google.common.collect.Maps;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundEvents;
import net.minewolf.firstmod.item.equipment.ModEquipmentAssetKeys;

import java.util.Map;

public interface ModArmorMaterials {
    ArmorMaterial ALUMINUM = new ArmorMaterial(
            24, createDefenseMap(3, 5, 7, 3, 8), 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            1.0F, 0.025F, ItemTags.REPAIRS_IRON_ARMOR, ModEquipmentAssetKeys.ALUMINUM);

    private static Map<EquipmentType, Integer> createDefenseMap(int bootsDefense, int leggingsDefense, int chestplateDefense, int helmetDefense, int bodyDefense) {
        return Maps.newEnumMap(
                Map.of(
                        EquipmentType.BOOTS,
                        bootsDefense,
                        EquipmentType.LEGGINGS,
                        leggingsDefense,
                        EquipmentType.CHESTPLATE,
                        chestplateDefense,
                        EquipmentType.HELMET,
                        helmetDefense,
                        EquipmentType.BODY,
                        bodyDefense
                )
        );
    }
}
