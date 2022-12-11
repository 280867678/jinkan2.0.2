package me.tvspark;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.SingleRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.AbstractC2734w1;
import me.tvspark.C2619t1;
import me.tvspark.O000000;

/* loaded from: classes4.dex */
public class O0000000000<R> implements DecodeJob.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R>, C2619t1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Kkkkkkkkkkkkkkkkkkkkkkkk = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public volatile boolean Kkkkkkkkkkkkkkkkkkkkkkkkk;
    public DecodeJob<R> Kkkkkkkkkkkkkkkkkkkkkkkkkk;
    public O000000<?> Www;
    public boolean Wwww;
    public GlideException Wwwww;
    public boolean Wwwwww;
    public DataSource Wwwwwww;
    public AbstractC1886O0<?> Wwwwwwww;
    public boolean Wwwwwwwww;
    public boolean Wwwwwwwwww;
    public boolean Wwwwwwwwwww;
    public boolean Wwwwwwwwwwww;
    public Illlllllllllllllllllllllllll Wwwwwwwwwwwww;
    public final Oooooooooo Wwwwwwwwwwwwwww;
    public final Oooooooooo Wwwwwwwwwwwwwwww;
    public final Oooooooooo Wwwwwwwwwwwwwwwww;
    public final Oooooooooo Wwwwwwwwwwwwwwwwww;
    public final O000000000 Wwwwwwwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwww;
    public final Pools.Pool<O0000000000<?>> Wwwwwwwwwwwwwwwwwwwww;
    public final O000000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final AbstractC2734w1 Wwwwwwwwwwwwwwwwwwwwwww = new AbstractC2734w1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final AtomicInteger Wwwwwwwwwwwwww = new AtomicInteger();

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Iterable<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> {
        public final List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwww = new ArrayList(2);

        public boolean isEmpty() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.isEmpty();
        }

        @Override // java.lang.Iterable
        @NonNull
        public Iterator<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> iterator() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.iterator();
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final Executor Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final AbstractC2581s0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2581s0 abstractC2581s0, Executor executor) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2581s0;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            return false;
        }

        public int hashCode() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode();
        }
    }

    @VisibleForTesting
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
        public final AbstractC2581s0 Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2581s0 abstractC2581s0) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = abstractC2581s0;
        }

        @Override // java.lang.Runnable
        public void run() {
            SingleRequest singleRequest = (SingleRequest) this.Wwwwwwwwwwwwwwwwwwwwwwww;
            singleRequest.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            synchronized (singleRequest.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                synchronized (O0000000000.this) {
                    if (O0000000000.this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.contains(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, C2391n1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww))) {
                        O0000000000.this.Www.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        O0000000000 o0000000000 = O0000000000.this;
                        AbstractC2581s0 abstractC2581s0 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                        if (o0000000000 == null) {
                            throw null;
                        }
                        ((SingleRequest) abstractC2581s0).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(o0000000000.Www, o0000000000.Wwwwwww);
                        O0000000000.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww);
                    }
                    O0000000000.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
        public final AbstractC2581s0 Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2581s0 abstractC2581s0) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = abstractC2581s0;
        }

        @Override // java.lang.Runnable
        public void run() {
            SingleRequest singleRequest = (SingleRequest) this.Wwwwwwwwwwwwwwwwwwwwwwww;
            singleRequest.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            synchronized (singleRequest.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                synchronized (O0000000000.this) {
                    if (O0000000000.this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.contains(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, C2391n1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww))) {
                        O0000000000 o0000000000 = O0000000000.this;
                        AbstractC2581s0 abstractC2581s0 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                        if (o0000000000 == null) {
                            throw null;
                        }
                        ((SingleRequest) abstractC2581s0).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(o0000000000.Wwwww, 5);
                    }
                    O0000000000.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
            }
        }
    }

    public O0000000000(Oooooooooo oooooooooo, Oooooooooo oooooooooo2, Oooooooooo oooooooooo3, Oooooooooo oooooooooo4, O000000000 o000000000, O000000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Pools.Pool<O0000000000<?>> pool) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Kkkkkkkkkkkkkkkkkkkkkkkk;
        this.Wwwwwwwwwwwwwwwwww = oooooooooo;
        this.Wwwwwwwwwwwwwwwww = oooooooooo2;
        this.Wwwwwwwwwwwwwwww = oooooooooo3;
        this.Wwwwwwwwwwwwwww = oooooooooo4;
        this.Wwwwwwwwwwwwwwwwwww = o000000000;
        this.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwww = pool;
        this.Wwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public final synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwww == null) {
            throw new IllegalArgumentException();
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.clear();
        this.Wwwwwwwwwwwww = null;
        this.Www = null;
        this.Wwwwwwww = null;
        this.Wwww = false;
        this.Kkkkkkkkkkkkkkkkkkkkkkkkk = false;
        this.Wwwwww = false;
        DecodeJob<R> decodeJob = this.Kkkkkkkkkkkkkkkkkkkkkkkkkk;
        if (decodeJob.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false)) {
            decodeJob.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        this.Kkkkkkkkkkkkkkkkkkkkkkkkkk = null;
        this.Wwwww = null;
        this.Wwwwwww = null;
        this.Wwwwwwwwwwwwwwwwwwwww.release(this);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        synchronized (this) {
            this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (this.Kkkkkkkkkkkkkkkkkkkkkkkkk) {
                this.Wwwwwwww.recycle();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            } else if (this.Wwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
                throw new IllegalStateException("Received a resource without any callbacks to notify");
            } else {
                if (this.Wwwwww) {
                    throw new IllegalStateException("Already have resource");
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwww;
                AbstractC1886O0<?> abstractC1886O0 = this.Wwwwwwww;
                boolean z = this.Wwwwwwwwwwww;
                Illlllllllllllllllllllllllll illlllllllllllllllllllllllll = this.Wwwwwwwwwwwww;
                O000000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    this.Www = new O000000<>(abstractC1886O0, z, true, illlllllllllllllllllllllllll, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    this.Wwwwww = true;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                        ArrayList arrayList = new ArrayList(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrayList.size() + 1);
                        ((IIl) this.Wwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((O0000000000<?>) this, this.Wwwwwwwwwwwww, this.Www);
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) it.next();
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.execute(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                        }
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        return;
                    }
                    throw null;
                }
                throw null;
            }
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        synchronized (this) {
            this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (this.Kkkkkkkkkkkkkkkkkkkkkkkkk) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            } else if (this.Wwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            } else {
                if (this.Wwww) {
                    throw new IllegalStateException("Already failed once");
                }
                this.Wwww = true;
                Illlllllllllllllllllllllllll illlllllllllllllllllllllllll = this.Wwwwwwwwwwwww;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    ArrayList arrayList = new ArrayList(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrayList.size() + 1);
                    ((IIl) this.Wwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((O0000000000<?>) this, illlllllllllllllllllllllllll, (O000000<?>) null);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) it.next();
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.execute(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    return;
                }
                throw null;
            }
        }
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwww || this.Wwwwww || this.Kkkkkkkkkkkkkkkkkkkkkkkkk;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        O000000<?> o000000;
        synchronized (this) {
            this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), "Not yet complete!");
            int decrementAndGet = this.Wwwwwwwwwwwwww.decrementAndGet();
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(decrementAndGet >= 0, "Can't decrement below 0");
            if (decrementAndGet == 0) {
                o000000 = this.Www;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            } else {
                o000000 = null;
            }
        }
        if (o000000 != null) {
            o000000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0019 A[Catch: all -> 0x0035, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x000f, B:12:0x0019, B:13:0x002c, B:17:0x001c, B:19:0x0020, B:20:0x0023, B:22:0x0027, B:23:0x002a, B:26:0x0034), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x001c A[Catch: all -> 0x0035, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x000f, B:12:0x0019, B:13:0x002c, B:17:0x001c, B:19:0x0020, B:20:0x0023, B:22:0x0027, B:23:0x002a, B:26:0x0034), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DecodeJob<R> decodeJob) {
        boolean z;
        Oooooooooo oooooooooo;
        this.Kkkkkkkkkkkkkkkkkkkkkkkkkk = decodeJob;
        if (decodeJob != null) {
            DecodeJob.Stage Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = decodeJob.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DecodeJob.Stage.INITIALIZE);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != DecodeJob.Stage.RESOURCE_CACHE && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != DecodeJob.Stage.DATA_CACHE) {
                z = false;
                if (!z) {
                    oooooooooo = this.Wwwwwwwwwwwwwwwwww;
                } else {
                    oooooooooo = this.Wwwwwwwwwww ? this.Wwwwwwwwwwwwwwww : this.Wwwwwwwwww ? this.Wwwwwwwwwwwwwww : this.Wwwwwwwwwwwwwwwww;
                }
                oooooooooo.Wwwwwwwwwwwwwwwwwwwwwwww.execute(decodeJob);
            }
            z = true;
            if (!z) {
            }
            oooooooooo.Wwwwwwwwwwwwwwwwwwwwwwww.execute(decodeJob);
        } else {
            throw null;
        }
    }

    @VisibleForTesting
    public synchronized O0000000000<R> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illlllllllllllllllllllllllll illlllllllllllllllllllllllll, boolean z, boolean z2, boolean z3, boolean z4) {
        this.Wwwwwwwwwwwww = illlllllllllllllllllllllllll;
        this.Wwwwwwwwwwww = z;
        this.Wwwwwwwwwww = z2;
        this.Wwwwwwwwww = z3;
        this.Wwwwwwwww = z4;
        return this;
    }

    @Override // me.tvspark.C2619t1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    @NonNull
    public AbstractC2734w1 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww;
    }

    public synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), "Not yet complete!");
        if (this.Wwwwwwwwwwwwww.getAndAdd(i) == 0 && this.Www != null) {
            this.Www.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(GlideException glideException) {
        synchronized (this) {
            this.Wwwww = glideException;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC1886O0<R> abstractC1886O0, DataSource dataSource) {
        synchronized (this) {
            this.Wwwwwwww = abstractC1886O0;
            this.Wwwwwww = dataSource;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2581s0 abstractC2581s0, Executor executor) {
        Runnable wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.add(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2581s0, executor));
        boolean z = true;
        if (this.Wwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2581s0);
        } else if (this.Wwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2581s0);
        } else {
            if (this.Kkkkkkkkkkkkkkkkkkkkkkkkk) {
                z = false;
            }
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z, "Cannot add callbacks to a cancelled EngineJob");
        }
        executor.execute(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004c, code lost:
        if (r3.Wwwwwwwwwwwwww.get() != 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004e, code lost:
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2581s0 abstractC2581s0) {
        this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.remove(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2581s0, C2391n1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
            boolean z = true;
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                this.Kkkkkkkkkkkkkkkkkkkkkkkkk = true;
                DecodeJob<R> decodeJob = this.Kkkkkkkkkkkkkkkkkkkkkkkkkk;
                decodeJob.Kkkkkkkkkkkkkkkkkk = true;
                IIlllll iIlllll = decodeJob.Kkkkkkkkkkkkkkkkkkkk;
                if (iIlllll != null) {
                    iIlllll.cancel();
                }
                ((IIl) this.Wwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((O0000000000<?>) this, this.Wwwwwwwwwwwww);
            }
            if (!this.Wwwwww && !this.Wwww) {
                z = false;
            }
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DecodeJob<?> decodeJob) {
        (this.Wwwwwwwwwww ? this.Wwwwwwwwwwwwwwww : this.Wwwwwwwwww ? this.Wwwwwwwwwwwwwww : this.Wwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwww.execute(decodeJob);
    }
}
