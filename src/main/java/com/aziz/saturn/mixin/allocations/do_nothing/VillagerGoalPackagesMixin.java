package com.aziz.saturn.mixin.allocations.do_nothing;

import com.aziz.saturn.common.util.constants.DoNothingConstants;
import net.minecraft.world.entity.ai.behavior.DoNothing;
import net.minecraft.world.entity.ai.behavior.VillagerGoalPackages;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(VillagerGoalPackages.class)
public class VillagerGoalPackagesMixin {
    /**
     * @reason Cache to a static final reference.
     * @author AbdElAziz
     * @since 0.1.3
     * */
    @Redirect(
            method = {
                    "getIdlePackage",
                    "getFullLookBehavior",
                    "getMinimalLookBehavior"
            },
            at = @At(
                    value = "NEW",
                    target = "(II)Lnet/minecraft/world/entity/ai/behavior/DoNothing;"
            )
    )
    private static DoNothing useStaticFinalReference(int minDuration, int maxDuration) {
        return DoNothingConstants.DO_NOTHING;
    }

    @Redirect(
            method = {
                    "getRestPackage",
                    "getPlayPackage"
            },
            at = @At(
                    value = "NEW",
                    target = "(II)Lnet/minecraft/world/entity/ai/behavior/DoNothing;"
            )
    )
    private static DoNothing useStaticFinalReferenceForPackages(int minDuration, int maxDuration) {
        return DoNothingConstants.VILLAGERS_DO_NOTHING;
    }
}
