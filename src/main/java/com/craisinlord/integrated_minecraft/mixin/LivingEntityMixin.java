package com.craisinlord.integrated_minecraft.mixin;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    // This method hooks into the `addEffect` method
    @Inject(method = "addEffect", at = @At("HEAD"), cancellable = true)
    private void preventRottenSmell(MobEffectInstance effect, CallbackInfoReturnable<Boolean> cir) {
        // Check if the effect's registry name matches 'born_in_chaos_v1:rotten_smell'
        MobEffect mobEffect = effect.getEffect(); // Get the MobEffect (effect type)

        if (mobEffect != null && "effect.born_in_chaos_v1.rotten_smell".equals(mobEffect.getDescriptionId())) {
            cir.setReturnValue(false);
        }
    }
}