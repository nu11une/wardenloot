package net.nu11une.wardenloot.core;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.nu11une.wardenloot.WardenLoot;
import net.nu11une.wardenloot.common.WLArmorItem;
import net.nu11une.wardenloot.common.WLArmorMaterial;

public class WLLeggingsBoots {
    public static WLArmorItem SCULK_LEGGINGS;
    public static WLArmorItem SCULK_BOOTS;

    public static void registerArmor(){
        Registry.register(Registry.ITEM, new Identifier(WardenLoot.MOD_ID, "sculk_leggings"), SCULK_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(WardenLoot.MOD_ID, "sculk_boots"), SCULK_BOOTS);
    }

    static {
        SCULK_LEGGINGS = new WLArmorItem(WLArmorMaterial.SCULKERITE, EquipmentSlot.LEGS, new FabricItemSettings().fireproof().group(WardenLoot.WL_GROUP));
        SCULK_BOOTS = new WLArmorItem(WLArmorMaterial.SCULKERITE, EquipmentSlot.FEET, new FabricItemSettings().fireproof().group(WardenLoot.WL_GROUP));
    }
}
