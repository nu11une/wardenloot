package net.nu11une.wardenloot;

import net.fabricmc.api.ModInitializer;
import net.nu11une.wardenloot.item.WLItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WardenLoot implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "wardenloot";
	public static final Logger LOGGER = LoggerFactory.getLogger("AIOTs Expanded");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		WLItems.registerWLItems();
		LOGGER.info("["+MOD_ID+"] Mod Initialized");
	}
}
