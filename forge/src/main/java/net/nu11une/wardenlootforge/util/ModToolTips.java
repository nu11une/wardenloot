package net.nu11une.wardenlootforge.util;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.nu11une.wardenlootforge.WardenLootForge;

public class ModToolTips {
    public static final MutableComponent WARDEN_SET_BONUS = Component.translatable("tooltip."+ WardenLootForge.MOD_ID+".armor.warden_fear_set").withStyle(ChatFormatting.DARK_AQUA);
    public static final MutableComponent WARDEN_BONUS = Component.translatable("tooltip."+ WardenLootForge.MOD_ID+".armor.warden_fear").withStyle(ChatFormatting.DARK_AQUA);
    public static final MutableComponent COLD_HEART = Component.translatable("tooltip."+ WardenLootForge.MOD_ID+".armor.cold_heart").withStyle(ChatFormatting.DARK_PURPLE);
    public static final MutableComponent DARKNESS_IMMUNITY_BONUS = Component.translatable("tooltip."+ WardenLootForge.MOD_ID+".armor.darkness_immunity").withStyle(ChatFormatting.DARK_GRAY);
    public static final MutableComponent INFLICT_DARKNESS = Component.translatable("tooltip."+ WardenLootForge.MOD_ID+".weapon.inflict_darkness").withStyle(ChatFormatting.DARK_GRAY);
    public static final MutableComponent DEEPSLATE_MINER = Component.translatable("tooltip."+ WardenLootForge.MOD_ID+".tool.deepslate_miner").withStyle(ChatFormatting.DARK_GRAY);
    public static final MutableComponent TRINKET_ECHOLOCATE = Component.translatable("tooltip."+ WardenLootForge.MOD_ID+".trinket.warden_ears").withStyle(ChatFormatting.DARK_AQUA);
}
