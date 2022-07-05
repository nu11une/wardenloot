package net.nu11une.wardenlootforge.register;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nu11une.wardenlootforge.WardenLootForge;
import net.nu11une.wardenlootforge.common.EcholocateEffect;

public class ModEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, WardenLootForge.MOD_ID);

    public static final RegistryObject<MobEffect> ECHOLOCATE = EFFECTS.register("echolocate", () -> new EcholocateEffect(MobEffectCategory.BENEFICIAL, 3124687));

    public static void register(IEventBus eventBus){
        EFFECTS.register(eventBus);
    }
}
