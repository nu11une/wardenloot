package net.nu11une.wardenloot.register;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.nu11une.wardenloot.WardenLoot;

public class WLItems {

    public static Item SCULK_INGOT;
    public static Item SCULK_SOUL;

    public static void registerWLItems() {
        Registry.register(Registry.ITEM, new Identifier(WardenLoot.MOD_ID, "sculk_ingot"), SCULK_INGOT);
        Registry.register(Registry.ITEM, new Identifier(WardenLoot.MOD_ID, "sculk_soul"), SCULK_SOUL);

    }

    static {
        SCULK_INGOT = new Item(new FabricItemSettings().group(WardenLoot.WL_GROUP));
        SCULK_SOUL = new Item(new FabricItemSettings().group(WardenLoot.WL_GROUP));
    }
}
