package net.nu11une.wardenloot;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.nu11une.wardenloot.core.WLItems;
import net.nu11une.wardenloot.util.WLLootTableModifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.minecraft.util.Identifier;

public class WardenLoot implements ModInitializer {
	public static final String MOD_ID = "wardenloot";
	public static final Logger LOGGER = LoggerFactory.getLogger("AIOTs Expanded");

	public static final ItemGroup WL_GROUP = FabricItemGroupBuilder.build(
			new Identifier(MOD_ID, "wardenloot_group"),
			() -> new ItemStack(WLItems.SCULK_INGOT));

	@Override
	public void onInitialize() {
		WLItems.registerWLItems();
		WLLootTableModifier.registerWLLootPools();
		LOGGER.info("["+MOD_ID+"] Mod Initialized");
	}
}
