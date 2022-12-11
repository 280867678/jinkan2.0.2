package me.tvspark;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes4.dex */
public @interface wd0 {
    int fileSizeThreshold() default 0;

    String location() default "";

    long maxFileSize() default -1;

    long maxRequestSize() default -1;
}
