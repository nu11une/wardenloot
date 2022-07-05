package net.nu11une.wardenlootforge.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.Entity;
import net.nu11une.wardenlootforge.WardenLootForge;
import net.nu11une.wardenlootforge.util.SoundHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nullable;

@Mixin(Minecraft.class)
public class MinecraftClientMixin {
    @Shadow @Nullable public LocalPlayer player;

    @Inject(method = "shouldEntityAppearGlowing", at = @At("HEAD"), cancellable = true)
    public void shouldEntityAppearGlowingCallback(Entity entity, CallbackInfoReturnable<Boolean> cir){
        if(SoundHelper.entityMap.containsKey(entity) && SoundHelper.distanceMap.containsKey(entity)){
            assert this.player != null;
            float distance = SoundHelper.distanceMap.get(entity);
            if(this.player.closerThan(entity, distance, distance * 0.7F) && WardenLootForge.tendrilEntities.contains(this.player)){
                cir.setReturnValue(true);
            }
        }
    }
}
