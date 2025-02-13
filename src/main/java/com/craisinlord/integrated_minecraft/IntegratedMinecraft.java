package com.craisinlord.integrated_minecraft;

import com.craisinlord.integrated_minecraft.config.ConfigModule;
import com.craisinlord.integrated_minecraft.config.ConfigModuleForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(IntegratedMinecraft.MODID)
public class IntegratedMinecraft {
    public static final String MODID = "integrated_minecraft";
    public static final Logger LOGGER = LogManager.getLogger();
    public static final ConfigModule CONFIG = new ConfigModule();

    public IntegratedMinecraft() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ConfigModuleForge.init();
        modEventBus.addListener(this::setup);

//        MinecraftForge.EVENT_BUS.register(new Events());
    }

    public void setup(final FMLCommonSetupEvent event) {
    }
}