package com.aziz.saturn.common.util.constants;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;

import java.io.File;

public interface SaturnConstants {
    File SERVER_DIRECTORY = new File(".");
    int[] ZERO = new int[0];
    int[] MULTI_ZERO = new int[]{0};
    Vec3 EMPTY_VECTOR3 = new Vec3(0.0D, 0.0D, 1.0D);
    ResourceLocation[] EMPTY_RESOURCE_LOCATION = new ResourceLocation[0];
}