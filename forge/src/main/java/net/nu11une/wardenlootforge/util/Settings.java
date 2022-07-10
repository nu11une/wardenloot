package net.nu11une.wardenlootforge.util;

import net.minecraftforge.fml.ModList;
import net.nu11une.wardenlootforge.WardenLootForge;
import net.nu11une.wardenlootforge.common.ModArmorMaterials;

public class Settings {
    static ModConfig.Registry registry = WardenLootForge.config.registry;
    public static boolean tools = registry.registerTools;
    public static boolean chestplate = registry.registerChestplate;
    public static boolean helmetleggingsboots = registry.registerHelmetLeggingsBoots;
    public static boolean enchantment = registry.registerWardenBaneEnchantment;
    static ModConfig.Stats stats = WardenLootForge.config.stats;
    public static int level = stats.toolMiningLevel;
    public static int durability = stats.toolDurability;
    public static float speed = stats.toolSpeed;
    public static float damage = stats.toolBaseDamage;
    public static int protection = stats.armorBaseProtection;
    public static float toughness = stats.armorToughness;
    public static float enchantMultiplier = stats.wardenBaneEnchantmentMultiplier;
    static ModConfig.LootTables tables = WardenLootForge.config.lootTables;
    public static boolean dropsSoul = tables.sculkDropsSoul;
    public static float soulChance = tables.soulChanceFromSculk;
    public static boolean cityLoot = tables.ancientCityHasModLoot;
    public static boolean wardenLoot = tables.wardenDropsModLoot;
    public static boolean killLoot = tables.wardenKillsDropSoul;
    static ModConfig.Misc misc = WardenLootForge.config.misc;
    public static boolean trinketClient = WardenLootForge.config.misc.trinketClientOnly;
    public static boolean cosmetic = misc.trinketCosmeticOnly;
    public static float range = misc.trinketRangeMultiplier;
    public static boolean animate = misc.animateArmor;

    public static ModArmorMaterials getMaterial(){
        if(!Settings.animate || !ModList.get().isLoaded("moremcmeta")){
            return ModArmorMaterials.SCULKERITE_COMPAT;
        }
        return ModArmorMaterials.SCULKERITE;
    }
}
