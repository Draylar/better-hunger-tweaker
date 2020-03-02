package com.github.draylar.betterhungertweaker;

import net.dblsaiko.qcommon.cfg.core.api.ConfigApi;
import net.dblsaiko.qcommon.cfg.core.api.cvar.CvarOptions;
import net.dblsaiko.qcommon.cfg.core.api.cvar.IntConVar;
import net.fabricmc.api.ModInitializer;

public class BetterHungerTweaker implements ModInitializer {

    private static final ConfigApi.Mutable CONFIG = ConfigApi.getInstanceMut();
    public static final IntConVar BREAD = CONFIG.addConVar("betterhungertweaker:bread_saturation", IntConVar.owned(6), CvarOptions.create().save("betterhungertweaker"));

    @Override
    public void onInitialize() {

    }
}
