package net.nu11une.wardenloot.util;

import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.nu11une.wardenloot.WardenLoot;

public class WLToolTip {
    public static final MutableText WARDEN_SET_BONUS = Text.translatable("tooltip."+ WardenLoot.MOD_ID+".armor.warden_fear_set").formatted(Formatting.DARK_AQUA);
    public static final MutableText WARDEN_BONUS = Text.translatable("tooltip."+ WardenLoot.MOD_ID+".armor.warden_fear").formatted(Formatting.DARK_AQUA);
    public static final MutableText COLD_HEART = Text.translatable("tooltip."+ WardenLoot.MOD_ID+".armor.cold_heart").formatted(Formatting.DARK_PURPLE);
    public static final MutableText DARKNESS_IMMUNITY_BONUS = Text.translatable("tooltip."+ WardenLoot.MOD_ID+".armor.darkness_immunity").formatted(Formatting.DARK_GRAY);
    public static final MutableText INFLICT_DARKNESS = Text.translatable("tooltip."+ WardenLoot.MOD_ID+".weapon.inflict_darkness").formatted(Formatting.DARK_GRAY);
    public static final MutableText DEEPSLATE_MINER = Text.translatable("tooltip."+ WardenLoot.MOD_ID+".tool.deepslate_miner").formatted(Formatting.DARK_GRAY);
    public static final MutableText TRINKET_ECHOLOCATE = Text.translatable("tooltip."+ WardenLoot.MOD_ID+".trinket.warden_ears").formatted(Formatting.DARK_AQUA);
}
