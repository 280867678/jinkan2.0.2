package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.c60;
import me.tvspark.d60;
import me.tvspark.f70;
import me.tvspark.h60;
import me.tvspark.h80;
import me.tvspark.j60;
import me.tvspark.l70;
import me.tvspark.p60;
import me.tvspark.qd0;
import me.tvspark.r40;
import me.tvspark.rd0;
import me.tvspark.sd0;
import me.tvspark.x60;
import me.tvspark.x80;

/* loaded from: classes4.dex */
public final class ObservableRedo<T> extends x80<T, T> {
    public final f70<? super d60<c60<Object>>, ? extends h60<?>> Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class RedoObserver<T> extends AtomicBoolean implements j60<T> {
        public static final long serialVersionUID = -1151903143112844287L;
        public final j60<? super T> actual;
        public final h60<? extends T> source;
        public final sd0<c60<Object>> subject;
        public final AtomicInteger wip = new AtomicInteger();
        public final SequentialDisposable arbiter = new SequentialDisposable();

        public RedoObserver(j60<? super T> j60Var, sd0<c60<Object>> sd0Var, h60<? extends T> h60Var) {
            this.actual = j60Var;
            this.subject = sd0Var;
            this.source = h60Var;
            lazySet(true);
        }

        public void handle(c60<Object> c60Var) {
            int i = 1;
            if (compareAndSet(true, false)) {
                if (c60Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    this.arbiter.dispose();
                    this.actual.onError(c60Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                } else if (!c60Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    this.arbiter.dispose();
                    this.actual.onComplete();
                } else if (this.wip.getAndIncrement() != 0) {
                } else {
                    while (!this.arbiter.isDisposed()) {
                        this.source.subscribe(this);
                        i = this.wip.addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    }
                }
            }
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.subject.onNext(c60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            if (compareAndSet(false, true)) {
                this.subject.onNext(c60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th));
            }
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            this.arbiter.replace(p60Var);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements x60<c60<Object>> {
        public final /* synthetic */ RedoObserver Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ObservableRedo observableRedo, RedoObserver redoObserver) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = redoObserver;
        }

        @Override // me.tvspark.x60
        public void accept(c60<Object> c60Var) throws Exception {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.handle(c60Var);
        }
    }

    public ObservableRedo(h60<T> h60Var, f70<? super d60<c60<Object>>, ? extends h60<?>> f70Var) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = f70Var;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        sd0 qd0Var = new qd0();
        if (!(qd0Var instanceof rd0)) {
            qd0Var = new rd0(qd0Var);
        }
        RedoObserver redoObserver = new RedoObserver(j60Var, qd0Var, this.Wwwwwwwwwwwwwwwwwwwwwwww);
        j60Var.onSubscribe(redoObserver.arbiter);
        try {
            h60<?> apply = this.Wwwwwwwwwwwwwwwwwwwwwww.apply(qd0Var);
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, "The function returned a null ObservableSource");
            apply.subscribe(new h80(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, redoObserver)));
            redoObserver.handle(c60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0));
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            j60Var.onError(th);
        }
    }
}
