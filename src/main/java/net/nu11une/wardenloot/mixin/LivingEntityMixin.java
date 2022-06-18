package net.nu11une.wardenloot.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.nu11une.wardenloot.core.WLHelmet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @Inject(method = "setStatusEffect", at = @At("TAIL"), cancellable = true)
    public void setStatusEffectCallback(CallbackInfo ci) {
        LivingEntity entity = (LivingEntity) (Object) this;
        setEffect(entity);
    }

    @Inject(method = "addStatusEffect", at = @At("TAIL"), cancellable = true)
    public void addStatusEffectCallback(CallbackInfoReturnable<Boolean> cir) {
        LivingEntity entity = (LivingEntity) (Object) this;
        setEffect(entity);
    }

    @Inject(method = "onEquipStack", at = @At("HEAD"), cancellable = true)
    public void onEquipStackCallback(CallbackInfo ci) {
        LivingEntity entity = (LivingEntity) (Object) this;
        setEffect(entity);
    }

    public void setEffect(LivingEntity entity) {
        if(entity instanceof PlayerEntity){
            for (ItemStack stack : entity.getArmorItems()) {
                Item item = stack.getItem();
                if (item.equals(WLHelmet.SCULK_HELMET)) {
                    entity.removeStatusEffect(StatusEffects.DARKNESS);
                }
            }
        }
    }
}