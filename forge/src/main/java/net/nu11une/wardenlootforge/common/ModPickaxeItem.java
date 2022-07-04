package net.nu11une.wardenlootforge.common;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.nu11une.wardenlootforge.util.ModToolTips;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModPickaxeItem extends PickaxeItem {
    public ModPickaxeItem(Tier material, int attackDamage, float attackSpeed, Properties settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if(state.getBlock().getName().toString().contains("deepslate")){
            return this.speed * 4F;
        }
        return super.getDestroySpeed(stack, state);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(ModToolTips.DEEPSLATE_MINER);
    }
}
