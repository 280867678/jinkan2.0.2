package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.h60;
import me.tvspark.j60;
import me.tvspark.md0;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.t60;
import me.tvspark.x80;

/* loaded from: classes4.dex */
public final class ObservableWithLatestFrom<T, U, R> extends x80<T, R> {
    public final h60<? extends U> Wwwwwwwwwwwwwwwwwwwwww;
    public final t60<? super T, ? super U, ? extends R> Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class WithLatestFromObserver<T, U, R> extends AtomicReference<U> implements j60<T>, p60 {
        public static final long serialVersionUID = -312246233408980075L;
        public final j60<? super R> actual;
        public final t60<? super T, ? super U, ? extends R> combiner;

        /* renamed from: s */
        public final AtomicReference<p60> f4462s = new AtomicReference<>();
        public final AtomicReference<p60> other = new AtomicReference<>();

        public WithLatestFromObserver(j60<? super R> j60Var, t60<? super T, ? super U, ? extends R> t60Var) {
            this.actual = j60Var;
            this.combiner = t60Var;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            DisposableHelper.dispose(this.f4462s);
            DisposableHelper.dispose(this.other);
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.f4462s.get());
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            DisposableHelper.dispose(this.other);
            this.actual.onComplete();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.other);
            this.actual.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            U u = get();
            if (u != null) {
                try {
                    this.actual.onNext(this.combiner.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t, u));
                } catch (Throwable th) {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                    dispose();
                    this.actual.onError(th);
                }
            }
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            DisposableHelper.setOnce(this.f4462s, p60Var);
        }

        public void otherError(Throwable th) {
            DisposableHelper.dispose(this.f4462s);
            this.actual.onError(th);
        }

        public boolean setOther(p60 p60Var) {
            return DisposableHelper.setOnce(this.other, p60Var);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements j60<U> {
        public final /* synthetic */ WithLatestFromObserver Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ObservableWithLatestFrom observableWithLatestFrom, WithLatestFromObserver withLatestFromObserver) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = withLatestFromObserver;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.otherError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(U u) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.lazySet(u);
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.setOther(p60Var);
        }
    }

    public ObservableWithLatestFrom(h60<T> h60Var, t60<? super T, ? super U, ? extends R> t60Var, h60<? extends U> h60Var2) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = t60Var;
        this.Wwwwwwwwwwwwwwwwwwwwww = h60Var2;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super R> j60Var) {
        WithLatestFromObserver withLatestFromObserver = new WithLatestFromObserver(new md0(j60Var), this.Wwwwwwwwwwwwwwwwwwwwwww);
        j60Var.onSubscribe(withLatestFromObserver);
        this.Wwwwwwwwwwwwwwwwwwwwww.subscribe(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, withLatestFromObserver));
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(withLatestFromObserver);
    }
}
