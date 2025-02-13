package com.craisinlord.integrated_minecraft.mixin;

import de.rubixdev.inventorio.api.InventorioAPI;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(PlayerInventoryExtraStuff.class)
public abstract class PlayerInventoryExtraStuffMixin {

    @Inject(method = "getMostPreferredTool", at = @At("HEAD"), cancellable = true)
    private void preventGrassToolSelection(BlockState block, CallbackInfoReturnable<ItemStack> cir) {
        if (block.isIn(BlockTags.SMALL_FLOWERS) ||
                block.isIn(BlockTags.TALL_FLOWERS) ||
                block.isIn(BlockTags.REPLACEABLE_BY_TREES) ||
                block.isOf(Blocks.GRASS) ||
                block.isOf(Blocks.TALL_GRASS) ||
                block.isOf(Blocks.GRASS)) {
            cir.setReturnValue(ItemStack.EMPTY);
        }
    }
}