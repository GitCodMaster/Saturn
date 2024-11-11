package com.aziz.saturn.mixin.allocations.empty_vector;

import com.aziz.saturn.common.util.constants.SaturnConstants;
import net.minecraft.world.entity.monster.Strider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Strider.class)
public class StriderMixin {
    /**
     * @reason Cache to a static final reference.
     * @author AbdElAziz
     * @since 0.1.0
     * */
    @Overwrite
    protected Vec3 getRiddenInput(Player player, Vec3 vec3) {
        return SaturnConstants.EMPTY_VECTOR3;
    }
}
