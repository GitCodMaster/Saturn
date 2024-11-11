package com.aziz.saturn.mixin.allocations.do_nothing;

import com.aziz.saturn.common.util.constants.DoNothingConstants;
import net.minecraft.world.entity.ai.behavior.DoNothing;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PiglinAi.class)
public class PiglinAiMixin {
    /**
     * @reason Cache to a static final reference.
     * @author AbdElAziz
     * @since 0.1.3
     * */
    @Redirect(
            method = {
                    "createIdleLookBehaviors",
                    "createIdleMovementBehaviors"
            },
            at = @At(
                    value = "NEW",
                    target = "(II)Lnet/minecraft/world/entity/ai/behavior/DoNothing;"
            )
    )
    private static DoNothing useStaticFinalReference(int minDuration, int maxDuration) {
        return DoNothingConstants.DO_NOTHING;
    }

    /**
     * @reason Cache to a static final reference.
     * @author AbdElAziz
     * @since 0.1.3
     * */
    @Redirect(
            method = "initCelebrateActivity",
            at = @At(
                    value = "NEW",
                    target = "(II)Lnet/minecraft/world/entity/ai/behavior/DoNothing;"
            )
    )
    private static DoNothing useStaticFinalReference2(int minDuration, int maxDuration) {
        return DoNothingConstants.PIGLIN_DO_NOTHING;
    }
}
