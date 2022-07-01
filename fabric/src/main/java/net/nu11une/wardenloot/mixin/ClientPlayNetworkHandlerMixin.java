package net.nu11une.wardenloot.mixin;

import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.nu11une.wardenloot.register.WLChestplate;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientPlayNetworkHandler.class)
public class ClientPlayNetworkHandlerMixin {
    @Inject(method = "getActiveTotemOfUndying", at = @At("HEAD"), cancellable = true)
    private static void getActiveTotemOfUndyingCallback(PlayerEntity player, CallbackInfoReturnable<ItemStack> cir) {
        for (ItemStack stack : player.getArmorItems()) {
            Item item = stack.getItem();
            if (item.equals(WLChestplate.SCULK_CHESTPLATE)) {
                cir.setReturnValue(stack);
            }
        }
    }
}
