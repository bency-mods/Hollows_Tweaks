package net.bency.hollowstweaks;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class Splodge extends Block {
    public Splodge(Settings settings) {
        super(settings);
    }

    public static final Splodge HONEY_SPLODGE = new Splodge(Settings.copy(Blocks.HONEY_BLOCK).nonOpaque());

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return Block.createCuboidShape(0, 0, 0, 16, 1, 16);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return Block.createCuboidShape(0, 0, 0, 16, 1, 16);
    }

    @Override
    public BlockState getAppearance(BlockState state, BlockRenderView renderView, BlockPos pos, Direction side, @Nullable BlockState sourceState, @Nullable BlockPos sourcePos) {
        return super.getAppearance(state, renderView, pos, side, sourceState, sourcePos);

    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        super.onEntityCollision(state, world, pos, entity);
        if (!world.isClient) {
            LivingEntity livingEntity = (LivingEntity) entity;
            livingEntity.addStatusEffect
                    (new StatusEffectInstance(StatusEffects.SLOWNESS, 2, 255, true, false));
        }
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if ((player.getStackInHand(hand).getItem() == Items.GLASS_BOTTLE)) {
            world.setBlockState(pos, Blocks.AIR.getDefaultState());
            player.playSound(SoundEvents.BLOCK_HONEY_BLOCK_BREAK, 1, 1);
            player.setStackInHand(Hand.MAIN_HAND, new ItemStack(Items.HONEY_BOTTLE));
            return ItemActionResult.success(true);
        } else {
            return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }
    }

    public static void SplodgeInitialize(){
        Registry.register(Registries.BLOCK, Identifier.of("hollowtweaks","honey_splodge"), HONEY_SPLODGE);
        Registry.register(Registries.ITEM, Identifier.of("hollowtweaks","honey_splodge"),
                new BlockItem(HONEY_SPLODGE, new Item.Settings()));

        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            BlockPos pos = hitResult.getBlockPos().up();
            if ((player.getStackInHand(hand).getItem() == Items.HONEY_BOTTLE)){
                if (world.getBlockState(pos).getBlock() == Blocks.AIR){
                    world.setBlockState(pos, HONEY_SPLODGE.getDefaultState());
                    player.playSound(SoundEvents.ITEM_HONEY_BOTTLE_DRINK);
                    player.setStackInHand(Hand.MAIN_HAND, new ItemStack(Items.GLASS_BOTTLE));
                    return ActionResult.SUCCESS;
                }
            }
            return ActionResult.PASS;
        });
    }

}
