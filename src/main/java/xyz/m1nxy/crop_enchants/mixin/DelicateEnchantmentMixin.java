package xyz.m1nxy.crop_enchants.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xyz.m1nxy.crop_enchants.CropEnchants;

@Mixin(Block.class)
public abstract class DelicateEnchantmentMixin {
    @Shadow
    protected abstract Block asBlock();

    @Inject(method = "afterBreak", at = @At("HEAD"), cancellable = true)
    private void DelicateEnchantment(World world, PlayerEntity player, BlockPos pos, BlockState state, BlockEntity blockEntity, ItemStack stack, CallbackInfo ci) {
        if ((stack.getItem() instanceof HoeItem || stack.getItem() instanceof AxeItem) && EnchantmentHelper.getLevel(CropEnchants.DELICATE, stack) >= 1) {
            Block block = this.asBlock();
            CropBlock crop = ((CropBlock) block);

            if (block instanceof CropBlock && !crop.isMature(state)) {
                world.setBlockState(pos, state);
                ci.cancel();
            }
        }
    }
}
