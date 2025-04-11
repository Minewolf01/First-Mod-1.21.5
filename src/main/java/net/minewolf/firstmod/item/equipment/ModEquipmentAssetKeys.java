package net.minewolf.firstmod.item.equipment;

import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minewolf.firstmod.FirstMod;

public interface ModEquipmentAssetKeys {
    //RegistryKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY = RegistryKey.ofRegistry(Identifier.of(FirstMod.MOD_ID, "equipment_asset"));
    RegistryKey<EquipmentAsset> ALUMINUM = register("aluminum");

    static RegistryKey<EquipmentAsset> register(String name) {
        return RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(FirstMod.MOD_ID, name));
    }


}
