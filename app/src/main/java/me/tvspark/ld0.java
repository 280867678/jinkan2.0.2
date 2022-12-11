package me.tvspark;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;

/* loaded from: classes4.dex */
public final class ld0<T> implements j60<T>, p60 {
    public boolean Wwwwwwwwwwwwwwwwwwwwww;
    public p60 Wwwwwwwwwwwwwwwwwwwwwww;
    public final j60<? super T> Wwwwwwwwwwwwwwwwwwwwwwww;

    public ld0(j60<? super T> j60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = j60Var;
    }

    @Override // me.tvspark.p60
    public void dispose() {
        this.Wwwwwwwwwwwwwwwwwwwwwww.dispose();
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww.isDisposed();
    }

    @Override // me.tvspark.j60
    public void onComplete() {
        CompositeException compositeException;
        if (this.Wwwwwwwwwwwwwwwwwwwwww) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwww = true;
        if (this.Wwwwwwwwwwwwwwwwwwwwwww == null) {
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onSubscribe(EmptyDisposable.INSTANCE);
                try {
                    this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(nullPointerException);
                } catch (Throwable th) {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                    compositeException = new CompositeException(nullPointerException, th);
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) compositeException);
                }
            } catch (Throwable th2) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
                compositeException = new CompositeException(nullPointerException, th2);
            }
        } else {
            try {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onComplete();
            } catch (Throwable th3) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th3);
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th3);
            }
        }
    }

    @Override // me.tvspark.j60
    public void onError(Throwable th) {
        if (this.Wwwwwwwwwwwwwwwwwwwwww) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwww = true;
        if (this.Wwwwwwwwwwwwwwwwwwwwwww != null) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            try {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(th);
                return;
            } catch (Throwable th2) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) new CompositeException(th, th2));
                return;
            }
        }
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onSubscribe(EmptyDisposable.INSTANCE);
            try {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(new CompositeException(th, nullPointerException));
            } catch (Throwable th3) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th3);
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) new CompositeException(th, nullPointerException, th3));
            }
        } catch (Throwable th4) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th4);
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) new CompositeException(th, nullPointerException, th4));
        }
    }

    @Override // me.tvspark.j60
    public void onNext(T t) {
        CompositeException compositeException;
        CompositeException compositeException2;
        if (this.Wwwwwwwwwwwwwwwwwwwwww) {
            return;
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwww != null) {
            if (t == null) {
                NullPointerException nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
                try {
                    this.Wwwwwwwwwwwwwwwwwwwwwww.dispose();
                    onError(nullPointerException);
                    return;
                } catch (Throwable th) {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                    compositeException = new CompositeException(nullPointerException, th);
                }
            } else {
                try {
                    this.Wwwwwwwwwwwwwwwwwwwwwwww.onNext(t);
                    return;
                } catch (Throwable th2) {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
                    try {
                        this.Wwwwwwwwwwwwwwwwwwwwwww.dispose();
                        onError(th2);
                        return;
                    } catch (Throwable th3) {
                        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th3);
                        compositeException = new CompositeException(th2, th3);
                    }
                }
            }
            onError(compositeException);
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwww = true;
        NullPointerException nullPointerException2 = new NullPointerException("Subscription not set!");
        try {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onSubscribe(EmptyDisposable.INSTANCE);
            try {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(nullPointerException2);
            } catch (Throwable th4) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th4);
                compositeException2 = new CompositeException(nullPointerException2, th4);
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) compositeException2);
            }
        } catch (Throwable th5) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th5);
            compositeException2 = new CompositeException(nullPointerException2, th5);
        }
    }

    @Override // me.tvspark.j60
    public void onSubscribe(p60 p60Var) {
        if (DisposableHelper.validate(this.Wwwwwwwwwwwwwwwwwwwwwww, p60Var)) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = p60Var;
            try {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onSubscribe(this);
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                this.Wwwwwwwwwwwwwwwwwwwwww = true;
                try {
                    p60Var.dispose();
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                } catch (Throwable th2) {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) new CompositeException(th, th2));
                }
            }
        }
    }
}
