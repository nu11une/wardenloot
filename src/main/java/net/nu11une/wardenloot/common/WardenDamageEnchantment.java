package net.nu11une.wardenloot.common;

import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.*;
import net.minecraft.entity.damage.DamageSource;
import net.nu11une.wardenloot.util.ModConfigs;

public class WardenDamageEnchantment extends DamageEnchantment {

    public WardenDamageEnchantment(Rarity weight, EquipmentSlot... slots) {
        super(weight, 3, slots);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity livingEntity) {
            if(livingEntity.getType().equals(EntityType.WARDEN)) {
                target.damage(DamageSource.sting(user), (10 + (level * 6)) * ModConfigs.WARDEN_DAMAGE_ENCHANTMENT_MULTIPLIER);
            }
        }
    }

    @Override
    public int getMinPower(int level) {
        return 5 + (level - 1) * 10;
    }

    @Override
    public int getMaxPower(int level) {
        return this.getMinPower(level) + 20;
    }

    @Override public boolean canAccept(Enchantment other) {
        return !(other instanceof WardenDamageEnchantment);
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return false;
    }

    @Override
    public boolean isAvailableForRandomSelection() {
        return false;
    }
}
