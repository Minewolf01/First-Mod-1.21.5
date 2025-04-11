package net.minewolf.firstmod.item;

import net.minecraft.item.ToolMaterial;
import net.minewolf.firstmod.util.ModTags;


public record ModToolMaterial() {
    public static final ToolMaterial ALUMINUM = new ToolMaterial(ModTags.Blocks.INCORRECT_FOR_ALUMINUM_TOOL,
            512, 7.0F, 2.5F, 14, ModTags.Items.ALUMINUM_TOOL_MATERIAL);
}
