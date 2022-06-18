package net.nu11une.wardenloot.mixin;

import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.nu11une.wardenloot.core.WLHelmet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {
    @Inject(at = @At("HEAD"), method = "tick", cancellable = true)
    private void PlayerEntity_tick(CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity) (Object) this;
        for (ItemStack stack : player.getArmorItems()) {
            Item item = stack.getItem();
            if (item.equals(WLHelmet.SCULK_HELMET)) {
                player.removeStatusEffect(StatusEffects.DARKNESS);
            }
        }
    }
}
