package me.tvspark;

import android.os.Handler;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import me.tvspark.AbstractC1944bf;
import me.tvspark.AbstractC2858ze;

/* renamed from: me.tvspark.bf */
/* loaded from: classes4.dex */
public interface AbstractC1944bf {

    /* renamed from: me.tvspark.bf$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final CopyOnWriteArrayList<C3470Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        @Nullable
        public final AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        /* renamed from: me.tvspark.bf$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C3470Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
            public AbstractC1944bf Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            public Handler Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

            public C3470Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Handler handler, AbstractC1944bf abstractC1944bf) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = handler;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC1944bf;
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new CopyOnWriteArrayList<>();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0L;
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CopyOnWriteArrayList<C3470Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> copyOnWriteArrayList, int i, @Nullable AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, long j) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = copyOnWriteArrayList;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
        }

        public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC1944bf abstractC1944bf, C2632te c2632te, C2747we c2747we) {
            abstractC1944bf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2632te, c2747we);
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2632te c2632te, int i) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2632te, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2632te c2632te, int i, int i2, @Nullable C2245j3 c2245j3, int i3, @Nullable Object obj, long j, long j2) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2632te, new C2747we(i, i2, c2245j3, i3, obj, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2)));
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(final C2632te c2632te, final C2747we c2747we) {
            Iterator<C3470Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> it = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.iterator();
            while (it.hasNext()) {
                C3470Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww next = it.next();
                final AbstractC1944bf abstractC1944bf = next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new Runnable() { // from class: me.tvspark.ee
                    @Override // java.lang.Runnable
                    public final void run() {
                        AbstractC1944bf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1944bf, c2632te, c2747we);
                    }
                });
            }
        }

        public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC1944bf abstractC1944bf, C2632te c2632te, C2747we c2747we) {
            abstractC1944bf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2632te, c2747we);
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2632te c2632te, int i) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2632te, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2632te c2632te, int i, int i2, @Nullable C2245j3 c2245j3, int i3, @Nullable Object obj, long j, long j2) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2632te, new C2747we(i, i2, c2245j3, i3, obj, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2)));
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(final C2632te c2632te, final C2747we c2747we) {
            Iterator<C3470Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> it = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.iterator();
            while (it.hasNext()) {
                C3470Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww next = it.next();
                final AbstractC1944bf abstractC1944bf = next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new Runnable() { // from class: me.tvspark.de
                    @Override // java.lang.Runnable
                    public final void run() {
                        AbstractC1944bf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1944bf, c2632te, c2747we);
                    }
                });
            }
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(final C2747we c2747we) {
            AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            final AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Iterator<C3470Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> it = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.iterator();
            while (it.hasNext()) {
                C3470Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww next = it.next();
                final AbstractC1944bf abstractC1944bf = next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new Runnable() { // from class: me.tvspark.ge
                    @Override // java.lang.Runnable
                    public final void run() {
                        AbstractC1944bf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1944bf, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, c2747we);
                    }
                });
            }
        }

        public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @CheckResult
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, @Nullable AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, long j) {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, j);
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, @Nullable C2245j3 c2245j3, int i2, @Nullable Object obj, long j) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new C2747we(1, i, c2245j3, i2, obj, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j), -9223372036854775807L));
        }

        public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC1944bf abstractC1944bf, C2632te c2632te, C2747we c2747we) {
            abstractC1944bf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2632te, c2747we);
        }

        public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC1944bf abstractC1944bf, C2632te c2632te, C2747we c2747we, IOException iOException, boolean z) {
            abstractC1944bf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2632te, c2747we, iOException, z);
        }

        public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC1944bf abstractC1944bf, C2747we c2747we) {
            abstractC1944bf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2747we);
        }

        public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC1944bf abstractC1944bf, AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, C2747we c2747we) {
            abstractC1944bf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2747we);
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2632te c2632te, int i) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2632te, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2632te c2632te, int i, int i2, @Nullable C2245j3 c2245j3, int i3, @Nullable Object obj, long j, long j2) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2632te, new C2747we(i, i2, c2245j3, i3, obj, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2)));
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2632te c2632te, int i, int i2, @Nullable C2245j3 c2245j3, int i3, @Nullable Object obj, long j, long j2, IOException iOException, boolean z) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2632te, new C2747we(i, i2, c2245j3, i3, obj, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2)), iOException, z);
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2632te c2632te, int i, IOException iOException, boolean z) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2632te, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, iOException, z);
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(final C2632te c2632te, final C2747we c2747we) {
            Iterator<C3470Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> it = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.iterator();
            while (it.hasNext()) {
                C3470Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww next = it.next();
                final AbstractC1944bf abstractC1944bf = next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new Runnable() { // from class: me.tvspark.be
                    @Override // java.lang.Runnable
                    public final void run() {
                        AbstractC1944bf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1944bf, c2632te, c2747we);
                    }
                });
            }
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(final C2632te c2632te, final C2747we c2747we, final IOException iOException, final boolean z) {
            Iterator<C3470Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> it = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.iterator();
            while (it.hasNext()) {
                C3470Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww next = it.next();
                final AbstractC1944bf abstractC1944bf = next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new Runnable() { // from class: me.tvspark.ce
                    @Override // java.lang.Runnable
                    public final void run() {
                        AbstractC1944bf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1944bf, c2632te, c2747we, iOException, z);
                    }
                });
            }
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(final C2747we c2747we) {
            Iterator<C3470Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> it = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.iterator();
            while (it.hasNext()) {
                C3470Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww next = it.next();
                final AbstractC1944bf abstractC1944bf = next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new Runnable() { // from class: me.tvspark.fe
                    @Override // java.lang.Runnable
                    public final void run() {
                        AbstractC1944bf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1944bf, c2747we);
                    }
                });
            }
        }
    }

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, @Nullable AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, C2632te c2632te, C2747we c2747we);

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, @Nullable AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, C2632te c2632te, C2747we c2747we);

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, C2747we c2747we);

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, @Nullable AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, C2632te c2632te, C2747we c2747we);

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, @Nullable AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, C2632te c2632te, C2747we c2747we, IOException iOException, boolean z);

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, @Nullable AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, C2747we c2747we);
}
