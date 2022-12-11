package me.tvspark;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class Llll {
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final C1884Ll Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final Map<Class<?>, C3461Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new HashMap();

        /* renamed from: me.tvspark.Llll$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C3461Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Model> {
            public final List<Llllll<Model, ?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

            public C3461Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<Llllll<Model, ?>> list) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = list;
            }
        }
    }

    public Llll(@NonNull Pools.Pool<List<Throwable>> pool) {
        C1884Ll c1884Ll = new C1884Ll(pool);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c1884Ll;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public final synchronized <A> List<Llllll<A, ?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Class<A> cls) {
        List list;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.C3461Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?> c3461Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(cls);
        list = c3461Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null ? (List<Llllll<A, ?>>) false : c3461Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (list == null) {
            list = (List<Llllll<A, ?>>) Collections.unmodifiableList(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls));
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(cls, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.C3461Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(list)) != null) {
                throw new IllegalStateException("Already cached loaders for model: " + cls);
            }
        }
        return (List<Llllll<A, ?>>) list;
    }

    @NonNull
    public synchronized List<Class<?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Class<?> cls) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls);
    }

    public synchronized <Model, Data> void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull Lllll<? extends Model, ? extends Data> lllll) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls, cls2, lllll);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
    }
}
