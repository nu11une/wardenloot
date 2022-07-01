package net.nu11une.wardenlootforge.event;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.nu11une.wardenlootforge.WardenLootForge;
import net.nu11une.wardenlootforge.util.loot.AncientCityLootModifier;
import net.nu11une.wardenlootforge.util.loot.SculkBlockLootModifier;
import net.nu11une.wardenlootforge.util.loot.WardenLootModifier;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = WardenLootForge.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegisterEvent event) {
        event.register(ForgeRegistries.Keys.LOOT_MODIFIER_SERIALIZERS, helper -> {
            helper.register(new ResourceLocation(WardenLootForge.MOD_ID,"ancient_city_loot_modifier"),
                    new AncientCityLootModifier.Serializer());
            helper.register(new ResourceLocation(WardenLootForge.MOD_ID,"sculk_block_loot_modifier"),
                    new SculkBlockLootModifier.Serializer());
            helper.register(new ResourceLocation(WardenLootForge.MOD_ID,"warden_loot_modifier"),
                    new WardenLootModifier.Serializer());
        });
    }
}
