package net.nu11une.wardenloot.util;

import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.entity.player.PlayerEntity;
import net.nu11une.wardenloot.register.WLTrinketItems;

import java.util.Optional;

public class TrinketHelper {
    public static boolean hasWardenTrinket(PlayerEntity player){
        Optional<TrinketComponent> optionalTrinketComponent = TrinketsApi.getTrinketComponent(player);
        if(optionalTrinketComponent.isPresent()){
            TrinketComponent trinket = optionalTrinketComponent.get();
            if(trinket.isEquipped(WLTrinketItems.WARDEN_EARS_TRINKET)){
                return true;
            }
        }
        return false;
    }
}
