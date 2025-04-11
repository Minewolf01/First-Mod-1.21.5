package net.minewolf.firstmod.item;

import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minewolf.firstmod.FirstMod;
import net.minewolf.firstmod.component.ModDataComponentTypes;

public class ModTooltips {
    public static void registerTooltips() {
        FirstMod.LOGGER.info("Registering Tooltips for " + FirstMod.MOD_ID);

        ItemTooltipCallback.EVENT.register((itemStack, tooltipContext, tooltipType, list) -> {
            if (itemStack.isOf(ModItems.WAND)) {
                if (!Screen.hasShiftDown()) {
                    list.add(Text.translatable("item.firstmod.wand.tooltipNonShift"));
                } else {
                    list.add(Text.translatable("item.firstmod.wand.tooltipWithShift"));

                    if (itemStack.get(ModDataComponentTypes.COORDINATES) != null) {
                        list.add(Text.of("Last Block Changes at " + itemStack.get(ModDataComponentTypes.COORDINATES)));
                    }
                }
            }
        });
    }
}
