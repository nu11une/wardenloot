package net.nu11une.wardenloot;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.nu11une.wardenloot.core.*;
import net.nu11une.wardenloot.util.ModConfigs;
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
		ModConfigs.registerConfigs();
		WLLootTableModifier.registerWLLootPools();
		if(ModConfigs.REGISTER_TOOLS){
			WLTools.registerTools();
		}
		if(ModConfigs.REGISTER_HELMET_LEGGINGS_BOOTS){
			WLHelmet.registerHelmet();
		}
		if(ModConfigs.REGISTER_CHESTPLATE){
			WLChestplate.registerChestplate();
		}
		if(ModConfigs.REGISTER_HELMET_LEGGINGS_BOOTS){
			WLLeggingsBoots.registerArmor();
		}
		WLItems.registerWLItems();
		if(ModConfigs.REGISTER_HELMET_LEGGINGS_BOOTS || ModConfigs.REGISTER_CHESTPLATE){
			WLWardenHeart.registerHeart();
		}
		if(ModConfigs.REGISTER_WARDEN_DAMAGE_ENCHANTMENT){
			WLEnchants.registerWLEnchants();
		}
		LOGGER.info("["+MOD_ID+"] Mod Initialized");
	}
}
