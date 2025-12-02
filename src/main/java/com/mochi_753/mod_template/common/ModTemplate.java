package com.mochi_753.mod_template.common;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ModTemplate.MOD_ID)
public class ModTemplate {
    public static final String MOD_ID = "mod_template";

    @SuppressWarnings("removal")
    public ModTemplate() {
        FMLJavaModLoadingContext context = FMLJavaModLoadingContext.get();
        IEventBus eventBus = context.getModEventBus();
    }
}
