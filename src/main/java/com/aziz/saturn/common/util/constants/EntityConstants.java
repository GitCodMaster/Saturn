package com.aziz.saturn.common.util.constants;

import net.minecraft.world.entity.monster.Shulker;
import net.minecraft.world.item.ItemCooldowns;
import org.joml.Vector3f;

public interface EntityConstants {
    ItemCooldowns ITEM_COOLDOWNS = new ItemCooldowns();
    float[] WHITE_SHEEP_COLOR = new float[]{0.9019608F, 0.9019608F, 0.9019608F};
    Vector3f FORWARD_VECTOR = new Vector3f(Shulker.FORWARD);
}
