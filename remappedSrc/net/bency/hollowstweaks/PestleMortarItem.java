package net.bency.hollowstweaks;

import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class PestleMortarItem extends Item {
    public PestleMortarItem(Settings settings) {
        super(settings);
    }

    public static final Item PESTLE_AND_MORTAR = new Item(new FabricItemSettings().maxDamage(256));



    public static void PestleMortarInitialize(){
        Registry.register(Registries.ITEM,new Identifier
                ("hollowtweaks","pestle_and_mortar"),PESTLE_AND_MORTAR);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.add(PESTLE_AND_MORTAR);
        });
        //Usage
        UseItemCallback.EVENT.register((player, world, hand) ->{
            ItemStack usedItem = player.getStackInHand(hand);
            int damagedAmount = player.getStackInHand(hand).getDamage();
            if (player.getStackInHand(hand).getItem() == PESTLE_AND_MORTAR){
                if (player.getOffHandStack().getItem() == Items.SANDSTONE){
                    player.getOffHandStack().decrement(1);
                    player.giveItemStack(new ItemStack(Items.SAND,4));
                    player.playSound(SoundEvents.BLOCK_GRINDSTONE_USE,0.3F,1);
                    usedItem.damage(1,player,playerEntity -> player.animateDamage(1));
                    return new TypedActionResult<>(ActionResult.SUCCESS, usedItem);
                }
                if (player.getOffHandStack().getItem() == Items.STONE){
                    player.getOffHandStack().decrement(1);
                    player.giveItemStack(new ItemStack(Items.COBBLESTONE,1));
                    player.playSound(SoundEvents.BLOCK_GRINDSTONE_USE,0.3F,1);
                    usedItem.damage(1,player,playerEntity -> player.animateDamage(1));
                    return new TypedActionResult<>(ActionResult.SUCCESS, usedItem);
                }
                if (player.getOffHandStack().getItem() == Items.COBBLESTONE){
                    player.getOffHandStack().decrement(1);
                    player.giveItemStack(new ItemStack(Items.GRAVEL,1));
                    player.playSound(SoundEvents.BLOCK_GRINDSTONE_USE,0.3F,1);
                    usedItem.damage(1,player,playerEntity -> player.animateDamage(1));
                    return new TypedActionResult<>(ActionResult.SUCCESS, usedItem);
                }
                if (player.getOffHandStack().getItem() == Items.GRAVEL){
                    player.getOffHandStack().decrement(1);
                    player.giveItemStack(new ItemStack(Items.SAND,1));
                    player.playSound(SoundEvents.BLOCK_GRINDSTONE_USE,0.3F,1);
                    usedItem.damage(1,player,playerEntity -> player.animateDamage(1));
                    return new TypedActionResult<>(ActionResult.SUCCESS, usedItem);
                }
                if (player.getOffHandStack().getItem() == Items.CACTUS){
                    player.getOffHandStack().decrement(1);
                    player.giveItemStack(new ItemStack(Items.GREEN_DYE,1));
                    player.playSound(SoundEvents.BLOCK_GRINDSTONE_USE,0.3F,1);
                    usedItem.damage(1,player,playerEntity -> player.animateDamage(1));
                    return new TypedActionResult<>(ActionResult.SUCCESS, usedItem);
                }
                if ((player.getOffHandStack().getItem() == Items.GRASS) |
                        (player.getOffHandStack().getItem() == Items.TALL_GRASS)){
                    player.getOffHandStack().decrement(1);
                    player.giveItemStack(new ItemStack(Items.LIME_DYE,1));
                    player.playSound(SoundEvents.BLOCK_GRINDSTONE_USE,0.3F,1);
                    usedItem.damage(1,player,playerEntity -> player.animateDamage(1));
                    return new TypedActionResult<>(ActionResult.SUCCESS, usedItem);
                }
                if ((player.getOffHandStack().getItem() == Items.COAL) |
                        (player.getOffHandStack().getItem() == Items.CHARCOAL)){
                    player.getOffHandStack().decrement(1);
                    player.giveItemStack(new ItemStack(Items.GUNPOWDER,4));
                    player.playSound(SoundEvents.BLOCK_GRINDSTONE_USE,0.3F,1);
                    usedItem.damage(1,player,playerEntity -> player.animateDamage(1));
                    return new TypedActionResult<>(ActionResult.SUCCESS, usedItem);
                }
            }
            return new TypedActionResult<>(ActionResult.PASS, usedItem);
        });
    }
}
