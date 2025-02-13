package com.craisinlord.integrated_minecraft.mixin;

import com.craisinlord.integrated_api.mixins.world.WorldGenRegionAccessor;
import com.craisinlord.integrated_api.modinit.IATags;
import com.github.alexthe666.iceandfire.world.gen.WorldGenDragonCave;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.minecraft.world.level.levelgen.structure.Structure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WorldGenDragonCave.class)
public class NoDragonsCavesInStructuresMixin {

    @Inject(
            method = "place(Lnet/minecraft/world/level/levelgen/feature/FeaturePlaceContext;)Z",
            at = @At(value = "HEAD"),
            cancellable = true
    )
    private void integrated_api_noDragonCaves(FeaturePlaceContext<BlockStateConfiguration> context, CallbackInfoReturnable<Boolean> cir) {
        if(!(context.level() instanceof WorldGenRegion)) {
            return;
        }

        Registry<Structure> configuredStructureFeatureRegistry = context.level().registryAccess().registryOrThrow(Registries.STRUCTURE);
        StructureManager structureManager = ((WorldGenRegionAccessor)context.level()).getStructureManager();

        for (Holder<Structure> configuredStructureFeature : configuredStructureFeatureRegistry.getOrCreateTag(IATags.LARGER_LOCATE_SEARCH)) {
            if (structureManager.getStructureAt(context.origin(), configuredStructureFeature.value()).isValid()) {
                cir.setReturnValue(false);
                return;
            }
        }
    }
}
