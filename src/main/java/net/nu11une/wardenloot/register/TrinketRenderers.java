package net.nu11une.wardenloot.register;

import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import net.nu11une.wardenloot.client.WLTrinketRender;

public class TrinketRenderers {
    public static void registerRenderers(){
        TrinketRendererRegistry.registerRenderer(WLTrinketItems.WARDEN_EARS_TRINKET, new WLTrinketRender());
    }
}
