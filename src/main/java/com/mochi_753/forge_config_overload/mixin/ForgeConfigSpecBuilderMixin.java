/*
 * This file incorporates code from MinecraftForge, licensed under LGPL-2.1-only.
 * Copyright (c) Forge Development LLC and contributors
 * For details, please refer to the LICENSE-MinecraftForge.txt file.
 */

package com.mochi_753.forge_config_overload.mixin;

import net.minecraftforge.common.ForgeConfigSpec;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.function.Supplier;

@Mixin(value = ForgeConfigSpec.Builder.class, remap = false)
public class ForgeConfigSpecBuilderMixin {
    @Inject(method = "defineInRange(Ljava/util/List;Ljava/util/function/Supplier;DD)Lnet/minecraftforge/common/ForgeConfigSpec$DoubleValue;", at = @At("HEAD"))
    private void onDefineInRange(List<String> path, Supplier<Double> defaultSupplier, double min, double max, CallbackInfoReturnable<ForgeConfigSpec.DoubleValue> cir) {
        min = -Double.MAX_VALUE;
        max = Double.MAX_VALUE;
    }

    @Inject(method = "defineInRange(Ljava/util/List;Ljava/util/function/Supplier;II)Lnet/minecraftforge/common/ForgeConfigSpec$IntValue;", at = @At("HEAD"))
    private void onDefineInRange(List<String> path, Supplier<Integer> defaultSupplier, int min, int max, CallbackInfoReturnable<ForgeConfigSpec.IntValue> cir) {
        min = Integer.MIN_VALUE;
        max = Integer.MAX_VALUE;
    }

    @Inject(method = "defineInRange(Ljava/util/List;Ljava/util/function/Supplier;JJ)Lnet/minecraftforge/common/ForgeConfigSpec$LongValue;", at = @At("HEAD"))
    private void onDefineInRange(List<String> path, Supplier<Long> defaultSupplier, long min, long max, CallbackInfoReturnable<ForgeConfigSpec.LongValue> cir) {
        min = Long.MIN_VALUE;
        max = Long.MAX_VALUE;
    }
}
