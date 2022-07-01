package net.nu11une.wardenlootforge.common;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.nu11une.wardenlootforge.WardenLootForge;
import net.nu11une.wardenlootforge.register.ModChestplate;
import net.nu11une.wardenlootforge.register.ModHelmet;
import net.nu11une.wardenlootforge.util.ModToolTips;
import net.nu11une.wardenlootforge.util.Settings;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModArmorItem extends ArmorItem {
    public ModArmorItem(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
        super(material, slot, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        if(Settings.helmetleggingsboots){
            tooltip.add(ModToolTips.WARDEN_SET_BONUS);
            if(stack.getItem().equals(ModHelmet.SCULK_HELMET.get())){
                tooltip.add(ModToolTips.DARKNESS_IMMUNITY_BONUS);
            }
        } else if (Settings.chestplate) {
            tooltip.add(ModToolTips.WARDEN_BONUS);
        }
        if(Settings.chestplate){
            if(stack.getItem().equals(ModChestplate.SCULK_CHESTPLATE_UNCHARGED.get())){
                tooltip.add(ModToolTips.COLD_HEART);
            }
        }
    }
}
