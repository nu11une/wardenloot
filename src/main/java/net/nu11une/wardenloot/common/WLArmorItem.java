package net.nu11une.wardenloot.common;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.nu11une.wardenloot.WardenLoot;
import net.nu11une.wardenloot.register.WLHelmet;
import net.nu11une.wardenloot.util.ModConfig;
import net.nu11une.wardenloot.util.WLToolTip;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class WLArmorItem extends ArmorItem {
    public WLArmorItem(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(WardenLoot.config.registry.registerHelmetLeggingsBoots){
            tooltip.add(WLToolTip.WARDEN_SET_BONUS);
            if(stack.getItem().equals(WLHelmet.SCULK_HELMET)){
                tooltip.add(WLToolTip.DARKNESS_IMMUNITY_BONUS);
            }
        } else {
            tooltip.add(WLToolTip.WARDEN_BONUS);
        }
    }
}
