package net.minewolf.firstmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minewolf.firstmod.util.ModTags;

import static net.minecraft.item.Items.DIAMOND;

public class MagicBlock extends Block{

    public MagicBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        world.playSound(player, pos, SoundEvents.BLOCK_AMETHYST_BLOCK_BREAK, SoundCategory.BLOCKS, 1f, 0.9f);
        return ActionResult.SUCCESS;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof ItemEntity itemEntity) {
            if(isValidItem(itemEntity.getStack())) {
                ItemStack stack = new ItemStack(DIAMOND, itemEntity.getStack().getCount());
                itemEntity.setStack(stack);

                for(int i = 0; i < itemEntity.getStack().getCount() * 4; i++){
                    TntEntity newEntity = new TntEntity(EntityType.TNT, world);
                    newEntity.setPosition(itemEntity.getPos());
                    world.spawnEntity(newEntity);
                    //newEntity.setMovementSpeed(100f);
                    //newEntity.setForwardSpeed(100f);
                    //newEntity.setSidewaysSpeed(100f);

                    /*TntEntity newTnt = new TntEntity(EntityType.TNT, world);
                    newTnt.setPosition(new Vec3d(itemEntity.getPos().x, -i, itemEntity.getPos().z));
                    world.spawnEntity(newTnt);*/
                }

                //world.setBlockState(itemEntity.getBlockPos(), Blocks.DIAMOND_BLOCK.getDefaultState());
            }
        }
        super.onSteppedOn(world, pos, state, entity);
    }

    private boolean isValidItem(ItemStack stack) {
        return stack.isIn(ModTags.Items.TRANSFORMABLE_ITEMS);
    }
}
