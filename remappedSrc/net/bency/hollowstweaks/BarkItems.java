package net.bency.hollowstweaks;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class BarkItems extends Item {
    public BarkItems(Settings settings) {
        super(settings);
    }

    public static final Item OAK_BARK = new Item(new FabricItemSettings());
    public static final Item DARK_OAK_BARK = new Item(new FabricItemSettings());
    public static final Item BIRCH_BARK = new Item(new FabricItemSettings());
    public static final Item SPRUCE_BARK = new Item(new FabricItemSettings());
    public static final Item JUNGLE_BARK = new Item(new FabricItemSettings());
    public static final Item ACACIA_BARK = new Item(new FabricItemSettings());
    public static final Item MANGROVE_BARK = new Item(new FabricItemSettings());
    public static final Item CHERRY_BARK = new Item(new FabricItemSettings());
    public static final Item CRIMSON_BARK = new Item(new FabricItemSettings());
    public static final Item WARPED_BARK = new Item(new FabricItemSettings());



    public static void BarkItemsInitialize(){
        Registry.register(Registries.ITEM, new Identifier("hollowtweaks","oak_bark"), OAK_BARK);
        Registry.register(Registries.ITEM, new Identifier("hollowtweaks","dark_oak_bark"), DARK_OAK_BARK);
        Registry.register(Registries.ITEM, new Identifier("hollowtweaks","birch_bark"), BIRCH_BARK);
        Registry.register(Registries.ITEM, new Identifier("hollowtweaks","spruce_bark"), SPRUCE_BARK);
        Registry.register(Registries.ITEM, new Identifier("hollowtweaks","jungle_bark"), JUNGLE_BARK);
        Registry.register(Registries.ITEM, new Identifier("hollowtweaks","acacia_bark"), ACACIA_BARK);
        Registry.register(Registries.ITEM, new Identifier("hollowtweaks","mangrove_bark"), MANGROVE_BARK);
        Registry.register(Registries.ITEM, new Identifier("hollowtweaks","cherry_bark"), CHERRY_BARK);
        Registry.register(Registries.ITEM, new Identifier("hollowtweaks","crimson_bark"), CRIMSON_BARK);
        Registry.register(Registries.ITEM, new Identifier("hollowtweaks","warped_bark"), WARPED_BARK);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
            content.add(OAK_BARK);
            content.add(DARK_OAK_BARK);
            content.add(BIRCH_BARK);
            content.add(SPRUCE_BARK);
            content.add(JUNGLE_BARK);
            content.add(ACACIA_BARK);
            content.add(MANGROVE_BARK);
            content.add(CHERRY_BARK);
            content.add(CRIMSON_BARK);
            content.add(WARPED_BARK);
        });

        {
            UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
                BlockPos pos = hitResult.getBlockPos();

                if ((player.getStackInHand(hand).getItem() == Items.WOODEN_AXE)|
                        (player.getStackInHand(hand).getItem() == Items.STONE_AXE)|
                        (player.getStackInHand(hand).getItem() == Items.IRON_AXE) |
                        (player.getStackInHand(hand).getItem() == Items.GOLDEN_AXE) |
                        (player.getStackInHand(hand).getItem() == Items.DIAMOND_AXE) |
                        (player.getStackInHand(hand).getItem() == Items.NETHERITE_AXE))
                {
                    if ((world.getBlockState(pos).getBlock() == Blocks.OAK_LOG) |
                            (world.getBlockState(pos).getBlock() == Blocks.OAK_WOOD)) {
                        player.giveItemStack(new ItemStack(BarkItems.OAK_BARK));
                    }
                    if ((world.getBlockState(pos).getBlock() == Blocks.DARK_OAK_LOG) |
                            (world.getBlockState(pos).getBlock() == Blocks.DARK_OAK_WOOD)) {
                        player.giveItemStack(new ItemStack(BarkItems.DARK_OAK_BARK));
                    }
                    if ((world.getBlockState(pos).getBlock() == Blocks.BIRCH_LOG) |
                            (world.getBlockState(pos).getBlock() == Blocks.BIRCH_WOOD)) {
                        player.giveItemStack(new ItemStack(BarkItems.BIRCH_BARK));
                    }
                    if ((world.getBlockState(pos).getBlock() == Blocks.SPRUCE_LOG) |
                            (world.getBlockState(pos).getBlock() == Blocks.SPRUCE_WOOD)) {
                        player.giveItemStack(new ItemStack(BarkItems.SPRUCE_BARK));
                    }
                    if ((world.getBlockState(pos).getBlock() == Blocks.JUNGLE_LOG) |
                            (world.getBlockState(pos).getBlock() == Blocks.JUNGLE_WOOD)) {
                        player.giveItemStack(new ItemStack(BarkItems.JUNGLE_BARK));
                    }
                    if ((world.getBlockState(pos).getBlock() == Blocks.ACACIA_LOG) |
                            (world.getBlockState(pos).getBlock() == Blocks.ACACIA_WOOD)) {
                        player.giveItemStack(new ItemStack(BarkItems.ACACIA_BARK));
                    }
                    if ((world.getBlockState(pos).getBlock() == Blocks.MANGROVE_LOG) |
                            (world.getBlockState(pos).getBlock() == Blocks.MANGROVE_WOOD)) {
                        player.giveItemStack(new ItemStack(BarkItems.MANGROVE_BARK));
                    }
                    if ((world.getBlockState(pos).getBlock() == Blocks.CHERRY_LOG) |
                            (world.getBlockState(pos).getBlock() == Blocks.CHERRY_WOOD)) {
                        player.giveItemStack(new ItemStack(BarkItems.CHERRY_BARK));
                    }
                    if ((world.getBlockState(pos).getBlock() == Blocks.CRIMSON_STEM) |
                            (world.getBlockState(pos).getBlock() == Blocks.CRIMSON_HYPHAE)) {
                        player.giveItemStack(new ItemStack(BarkItems.CRIMSON_BARK));
                    }
                    if ((world.getBlockState(pos).getBlock() == Blocks.WARPED_STEM) |
                            (world.getBlockState(pos).getBlock() == Blocks.WARPED_HYPHAE)) {
                        player.giveItemStack(new ItemStack(BarkItems.WARPED_BARK));
                    }
                }
                return ActionResult.PASS;
            });
        } //Right-clicking on logs/wood gives the corresponding bark item.

        CompostingChanceRegistry.INSTANCE.add((ItemConvertible) OAK_BARK, 1F);
        CompostingChanceRegistry.INSTANCE.add((ItemConvertible) DARK_OAK_BARK, 1F);
        CompostingChanceRegistry.INSTANCE.add((ItemConvertible) BIRCH_BARK, 1F);
        CompostingChanceRegistry.INSTANCE.add((ItemConvertible) SPRUCE_BARK, 1F);
        CompostingChanceRegistry.INSTANCE.add((ItemConvertible) JUNGLE_BARK, 1F);
        CompostingChanceRegistry.INSTANCE.add((ItemConvertible) ACACIA_BARK, 1F);
        CompostingChanceRegistry.INSTANCE.add((ItemConvertible) MANGROVE_BARK, 1F);
        CompostingChanceRegistry.INSTANCE.add((ItemConvertible) CHERRY_BARK, 1F);
        CompostingChanceRegistry.INSTANCE.add((ItemConvertible) CRIMSON_BARK, 1F);
        CompostingChanceRegistry.INSTANCE.add((ItemConvertible) WARPED_BARK, 1F);
    }
}
