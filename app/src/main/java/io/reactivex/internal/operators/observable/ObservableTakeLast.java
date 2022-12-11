package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;
import me.tvspark.h60;
import me.tvspark.j60;
import me.tvspark.p60;
import me.tvspark.x80;

/* loaded from: classes4.dex */
public final class ObservableTakeLast<T> extends x80<T, T> {
    public final int Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class TakeLastObserver<T> extends ArrayDeque<T> implements j60<T>, p60 {
        public static final long serialVersionUID = 7240042530241604978L;
        public final j60<? super T> actual;
        public volatile boolean cancelled;
        public final int count;

        /* renamed from: s */
        public p60 f4450s;

        public TakeLastObserver(j60<? super T> j60Var, int i) {
            this.actual = j60Var;
            this.count = i;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.f4450s.dispose();
            }
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            j60<? super T> j60Var = this.actual;
            while (!this.cancelled) {
                Object obj = (T) poll();
                if (obj == null) {
                    if (this.cancelled) {
                        return;
                    }
                    j60Var.onComplete();
                    return;
                }
                j60Var.onNext(obj);
            }
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            if (this.count == size()) {
                poll();
            }
            offer(t);
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.f4450s, p60Var)) {
                this.f4450s = p60Var;
                this.actual.onSubscribe(this);
            }
        }
    }

    public ObservableTakeLast(h60<T> h60Var, int i) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = i;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new TakeLastObserver(j60Var, this.Wwwwwwwwwwwwwwwwwwwwwww));
    }
}
