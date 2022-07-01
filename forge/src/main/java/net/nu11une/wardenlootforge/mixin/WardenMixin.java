package net.nu11une.wardenlootforge.mixin;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Unit;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.nu11une.wardenlootforge.common.ModArmorItem;
import net.nu11une.wardenlootforge.register.ModChestplate;
import net.nu11une.wardenlootforge.register.ModItems;
import net.nu11une.wardenlootforge.util.Settings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Warden.class)
public abstract class WardenMixin {
    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    private void WardenEntity_tick(CallbackInfo ci) {
        Warden warden = (Warden) (Object) this;
        LivingEntity target = warden.getTarget();
        if(warden.getCombatTracker().getKiller() != target && target instanceof Player){
            int armorCount = 0;
            int armorTotal = 0;
            if(Settings.chestplate){
                armorTotal +=1;
            }
            if(Settings.helmetleggingsboots){
                armorTotal += 3;
            }
            for (ItemStack stack : target.getArmorSlots()) {
                Item item = stack.getItem();
                if (item instanceof ModArmorItem) {
                    armorCount += 1;
                }
            }
            if(armorCount == armorTotal && armorCount > 0) {
                warden.clearAnger(target);
                warden.getBrain().setMemoryWithExpiry(MemoryModuleType.DIG_COOLDOWN, Unit.INSTANCE, 0L);
                if(target instanceof ServerPlayer){
                    ItemStack stack;
                    if(Settings.chestplate){
                        stack = new ItemStack(ModChestplate.SCULK_CHESTPLATE.get());
                    } else {
                        stack = new ItemStack(ModItems.SCULK_INGOT.get());
                    }
                    CriteriaTriggers.USED_TOTEM.trigger((ServerPlayer) target, stack);
                }
            }
        }
    }
}
