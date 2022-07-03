package net.nu11une.wardenloot.common;

import net.minecraft.item.ArmorMaterial;
import java.util.function.Supplier;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;
import net.nu11une.wardenloot.WardenLoot;
import net.nu11une.wardenloot.register.WLItems;
import net.nu11une.wardenloot.util.ModConfig;

public enum WLArmorMaterial implements ArmorMaterial {
    SCULKERITE("sculkerite", 43, new int[]{WardenLoot.config.stats.armorBaseProtection, (3 + WardenLoot.config.stats.armorBaseProtection), (6 + WardenLoot.config.stats.armorBaseProtection), WardenLoot.config.stats.armorBaseProtection}, 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, WardenLoot.config.stats.armorToughness, 0.15F, () -> {
        return Ingredient.ofItems(WLItems.SCULK_INGOT);
    }),
    SCULKERITE_COMPAT("sculkerite_compat", 43, new int[]{WardenLoot.config.stats.armorBaseProtection, (3 + WardenLoot.config.stats.armorBaseProtection), (6 + WardenLoot.config.stats.armorBaseProtection), WardenLoot.config.stats.armorBaseProtection}, 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, WardenLoot.config.stats.armorToughness, 0.15F, () -> {
        return Ingredient.ofItems(WLItems.SCULK_INGOT);
    }),
    SCULKERITE_UNCHARGED("sculkerite_uncharged", 43, new int[]{WardenLoot.config.stats.armorBaseProtection, (3 + WardenLoot.config.stats.armorBaseProtection), WardenLoot.config.stats.armorBaseProtection, WardenLoot.config.stats.armorBaseProtection}, 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, (WardenLoot.config.stats.armorToughness / 2), 0.05F, () -> {
        return Ingredient.ofItems(WLItems.SCULK_INGOT);
    });
    private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Lazy repairIngredientSupplier;

    private WLArmorMaterial(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier repairIngredientSupplier) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredientSupplier = new Lazy(repairIngredientSupplier);
    }

    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * this.durabilityMultiplier;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return this.protectionAmounts[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredientSupplier.get();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
