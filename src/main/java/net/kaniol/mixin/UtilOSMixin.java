package net.kaniol.mixin;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.Util;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Util.OS.class)
public class UtilOSMixin {
    @Redirect(
            method = "openUrl(Ljava/net/URL;)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lorg/apache/commons/io/IOUtils;readLines(Ljava/io/InputStream;)Ljava/util/List;"
            )
    )
    private List<String> onError(InputStream input) {
        return new ArrayList<String>();
    }
}
