package me.tvspark;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.request.SingleRequest;
import java.io.File;
import java.util.Map;
import java.util.concurrent.Executor;
import me.tvspark.C2619t1;
import me.tvspark.O000000;
import me.tvspark.Sss;
import me.tvspark.Sssssssssss;

/* loaded from: classes4.dex */
public class IIl implements O000000000, Sss.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, O000000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    public static final boolean Wwwwwwwwwwwwwwwwwwwwwwwwww = Log.isLoggable("Engine", 2);
    public final C1882Il Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Sss Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final O0000000 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new O0000000();
    public final O0000 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new O0000();
    public final OO0000000 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new OO0000000();

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final AbstractC2581s0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final O0000000000<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2581s0 abstractC2581s0, O0000000000<?> o0000000000) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2581s0;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = o0000000000;
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            synchronized (IIl.this) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DecodeJob.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public volatile Sssssssssss Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final Sssssssssss.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Sssssssssss.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        public Sssssssssss Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                synchronized (this) {
                    if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                        Ssssssss ssssssss = (Ssssssss) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        Ssssss ssssss = (Ssssss) ssssssss.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        File cacheDir = ssssss.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getCacheDir();
                        Sssssss sssssss = null;
                        if (cacheDir == null) {
                            cacheDir = null;
                        } else if (ssssss.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                            cacheDir = new File(cacheDir, ssssss.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        }
                        if (cacheDir != null && (cacheDir.mkdirs() || (cacheDir.exists() && cacheDir.isDirectory()))) {
                            sssssss = new Sssssss(cacheDir, ssssssss.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        }
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = sssssss;
                    }
                    if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Ssssssssss();
                    }
                }
            }
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    @VisibleForTesting
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final Pools.Pool<O0000000000<?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwww = C2619t1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(150, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        public final O000000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final O000000000 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final Oooooooooo Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final Oooooooooo Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final Oooooooooo Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final Oooooooooo Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements C2619t1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<O0000000000<?>> {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            }

            @Override // me.tvspark.C2619t1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
            public O0000000000<?> create() {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this;
                return new O0000000000<>(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Oooooooooo oooooooooo, Oooooooooo oooooooooo2, Oooooooooo oooooooooo3, Oooooooooo oooooooooo4, O000000000 o000000000, O000000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = oooooooooo;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = oooooooooo2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = oooooooooo3;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = oooooooooo4;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = o000000000;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    @VisibleForTesting
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final Pools.Pool<DecodeJob<?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2619t1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(150, new C3459Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        public final DecodeJob.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        /* renamed from: me.tvspark.IIl$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C3459Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements C2619t1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<DecodeJob<?>> {
            public C3459Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            }

            @Override // me.tvspark.C2619t1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
            public DecodeJob<?> create() {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this;
                return new DecodeJob<>(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DecodeJob.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    public IIl(Sss sss, Sssssssssss.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Oooooooooo oooooooooo, Oooooooooo oooooooooo2, Oooooooooo oooooooooo3, Oooooooooo oooooooooo4, boolean z) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = sss;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        C1882Il c1882Il = new C1882Il(z);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = c1882Il;
        c1882Il.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(oooooooooo, oooooooooo2, oooooooooo3, oooooooooo4, this, this);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        ((Ssss) sss).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this;
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, long j, Illlllllllllllllllllllllllll illlllllllllllllllllllllllll) {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, " in ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(C2428o1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("ms, key: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(illlllllllllllllllllllllllll);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
    }

    public <R> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Kkkkkkkkkkkkkk kkkkkkkkkkkkkk, Object obj, Illlllllllllllllllllllllllll illlllllllllllllllllllllllll, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, IIll iIll, Map<Class<?>, Illlllllllllllllllllll<?>> map, boolean z, boolean z2, Illllllllllllllllllllllll illllllllllllllllllllllll, boolean z3, boolean z4, boolean z5, boolean z6, AbstractC2581s0 abstractC2581s0, Executor executor) {
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwww ? C2428o1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() : 0L;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            O00000000 o00000000 = new O00000000(obj, illlllllllllllllllllllllllll, i, i2, map, cls, cls2, illllllllllllllllllllllll);
            synchronized (this) {
                O000000<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(o00000000, z3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == null) {
                    return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(kkkkkkkkkkkkkk, obj, illlllllllllllllllllllllllll, i, i2, cls, cls2, priority, iIll, map, z, z2, illllllllllllllllllllllll, z3, z4, z5, z6, abstractC2581s0, executor, o00000000, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                }
                ((SingleRequest) abstractC2581s0).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, DataSource.MEMORY_CACHE);
                return null;
            }
        }
        throw null;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC1886O0<?> abstractC1886O0) {
        if (abstractC1886O0 instanceof O000000) {
            ((O000000) abstractC1886O0).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    @Nullable
    public final O000000<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(O00000000 o00000000, boolean z, long j) {
        if (!z) {
            return null;
        }
        O000000<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(o00000000);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Loaded resource from active resources", j, o00000000);
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        }
        AbstractC1886O0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = ((Ssss) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Illlllllllllllllllllllllllll) o00000000);
        O000000<?> o000000 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null ? null : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 instanceof O000000 ? (O000000) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 : new O000000<>(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, true, true, o00000000, this);
        if (o000000 != null) {
            o000000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(o00000000, o000000);
        }
        if (o000000 == null) {
            return null;
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Loaded resource from cache", j, o00000000);
        }
        return o000000;
    }

    public synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(O0000000000<?> o0000000000, Illlllllllllllllllllllllllll illlllllllllllllllllllllllll) {
        O0000 o0000 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (o0000 != null) {
            Map<Illlllllllllllllllllllllllll, O0000000000<?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = o0000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(o0000000000.Wwwwwwwww);
            if (o0000000000.equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.get(illlllllllllllllllllllllllll))) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.remove(illlllllllllllllllllllllllll);
            }
        } else {
            throw null;
        }
    }

    public synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(O0000000000<?> o0000000000, Illlllllllllllllllllllllllll illlllllllllllllllllllllllll, O000000<?> o000000) {
        if (o000000 != null) {
            if (o000000.Wwwwwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(illlllllllllllllllllllllllll, o000000);
            }
        }
        O0000 o0000 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (o0000 != null) {
            Map<Illlllllllllllllllllllllllll, O0000000000<?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = o0000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(o0000000000.Wwwwwwwww);
            if (o0000000000.equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.get(illlllllllllllllllllllllllll))) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.remove(illlllllllllllllllllllllllll);
            }
        } else {
            throw null;
        }
    }

    @Override // me.tvspark.O000000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illlllllllllllllllllllllllll illlllllllllllllllllllllllll, O000000<?> o000000) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(illlllllllllllllllllllllllll);
        if (o000000.Wwwwwwwwwwwwwwwwwwwwwwww) {
            ((Ssss) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2(illlllllllllllllllllllllllll, (AbstractC1886O0) o000000);
        } else {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(o000000, false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Kkkkkkkkkkkkkk kkkkkkkkkkkkkk, Object obj, Illlllllllllllllllllllllllll illlllllllllllllllllllllllll, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, IIll iIll, Map<Class<?>, Illlllllllllllllllllll<?>> map, boolean z, boolean z2, Illllllllllllllllllllllll illllllllllllllllllllllll, boolean z3, boolean z4, boolean z5, boolean z6, AbstractC2581s0 abstractC2581s0, Executor executor, O00000000 o00000000, long j) {
        O0000 o0000 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        O0000000000<?> o0000000000 = (z6 ? o0000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : o0000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).get(o00000000);
        if (o0000000000 != null) {
            o0000000000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2581s0, executor);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Added to existing load", j, o00000000);
            }
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2581s0, o0000000000);
        }
        O0000000000<?> acquire = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.acquire();
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(acquire, "Argument must not be null");
        acquire.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(o00000000, z3, z4, z5, z6);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        DecodeJob<?> acquire2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.acquire();
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(acquire2, "Argument must not be null");
        int i3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3 + 1;
        IIllll<?> iIllll = acquire2.Wwwwwwwwwwwwwwwwwwwwwwww;
        DecodeJob.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = acquire2.Wwwwwwwwwwwwwwwwwwwww;
        iIllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = kkkkkkkkkkkkkk;
        iIllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = obj;
        iIllll.Wwwwwwwwwwwwwwwwwwwww = illlllllllllllllllllllllllll;
        iIllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        iIllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        iIllll.Wwwwwwwwwwwwwwwwwww = iIll;
        iIllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = cls;
        iIllll.Wwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        iIllll.Wwwwwwwwwwwwwwwwwwwwwwww = cls2;
        iIllll.Wwwwwwwwwwwwwwwwwwww = priority;
        iIllll.Wwwwwwwwwwwwwwwwwwwwwwwwww = illllllllllllllllllllllll;
        iIllll.Wwwwwwwwwwwwwwwwwwwwwwwww = map;
        iIllll.Wwwwwwwwwwwwwwwwww = z;
        iIllll.Wwwwwwwwwwwwwwwww = z2;
        acquire2.Wwwwwwwwwwwwwwwww = kkkkkkkkkkkkkk;
        acquire2.Wwwwwwwwwwwwwwww = illlllllllllllllllllllllllll;
        acquire2.Wwwwwwwwwwwwwww = priority;
        acquire2.Wwwwwwwwwwwwww = o00000000;
        acquire2.Wwwwwwwwwwwww = i;
        acquire2.Wwwwwwwwwwww = i2;
        acquire2.Wwwwwwwwwww = iIll;
        acquire2.Wwww = z6;
        acquire2.Wwwwwwwwww = illllllllllllllllllllllll;
        acquire2.Wwwwwwwww = acquire;
        acquire2.Wwwwwwww = i3;
        acquire2.Wwwwww = DecodeJob.RunReason.INITIALIZE;
        acquire2.Www = obj;
        O0000 o00002 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (o00002 != null) {
            o00002.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(acquire.Wwwwwwwww).put(o00000000, acquire);
            acquire.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2581s0, executor);
            acquire.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(acquire2);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Started new load", j, o00000000);
            }
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2581s0, acquire);
        }
        throw null;
    }
}
