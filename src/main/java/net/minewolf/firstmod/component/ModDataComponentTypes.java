package net.minewolf.firstmod.component;

import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minewolf.firstmod.FirstMod;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes {
    public static final ComponentType<BlockPos> COORDINATES = register("coordiantes", buider -> buider.codec(BlockPos.CODEC));
    /*public static final ComponentType<Integer> HAMMER_USAGE = register("hammer_usage", builder -> builder.codec(Codecs.NON_NEGATIVE_INT)
            .packetCodec(PacketCodecs.VAR_INT));*/

    private static <T>ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(FirstMod.MOD_ID, name),
                builderOperator.apply(ComponentType.builder()).build());
    }

    public static void registeringModDataComponentTypes() {
        FirstMod.LOGGER.info("Registering Mod Data Component Types for " + FirstMod.MOD_ID);
    }
}
