package net.nu11une.wardenlootforge.mixin;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.fml.ModList;
import net.nu11une.wardenlootforge.WardenLootForge;
import net.nu11une.wardenlootforge.register.ModEffects;
import net.nu11une.wardenlootforge.util.Settings;
import net.nu11une.wardenlootforge.util.SoundHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public class EntityMixin {
    @Inject(method = "playSound", at = @At("HEAD"), cancellable = true)
    public void playSoundCallback(SoundEvent sound, float volume, float pitch, CallbackInfo ci) {
        if(ModList.get().isLoaded("curios")){
            Entity entity = (Entity) (Object) this;
            if(entity instanceof LivingEntity){
                LivingEntity livingEntity = (LivingEntity) (Object) this;
                for (Player player : livingEntity.level.players()) {
                    if((WardenLootForge.tendrilEntities.contains(player)||player.hasEffect(ModEffects.ECHOLOCATE.get())) && !Settings.cosmetic){
                        float distance = sound.getRange(volume) * 0.9F * Settings.range;
                        if(player.closerThan(entity, distance, distance * 0.7F)){
                            if(Settings.trinketClient){
                                SoundHelper.entityMap.put(entity, 0);
                                SoundHelper.distanceMap.put(entity, distance);
                            } else {
                                livingEntity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 60, 1, false, false, false), player);
                            }
                        }
                    }
                }
            }
        }
    }

    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    public void tickCallback(CallbackInfo ci){
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
