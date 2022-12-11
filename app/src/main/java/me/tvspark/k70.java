package me.tvspark;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.util.NotificationLite;

/* JADX WARN: Incorrect class signature, class is equals to this class: <T:Ljava/lang/Object;>Lme/tvspark/k70;Lme/tvspark/p60; */
/* loaded from: classes4.dex */
public final class k70<T> extends i70 implements p60 {
    public volatile boolean Wwwwwwwwwwwwwwwwwww;
    public p60 Wwwwwwwwwwwwwwwwwwww;
    public volatile p60 Wwwwwwwwwwwwwwwwwwwww = EmptyDisposable.INSTANCE;
    public final sc0<Object> Wwwwwwwwwwwwwwwwwwwwww;
    public final j60<? super T> Wwwwwwwwwwwwwwwwwwwwwww;

    public k70(j60<? super T> j60Var, p60 p60Var, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = j60Var;
        this.Wwwwwwwwwwwwwwwwwwww = p60Var;
        this.Wwwwwwwwwwwwwwwwwwwwww = new sc0<>(i);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww.getAndIncrement() != 0) {
            return;
        }
        sc0<Object> sc0Var = this.Wwwwwwwwwwwwwwwwwwwwww;
        j60<? super T> j60Var = this.Wwwwwwwwwwwwwwwwwwwwwww;
        int i = 1;
        while (true) {
            Object mo4868poll = sc0Var.mo4868poll();
            if (mo4868poll == null) {
                i = this.Wwwwwwwwwwwwwwwwwwwwwwww.addAndGet(-i);
                if (i == 0) {
                    return;
                }
            } else {
                Object mo4868poll2 = sc0Var.mo4868poll();
                if (mo4868poll == this.Wwwwwwwwwwwwwwwwwwwww) {
                    if (NotificationLite.isDisposable(mo4868poll2)) {
                        p60 disposable = NotificationLite.getDisposable(mo4868poll2);
                        this.Wwwwwwwwwwwwwwwwwwwww.dispose();
                        if (!this.Wwwwwwwwwwwwwwwwwww) {
                            this.Wwwwwwwwwwwwwwwwwwwww = disposable;
                        } else {
                            disposable.dispose();
                        }
                    } else if (NotificationLite.isError(mo4868poll2)) {
                        sc0Var.clear();
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        Throwable error = NotificationLite.getError(mo4868poll2);
                        if (!this.Wwwwwwwwwwwwwwwwwww) {
                            this.Wwwwwwwwwwwwwwwwwww = true;
                            j60Var.onError(error);
                        } else {
                            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(error);
                        }
                    } else if (NotificationLite.isComplete(mo4868poll2)) {
                        sc0Var.clear();
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        if (!this.Wwwwwwwwwwwwwwwwwww) {
                            this.Wwwwwwwwwwwwwwwwwww = true;
                            j60Var.onComplete();
                        }
                    } else {
                        j60Var.onNext((Object) NotificationLite.getValue(mo4868poll2));
                    }
                }
            }
        }
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(p60 p60Var) {
        if (this.Wwwwwwwwwwwwwwwwwww) {
            return false;
        }
        this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwww, NotificationLite.disposable(p60Var));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return true;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        p60 p60Var = this.Wwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwww = null;
        if (p60Var != null) {
            p60Var.dispose();
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Throwable th, p60 p60Var) {
        if (this.Wwwwwwwwwwwwwwwwwww) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(p60Var, NotificationLite.error(th));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(p60 p60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(p60Var, NotificationLite.complete());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T t, p60 p60Var) {
        if (this.Wwwwwwwwwwwwwwwwwww) {
            return false;
        }
        this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(p60Var, NotificationLite.next(t));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return true;
    }

    @Override // me.tvspark.p60
    public void dispose() {
        if (!this.Wwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwww = true;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        p60 p60Var = this.Wwwwwwwwwwwwwwwwwwww;
        return p60Var != null ? p60Var.isDisposed() : this.Wwwwwwwwwwwwwwwwwww;
    }
}
