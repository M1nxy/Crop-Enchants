package xyz.m1nxy.crop_enchants.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xyz.m1nxy.crop_enchants.CropEnchants;

@Mixin(FarmlandBlock.class)
public abstract class FeatherFootEnchantmentMixin {
    @Inject(method = "onLandedUpon", at = @At("HEAD"), cancellable = true)
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance, CallbackInfo ci) {
        if (entity instanceof PlayerEntity player) {
            ItemStack stack = player.getInventory().getArmorStack(0);

            if (EnchantmentHelper.getLevel(CropEnchants.FEATHERFOOT, stack) >= 1) {
                ci.cancel();
            }
        }
    }
}
