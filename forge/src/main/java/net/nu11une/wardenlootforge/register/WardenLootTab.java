package net.nu11une.wardenlootforge.register;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.nu11une.wardenlootforge.util.Settings;

public class WardenLootTab {
    public static final CreativeModeTab WARDEN_LOOT_TAB = new CreativeModeTab("wardenlootforge.wardenlootforge_group") {
        @Override
        public ItemStack makeIcon() {
            if(Settings.chestplate){
                return new ItemStack(ModChestplate.SCULK_CHESTPLATE.get());
            } else {
                return new ItemStack(ModItems.SCULK_INGOT.get());
            }
        }
    };
}
