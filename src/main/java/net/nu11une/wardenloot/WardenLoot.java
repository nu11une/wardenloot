package net.nu11une.wardenloot;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.nu11une.wardenloot.register.*;
import net.nu11une.wardenloot.util.ModConfig;
import net.nu11une.wardenloot.util.WLLootTableModifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.minecraft.util.Identifier;

public class WardenLoot implements ModInitializer {
	public static final String MOD_ID = "wardenloot";
	public static final Logger LOGGER = LoggerFactory.getLogger("AIOTs Expanded");
	public static ModConfig config;
	public static ItemStack iconStack;

	public static final ItemGroup WL_GROUP = FabricItemGroupBuilder.build(
			new Identifier(MOD_ID, "wardenloot_group"),
			() -> iconStack);


	public static boolean isModLoaded(String modId) {
		return FabricLoader.getInstance().isModLoaded(modId);
	}
	@Override
	public void onInitialize() {
		AutoConfig.register(ModConfig.class, JanksonConfigSerializer::new);
		config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
		if(config.registry.registerChestplate){
			iconStack = new ItemStack(WLChestplate.SCULK_CHESTPLATE);
		} else {
			iconStack = new ItemStack(WLItems.SCULK_INGOT);
		}
		WLLootTableModifier.registerWLLootPools();
		if(config.registry.registerTools){
			WLTools.registerTools();
		}
		if(config.registry.registerHelmetLeggingsBoots){
			WLHelmet.registerHelmet();
		}
		if(config.registry.registerChestplate){
			WLChestplate.registerChestplate();
		}
		if(config.registry.registerHelmetLeggingsBoots){
			WLLeggingsBoots.registerArmor();
		}
		if(config.registry.registerChestplate){
			WLChestplate.registerBlood();
		}
		WLItems.registerWLItems();
		if(config.registry.registerHelmetLeggingsBoots || config.registry.registerChestplate){
			WLWardenHeart.registerHeart();
		}
		if(config.registry.registerWardenBaneEnchantment){
			WLEnchants.registerWLEnchants();
		}
		if(isModLoaded("trinkets")){
			WLTrinketItems.registerTrinketItems();
		}
		LOGGER.info("["+MOD_ID+"] Mod Initialized");
		FabricLoader.getInstance().getConfigDir().resolve("wardenloot.properties").toFile().delete();
	}
}
