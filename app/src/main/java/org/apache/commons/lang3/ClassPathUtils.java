package org.apache.commons.lang3;

import com.umeng.analytics.pro.C1615d;

/* loaded from: classes4.dex */
public class ClassPathUtils {
    public static String toFullyQualifiedName(Class<?> cls, String str) {
        Validate.notNull(cls, "Parameter '%s' must not be null!", C1615d.f3292R);
        Validate.notNull(str, "Parameter '%s' must not be null!", "resourceName");
        return toFullyQualifiedName(cls.getPackage(), str);
    }

    public static String toFullyQualifiedName(Package r4, String str) {
        Validate.notNull(r4, "Parameter '%s' must not be null!", C1615d.f3292R);
        Validate.notNull(str, "Parameter '%s' must not be null!", "resourceName");
        return r4.getName() + "." + str;
    }

    public static String toFullyQualifiedPath(Class<?> cls, String str) {
        Validate.notNull(cls, "Parameter '%s' must not be null!", C1615d.f3292R);
        Validate.notNull(str, "Parameter '%s' must not be null!", "resourceName");
        return toFullyQualifiedPath(cls.getPackage(), str);
    }

    public static String toFullyQualifiedPath(Package r4, String str) {
        Validate.notNull(r4, "Parameter '%s' must not be null!", C1615d.f3292R);
        Validate.notNull(str, "Parameter '%s' must not be null!", "resourceName");
        return r4.getName().replace('.', '/') + "/" + str;
    }
}
