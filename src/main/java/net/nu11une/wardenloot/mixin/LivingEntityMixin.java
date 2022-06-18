package net.nu11une.wardenloot.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.nu11une.wardenloot.core.WLHelmet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @Inject(method = "setStatusEffect", at = @At("HEAD"), cancellable = true)
    public void setStatusEffectCallback(StatusEffectInstance effect, Entity source, CallbackInfo ci) {
        if (source != null) {
            if (setEffect(effect, source)) ci.cancel();
        }
    }

    @Inject(method = "addStatusEffect(Lnet/minecraft/entity/effect/StatusEffectInstance;Lnet/minecraft/entity/Entity;)Z", at = @At("HEAD"), cancellable = true)
    public void addStatusEffectCallback(StatusEffectInstance effect, Entity source, CallbackInfoReturnable<Boolean> cir) {
        if (source != null) {
            cir.setReturnValue(setEffect(effect, source));
        }
    }

    public boolean setEffect(StatusEffectInstance effect, Entity source) {
        if (source.isPlayer()) {
            if(source instanceof ServerPlayerEntity){
                for (ItemStack stack : source.getArmorItems()) {
                    Item item = stack.getItem();
                    if (item.equals(WLHelmet.SCULK_HELMET) && effect.getEffectType().equals(StatusEffects.DARKNESS)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
