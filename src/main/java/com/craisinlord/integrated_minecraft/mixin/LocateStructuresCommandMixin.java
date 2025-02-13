package com.craisinlord.integrated_minecraft.mixin;

import com.craisinlord.integrated_minecraft.IntegratedMinecraft;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.ResourceOrTagKeyArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.commands.LocateCommand;
import net.minecraft.world.level.levelgen.structure.Structure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

/**
 * Overrides behavior of /locate structure
 */
@Mixin(LocateCommand.class)
public class LocateStructuresCommandMixin {
    private static final SimpleCommandExceptionType DISABLED =
            new SimpleCommandExceptionType(Component.translatable("Integrated Minecraft disables this structure!"));

    private static final SimpleCommandExceptionType RECODED =
            new SimpleCommandExceptionType(Component.translatable("Integrated Minecraft recodes this structure! Use /locate idas: instead!"));

    @Inject(method = "locateStructure", at = @At(value = "HEAD"))
    private static void integrated_minecraft_overrideLocateStructures(CommandSourceStack cmdSource,
                                                        ResourceOrTagKeyArgument.Result<Structure> result,
                                                        CallbackInfoReturnable<Integer> ci) throws CommandSyntaxException {
        Optional<ResourceKey<Structure>> optional = result.unwrap().left();
        if (IntegratedMinecraft.CONFIG.general.disableStructures) {


            if (optional.isPresent() && optional.get().location().equals(new ResourceLocation("mansion"))) {
                throw DISABLED.create();
            }if (optional.isPresent() && optional.get().location().equals(new ResourceLocation("desert_pyramid"))) {
                throw DISABLED.create();
            }if (optional.isPresent() && optional.get().location().equals(new ResourceLocation("igloo"))) {
                throw DISABLED.create();
            }if (optional.isPresent() && optional.get().location().equals(new ResourceLocation("illagerinvasion:firecaller_hut"))) {
                throw DISABLED.create();
            }if (optional.isPresent() && optional.get().location().equals(new ResourceLocation("illagerinvasion:illager_fort"))) {
                throw DISABLED.create();
            }if (optional.isPresent() && optional.get().location().equals(new ResourceLocation("illagerinvasion:illusioner_tower"))) {
                throw DISABLED.create();
            }if (optional.isPresent() && optional.get().location().equals(new ResourceLocation("illagerinvasion:labyrinth"))) {
                throw DISABLED.create();
            }if (optional.isPresent() && optional.get().location().equals(new ResourceLocation("illagerinvasion:sorcerer_hut"))) {
                throw DISABLED.create();
            }if (optional.isPresent() && optional.get().location().equals(new ResourceLocation("biomemakeover:ghost_town"))) {
                throw DISABLED.create();
            }if (optional.isPresent() && optional.get().location().equals(new ResourceLocation("betterend:end_village"))) {
                throw DISABLED.create();
            }if (optional.isPresent() && optional.get().location().equals(new ResourceLocation("betternether:nether_city"))) {
                throw DISABLED.create();
            }if (optional.isPresent() && optional.get().location().equals(new ResourceLocation("forbidden_arcanus:nipa"))) {
                throw DISABLED.create();
            }if (optional.isPresent() && optional.get().location().equals(new ResourceLocation("forbidden_arcanus:nipa_floating"))) {
                throw DISABLED.create();
            }if (optional.isPresent() && optional.get().location().equals(new ResourceLocation("born_in_chaos_v1:clown_caravan_plains"))) {
                throw DISABLED.create();
            }if (optional.isPresent() && optional.get().location().equals(new ResourceLocation("born_in_chaos_v1:clown_caravan_taiga"))) {
                throw DISABLED.create();
            }if (optional.isPresent() && optional.get().location().equals(new ResourceLocation("born_in_chaos_v1:clown_caravan_savanna"))) {
                throw DISABLED.create();
            }if (optional.isPresent() && optional.get().location().equals(new ResourceLocation("born_in_chaos_v1:grave_2003wise"))) {
                throw DISABLED.create();
            }if (optional.isPresent() && optional.get().location().equals(new ResourceLocation("born_in_chaos_v1:grave_darktitan"))) {
                throw DISABLED.create();
            }if (optional.isPresent() && optional.get().location().equals(new ResourceLocation("born_in_chaos_v1:grave_derivas"))) {
                throw DISABLED.create();
            }if (optional.isPresent() && optional.get().location().equals(new ResourceLocation("born_in_chaos_v1:grave_orion"))) {
                throw DISABLED.create();
            }if (optional.isPresent() && optional.get().location().equals(new ResourceLocation("born_in_chaos_v1:grave_petasi"))) {
                throw DISABLED.create();
            }if (optional.isPresent() && optional.get().location().equals(new ResourceLocation("born_in_chaos_v1:grave_fubuki_banzai"))) {
                throw DISABLED.create();
            }if (optional.isPresent() && optional.get().location().equals(new ResourceLocation("born_in_chaos_v1:observation_tower_forest"))) {
                throw DISABLED.create();
            }if (optional.isPresent() && optional.get().location().equals(new ResourceLocation("born_in_chaos_v1:observation_tower_plains"))) {
                throw DISABLED.create();
            }if (optional.isPresent() && optional.get().location().equals(new ResourceLocation("born_in_chaos_v1:farm"))) {
                throw DISABLED.create();
            }if (optional.isPresent() && optional.get().location().equals(new ResourceLocation("born_in_chaos_v1:firewell"))) {
                throw DISABLED.create();
            }if (optional.isPresent() && optional.get().location().equals(new ResourceLocation("born_in_chaos_v1:mound_of_hounds"))) {
                throw DISABLED.create();
            }if (optional.isPresent() && optional.get().location().equals(new ResourceLocation("born_in_chaos_v1:inferal_pumpkin"))) {
                throw DISABLED.create();
            }if (optional.isPresent() && optional.get().location().equals(new ResourceLocation("born_in_chaos_v1:dark_tower_forest"))) {
                throw RECODED.create();
            }if (optional.isPresent() && optional.get().location().equals(new ResourceLocation("born_in_chaos_v1:dark_tower_plains"))) {
                throw RECODED.create();
            }if (optional.isPresent() && optional.get().location().equals(new ResourceLocation("born_in_chaos_v1:dark_tower_taiga"))) {
                throw RECODED.create();
            }if (optional.isPresent() && optional.get().location().equals(new ResourceLocation("eidolon:catacomb"))) {
                throw DISABLED.create();
            }if (optional.isPresent() && optional.get().location().equals(new ResourceLocation("eidolon:stray_tower"))) {
                throw DISABLED.create();
            }if (optional.isPresent() && optional.get().location().equals(new ResourceLocation("betterend:eternal_portal"))) {
                throw DISABLED.create();
            }if (optional.isPresent() && optional.get().location().equals(new ResourceLocation("bosses_of_mass_destruction:void_blossom"))) {
                throw DISABLED.create();
            }if (optional.isPresent() && optional.get().location().equals(new ResourceLocation("bosses_of_mass_destruction:lich_tower"))) {
                throw DISABLED.create();
            }if (optional.isPresent() && optional.get().location().equals(new ResourceLocation("mowziesmobs:wrought_chamber"))) {
                throw DISABLED.create();
            }if (optional.isPresent() && optional.get().location().equals(new ResourceLocation("mes:enderbloom_grove"))) {
                throw DISABLED.create();
            }if (optional.isPresent() && optional.get().location().equals(new ResourceLocation("mes:placid_prarie"))) {
                throw DISABLED.create();
            }if (optional.isPresent() && optional.get().location().equals(new ResourceLocation("mes:enderscraps"))) {
                throw DISABLED.create();
            }if (optional.isPresent() && optional.get().location().equals(new ResourceLocation("mes:mythic_garden"))) {
                throw DISABLED.create();
            }if (optional.isPresent() && optional.get().location().equals(new ResourceLocation("mes:ruined_pillar"))) {
                throw DISABLED.create();
            }if (optional.isPresent() && optional.get().location().equals(new ResourceLocation("mes:placid_prairie"))) {
                throw DISABLED.create();
            }if (optional.isPresent() && optional.get().location().equals(new ResourceLocation("ars_elemental:starbuncle_shrine"))) {
                throw DISABLED.create();
            }
        }
    }
}