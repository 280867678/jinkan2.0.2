package me.tvspark;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: me.tvspark.k0 */
/* loaded from: classes4.dex */
public class C2279k0 {
    public static final O000<?, ?, ?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new O000<>(Object.class, Object.class, Object.class, Collections.singletonList(new IIlll(Object.class, Object.class, Object.class, Collections.emptyList(), new C2352m(), null)), null);
    public final ArrayMap<C2545r1, O000<?, ?, ?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayMap<>();
    public final AtomicReference<C2545r1> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new AtomicReference<>();

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public <Data, TResource, Transcode> O000<Data, TResource, Transcode> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        O000<Data, TResource, Transcode> o000;
        C2545r1 andSet = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getAndSet(null);
        if (andSet == null) {
            andSet = new C2545r1();
        }
        andSet.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = cls;
        andSet.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = cls2;
        andSet.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = cls3;
        synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            o000 = (O000<Data, TResource, Transcode>) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(andSet);
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.set(andSet);
        return o000;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class<?> cls, Class<?> cls2, Class<?> cls3, @Nullable O000<?, ?, ?> o000) {
        synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            ArrayMap<C2545r1, O000<?, ?, ?>> arrayMap = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            C2545r1 c2545r1 = new C2545r1(cls, cls2, cls3);
            if (o000 == null) {
                o000 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            arrayMap.put(c2545r1, o000);
        }
    }
}
