package me.tvspark;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import me.tvspark.AbstractC2209i4;
import me.tvspark.AbstractC2784xe;
import me.tvspark.AbstractC2858ze;
import me.tvspark.C1969c3;
import me.tvspark.C2584s3;
import me.tvspark.C2773x3;

/* renamed from: me.tvspark.h3 */
/* loaded from: classes4.dex */
public final class C2171h3 implements Handler.Callback, AbstractC2784xe.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, C2584s3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, C1969c3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, C2773x3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    public boolean Kkkkkkkkkkk = true;
    public boolean Kkkkkkkkkkkk;
    public int Kkkkkkkkkkkkk;
    public long Kkkkkkkkkkkkkk;
    @Nullable
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwww Kkkkkkkkkkkkkkk;
    public int Kkkkkkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkkkkkkkkk;
    public int Kkkkkkkkkkkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkkkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkkkkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkkkkkkkkkkkkkkk;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Www;
    public C2621t3 Wwww;
    public C2098f4 Wwwww;
    public final C2584s3 Wwwwww;
    public final C2510q3 Wwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwww;
    public final AbstractC2564rk Wwwwwwwww;
    public final ArrayList<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwww;
    public final C1969c3 Wwwwwwwwwww;
    public final boolean Wwwwwwwwwwww;
    public final long Wwwwwwwwwwwww;
    public final AbstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwww;
    public final AbstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwww;
    public final Looper Wwwwwwwwwwwwwwww;
    public final HandlerThread Wwwwwwwwwwwwwwwww;
    public final C2263jl Wwwwwwwwwwwwwwwwww;
    public final AbstractC2674uj Wwwwwwwwwwwwwwwwwww;
    public final AbstractC2319l3 Wwwwwwwwwwwwwwwwwwww;
    public final C2150gj Wwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2113fj Wwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC1970c4[] Wwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC1896a4[] Wwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.h3$Wwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final AbstractC2209i4 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2209i4 abstractC2209i4, int i, long j) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2209i4;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
        }
    }

    /* renamed from: me.tvspark.h3$Wwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, long j, long j2, boolean z, boolean z2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z2;
        }
    }

    /* renamed from: me.tvspark.h3$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    /* renamed from: me.tvspark.h3$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public C2621t3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2621t3 c2621t3) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2621t3;
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            boolean z = true;
            if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 4) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
                return;
            }
            if (i != 4) {
                z = false;
            }
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww |= i > 0;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i;
        }
    }

    /* renamed from: me.tvspark.h3$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Comparable<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> {
        @Nullable
        public Object Wwwwwwwwwwwwwwwwwwwww;
        public long Wwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwww;
        public final C2773x3 Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2773x3 c2773x3) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = c2773x3;
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, long j, Object obj) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwww = j;
            this.Wwwwwwwwwwwwwwwwwwwww = obj;
        }

        @Override // java.lang.Comparable
        public int compareTo(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if ((this.Wwwwwwwwwwwwwwwwwwwww == null) != (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwww == null)) {
                return this.Wwwwwwwwwwwwwwwwwwwww != null ? -1 : 1;
            } else if (this.Wwwwwwwwwwwwwwwwwwwww == null) {
                return 0;
            } else {
                int i = this.Wwwwwwwwwwwwwwwwwwwwwww - wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwww;
                return i != 0 ? i : C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwww);
            }
        }
    }

    /* renamed from: me.tvspark.h3$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final AbstractC2257jf Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    /* renamed from: me.tvspark.h3$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final AbstractC2257jf Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final List<C2584s3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List list, AbstractC2257jf abstractC2257jf, int i, long j, C2134g3 c2134g3) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = list;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2257jf;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
        }
    }

    public C2171h3(AbstractC1896a4[] abstractC1896a4Arr, AbstractC2113fj abstractC2113fj, C2150gj c2150gj, AbstractC2319l3 abstractC2319l3, AbstractC2674uj abstractC2674uj, int i, boolean z, @Nullable C2320l4 c2320l4, C2098f4 c2098f4, boolean z2, Looper looper, AbstractC2564rk abstractC2564rk, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = abstractC1896a4Arr;
        this.Wwwwwwwwwwwwwwwwwwwwww = abstractC2113fj;
        this.Wwwwwwwwwwwwwwwwwwwww = c2150gj;
        this.Wwwwwwwwwwwwwwwwwwww = abstractC2319l3;
        this.Wwwwwwwwwwwwwwwwwww = abstractC2674uj;
        this.Kkkkkkkkkkkkkkkkkkkkk = i;
        this.Kkkkkkkkkkkkkkkkkkkk = z;
        this.Wwwww = c2098f4;
        this.Kkkkkkkkkkkkkkkkkkkkkkkkk = z2;
        this.Wwwwwwwww = abstractC2564rk;
        this.Wwwwwwwwwwwww = ((C1932b3) abstractC2319l3).Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwww = ((C1932b3) abstractC2319l3).Wwwwwwwwwwwwwwwwwwwwwwwwww;
        C2621t3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2150gj);
        this.Wwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        this.Www = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        this.Wwwwwwwwwwwwwwwwwwwwwww = new AbstractC1970c4[abstractC1896a4Arr.length];
        for (int i2 = 0; i2 < abstractC1896a4Arr.length; i2++) {
            abstractC1896a4Arr[i2].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
            this.Wwwwwwwwwwwwwwwwwwwwwww[i2] = abstractC1896a4Arr[i2].Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        this.Wwwwwwwwwww = new C1969c3(this, abstractC2564rk);
        this.Wwwwwwwwww = new ArrayList<>();
        this.Wwwwwwwwwwwwwww = new AbstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwww = new AbstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        abstractC2113fj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2674uj;
        this.Kkkkkkkkkkkk = true;
        Handler handler = new Handler(looper);
        this.Wwwwwww = new C2510q3(c2320l4, handler);
        this.Wwwwww = new C2584s3(this, c2320l4, handler);
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
        this.Wwwwwwwwwwwwwwwww = handlerThread;
        handlerThread.start();
        Looper looper2 = this.Wwwwwwwwwwwwwwwww.getLooper();
        this.Wwwwwwwwwwwwwwww = looper2;
        this.Wwwwwwwwwwwwwwwwww = abstractC2564rk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(looper2, this);
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC1896a4 abstractC1896a4) {
        return abstractC1896a4.getState() != 0;
    }

    @Nullable
    public static Pair<Object, Long> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2209i4 abstractC2209i4, Wwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwww, boolean z, int i, boolean z2, AbstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, AbstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        Pair<Object, Long> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
        AbstractC2209i4 abstractC2209i42 = wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return null;
        }
        AbstractC2209i4 abstractC2209i43 = abstractC2209i42.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() ? abstractC2209i4 : abstractC2209i42;
        try {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = abstractC2209i43.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        } catch (IndexOutOfBoundsException unused) {
        }
        if (abstractC2209i4.equals(abstractC2209i43)) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        }
        if (abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.first) != -1) {
            abstractC2209i43.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.first, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            return abstractC2209i43.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwww ? abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.first, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        }
        if (z && (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i, z2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.first, abstractC2209i43, abstractC2209i4)) != null) {
            return abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, -9223372036854775807L);
        }
        return null;
    }

    @Nullable
    public static Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, AbstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, int i, boolean z, Object obj, AbstractC2209i4 abstractC2209i4, AbstractC2209i4 abstractC2209i42) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        int i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        int i3 = -1;
        for (int i4 = 0; i4 < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 && i3 == -1; i4++) {
            i2 = abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i, z);
            if (i2 == -1) {
                break;
            }
            i3 = abstractC2209i42.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2));
        }
        if (i3 == -1) {
            return null;
        }
        return abstractC2209i42.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2209i4 abstractC2209i4, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, AbstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, AbstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        int i = abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2).Wwwwwwwwwwwwwwwwwwwwww;
        Object obj = abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, true).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        long j = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, j != -9223372036854775807L ? j - 1 : Long.MAX_VALUE, obj);
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2621t3 c2621t3, AbstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, AbstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        AbstractC2209i4 abstractC2209i4 = c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    public static C2245j3[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC1985cj abstractC1985cj) {
        int length = abstractC1985cj != null ? abstractC1985cj.length() : 0;
        C2245j3[] c2245j3Arr = new C2245j3[length];
        for (int i = 0; i < length; i++) {
            c2245j3Arr[i] = abstractC1985cj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        }
        return c2245j3Arr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x0169, code lost:
        r10 = r14.Wwwwwwwwww.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0138, code lost:
        r10 = r14.Wwwwwwwwww.get(r3 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0122, code lost:
        if (r3 > 0) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0125, code lost:
        r10 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0126, code lost:
        if (r10 == null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0128, code lost:
        r11 = r10.Wwwwwwwwwwwwwwwwwwwwwww;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x012a, code lost:
        if (r11 > r0) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x012c, code lost:
        if (r11 != r0) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0132, code lost:
        if (r10.Wwwwwwwwwwwwwwwwwwwwww <= r4) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0134, code lost:
        r3 = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0136, code lost:
        if (r3 <= 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0149, code lost:
        if (r3 >= r14.Wwwwwwwwww.size()) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x014c, code lost:
        r10 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x014d, code lost:
        if (r10 == null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0151, code lost:
        if (r10.Wwwwwwwwwwwwwwwwwwwww == null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0153, code lost:
        r11 = r10.Wwwwwwwwwwwwwwwwwwwwwww;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0155, code lost:
        if (r11 < r0) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0157, code lost:
        if (r11 != r0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x015d, code lost:
        if (r10.Wwwwwwwwwwwwwwwwwwwwww > r4) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x015f, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0167, code lost:
        if (r3 >= r14.Wwwwwwwwww.size()) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0172, code lost:
        if (r10 == null) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0176, code lost:
        if (r10.Wwwwwwwwwwwwwwwwwwwww == null) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x017a, code lost:
        if (r10.Wwwwwwwwwwwwwwwwwwwwwww != r0) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x017c, code lost:
        r11 = r10.Wwwwwwwwwwwwwwwwwwwwww;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0180, code lost:
        if (r11 <= r4) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0184, code lost:
        if (r11 > r1) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0186, code lost:
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r10.Wwwwwwwwwwwwwwwwwwwwwwww);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x018b, code lost:
        r10 = r10.Wwwwwwwwwwwwwwwwwwwwwwww;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x018f, code lost:
        if (r10.Wwwwwwwwwwwwwwwwwwwwwwwwww != false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0191, code lost:
        r10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01a2, code lost:
        if (r3 >= r14.Wwwwwwwwww.size()) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01ad, code lost:
        r10 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01a4, code lost:
        r10 = r14.Wwwwwwwwww.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0197, code lost:
        r14.Wwwwwwwwww.remove(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01af, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01b0, code lost:
        r1 = r10.Wwwwwwwwwwwwwwwwwwwwwwww;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01b4, code lost:
        if (r1.Wwwwwwwwwwwwwwwwwwwwwwwwww == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01b6, code lost:
        r1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01bf, code lost:
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01ba, code lost:
        r14.Wwwwwwwwww.remove(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01c0, code lost:
        r14.Kkkkkkkkkkkkk = r3;
     */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0136 -> B:41:0x0125). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x0167 -> B:52:0x014c). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x0169 -> B:53:0x014d). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:91:0x0138 -> B:42:0x0126). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Wwwwwwwwwwwwwwww() throws ExoPlaybackException {
        C2430o3 c2430o3 = this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (c2430o3 == null) {
            return;
        }
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2430o3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? c2430o3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww() : -9223372036854775807L;
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwww2 != -9223372036854775807L) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwww2 != this.Wwww.Wwwwwwwwwwwwwwwwwww) {
                C2621t3 c2621t3 = this.Wwww;
                this.Wwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwww2, c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                this.Www.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
            }
        } else {
            C1969c3 c1969c3 = this.Wwwwwwwwwww;
            boolean z = c2430o3 != this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww;
            AbstractC1896a4 abstractC1896a4 = c1969c3.Wwwwwwwwwwwwwwwwwwwwww;
            if (abstractC1896a4 == null || abstractC1896a4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || (!c1969c3.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && (z || c1969c3.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()))) {
                c1969c3.Wwwwwwwwwwwwwwwwwwww = true;
                if (c1969c3.Wwwwwwwwwwwwwwwwwww) {
                    c1969c3.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
            } else {
                AbstractC1913al abstractC1913al = c1969c3.Wwwwwwwwwwwwwwwwwwwww;
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1913al);
                long Wwwwwwwwwwwwwwwwwwwwwwwwwwww3 = abstractC1913al.Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
                if (c1969c3.Wwwwwwwwwwwwwwwwwwww) {
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwww3 < c1969c3.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                        C2189hl c2189hl = c1969c3.Wwwwwwwwwwwwwwwwwwwwwwww;
                        if (c2189hl.Wwwwwwwwwwwwwwwwwwwwwww) {
                            c2189hl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2189hl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww());
                            c2189hl.Wwwwwwwwwwwwwwwwwwwwwww = false;
                        }
                    } else {
                        c1969c3.Wwwwwwwwwwwwwwwwwwww = false;
                        if (c1969c3.Wwwwwwwwwwwwwwwwwww) {
                            c1969c3.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        }
                    }
                }
                c1969c3.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                C2658u3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = abstractC1913al.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.equals(c1969c3.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww)) {
                    C2189hl c2189hl2 = c1969c3.Wwwwwwwwwwwwwwwwwwwwwwww;
                    if (c2189hl2.Wwwwwwwwwwwwwwwwwwwwwww) {
                        c2189hl2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2189hl2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww());
                    }
                    c2189hl2.Wwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                    ((C2171h3) c1969c3.Wwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.obtainMessage(16, 0, 0, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2).sendToTarget();
                }
            }
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwww4 = c1969c3.Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Kkkkkkkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwww4;
            long j = Wwwwwwwwwwwwwwwwwwwwwwwwwwww4 - c2430o3.Wwwwwwwwwwwwwwwwwwww;
            long j2 = this.Wwww.Wwwwwwwwwwwwwwwwwww;
            if (!this.Wwwwwwwwww.isEmpty() && !this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                if (this.Kkkkkkkkkkkk) {
                    j2--;
                    this.Kkkkkkkkkkkk = false;
                }
                C2621t3 c2621t32 = this.Wwww;
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2621t32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2621t32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                int min = Math.min(this.Kkkkkkkkkkkkk, this.Wwwwwwwwww.size());
            }
            this.Wwww.Wwwwwwwwwwwwwwwwwww = j;
        }
        this.Wwww.Wwwwwwwwwwwwwwwwwwwww = this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwww.Wwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public final void Wwwwwwwwwwwwwwwww() {
        C2430o3 c2430o3 = this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww;
        boolean z = this.Kkkkkkkkkkkkkkkkkkkkkk || (c2430o3 != null && c2430o3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        C2621t3 c2621t3 = this.Wwww;
        if (z != c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwww = new C2621t3(c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, z, c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwww, c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwww, c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwww, c2621t3.Wwwwwwwwwwwwwwwwwwwwwwww, c2621t3.Wwwwwwwwwwwwwwwwwwwwwww, c2621t3.Wwwwwwwwwwwwwwwwwwwww, c2621t3.Wwwwwwwwwwwwwwwwwwww, c2621t3.Wwwwwwwwwwwwwwwwwww, c2621t3.Wwwwwwwwwwwwwwwwwwwwww);
        }
    }

    public final void Wwwwwwwwwwwwwwwwww() throws ExoPlaybackException {
        AbstractC1896a4[] abstractC1896a4Arr;
        C1969c3 c1969c3 = this.Wwwwwwwwwww;
        c1969c3.Wwwwwwwwwwwwwwwwwww = false;
        C2189hl c2189hl = c1969c3.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (c2189hl.Wwwwwwwwwwwwwwwwwwwwwww) {
            c2189hl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2189hl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww());
            c2189hl.Wwwwwwwwwwwwwwwwwwwwwww = false;
        }
        for (AbstractC1896a4 abstractC1896a4 : this.Wwwwwwwwwwwwwwwwwwwwwwww) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1896a4) && abstractC1896a4.getState() == 2) {
                abstractC1896a4.stop();
            }
        }
    }

    public final void Wwwwwwwwwwwwwwwwwww() throws ExoPlaybackException {
        AbstractC1896a4[] abstractC1896a4Arr;
        this.Kkkkkkkkkkkkkkkkkkkkkkk = false;
        C1969c3 c1969c3 = this.Wwwwwwwwwww;
        c1969c3.Wwwwwwwwwwwwwwwwwww = true;
        c1969c3.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        for (AbstractC1896a4 abstractC1896a4 : this.Wwwwwwwwwwwwwwwwwwwwwwww) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1896a4)) {
                abstractC1896a4.start();
            }
        }
    }

    public final boolean Wwwwwwwwwwwwwwwwwwww() {
        C2621t3 c2621t3 = this.Wwww;
        return c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwww && c2621t3.Wwwwwwwwwwwwwwwwwwwwwwww == 0;
    }

    public final void Wwwwwwwwwwwwwwwwwwwww() {
        C2430o3 c2430o3 = this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Kkkkkkkkkkkkkkkkkkkkkkkk = c2430o3 != null && c2430o3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww && this.Kkkkkkkkkkkkkkkkkkkkkkkkk;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0049 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Wwwwwwwwwwwwwwwwwwwwww() throws ExoPlaybackException {
        boolean z;
        int i;
        float f = this.Wwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2510q3 c2510q3 = this.Wwwwwww;
        C2430o3 c2430o3 = c2510q3.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2430o3 c2430o32 = c2510q3.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        boolean z2 = true;
        for (C2430o3 c2430o33 = c2430o3; c2430o33 != null && c2430o33.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww; c2430o33 = c2430o33.Wwwwwwwwwwwwwwwwwwwwwww) {
            C2150gj Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2430o33.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f, this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            C2150gj c2150gj = c2430o33.Wwwwwwwwwwwwwwwwwwwww;
            int i2 = 0;
            if (c2150gj != null && c2150gj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                for (int i3 = 0; i3 < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww; i3++) {
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2150gj, i3)) {
                    }
                }
                z = true;
                if (z) {
                    if (z2) {
                        C2510q3 c2510q32 = this.Wwwwwww;
                        C2430o3 c2430o34 = c2510q32.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = c2510q32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2430o34);
                        boolean[] zArr = new boolean[this.Wwwwwwwwwwwwwwwwwwwwwwww.length];
                        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = c2430o34.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, this.Wwww.Wwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, zArr);
                        C2621t3 c2621t3 = this.Wwww;
                        i = 4;
                        C2621t3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4, c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        this.Wwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5;
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 4 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 != Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwww) {
                            this.Www.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
                        }
                        boolean[] zArr2 = new boolean[this.Wwwwwwwwwwwwwwwwwwwwwwww.length];
                        while (true) {
                            AbstractC1896a4[] abstractC1896a4Arr = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                            if (i2 >= abstractC1896a4Arr.length) {
                                break;
                            }
                            AbstractC1896a4 abstractC1896a4 = abstractC1896a4Arr[i2];
                            zArr2[i2] = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1896a4);
                            AbstractC2183hf abstractC2183hf = c2430o34.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2];
                            if (zArr2[i2]) {
                                if (abstractC2183hf != abstractC1896a4.Wwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1896a4);
                                } else if (zArr[i2]) {
                                    abstractC1896a4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkk);
                                }
                            }
                            i2++;
                        }
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(zArr2);
                    } else {
                        i = 4;
                        this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2430o33);
                        if (c2430o33.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                            c2430o33.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Math.max(c2430o33.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Kkkkkkkkkkkkkk - c2430o33.Wwwwwwwwwwwwwwwwwwww), false, new boolean[c2430o33.Wwwwwwwwwwwwwwwwwwwwwwwwww.length]);
                        }
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
                    if (this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == i) {
                        return;
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwww();
                    Wwwwwwwwwwwwwwww();
                    this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                    return;
                }
                if (c2430o33 == c2430o32) {
                    z2 = false;
                }
            }
            z = false;
            if (z) {
            }
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, false, true, false);
        ((C1932b3) this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        this.Wwwwwwwwwwwwwwwww.quit();
        synchronized (this) {
            this.Kkkkkkkkkkkkkkkkkkkkkkkkkk = true;
            notifyAll();
        }
    }

    public synchronized boolean Wwwwwwwwwwwwwwwwwwwwwwww() {
        if (!this.Kkkkkkkkkkkkkkkkkkkkkkkkkk && this.Wwwwwwwwwwwwwwwww.isAlive()) {
            this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(7);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new AbstractC2684ut() { // from class: me.tvspark.r2
                @Override // me.tvspark.AbstractC2684ut
                /* renamed from: get */
                public final Object mo4804get() {
                    return C2171h3.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
            });
            return this.Kkkkkkkkkkkkkkkkkkkkkkkkkk;
        }
        return true;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Www.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, false, false, true);
        ((C1932b3) this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() ? 4 : 2);
        C2584s3 c2584s3 = this.Wwwwww;
        AbstractC2410nk Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!c2584s3.Wwwwwwwwwwwwwwwwwwwwwwwww);
        c2584s3.Wwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        for (int i = 0; i < c2584s3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size(); i++) {
            C2584s3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2584s3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i);
            c2584s3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            c2584s3.Wwwwwwwwwwwwwwwwwwwwwwwwwww.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        c2584s3.Wwwwwwwwwwwwwwwwwwwwwwwww = true;
        this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Www;
        C2621t3 c2621t3 = this.Wwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww |= wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != c2621t3;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2621t3;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Www;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            this.Www = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwww);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x006d, code lost:
        if (r5 == false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwww() {
        boolean z = false;
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            C2430o3 c2430o3 = this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww;
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!c2430o3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? 0L : c2430o3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            if (c2430o3 != this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww) {
                long j = c2430o3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            AbstractC2319l3 abstractC2319l3 = this.Wwwwwwwwwwwwwwwwwwww;
            float f = this.Wwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            C1932b3 c1932b3 = (C1932b3) abstractC2319l3;
            boolean z2 = c1932b3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() >= c1932b3.Wwwwwwwwwwwwwwwwwwwwwwwww;
            long j2 = c1932b3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (f > 1.0f) {
                j2 = Math.min(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2, f), c1932b3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 < Math.max(j2, 500000L)) {
                if (c1932b3.Wwwwwwwwwwwwwwwwwwwwwwwwwwww || !z2) {
                    z = true;
                }
            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 < c1932b3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            }
            c1932b3.Wwwwwwwwwwwwwwwwwwwwwwww = z;
            z = c1932b3.Wwwwwwwwwwwwwwwwwwwwwwww;
        }
        this.Kkkkkkkkkkkkkkkkkkkkkk = z;
        if (z) {
            C2430o3 c2430o32 = this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww;
            long j3 = this.Kkkkkkkkkkkkkk;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2430o32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            c2430o32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j3 - c2430o32.Wwwwwwwwwwwwwwwwwwww);
        }
        Wwwwwwwwwwwwwwwww();
    }

    public /* synthetic */ Boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return Boolean.valueOf(this.Kkkkkkkkkkkkkkkkkkkkkkkkkk);
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        C2430o3 c2430o3 = this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        long j = c2430o3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        return c2430o3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && (j == -9223372036854775807L || this.Wwww.Wwwwwwwwwwwwwwwwwww < j || !Wwwwwwwwwwwwwwwwwwww());
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        C2430o3 c2430o3 = this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww;
        if (c2430o3 == null) {
            return false;
        }
        return (!c2430o3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? 0L : c2430o3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) != Long.MIN_VALUE;
    }

    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwww.Wwwwwwwwwwwwwwwwwwwww);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2773x3 c2773x3) throws ExoPlaybackException {
        if (c2773x3.Wwwwwwwwwwwwwwwwwwwwwwwwwww == -9223372036854775807L) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2773x3);
        } else if (this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            this.Wwwwwwwwww.add(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2773x3));
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2773x3);
            AbstractC2209i4 abstractC2209i4 = this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, abstractC2209i4, abstractC2209i4, this.Kkkkkkkkkkkkkkkkkkkkk, this.Kkkkkkkkkkkkkkkkkkkk, this.Wwwwwwwwwwwwwww, this.Wwwwwwwwwwwwww)) {
                c2773x3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
                return;
            }
            this.Wwwwwwwwww.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            Collections.sort(this.Wwwwwwwwww);
        }
    }

    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        C2430o3 c2430o3 = this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        if (c2430o3 == null) {
            return 0L;
        }
        long j = c2430o3.Wwwwwwwwwwwwwwwwwwww;
        if (!c2430o3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return j;
        }
        int i = 0;
        while (true) {
            AbstractC1896a4[] abstractC1896a4Arr = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (i >= abstractC1896a4Arr.length) {
                return j;
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1896a4Arr[i]) && this.Wwwwwwwwwwwwwwwwwwwwwwww[i].Wwwwwwwwwwwwwwwwwwwwwwwwww() == c2430o3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i]) {
                long Wwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww[i].Wwwwwwwwwwwwwwwwwwwwwwww();
                if (Wwwwwwwwwwwwwwwwwwwwwwww == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                j = Math.max(Wwwwwwwwwwwwwwwwwwwwwwww, j);
            }
            i++;
        }
    }

    public synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2773x3 c2773x3) {
        if (!this.Kkkkkkkkkkkkkkkkkkkkkkkkkk && this.Wwwwwwwwwwwwwwwww.isAlive()) {
            this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(14, c2773x3).sendToTarget();
            return;
        }
        c2773x3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        if (z == this.Kkkkkkkkkkkkkkkkk) {
            return;
        }
        this.Kkkkkkkkkkkkkkkkk = z;
        int i = this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (z || i == 4 || i == 1) {
            this.Wwww = this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
        } else {
            this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws ExoPlaybackException {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new boolean[this.Wwwwwwwwwwwwwwwwwwwwwwww.length]);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        C2621t3 c2621t3 = this.Wwww;
        if (c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != i) {
            this.Wwww = c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2784xe abstractC2784xe) {
        C2430o3 c2430o3 = this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww;
        if (!(c2430o3 != null && c2430o3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == abstractC2784xe)) {
            return;
        }
        this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkk);
        Wwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, int i) throws ExoPlaybackException {
        this.Www.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        C2584s3 c2584s3 = this.Wwwwww;
        if (i == -1) {
            i = c2584s3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2584s3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2209i4 abstractC2209i4, AbstractC2209i4 abstractC2209i42) {
        if (!abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || !abstractC2209i42.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            for (int size = this.Wwwwwwwwww.size() - 1; size >= 0; size--) {
                if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwww.get(size), abstractC2209i4, abstractC2209i42, this.Kkkkkkkkkkkkkkkkkkkkk, this.Kkkkkkkkkkkkkkkkkkkk, this.Wwwwwwwwwwwwwww, this.Wwwwwwwwwwwwww)) {
                    this.Wwwwwwwwww.get(size).Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
                    this.Wwwwwwwwww.remove(size);
                }
            }
            Collections.sort(this.Wwwwwwwwww);
        }
    }

    public final synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2684ut<Boolean> abstractC2684ut) {
        boolean z = false;
        while (!abstractC2684ut.mo4804get().booleanValue()) {
            try {
                wait();
            } catch (InterruptedException unused) {
                z = true;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    @Override // me.tvspark.AbstractC2784xe.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: avoid collision after fix types in other method */
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2(AbstractC2784xe abstractC2784xe) {
        this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8, abstractC2784xe).sendToTarget();
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, @Nullable AtomicBoolean atomicBoolean) {
        AbstractC1896a4[] abstractC1896a4Arr;
        if (this.Kkkkkkkkkkkkkkkkkkk != z) {
            this.Kkkkkkkkkkkkkkkkkkk = z;
            if (!z) {
                for (AbstractC1896a4 abstractC1896a4 : this.Wwwwwwwwwwwwwwwwwwwwwwww) {
                    if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1896a4)) {
                        abstractC1896a4.reset();
                    }
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00fb  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleMessage(Message message) {
        ExoPlaybackException e;
        C2430o3 c2430o3;
        try {
            switch (message.what) {
                case 0:
                    Wwwwwwwwwwwwwwwwwwwwwwwww();
                    break;
                case 1:
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(message.arg1 != 0, message.arg2, true, 1);
                    break;
                case 2:
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    break;
                case 3:
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwww) message.obj);
                    break;
                case 4:
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((C2658u3) message.obj);
                    break;
                case 5:
                    this.Wwwww = (C2098f4) message.obj;
                    break;
                case 6:
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, true);
                    break;
                case 7:
                    Wwwwwwwwwwwwwwwwwwwwwww();
                    return true;
                case 8:
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2784xe) message.obj);
                    break;
                case 9:
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2784xe) message.obj);
                    break;
                case 10:
                    Wwwwwwwwwwwwwwwwwwwwww();
                    break;
                case 11:
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(message.arg1);
                    break;
                case 12:
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(message.arg1 != 0);
                    break;
                case 13:
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(message.arg1 != 0, (AtomicBoolean) message.obj);
                    break;
                case 14:
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((C2773x3) message.obj);
                    break;
                case 15:
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwww((C2773x3) message.obj);
                    break;
                case 16:
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((C2658u3) message.obj, message.arg1 != 0);
                    break;
                case 17:
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) message.obj);
                    break;
                case 18:
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) message.obj, message.arg1);
                    break;
                case 19:
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) message.obj);
                    break;
                case 20:
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(message.arg1, message.arg2, (AbstractC2257jf) message.obj);
                    break;
                case 21:
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2257jf) message.obj);
                    break;
                case 22:
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                    break;
                case 23:
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(message.arg1 != 0);
                    break;
                case 24:
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(message.arg1 == 1);
                    break;
                default:
                    return false;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwww();
        } catch (ExoPlaybackException e2) {
            e = e2;
            if (e.type == 1 && (c2430o3 = this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww) != null) {
                e = e.copyWithMediaPeriodId(c2430o3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            C2827yk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Playback error", e);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, false);
            this.Wwww = this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e);
            Wwwwwwwwwwwwwwwwwwwwwwwwww();
            return true;
        } catch (IOException e3) {
            e = ExoPlaybackException.createForSource(e3);
            C2430o3 c2430o32 = this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (c2430o32 != null) {
                e = e.copyWithMediaPeriodId(c2430o32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            C2827yk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Playback error", e);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, false);
            this.Wwww = this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e);
            Wwwwwwwwwwwwwwwwwwwwwwwwww();
            return true;
        } catch (OutOfMemoryError e4) {
            e = e4;
            e = !(e instanceof OutOfMemoryError) ? ExoPlaybackException.createForOutOfMemory((OutOfMemoryError) e) : ExoPlaybackException.createForUnexpected((RuntimeException) e);
            C2827yk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Playback error", e);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, false);
            this.Wwww = this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e);
            Wwwwwwwwwwwwwwwwwwwwwwwwww();
            return true;
        } catch (RuntimeException e5) {
            e = e5;
            if (!(e instanceof OutOfMemoryError)) {
            }
            C2827yk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Playback error", e);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, false);
            this.Wwww = this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e);
            Wwwwwwwwwwwwwwwwwwwwwwwwww();
            return true;
        }
        return true;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(final C2773x3 c2773x3) {
        Handler handler = c2773x3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (!handler.getLooper().getThread().isAlive()) {
            c2773x3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
        } else {
            handler.post(new Runnable() { // from class: me.tvspark.q2
                @Override // java.lang.Runnable
                public final void run() {
                    C2171h3.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2773x3);
                }
            });
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2773x3 c2773x3) throws ExoPlaybackException {
        if (c2773x3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.getLooper() != this.Wwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(15, c2773x3).sendToTarget();
            return;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2773x3);
        int i = this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i != 3 && i != 2) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) throws ExoPlaybackException {
        this.Kkkkkkkkkkkkkkkkkkkkkkkkk = z;
        Wwwwwwwwwwwwwwwwwwwww();
        if (this.Kkkkkkkkkkkkkkkkkkkkkkkk) {
            C2510q3 c2510q3 = this.Wwwwwww;
            if (c2510q3.Wwwwwwwwwwwwwwwwwwwwwwwwww == c2510q3.Wwwwwwwwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0269  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2209i4 abstractC2209i4) throws ExoPlaybackException {
        AbstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        AbstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2510q3 c2510q3;
        AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        boolean z;
        int i;
        Object obj;
        int i2;
        int i3;
        int i4;
        boolean z2;
        boolean z3;
        boolean z4;
        int i5;
        long j;
        long j2;
        long j3;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        long j4;
        int i6;
        int i7;
        boolean z5;
        int i8;
        boolean z6;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        C2621t3 c2621t3 = this.Wwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Kkkkkkkkkkkkkkk;
        C2510q3 c2510q32 = this.Wwwwwww;
        int i9 = this.Kkkkkkkkkkkkkkkkkkkkk;
        boolean z7 = this.Kkkkkkkkkkkkkkkkkkkk;
        AbstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwww;
        AbstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwww;
        if (abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2621t3.Wwwwwwwwwwwwwwwwww, 0L, -9223372036854775807L, false, true);
            z = false;
        } else {
            AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Object obj2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2621t3, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            long j5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 ? c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : c2621t3.Wwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                Pair<Object, Long> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2209i4, wwwwwwwwwwwwwwwwwwwwwwwwwwww2, true, i9, z7, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 == null) {
                    i8 = abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z7);
                    obj = obj2;
                    z5 = false;
                    z6 = true;
                } else {
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -9223372036854775807L) {
                        i7 = abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.first, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        obj = obj2;
                    } else {
                        obj = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.first;
                        j5 = ((Long) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.second).longValue();
                        i7 = -1;
                    }
                    z5 = c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 4;
                    i8 = i7;
                    z6 = false;
                }
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                z4 = z5;
                z3 = z6;
                c2510q3 = c2510q32;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                z = false;
                i = -1;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                i5 = i8;
            } else {
                if (c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    i3 = abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z7);
                } else if (abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj2) == -1) {
                    Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, i9, z7, obj2, c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, abstractC2209i4);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 == null) {
                        i4 = abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z7);
                        z2 = true;
                    } else {
                        i4 = abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        z2 = false;
                    }
                    obj = obj2;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                    z3 = z2;
                    c2510q3 = c2510q32;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                    z = false;
                    i = -1;
                    z4 = false;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                    i5 = i4;
                } else {
                    if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3) {
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                        c2510q3 = c2510q32;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                        z = false;
                        i = -1;
                        obj = obj2;
                    } else if (j5 == -9223372036854775807L) {
                        i3 = abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj2, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    } else {
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                        c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                        z = false;
                        i = -1;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                        c2510q3 = c2510q32;
                        Pair<Object, Long> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj2, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, j5 + wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        obj = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.first;
                        j5 = ((Long) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.second).longValue();
                    }
                    i2 = -1;
                    i5 = i2;
                    z4 = false;
                    z3 = false;
                }
                obj = obj2;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                i2 = i3;
                c2510q3 = c2510q32;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                z = false;
                i = -1;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                i5 = i2;
                z4 = false;
                z3 = false;
            }
            if (i5 != i) {
                Pair<Object, Long> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i5, -9223372036854775807L);
                obj = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.first;
                j = ((Long) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.second).longValue();
                j2 = -9223372036854775807L;
            } else {
                j = j5;
                j2 = j;
            }
            AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 = c2510q3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2209i4, obj, j);
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(obj) && !wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == i || ((i6 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != i && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= i6))) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.equals(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    j4 = c2621t3.Wwwwwwwwwwwwwwwwwww;
                } else {
                    abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    j4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) ? wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : 0L;
                }
                j3 = j4;
            } else {
                j3 = j;
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8, j3, j2, z4, z3);
        }
        AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        long j6 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        boolean z8 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        long j7 = wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        boolean z9 = !this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3) || j7 != this.Wwww.Wwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwww3 = null;
        try {
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                if (this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 1) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z, z, z, true);
            }
            try {
                if (!z9) {
                    if (!this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2209i4, this.Kkkkkkkkkkkkkk, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww())) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
                    }
                } else if (!abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    for (C2430o3 c2430o3 = this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww; c2430o3 != null; c2430o3 = c2430o3.Wwwwwwwwwwwwwwwwwwwwwww) {
                        if (c2430o3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3)) {
                            c2430o3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2209i4, c2430o3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        }
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, j7, z8);
                    if (!z9 || j6 != this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        this.Wwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, j6);
                    }
                    Wwwwwwwwwwwwwwwwwwwww();
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2209i4, this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    this.Wwww = this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2209i4);
                    if (!abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                        this.Kkkkkkkkkkkkkkk = null;
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = j7;
                if (!z9) {
                }
                this.Wwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, j6);
                Wwwwwwwwwwwwwwwwwwwww();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2209i4, this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                this.Wwww = this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2209i4);
                if (!abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
            } catch (Throwable th) {
                th = th;
                wwwwwwwwwwwwwwwwwwwwwwwwwwww3 = null;
                if (z9 || j6 != this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                    this.Wwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, j7, j6);
                } else {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                }
                Wwwwwwwwwwwwwwwwwwwww();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2209i4, this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                this.Wwww = this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2209i4);
                if (!abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    this.Kkkkkkkkkkkkkkk = wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2784xe abstractC2784xe) throws ExoPlaybackException {
        C2430o3 c2430o3 = this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww;
        if (!(c2430o3 != null && c2430o3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == abstractC2784xe)) {
            return;
        }
        C2430o3 c2430o32 = this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww;
        float f = this.Wwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        AbstractC2209i4 abstractC2209i4 = this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        c2430o32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        c2430o32.Wwwwwwwwwwwwwwwwwwwwww = c2430o32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww();
        C2150gj Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2430o32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f, abstractC2209i4);
        C2467p3 c2467p3 = c2430o32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        long j = c2467p3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        long j2 = c2467p3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = c2430o32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, (j2 == -9223372036854775807L || j < j2) ? j : Math.max(0L, j2 - 1), false, new boolean[c2430o32.Wwwwwwwwwwwwwwwwwwwwwwwwww.length]);
        long j3 = c2430o32.Wwwwwwwwwwwwwwwwwwww;
        C2467p3 c2467p32 = c2430o32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        c2430o32.Wwwwwwwwwwwwwwwwwwww = (c2467p32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3) + j3;
        c2430o32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2467p32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2430o32.Wwwwwwwwwwwwwwwwwwwwww, c2430o32.Wwwwwwwwwwwwwwwwwwwww);
        if (c2430o32 == this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2430o32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            C2621t3 c2621t3 = this.Wwww;
            this.Wwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2430o32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2773x3 c2773x3) throws ExoPlaybackException {
        c2773x3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        try {
            c2773x3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2773x3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2773x3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        } finally {
            c2773x3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) throws ExoPlaybackException {
        this.Kkkkkkkkkkkkkkkkkkkk = z;
        C2510q3 c2510q3 = this.Wwwwwww;
        AbstractC2209i4 abstractC2209i4 = this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        c2510q3.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
        if (!c2510q3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2209i4)) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC1896a4 abstractC1896a4) throws ExoPlaybackException {
        if (!(abstractC1896a4.getState() != 0)) {
            return;
        }
        C1969c3 c1969c3 = this.Wwwwwwwwwww;
        if (abstractC1896a4 == c1969c3.Wwwwwwwwwwwwwwwwwwwwww) {
            c1969c3.Wwwwwwwwwwwwwwwwwwwww = null;
            c1969c3.Wwwwwwwwwwwwwwwwwwwwww = null;
            c1969c3.Wwwwwwwwwwwwwwwwwwww = true;
        }
        if (abstractC1896a4.getState() == 2) {
            abstractC1896a4.stop();
        }
        abstractC1896a4.disable();
        this.Kkkkkkkkkkkkkkkk--;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0098, code lost:
        if (r14 != (-9223372036854775807L)) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:345:0x0421, code lost:
        if ((r11 <= 0 || r9 >= r11 || (!r3.Wwwwwwwwwwwwwwwwwwwwwwwwwwww && r3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() >= r3.Wwwwwwwwwwwwwwwwwwwwwwwww)) != false) goto L350;
     */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0274 A[EDGE_INSN: B:162:0x0274->B:163:0x0274 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x02dd A[EDGE_INSN: B:190:0x02dd->B:199:0x02dd ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x04ad  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x04b9  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x04d9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws ExoPlaybackException, IOException {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        C2621t3 c2621t3;
        int i;
        C2430o3 c2430o3;
        C2430o3 c2430o32;
        boolean z5;
        C2430o3 c2430o33;
        C2430o3 c2430o34;
        boolean z6;
        int i2;
        AbstractC1896a4[] abstractC1896a4Arr;
        boolean z7;
        AbstractC1896a4[] abstractC1896a4Arr2;
        C2467p3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        long j;
        long j2;
        C2430o3 c2430o35;
        C2430o3 c2430o36;
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.Wwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (!this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && this.Wwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkk);
            C2510q3 c2510q3 = this.Wwwwwww;
            C2430o3 c2430o37 = c2510q3.Wwwwwwwwwwwwwwwwwwwwwwwww;
            if (c2430o37 == null || (!c2430o37.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww && c2430o37.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && c2510q3.Wwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww != -9223372036854775807L && c2510q3.Wwwwwwwwwwwwwwwwwwwwwwww < 100)) {
                C2510q3 c2510q32 = this.Wwwwwww;
                long j3 = this.Kkkkkkkkkkkkkk;
                C2621t3 c2621t32 = this.Wwww;
                C2430o3 c2430o38 = c2510q32.Wwwwwwwwwwwwwwwwwwwwwwwww;
                if (c2430o38 == null) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2510q32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2621t32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2621t32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2621t32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2621t32.Wwwwwwwwwwwwwwwwwww);
                } else {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2510q32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2621t32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2430o38, j3);
                }
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                    C2510q3 c2510q33 = this.Wwwwwww;
                    AbstractC1970c4[] abstractC1970c4Arr = this.Wwwwwwwwwwwwwwwwwwwwwww;
                    AbstractC2113fj abstractC2113fj = this.Wwwwwwwwwwwwwwwwwwwwww;
                    C1986ck c1986ck = ((C1932b3) this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    C2584s3 c2584s3 = this.Wwwwww;
                    C2150gj c2150gj = this.Wwwwwwwwwwwwwwwwwwwww;
                    C2430o3 c2430o39 = c2510q33.Wwwwwwwwwwwwwwwwwwwwwwwww;
                    if (c2430o39 != null) {
                        j = (c2430o39.Wwwwwwwwwwwwwwwwwwww + c2430o39.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    } else {
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                            j = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        }
                        j2 = 0;
                        c2430o35 = new C2430o3(abstractC1970c4Arr, j2, abstractC2113fj, c1986ck, c2584s3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, c2150gj);
                        c2430o36 = c2510q33.Wwwwwwwwwwwwwwwwwwwwwwwww;
                        if (c2430o36 == null) {
                            if (c2430o35 != c2430o36.Wwwwwwwwwwwwwwwwwwwwwww) {
                                c2430o36.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                c2430o36.Wwwwwwwwwwwwwwwwwwwwwww = c2430o35;
                                c2430o36.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            }
                        } else {
                            c2510q33.Wwwwwwwwwwwwwwwwwwwwwwwwwww = c2430o35;
                            c2510q33.Wwwwwwwwwwwwwwwwwwwwwwwwww = c2430o35;
                        }
                        c2510q33.Wwwwwwwwwwwwwwwwwwwwwww = null;
                        c2510q33.Wwwwwwwwwwwwwwwwwwwwwwwww = c2430o35;
                        c2510q33.Wwwwwwwwwwwwwwwwwwwwwwww++;
                        c2510q33.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        c2430o35.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        if (this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww == c2430o35) {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2430o35.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                        }
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
                        if (this.Kkkkkkkkkkkkkkkkkkkkkk) {
                            this.Kkkkkkkkkkkkkkkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            Wwwwwwwwwwwwwwwww();
                        } else {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwww();
                        }
                        c2430o3 = this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (c2430o3 != null) {
                            if (c2430o3.Wwwwwwwwwwwwwwwwwwwwwww != null && !this.Kkkkkkkkkkkkkkkkkkkkkkkk) {
                                if (c2430o3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                                    int i3 = 0;
                                    while (true) {
                                        AbstractC1896a4[] abstractC1896a4Arr3 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                                        if (i3 >= abstractC1896a4Arr3.length) {
                                            z7 = true;
                                            break;
                                        }
                                        AbstractC1896a4 abstractC1896a4 = abstractC1896a4Arr3[i3];
                                        AbstractC2183hf abstractC2183hf = c2430o3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i3];
                                        if (abstractC1896a4.Wwwwwwwwwwwwwwwwwwwwwwwwww() != abstractC2183hf || (abstractC2183hf != null && !abstractC1896a4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww())) {
                                            break;
                                        }
                                        i3++;
                                    }
                                }
                                z7 = false;
                                if (z7) {
                                    C2430o3 c2430o310 = c2430o3.Wwwwwwwwwwwwwwwwwwwwwww;
                                    if (c2430o310.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || this.Kkkkkkkkkkkkkk >= c2430o310.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                        C2150gj c2150gj2 = c2430o3.Wwwwwwwwwwwwwwwwwwwww;
                                        C2510q3 c2510q34 = this.Wwwwwww;
                                        C2430o3 c2430o311 = c2510q34.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww((c2430o311 == null || c2430o311.Wwwwwwwwwwwwwwwwwwwwwww == null) ? false : true);
                                        c2510q34.Wwwwwwwwwwwwwwwwwwwwwwwwww = c2510q34.Wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
                                        c2510q34.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                        C2430o3 c2430o312 = c2510q34.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                                        C2150gj c2150gj3 = c2430o312.Wwwwwwwwwwwwwwwwwwwww;
                                        if (c2430o312.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && c2430o312.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww() != -9223372036854775807L) {
                                            for (AbstractC1896a4 abstractC1896a42 : this.Wwwwwwwwwwwwwwwwwwwwwwww) {
                                                if (abstractC1896a42.Wwwwwwwwwwwwwwwwwwwwwwwwww() != null) {
                                                    abstractC1896a42.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                }
                                            }
                                        } else {
                                            for (int i4 = 0; i4 < this.Wwwwwwwwwwwwwwwwwwwwwwww.length; i4++) {
                                                boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = c2150gj2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4);
                                                boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = c2150gj3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4);
                                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 && !this.Wwwwwwwwwwwwwwwwwwwwwwww[i4].Wwwwwwwwwwwwwwwwwwwwwww()) {
                                                    boolean z8 = ((AbstractC2846z2) this.Wwwwwwwwwwwwwwwwwwwwwww[i4]).Wwwwwwwwwwwwwwwwwwwwwwww == 6;
                                                    C2007d4 c2007d4 = c2150gj2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i4];
                                                    C2007d4 c2007d42 = c2150gj3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i4];
                                                    if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 || !c2007d42.equals(c2007d4) || z8) {
                                                        this.Wwwwwwwwwwwwwwwwwwwwwwww[i4].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } else if (c2430o3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww || this.Kkkkkkkkkkkkkkkkkkkkkkkk) {
                                int i5 = 0;
                                while (true) {
                                    AbstractC1896a4[] abstractC1896a4Arr4 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                                    if (i5 >= abstractC1896a4Arr4.length) {
                                        break;
                                    }
                                    AbstractC1896a4 abstractC1896a43 = abstractC1896a4Arr4[i5];
                                    AbstractC2183hf abstractC2183hf2 = c2430o3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i5];
                                    if (abstractC2183hf2 != null && abstractC1896a43.Wwwwwwwwwwwwwwwwwwwwwwwwww() == abstractC2183hf2 && abstractC1896a43.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                        abstractC1896a43.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                    }
                                    i5++;
                                }
                            }
                        }
                        C2510q3 c2510q35 = this.Wwwwwww;
                        c2430o32 = c2510q35.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (c2430o32 != null && c2510q35.Wwwwwwwwwwwwwwwwwwwwwwwwwww != c2430o32 && !c2430o32.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                            C2150gj c2150gj4 = c2430o32.Wwwwwwwwwwwwwwwwwwwww;
                            z6 = false;
                            i2 = 0;
                            while (true) {
                                abstractC1896a4Arr = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                                if (i2 < abstractC1896a4Arr.length) {
                                    break;
                                }
                                AbstractC1896a4 abstractC1896a44 = abstractC1896a4Arr[i2];
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1896a44)) {
                                    boolean z9 = abstractC1896a44.Wwwwwwwwwwwwwwwwwwwwwwwwww() != c2430o32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2];
                                    if (!c2150gj4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2) || z9) {
                                        if (!abstractC1896a44.Wwwwwwwwwwwwwwwwwwwwwww()) {
                                            abstractC1896a44.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2150gj4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2]), c2430o32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2], c2430o32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), c2430o32.Wwwwwwwwwwwwwwwwwwww);
                                        } else if (abstractC1896a44.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1896a44);
                                        } else {
                                            z6 = true;
                                        }
                                    }
                                }
                                i2++;
                            }
                            if (!z6) {
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            }
                        }
                        z5 = false;
                        while (true) {
                            if (Wwwwwwwwwwwwwwwwwwww() && !this.Kkkkkkkkkkkkkkkkkkkkkkkk && (c2430o33 = this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww) != null && (c2430o34 = c2430o33.Wwwwwwwwwwwwwwwwwwwwwww) != null && this.Kkkkkkkkkkkkkk >= c2430o34.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && c2430o34.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                                break;
                            }
                            if (z5) {
                                Wwwwwwwwwwwwwwwwwwwwwwwwww();
                            }
                            C2510q3 c2510q36 = this.Wwwwwww;
                            C2430o3 c2430o313 = c2510q36.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                            C2467p3 c2467p3 = c2510q36.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            this.Wwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2467p3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2467p3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2467p3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            this.Www.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2430o313.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww ? 0 : 3);
                            Wwwwwwwwwwwwwwwwwwwww();
                            Wwwwwwwwwwwwwwww();
                            z5 = true;
                        }
                    }
                    j2 = j;
                    c2430o35 = new C2430o3(abstractC1970c4Arr, j2, abstractC2113fj, c1986ck, c2584s3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, c2150gj);
                    c2430o36 = c2510q33.Wwwwwwwwwwwwwwwwwwwwwwwww;
                    if (c2430o36 == null) {
                    }
                    c2510q33.Wwwwwwwwwwwwwwwwwwwwwww = null;
                    c2510q33.Wwwwwwwwwwwwwwwwwwwwwwwww = c2430o35;
                    c2510q33.Wwwwwwwwwwwwwwwwwwwwwwww++;
                    c2510q33.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    c2430o35.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    if (this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww == c2430o35) {
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
                    if (this.Kkkkkkkkkkkkkkkkkkkkkk) {
                    }
                    c2430o3 = this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (c2430o3 != null) {
                    }
                    C2510q3 c2510q352 = this.Wwwwwww;
                    c2430o32 = c2510q352.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (c2430o32 != null) {
                        C2150gj c2150gj42 = c2430o32.Wwwwwwwwwwwwwwwwwwwww;
                        z6 = false;
                        i2 = 0;
                        while (true) {
                            abstractC1896a4Arr = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                            if (i2 < abstractC1896a4Arr.length) {
                            }
                            i2++;
                        }
                        if (!z6) {
                        }
                    }
                    z5 = false;
                    while (true) {
                        if (Wwwwwwwwwwwwwwwwwwww()) {
                            if (Wwwwwwwwwwwwwwwwwwww() && !this.Kkkkkkkkkkkkkkkkkkkkkkkk && (c2430o33 = this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww) != null && (c2430o34 = c2430o33.Wwwwwwwwwwwwwwwwwwwwwww) != null && this.Kkkkkkkkkkkkkk >= c2430o34.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && c2430o34.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                            }
                        }
                        if (Wwwwwwwwwwwwwwwwwwww() && !this.Kkkkkkkkkkkkkkkkkkkkkkkk && (c2430o33 = this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww) != null && (c2430o34 = c2430o33.Wwwwwwwwwwwwwwwwwwwwwww) != null && this.Kkkkkkkkkkkkkk >= c2430o34.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && c2430o34.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        }
                        this.Www.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2430o313.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww ? 0 : 3);
                        Wwwwwwwwwwwwwwwwwwwww();
                        Wwwwwwwwwwwwwwww();
                        z5 = true;
                    }
                }
            }
            if (this.Kkkkkkkkkkkkkkkkkkkkkk) {
            }
            c2430o3 = this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww;
            if (c2430o3 != null) {
            }
            C2510q3 c2510q3522 = this.Wwwwwww;
            c2430o32 = c2510q3522.Wwwwwwwwwwwwwwwwwwwwwwwwww;
            if (c2430o32 != null) {
            }
            z5 = false;
            while (true) {
                if (Wwwwwwwwwwwwwwwwwwww() && !this.Kkkkkkkkkkkkkkkkkkkkkkkk && (c2430o33 = this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww) != null && (c2430o34 = c2430o33.Wwwwwwwwwwwwwwwwwwwwwww) != null && this.Kkkkkkkkkkkkkk >= c2430o34.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && c2430o34.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                }
                this.Www.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2430o313.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww ? 0 : 3);
                Wwwwwwwwwwwwwwwwwwwww();
                Wwwwwwwwwwwwwwww();
                z5 = true;
            }
        }
        int i6 = this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i6 != 1 && i6 != 4) {
            C2430o3 c2430o314 = this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (c2430o314 == null) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, 10L);
                return;
            }
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("doSomeWork");
            Wwwwwwwwwwwwwwww();
            if (c2430o314.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
                c2430o314.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwww.Wwwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwww, this.Wwwwwwwwwwww);
                z = true;
                z2 = true;
                int i7 = 0;
                while (true) {
                    AbstractC1896a4[] abstractC1896a4Arr5 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                    if (i7 >= abstractC1896a4Arr5.length) {
                        break;
                    }
                    AbstractC1896a4 abstractC1896a45 = abstractC1896a4Arr5[i7];
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1896a45)) {
                        abstractC1896a45.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkk, elapsedRealtime);
                        z = z && abstractC1896a45.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        boolean z10 = c2430o314.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i7] != abstractC1896a45.Wwwwwwwwwwwwwwwwwwwwwwwwww();
                        boolean z11 = z10 || (!z10 && abstractC1896a45.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) || abstractC1896a45.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || abstractC1896a45.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        z2 = z2 && z11;
                        if (!z11) {
                            abstractC1896a45.Wwwwwwwwwwwwwwwwwwwwwwwww();
                        }
                    }
                    i7++;
                }
            } else {
                c2430o314.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                z = true;
                z2 = true;
            }
            long j4 = c2430o314.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            boolean z12 = z && c2430o314.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && (j4 == -9223372036854775807L || j4 <= this.Wwww.Wwwwwwwwwwwwwwwwwww);
            if (z12 && this.Kkkkkkkkkkkkkkkkkkkkkkkk) {
                this.Kkkkkkkkkkkkkkkkkkkkkkkk = false;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwww, false, 5);
            }
            if (!z12 || !c2430o314.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww) {
                C2621t3 c2621t33 = this.Wwww;
                if (c2621t33.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 2) {
                    if (this.Kkkkkkkkkkkkkkkk == 0) {
                        z3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    } else {
                        if (z2) {
                            if (c2621t33.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                                C2430o3 c2430o315 = this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww;
                                if (!(c2430o315.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && c2430o315.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                    AbstractC2319l3 abstractC2319l3 = this.Wwwwwwwwwwwwwwwwwwww;
                                    long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                    float f = this.Wwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    boolean z13 = this.Kkkkkkkkkkkkkkkkkkkkkkk;
                                    C1932b3 c1932b3 = (C1932b3) abstractC2319l3;
                                    if (c1932b3 == null) {
                                        throw null;
                                    }
                                    long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, f);
                                    long j5 = z13 ? c1932b3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww : c1932b3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                }
                            }
                            z3 = true;
                        }
                        z3 = false;
                    }
                    if (z3) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
                        if (Wwwwwwwwwwwwwwwwwwww()) {
                            Wwwwwwwwwwwwwwwwwww();
                        }
                        if (this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 2) {
                            int i8 = 0;
                            while (true) {
                                AbstractC1896a4[] abstractC1896a4Arr6 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                                if (i8 >= abstractC1896a4Arr6.length) {
                                    break;
                                }
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1896a4Arr6[i8]) && this.Wwwwwwwwwwwwwwwwwwwwwwww[i8].Wwwwwwwwwwwwwwwwwwwwwwwwww() == c2430o314.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i8]) {
                                    this.Wwwwwwwwwwwwwwwwwwwwwwww[i8].Wwwwwwwwwwwwwwwwwwwwwwwww();
                                }
                                i8++;
                            }
                            if (this.Kkkkkkkkkkk) {
                                C2621t3 c2621t34 = this.Wwww;
                                if (!c2621t34.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww && c2621t34.Wwwwwwwwwwwwwwwwwwww < 500000 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                    throw new IllegalStateException("Playback stuck buffering and not loading");
                                }
                            }
                        }
                        z4 = this.Kkkkkkkkkkkkkkkkk;
                        c2621t3 = this.Wwww;
                        if (z4 != c2621t3.Wwwwwwwwwwwwwwwwwwwwww) {
                            this.Wwww = c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z4);
                        }
                        if ((!Wwwwwwwwwwwwwwwwwwww() && this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 3) || (i = this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == 2) {
                            if (!this.Kkkkkkkkkkkkkkkkk || !this.Kkkkkkkkkkkkkkkkkk) {
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, 10L);
                            }
                        } else if (this.Kkkkkkkkkkkkkkkk != 0 || i == 4) {
                            this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.removeMessages(2);
                        } else {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, 1000L);
                        }
                        this.Kkkkkkkkkkkkkkkkkk = false;
                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        return;
                    }
                }
                if (this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 3 && (this.Kkkkkkkkkkkkkkkk != 0 ? !z2 : !Wwwwwwwwwwwwwwwwwwwwwwwwwwwww())) {
                    this.Kkkkkkkkkkkkkkkkkkkkkkk = Wwwwwwwwwwwwwwwwwwww();
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                }
                if (this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 2) {
                }
                z4 = this.Kkkkkkkkkkkkkkkkk;
                c2621t3 = this.Wwww;
                if (z4 != c2621t3.Wwwwwwwwwwwwwwwwwwwwww) {
                }
                if (!Wwwwwwwwwwwwwwwwwwww()) {
                }
                if (this.Kkkkkkkkkkkkkkkk != 0) {
                }
                this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.removeMessages(2);
                this.Kkkkkkkkkkkkkkkkkk = false;
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
            Wwwwwwwwwwwwwwwwww();
            if (this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 2) {
            }
            z4 = this.Kkkkkkkkkkkkkkkkk;
            c2621t3 = this.Wwww;
            if (z4 != c2621t3.Wwwwwwwwwwwwwwwwwwwwww) {
            }
            if (!Wwwwwwwwwwwwwwwwwwww()) {
            }
            if (this.Kkkkkkkkkkkkkkkk != 0) {
            }
            this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.removeMessages(2);
            this.Kkkkkkkkkkkkkkkkkk = false;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return;
        }
        this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.removeMessages(2);
    }

    public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2773x3 c2773x3) {
        try {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2773x3);
        } catch (ExoPlaybackException e) {
            C2827yk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unexpected error delivering message on external thread.", e);
            throw new RuntimeException(e);
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) throws ExoPlaybackException {
        AbstractC1896a4[] abstractC1896a4Arr;
        AbstractC1985cj[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        C2430o3 c2430o3 = this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (c2430o3 != null) {
            j += c2430o3.Wwwwwwwwwwwwwwwwwwww;
        }
        this.Kkkkkkkkkkkkkk = j;
        this.Wwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
        for (AbstractC1896a4 abstractC1896a4 : this.Wwwwwwwwwwwwwwwwwwwwwwww) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1896a4)) {
                abstractC1896a4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkk);
            }
        }
        for (C2430o3 c2430o32 = this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww; c2430o32 != null; c2430o32 = c2430o32.Wwwwwwwwwwwwwwwwwwwwwww) {
            for (AbstractC1985cj abstractC1985cj : c2430o32.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                if (abstractC1985cj != null) {
                    abstractC1985cj.Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
            }
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) throws ExoPlaybackException {
        AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwww.Wwwwwwwwwwwwwwwwwww, true, false);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != this.Wwww.Wwwwwwwwwwwwwwwwwww) {
            this.Wwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (!z) {
                return;
            }
            this.Www.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean[] zArr) throws ExoPlaybackException {
        AbstractC1913al abstractC1913al;
        C2430o3 c2430o3 = this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        C2150gj c2150gj = c2430o3.Wwwwwwwwwwwwwwwwwwwww;
        for (int i = 0; i < this.Wwwwwwwwwwwwwwwwwwwwwwww.length; i++) {
            if (!c2150gj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i)) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww[i].reset();
            }
        }
        for (int i2 = 0; i2 < this.Wwwwwwwwwwwwwwwwwwwwwwww.length; i2++) {
            if (c2150gj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2)) {
                boolean z = zArr[i2];
                AbstractC1896a4 abstractC1896a4 = this.Wwwwwwwwwwwwwwwwwwwwwwww[i2];
                if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1896a4)) {
                    C2510q3 c2510q3 = this.Wwwwwww;
                    C2430o3 c2430o32 = c2510q3.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                    boolean z2 = c2430o32 == c2510q3.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                    C2150gj c2150gj2 = c2430o32.Wwwwwwwwwwwwwwwwwwwww;
                    C2007d4 c2007d4 = c2150gj2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2];
                    C2245j3[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2150gj2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2]);
                    boolean z3 = Wwwwwwwwwwwwwwwwwwww() && this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 3;
                    boolean z4 = !z && z3;
                    this.Kkkkkkkkkkkkkkkk++;
                    abstractC1896a4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2007d4, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, c2430o32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2], this.Kkkkkkkkkkkkkk, z4, z2, c2430o32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), c2430o32.Wwwwwwwwwwwwwwwwwwww);
                    abstractC1896a4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(103, new C2134g3(this));
                    C1969c3 c1969c3 = this.Wwwwwwwwwww;
                    if (c1969c3 != null) {
                        AbstractC1913al Wwwwwwwwwwwwwwwwwwwwww = abstractC1896a4.Wwwwwwwwwwwwwwwwwwwwww();
                        if (Wwwwwwwwwwwwwwwwwwwwww != null && Wwwwwwwwwwwwwwwwwwwwww != (abstractC1913al = c1969c3.Wwwwwwwwwwwwwwwwwwwww)) {
                            if (abstractC1913al != null) {
                                throw ExoPlaybackException.createForUnexpected(new IllegalStateException("Multiple renderer media clocks enabled."));
                            }
                            c1969c3.Wwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwww;
                            c1969c3.Wwwwwwwwwwwwwwwwwwwwww = abstractC1896a4;
                            Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c1969c3.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww);
                        }
                        if (z3) {
                            abstractC1896a4.start();
                        }
                    } else {
                        throw null;
                    }
                } else {
                    continue;
                }
            }
        }
        c2430o3.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
    }

    public final Pair<AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Long> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2209i4 abstractC2209i4) {
        long j = 0;
        if (abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return Pair.create(C2621t3.Wwwwwwwwwwwwwwwwww, 0L);
        }
        Pair<Object, Long> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwww, this.Wwwwwwwwwwwwww, abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkkkk), -9223372036854775807L);
        AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2209i4, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.first, 0L);
        long longValue = ((Long) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.second).longValue();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwww);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                j = this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            longValue = j;
        }
        return Pair.create(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Long.valueOf(longValue));
    }

    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        C2430o3 c2430o3 = this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww;
        if (c2430o3 == null) {
            return 0L;
        }
        return Math.max(0L, j - (this.Kkkkkkkkkkkkkk - c2430o3.Wwwwwwwwwwwwwwwwwwww));
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        C2430o3 c2430o3 = this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww;
        AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2430o3 == null ? this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : c2430o3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        boolean z2 = !this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwww.equals(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (z2) {
            this.Wwww = this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        C2621t3 c2621t3 = this.Wwww;
        c2621t3.Wwwwwwwwwwwwwwwwwwwww = c2430o3 == null ? c2621t3.Wwwwwwwwwwwwwwwwwww : c2430o3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwww.Wwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if ((z2 || z) && c2430o3 != null && c2430o3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2430o3.Wwwwwwwwwwwwwwwwwwwwww, c2430o3.Wwwwwwwwwwwwwwwwwwwww);
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2658u3 c2658u3, boolean z) throws ExoPlaybackException {
        int i;
        this.Www.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z ? 1 : 0);
        this.Wwww = this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2658u3);
        float f = c2658u3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2430o3 c2430o3 = this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        while (true) {
            i = 0;
            if (c2430o3 == null) {
                break;
            }
            AbstractC1985cj[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2430o3.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            int length = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.length;
            while (i < length) {
                AbstractC1985cj abstractC1985cj = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2[i];
                if (abstractC1985cj != null) {
                    abstractC1985cj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f);
                }
                i++;
            }
            c2430o3 = c2430o3.Wwwwwwwwwwwwwwwwwwwwwww;
        }
        AbstractC1896a4[] abstractC1896a4Arr = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        int length2 = abstractC1896a4Arr.length;
        while (i < length2) {
            AbstractC1896a4 abstractC1896a4 = abstractC1896a4Arr[i];
            if (abstractC1896a4 != null) {
                abstractC1896a4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2658u3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            i++;
        }
    }

    @CheckResult
    public final C2621t3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, long j, long j2) {
        C2368mf c2368mf;
        C2150gj c2150gj;
        C2368mf c2368mf2;
        C2150gj c2150gj2;
        this.Kkkkkkkkkkkk = this.Kkkkkkkkkkkk || j != this.Wwww.Wwwwwwwwwwwwwwwwwww || !wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwww();
        C2621t3 c2621t3 = this.Wwww;
        C2368mf c2368mf3 = c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2150gj c2150gj3 = c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (this.Wwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww) {
            C2430o3 c2430o3 = this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (c2430o3 == null) {
                c2368mf2 = C2368mf.Wwwwwwwwwwwwwwwwwwwww;
            } else {
                c2368mf2 = c2430o3.Wwwwwwwwwwwwwwwwwwwwww;
            }
            if (c2430o3 == null) {
                c2150gj2 = this.Wwwwwwwwwwwwwwwwwwwww;
            } else {
                c2150gj2 = c2430o3.Wwwwwwwwwwwwwwwwwwwww;
            }
            c2150gj = c2150gj2;
            c2368mf = c2368mf2;
        } else if (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            c2368mf = C2368mf.Wwwwwwwwwwwwwwwwwwwww;
            c2150gj = this.Wwwwwwwwwwwwwwwwwwwww;
        } else {
            c2368mf = c2368mf3;
            c2150gj = c2150gj3;
        }
        return this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, j, j2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), c2368mf, c2150gj);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) throws ExoPlaybackException {
        this.Www.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        C2584s3 c2584s3 = this.Wwwwww;
        int i = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        AbstractC2257jf abstractC2257jf = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (c2584s3 != null) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i >= 0 && i <= i2 && i2 <= c2584s3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && i3 >= 0);
            c2584s3.Wwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2257jf;
            if (i != i2 && i != i3) {
                int min = Math.min(i, i3);
                int max = Math.max(((i2 - i) + i3) - 1, i2 - 1);
                int i4 = c2584s3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(min).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2584s3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i, i2, i3);
                while (min <= max) {
                    C2584s3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2584s3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(min);
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i4;
                    i4 += wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    min++;
                }
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2584s3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            return;
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2220if.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2784xe abstractC2784xe) {
        this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(9, abstractC2784xe).sendToTarget();
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, AbstractC2257jf abstractC2257jf) throws ExoPlaybackException {
        boolean z = true;
        this.Www.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        C2584s3 c2584s3 = this.Wwwwww;
        if (c2584s3 != null) {
            if (i < 0 || i > i2 || i2 > c2584s3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                z = false;
            }
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
            c2584s3.Wwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2257jf;
            c2584s3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2584s3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            return;
        }
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, boolean z2, boolean z3, boolean z4) {
        AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        long j;
        long j2;
        boolean z5;
        this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.removeMessages(2);
        this.Kkkkkkkkkkkkkkkkkkkkkkk = false;
        C1969c3 c1969c3 = this.Wwwwwwwwwww;
        c1969c3.Wwwwwwwwwwwwwwwwwww = false;
        C2189hl c2189hl = c1969c3.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (c2189hl.Wwwwwwwwwwwwwwwwwwwwwww) {
            c2189hl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2189hl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww());
            c2189hl.Wwwwwwwwwwwwwwwwwwwwwww = false;
        }
        this.Kkkkkkkkkkkkkk = 0L;
        for (AbstractC1896a4 abstractC1896a4 : this.Wwwwwwwwwwwwwwwwwwwwwwww) {
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1896a4);
            } catch (ExoPlaybackException | RuntimeException e) {
                C2827yk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Disable failed.", e);
            }
        }
        if (z) {
            for (AbstractC1896a4 abstractC1896a42 : this.Wwwwwwwwwwwwwwwwwwwwwwww) {
                try {
                    abstractC1896a42.reset();
                } catch (RuntimeException e2) {
                    C2827yk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Reset failed.", e2);
                }
            }
        }
        this.Kkkkkkkkkkkkkkkk = 0;
        C2621t3 c2621t3 = this.Wwww;
        AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        long j3 = c2621t3.Wwwwwwwwwwwwwwwwwww;
        long j4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwww, this.Wwwwwwwwwwwwww, this.Wwwwwwwwwwwwwww) ? this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : this.Wwww.Wwwwwwwwwwwwwwwwwww;
        ExoPlaybackException exoPlaybackException = null;
        if (z2) {
            this.Kkkkkkkkkkkkkkk = null;
            Pair<AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Long> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = (AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.first;
            long longValue = ((Long) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.second).longValue();
            j2 = -9223372036854775807L;
            if (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.equals(this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                z5 = true;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                j = longValue;
                this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                this.Kkkkkkkkkkkkkkkkkkkkkk = false;
                C2621t3 c2621t32 = this.Wwww;
                AbstractC2209i4 abstractC2209i4 = c2621t32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i = c2621t32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (!z4) {
                    exoPlaybackException = c2621t32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
                ExoPlaybackException exoPlaybackException2 = exoPlaybackException;
                C2368mf c2368mf = !z5 ? C2368mf.Wwwwwwwwwwwwwwwwwwwww : this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                C2150gj c2150gj = !z5 ? this.Wwwwwwwwwwwwwwwwwwwww : this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                C2621t3 c2621t33 = this.Wwww;
                this.Wwww = new C2621t3(abstractC2209i4, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, j2, i, exoPlaybackException2, false, c2368mf, c2150gj, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2621t33.Wwwwwwwwwwwwwwwwwwwwwwwww, c2621t33.Wwwwwwwwwwwwwwwwwwwwwwww, c2621t33.Wwwwwwwwwwwwwwwwwwwwwww, j, 0L, j, this.Kkkkkkkkkkkkkkkkk);
                if (z3) {
                    return;
                }
                C2584s3 c2584s3 = this.Wwwwww;
                for (C2584s3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : c2584s3.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.values()) {
                    try {
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    } catch (RuntimeException e3) {
                        C2827yk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Failed to release child source.", e3);
                    }
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
                c2584s3.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
                c2584s3.Wwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
                c2584s3.Wwwwwwwwwwwwwwwwwwwwwwwww = false;
                return;
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
            j3 = longValue;
            j4 = -9223372036854775807L;
        }
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        j = j3;
        j2 = j4;
        z5 = false;
        this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Kkkkkkkkkkkkkkkkkkkkkk = false;
        C2621t3 c2621t322 = this.Wwww;
        AbstractC2209i4 abstractC2209i42 = c2621t322.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = c2621t322.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (!z4) {
        }
        ExoPlaybackException exoPlaybackException22 = exoPlaybackException;
        C2368mf c2368mf2 = !z5 ? C2368mf.Wwwwwwwwwwwwwwwwwwwww : this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (!z5) {
        }
        C2621t3 c2621t332 = this.Wwww;
        this.Wwww = new C2621t3(abstractC2209i42, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, j2, i2, exoPlaybackException22, false, c2368mf2, c2150gj, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2621t332.Wwwwwwwwwwwwwwwwwwwwwwwww, c2621t332.Wwwwwwwwwwwwwwwwwwwwwwww, c2621t332.Wwwwwwwwwwwwwwwwwwwwwww, j, 0L, j, this.Kkkkkkkkkkkkkkkkk);
        if (z3) {
        }
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, AbstractC2209i4 abstractC2209i4, AbstractC2209i4 abstractC2209i42, int i, boolean z, AbstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, AbstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        Object obj = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww;
        if (obj == null) {
            long j = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = j == Long.MIN_VALUE ? -9223372036854775807L : C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
            C2773x3 c2773x3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
            Pair<Object, Long> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2209i4, new Wwwwwwwwwwwwwwwwwwwwwwwwwwww(c2773x3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2773x3.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2), false, i, z, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == null) {
                return false;
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.first), ((Long) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.second).longValue(), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.first);
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww == Long.MIN_VALUE) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2209i4, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            return true;
        }
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 == -1) {
            return false;
        }
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww == Long.MIN_VALUE) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2209i4, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            return true;
        }
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
        abstractC2209i42.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (abstractC2209i42.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2).Wwwwwwwwwwwwwwwwwwwwwwww) {
            Pair<Object, Long> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww + wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.first), ((Long) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.second).longValue(), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.first);
        }
        return true;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2) {
        this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.removeMessages(2);
        this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.sendEmptyMessageAtTime(2, j + j2);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwww) throws ExoPlaybackException {
        long j;
        AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        boolean z;
        long j2;
        long j3;
        long j4;
        this.Www.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        Pair<Object, Long> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwww, true, this.Kkkkkkkkkkkkkkkkkkkkk, this.Kkkkkkkkkkkkkkkkkkkk, this.Wwwwwwwwwwwwwww, this.Wwwwwwwwwwwwww);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == null) {
            Pair<AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Long> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.first;
            long longValue = ((Long) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.second).longValue();
            z = !this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            j2 = longValue;
            j = -9223372036854775807L;
        } else {
            Object obj = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.first;
            long longValue2 = ((Long) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.second).longValue();
            j = wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -9223372036854775807L ? -9223372036854775807L : longValue2;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, obj, longValue2);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwww);
                j2 = this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : 0L;
                z = true;
            } else {
                z = wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -9223372036854775807L;
                j2 = longValue2;
            }
        }
        try {
            if (this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                this.Kkkkkkkkkkkkkkk = wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != null) {
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.equals(this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    C2430o3 c2430o3 = this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                    long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = (c2430o3 == null || !c2430o3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || j2 == 0) ? j2 : c2430o3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2, this.Wwwww);
                    long j5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5;
                    if (C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5) == C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwww.Wwwwwwwwwwwwwwwwwww) && (this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 2 || this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 3)) {
                        this.Wwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, this.Wwww.Wwwwwwwwwwwwwwwwwww, j);
                        if (!z) {
                            return;
                        }
                        this.Www.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                        return;
                    }
                    j3 = j5;
                } else {
                    j3 = j2;
                }
                long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, j3, this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 4);
                z |= j2 != Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6;
                j4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6;
                this.Wwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, j4, j);
                if (z) {
                    return;
                }
                this.Www.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                return;
            } else {
                if (this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 1) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, true, false, true);
            }
            j4 = j2;
            this.Wwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, j4, j);
            if (z) {
            }
        } catch (Throwable th) {
            this.Wwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, j2, j);
            if (z) {
                this.Www.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
            }
            throw th;
        }
    }

    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, long j, boolean z) throws ExoPlaybackException {
        C2510q3 c2510q3 = this.Wwwwwww;
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, j, c2510q3.Wwwwwwwwwwwwwwwwwwwwwwwwwww != c2510q3.Wwwwwwwwwwwwwwwwwwwwwwwwww, z);
    }

    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, long j, boolean z, boolean z2) throws ExoPlaybackException {
        C2510q3 c2510q3;
        Wwwwwwwwwwwwwwwwww();
        this.Kkkkkkkkkkkkkkkkkkkkkkk = false;
        if (z2 || this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 3) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
        }
        C2430o3 c2430o3 = this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2430o3 c2430o32 = c2430o3;
        while (c2430o32 != null && !wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(c2430o32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            c2430o32 = c2430o32.Wwwwwwwwwwwwwwwwwwwwwww;
        }
        if (z || c2430o3 != c2430o32 || (c2430o32 != null && c2430o32.Wwwwwwwwwwwwwwwwwwww + j < 0)) {
            for (AbstractC1896a4 abstractC1896a4 : this.Wwwwwwwwwwwwwwwwwwwwwwww) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1896a4);
            }
            if (c2430o32 != null) {
                while (true) {
                    c2510q3 = this.Wwwwwww;
                    if (c2510q3.Wwwwwwwwwwwwwwwwwwwwwwwwwww == c2430o32) {
                        break;
                    }
                    c2510q3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
                c2510q3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2430o32);
                c2430o32.Wwwwwwwwwwwwwwwwwwww = 0L;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }
        C2510q3 c2510q32 = this.Wwwwwww;
        if (c2430o32 != null) {
            c2510q32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2430o32);
            if (!c2430o32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                c2430o32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2430o32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
            } else {
                long j2 = c2430o32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (j2 != -9223372036854775807L && j >= j2) {
                    j = Math.max(0L, j2 - 1);
                }
                if (c2430o32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2430o32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
                    c2430o32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 - this.Wwwwwwwwwwwww, this.Wwwwwwwwwwww);
                    j = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                }
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
            Wwwwwwwwwwwwwwwwwwwwwwwwwww();
        } else {
            c2510q32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
        this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
        return j;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) throws ExoPlaybackException {
        this.Www.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != -1) {
            this.Kkkkkkkkkkkkkkk = new Wwwwwwwwwwwwwwwwwwwwwwwwwwww(new C2810y3(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        C2584s3 c2584s3 = this.Wwwwww;
        List<C2584s3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> list = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        AbstractC2257jf abstractC2257jf = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        c2584s3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, c2584s3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2584s3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2584s3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size(), list, abstractC2257jf));
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, int i, boolean z2, int i2) throws ExoPlaybackException {
        this.Www.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z2 ? 1 : 0);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Www;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        this.Wwww = this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z, i);
        this.Kkkkkkkkkkkkkkkkkkkkkkk = false;
        if (!Wwwwwwwwwwwwwwwwwwww()) {
            Wwwwwwwwwwwwwwwwww();
            Wwwwwwwwwwwwwwww();
            return;
        }
        int i3 = this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i3 == 3) {
            Wwwwwwwwwwwwwwwwwww();
        } else if (i3 != 2) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2658u3 c2658u3) {
        this.Wwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2658u3);
        this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.obtainMessage(16, 1, 0, this.Wwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()).sendToTarget();
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) throws ExoPlaybackException {
        this.Kkkkkkkkkkkkkkkkkkkkk = i;
        C2510q3 c2510q3 = this.Wwwwwww;
        AbstractC2209i4 abstractC2209i4 = this.Wwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        c2510q3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        if (!c2510q3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2209i4)) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2257jf abstractC2257jf) throws ExoPlaybackException {
        this.Www.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        C2584s3 c2584s3 = this.Wwwwww;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2584s3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (abstractC2257jf.getLength() != Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
            abstractC2257jf = abstractC2257jf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        }
        c2584s3.Wwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2257jf;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2584s3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, boolean z2) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z || !this.Kkkkkkkkkkkkkkkkkkk, false, true, false);
        this.Www.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z2 ? 1 : 0);
        ((C1932b3) this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2368mf c2368mf, C2150gj c2150gj) {
        AbstractC2319l3 abstractC2319l3 = this.Wwwwwwwwwwwwwwwwwwww;
        AbstractC1896a4[] abstractC1896a4Arr = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        C2039dj c2039dj = c2150gj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C1932b3 c1932b3 = (C1932b3) abstractC2319l3;
        int i = c1932b3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i == -1) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = 13107200;
                if (i2 < abstractC1896a4Arr.length) {
                    if (c2039dj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2] != null) {
                        switch (abstractC1896a4Arr[i2].getTrackType()) {
                            case 0:
                                i4 = 144310272;
                                break;
                            case 1:
                                break;
                            case 2:
                                i4 = 131072000;
                                break;
                            case 3:
                            case 4:
                            case 5:
                                i4 = 131072;
                                break;
                            case 6:
                                i4 = 0;
                                break;
                            default:
                                throw new IllegalArgumentException();
                        }
                        i3 += i4;
                    }
                    i2++;
                } else {
                    i = Math.max(13107200, i3);
                }
            }
        }
        c1932b3.Wwwwwwwwwwwwwwwwwwwwwwwww = i;
        c1932b3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
    }
}
