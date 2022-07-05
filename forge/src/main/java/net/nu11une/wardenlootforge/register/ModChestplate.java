package net.nu11une.wardenlootforge.register;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nu11une.wardenlootforge.WardenLootForge;
import net.nu11une.wardenlootforge.common.ModArmorItem;
import net.nu11une.wardenlootforge.common.ModArmorMaterials;
import net.nu11une.wardenlootforge.common.WardenBloodItem;
import net.nu11une.wardenlootforge.util.Settings;

public class ModChestplate {
    public static final DeferredRegister<Item> CHESTPLATE = DeferredRegister.create(ForgeRegistries.ITEMS, WardenLootForge.MOD_ID);
    public static final DeferredRegister<Item> WARDEN_BLOOD_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, WardenLootForge.MOD_ID);

    public static final RegistryObject<Item> WARDEN_BLOOD = WARDEN_BLOOD_ITEMS.register("warden_blood", () -> new WardenBloodItem(new Item.Properties().tab(WardenLootTab.WARDEN_LOOT_TAB).rarity(Rarity.UNCOMMON).food(new
            FoodProperties.Builder()
            .alwaysEat()
            .effect(new MobEffectInstance(MobEffects.BLINDNESS, 1200), 1)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 3), 1)
            .effect(new MobEffectInstance(ModEffects.ECHOLOCATE.get(), 1200, 0, false, false), 1)
            .build())));
    public static final RegistryObject<Item> SCULK_CHESTPLATE = CHESTPLATE.register("sculk_chestplate", () -> new ModArmorItem(Settings.getMaterial(), EquipmentSlot.CHEST, new Item.Properties().tab(WardenLootTab.WARDEN_LOOT_TAB).fireResistant()));
    public static final RegistryObject<Item> SCULK_CHESTPLATE_UNCHARGED = CHESTPLATE.register("sculk_chestplate_uncharged", () -> new ModArmorItem(ModArmorMaterials.SCULKERITE_UNCHARGED, EquipmentSlot.CHEST, new Item.Properties().fireResistant()));

    public static void register(IEventBus eventBus){
        CHESTPLATE.register(eventBus);
    }

    public static void registerBlood(IEventBus eventBus){
        WARDEN_BLOOD_ITEMS.register(eventBus);
    }
}
