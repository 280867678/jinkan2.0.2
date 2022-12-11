package me.tvspark;

import android.os.Handler;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import me.tvspark.AbstractC2396n6;
import me.tvspark.AbstractC2858ze;

/* renamed from: me.tvspark.n6 */
/* loaded from: classes4.dex */
public interface AbstractC2396n6 {

    /* renamed from: me.tvspark.n6$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final CopyOnWriteArrayList<C3482Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        @Nullable
        public final AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        /* renamed from: me.tvspark.n6$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C3482Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
            public AbstractC2396n6 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            public Handler Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

            public C3482Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Handler handler, AbstractC2396n6 abstractC2396n6) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = handler;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2396n6;
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new CopyOnWriteArrayList<>();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CopyOnWriteArrayList<C3482Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> copyOnWriteArrayList, int i, @Nullable AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = copyOnWriteArrayList;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            Iterator<C3482Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> it = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.iterator();
            while (it.hasNext()) {
                C3482Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww next = it.next();
                final AbstractC2396n6 abstractC2396n6 = next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new Runnable() { // from class: me.tvspark.e6
                    @Override // java.lang.Runnable
                    public final void run() {
                        AbstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2396n6);
                    }
                });
            }
        }

        public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2396n6 abstractC2396n6) {
            abstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            Iterator<C3482Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> it = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.iterator();
            while (it.hasNext()) {
                C3482Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww next = it.next();
                final AbstractC2396n6 abstractC2396n6 = next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new Runnable() { // from class: me.tvspark.f6
                    @Override // java.lang.Runnable
                    public final void run() {
                        AbstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2396n6);
                    }
                });
            }
        }

        public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2396n6 abstractC2396n6) {
            abstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            Iterator<C3482Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> it = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.iterator();
            while (it.hasNext()) {
                C3482Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww next = it.next();
                final AbstractC2396n6 abstractC2396n6 = next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new Runnable() { // from class: me.tvspark.d6
                    @Override // java.lang.Runnable
                    public final void run() {
                        AbstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2396n6);
                    }
                });
            }
        }

        public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2396n6 abstractC2396n6) {
            abstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            Iterator<C3482Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> it = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.iterator();
            while (it.hasNext()) {
                C3482Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww next = it.next();
                final AbstractC2396n6 abstractC2396n6 = next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new Runnable() { // from class: me.tvspark.g6
                    @Override // java.lang.Runnable
                    public final void run() {
                        AbstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2396n6);
                    }
                });
            }
        }

        public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2396n6 abstractC2396n6) {
            abstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        @CheckResult
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, @Nullable AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            Iterator<C3482Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> it = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.iterator();
            while (it.hasNext()) {
                C3482Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww next = it.next();
                final AbstractC2396n6 abstractC2396n6 = next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new Runnable() { // from class: me.tvspark.i6
                    @Override // java.lang.Runnable
                    public final void run() {
                        AbstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2396n6);
                    }
                });
            }
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(final Exception exc) {
            Iterator<C3482Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> it = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.iterator();
            while (it.hasNext()) {
                C3482Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww next = it.next();
                final AbstractC2396n6 abstractC2396n6 = next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new Runnable() { // from class: me.tvspark.h6
                    @Override // java.lang.Runnable
                    public final void run() {
                        AbstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2396n6, exc);
                    }
                });
            }
        }

        public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2396n6 abstractC2396n6) {
            abstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2396n6 abstractC2396n6, Exception exc) {
            abstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, exc);
        }
    }

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, @Nullable AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, @Nullable AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, @Nullable AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, @Nullable AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, @Nullable AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, @Nullable AbstractC2858ze.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Exception exc);
}
