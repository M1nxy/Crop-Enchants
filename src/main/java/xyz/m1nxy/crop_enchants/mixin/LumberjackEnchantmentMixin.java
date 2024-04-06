package xyz.m1nxy.crop_enchants.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Block.class)
public class LumberjackEnchantmentMixin {
    @Inject(method = "afterBreak", at = @At("HEAD"), cancellable = true)
    private void DelicateEnchantment(World world, PlayerEntity player, BlockPos pos, BlockState state, BlockEntity blockEntity, ItemStack stack, CallbackInfo ci) {
        // check tree and enchant status. then remove tree
        // check 2 blocks up is log before removal.
        // dont remove if player is sneaking.
    }
}

