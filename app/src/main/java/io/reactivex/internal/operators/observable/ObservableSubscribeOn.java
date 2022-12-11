package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.h60;
import me.tvspark.j60;
import me.tvspark.k60;
import me.tvspark.p60;
import me.tvspark.x80;

/* loaded from: classes4.dex */
public final class ObservableSubscribeOn<T> extends x80<T, T> {
    public final k60 Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class SubscribeOnObserver<T> extends AtomicReference<p60> implements j60<T>, p60 {
        public static final long serialVersionUID = 8094547886072529208L;
        public final j60<? super T> actual;

        /* renamed from: s */
        public final AtomicReference<p60> f4448s = new AtomicReference<>();

        public SubscribeOnObserver(j60<? super T> j60Var) {
            this.actual = j60Var;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            DisposableHelper.dispose(this.f4448s);
            DisposableHelper.dispose(this);
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
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
            this.actual.onNext(t);
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            DisposableHelper.setOnce(this.f4448s, p60Var);
        }

        public void setDisposable(p60 p60Var) {
            DisposableHelper.setOnce(this, p60Var);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
        public final /* synthetic */ SubscribeOnObserver Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SubscribeOnObserver subscribeOnObserver) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = subscribeOnObserver;
        }

        @Override // java.lang.Runnable
        public void run() {
            ObservableSubscribeOn.this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    public ObservableSubscribeOn(h60<T> h60Var, k60 k60Var) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = k60Var;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(j60Var);
        j60Var.onSubscribe(subscribeOnObserver);
        subscribeOnObserver.setDisposable(this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(subscribeOnObserver)));
    }
}
