package me.tvspark;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.IllegalSeekPositionException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import me.tvspark.AbstractC1911aj;
import me.tvspark.AbstractC2209i4;
import me.tvspark.AbstractC2257jf;
import me.tvspark.AbstractC2736w3;
import me.tvspark.AbstractC2809y2;
import me.tvspark.AbstractC2858ze;
import me.tvspark.C2097f3;
import me.tvspark.C2171h3;
import me.tvspark.C2773x3;

/* renamed from: me.tvspark.f3 */
/* loaded from: classes4.dex */
public final class C2097f3 extends AbstractC2809y2 implements AbstractC2060e3 {
    public long Wwwwwwwww;
    public int Wwwwwwwwww;
    public int Wwwwwwwwwww;
    public C2621t3 Wwwwwwwwwwww;
    public boolean Wwwwwwwwwwwww;
    public AbstractC2257jf Wwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwww;
    public final AbstractC2674uj Wwwwwwwwwwwwwwwwwwww;
    public final Looper Wwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final C2320l4 Wwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwww;
    public final List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwww;
    public final ArrayDeque<Runnable> Wwwwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public final CopyOnWriteArrayList<AbstractC2809y2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Handler Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2171h3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2171h3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Handler Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2113fj Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2150gj Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.f3$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
        public final boolean Wwww;
        public final boolean Wwwww;
        public final boolean Wwwwww;
        public final boolean Wwwwwww;
        public final boolean Wwwwwwww;
        public final boolean Wwwwwwwww;
        public final boolean Wwwwwwwwww;
        public final boolean Wwwwwwwwwww;
        public final boolean Wwwwwwwwwwww;
        public final boolean Wwwwwwwwwwwww;
        public final boolean Wwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwww;
        @Nullable
        public final C2356m3 Wwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwww;
        public final boolean Wwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwww;
        public final boolean Wwwwwwwwwwwwwwwwwwwww;
        public final AbstractC2113fj Wwwwwwwwwwwwwwwwwwwwww;
        public final CopyOnWriteArrayList<AbstractC2809y2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwww;
        public final C2621t3 Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2621t3 c2621t3, C2621t3 c2621t32, CopyOnWriteArrayList<AbstractC2809y2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> copyOnWriteArrayList, AbstractC2113fj abstractC2113fj, boolean z, int i, int i2, boolean z2, int i3, @Nullable C2356m3 c2356m3, int i4, boolean z3) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = c2621t3;
            this.Wwwwwwwwwwwwwwwwwwwwwww = new CopyOnWriteArrayList<>(copyOnWriteArrayList);
            this.Wwwwwwwwwwwwwwwwwwwwww = abstractC2113fj;
            this.Wwwwwwwwwwwwwwwwwwwww = z;
            this.Wwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwww = i2;
            this.Wwwwwwwwwwwwwwwwww = z2;
            this.Wwwwwwwwwwwwwwwww = i3;
            this.Wwwwwwwwwwwwwwww = c2356m3;
            this.Wwwwwwwwwwwwwww = i4;
            this.Wwwwwwwwwwwwww = z3;
            boolean z4 = false;
            this.Wwwwwwwwwwwww = c2621t32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            ExoPlaybackException exoPlaybackException = c2621t32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            ExoPlaybackException exoPlaybackException2 = c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwww = (exoPlaybackException == exoPlaybackException2 || exoPlaybackException2 == null) ? false : true;
            this.Wwwwwwwwwww = c2621t32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww != c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwww = !c2621t32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwww = c2621t32.Wwwwwwwwwwwwwwwwwwwwwwwwwww != c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwww = c2621t32.Wwwwwwwwwwwwwwwwwwwwwwwww != c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwww = c2621t32.Wwwwwwwwwwwwwwwwwwwwwwww != c2621t3.Wwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2621t32) != Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2621t3);
            this.Wwwww = !c2621t32.Wwwwwwwwwwwwwwwwwwwwwww.equals(c2621t3.Wwwwwwwwwwwwwwwwwwwwwww);
            this.Wwww = c2621t32.Wwwwwwwwwwwwwwwwwwwwww != c2621t3.Wwwwwwwwwwwwwwwwwwwwww ? true : z4;
        }

        public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2621t3 c2621t3) {
            return c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 3 && c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwww && c2621t3.Wwwwwwwwwwwwwwwwwwwwwwww == 0;
        }

        public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwww(AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww);
        }

        public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwww(AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwww);
        }

        public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwww(AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            C2621t3 c2621t3 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.onPlayerStateChanged(c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwww, c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            C2621t3 c2621t3 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.onTracksChanged(c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.onPlayerError(this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwww);
        }

        public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww);
        }

        public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.onPlaybackParametersChanged(this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww);
        }

        public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww));
        }

        public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.onPositionDiscontinuity(this.Wwwwwwwwwwwwwwwwwwww);
        }

        public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwww);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.Wwwwwwwwww) {
                C2097f3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, new AbstractC2809y2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() { // from class: me.tvspark.c2
                    @Override // me.tvspark.AbstractC2809y2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
                    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        C2097f3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    }
                });
            }
            if (this.Wwwwwwwwwwwwwwwwwwwww) {
                C2097f3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, new AbstractC2809y2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() { // from class: me.tvspark.b2
                    @Override // me.tvspark.AbstractC2809y2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
                    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        C2097f3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    }
                });
            }
            if (this.Wwwwwwwwwwwwwwwwww) {
                C2097f3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, new AbstractC2809y2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() { // from class: me.tvspark.h2
                    @Override // me.tvspark.AbstractC2809y2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
                    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        C2097f3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    }
                });
            }
            if (this.Wwwwwwwwwwww) {
                C2097f3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, new AbstractC2809y2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() { // from class: me.tvspark.g2
                    @Override // me.tvspark.AbstractC2809y2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
                    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        C2097f3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    }
                });
            }
            if (this.Wwwwwwwww) {
                AbstractC2113fj abstractC2113fj = this.Wwwwwwwwwwwwwwwwwwwwww;
                Object obj = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (((AbstractC1911aj) abstractC2113fj) != null) {
                    AbstractC1911aj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (AbstractC1911aj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj;
                    C2097f3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, new AbstractC2809y2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() { // from class: me.tvspark.l2
                        @Override // me.tvspark.AbstractC2809y2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
                        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
                            C2097f3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                        }
                    });
                } else {
                    throw null;
                }
            }
            if (this.Wwwwwwwwwww) {
                C2097f3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, new AbstractC2809y2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() { // from class: me.tvspark.a2
                    @Override // me.tvspark.AbstractC2809y2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
                    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
                        C2097f3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    }
                });
            }
            if (this.Wwwwwwwwwwwww || this.Wwwwwwww) {
                C2097f3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, new AbstractC2809y2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() { // from class: me.tvspark.d2
                    @Override // me.tvspark.AbstractC2809y2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
                    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
                        C2097f3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    }
                });
            }
            if (this.Wwwwwwwwwwwww) {
                C2097f3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, new AbstractC2809y2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() { // from class: me.tvspark.m2
                    @Override // me.tvspark.AbstractC2809y2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
                    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
                        C2097f3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    }
                });
            }
            if (this.Wwwwwwww) {
                C2097f3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, new AbstractC2809y2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() { // from class: me.tvspark.k2
                    @Override // me.tvspark.AbstractC2809y2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
                    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
                        C2097f3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    }
                });
            }
            if (this.Wwwwwww) {
                C2097f3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, new AbstractC2809y2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() { // from class: me.tvspark.i2
                    @Override // me.tvspark.AbstractC2809y2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
                    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
                        C2097f3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    }
                });
            }
            if (this.Wwwwww) {
                C2097f3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, new AbstractC2809y2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() { // from class: me.tvspark.f2
                    @Override // me.tvspark.AbstractC2809y2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
                    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
                        C2097f3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    }
                });
            }
            if (this.Wwwww) {
                C2097f3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, new AbstractC2809y2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() { // from class: me.tvspark.j2
                    @Override // me.tvspark.AbstractC2809y2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
                    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
                        C2097f3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    }
                });
            }
            if (this.Wwwwwwwwwwwwww) {
                Iterator<AbstractC2809y2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> it = this.Wwwwwwwwwwwwwwwwwwwwwww.iterator();
                while (it.hasNext()) {
                    it.next().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.onSeekProcessed();
                }
            }
            if (this.Wwww) {
                C2097f3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, new AbstractC2809y2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() { // from class: me.tvspark.e2
                    @Override // me.tvspark.AbstractC2809y2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
                    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
                        C2097f3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    }
                });
            }
        }
    }

    /* renamed from: me.tvspark.f3$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2547r3 {
        public AbstractC2209i4 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, AbstractC2209i4 abstractC2209i4) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = obj;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2209i4;
        }

        @Override // me.tvspark.AbstractC2547r3
        public AbstractC2209i4 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.AbstractC2547r3
        public Object getUid() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    @SuppressLint({"HandlerLeak"})
    public C2097f3(AbstractC1896a4[] abstractC1896a4Arr, AbstractC2113fj abstractC2113fj, AbstractC1981cf abstractC1981cf, AbstractC2319l3 abstractC2319l3, AbstractC2674uj abstractC2674uj, @Nullable C2320l4 c2320l4, boolean z, C2098f4 c2098f4, boolean z2, AbstractC2564rk abstractC2564rk, Looper looper) {
        String hexString = Integer.toHexString(System.identityHashCode(this));
        String str = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        String.valueOf(hexString).length();
        String.valueOf(str).length();
        boolean z3 = true;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1896a4Arr.length > 0);
        if (abstractC2113fj != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2113fj;
            this.Wwwwwwwwwwwwwwwwwwww = abstractC2674uj;
            this.Wwwwwwwwwwwwwwwwwwwwww = c2320l4;
            this.Wwwwwwwwwwwwwwwwwwwwwww = z;
            this.Wwwwwwwwwwwwwwwwwwwww = looper;
            this.Wwwwwwwwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = new CopyOnWriteArrayList<>();
            this.Wwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
            this.Wwwwwwwwwwwwww = new AbstractC2257jf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, new Random());
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2150gj(new C2007d4[abstractC1896a4Arr.length], new AbstractC1985cj[abstractC1896a4Arr.length], null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = new AbstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwww = -1;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Handler(looper);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2171h3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() { // from class: me.tvspark.n2
                @Override // me.tvspark.C2171h3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww
                public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2171h3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    C2097f3.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
            };
            this.Wwwwwwwwwwww = C2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwww = new ArrayDeque<>();
            if (c2320l4 != null) {
                if (c2320l4.Wwwwwwwwwwwwwwwwwww != null && !c2320l4.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
                    z3 = false;
                }
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z3);
                c2320l4.Wwwwwwwwwwwwwwwwwww = this;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2320l4);
                abstractC2674uj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Handler(looper), c2320l4);
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2171h3(abstractC1896a4Arr, abstractC2113fj, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, abstractC2319l3, abstractC2674uj, this.Wwwwwwwwwwwwwwwwwww, false, c2320l4, c2098f4, z2, looper, abstractC2564rk, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new Handler(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww);
            return;
        }
        throw null;
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return this.Wwwwwwwwwww;
        }
        C2621t3 c2621t3 = this.Wwwwwwwwwwww;
        return c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2736w3
    public AbstractC2209i4 Wwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2736w3
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return this.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return -1;
    }

    @Override // me.tvspark.AbstractC2736w3
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            C2621t3 c2621t3 = this.Wwwwwwwwwwww;
            return c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwww.equals(c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) ? C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww) : getDuration();
        } else if (this.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return this.Wwwwwwwww;
        } else {
            C2621t3 c2621t32 = this.Wwwwwwwwwwww;
            if (c2621t32.Wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != c2621t32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                return C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2621t32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwww);
            }
            long j = c2621t32.Wwwwwwwwwwwwwwwwwwwww;
            if (this.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                C2621t3 c2621t33 = this.Wwwwwwwwwwww;
                AbstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2621t33.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2621t33.Wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwww);
                long j2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[this.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww];
                j = j2 == Long.MIN_VALUE ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : j2;
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww, j);
        }
    }

    @Override // me.tvspark.AbstractC2736w3
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            C2621t3 c2621t3 = this.Wwwwwwwwwwww;
            c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwww);
            C2621t3 c2621t32 = this.Wwwwwwwwwwww;
            return c2621t32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -9223372036854775807L ? c2621t32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() : C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) + C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        return getCurrentPosition();
    }

    @Override // me.tvspark.AbstractC2736w3
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int Wwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwwwwww == -1) {
            return 0;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2736w3
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return this.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return -1;
    }

    @Override // me.tvspark.AbstractC2736w3
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return this.Wwwwwwwwww;
        }
        C2621t3 c2621t3 = this.Wwwwwwwwwwww;
        return c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.AbstractC2736w3
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww);
    }

    public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(final C2171h3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.post(new Runnable() { // from class: me.tvspark.o2
            @Override // java.lang.Runnable
            public final void run() {
                C2097f3.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        });
    }

    @Nullable
    public final Pair<Object, Long> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2209i4 abstractC2209i4, int i, long j) {
        if (abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            this.Wwwwwwwwwww = i;
            if (j == -9223372036854775807L) {
                j = 0;
            }
            this.Wwwwwwwww = j;
            this.Wwwwwwwwww = 0;
            return null;
        }
        if (i == -1 || i >= abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            i = abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
            j = abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        return abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwww, i, C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j));
    }

    public C2773x3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2773x3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        return new C2773x3(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Runnable runnable) {
        boolean z = !this.Wwwwwwwwwwwwwwwwwwwwwwwww.isEmpty();
        this.Wwwwwwwwwwwwwwwwwwwwwwwww.addLast(runnable);
        if (z) {
            return;
        }
        while (!this.Wwwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwww.peekFirst().run();
            this.Wwwwwwwwwwwwwwwwwwwwwwwww.removeFirst();
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.addIfAbsent(new AbstractC2809y2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
            return;
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2736w3
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2736w3
    public long getCurrentPosition() {
        if (this.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return this.Wwwwwwwww;
        }
        if (this.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww);
        }
        C2621t3 c2621t3 = this.Wwwwwwwwwwww;
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2621t3.Wwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.AbstractC2736w3
    public long getDuration() {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            C2621t3 c2621t3 = this.Wwwwwwwwwwww;
            AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwww);
            return C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        }
        AbstractC2209i4 Wwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwww();
        if (!Wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwww);
        }
        return -9223372036854775807L;
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CopyOnWriteArrayList<AbstractC2809y2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> copyOnWriteArrayList, AbstractC2809y2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        Iterator<AbstractC2809y2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(it.next().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2171h3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwww -= wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        boolean z = true;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        if (this.Wwwwwwwwwwwwwwwwww == 0) {
            AbstractC2209i4 abstractC2209i4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (!this.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                this.Wwwwwwwwwww = -1;
                this.Wwwwwwwww = 0L;
                this.Wwwwwwwwww = 0;
            }
            if (!abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                List asList = Arrays.asList(((C2810y3) abstractC2209i4).Wwwwwwwwwwwwwwwwwwwwwwwwww);
                if (asList.size() != this.Wwwwwwwwwwwwwwwwwwwwwwww.size()) {
                    z = false;
                }
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
                for (int i = 0; i < asList.size(); i++) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwww.get(i).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (AbstractC2209i4) asList.get(i);
                }
            }
            boolean z2 = this.Wwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwww = false;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, z2, this.Wwwwwwwwwwwwwwww, 1, this.Wwwwwwwwwwwwwww, false);
        }
    }

    public final C2621t3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2621t3 c2621t3, AbstractC2209i4 abstractC2209i4, @Nullable Pair<Object, Long> pair) {
        long j;
        C2621t3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        int i;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || pair != null);
        AbstractC2209i4 abstractC2209i42 = c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2621t3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2209i4);
        if (abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2621t3.Wwwwwwwwwwwwwwwwww;
            C2621t3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwww), C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwww), 0L, C2368mf.Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwww;
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
        }
        Object obj = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(pair);
        boolean z = !obj.equals(pair.first);
        AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = z ? new AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(pair.first) : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        long longValue = ((Long) pair.second).longValue();
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        if (!abstractC2209i42.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 -= abstractC2209i42.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, this.Wwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        if (z || longValue < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            j = longValue;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, longValue, longValue, 0L, z ? C2368mf.Wwwwwwwwwwwwwwwwwwwww : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, z ? this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        } else if (i == 0) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 != -1 && abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6, this.Wwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
            }
            abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwww);
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() ? this.Wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) : this.Wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            C2621t3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.Wwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7;
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8;
        } else {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            long max = Math.max(0L, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwww - (longValue - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5));
            j = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwww;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwww.equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                j = longValue + max;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, longValue, longValue, max, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwww = j;
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
    }

    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, long j) {
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
        this.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwww);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 + C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.AbstractC2736w3
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, long j) {
        AbstractC2209i4 abstractC2209i4 = this.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i < 0 || (!abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && i >= abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww())) {
            throw new IllegalSeekPositionException(abstractC2209i4, i, j);
        }
        int i2 = 1;
        this.Wwwwwwwwwwwwwwwwww++;
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new C2171h3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwww));
            return;
        }
        if (this.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 1) {
            i2 = 2;
        }
        C2621t3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2), abstractC2209i4, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2209i4, i, j));
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3, new C2171h3.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2209i4, i, C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j))).sendToTarget();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, true, 1, 0, 1, true);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2621t3 c2621t3, boolean z, int i, int i2, int i3, boolean z2) {
        Pair pair;
        C2621t3 c2621t32 = this.Wwwwwwwwwwww;
        this.Wwwwwwwwwwww = c2621t3;
        boolean z3 = !c2621t32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        AbstractC2209i4 abstractC2209i4 = c2621t32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        AbstractC2209i4 abstractC2209i42 = c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (!abstractC2209i42.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || !abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            int i4 = 3;
            if (abstractC2209i42.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                pair = new Pair(true, 3);
            } else {
                Object obj = abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2621t32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                Object obj2 = abstractC2209i42.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2209i42.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
                if (!obj.equals(obj2)) {
                    if (z && i == 0) {
                        i4 = 1;
                    } else if (z && i == 1) {
                        i4 = 2;
                    } else if (!z3) {
                        throw new IllegalStateException();
                    }
                    pair = new Pair(true, Integer.valueOf(i4));
                } else {
                    pair = (z && i == 0 && abstractC2209i42.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == i5) ? new Pair(true, 0) : new Pair(false, -1);
                }
            }
        } else {
            pair = new Pair(false, -1);
        }
        boolean booleanValue = ((Boolean) pair.first).booleanValue();
        int intValue = ((Integer) pair.second).intValue();
        C2356m3 c2356m3 = null;
        if (booleanValue && !c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            c2356m3 = c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2621t3, c2621t32, this.Wwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, z, i, i2, booleanValue, intValue, c2356m3, i3, z2));
    }
}
