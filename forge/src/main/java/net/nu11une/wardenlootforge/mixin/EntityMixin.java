package net.nu11une.wardenlootforge.mixin;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.fml.ModList;
import net.nu11une.wardenlootforge.WardenLootForge;
import net.nu11une.wardenlootforge.util.Settings;
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
                    if(WardenLootForge.tendrilEntities.contains(player) && !Settings.cosmetic){
                        float distance = volume * 15F * Settings.range;
                        double playerX = player.getX();
                        double playerY = player.getY();
                        double playerZ = player.getZ();
                        double entityX = entity.getX();
                        double entityY = entity.getY();
                        double entityZ = entity.getZ();
                        if(Math.abs(Math.abs(playerX) - Math.abs(entityX)) < distance && Math.abs(Math.abs(playerY) - Math.abs(entityY)) < distance && Math.abs(Math.abs(playerZ) - Math.abs(entityZ)) < distance){
                            livingEntity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 60, 1, false, false, false), player);
                        }
                    }
                }
            }
        }
    }
}
