package net.nu11une.wardenlootforge.register;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nu11une.wardenlootforge.WardenLootForge;
import net.nu11une.wardenlootforge.common.ModArmorItem;
import net.nu11une.wardenlootforge.common.ModArmorMaterials;
import net.nu11une.wardenlootforge.util.Settings;

public class ModLeggingsBoots {
    public static final DeferredRegister<Item> LEGGINGS_BOOTS = DeferredRegister.create(ForgeRegistries.ITEMS, WardenLootForge.MOD_ID);

    public static final RegistryObject<Item> SCULK_LEGGINGS = LEGGINGS_BOOTS.register("sculk_leggings", () -> new ModArmorItem(ModArmorMaterials.SCULKERITE, EquipmentSlot.LEGS, new Item.Properties().tab(WardenLootTab.WARDEN_LOOT_TAB).fireResistant()));
    public static final RegistryObject<Item> SCULK_BOOTS = LEGGINGS_BOOTS.register("sculk_boots", () -> new ModArmorItem(Settings.getMaterial(), EquipmentSlot.FEET, new Item.Properties().tab(WardenLootTab.WARDEN_LOOT_TAB).fireResistant()));

    public static void register(IEventBus eventBus){
        LEGGINGS_BOOTS.register(eventBus);
    }
}
