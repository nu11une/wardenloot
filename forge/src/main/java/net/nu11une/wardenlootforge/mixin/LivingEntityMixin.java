package net.nu11une.wardenlootforge.mixin;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.nu11une.wardenlootforge.register.ModChestplate;
import net.nu11une.wardenlootforge.register.ModHelmet;
import net.nu11une.wardenlootforge.register.ModItems;
import net.nu11une.wardenlootforge.util.Settings;
import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    public LivingEntityMixin(EntityType<?> type, Level level){
        super(type, level);
    }

    @Inject(method = "addEffect(Lnet/minecraft/world/effect/MobEffectInstance;Lnet/minecraft/world/entity/Entity;)Z", at = @At("TAIL"), cancellable = true)
    public void setStatusEffectCallback(MobEffectInstance p_147208_, Entity p_147209_, CallbackInfoReturnable<Boolean> cir) {
        setEffect();
    }

    @Inject(method = "addEffect(Lnet/minecraft/world/effect/MobEffectInstance;)Z", at = @At("TAIL"), cancellable = true)
    public void addStatusEffectCallback(MobEffectInstance p_21165_, CallbackInfoReturnable<Boolean> cir) {
        setEffect();
    }

    @Inject(method = "forceAddEffect", at = @At("TAIL"), cancellable = true)
    public void forceStatusEffectCallback(MobEffectInstance p_147216_, Entity p_147217_, CallbackInfo ci) {
        setEffect();
    }

    @Inject(method = "onEquipItem", at = @At("TAIL"), cancellable = true)
    public void onEquipItemCallback(CallbackInfo ci) {
        setEffect();
    }

    @Inject(method = "die", at = @At("TAIL"), cancellable = true)
    public void onDeathCallback(DamageSource damageSource, CallbackInfo ci){
        if(Settings.killLoot){
            LivingEntity livingEntity = (LivingEntity) (Object) this;
            Entity entity = damageSource.getEntity();
            if(entity instanceof Warden){
                if(livingEntity instanceof Player){
                    if(Math.random() <= 0.2){
                        this.spawnAtLocation(new ItemStack(ModItems.SCULK_SOUL.get()));
                    }
                } else if(Math.random() <= 0.05) {
                    this.spawnAtLocation(new ItemStack(ModItems.SCULK_SOUL.get()));
                }
            }
        }
    }

    @Inject(method = "checkTotemDeathProtection", at = @At("TAIL"), cancellable = true)
    private void tryUseTotem(DamageSource source, CallbackInfoReturnable<Boolean> cir) {
        if(Settings.chestplate){
            LivingEntity livingEntity = (LivingEntity) (Object) this;
            if (source.isBypassInvul()) {
                cir.setReturnValue(false);
            } else {
                ItemStack itemStack = null;

                if(livingEntity instanceof Player){
                    Player player = (Player) (Object) this;
                    for (ItemStack stack : player.getArmorSlots()) {
                        Item item = stack.getItem();
                        if (item.equals(ModChestplate.SCULK_CHESTPLATE.get())) {
                            ItemStack newStack = new ItemStack(ModChestplate.SCULK_CHESTPLATE_UNCHARGED.get());
                            newStack.setHoverName(stack.getHoverName());
                            newStack.setDamageValue(stack.getDamageValue());
                            newStack.setTag(stack.getTag());

                            itemStack = stack.copy();
                            stack.shrink(1);
                            player.setItemSlot(EquipmentSlot.CHEST, newStack);
                            break;
                        }
                    }
                }

                if (itemStack != null) {
                    if (livingEntity instanceof ServerPlayer) {
                        ServerPlayer serverPlayerEntity = (ServerPlayer)livingEntity;
                        serverPlayerEntity.awardStat(Stats.ITEM_USED.get(ModChestplate.SCULK_CHESTPLATE.get()));
                        CriteriaTriggers.USED_TOTEM.trigger(serverPlayerEntity, new ItemStack(ModChestplate.SCULK_CHESTPLATE_UNCHARGED.get()));
                    }

                    livingEntity.setHealth(1.0F);
                    livingEntity.removeAllEffects();
                    livingEntity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 900, 1));
                    livingEntity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100, 1));
                    livingEntity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 800, 0));
                    livingEntity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 600, 0));
                    livingEntity.level.broadcastEntityEvent(this, (byte)35);
                    cir.setReturnValue(true);
                }
            }
        }
    }

    public void setEffect() {
        if(Settings.helmetleggingsboots){
            LivingEntity entity = (LivingEntity) (Object) this;
            if(entity instanceof Player){
                for (ItemStack stack : entity.getArmorSlots()) {
                    Item item = stack.getItem();
                    if (item.equals(ModHelmet.SCULK_HELMET.get())) {
                        entity.removeEffect(MobEffects.DARKNESS);
                    }
                }
            }
        }
    }
}
