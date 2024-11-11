package com.aziz.saturn.mixin.allocations.composter;

import com.aziz.saturn.common.util.constants.SaturnConstants;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.ComposterBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

public class ComposterBlockMixin {
    @Mixin(ComposterBlock.EmptyContainer.class)
    static class EmptyContainerMixin {
        /**
         * @reason Cache to a static final reference.
         * @author AbdElAziz
         * @since 0.1.0
         * */
        @Overwrite
        public int[] getSlotsForFace(Direction side) {
            return SaturnConstants.ZERO;
        }
    }

    @Mixin(ComposterBlock.InputContainer.class)
    static class InputContainerMixin {
        /**
         * @reason Cache to a static final reference.
         * @author AbdElAziz
         * @since 0.1.0
         * */
        @Overwrite
        public int[] getSlotsForFace(Direction side) {
            return side == Direction.UP ? SaturnConstants.MULTI_ZERO : SaturnConstants.ZERO;
        }
    }

    @Mixin(ComposterBlock.OutputContainer.class)
    static class OutputContainerMixin {
        /**
         * @reason Cache to a static final reference.
         * @author AbdElAziz
         * @since 0.1.0
         * */
        @Overwrite
        public int[] getSlotsForFace(Direction side) {
            return side == Direction.DOWN ? SaturnConstants.MULTI_ZERO : SaturnConstants.ZERO;
        }
    }
}
