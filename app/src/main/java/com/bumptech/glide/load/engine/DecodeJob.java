package com.bumptech.glide.load.engine;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.AbstractC1886O0;
import me.tvspark.AbstractC2734w1;
import me.tvspark.C2428o1;
import me.tvspark.C2619t1;
import me.tvspark.IIl;
import me.tvspark.IIll;
import me.tvspark.IIlll;
import me.tvspark.IIllll;
import me.tvspark.IIlllll;
import me.tvspark.IIllllll;
import me.tvspark.IIllllllll;
import me.tvspark.Illlllllllllllll;
import me.tvspark.Illllllllllllllll;
import me.tvspark.Illlllllllllllllll;
import me.tvspark.Illllllllllllllllllllll;
import me.tvspark.Illllllllllllllllllllllll;
import me.tvspark.Illlllllllllllllllllllllllll;
import me.tvspark.Kkkkkkkkkkkkkk;
import me.tvspark.O00;
import me.tvspark.O000;
import me.tvspark.O00000;
import me.tvspark.O00000000;
import me.tvspark.O0000000000;
import me.tvspark.OO00000;
import me.tvspark.OO000000000;
import me.tvspark.Zzzzzzz;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class DecodeJob<R> implements IIlllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Runnable, Comparable<DecodeJob<?>>, C2619t1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    public volatile boolean Kkkkkkkkkkkkkkkkkk;
    public volatile boolean Kkkkkkkkkkkkkkkkkkk;
    public volatile IIlllll Kkkkkkkkkkkkkkkkkkkk;
    public Illlllllllllllllll<?> Kkkkkkkkkkkkkkkkkkkkk;
    public DataSource Kkkkkkkkkkkkkkkkkkkkkk;
    public Object Kkkkkkkkkkkkkkkkkkkkkkk;
    public Illlllllllllllllllllllllllll Kkkkkkkkkkkkkkkkkkkkkkkk;
    public Illlllllllllllllllllllllllll Kkkkkkkkkkkkkkkkkkkkkkkkk;
    public Thread Kkkkkkkkkkkkkkkkkkkkkkkkkk;
    public Object Www;
    public boolean Wwww;
    public long Wwwww;
    public RunReason Wwwwww;
    public Stage Wwwwwww;
    public int Wwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R> Wwwwwwwww;
    public Illllllllllllllllllllllll Wwwwwwwwww;
    public IIll Wwwwwwwwwww;
    public int Wwwwwwwwwwww;
    public int Wwwwwwwwwwwww;
    public O00000000 Wwwwwwwwwwwwww;
    public Priority Wwwwwwwwwwwwwww;
    public Illlllllllllllllllllllllllll Wwwwwwwwwwwwwwww;
    public Kkkkkkkkkkkkkk Wwwwwwwwwwwwwwwww;
    public final Pools.Pool<DecodeJob<?>> Wwwwwwwwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwww;
    public final IIllll<R> Wwwwwwwwwwwwwwwwwwwwwwww = new IIllll<>();
    public final List<Throwable> Wwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
    public final AbstractC2734w1 Wwwwwwwwwwwwwwwwwwwwww = new AbstractC2734w1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?> Wwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>();
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* loaded from: classes3.dex */
    public enum RunReason {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    /* loaded from: classes3.dex */
    public enum Stage {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        }

        public synchronized boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
        }

        public synchronized boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
        }

        public synchronized boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
        }

        public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
            return (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || z || this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Z> {
        public O00<Z> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public Illllllllllllllllllllll<Z> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public Illlllllllllllllllllllllllll Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    /* loaded from: classes3.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Z> implements IIlll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Z> {
        public final DataSource Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DataSource dataSource) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = dataSource;
        }
    }

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R> {
    }

    public DecodeJob(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Pools.Pool<DecodeJob<?>> pool) {
        this.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwww = pool;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwww() {
        Throwable th;
        this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (!this.Kkkkkkkkkkkkkkkkkkk) {
            this.Kkkkkkkkkkkkkkkkkkk = true;
            return;
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
            th = null;
        } else {
            List<Throwable> list = this.Wwwwwwwwwwwwwwwwwwwwwww;
            th = list.get(list.size() - 1);
        }
        throw new IllegalStateException("Already notified", th);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int ordinal = this.Wwwwww.ordinal();
        if (ordinal == 0) {
            this.Wwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Stage.INITIALIZE);
            this.Kkkkkkkkkkkkkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        } else if (ordinal != 1) {
            if (ordinal == 2) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return;
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unrecognized run reason: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwww);
            throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Kkkkkkkkkkkkkkkkkkkkkkkkkk = Thread.currentThread();
        this.Wwwww = C2428o1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        boolean z = false;
        while (!this.Kkkkkkkkkkkkkkkkkk && this.Kkkkkkkkkkkkkkkkkkkk != null && !(z = this.Kkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww())) {
            this.Wwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwww);
            this.Kkkkkkkkkkkkkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (this.Wwwwwww == Stage.SOURCE) {
                this.Wwwwww = RunReason.SWITCH_TO_SOURCE_SERVICE;
                ((O0000000000) this.Wwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((DecodeJob<?>) this);
                return;
            }
        }
        if ((this.Wwwwwww == Stage.FINISHED || this.Kkkkkkkkkkkkkkkkkk) && !z) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        IIllll<R> iIllll = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        iIllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        iIllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        iIllll.Wwwwwwwwwwwwwwwwwwwww = null;
        iIllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        iIllll.Wwwwwwwwwwwwwwwwwwwwwwww = null;
        iIllll.Wwwwwwwwwwwwwwwwwwwwwwwwww = null;
        iIllll.Wwwwwwwwwwwwwwwwwwww = null;
        iIllll.Wwwwwwwwwwwwwwwwwwwwwwwww = null;
        iIllll.Wwwwwwwwwwwwwwwwwww = null;
        iIllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
        iIllll.Wwwwwwwwwwwwwwwwwwwwwww = false;
        iIllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
        iIllll.Wwwwwwwwwwwwwwwwwwwwww = false;
        this.Kkkkkkkkkkkkkkkkkkk = false;
        this.Wwwwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwwwww = null;
        this.Wwwwwwwwww = null;
        this.Wwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwww = null;
        this.Wwwwwwwww = null;
        this.Wwwwwww = null;
        this.Kkkkkkkkkkkkkkkkkkkk = null;
        this.Kkkkkkkkkkkkkkkkkkkkkkkkkk = null;
        this.Kkkkkkkkkkkkkkkkkkkkkkkkk = null;
        this.Kkkkkkkkkkkkkkkkkkkkkkk = null;
        this.Kkkkkkkkkkkkkkkkkkkkkk = null;
        this.Kkkkkkkkkkkkkkkkkkkkk = null;
        this.Wwwww = 0L;
        this.Kkkkkkkkkkkkkkkkkk = false;
        this.Www = null;
        this.Wwwwwwwwwwwwwwwwwwwwwww.clear();
        this.Wwwwwwwwwwwwwwwwwwww.release(this);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwwwwwwwwwww();
        ((O0000000000) this.Wwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new GlideException("Failed to load resource", new ArrayList(this.Wwwwwwwwwwwwwwwwwwwwwww)));
        if (this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public final IIlllll Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int ordinal = this.Wwwwwww.ordinal();
        if (ordinal != 1) {
            if (ordinal == 2) {
                return new IIllllllll(this.Wwwwwwwwwwwwwwwwwwwwwwww, this);
            }
            if (ordinal == 3) {
                return new OO00000(this.Wwwwwwwwwwwwwwwwwwwwwwww, this);
            }
            if (ordinal == 5) {
                return null;
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unrecognized stage: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwww);
            throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        }
        return new OO000000000(this.Wwwwwwwwwwwwwwwwwwwwwwww, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        AbstractC1886O0<R> abstractC1886O0;
        O00 o00;
        if (Log.isLoggable("DecodeJob", 2)) {
            long j = this.Wwwww;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("data: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Kkkkkkkkkkkkkkkkkkkkkkk);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(", cache key: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Kkkkkkkkkkkkkkkkkkkkkkkkk);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(", fetcher: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Kkkkkkkkkkkkkkkkkkkkk);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Retrieved data", j, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        }
        try {
            abstractC1886O0 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkkkkk, (Illlllllllllllllll<?>) this.Kkkkkkkkkkkkkkkkkkkkkkk, this.Kkkkkkkkkkkkkkkkkkkkkk);
        } catch (GlideException e) {
            e.setLoggingDetails(this.Kkkkkkkkkkkkkkkkkkkkkkkk, this.Kkkkkkkkkkkkkkkkkkkkkk);
            this.Wwwwwwwwwwwwwwwwwwwwwww.add(e);
            abstractC1886O0 = null;
        }
        if (abstractC1886O0 != null) {
            DataSource dataSource = this.Kkkkkkkkkkkkkkkkkkkkkk;
            if (abstractC1886O0 instanceof O00000) {
                ((O00000) abstractC1886O0).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            boolean z = true;
            if (this.Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                abstractC1886O0 = O00.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1886O0);
                o00 = abstractC1886O0;
            } else {
                o00 = 0;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwww();
            ((O0000000000) this.Wwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1886O0, dataSource);
            this.Wwwwwww = Stage.ENCODE;
            try {
                if (this.Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                    z = false;
                }
                if (z) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwww;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwww;
                    Illllllllllllllllllllllll illllllllllllllllllllllll = this.Wwwwwwwwww;
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                        throw null;
                    }
                    ((IIl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new IIllllll(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, illllllllllllllllllllllll));
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
                if (!this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    return;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return;
            } finally {
                if (o00 != 0) {
                    o00.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
            }
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.IIlllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwww = RunReason.SWITCH_TO_SOURCE_SERVICE;
        ((O0000000000) this.Wwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((DecodeJob<?>) this);
    }

    public final Stage Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Stage stage) {
        int ordinal = stage.ordinal();
        if (ordinal == 0) {
            return this.Wwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() ? Stage.RESOURCE_CACHE : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Stage.RESOURCE_CACHE);
        } else if (ordinal == 1) {
            return this.Wwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() ? Stage.DATA_CACHE : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Stage.DATA_CACHE);
        } else if (ordinal == 2) {
            return this.Wwww ? Stage.FINISHED : Stage.SOURCE;
        } else if (ordinal == 3 || ordinal == 5) {
            return Stage.FINISHED;
        } else {
            throw new IllegalArgumentException("Unrecognized stage: " + stage);
        }
    }

    public final <Data> AbstractC1886O0<R> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illlllllllllllllll<?> illlllllllllllllll, Data data, DataSource dataSource) throws GlideException {
        if (data == null) {
            return null;
        }
        try {
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2428o1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            AbstractC1886O0<R> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(data, dataSource);
            if (Log.isLoggable("DecodeJob", 2)) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Decoded result " + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, (String) null);
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
        } finally {
            illlllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    @Override // me.tvspark.C2619t1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    @NonNull
    public AbstractC2734w1 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwww;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, long j, String str2) {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, " in ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(C2428o1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(", load key: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(str2 != null ? outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(", ", str2) : "");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(", thread: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(Thread.currentThread().getName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
    }

    @Override // me.tvspark.IIlllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illlllllllllllllllllllllllll illlllllllllllllllllllllllll, Exception exc, Illlllllllllllllll<?> illlllllllllllllll, DataSource dataSource) {
        illlllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        GlideException glideException = new GlideException("Fetching data failed", exc);
        glideException.setLoggingDetails(illlllllllllllllllllllllllll, dataSource, illlllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        this.Wwwwwwwwwwwwwwwwwwwwwww.add(glideException);
        if (Thread.currentThread() == this.Kkkkkkkkkkkkkkkkkkkkkkkkkk) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return;
        }
        this.Wwwwww = RunReason.SWITCH_TO_SOURCE_SERVICE;
        ((O0000000000) this.Wwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((DecodeJob<?>) this);
    }

    @Override // me.tvspark.IIlllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illlllllllllllllllllllllllll illlllllllllllllllllllllllll, Object obj, Illlllllllllllllll<?> illlllllllllllllll, DataSource dataSource, Illlllllllllllllllllllllllll illlllllllllllllllllllllllll2) {
        this.Kkkkkkkkkkkkkkkkkkkkkkkkk = illlllllllllllllllllllllllll;
        this.Kkkkkkkkkkkkkkkkkkkkkkk = obj;
        this.Kkkkkkkkkkkkkkkkkkkkk = illlllllllllllllll;
        this.Kkkkkkkkkkkkkkkkkkkkkk = dataSource;
        this.Kkkkkkkkkkkkkkkkkkkkkkkk = illlllllllllllllllllllllllll2;
        if (Thread.currentThread() == this.Kkkkkkkkkkkkkkkkkkkkkkkkkk) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return;
        }
        this.Wwwwww = RunReason.DECODE_DATA;
        ((O0000000000) this.Wwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((DecodeJob<?>) this);
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull DecodeJob<?> decodeJob) {
        DecodeJob<?> decodeJob2 = decodeJob;
        int ordinal = this.Wwwwwwwwwwwwwww.ordinal() - decodeJob2.Wwwwwwwwwwwwwww.ordinal();
        return ordinal == 0 ? this.Wwwwwwww - decodeJob2.Wwwwwwww : ordinal;
    }

    @Override // java.lang.Runnable
    public void run() {
        Illlllllllllllllll<?> illlllllllllllllll = this.Kkkkkkkkkkkkkkkkkkkkk;
        try {
            try {
                if (this.Kkkkkkkkkkkkkkkkkk) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    if (illlllllllllllllll == null) {
                        return;
                    }
                    illlllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    return;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwww();
                if (illlllllllllllllll == null) {
                    return;
                }
                illlllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            } catch (CallbackException e) {
                throw e;
            }
        }
    }

    public final <Data> AbstractC1886O0<R> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Data data, DataSource dataSource) throws GlideException {
        O000<Data, ?, R> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(data.getClass());
        Illllllllllllllllllllllll illllllllllllllllllllllll = this.Wwwwwwwwww;
        if (Build.VERSION.SDK_INT >= 26) {
            boolean z = dataSource == DataSource.RESOURCE_DISK_CACHE || this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww;
            Boolean bool = (Boolean) illllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Zzzzzzz.Wwwwwwwwwwwwwwwwwwwwwwwwww);
            if (bool == null || (bool.booleanValue() && !z)) {
                illllllllllllllllllllllll = new Illllllllllllllllllllllll();
                illllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwww);
                illllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(Zzzzzzz.Wwwwwwwwwwwwwwwwwwwwwwwwww, Boolean.valueOf(z));
            }
        }
        Illllllllllllllllllllllll illllllllllllllllllllllll2 = illllllllllllllllllllllll;
        Illllllllllllllll<Data> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.Wwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Illlllllllllllll) data);
        try {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, illllllllllllllllllllllll2, this.Wwwwwwwwwwwww, this.Wwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dataSource));
        } finally {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }
}
