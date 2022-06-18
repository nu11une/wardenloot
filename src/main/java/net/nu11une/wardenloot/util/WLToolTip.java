package net.nu11une.wardenloot.util;

import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.nu11une.wardenloot.WardenLoot;

/**
 * Author: Autovw
 */
public class WLToolTip {
    public static final MutableText WARDEN_SET_BONUS = Text.translatable("tooltip."+ WardenLoot.MOD_ID+".armor.warden_fear_set").formatted(Formatting.DARK_AQUA);
    public static final MutableText WARDEN_BONUS = Text.translatable("tooltip."+ WardenLoot.MOD_ID+".armor.warden_fear").formatted(Formatting.DARK_AQUA);
    public static final MutableText DARKNESS_IMMUNITY_BONUS = Text.translatable("tooltip."+ WardenLoot.MOD_ID+".armor.darkness_immunity").formatted(Formatting.DARK_BLUE);
}
