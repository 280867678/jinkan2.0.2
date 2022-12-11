package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.h60;
import me.tvspark.j60;
import me.tvspark.k60;
import me.tvspark.md0;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.x80;

/* loaded from: classes4.dex */
public final class ObservableDebounceTimed<T> extends x80<T, T> {
    public final k60 Wwwwwwwwwwwwwwwwwwwww;
    public final TimeUnit Wwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class DebounceEmitter<T> extends AtomicReference<p60> implements Runnable, p60 {
        public static final long serialVersionUID = 6812032969491025141L;
        public final long idx;
        public final AtomicBoolean once = new AtomicBoolean();
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> parent;
        public final T value;

        public DebounceEmitter(T t, long j, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.value = t;
            this.idx = j;
            this.parent = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.once.compareAndSet(false, true)) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.parent;
                long j = this.idx;
                T t = this.value;
                if (j != wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww) {
                    return;
                }
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.onNext(t);
                dispose();
            }
        }

        public void setResource(p60 p60Var) {
            DisposableHelper.replace(this, p60Var);
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> implements j60<T>, p60 {
        public boolean Wwwwwwwwwwwwwwwww;
        public volatile long Wwwwwwwwwwwwwwwwww;
        public final AtomicReference<p60> Wwwwwwwwwwwwwwwwwww = new AtomicReference<>();
        public p60 Wwwwwwwwwwwwwwwwwwww;
        public final k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwww;
        public final TimeUnit Wwwwwwwwwwwwwwwwwwwwww;
        public final long Wwwwwwwwwwwwwwwwwwwwwww;
        public final j60<? super T> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60<? super T> j60Var, long j, TimeUnit timeUnit, k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = j60Var;
            this.Wwwwwwwwwwwwwwwwwwwwwww = j;
            this.Wwwwwwwwwwwwwwwwwwwwww = timeUnit;
            this.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            DisposableHelper.dispose(this.Wwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwww.dispose();
            this.Wwwwwwwwwwwwwwwwwwww.dispose();
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.Wwwwwwwwwwwwwwwwwww.get() == DisposableHelper.DISPOSED;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            if (this.Wwwwwwwwwwwwwwwww) {
                return;
            }
            this.Wwwwwwwwwwwwwwwww = true;
            p60 p60Var = this.Wwwwwwwwwwwwwwwwwww.get();
            if (p60Var == DisposableHelper.DISPOSED) {
                return;
            }
            DebounceEmitter debounceEmitter = (DebounceEmitter) p60Var;
            if (debounceEmitter != null) {
                debounceEmitter.run();
            }
            DisposableHelper.dispose(this.Wwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwww.dispose();
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onComplete();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            if (this.Wwwwwwwwwwwwwwwww) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                return;
            }
            this.Wwwwwwwwwwwwwwwww = true;
            DisposableHelper.dispose(this.Wwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            if (this.Wwwwwwwwwwwwwwwww) {
                return;
            }
            long j = this.Wwwwwwwwwwwwwwwwww + 1;
            this.Wwwwwwwwwwwwwwwwww = j;
            p60 p60Var = this.Wwwwwwwwwwwwwwwwwww.get();
            if (p60Var != null) {
                p60Var.dispose();
            }
            DebounceEmitter debounceEmitter = new DebounceEmitter(t, j, this);
            if (!this.Wwwwwwwwwwwwwwwwwww.compareAndSet(p60Var, debounceEmitter)) {
                return;
            }
            debounceEmitter.setResource(this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(debounceEmitter, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww));
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.Wwwwwwwwwwwwwwwwwwww, p60Var)) {
                this.Wwwwwwwwwwwwwwwwwwww = p60Var;
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onSubscribe(this);
            }
        }
    }

    public ObservableDebounceTimed(h60<T> h60Var, long j, TimeUnit timeUnit, k60 k60Var) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = j;
        this.Wwwwwwwwwwwwwwwwwwwwww = timeUnit;
        this.Wwwwwwwwwwwwwwwwwwwww = k60Var;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new md0(j60Var), this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()));
    }
}
