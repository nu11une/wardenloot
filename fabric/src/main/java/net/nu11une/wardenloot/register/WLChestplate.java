package net.nu11une.wardenloot.register;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.nu11une.wardenloot.WardenLoot;
import net.nu11une.wardenloot.common.WLArmorItem;
import net.nu11une.wardenloot.common.WLArmorMaterial;
import net.nu11une.wardenloot.common.WardenBloodItem;

public class WLChestplate {
    public static WLArmorItem SCULK_CHESTPLATE;
    public static WLArmorItem SCULK_CHESTPLATE_UNCHARGED;
    public static Item WARDEN_BLOOD;

    public static void registerChestplate(){
        Registry.register(Registry.ITEM, new Identifier(WardenLoot.MOD_ID, "sculk_chestplate"), SCULK_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(WardenLoot.MOD_ID, "sculk_chestplate_uncharged"), SCULK_CHESTPLATE_UNCHARGED);
    }

    public static void registerBlood(){
        Registry.register(Registry.ITEM, new Identifier(WardenLoot.MOD_ID, "warden_blood"), WARDEN_BLOOD);
    }

    static {
        SCULK_CHESTPLATE = new WLArmorItem(getMaterial(), EquipmentSlot.CHEST, new FabricItemSettings().fireproof().group(WardenLoot.WL_GROUP));
        SCULK_CHESTPLATE_UNCHARGED = new WLArmorItem(WLArmorMaterial.SCULKERITE_UNCHARGED, EquipmentSlot.CHEST, new FabricItemSettings().fireproof());
        WARDEN_BLOOD = new WardenBloodItem(new FabricItemSettings().group(WardenLoot.WL_GROUP).rarity(Rarity.UNCOMMON).recipeRemainder(Items.GLASS_BOTTLE)
                .food(new FoodComponent.Builder()
                        .alwaysEdible()
                        .statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 1200), 1)
                        .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 1200, 3), 1)
                        .statusEffect(new StatusEffectInstance(WLEffects.ECHOLOCATE, 1200, 0, false, false), 1)
                        .build()));
    }

    public static WLArmorMaterial getMaterial() {
        if(!WardenLoot.config.misc.animateArmor){
            return WLArmorMaterial.SCULKERITE_COMPAT;
        }
        return WLArmorMaterial.SCULKERITE;
    }
}
