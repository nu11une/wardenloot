package net.nu11une.wardenloot.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Unit;
import net.minecraft.world.World;
import net.minecraft.world.event.listener.VibrationListener;
import net.nu11une.wardenloot.common.WLArmorItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WardenEntity.class)
public abstract class WardenEntityMixin extends HostileEntity implements VibrationListener.Callback {

    protected WardenEntityMixin(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    private void WardenEntity_tick(CallbackInfo ci) {
        WardenEntity warden = (WardenEntity) (Object) this;
        LivingEntity target = warden.getTarget();
        if(warden.getDamageTracker().getBiggestAttacker() != target && target instanceof PlayerEntity){
            int armorCount = 0;
            for (ItemStack stack : target.getArmorItems()) {
                Item item = stack.getItem();
                if (item instanceof WLArmorItem) {
                    armorCount += 1;
                }
            }
            if(armorCount == 4) {
                warden.removeSuspect(target);
                warden.getBrain().remember(MemoryModuleType.DIG_COOLDOWN, Unit.INSTANCE, 0L);
            }
        }
    }
}

