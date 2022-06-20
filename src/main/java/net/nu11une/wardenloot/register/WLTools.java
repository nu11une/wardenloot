package net.nu11une.wardenloot.register;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.nu11une.wardenloot.WardenLoot;
import net.nu11une.wardenloot.common.*;

public class WLTools {
    public static WLSwordItem SCULK_SWORD;
    public static WLPickaxeItem SCULK_PICKAXE;
    public static WLAxeItem SCULK_AXE;
    public static WLHoeItem SCULK_HOE;
    public static WLShovelItem SCULK_SHOVEL;

    public static void registerTools(){
        Registry.register(Registry.ITEM, new Identifier(WardenLoot.MOD_ID, "sculk_sword"), SCULK_SWORD);
        Registry.register(Registry.ITEM, new Identifier(WardenLoot.MOD_ID, "sculk_pickaxe"), SCULK_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier(WardenLoot.MOD_ID, "sculk_axe"), SCULK_AXE);
        Registry.register(Registry.ITEM, new Identifier(WardenLoot.MOD_ID, "sculk_hoe"), SCULK_HOE);
        Registry.register(Registry.ITEM, new Identifier(WardenLoot.MOD_ID, "sculk_shovel"), SCULK_SHOVEL);
    }

    static {
        SCULK_SWORD = new WLSwordItem(WLToolMaterial.SCULKERITE, 3, -2.4F, new FabricItemSettings().fireproof().group(WardenLoot.WL_GROUP));
        SCULK_PICKAXE = new WLPickaxeItem(WLToolMaterial.SCULKERITE, 0, -3, new FabricItemSettings().fireproof().group(WardenLoot.WL_GROUP));
        SCULK_AXE = new WLAxeItem(WLToolMaterial.SCULKERITE, 5, -3, new FabricItemSettings().fireproof().group(WardenLoot.WL_GROUP));
        SCULK_HOE = new WLHoeItem(WLToolMaterial.SCULKERITE, -4, 0, new FabricItemSettings().fireproof().group(WardenLoot.WL_GROUP));
        SCULK_SHOVEL = new WLShovelItem(WLToolMaterial.SCULKERITE, 1, -3, new FabricItemSettings().fireproof().group(WardenLoot.WL_GROUP));
    }
}
