package com.craisinlord.integrated_minecraft.config;

import com.craisinlord.integrated_minecraft.IntegratedMinecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ConfigModuleForge {

    public static void init() {
        initCustomFiles();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, IMConfigForge.SPEC, "integrated_minecraft.toml");
        MinecraftForge.EVENT_BUS.addListener(ConfigModuleForge::onWorldLoad);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ConfigModuleForge::onConfigChange);
    }

    private static void onWorldLoad(LevelEvent.Load event) {
        bakeConfig();
        loadJSON();
    }

    private static void onConfigChange(ModConfigEvent event) {
        if (event.getConfig().getSpec() == IMConfigForge.SPEC) {
            bakeConfig();
            loadJSON();
        }
    }

    private static void initCustomFiles() {
        loadJSON();
    }

    private static void loadJSON() {
    }

    private static void bakeConfig() {
        IntegratedMinecraft.CONFIG.general.disableStructures = IMConfigForge.general.disableStructures.get();
    }
}