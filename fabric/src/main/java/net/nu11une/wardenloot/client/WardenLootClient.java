package net.nu11une.wardenloot.client;

import net.fabricmc.api.ClientModInitializer;
import net.nu11une.wardenloot.WardenLoot;
import net.nu11une.wardenloot.register.TrinketRenderers;

public class WardenLootClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        if(WardenLoot.isModLoaded("trinkets")){
            TrinketRenderers.registerRenderers();
        }
        if(!WardenLoot.isModLoaded("moremcmeta")){
            WardenLoot.LOGGER.info("["+WardenLoot.MOD_ID+"] MoreMcmeta is not loaded. Please either install MoreMcmeta or disabled animated armor in the config");
        }
    }
}
