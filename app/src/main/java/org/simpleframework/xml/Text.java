package org.simpleframework.xml;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes5.dex */
public @interface Text {
    boolean data() default false;

    String empty() default "";

    boolean required() default true;
}
