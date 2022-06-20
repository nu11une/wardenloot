package net.nu11une.wardenloot.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.nu11une.wardenloot.WardenLoot;
import net.nu11une.wardenloot.util.TrinketHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public class EntityMixin {

    @Inject(method = "playSound", at = @At("HEAD"), cancellable = true)
    public void playSoundCallback(SoundEvent sound, float volume, float pitch, CallbackInfo ci) {
        if(WardenLoot.isModLoaded("trinkets")){
            Entity entity = (Entity) (Object) this;
            if(entity instanceof LivingEntity){
                LivingEntity livingEntity = (LivingEntity) (Object) this;
                for (PlayerEntity player : livingEntity.world.getPlayers()) {
                    if(TrinketHelper.hasWardenTrinket(player)){
                        float distance = volume * 15.5F;
                        double playerX = player.getX();
                        double playerY = player.getY();
                        double playerZ = player.getZ();
                        double entityX = entity.getX();
                        double entityY = entity.getY();
                        double entityZ = entity.getZ();
                        if(Math.abs(Math.abs(playerX) - Math.abs(entityX)) < distance && Math.abs(Math.abs(playerY) - Math.abs(entityY)) < distance && Math.abs(Math.abs(playerZ) - Math.abs(entityZ)) < distance){
                            livingEntity.setStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 60, 1, false, false, false), player);
                        }
                    }
                }
            }
        }
    }
}
