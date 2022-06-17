package net.nu11une.wardenloot.util;

import com.mojang.datafixers.util.Pair;
import net.nu11une.wardenloot.WardenLoot;

public class ModConfigs {
    public static SimpleConfig CONFIG;
    private static ModConfigProvider configs;

    // Registry
    public static boolean REGISTER_TOOLS;
    public static boolean REGISTER_CHESTPLATE;
    public static boolean REGISTER_HELMET_LEGGINGS_BOOTS;

    // Tool Material
    public static int MINING_LEVEL;
    public static int DURABILITY;
    public static float MINING_SPEED;
    public static float BASE_ATTACK_DAMAGE;

    // Armor Material
    public static int BASE_ARMOR_PROTECTION;
    public static float ARMOR_TOUGHNESS;

    // Warden Damage Enchantment
    public static boolean REGISTER_WARDEN_DAMAGE_ENCHANTMENT;
    public static float WARDEN_DAMAGE_ENCHANTMENT_MULTIPLIER;

    // Loot Tables
    public static boolean SCULK_DROPS_SOUL;
    public static float SCULK_SOUL_DROP_CHANCE;
    public static boolean ANCIENT_CITY_HAS_MOD_LOOT;

    public static void registerConfigs() {
        configs = new ModConfigProvider();
        createConfigs();
        CONFIG = SimpleConfig.of(WardenLoot.MOD_ID).provider(configs).request();
        assignConfigs();
    }

    private static void createConfigs() {
        configs.addKeyValuePair(new Pair<>("register.tools", true), "boolean");
        configs.addKeyValuePair(new Pair<>("register.chestplate", true), "boolean");
        configs.addKeyValuePair(new Pair<>("register.helmetleggingsboots", true), "boolean");
        configs.addKeyValuePair(new Pair<>("tool.level", 4), "int");
        configs.addKeyValuePair(new Pair<>("tool.durability", 3070), "int");
        configs.addKeyValuePair(new Pair<>("tool.speed", 12), "float");
        configs.addKeyValuePair(new Pair<>("tool.base.damage", 8), "float");
        configs.addKeyValuePair(new Pair<>("base.armor.protection", 8), "int");
        configs.addKeyValuePair(new Pair<>("armor.toughness", 4), "float");
        configs.addKeyValuePair(new Pair<>("register.bane.depth.keeper.enchantment", true), "boolean");
        configs.addKeyValuePair(new Pair<>("bane.depth.keeper.enchantment.damage.multiplier", 1), "float");
        configs.addKeyValuePair(new Pair<>("sculk.drops.soul", true), "boolean");
        configs.addKeyValuePair(new Pair<>("soul.chance.from.sculk", 0.006), "float (chance out of 1)");
        configs.addKeyValuePair(new Pair<>("ancient.city.has.mod.loot", true), "boolean");
    }

    private static void assignConfigs() {
        REGISTER_TOOLS = CONFIG.getOrDefault("register.tools", true);
        REGISTER_CHESTPLATE = CONFIG.getOrDefault("register.chestplate", true);
        REGISTER_HELMET_LEGGINGS_BOOTS = CONFIG.getOrDefault("register.helmetleggingsboots", true);
        MINING_LEVEL = CONFIG.getOrDefault("tool.level", 4);
        DURABILITY = CONFIG.getOrDefault("tool.durability", 3070);
        MINING_SPEED = (float) CONFIG.getOrDefault("tool.speed", 12);
        BASE_ATTACK_DAMAGE = (float) CONFIG.getOrDefault("tool.base.damage", 8);
        BASE_ARMOR_PROTECTION = CONFIG.getOrDefault("base.armor.protection", 8);
        ARMOR_TOUGHNESS = (float) CONFIG.getOrDefault("armor.toughness", 4);
        REGISTER_WARDEN_DAMAGE_ENCHANTMENT = CONFIG.getOrDefault("register.bane.depth.keeper.enchantment", true);
        WARDEN_DAMAGE_ENCHANTMENT_MULTIPLIER = (float) CONFIG.getOrDefault("bane.depth.keeper.enchantment.damage.multiplier", 1);
        SCULK_DROPS_SOUL = CONFIG.getOrDefault("sculk.drops.soul", true);
        SCULK_SOUL_DROP_CHANCE = (float) CONFIG.getOrDefault("soul.chance.from.sculk", 0.006);
        ANCIENT_CITY_HAS_MOD_LOOT = CONFIG.getOrDefault("ancient.city.has.mod.loot", true);
        System.out.println("All " + configs.getConfigsList().size() + " have been set properly");
    }
}
