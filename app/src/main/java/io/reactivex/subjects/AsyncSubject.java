package io.reactivex.subjects;

import io.reactivex.internal.observers.DeferredScalarDisposable;
import me.tvspark.j60;
import me.tvspark.r40;
import me.tvspark.sd0;

/* loaded from: classes4.dex */
public final class AsyncSubject<T> extends sd0<T> {

    /* loaded from: classes4.dex */
    public static final class AsyncDisposable<T> extends DeferredScalarDisposable<T> {
        public static final long serialVersionUID = 5629876084736248016L;
        public final AsyncSubject<T> parent;

        public AsyncDisposable(j60<? super T> j60Var, AsyncSubject<T> asyncSubject) {
            super(j60Var);
            this.parent = asyncSubject;
        }

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, me.tvspark.p60
        public void dispose() {
            if (super.tryDispose()) {
                throw null;
            }
        }

        public void onComplete() {
            if (!isDisposed()) {
                this.actual.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (isDisposed()) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            } else {
                this.actual.onError(th);
            }
        }
    }
}
