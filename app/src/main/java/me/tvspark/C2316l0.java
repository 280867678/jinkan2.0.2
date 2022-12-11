package me.tvspark;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: me.tvspark.l0 */
/* loaded from: classes4.dex */
public class C2316l0 {
    public final AtomicReference<C2545r1> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new AtomicReference<>();
    public final ArrayMap<C2545r1, List<Class<?>>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayMap<>();

    @Nullable
    public List<Class<?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull Class<?> cls3) {
        List<Class<?>> list;
        C2545r1 andSet = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getAndSet(null);
        if (andSet == null) {
            andSet = new C2545r1(cls, cls2, cls3);
        } else {
            andSet.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = cls;
            andSet.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = cls2;
            andSet.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = cls3;
        }
        synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(andSet);
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.set(andSet);
        return list;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull Class<?> cls3, @NonNull List<Class<?>> list) {
        synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(new C2545r1(cls, cls2, cls3), list);
        }
    }
}
