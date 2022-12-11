package com.bumptech.glide.request;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import java.util.List;
import java.util.concurrent.Executor;
import me.tvspark.AbstractC1886O0;
import me.tvspark.AbstractC1893a1;
import me.tvspark.AbstractC1930b1;
import me.tvspark.AbstractC2095f1;
import me.tvspark.AbstractC2427o0;
import me.tvspark.AbstractC2464p0;
import me.tvspark.AbstractC2507q0;
import me.tvspark.AbstractC2581s0;
import me.tvspark.AbstractC2734w1;
import me.tvspark.C2004d1;
import me.tvspark.C2428o1;
import me.tvspark.C2582s1;
import me.tvspark.IIl;
import me.tvspark.Kkkkkkkkkkkkkk;
import me.tvspark.Mmmmmmmm;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public final class SingleRequest<R> implements AbstractC2464p0, AbstractC1893a1, AbstractC2581s0 {
    public static final boolean Wwwww = Log.isLoggable("Request", 2);
    @Nullable
    public RuntimeException Wwwwww;
    @GuardedBy("requestLock")
    public boolean Wwwwwww;
    @GuardedBy("requestLock")
    public int Wwwwwwww;
    @GuardedBy("requestLock")
    public int Wwwwwwwww;
    @Nullable
    @GuardedBy("requestLock")
    public Drawable Wwwwwwwwww;
    @Nullable
    @GuardedBy("requestLock")
    public Drawable Wwwwwwwwwww;
    @Nullable
    @GuardedBy("requestLock")
    public Drawable Wwwwwwwwwwww;
    @GuardedBy("requestLock")
    public Status Wwwwwwwwwwwww;
    public volatile IIl Wwwwwwwwwwwwww;
    @GuardedBy("requestLock")
    public long Wwwwwwwwwwwwwww;
    @GuardedBy("requestLock")
    public IIl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwww;
    @GuardedBy("requestLock")
    public AbstractC1886O0<R> Wwwwwwwwwwwwwwwww;
    public final Executor Wwwwwwwwwwwwwwwwww;
    public final AbstractC2095f1<? super R> Wwwwwwwwwwwwwwwwwww;
    @Nullable
    public final List<AbstractC2507q0<R>> Wwwwwwwwwwwwwwwwwwww;
    public final AbstractC1930b1<R> Wwwwwwwwwwwwwwwwwwwww;
    public final Priority Wwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2427o0<?> Wwwwwwwwwwwwwwwwwwwwwwwww;
    public final Class<R> Wwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final Object Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Kkkkkkkkkkkkkk Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Context Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final RequestCoordinator Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final AbstractC2507q0<R> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2734w1 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes3.dex */
    public enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    public SingleRequest(Context context, Kkkkkkkkkkkkkk kkkkkkkkkkkkkk, @NonNull Object obj, @Nullable Object obj2, Class<R> cls, AbstractC2427o0<?> abstractC2427o0, int i, int i2, Priority priority, AbstractC1930b1<R> abstractC1930b1, @Nullable AbstractC2507q0<R> abstractC2507q0, @Nullable List<AbstractC2507q0<R>> list, RequestCoordinator requestCoordinator, IIl iIl, AbstractC2095f1<? super R> abstractC2095f1, Executor executor) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwww ? String.valueOf(super.hashCode()) : null;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new AbstractC2734w1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = obj;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = context;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = kkkkkkkkkkkkkk;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = obj2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = cls;
        this.Wwwwwwwwwwwwwwwwwwwwwwwww = abstractC2427o0;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwww = i2;
        this.Wwwwwwwwwwwwwwwwwwwwww = priority;
        this.Wwwwwwwwwwwwwwwwwwwww = abstractC1930b1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2507q0;
        this.Wwwwwwwwwwwwwwwwwwww = list;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = requestCoordinator;
        this.Wwwwwwwwwwwwww = iIl;
        this.Wwwwwwwwwwwwwwwwwww = abstractC2095f1;
        this.Wwwwwwwwwwwwwwwwww = executor;
        this.Wwwwwwwwwwwww = Status.PENDING;
        if (this.Wwwwww != null || !kkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return;
        }
        this.Wwwwww = new RuntimeException("Glide request origin trace");
    }

    @GuardedBy("requestLock")
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i;
        RequestCoordinator requestCoordinator = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (!(requestCoordinator == null || requestCoordinator.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this))) {
            return;
        }
        Drawable drawable = null;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            drawable = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        if (drawable == null) {
            if (this.Wwwwwwwwwwww == null) {
                AbstractC2427o0<?> abstractC2427o0 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
                Drawable drawable2 = abstractC2427o0.Wwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwww = drawable2;
                if (drawable2 == null && (i = abstractC2427o0.Wwwwwwwwwwwwwwwwwww) > 0) {
                    this.Wwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
                }
            }
            drawable = this.Wwwwwwwwwwww;
        }
        if (drawable == null) {
            drawable = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(drawable);
    }

    @GuardedBy("requestLock")
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        RequestCoordinator requestCoordinator = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        return requestCoordinator == null || !requestCoordinator.getRoot().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @GuardedBy("requestLock")
    public final Drawable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i;
        if (this.Wwwwwwwwwww == null) {
            AbstractC2427o0<?> abstractC2427o0 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
            Drawable drawable = abstractC2427o0.Wwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwww = drawable;
            if (drawable == null && (i = abstractC2427o0.Wwwwwwwwwwwwwwwww) > 0) {
                this.Wwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
            }
        }
        return this.Wwwwwwwwwww;
    }

    @GuardedBy("requestLock")
    public final Drawable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i;
        if (this.Wwwwwwwwww == null) {
            AbstractC2427o0<?> abstractC2427o0 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
            Drawable drawable = abstractC2427o0.Wwwwwwwwww;
            this.Wwwwwwwwww = drawable;
            if (drawable == null && (i = abstractC2427o0.Wwwwwwwww) > 0) {
                this.Wwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
            }
        }
        return this.Wwwwwwwwww;
    }

    @GuardedBy("requestLock")
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (!this.Wwwwwww) {
            return;
        }
        throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0088 A[Catch: all -> 0x00a4, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0015, B:8:0x001f, B:9:0x0027, B:12:0x0030, B:13:0x003a, B:17:0x003c, B:19:0x0042, B:21:0x0048, B:22:0x004f, B:24:0x0051, B:26:0x005f, B:27:0x006c, B:29:0x0072, B:31:0x0091, B:33:0x0095, B:34:0x009a, B:36:0x0078, B:38:0x007c, B:43:0x0088, B:45:0x0067, B:46:0x009c, B:47:0x00a3), top: B:3:0x0003 }] */
    @Override // me.tvspark.AbstractC2464p0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        boolean z;
        synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwww = C2428o1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                if (C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww)) {
                    this.Wwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                    this.Wwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new GlideException("Received null model"), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == null ? 5 : 3);
            } else if (this.Wwwwwwwwwwwww == Status.RUNNING) {
                throw new IllegalArgumentException("Cannot restart a running request");
            } else {
                if (this.Wwwwwwwwwwwww == Status.COMPLETE) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC1886O0<?>) this.Wwwwwwwwwwwwwwwww, DataSource.MEMORY_CACHE);
                    return;
                }
                this.Wwwwwwwwwwwww = Status.WAITING_FOR_SIZE;
                if (C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww)) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww);
                } else {
                    this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
                }
                if (this.Wwwwwwwwwwwww == Status.RUNNING || this.Wwwwwwwwwwwww == Status.WAITING_FOR_SIZE) {
                    RequestCoordinator requestCoordinator = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (requestCoordinator != null && !requestCoordinator.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this)) {
                        z = false;
                        if (z) {
                            this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                        }
                    }
                    z = true;
                    if (z) {
                    }
                }
                if (Wwwww) {
                    C2428o1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwww);
                }
            }
        }
    }

    @GuardedBy("requestLock")
    public final Drawable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@DrawableRes int i) {
        Resources.Theme theme = this.Wwwwwwwwwwwwwwwwwwwwwwwww.Wwww;
        if (theme == null) {
            theme = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.getTheme();
        }
        Kkkkkkkkkkkkkk kkkkkkkkkkkkkk = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        return Mmmmmmmm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(kkkkkkkkkkkkkk, kkkkkkkkkkkkkk, i, theme);
    }

    @Override // me.tvspark.AbstractC2464p0
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        boolean z;
        synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            z = this.Wwwwwwwwwwwww == Status.CLEARED;
        }
        return z;
    }

    @Override // me.tvspark.AbstractC2464p0
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2464p0 abstractC2464p0) {
        int i;
        int i2;
        Object obj;
        Class<R> cls;
        AbstractC2427o0<?> abstractC2427o0;
        Priority priority;
        int size;
        int i3;
        int i4;
        Object obj2;
        Class<R> cls2;
        AbstractC2427o0<?> abstractC2427o02;
        Priority priority2;
        int size2;
        if (!(abstractC2464p0 instanceof SingleRequest)) {
            return false;
        }
        synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            i = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            i2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
            obj = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            cls = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
            abstractC2427o0 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
            priority = this.Wwwwwwwwwwwwwwwwwwwwww;
            size = this.Wwwwwwwwwwwwwwwwwwww != null ? this.Wwwwwwwwwwwwwwwwwwww.size() : 0;
        }
        SingleRequest singleRequest = (SingleRequest) abstractC2464p0;
        synchronized (singleRequest.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            i3 = singleRequest.Wwwwwwwwwwwwwwwwwwwwwwww;
            i4 = singleRequest.Wwwwwwwwwwwwwwwwwwwwwww;
            obj2 = singleRequest.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            cls2 = singleRequest.Wwwwwwwwwwwwwwwwwwwwwwwwww;
            abstractC2427o02 = singleRequest.Wwwwwwwwwwwwwwwwwwwwwwwww;
            priority2 = singleRequest.Wwwwwwwwwwwwwwwwwwwwww;
            size2 = singleRequest.Wwwwwwwwwwwwwwwwwwww != null ? singleRequest.Wwwwwwwwwwwwwwwwwwww.size() : 0;
        }
        return i == i3 && i2 == i4 && C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, obj2) && cls.equals(cls2) && abstractC2427o0.equals(abstractC2427o02) && priority == priority2 && size == size2;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0043 A[Catch: all -> 0x0059, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0011, B:9:0x0013, B:11:0x0025, B:12:0x002a, B:14:0x002e, B:15:0x0033, B:17:0x0037, B:22:0x0043, B:23:0x004c, B:24:0x0050), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    @Override // me.tvspark.AbstractC2464p0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void clear() {
        boolean z;
        synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (this.Wwwwwwwwwwwww == Status.CLEARED) {
                return;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC1893a1) this);
            IIl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwww;
            AbstractC1886O0<?> abstractC1886O0 = null;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                this.Wwwwwwwwwwwwwwww = null;
            }
            if (this.Wwwwwwwwwwwwwwwww != null) {
                AbstractC1886O0<R> abstractC1886O02 = this.Wwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwww = null;
                abstractC1886O0 = abstractC1886O02;
            }
            RequestCoordinator requestCoordinator = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (requestCoordinator != null && !requestCoordinator.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this)) {
                z = false;
                if (z) {
                    this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                }
                this.Wwwwwwwwwwwww = Status.CLEARED;
                if (abstractC1886O0 != null) {
                    return;
                }
                this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1886O0);
                return;
            }
            z = true;
            if (z) {
            }
            this.Wwwwwwwwwwwww = Status.CLEARED;
            if (abstractC1886O0 != null) {
            }
        }
    }

    @Override // me.tvspark.AbstractC2464p0
    public boolean isComplete() {
        boolean z;
        synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            z = this.Wwwwwwwwwwwww == Status.COMPLETE;
        }
        return z;
    }

    @Override // me.tvspark.AbstractC2464p0
    public boolean isRunning() {
        boolean z;
        synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (this.Wwwwwwwwwwwww != Status.RUNNING && this.Wwwwwwwwwwwww != Status.WAITING_FOR_SIZE) {
                z = false;
            }
            z = true;
        }
        return z;
    }

    @Override // me.tvspark.AbstractC2464p0
    public void pause() {
        synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (isRunning()) {
                clear();
            }
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(GlideException glideException, int i) {
        boolean z;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            glideException.setOrigin(this.Wwwwww);
            int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i2 <= i) {
                String str = "Load failed for " + this.Wwwwwwwwwwwwwwwwwwwwwwwwwww + " with size [" + this.Wwwwwwwww + "x" + this.Wwwwwwww + "]";
                if (i2 <= 4) {
                    glideException.logRootCauses("Glide");
                }
            }
            this.Wwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwww = Status.FAILED;
            boolean z2 = true;
            this.Wwwwwww = true;
            if (this.Wwwwwwwwwwwwwwwwwwww != null) {
                z = false;
                for (AbstractC2507q0<R> abstractC2507q0 : this.Wwwwwwwwwwwwwwwwwwww) {
                    z |= abstractC2507q0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(glideException, this.Wwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                }
            } else {
                z = false;
            }
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null || !this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(glideException, this.Wwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww())) {
                z2 = false;
            }
            if (!(z | z2)) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            this.Wwwwwww = false;
            RequestCoordinator requestCoordinator = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (requestCoordinator != null) {
                requestCoordinator.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC1886O0<?> abstractC1886O0, DataSource dataSource) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        AbstractC1886O0<?> abstractC1886O02 = null;
        try {
            synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                try {
                    this.Wwwwwwwwwwwwwwww = null;
                    if (abstractC1886O0 == null) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new GlideException("Expected to receive a Resource<R> with an object of " + this.Wwwwwwwwwwwwwwwwwwwwwwwwww + " inside, but instead got null."), 5);
                        return;
                    }
                    Object obj = abstractC1886O0.get();
                    try {
                        if (obj != null && this.Wwwwwwwwwwwwwwwwwwwwwwwwww.isAssignableFrom(obj.getClass())) {
                            RequestCoordinator requestCoordinator = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            if (requestCoordinator == null || requestCoordinator.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this)) {
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1886O0, obj, dataSource);
                                return;
                            }
                            this.Wwwwwwwwwwwwwwwww = null;
                            this.Wwwwwwwwwwwww = Status.COMPLETE;
                            this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1886O0);
                            return;
                        }
                        this.Wwwwwwwwwwwwwwwww = null;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Expected to receive an object of ");
                        sb.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwww);
                        sb.append(" but instead got ");
                        sb.append(obj != null ? obj.getClass() : "");
                        sb.append("{");
                        sb.append(obj);
                        sb.append("} inside Resource{");
                        sb.append(abstractC1886O0);
                        sb.append("}.");
                        sb.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new GlideException(sb.toString()), 5);
                        this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1886O0);
                    } catch (Throwable th) {
                        abstractC1886O02 = abstractC1886O0;
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            if (abstractC1886O02 != null) {
                this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1886O02);
            }
            throw th3;
        }
    }

    @GuardedBy("requestLock")
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC1886O0<R> abstractC1886O0, R r, DataSource dataSource) {
        boolean z;
        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwww = Status.COMPLETE;
        this.Wwwwwwwwwwwwwwwww = abstractC1886O0;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww <= 3) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Finished loading ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(r.getClass().getSimpleName());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" from ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(dataSource);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" for ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" with size [");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("x");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("] in ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(C2428o1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwww));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" ms");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        boolean z2 = true;
        this.Wwwwwww = true;
        try {
            if (this.Wwwwwwwwwwwwwwwwwwww != null) {
                z = false;
                for (AbstractC2507q0<R> abstractC2507q0 : this.Wwwwwwwwwwwwwwwwwwww) {
                    z |= abstractC2507q0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r, this.Wwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww, dataSource, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
            } else {
                z = false;
            }
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null || !this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r, this.Wwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww, dataSource, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                z2 = false;
            }
            if (!(z2 | z)) {
                if (((C2004d1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this.Wwwwwwwwwwwwwwwwwww) != null) {
                    this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r, C2004d1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                } else {
                    throw null;
                }
            }
            this.Wwwwwww = false;
            RequestCoordinator requestCoordinator = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (requestCoordinator == null) {
                return;
            }
            requestCoordinator.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        } catch (Throwable th) {
            this.Wwwwwww = false;
            throw th;
        }
    }

    @Override // me.tvspark.AbstractC1893a1
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        Object obj;
        int i3 = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Object obj2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        synchronized (obj2) {
            try {
                if (Wwwww) {
                    C2428o1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwww);
                }
                if (this.Wwwwwwwwwwwww == Status.WAITING_FOR_SIZE) {
                    this.Wwwwwwwwwwwww = Status.RUNNING;
                    float f = this.Wwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
                    if (i3 != Integer.MIN_VALUE) {
                        i3 = Math.round(i3 * f);
                    }
                    this.Wwwwwwwww = i3;
                    this.Wwwwwwww = i2 == Integer.MIN_VALUE ? i2 : Math.round(f * i2);
                    if (Wwwww) {
                        C2428o1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwww);
                    }
                    obj = obj2;
                    try {
                        try {
                            this.Wwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwww, this.Wwwwwwwww, this.Wwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwww.Wwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkkkkkkkk, this.Wwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkkkkkkkkkk, this.Wwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkkkkkkk, this.Wwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkkkkkkkkk, this, this.Wwwwwwwwwwwwwwwwww);
                            if (this.Wwwwwwwwwwwww != Status.RUNNING) {
                                this.Wwwwwwwwwwwwwwww = null;
                            }
                            if (Wwwww) {
                                C2428o1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwww);
                            }
                        } catch (Throwable th) {
                            th = th;
                            while (true) {
                                try {
                                    break;
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                obj = obj2;
            }
        }
    }
}
