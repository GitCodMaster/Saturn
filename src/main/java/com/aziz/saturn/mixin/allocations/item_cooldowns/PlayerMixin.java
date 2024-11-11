package com.aziz.saturn.mixin.allocations.item_cooldowns;

import com.aziz.saturn.common.util.constants.EntityConstants;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemCooldowns;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Player.class)
public class PlayerMixin {
    /**
     * @reason Cache to a static final reference.
     * @author AbdElAziz
     * @since 0.1.0
     * */
    @Overwrite
    protected ItemCooldowns createItemCooldowns() {
        return EntityConstants.ITEM_COOLDOWNS;
    }
}
