package net.nu11une.wardenloot.register;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.nu11une.wardenloot.WardenLoot;

public class WLWardenHeart {
    public static Item WARDEN_HEART;

    public static void registerHeart(){
        Registry.register(Registry.ITEM, new Identifier(WardenLoot.MOD_ID, "warden_heart"), WARDEN_HEART);
    }

    static {
        WARDEN_HEART = new Item(new FabricItemSettings().group(WardenLoot.WL_GROUP).rarity(Rarity.UNCOMMON));
    }
}
