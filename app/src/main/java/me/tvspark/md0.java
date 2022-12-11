package me.tvspark;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;

/* loaded from: classes4.dex */
public final class md0<T> implements j60<T>, p60 {
    public volatile boolean Wwwwwwwwwwwwwwwwwww;
    public cd0<Object> Wwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwww;
    public p60 Wwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwww = false;
    public final j60<? super T> Wwwwwwwwwwwwwwwwwwwwwwww;

    public md0(j60<? super T> j60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = j60Var;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        cd0<Object> cd0Var;
        while (true) {
            synchronized (this) {
                cd0Var = this.Wwwwwwwwwwwwwwwwwwww;
                if (cd0Var == null) {
                    this.Wwwwwwwwwwwwwwwwwwwww = false;
                    return;
                }
                this.Wwwwwwwwwwwwwwwwwwww = null;
            }
            j60<? super T> j60Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            int i = cd0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            for (Object[] objArr = cd0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww; objArr != null; objArr = objArr[i]) {
                for (int i2 = 0; i2 < i; i2++) {
                    Object[] objArr2 = objArr[i2];
                    if (objArr2 == null || NotificationLite.acceptFull(objArr2, j60Var)) {
                        break;
                    }
                }
            }
        }
    }

    @Override // me.tvspark.p60
    public void dispose() {
        this.Wwwwwwwwwwwwwwwwwwwwww.dispose();
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return this.Wwwwwwwwwwwwwwwwwwwwww.isDisposed();
    }

    @Override // me.tvspark.j60
    public void onComplete() {
        if (this.Wwwwwwwwwwwwwwwwwww) {
            return;
        }
        synchronized (this) {
            if (this.Wwwwwwwwwwwwwwwwwww) {
                return;
            }
            if (!this.Wwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwww = true;
                this.Wwwwwwwwwwwwwwwwwwwww = true;
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onComplete();
                return;
            }
            cd0<Object> cd0Var = this.Wwwwwwwwwwwwwwwwwwww;
            if (cd0Var == null) {
                cd0Var = new cd0<>(4);
                this.Wwwwwwwwwwwwwwwwwwww = cd0Var;
            }
            cd0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((cd0<Object>) NotificationLite.complete());
        }
    }

    @Override // me.tvspark.j60
    public void onError(Throwable th) {
        if (this.Wwwwwwwwwwwwwwwwwww) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        synchronized (this) {
            boolean z = false;
            if (this.Wwwwwwwwwwwwwwwwwww) {
                z = true;
            } else if (this.Wwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwww = true;
                cd0<Object> cd0Var = this.Wwwwwwwwwwwwwwwwwwww;
                if (cd0Var == null) {
                    cd0Var = new cd0<>(4);
                    this.Wwwwwwwwwwwwwwwwwwww = cd0Var;
                }
                Object error = NotificationLite.error(th);
                if (this.Wwwwwwwwwwwwwwwwwwwwwww) {
                    cd0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((cd0<Object>) error);
                } else {
                    cd0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[0] = error;
                }
                return;
            } else {
                this.Wwwwwwwwwwwwwwwwwww = true;
                this.Wwwwwwwwwwwwwwwwwwwww = true;
            }
            if (z) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            } else {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(th);
            }
        }
    }

    @Override // me.tvspark.j60
    public void onNext(T t) {
        if (this.Wwwwwwwwwwwwwwwwwww) {
            return;
        }
        if (t == null) {
            this.Wwwwwwwwwwwwwwwwwwwwww.dispose();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            if (this.Wwwwwwwwwwwwwwwwwww) {
                return;
            }
            if (!this.Wwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwww = true;
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onNext(t);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return;
            }
            cd0<Object> cd0Var = this.Wwwwwwwwwwwwwwwwwwww;
            if (cd0Var == null) {
                cd0Var = new cd0<>(4);
                this.Wwwwwwwwwwwwwwwwwwww = cd0Var;
            }
            cd0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((cd0<Object>) NotificationLite.next(t));
        }
    }

    @Override // me.tvspark.j60
    public void onSubscribe(p60 p60Var) {
        if (DisposableHelper.validate(this.Wwwwwwwwwwwwwwwwwwwwww, p60Var)) {
            this.Wwwwwwwwwwwwwwwwwwwwww = p60Var;
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onSubscribe(this);
        }
    }
}
