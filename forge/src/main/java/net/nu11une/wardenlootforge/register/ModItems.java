package net.nu11une.wardenlootforge.register;

import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nu11une.wardenlootforge.WardenLootForge;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, WardenLootForge.MOD_ID);

    public static final RegistryObject<Item> SCULK_SOUL = ITEMS.register("sculk_soul", () -> new Item(new Item.Properties().tab(WardenLootTab.WARDEN_LOOT_TAB)));
    public static final RegistryObject<Item> SCULK_INGOT = ITEMS.register("sculk_ingot", () -> new Item(new Item.Properties().tab(WardenLootTab.WARDEN_LOOT_TAB).fireResistant()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
