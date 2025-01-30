package com.aziz.saturn.common;

import net.neoforged.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Saturn.MOD_ID)
public class Saturn {
    public static final String MOD_ID = "saturn";
    private static final Logger LOGGER = LogManager.getLogger();

    public static Logger getLogger() {
        return LOGGER;
    }
}