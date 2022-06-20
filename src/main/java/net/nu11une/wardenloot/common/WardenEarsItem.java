package net.nu11une.wardenloot.common;

import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.nu11une.wardenloot.util.WLToolTip;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class WardenEarsItem extends TrinketItem {
    public WardenEarsItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(WLToolTip.TRINKET_ECHOLOCATE);
    }
}
