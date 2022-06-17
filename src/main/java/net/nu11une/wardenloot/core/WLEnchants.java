package net.nu11une.wardenloot.core;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.nu11une.wardenloot.WardenLoot;
import net.nu11une.wardenloot.common.WardenDamageEnchantment;

public class WLEnchants {
    public static Enchantment WARDEN_DAMAGE;

    public static void registerWLEnchants(){
        Registry.register(Registry.ENCHANTMENT, new Identifier(WardenLoot.MOD_ID, "warden_damage"), WARDEN_DAMAGE);
    }

    static {
        WARDEN_DAMAGE = new WardenDamageEnchantment(Enchantment.Rarity.RARE, EquipmentSlot.MAINHAND);
    }
}
