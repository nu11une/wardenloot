package net.nu11une.wardenloot.register;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.nu11une.wardenloot.WardenLoot;
import net.nu11une.wardenloot.common.EcholocateEffect;

public class WLEffects {
    public static StatusEffect ECHOLOCATE;

    public static void registerEffects(){
        Registry.register(Registry.STATUS_EFFECT, new Identifier(WardenLoot.MOD_ID, "echolocate"), ECHOLOCATE);
    }

    static {
        ECHOLOCATE = new EcholocateEffect(StatusEffectCategory.BENEFICIAL, 3124687);
    }
}
