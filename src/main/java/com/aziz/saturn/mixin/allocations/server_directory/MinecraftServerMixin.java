package com.aziz.saturn.mixin.allocations.server_directory;

import com.aziz.saturn.common.util.constants.SaturnConstants;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.io.File;

@Mixin(MinecraftServer.class)
public class MinecraftServerMixin {
    /**
     * @reason Cache to a static final reference.
     * @author AbdElAziz
     * @since 0.1.0
     * */
    @Overwrite
    public File getServerDirectory() {
        return SaturnConstants.SERVER_DIRECTORY;
    }
}
