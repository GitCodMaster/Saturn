package com.aziz.saturn.mixin.gc_heap.unnecessary_object_creation;

import com.mojang.datafixers.types.Type;
import com.mojang.datafixers.types.templates.TypeTemplate;
import com.mojang.serialization.Codec;
import org.checkerframework.checker.units.qual.A;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.Nullable;

@Mixin(Type.class)
public abstract class TypeMixin {
    @Shadow @Nullable
    private Codec<A> codec;

    @Shadow @Nullable
    private TypeTemplate template;

    @Shadow
    protected abstract Codec<A> buildCodec();

    @Shadow
    public abstract TypeTemplate buildTemplate();

    @Inject(
            method = "<init>",
            at = @At(
                    value = "TAIL"
            )
    )
    private void nullValue(CallbackInfo ci) {
        codec = null;
        template = null;
    }

    /**
     * @reason Avoid unnecessary object creation.
     * @author AbdElAziz
     * @since 0.0.8
     * */
    @Overwrite (remap = false)
    public final Codec<A> codec() {
        return buildCodec();
    }

    /**
     * @reason Avoid unnecessary object creation.
     * @author AbdElAziz
     * @since 0.0.8
     * */
    @Overwrite (remap = false)
    public TypeTemplate template() {
        return buildTemplate();
    }
}