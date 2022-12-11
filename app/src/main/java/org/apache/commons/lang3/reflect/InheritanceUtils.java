package org.apache.commons.lang3.reflect;

import org.apache.commons.lang3.BooleanUtils;

/* loaded from: classes4.dex */
public class InheritanceUtils {
    public static int distance(Class<?> cls, Class<?> cls2) {
        if (cls == null || cls2 == null) {
            return -1;
        }
        if (cls.equals(cls2)) {
            return 0;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        int integer = BooleanUtils.toInteger(cls2.equals(superclass));
        if (integer == 1) {
            return integer;
        }
        int distance = distance(superclass, cls2) + integer;
        if (distance <= 0) {
            return -1;
        }
        return distance + 1;
    }
}
