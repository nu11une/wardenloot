package net.nu11une.wardenlootforge;

import com.mojang.logging.LogUtils;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.nu11une.wardenlootforge.register.*;
import net.nu11une.wardenlootforge.util.ModConfig;
import net.nu11une.wardenlootforge.util.Settings;
import org.slf4j.Logger;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

import java.util.ArrayList;

@Mod(WardenLootForge.MOD_ID)
public class WardenLootForge {
    public static final String MOD_ID = "wardenlootforge";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static ModConfig config;
    public static ArrayList<LivingEntity> tendrilEntities = new ArrayList<>();
    public WardenLootForge() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        AutoConfig.register(ModConfig.class, JanksonConfigSerializer::new);
        config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();

        ModEffects.register(modEventBus);

        if(Settings.tools){
            ModTools.register(modEventBus);
        }

        if(Settings.helmetleggingsboots){
            ModHelmet.register(modEventBus);
        }

        if(Settings.chestplate){
            ModChestplate.register(modEventBus);
        }

        if(Settings.helmetleggingsboots){
            ModLeggingsBoots.register(modEventBus);
        }

        if(Settings.chestplate){
            ModChestplate.registerBlood(modEventBus);
        }

        ModItems.register(modEventBus);

        if(Settings.chestplate || Settings.helmetleggingsboots){
            ModWardenHeart.register(modEventBus);
        }

        if(Settings.enchantment){
            ModEnchants.register(modEventBus);
        }

        if(ModList.get().isLoaded("curios")){
            ModTrinkets.register(modEventBus);
        }

        modEventBus.addListener(this::commonSetup);

        modEventBus.addListener(this::enqueueIMC);

        MinecraftForge.EVENT_BUS.register(this);

        LOGGER.info("["+MOD_ID+"] Mod Initialized");
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> SlotTypePreset.HEAD.getMessageBuilder().build());
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}
