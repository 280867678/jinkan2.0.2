package me.tvspark;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.CheckResult;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import me.tvspark.AbstractC2463p;

/* loaded from: classes4.dex */
public class Kkkkkkkkkkkk implements ComponentCallbacks2, AbstractC2692v {
    public static final C2544r0 Wwwwwwwwwwwww;
    @GuardedBy("this")
    public C2544r0 Wwwwwwwwwwwwww;
    public final CopyOnWriteArrayList<AbstractC2507q0<Object>> Wwwwwwwwwwwwwww;
    public final AbstractC2463p Wwwwwwwwwwwwwwww;
    @GuardedBy("this")
    public final AbstractC2843z Wwwwwwwwwwwwwwwwwwww;
    @GuardedBy("this")
    public final C1892a0 Wwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2654u Wwwwwwwwwwwwwwwwwwwwww;
    public final Context Wwwwwwwwwwwwwwwwwwwwwww;
    public final Kkkkkkkkkkkkkkkk Wwwwwwwwwwwwwwwwwwwwwwww;
    @GuardedBy("this")
    public final C1929b0 Wwwwwwwwwwwwwwwwwww = new C1929b0();
    public final Runnable Wwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final Handler Wwwwwwwwwwwwwwwww = new Handler(Looper.getMainLooper());

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2463p.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        @GuardedBy("RequestManager.this")
        public final C1892a0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull C1892a0 c1892a0) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c1892a0;
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
            if (z) {
                synchronized (Kkkkkkkkkkkk.this) {
                    C1892a0 c1892a0 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    Iterator it = ((ArrayList) C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c1892a0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)).iterator();
                    while (it.hasNext()) {
                        AbstractC2464p0 abstractC2464p0 = (AbstractC2464p0) it.next();
                        if (!abstractC2464p0.isComplete() && !abstractC2464p0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                            abstractC2464p0.clear();
                            if (!c1892a0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                                abstractC2464p0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            } else {
                                c1892a0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(abstractC2464p0);
                            }
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Kkkkkkkkkkkk kkkkkkkkkkkk = Kkkkkkkkkkkk.this;
            kkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(kkkkkkkkkkkk);
        }
    }

    static {
        C2544r0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new C2544r0().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bitmap.class);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwww = true;
        Wwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        new C2544r0().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(GifDrawable.class).Wwwww = true;
        new C2544r0().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(IIll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Priority.LOW).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
    }

    public Kkkkkkkkkkkk(@NonNull Kkkkkkkkkkkkkkkk kkkkkkkkkkkkkkkk, @NonNull AbstractC2654u abstractC2654u, @NonNull AbstractC2843z abstractC2843z, @NonNull Context context) {
        C1892a0 c1892a0 = new C1892a0();
        AbstractC2506q abstractC2506q = kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = kkkkkkkkkkkkkkkk;
        this.Wwwwwwwwwwwwwwwwwwwwww = abstractC2654u;
        this.Wwwwwwwwwwwwwwwwwwww = abstractC2843z;
        this.Wwwwwwwwwwwwwwwwwwwww = c1892a0;
        this.Wwwwwwwwwwwwwwwwwwwwwww = context;
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c1892a0);
        if (((C2580s) abstractC2506q) != null) {
            boolean z = ContextCompat.checkSelfPermission(origApplicationContext, "android.permission.ACCESS_NETWORK_STATE") == 0;
            Log.isLoggable("ConnectivityMonitor", 3);
            this.Wwwwwwwwwwwwwwww = z ? new C2543r(origApplicationContext, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) : new C2732w();
            if (C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                this.Wwwwwwwwwwwwwwwww.post(this.Wwwwwwwwwwwwwwwwww);
            } else {
                abstractC2654u.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
            }
            abstractC2654u.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwww = new CopyOnWriteArrayList<>(kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
            return;
        }
        throw null;
    }

    public synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        C1892a0 c1892a0 = this.Wwwwwwwwwwwwwwwwwwwww;
        c1892a0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        Iterator it = ((ArrayList) C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c1892a0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)).iterator();
        while (it.hasNext()) {
            AbstractC2464p0 abstractC2464p0 = (AbstractC2464p0) it.next();
            if (!abstractC2464p0.isComplete() && !abstractC2464p0.isRunning()) {
                abstractC2464p0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }
        c1892a0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
    }

    public synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        C1892a0 c1892a0 = this.Wwwwwwwwwwwwwwwwwwwww;
        c1892a0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        Iterator it = ((ArrayList) C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c1892a0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)).iterator();
        while (it.hasNext()) {
            AbstractC2464p0 abstractC2464p0 = (AbstractC2464p0) it.next();
            if (abstractC2464p0.isRunning()) {
                abstractC2464p0.pause();
                c1892a0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(abstractC2464p0);
            }
        }
    }

    public synchronized C2544r0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwww;
    }

    public synchronized boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull AbstractC1930b1<?> abstractC1930b1) {
        AbstractC2464p0 request = abstractC1930b1.getRequest();
        if (request == null) {
            return true;
        }
        if (!this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(request)) {
            return false;
        }
        this.Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.remove(abstractC1930b1);
        abstractC1930b1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2464p0) null);
        return true;
    }

    @NonNull
    @CheckResult
    public Kkkkkkkkkkkkk<Bitmap> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return new Kkkkkkkkkkkkk(this.Wwwwwwwwwwwwwwwwwwwwwwww, this, Bitmap.class, this.Wwwwwwwwwwwwwwwwwwwwwww).mo4926Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2427o0<?>) Wwwwwwwwwwwww);
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // me.tvspark.AbstractC2692v
    public synchronized void onDestroy() {
        this.Wwwwwwwwwwwwwwwwwww.onDestroy();
        for (AbstractC1930b1<?> abstractC1930b1 : C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww)) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1930b1);
        }
        this.Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.clear();
        C1892a0 c1892a0 = this.Wwwwwwwwwwwwwwwwwwwww;
        Iterator it = ((ArrayList) C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c1892a0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)).iterator();
        while (it.hasNext()) {
            c1892a0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2464p0) it.next());
        }
        c1892a0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
        this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwww.removeCallbacks(this.Wwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // me.tvspark.AbstractC2692v
    public synchronized void onStart() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwww.onStart();
    }

    @Override // me.tvspark.AbstractC2692v
    public synchronized void onStop() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwww.onStop();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.Wwwwwwwwwwwwwwwwwwwww + ", treeNode=" + this.Wwwwwwwwwwwwwwwwwwww + "}";
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable AbstractC1930b1<?> abstractC1930b1) {
        if (abstractC1930b1 == null) {
            return;
        }
        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1930b1);
        AbstractC2464p0 request = abstractC1930b1.getRequest();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 || this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1930b1) || request == null) {
            return;
        }
        abstractC1930b1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2464p0) null);
        request.clear();
    }

    public synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull C2544r0 c2544r0) {
        C2544r0 mo4927clone = c2544r0.mo4927clone();
        if (mo4927clone.Wwwww && !mo4927clone.Www) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        mo4927clone.Www = true;
        mo4927clone.Wwwww = true;
        this.Wwwwwwwwwwwwww = mo4927clone;
    }

    public synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull AbstractC1930b1<?> abstractC1930b1, @NonNull AbstractC2464p0 abstractC2464p0) {
        this.Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.add(abstractC1930b1);
        C1892a0 c1892a0 = this.Wwwwwwwwwwwwwwwwwwwww;
        c1892a0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(abstractC2464p0);
        if (!c1892a0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            abstractC2464p0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        } else {
            abstractC2464p0.clear();
            Log.isLoggable("RequestTracker", 2);
            c1892a0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(abstractC2464p0);
        }
    }
}
