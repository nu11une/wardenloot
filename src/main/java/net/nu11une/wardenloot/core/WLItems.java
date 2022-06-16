package net.nu11une.wardenloot.core;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.nu11une.wardenloot.WardenLoot;
import net.nu11une.wardenloot.common.*;
import net.nu11une.wardenloot.common.WLArmorMaterial;
import net.nu11une.wardenloot.common.WLToolMaterial;

public class WLItems {

    public static Item SCULK_INGOT;
    public static Item SCULK_SOUL;
    public static Item WARDEN_HEART;
    public static WLArmorItem SCULK_HELMET;
    public static WLArmorItem SCULK_CHESTPLATE;
    public static WLArmorItem SCULK_LEGGINGS;
    public static WLArmorItem SCULK_BOOTS;
    public static WLSwordItem SCULK_SWORD;
    public static WLPickaxeItem SCULK_PICKAXE;
    public static WLAxeItem SCULK_AXE;
    public static WLHoeItem SCULK_HOE;
    public static WLShovelItem SCULK_SHOVEL;

    public static void registerWLItems() {
        Registry.register(Registry.ITEM, new Identifier(WardenLoot.MOD_ID, "sculk_ingot"), SCULK_INGOT);
        Registry.register(Registry.ITEM, new Identifier(WardenLoot.MOD_ID, "sculk_soul"), SCULK_SOUL);
        Registry.register(Registry.ITEM, new Identifier(WardenLoot.MOD_ID, "warden_heart"), WARDEN_HEART);
        Registry.register(Registry.ITEM, new Identifier(WardenLoot.MOD_ID, "sculk_helmet"), SCULK_HELMET);
        Registry.register(Registry.ITEM, new Identifier(WardenLoot.MOD_ID, "sculk_chestplate"), SCULK_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(WardenLoot.MOD_ID, "sculk_leggings"), SCULK_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(WardenLoot.MOD_ID, "sculk_boots"), SCULK_BOOTS);
        Registry.register(Registry.ITEM, new Identifier(WardenLoot.MOD_ID, "sculk_sword"), SCULK_SWORD);
        Registry.register(Registry.ITEM, new Identifier(WardenLoot.MOD_ID, "sculk_pickaxe"), SCULK_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier(WardenLoot.MOD_ID, "sculk_axe"), SCULK_AXE);
        Registry.register(Registry.ITEM, new Identifier(WardenLoot.MOD_ID, "sculk_hoe"), SCULK_HOE);
        Registry.register(Registry.ITEM, new Identifier(WardenLoot.MOD_ID, "sculk_shovel"), SCULK_SHOVEL);

    }

    static {
        SCULK_INGOT = new Item(new FabricItemSettings().group(WardenLoot.WL_GROUP));
        SCULK_SOUL = new Item(new FabricItemSettings().group(WardenLoot.WL_GROUP));
        WARDEN_HEART = new Item(new FabricItemSettings().group(WardenLoot.WL_GROUP).rarity(Rarity.UNCOMMON));
        SCULK_HELMET = new WLArmorItem(WLArmorMaterial.SCULKERITE, EquipmentSlot.HEAD, new FabricItemSettings().fireproof().group(WardenLoot.WL_GROUP));
        SCULK_CHESTPLATE = new WLArmorItem(WLArmorMaterial.SCULKERITE, EquipmentSlot.CHEST, new FabricItemSettings().fireproof().group(WardenLoot.WL_GROUP));
        SCULK_LEGGINGS = new WLArmorItem(WLArmorMaterial.SCULKERITE, EquipmentSlot.LEGS, new FabricItemSettings().fireproof().group(WardenLoot.WL_GROUP));
        SCULK_BOOTS = new WLArmorItem(WLArmorMaterial.SCULKERITE, EquipmentSlot.FEET, new FabricItemSettings().fireproof().group(WardenLoot.WL_GROUP));
        SCULK_SWORD = new WLSwordItem(WLToolMaterial.SCULKERITE, 3, -2.4F, new FabricItemSettings().fireproof().group(WardenLoot.WL_GROUP));
        SCULK_PICKAXE = new WLPickaxeItem(WLToolMaterial.SCULKERITE, 0, -3, new FabricItemSettings().fireproof().group(WardenLoot.WL_GROUP));
        SCULK_AXE = new WLAxeItem(WLToolMaterial.SCULKERITE, 5, -3, new FabricItemSettings().fireproof().group(WardenLoot.WL_GROUP));
        SCULK_HOE = new WLHoeItem(WLToolMaterial.SCULKERITE, -4, 0, new FabricItemSettings().fireproof().group(WardenLoot.WL_GROUP));
        SCULK_SHOVEL = new WLShovelItem(WLToolMaterial.SCULKERITE, 1, -3, new FabricItemSettings().fireproof().group(WardenLoot.WL_GROUP));
    }
}
