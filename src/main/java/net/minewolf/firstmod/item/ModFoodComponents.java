package net.minewolf.firstmod.item;

import net.minecraft.component.type.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent BUFFALO_MEAT = new FoodComponent.Builder().nutrition(4).saturationModifier(2f).build();
    public static final FoodComponent COOKED_BUFFALO_MEAT = new FoodComponent.Builder().nutrition(10).saturationModifier(1f).build();
}
