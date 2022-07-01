package net.nu11une.wardenlootforge.register;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nu11une.wardenlootforge.WardenLootForge;
import net.nu11une.wardenlootforge.common.WardenEarsItem;

public class ModTrinkets {
    public static final DeferredRegister<Item> TRINKET_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, WardenLootForge.MOD_ID);

    public static final RegistryObject<Item> WARDEN_EARS_TRINKET = TRINKET_ITEMS.register("warden_ears_trinket", () -> new WardenEarsItem(new Item.Properties().tab(WardenLootTab.WARDEN_LOOT_TAB).rarity(Rarity.UNCOMMON).stacksTo(1)));

    public static void register(IEventBus eventBus){
        TRINKET_ITEMS.register(eventBus);
    }
}
