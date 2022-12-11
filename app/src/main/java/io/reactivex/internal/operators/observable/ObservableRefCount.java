package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.RunnableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import me.tvspark.gd0;
import me.tvspark.j60;
import me.tvspark.l70;
import me.tvspark.o60;
import me.tvspark.p60;
import me.tvspark.rb0;
import me.tvspark.sb0;
import me.tvspark.x80;

/* loaded from: classes4.dex */
public final class ObservableRefCount<T> extends x80<T, T> {
    public final gd0<? extends T> Wwwwwwwwwwwwwwwwwwwwwww;
    public volatile o60 Wwwwwwwwwwwwwwwwwwwwww = new o60();
    public final AtomicInteger Wwwwwwwwwwwwwwwwwwwww = new AtomicInteger();
    public final ReentrantLock Wwwwwwwwwwwwwwwwwwww = new ReentrantLock();

    /* loaded from: classes4.dex */
    public final class ConnectionObserver extends AtomicReference<p60> implements j60<T>, p60 {
        public static final long serialVersionUID = 3813126992133394324L;
        public final o60 currentBase;
        public final p60 resource;
        public final j60<? super T> subscriber;

        public ConnectionObserver(j60<? super T> j60Var, o60 o60Var, p60 p60Var) {
            this.subscriber = j60Var;
            this.currentBase = o60Var;
            this.resource = p60Var;
        }

        public void cleanup() {
            ObservableRefCount.this.Wwwwwwwwwwwwwwwwwwww.lock();
            try {
                if (ObservableRefCount.this.Wwwwwwwwwwwwwwwwwwwwww == this.currentBase) {
                    ObservableRefCount.this.Wwwwwwwwwwwwwwwwwwwwww.dispose();
                    ObservableRefCount.this.Wwwwwwwwwwwwwwwwwwwwww = new o60();
                    ObservableRefCount.this.Wwwwwwwwwwwwwwwwwwwww.set(0);
                }
            } finally {
                ObservableRefCount.this.Wwwwwwwwwwwwwwwwwwww.unlock();
            }
        }

        @Override // me.tvspark.p60
        public void dispose() {
            DisposableHelper.dispose(this);
            this.resource.dispose();
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            cleanup();
            this.subscriber.onComplete();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            cleanup();
            this.subscriber.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            this.subscriber.onNext(t);
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            DisposableHelper.setOnce(this, p60Var);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ObservableRefCount(gd0<T> gd0Var) {
        super(gd0Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = gd0Var;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60<? super T> j60Var, o60 o60Var) {
        sb0 sb0Var = new sb0(this, o60Var);
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb0Var, "run is null");
        ConnectionObserver connectionObserver = new ConnectionObserver(j60Var, o60Var, new RunnableDisposable(sb0Var));
        j60Var.onSubscribe(connectionObserver);
        this.Wwwwwwwwwwwwwwwwwwwwwww.subscribe(connectionObserver);
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        this.Wwwwwwwwwwwwwwwwwwww.lock();
        if (this.Wwwwwwwwwwwwwwwwwwwww.incrementAndGet() == 1) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            try {
                this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new rb0(this, j60Var, atomicBoolean));
            } finally {
                if (atomicBoolean.get()) {
                }
            }
        } else {
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60Var, this.Wwwwwwwwwwwwwwwwwwwwww);
            } finally {
                this.Wwwwwwwwwwwwwwwwwwww.unlock();
            }
        }
    }
}
