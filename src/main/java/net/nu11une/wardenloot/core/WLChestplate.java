package net.nu11une.wardenloot.core;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.nu11une.wardenloot.WardenLoot;
import net.nu11une.wardenloot.common.WLArmorItem;
import net.nu11une.wardenloot.common.WLArmorMaterial;
import net.nu11une.wardenloot.util.WLToolTip;

public class WLChestplate {
    public static WLArmorItem SCULK_CHESTPLATE;

    public static void registerChestplate(){
        Registry.register(Registry.ITEM, new Identifier(WardenLoot.MOD_ID, "sculk_chestplate"), SCULK_CHESTPLATE);
    }

    static {
        SCULK_CHESTPLATE = new WLArmorItem(WLArmorMaterial.SCULKERITE, EquipmentSlot.CHEST, new FabricItemSettings().fireproof().group(WardenLoot.WL_GROUP));
    }
}
