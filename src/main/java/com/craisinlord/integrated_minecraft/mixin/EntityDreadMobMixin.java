package com.craisinlord.integrated_minecraft.mixin;

import com.cerbon.bosses_of_mass_destruction.entity.custom.lich.LichEntity;
import com.github.alexthe666.iceandfire.entity.EntityDreadMob;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityDreadMob.class)
public class EntityDreadMobMixin {

    @Inject(method = "isAlliedTo", at = @At("HEAD"), cancellable = true)
    private void onIsAlliedTo(Entity entityIn, CallbackInfoReturnable<Boolean> cir) {
        if (entityIn instanceof LichEntity || entityIn.getName().getString().equals("bosses_of_mass_destruction:lich")) {
            cir.setReturnValue(true);
        }
    }
}





