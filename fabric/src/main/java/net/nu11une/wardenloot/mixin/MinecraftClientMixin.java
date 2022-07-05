package net.nu11une.wardenloot.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.nu11une.wardenloot.util.SoundHelper;
import net.nu11une.wardenloot.util.TrinketHelper;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
    @Shadow @Nullable public ClientPlayerEntity player;

    @Inject(method = "hasOutline", at = @At("HEAD"), cancellable = true)
    public void hasOutlineCallback(Entity entity, CallbackInfoReturnable<Boolean> cir){
        if(SoundHelper.entityMap.containsKey(entity) && SoundHelper.distanceMap.containsKey(entity)){
            assert this.player != null;
            float distance = SoundHelper.distanceMap.get(entity);
            if(this.player.isInRange(entity, distance, distance * 0.7F) && TrinketHelper.canEcholocate(this.player)){
                cir.setReturnValue(true);
            }
        }
    }
}
