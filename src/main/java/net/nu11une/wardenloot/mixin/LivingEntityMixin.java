package net.nu11une.wardenloot.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.WardenEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.nu11une.wardenloot.WardenLoot;
import net.nu11une.wardenloot.register.WLHelmet;
import net.nu11une.wardenloot.register.WLItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "setStatusEffect", at = @At("TAIL"), cancellable = true)
    public void setStatusEffectCallback(CallbackInfo ci) {
        setEffect();
    }

    @Inject(method = "addStatusEffect", at = @At("TAIL"), cancellable = true)
    public void addStatusEffectCallback(CallbackInfoReturnable<Boolean> cir) {
        setEffect();
    }

    @Inject(method = "onEquipStack", at = @At("HEAD"), cancellable = true)
    public void onEquipStackCallback(CallbackInfo ci) {
        setEffect();
    }

    @Inject(method = "onDeath", at = @At("HEAD"), cancellable = true)
    public void onDeathCallback(DamageSource damageSource, CallbackInfo ci){
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        Entity entity = damageSource.getAttacker();
        if(WardenLoot.config.lootTables.wardenKillsDropSoul){
            if(entity instanceof WardenEntity){
                if(livingEntity instanceof PlayerEntity){
                    if(Math.random() <= 0.2){
                        this.dropStack(new ItemStack(WLItems.SCULK_SOUL));
                    }
                } else if(Math.random() <= 0.05) {
                    this.dropStack(new ItemStack(WLItems.SCULK_SOUL));
                }
            }
        }
    }

    public void setEffect() {
        LivingEntity entity = (LivingEntity) (Object) this;
        if(WardenLoot.config.registry.registerHelmetLeggingsBoots){
            if(entity instanceof PlayerEntity){
                for (ItemStack stack : entity.getArmorItems()) {
                    Item item = stack.getItem();
                    if (item.equals(WLHelmet.SCULK_HELMET)) {
                        entity.removeStatusEffect(StatusEffects.DARKNESS);
                    }
                }
            }
        }
    }
}