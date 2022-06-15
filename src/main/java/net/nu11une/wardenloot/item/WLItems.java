package net.nu11une.wardenloot.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.nu11une.wardenloot.WardenLoot;
import net.nu11une.wardenloot.item.extension.*;
import net.nu11une.wardenloot.item.material.WLArmorMaterial;
import net.nu11une.wardenloot.item.material.WLToolMaterial;

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
        SCULK_INGOT = new Item(new FabricItemSettings());
        SCULK_SOUL = new Item(new FabricItemSettings());
        WARDEN_HEART = new Item(new FabricItemSettings());
        SCULK_HELMET = new WLArmorItem(WLArmorMaterial.SCULKERITE, EquipmentSlot.HEAD, new FabricItemSettings().fireproof());
        SCULK_CHESTPLATE = new WLArmorItem(WLArmorMaterial.SCULKERITE, EquipmentSlot.CHEST, new FabricItemSettings().fireproof());
        SCULK_LEGGINGS = new WLArmorItem(WLArmorMaterial.SCULKERITE, EquipmentSlot.LEGS, new FabricItemSettings().fireproof());
        SCULK_BOOTS = new WLArmorItem(WLArmorMaterial.SCULKERITE, EquipmentSlot.FEET, new FabricItemSettings().fireproof());
        SCULK_SWORD = new WLSwordItem(WLToolMaterial.SCULKERITE, 4, 1.6F, new FabricItemSettings().fireproof());
        SCULK_PICKAXE = new WLPickaxeItem(WLToolMaterial.SCULKERITE, 2, 1, new FabricItemSettings().fireproof());
        SCULK_AXE = new WLAxeItem(WLToolMaterial.SCULKERITE, 6, 1, new FabricItemSettings().fireproof());
        SCULK_HOE = new WLHoeItem(WLToolMaterial.SCULKERITE, -3, 4, new FabricItemSettings().fireproof());
        SCULK_SHOVEL = new WLShovelItem(WLToolMaterial.SCULKERITE, 2, 1, new FabricItemSettings().fireproof());
    }
}
