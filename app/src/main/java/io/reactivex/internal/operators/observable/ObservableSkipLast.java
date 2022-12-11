package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;
import me.tvspark.h60;
import me.tvspark.j60;
import me.tvspark.p60;
import me.tvspark.x80;

/* loaded from: classes4.dex */
public final class ObservableSkipLast<T> extends x80<T, T> {
    public final int Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class SkipLastObserver<T> extends ArrayDeque<T> implements j60<T>, p60 {
        public static final long serialVersionUID = -3807491841935125653L;
        public final j60<? super T> actual;

        /* renamed from: s */
        public p60 f4446s;
        public final int skip;

        public SkipLastObserver(j60<? super T> j60Var, int i) {
            super(i);
            this.actual = j60Var;
            this.skip = i;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            this.f4446s.dispose();
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.f4446s.isDisposed();
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            if (this.skip == size()) {
                this.actual.onNext((T) poll());
            }
            offer(t);
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.f4446s, p60Var)) {
                this.f4446s = p60Var;
                this.actual.onSubscribe(this);
            }
        }
    }

    public ObservableSkipLast(h60<T> h60Var, int i) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = i;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new SkipLastObserver(j60Var, this.Wwwwwwwwwwwwwwwwwwwwwww));
    }
}
