package net.bency.hollowstweaks;

import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;

import javax.swing.*;

public class BetterApple extends Item {
    public BetterApple(Settings settings) {
        super(settings);
    }

    public static final Item APPLE_1 = new Item(new FabricItemSettings());
    public static final Item APPLE_2 = new Item(new FabricItemSettings());
    public static final Item APPLE_3 = new Item(new FabricItemSettings());
    public static final Item APPLE_CORE = new Item(new FabricItemSettings());

    public static void BetterAppleInitialize(){
        Registry.register(Registries.ITEM, new Identifier
                ("hollowtweaks","apple_1"), APPLE_1);
        Registry.register(Registries.ITEM, new Identifier
                ("hollowtweaks","apple_2"), APPLE_2);
        Registry.register(Registries.ITEM, new Identifier
                ("hollowtweaks","apple_3"), APPLE_3);
        Registry.register(Registries.ITEM, new Identifier
                ("hollowtweaks","apple_core"), APPLE_CORE);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> {
            content.addAfter(Items.APPLE, APPLE_CORE);
        });

        {
            UseItemCallback.EVENT.register((player, world, hand) -> {
                ItemStack usedItem = player.getStackInHand(hand);
                if (player.getStackInHand(hand).getItem() == Items.APPLE) {
                    player.playSound(SoundEvents.ENTITY_GENERIC_EAT, 1, 1);
                    if (!world.isClient) {
                        (player).getHungerManager().add(3, 1.5F);
                        player.giveItemStack(new ItemStack(APPLE_1));
                        return new TypedActionResult<>(ActionResult.SUCCESS, usedItem);
                    }
                }
                return new TypedActionResult<>(ActionResult.PASS, usedItem);
            });
            UseItemCallback.EVENT.register((player, world, hand) -> {
                ItemStack usedItem = player.getStackInHand(hand);
                if (player.getStackInHand(hand).getItem() == APPLE_1) {
                    player.playSound(SoundEvents.ENTITY_GENERIC_EAT, 1, 1);
                    if (!world.isClient) {
                        (player).getHungerManager().add(3, 1.5F);
                        player.giveItemStack(new ItemStack(APPLE_2));
                        return new TypedActionResult<>(ActionResult.SUCCESS, usedItem);
                    }
                }
                return new TypedActionResult<>(ActionResult.PASS, usedItem);
            });
            UseItemCallback.EVENT.register((player, world, hand) -> {
                ItemStack usedItem = player.getStackInHand(hand);
                if (player.getStackInHand(hand).getItem() == APPLE_2) {
                    player.playSound(SoundEvents.ENTITY_GENERIC_EAT, 1, 1);
                    if (!world.isClient) {
                        (player).getHungerManager().add(3, 1.5F);
                        player.giveItemStack(new ItemStack(APPLE_3));
                        return new TypedActionResult<>(ActionResult.SUCCESS, usedItem);
                    }
                }
                return new TypedActionResult<>(ActionResult.PASS, usedItem);
            });
            UseItemCallback.EVENT.register((player, world, hand) -> {
                ItemStack usedItem = player.getStackInHand(hand);
                if (player.getStackInHand(hand).getItem() == APPLE_3) {
                    player.playSound(SoundEvents.ENTITY_GENERIC_EAT, 1, 1);
                    if (!world.isClient) {
                        (player).getHungerManager().add(3, 1.5F);
                        player.giveItemStack(new ItemStack(APPLE_CORE));
                        return new TypedActionResult<>(ActionResult.SUCCESS, usedItem);
                    }
                }
                return new TypedActionResult<>(ActionResult.PASS, usedItem);
            });
        } //The System which replaces regular apple consumption.

        CompostingChanceRegistry.INSTANCE.add(APPLE_CORE, 1F);
    }
}
