package net.minewolf.firstmod.item;

import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minewolf.firstmod.FirstMod;

public class ModFuelRegistry {
    public static void registerModFuelsRegistry() {
        FirstMod.LOGGER.info("Registering Fuel Registry for " + FirstMod.MOD_ID);
        FuelRegistryEvents.BUILD.register((builder, context) -> {
            //builder.add(ModItems.BUFFALO_MEAT, 60 * 20);
        });
    }
}
