package net.nu11une.wardenlootforge.common;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.nu11une.wardenlootforge.register.ModItems;
import net.nu11une.wardenlootforge.util.Settings;

public class ModToolMaterials {
    public static final ForgeTier SCULKERITE = new ForgeTier(Settings.level, Settings.durability, Settings.speed, Settings.damage, 20, BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(ModItems.SCULK_INGOT.get()));
}
