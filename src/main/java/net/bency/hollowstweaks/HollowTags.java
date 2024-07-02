package net.bency.hollowstweaks;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class HollowTags {
    public static class Items{
        public static TagKey<Item> BARKITEMS = createTag("barkitems");

        private static TagKey<Item> createTag(String name){
            return TagKey.of(RegistryKeys.ITEM, Identifier.of("hollowtweaks",name));
        }
    }
}
