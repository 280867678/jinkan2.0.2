package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import me.tvspark.h60;
import me.tvspark.j60;
import me.tvspark.md0;
import me.tvspark.p60;
import me.tvspark.x80;

/* loaded from: classes4.dex */
public final class ObservableTakeUntil<T, U> extends x80<T, T> {
    public final h60<? extends U> Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class TakeUntilObserver<T> extends AtomicBoolean implements j60<T> {
        public static final long serialVersionUID = 3451719290311127173L;
        public final j60<? super T> actual;
        public final ArrayCompositeDisposable frc;

        /* renamed from: s */
        public p60 f4452s;

        public TakeUntilObserver(j60<? super T> j60Var, ArrayCompositeDisposable arrayCompositeDisposable) {
            this.actual = j60Var;
            this.frc = arrayCompositeDisposable;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            this.frc.dispose();
            this.actual.onComplete();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            this.frc.dispose();
            this.actual.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.f4452s, p60Var)) {
                this.f4452s = p60Var;
                this.frc.setResource(0, p60Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements j60<U> {
        public final /* synthetic */ md0 Wwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ ArrayCompositeDisposable Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ObservableTakeUntil observableTakeUntil, ArrayCompositeDisposable arrayCompositeDisposable, md0 md0Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = arrayCompositeDisposable;
            this.Wwwwwwwwwwwwwwwwwwwwwww = md0Var;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.dispose();
            this.Wwwwwwwwwwwwwwwwwwwwwww.onComplete();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.dispose();
            this.Wwwwwwwwwwwwwwwwwwwwwww.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(U u) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.dispose();
            this.Wwwwwwwwwwwwwwwwwwwwwww.onComplete();
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.setResource(1, p60Var);
        }
    }

    public ObservableTakeUntil(h60<T> h60Var, h60<? extends U> h60Var2) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = h60Var2;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        md0 md0Var = new md0(j60Var);
        ArrayCompositeDisposable arrayCompositeDisposable = new ArrayCompositeDisposable(2);
        TakeUntilObserver takeUntilObserver = new TakeUntilObserver(md0Var, arrayCompositeDisposable);
        j60Var.onSubscribe(arrayCompositeDisposable);
        this.Wwwwwwwwwwwwwwwwwwwwwww.subscribe(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, arrayCompositeDisposable, md0Var));
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(takeUntilObserver);
    }
}
