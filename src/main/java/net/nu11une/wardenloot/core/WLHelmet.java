package net.nu11une.wardenloot.core;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.nu11une.wardenloot.WardenLoot;
import net.nu11une.wardenloot.common.WLArmorItem;
import net.nu11une.wardenloot.common.WLArmorMaterial;

public class WLHelmet {

    public static WLArmorItem SCULK_HELMET;

    public static void registerHelmet(){
        Registry.register(Registry.ITEM, new Identifier(WardenLoot.MOD_ID, "sculk_helmet"), SCULK_HELMET);
    }

    static {
        SCULK_HELMET = new WLArmorItem(WLArmorMaterial.SCULKERITE, EquipmentSlot.HEAD, new FabricItemSettings().fireproof().group(WardenLoot.WL_GROUP));
    }
}
