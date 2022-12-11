package me.tvspark;

import java.lang.reflect.Field;

/* renamed from: me.tvspark.rx */
/* loaded from: classes4.dex */
public final class C2577rx<T> {
    public final Field Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public /* synthetic */ C2577rx(Field field, C2540qx c2540qx) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = field;
        field.setAccessible(true);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T t, Object obj) {
        try {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.set(t, obj);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }
}
