package com.aziz.saturn.mixin.allocations.empty_resource_location;

import com.aziz.saturn.common.util.constants.SaturnConstants;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.commands.CommandFunction;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AdvancementRewards.class)
public class AdvancementRewardsMixin {
    @Shadow @Final @Mutable
    public static AdvancementRewards EMPTY;

    /**
     * @reason Cache empty resource location array creation.
     * @author AbdElAziz
     * @since 0.1.3
     * */
    @Inject(
            method = "<clinit>",
            at = @At(
                    value = "TAIL"
            )
    )
    private static void cacheResourceLocation(CallbackInfo ci) {
        EMPTY = new AdvancementRewards(0, SaturnConstants.EMPTY_RESOURCE_LOCATION, SaturnConstants.EMPTY_RESOURCE_LOCATION, CommandFunction.CacheableFunction.NONE);
    }
}
