package net.nu11une.wardenloot.register;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.nu11une.wardenloot.WardenLoot;
import net.nu11une.wardenloot.common.WLEnchantedBookItem;
import net.nu11une.wardenloot.common.WardenDamageEnchantment;

public class WLEnchants {
    public static Enchantment WARDEN_DAMAGE;
    //public static WLEnchantedBookItem WARDEN_ENCHANTED_BOOK;

    public static void registerWLEnchants(){
        Registry.register(Registry.ENCHANTMENT, new Identifier(WardenLoot.MOD_ID, "warden_damage"), WARDEN_DAMAGE);
        //Registry.register(Registry.ITEM, new Identifier(WardenLoot.MOD_ID, "warden_enchanted_book"), WARDEN_ENCHANTED_BOOK);
    }

    static {
        WARDEN_DAMAGE = new WardenDamageEnchantment(Enchantment.Rarity.RARE, EquipmentSlot.MAINHAND);
        //WARDEN_ENCHANTED_BOOK = new WLEnchantedBookItem(new FabricItemSettings().group(WardenLoot.WL_GROUP).rarity(Rarity.UNCOMMON));
    }
}
