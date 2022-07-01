package net.nu11une.wardenlootforge.common;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.nu11une.wardenlootforge.WardenLootForge;
import net.nu11une.wardenlootforge.register.ModItems;
import net.nu11une.wardenlootforge.util.Settings;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    SCULKERITE("sculkerite", 43, new int[]{Settings.protection, Settings.protection + 3, Settings.protection + 6, Settings.protection}, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, Settings.toughness, 0.15F, () -> {
        return Ingredient.of(ModItems.SCULK_INGOT.get());
    }),
    SCULKERITE_COMPAT("sculkerite_compat", 43, new int[]{Settings.protection, Settings.protection + 3, Settings.protection + 6, Settings.protection}, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, Settings.toughness, 0.15F, () -> {
        return Ingredient.of(ModItems.SCULK_INGOT.get());
    }),
    SCULKERITE_UNCHARGED("sculkerite_uncharged", 43, new int[]{8, 8, Settings.protection, 8}, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, Settings.toughness % 2, 0.05F, () -> {
        return Ingredient.of(ModItems.SCULK_INGOT.get());
    });

    private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] slotProtections;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    ModArmorMaterials(String name, int durabilityMultiplier, int[] slotProtections, int enchantmentValue, SoundEvent sound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.slotProtections = slotProtections;
        this.enchantmentValue = enchantmentValue;
        this.sound = sound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
    }

    public int getDurabilityForSlot(EquipmentSlot p_40484_) {
        return HEALTH_PER_SLOT[p_40484_.getIndex()] * this.durabilityMultiplier;
    }

    public int getDefenseForSlot(EquipmentSlot slot) {
        return this.slotProtections[slot.getIndex()];
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public SoundEvent getEquipSound() {
        return this.sound;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    public String getName() {
        return WardenLootForge.MOD_ID + ":" + this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
