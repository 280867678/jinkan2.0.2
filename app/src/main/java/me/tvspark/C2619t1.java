package me.tvspark;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import java.util.List;
import me.tvspark.AbstractC2734w1;

/* renamed from: me.tvspark.t1 */
/* loaded from: classes4.dex */
public final class C2619t1 {
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Object> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* renamed from: me.tvspark.t1$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull T t);
    }

    /* renamed from: me.tvspark.t1$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        @NonNull
        AbstractC2734w1 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    /* renamed from: me.tvspark.t1$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> implements Pools.Pool<T> {
        public final Pools.Pool<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Pools.Pool<T> pool, @NonNull Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, @NonNull Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = pool;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            T acquire = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.acquire();
            if (acquire == null) {
                acquire = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.create();
                if (Log.isLoggable("FactoryPools", 2)) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Created new ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(acquire.getClass());
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
                }
            }
            if (acquire instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                ((AbstractC2734w1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) acquire).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
            }
            return acquire;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(@NonNull T t) {
            if (t instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                ((AbstractC2734w1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) t).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t);
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.release(t);
        }
    }

    /* renamed from: me.tvspark.t1$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> {
        T create();
    }

    /* renamed from: me.tvspark.t1$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Object> {
        @Override // me.tvspark.C2619t1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Object obj) {
        }
    }

    @NonNull
    public static <T extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Pools.Pool<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, @NonNull Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Pools.SynchronizedPool(i), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Pools.SynchronizedPool(20), new C2656u1(), new C2694v1());
    }
}
