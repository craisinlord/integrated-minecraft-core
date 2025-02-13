package com.craisinlord.integrated_minecraft.mixin;

import com.craisinlord.integrated_minecraft.IntegratedMinecraft;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.SectionPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChunkGenerator.class)
public class DisableStructuresMixin {

@Inject(method = "tryGenerateStructure", at = @At(value = "HEAD"), cancellable = true)
    void integrated_minecraft_DisableStructures(
            StructureSet.StructureSelectionEntry structureSetEntry,
            StructureManager structureManager,
            RegistryAccess registryAccess,
            RandomState randomState,
            StructureTemplateManager structureTemplateManager,
            long seed,
            ChunkAccess chunkAccess,
            ChunkPos chunkPos,
            SectionPos sectionPos,
            CallbackInfoReturnable<Boolean> cir
    ) {
        if (IntegratedMinecraft.CONFIG.general.disableStructures) {
            if (structureSetEntry.structure().is(new ResourceLocation("illagerinvasion:firecaller_hut")) ||
                    structureSetEntry.structure().is(new ResourceLocation("illagerinvasion:illager_fort")) ||
                    structureSetEntry.structure().is(new ResourceLocation("illagerinvasion:illusioner_tower")) ||
                    structureSetEntry.structure().is(new ResourceLocation("illagerinvasion:labyrinth")) ||
                    structureSetEntry.structure().is(new ResourceLocation("illagerinvasion:sorcerer_hut")) ||
                    structureSetEntry.structure().is(new ResourceLocation("biomemakeover:ghost_town")) ||
                    structureSetEntry.structure().is(new ResourceLocation("betterend:end_village")) ||
                    structureSetEntry.structure().is(new ResourceLocation("betterend:eternal_portal")) ||
                    structureSetEntry.structure().is(new ResourceLocation("betternether:nether_city")) ||
                    structureSetEntry.structure().is(new ResourceLocation("forbidden_arcanus:nipa")) ||
                    structureSetEntry.structure().is(new ResourceLocation("forbidden_arcanus:nipa_floating")) ||
                    structureSetEntry.structure().is(new ResourceLocation("born_in_chaos_v1:clown_caravan_plains")) ||
                    structureSetEntry.structure().is(new ResourceLocation("born_in_chaos_v1:clown_caravan_taiga")) ||
                    structureSetEntry.structure().is(new ResourceLocation("born_in_chaos_v1:clown_caravan_savanna")) ||
                    structureSetEntry.structure().is(new ResourceLocation("born_in_chaos_v1:farm")) ||
                    structureSetEntry.structure().is(new ResourceLocation("born_in_chaos_v1:firewell")) ||
                    structureSetEntry.structure().is(new ResourceLocation("born_in_chaos_v1:mound_of_hounds")) ||
                    structureSetEntry.structure().is(new ResourceLocation("born_in_chaos_v1:grave_2003wise")) ||
                    structureSetEntry.structure().is(new ResourceLocation("born_in_chaos_v1:grave_darktitan")) ||
                    structureSetEntry.structure().is(new ResourceLocation("born_in_chaos_v1:grave_derivas")) ||
                    structureSetEntry.structure().is(new ResourceLocation("born_in_chaos_v1:grave_orion")) ||
                    structureSetEntry.structure().is(new ResourceLocation("born_in_chaos_v1:grave_petasi")) ||
                    structureSetEntry.structure().is(new ResourceLocation("born_in_chaos_v1:grave_fubuki_banzai")) ||
                    structureSetEntry.structure().is(new ResourceLocation("born_in_chaos_v1:observation_tower_forest")) ||
                    structureSetEntry.structure().is(new ResourceLocation("born_in_chaos_v1:observation_tower_plains")) ||
                    structureSetEntry.structure().is(new ResourceLocation("born_in_chaos_v1:infernal_pumpkin")) ||
                    structureSetEntry.structure().is(new ResourceLocation("born_in_chaos_v1:dark_tower_forest")) ||
                    structureSetEntry.structure().is(new ResourceLocation("born_in_chaos_v1:dark_tower_plains")) ||
                    structureSetEntry.structure().is(new ResourceLocation("born_in_chaos_v1:dark_tower_taiga")) ||
                    structureSetEntry.structure().is(new ResourceLocation("eidolon:catacomb")) ||
                    structureSetEntry.structure().is(new ResourceLocation("eidolon:stray_tower")) ||
                    structureSetEntry.structure().is(new ResourceLocation("bosses_of_mass_destruction:void_blossom")) ||
                    structureSetEntry.structure().is(new ResourceLocation("bosses_of_mass_destruction:lich_tower")) ||
                    structureSetEntry.structure().is(new ResourceLocation("atmospheric:village_scrubland")) ||
                    structureSetEntry.structure().is(new ResourceLocation("mowziesmobs:wrought_chamber")) ||
                    structureSetEntry.structure().is(new ResourceLocation("mes:enderbloom_grove")) ||
                    structureSetEntry.structure().is(new ResourceLocation("mes:placid_prarie")) ||
                    structureSetEntry.structure().is(new ResourceLocation("mes:enderscraps")) ||
                    structureSetEntry.structure().is(new ResourceLocation("mes:mythic_garden")) ||
                    structureSetEntry.structure().is(new ResourceLocation("mes:ruined_pillar")) ||
                    structureSetEntry.structure().is(new ResourceLocation("mes:placid_prairie")) ||
                    structureSetEntry.structure().is(new ResourceLocation("ars_elemental:starbuncle_shrine")) ||
                    structureSetEntry.structure().value().type() == StructureType.DESERT_PYRAMID ||
                    structureSetEntry.structure().value().type() == StructureType.MINESHAFT ||
                    structureSetEntry.structure().value().type() == StructureType.IGLOO ||
                    structureSetEntry.structure().value().type() == StructureType.WOODLAND_MANSION) {
                cir.setReturnValue(false);
            }
        }
    }
}
