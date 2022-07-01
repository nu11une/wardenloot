package net.nu11une.wardenlootforge.register;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nu11une.wardenlootforge.WardenLootForge;
import net.nu11une.wardenlootforge.common.ModArmorItem;
import net.nu11une.wardenlootforge.util.Settings;

public class ModHelmet {
    public static final DeferredRegister<Item> HELMET = DeferredRegister.create(ForgeRegistries.ITEMS, WardenLootForge.MOD_ID);

    public static final RegistryObject<Item> SCULK_HELMET = HELMET.register("sculk_helmet", () -> new ModArmorItem(Settings.getMaterial(), EquipmentSlot.HEAD, new Item.Properties().tab(WardenLootTab.WARDEN_LOOT_TAB).fireResistant()));

    public static void register(IEventBus eventBus){
        HELMET.register(eventBus);
    }
}
