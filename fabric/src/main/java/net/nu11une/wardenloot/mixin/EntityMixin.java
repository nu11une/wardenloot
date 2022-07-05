package net.nu11une.wardenloot.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.nu11une.wardenloot.WardenLoot;
import net.nu11une.wardenloot.util.SoundHelper;
import net.nu11une.wardenloot.util.TrinketHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public class EntityMixin {

    @Inject(method = "playSound", at = @At("HEAD"), cancellable = true)
    public void playSoundCallback(SoundEvent sound, float volume, float pitch, CallbackInfo ci) {
        if(WardenLoot.isModLoaded("trinkets") && !WardenLoot.config.misc.trinketCosmeticOnly){
            Entity entity = (Entity) (Object) this;
            if(entity instanceof LivingEntity){
                LivingEntity livingEntity = (LivingEntity) (Object) this;
                for (PlayerEntity player : livingEntity.world.getPlayers()) {
                    if(TrinketHelper.canEcholocate(player)){
                        float distance = sound.getDistanceToTravel(volume) * 0.9F * WardenLoot.config.misc.trinketRangeMultiplier;
                        if(player.isInRange(entity, distance, distance * 0.7F)){
                            if(WardenLoot.config.misc.trinketClientOnly){
                                SoundHelper.entityMap.put(entity, 0);
                                SoundHelper.distanceMap.put(entity, distance);
                            } else {
                                livingEntity.setStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 60, 0, false, false, false), player);
                            }
                        }
                    }
                }
            }
        }
    }

    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    public void tickCallback(CallbackInfo ci) {
        Entity entity = (Entity) (Object) this;
        if(SoundHelper.entityMap.containsKey(entity)){
            int ticks = SoundHelper.entityMap.get(entity);
            if(ticks >= 60){
                SoundHelper.entityMap.remove(entity);
                SoundHelper.distanceMap.remove(entity);
            } else {
                ticks++;
                SoundHelper.entityMap.replace(entity, ticks);
            }
        }
    }
}
