package io.reactivex.internal.operators.observable;

import io.reactivex.internal.observers.BasicIntQueueDisposable;
import me.tvspark.d60;
import me.tvspark.j60;

/* loaded from: classes4.dex */
public final class ObservableRange extends d60<Integer> {
    public final long Wwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class RangeDisposable extends BasicIntQueueDisposable<Integer> {
        public static final long serialVersionUID = 396518478098735504L;
        public final j60<? super Integer> actual;
        public final long end;
        public boolean fused;
        public long index;

        public RangeDisposable(j60<? super Integer> j60Var, long j, long j2) {
            this.actual = j60Var;
            this.index = j;
            this.end = j2;
        }

        @Override // me.tvspark.t70
        public void clear() {
            this.index = this.end;
            lazySet(1);
        }

        @Override // me.tvspark.p60
        public void dispose() {
            set(1);
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return get() != 0;
        }

        @Override // me.tvspark.t70
        public boolean isEmpty() {
            return this.index == this.end;
        }

        @Override // me.tvspark.t70
        /* renamed from: poll */
        public Integer mo4868poll() throws Exception {
            long j = this.index;
            if (j != this.end) {
                this.index = 1 + j;
                return Integer.valueOf((int) j);
            }
            lazySet(1);
            return null;
        }

        @Override // me.tvspark.p70
        public int requestFusion(int i) {
            if ((i & 1) != 0) {
                this.fused = true;
                return 1;
            }
            return 0;
        }

        public void run() {
            if (this.fused) {
                return;
            }
            j60<? super Integer> j60Var = this.actual;
            long j = this.end;
            for (long j2 = this.index; j2 != j && get() == 0; j2++) {
                j60Var.onNext(Integer.valueOf((int) j2));
            }
            if (get() != 0) {
                return;
            }
            lazySet(1);
            j60Var.onComplete();
        }
    }

    public ObservableRange(int i, int i2) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwww = i + i2;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super Integer> j60Var) {
        RangeDisposable rangeDisposable = new RangeDisposable(j60Var, this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww);
        j60Var.onSubscribe(rangeDisposable);
        rangeDisposable.run();
    }
}
