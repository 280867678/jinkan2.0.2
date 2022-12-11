package javax.servlet.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import me.tvspark.ud0;
import me.tvspark.vd0;

@Target({ElementType.TYPE})
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes4.dex */
public @interface ServletSecurity {

    /* loaded from: classes4.dex */
    public enum EmptyRoleSemantic {
        PERMIT,
        DENY
    }

    /* loaded from: classes4.dex */
    public enum TransportGuarantee {
        NONE,
        CONFIDENTIAL
    }

    vd0[] httpMethodConstraints() default {};

    ud0 value() default @ud0;
}
