package com.craisinlord.integrated_minecraft.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigGeneralForge {
    public final ForgeConfigSpec.ConfigValue<Boolean> disableStructures;

    public ConfigGeneralForge(final ForgeConfigSpec.Builder BUILDER) {
        BUILDER
                .comment(
                        """
                                ##########################################################################################################
                                # General settings.
                                ##########################################################################################################""")
                .push("General");

        disableStructures = BUILDER
                .comment(
                        """
                                Whether or not Integrated Minecraft disables some structures.
                                Default: true""".indent(1))
                .worldRestart()
                .define("Disable Structures", true);


        BUILDER.pop();
    }
}