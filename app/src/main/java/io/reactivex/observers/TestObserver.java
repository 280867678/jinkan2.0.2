package io.reactivex.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.a60;
import me.tvspark.id0;
import me.tvspark.j60;
import me.tvspark.m60;
import me.tvspark.o70;
import me.tvspark.p60;
import me.tvspark.u50;

/* loaded from: classes4.dex */
public class TestObserver<T> extends id0<T, TestObserver<T>> implements j60<T>, p60, a60<T>, m60<T>, u50 {
    public o70<T> Wwwwwwwwwwwwwwww;
    public final AtomicReference<p60> Wwwwwwwwwwwwwwwww = new AtomicReference<>();
    public final j60<? super T> Wwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public enum EmptyObserver implements j60<Object> {
        INSTANCE;

        @Override // me.tvspark.j60
        public void onComplete() {
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
        }

        @Override // me.tvspark.j60
        public void onNext(Object obj) {
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
        }
    }

    public TestObserver() {
        EmptyObserver emptyObserver = EmptyObserver.INSTANCE;
        this.Wwwwwwwwwwwwwwwwww = emptyObserver;
    }

    @Override // me.tvspark.p60
    public final void dispose() {
        DisposableHelper.dispose(this.Wwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.p60
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed(this.Wwwwwwwwwwwwwwwww.get());
    }

    @Override // me.tvspark.j60
    public void onComplete() {
        if (!this.Wwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwww = true;
            if (this.Wwwwwwwwwwwwwwwww.get() == null) {
                this.Wwwwwwwwwwwwwwwwwwwwww.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            Thread.currentThread();
            this.Wwwwwwwwwwwwwwwwwwwww++;
            this.Wwwwwwwwwwwwwwwwww.onComplete();
            this.Wwwwwwwwwwwwwwwww.lazySet(DisposableHelper.DISPOSED);
        } finally {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.countDown();
        }
    }

    @Override // me.tvspark.j60
    public void onError(Throwable th) {
        if (!this.Wwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwww = true;
            if (this.Wwwwwwwwwwwwwwwww.get() == null) {
                this.Wwwwwwwwwwwwwwwwwwwwww.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            Thread.currentThread();
            if (th == null) {
                this.Wwwwwwwwwwwwwwwwwwwwww.add(new NullPointerException("onError received a null Throwable"));
            } else {
                this.Wwwwwwwwwwwwwwwwwwwwww.add(th);
            }
            this.Wwwwwwwwwwwwwwwwww.onError(th);
            this.Wwwwwwwwwwwwwwwww.lazySet(DisposableHelper.DISPOSED);
        } finally {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.countDown();
        }
    }

    @Override // me.tvspark.j60
    public void onNext(T t) {
        if (!this.Wwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwww = true;
            if (this.Wwwwwwwwwwwwwwwww.get() == null) {
                this.Wwwwwwwwwwwwwwwwwwwwww.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        Thread.currentThread();
        if (this.Wwwwwwwwwwwwwwwwwww != 2) {
            this.Wwwwwwwwwwwwwwwwwwwwwww.add(t);
            if (t == null) {
                this.Wwwwwwwwwwwwwwwwwwwwww.add(new NullPointerException("onNext received a null Subscription"));
            }
            this.Wwwwwwwwwwwwwwwwww.onNext(t);
            return;
        }
        while (true) {
            try {
                T mo4868poll = this.Wwwwwwwwwwwwwwww.mo4868poll();
                if (mo4868poll == null) {
                    return;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwww.add(mo4868poll);
            } catch (Throwable th) {
                this.Wwwwwwwwwwwwwwwwwwwwww.add(th);
                return;
            }
        }
    }

    @Override // me.tvspark.j60
    public void onSubscribe(p60 p60Var) {
        Thread.currentThread();
        if (p60Var == null) {
            this.Wwwwwwwwwwwwwwwwwwwwww.add(new NullPointerException("onSubscribe received a null Subscription"));
        } else if (this.Wwwwwwwwwwwwwwwww.compareAndSet(null, p60Var)) {
            this.Wwwwwwwwwwwwwwwwww.onSubscribe(p60Var);
        } else {
            p60Var.dispose();
            if (this.Wwwwwwwwwwwwwwwww.get() == DisposableHelper.DISPOSED) {
                return;
            }
            List<Throwable> list = this.Wwwwwwwwwwwwwwwwwwwwww;
            list.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + p60Var));
        }
    }

    @Override // me.tvspark.a60
    public void onSuccess(T t) {
        onNext(t);
        onComplete();
    }
}
