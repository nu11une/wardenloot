package net.nu11une.wardenloot.mixin;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.WardenEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtElement;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.nu11une.wardenloot.WardenLoot;
import net.nu11une.wardenloot.register.WLChestplate;
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

    @Inject(method = "tryUseTotem", at = @At("HEAD"), cancellable = true)
    private void tryUseTotem(DamageSource source, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        if (source.isOutOfWorld()) {
            cir.setReturnValue(false);
        } else {
            ItemStack itemStack = null;

            if(livingEntity instanceof PlayerEntity){
                PlayerEntity player = (PlayerEntity) (Object) this;
                for (ItemStack stack : player.getArmorItems()) {
                    Item item = stack.getItem();
                    if (item.equals(WLChestplate.SCULK_CHESTPLATE)) {
                        ItemStack newStack = new ItemStack(WLChestplate.SCULK_CHESTPLATE_UNCHARGED);
                        newStack.setCustomName(stack.getName());
                        newStack.setDamage(stack.getDamage());
                        newStack.setNbt(stack.getNbt());

                        itemStack = stack.copy();
                        stack.decrement(1);
                        player.equipStack(EquipmentSlot.CHEST, newStack);
                        break;
                    }
                }
            }

            if (itemStack != null) {
                if (livingEntity instanceof ServerPlayerEntity) {
                    ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)livingEntity;
                    serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(WLChestplate.SCULK_CHESTPLATE));
                    Criteria.USED_TOTEM.trigger(serverPlayerEntity, new ItemStack(WLChestplate.SCULK_CHESTPLATE_UNCHARGED));
                }

                livingEntity.setHealth(1.0F);
                livingEntity.clearStatusEffects();
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 900, 1));
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 100, 1));
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 800, 0));
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 600, 0));
                livingEntity.world.sendEntityStatus(this, (byte)35);
                cir.setReturnValue(true);
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