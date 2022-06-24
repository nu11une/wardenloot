package net.nu11une.wardenloot.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Unit;
import net.nu11une.wardenloot.WardenLoot;
import net.nu11une.wardenloot.common.WLArmorItem;
import net.nu11une.wardenloot.util.ModConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WardenEntity.class)
public abstract class WardenEntityMixin {
    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    private void WardenEntity_tick(CallbackInfo ci) {
        WardenEntity warden = (WardenEntity) (Object) this;
        LivingEntity target = warden.getTarget();
        if(warden.getDamageTracker().getBiggestAttacker() != target && target instanceof PlayerEntity){
            int armorCount = 0;
            int armorTotal = 0;
            if(WardenLoot.config.registry.registerChestplate){
                armorTotal +=1;
            }
            if(WardenLoot.config.registry.registerHelmetLeggingsBoots){
                armorTotal += 3;
            }
            for (ItemStack stack : target.getArmorItems()) {
                Item item = stack.getItem();
                if (item instanceof WLArmorItem) {
                    armorCount += 1;
                }
            }
            if(armorCount == armorTotal && armorCount > 0) {
                warden.removeSuspect(target);
                warden.getBrain().remember(MemoryModuleType.DIG_COOLDOWN, Unit.INSTANCE, 0L);
            }
        }
    }
}

