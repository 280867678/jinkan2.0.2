package com.arialyy.aria.orm.annotation;

import com.arialyy.aria.orm.ActionPolicy;
import com.arialyy.aria.orm.DbEntity;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes3.dex */
public @interface Foreign {
    String column();

    ActionPolicy onDelete() default ActionPolicy.NO_ACTION;

    ActionPolicy onUpdate() default ActionPolicy.NO_ACTION;

    Class<? extends DbEntity> parent();
}
