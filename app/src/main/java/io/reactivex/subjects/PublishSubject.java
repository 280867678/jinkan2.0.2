package io.reactivex.subjects;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.j60;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.sd0;

/* loaded from: classes4.dex */
public final class PublishSubject<T> extends sd0<T> {
    public Throwable Wwwwwwwwwwwwwwwwwwwwwww;
    public final AtomicReference<PublishDisposable<T>[]> Wwwwwwwwwwwwwwwwwwwwwwww = new AtomicReference<>(Wwwwwwwwwwwwwwwwwwwww);
    public static final PublishDisposable[] Wwwwwwwwwwwwwwwwwwwwww = new PublishDisposable[0];
    public static final PublishDisposable[] Wwwwwwwwwwwwwwwwwwwww = new PublishDisposable[0];

    /* loaded from: classes4.dex */
    public static final class PublishDisposable<T> extends AtomicBoolean implements p60 {
        public static final long serialVersionUID = 3562861878281475070L;
        public final j60<? super T> actual;
        public final PublishSubject<T> parent;

        public PublishDisposable(j60<? super T> j60Var, PublishSubject<T> publishSubject) {
            this.actual = j60Var;
            this.parent = publishSubject;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
            }
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return get();
        }

        public void onComplete() {
            if (!get()) {
                this.actual.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (get()) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            } else {
                this.actual.onError(th);
            }
        }

        public void onNext(T t) {
            if (!get()) {
                this.actual.onNext(t);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(PublishDisposable<T> publishDisposable) {
        PublishDisposable<T>[] publishDisposableArr;
        PublishDisposable[] publishDisposableArr2;
        do {
            publishDisposableArr = this.Wwwwwwwwwwwwwwwwwwwwwwww.get();
            if (publishDisposableArr == Wwwwwwwwwwwwwwwwwwwwww || publishDisposableArr == Wwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            int length = publishDisposableArr.length;
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (publishDisposableArr[i2] == publishDisposable) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                publishDisposableArr2 = Wwwwwwwwwwwwwwwwwwwww;
            } else {
                PublishDisposable[] publishDisposableArr3 = new PublishDisposable[length - 1];
                System.arraycopy(publishDisposableArr, 0, publishDisposableArr3, 0, i);
                System.arraycopy(publishDisposableArr, i + 1, publishDisposableArr3, i, (length - i) - 1);
                publishDisposableArr2 = publishDisposableArr3;
            }
        } while (!this.Wwwwwwwwwwwwwwwwwwwwwwww.compareAndSet(publishDisposableArr, publishDisposableArr2));
    }

    @Override // me.tvspark.j60
    public void onComplete() {
        PublishDisposable<T>[] publishDisposableArr = this.Wwwwwwwwwwwwwwwwwwwwwwww.get();
        PublishDisposable<T>[] publishDisposableArr2 = Wwwwwwwwwwwwwwwwwwwwww;
        if (publishDisposableArr == publishDisposableArr2) {
            return;
        }
        for (PublishDisposable<T> publishDisposable : this.Wwwwwwwwwwwwwwwwwwwwwwww.getAndSet(publishDisposableArr2)) {
            publishDisposable.onComplete();
        }
    }

    @Override // me.tvspark.j60
    public void onError(Throwable th) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww.get() == Wwwwwwwwwwwwwwwwwwwwww) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        this.Wwwwwwwwwwwwwwwwwwwwwww = th;
        for (PublishDisposable<T> publishDisposable : this.Wwwwwwwwwwwwwwwwwwwwwwww.getAndSet(Wwwwwwwwwwwwwwwwwwwwww)) {
            publishDisposable.onError(th);
        }
    }

    @Override // me.tvspark.j60
    public void onNext(T t) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww.get() == Wwwwwwwwwwwwwwwwwwwwww) {
            return;
        }
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        for (PublishDisposable<T> publishDisposable : this.Wwwwwwwwwwwwwwwwwwwwwwww.get()) {
            publishDisposable.onNext(t);
        }
    }

    @Override // me.tvspark.j60
    public void onSubscribe(p60 p60Var) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww.get() == Wwwwwwwwwwwwwwwwwwwwww) {
            p60Var.dispose();
        }
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        boolean z;
        PublishDisposable<T> publishDisposable = new PublishDisposable<>(j60Var, this);
        j60Var.onSubscribe(publishDisposable);
        while (true) {
            PublishDisposable<T>[] publishDisposableArr = this.Wwwwwwwwwwwwwwwwwwwwwwww.get();
            z = false;
            if (publishDisposableArr != Wwwwwwwwwwwwwwwwwwwwww) {
                int length = publishDisposableArr.length;
                PublishDisposable<T>[] publishDisposableArr2 = new PublishDisposable[length + 1];
                System.arraycopy(publishDisposableArr, 0, publishDisposableArr2, 0, length);
                publishDisposableArr2[length] = publishDisposable;
                if (this.Wwwwwwwwwwwwwwwwwwwwwwww.compareAndSet(publishDisposableArr, publishDisposableArr2)) {
                    z = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (z) {
            if (!publishDisposable.isDisposed()) {
                return;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(publishDisposable);
            return;
        }
        Throwable th = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (th != null) {
            j60Var.onError(th);
        } else {
            j60Var.onComplete();
        }
    }
}
