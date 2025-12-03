/*
 * This file incorporates code from MinecraftForge, licensed under LGPL-2.1-only.
 * Copyright (c) Forge Development LLC and contributors
 * For details, please refer to the LICENSE-MinecraftForge.txt file.
 */

package com.mochi_753.forge_config_overload.mixin;

import net.minecraftforge.common.ForgeConfigSpec;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(value = ForgeConfigSpec.Builder.class, remap = false)
public abstract class ForgeConfigSpecBuilderMixin {
    @ModifyVariable(method = "defineInRange(Ljava/util/List;Ljava/util/function/Supplier;DD)Lnet/minecraftforge/common/ForgeConfigSpec$DoubleValue;", at = @At("HEAD"), argsOnly = true, name = "arg3")
    private double modifyDoubleMin(double min) {
        return -Double.MAX_VALUE;
    }

    @ModifyVariable(method = "defineInRange(Ljava/util/List;Ljava/util/function/Supplier;DD)Lnet/minecraftforge/common/ForgeConfigSpec$DoubleValue;", at = @At("HEAD"), argsOnly = true, name = "arg5")
    private double modifyDoubleMax(double max) {
        return Double.MAX_VALUE;
    }

    @ModifyVariable(method = "defineInRange(Ljava/util/List;Ljava/util/function/Supplier;II)Lnet/minecraftforge/common/ForgeConfigSpec$IntValue;", at = @At("HEAD"), argsOnly = true, name = "arg3")
    private int modifyIntMin(int min) {
        return Integer.MIN_VALUE;
    }

    @ModifyVariable(method = "defineInRange(Ljava/util/List;Ljava/util/function/Supplier;II)Lnet/minecraftforge/common/ForgeConfigSpec$IntValue;", at = @At("HEAD"), argsOnly = true, name = "arg4")
    private int modifyIntMax(int max) {
        return Integer.MAX_VALUE;
    }

    @ModifyVariable(method = "defineInRange(Ljava/util/List;Ljava/util/function/Supplier;JJ)Lnet/minecraftforge/common/ForgeConfigSpec$LongValue;", at = @At("HEAD"), argsOnly = true, name = "arg3")
    private long modifyLongMin(long min) {
        return Long.MIN_VALUE;
    }

    @ModifyVariable(method = "defineInRange(Ljava/util/List;Ljava/util/function/Supplier;JJ)Lnet/minecraftforge/common/ForgeConfigSpec$LongValue;", at = @At("HEAD"), argsOnly = true, name = "arg5")
    private long modifyLongMax(long max) {
        return Long.MAX_VALUE;
    }
}
