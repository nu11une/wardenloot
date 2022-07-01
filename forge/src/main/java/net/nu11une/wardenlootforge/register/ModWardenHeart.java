package net.nu11une.wardenlootforge.register;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nu11une.wardenlootforge.WardenLootForge;

public class ModWardenHeart {
    public static final DeferredRegister<Item> WARDEN_HEART_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, WardenLootForge.MOD_ID);

    public static final RegistryObject<Item> WARDEN_HEART = WARDEN_HEART_ITEMS.register("warden_heart", () -> new Item(new Item.Properties().tab(WardenLootTab.WARDEN_LOOT_TAB).rarity(Rarity.UNCOMMON)));

    public static void register(IEventBus eventBus){
        WARDEN_HEART_ITEMS.register(eventBus);
    }
}
