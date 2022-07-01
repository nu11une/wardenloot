package net.nu11une.wardenlootforge.util;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = "wardenlootforge")
public class ModConfig implements ConfigData {

    @Comment("Determines whether the given item(s) will be loaded into the game on launch")
    @ConfigEntry.Category("registry")
    @ConfigEntry.Gui.TransitiveObject
    public Registry registry = new Registry();

    public static class Registry {
        public boolean registerTools = true;
        public boolean registerChestplate = true;
        public boolean registerHelmetLeggingsBoots = true;
        public boolean registerWardenBaneEnchantment = true;
    }

    @ConfigEntry.Category("stats")
    @ConfigEntry.Gui.TransitiveObject
    public Stats stats = new Stats();

    public static class Stats {
        public int toolMiningLevel = 4;
        public int toolDurability = 3070;
        public float toolSpeed = 12;
        public float toolBaseDamage = 8;
        public int armorBaseProtection = 8;
        public float armorToughness = 4;
        public float wardenBaneEnchantmentMultiplier = 1;
    }

    @ConfigEntry.Category("lootTables")
    @ConfigEntry.Gui.TransitiveObject
    public LootTables lootTables = new LootTables();

    public static class LootTables {
        public boolean sculkDropsSoul = true;
        @Comment("0.006 = 0.6%")
        public float soulChanceFromSculk = 0.006F;
        public boolean ancientCityHasModLoot = true;
        public boolean wardenDropsModLoot = true;
        public boolean wardenKillsDropSoul = true;
    }

    @ConfigEntry.Category("misc")
    @ConfigEntry.Gui.TransitiveObject
    public Misc misc = new Misc();

    public static class Misc {
        public boolean trinketCosmeticOnly = false;
        public float trinketRangeMultiplier = 1;
        @Comment("Set this to false if the armor animation is failing due to an incompatibility")
        boolean animateArmor = true;
    }
}
