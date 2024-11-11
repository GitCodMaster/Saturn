package com.aziz.saturn.mixin.allocations.shulker_look_control;

import com.aziz.saturn.common.util.constants.EntityConstants;
import net.minecraft.world.entity.monster.Shulker;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Shulker.ShulkerLookControl.class)
public class ShulkerLookControlMixin {
    /**
     * @reason Cache to a static final reference.
     * @author AbdElAziz
     * @since 0.1.4
     * */
    @Redirect(
            method = "getYRotD",
            at = @At(
                    value = "NEW",
                    target = "(Lorg/joml/Vector3fc;)Lorg/joml/Vector3f;"
            )
    )
    private Vector3f useStaticFinalReferences(Vector3fc vector3fc) {
        return EntityConstants.FORWARD_VECTOR;
    }
}
