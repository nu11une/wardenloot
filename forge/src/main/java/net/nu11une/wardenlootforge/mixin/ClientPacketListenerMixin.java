package net.nu11une.wardenlootforge.mixin;

import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.nu11une.wardenlootforge.register.ModChestplate;
import net.nu11une.wardenlootforge.util.Settings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientPacketListener.class)
public class ClientPacketListenerMixin {
    @Inject(method = "findTotem", at = @At("HEAD"), cancellable = true)
    private static void getActiveTotemOfUndyingCallback(Player player, CallbackInfoReturnable<ItemStack> cir) {
        if(Settings.chestplate){
            for (ItemStack stack : player.getArmorSlots()) {
                Item item = stack.getItem();
                if (item.equals(ModChestplate.SCULK_CHESTPLATE.get())) {
                    cir.setReturnValue(stack);
                }
            }
        }
    }
}
