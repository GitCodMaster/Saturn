package com.aziz.saturn.mixin.allocations.do_nothing;

import com.aziz.saturn.common.util.constants.DoNothingConstants;
import net.minecraft.world.entity.ai.behavior.DoNothing;
import net.minecraft.world.entity.monster.Zoglin;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Zoglin.class)
public class ZoglinMixin {
    /**
     * @reason Cache to a static final reference.
     * @author AbdElAziz
     * @since 0.1.3
     * */
    @Redirect(
            method = "initIdleActivity",
            at = @At(
                    value = "NEW",
                    target = "(II)Lnet/minecraft/world/entity/ai/behavior/DoNothing;"
            )
    )
    private static DoNothing useStaticFinalReferences(int minDuration, int maxDuration) {
        return DoNothingConstants.DO_NOTHING;
    }
}
