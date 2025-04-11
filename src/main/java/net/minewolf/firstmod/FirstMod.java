package net.minewolf.firstmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minewolf.firstmod.block.ModBlocks;
import net.minewolf.firstmod.component.ModDataComponentTypes;
import net.minewolf.firstmod.item.ModFuelRegistry;
import net.minewolf.firstmod.item.ModItemGroups;
import net.minewolf.firstmod.item.ModItems;
import net.minewolf.firstmod.item.ModTooltips;
import net.minewolf.firstmod.util.HammerUsageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstMod implements ModInitializer {
	public static final String MOD_ID = "firstmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModFuelRegistry.registerModFuelsRegistry();
		ModTooltips.registerTooltips();
		ModDataComponentTypes.registeringModDataComponentTypes();

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
	}
}