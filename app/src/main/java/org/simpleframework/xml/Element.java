package org.simpleframework.xml;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes5.dex */
public @interface Element {
    boolean data() default false;

    String name() default "";

    boolean required() default true;

    Class type() default void.class;
}
