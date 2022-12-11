package me.tvspark;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import me.tvspark.Llllll;

/* renamed from: me.tvspark.Ll */
/* loaded from: classes4.dex */
public class C1884Ll {
    public final Pools.Pool<List<Throwable>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public static final Llllll<Object, Object> Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?, ?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
    public final Set<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?, ?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new HashSet();

    /* renamed from: me.tvspark.Ll$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* renamed from: me.tvspark.Ll$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Model, Data> {
        public final Lllll<? extends Model, ? extends Data> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final Class<Data> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final Class<Model> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull Lllll<? extends Model, ? extends Data> lllll) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = cls;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = cls2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = lllll;
        }
    }

    /* renamed from: me.tvspark.Ll$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Llllll<Object, Object> {
        @Override // me.tvspark.Llllll
        @Nullable
        public Llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Object> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Object obj, int i, int i2, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) {
            return null;
        }

        @Override // me.tvspark.Llllll
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Object obj) {
            return false;
        }
    }

    public C1884Ll(@NonNull Pools.Pool<List<Throwable>> pool) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = pool;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @NonNull
    public synchronized List<Class<?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?, ?> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (!arrayList.contains(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isAssignableFrom(cls)) {
                arrayList.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }
        return arrayList;
    }

    public synchronized <Model, Data> void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull Lllll<? extends Model, ? extends Data> lllll) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?, ?> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(cls, cls2, lllll);
        List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?, ?>> list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        list.add(list.size(), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @NonNull
    public final <Model, Data> Llllll<Model, Data> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?, ?> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        Llllll<Model, Data> llllll = (Llllll<Model, Data>) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(llllll, "Argument must not be null");
        return llllll;
    }

    @NonNull
    public synchronized <Model, Data> Llllll<Model, Data> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?, ?> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.contains(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    z = true;
                } else if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isAssignableFrom(cls) && wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isAssignableFrom(cls2)) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    arrayList.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remove(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
            }
            if (arrayList.size() > 1) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                Pools.Pool<List<Throwable>> pool = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    return new Lll(arrayList, pool);
                }
                throw null;
            } else if (arrayList.size() == 1) {
                return (Llllll) arrayList.get(0);
            } else if (z) {
                return (Llllll<Model, Data>) Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            } else {
                throw new Registry.NoModelLoaderAvailableException((Class<?>) cls, (Class<?>) cls2);
            }
        } catch (Throwable th) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
            throw th;
        }
    }

    @NonNull
    public synchronized <Model> List<Llllll<Model, ?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?, ?> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.contains(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isAssignableFrom(cls)) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    Llllll<? extends Object, ? extends Object> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, "Argument must not be null");
                    arrayList.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remove(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
            }
        } catch (Throwable th) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
            throw th;
        }
        return arrayList;
    }
}
