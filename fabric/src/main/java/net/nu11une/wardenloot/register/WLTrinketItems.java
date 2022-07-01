package net.nu11une.wardenloot.register;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.nu11une.wardenloot.WardenLoot;
import net.nu11une.wardenloot.common.WardenEarsItem;

public class WLTrinketItems {
    public static Item WARDEN_EARS_TRINKET;

    public static void registerTrinketItems() {
        Registry.register(Registry.ITEM, new Identifier(WardenLoot.MOD_ID, "warden_ears_trinket"), WARDEN_EARS_TRINKET);
    }

    static {
        WARDEN_EARS_TRINKET = new WardenEarsItem(new FabricItemSettings().group(WardenLoot.WL_GROUP).rarity(Rarity.UNCOMMON).maxCount(1));
    }
}
