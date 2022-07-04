package net.nu11une.wardenlootforge.register;

import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nu11une.wardenlootforge.WardenLootForge;
import net.nu11une.wardenlootforge.common.ModAxeItem;
import net.nu11une.wardenlootforge.common.ModPickaxeItem;
import net.nu11une.wardenlootforge.common.ModSwordItem;
import net.nu11une.wardenlootforge.common.ModToolMaterials;

public class ModTools {
    public static final DeferredRegister<Item> TOOLS = DeferredRegister.create(ForgeRegistries.ITEMS, WardenLootForge.MOD_ID);

    public static final RegistryObject<Item> SCULK_SWORD = TOOLS.register("sculk_sword", () -> new ModSwordItem(ModToolMaterials.SCULKERITE, 3, -2.4F, new Item.Properties().tab(WardenLootTab.WARDEN_LOOT_TAB).fireResistant()));
    public static final RegistryObject<Item> SCULK_PICKAXE = TOOLS.register("sculk_pickaxe", () -> new ModPickaxeItem(ModToolMaterials.SCULKERITE, 0, -3, new Item.Properties().tab(WardenLootTab.WARDEN_LOOT_TAB).fireResistant()));
    public static final RegistryObject<Item> SCULK_AXE = TOOLS.register("sculk_axe", () -> new ModAxeItem(ModToolMaterials.SCULKERITE, 5, -3, new Item.Properties().tab(WardenLootTab.WARDEN_LOOT_TAB).fireResistant()));
    public static final RegistryObject<Item> SCULK_HOE = TOOLS.register("sculk_hoe", () -> new HoeItem(ModToolMaterials.SCULKERITE, -4, 0, new Item.Properties().tab(WardenLootTab.WARDEN_LOOT_TAB).fireResistant()));
    public static final RegistryObject<Item> SCULK_SHOVEL = TOOLS.register("sculk_shovel", () -> new ShovelItem(ModToolMaterials.SCULKERITE, 1, -3, new Item.Properties().tab(WardenLootTab.WARDEN_LOOT_TAB).fireResistant()));

    public static void register(IEventBus eventBus){
        TOOLS.register(eventBus);
    }
}
