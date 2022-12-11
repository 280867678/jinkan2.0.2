package me.tvspark;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* renamed from: me.tvspark.ez */
/* loaded from: classes4.dex */
public abstract class AbstractC2092ez<T> {
    public final Type capture() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(genericSuperclass instanceof ParameterizedType, "%s isn't parameterized", genericSuperclass);
        return ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
    }
}
