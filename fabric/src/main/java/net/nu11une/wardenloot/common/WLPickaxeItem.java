package net.nu11une.wardenloot.common;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.nu11une.wardenloot.util.WLToolTip;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class WLPickaxeItem extends PickaxeItem {
    public WLPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        if(state.getBlock().getName().toString().contains("deepslate")){
            return this.miningSpeed * 4F;
        }
        return super.getMiningSpeedMultiplier(stack, state);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(WLToolTip.DEEPSLATE_MINER);
    }
}
