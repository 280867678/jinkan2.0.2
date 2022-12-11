package me.tvspark;

import io.reactivex.internal.util.NotificationLite;
import me.tvspark.cd0;

/* loaded from: classes4.dex */
public final class rd0<T> extends sd0<T> implements cd0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Object> {
    public volatile boolean Wwwwwwwwwwwwwwwwwwwww;
    public cd0<Object> Wwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwww;
    public final sd0<T> Wwwwwwwwwwwwwwwwwwwwwwww;

    public rd0(sd0<T> sd0Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = sd0Var;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        cd0<Object> cd0Var;
        while (true) {
            synchronized (this) {
                cd0Var = this.Wwwwwwwwwwwwwwwwwwwwww;
                if (cd0Var == null) {
                    this.Wwwwwwwwwwwwwwwwwwwwwww = false;
                    return;
                }
                this.Wwwwwwwwwwwwwwwwwwwwww = null;
            }
            cd0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((cd0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<? super Object>) this);
        }
    }

    @Override // me.tvspark.j60
    public void onComplete() {
        if (this.Wwwwwwwwwwwwwwwwwwwww) {
            return;
        }
        synchronized (this) {
            if (this.Wwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwww = true;
            if (!this.Wwwwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwwwww = true;
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onComplete();
                return;
            }
            cd0<Object> cd0Var = this.Wwwwwwwwwwwwwwwwwwwwww;
            if (cd0Var == null) {
                cd0Var = new cd0<>(4);
                this.Wwwwwwwwwwwwwwwwwwwwww = cd0Var;
            }
            cd0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((cd0<Object>) NotificationLite.complete());
        }
    }

    @Override // me.tvspark.j60
    public void onError(Throwable th) {
        if (this.Wwwwwwwwwwwwwwwwwwwww) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        synchronized (this) {
            boolean z = false;
            if (this.Wwwwwwwwwwwwwwwwwwwww) {
                z = true;
            } else {
                this.Wwwwwwwwwwwwwwwwwwwww = true;
                if (this.Wwwwwwwwwwwwwwwwwwwwwww) {
                    cd0<Object> cd0Var = this.Wwwwwwwwwwwwwwwwwwwwww;
                    if (cd0Var == null) {
                        cd0Var = new cd0<>(4);
                        this.Wwwwwwwwwwwwwwwwwwwwww = cd0Var;
                    }
                    cd0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[0] = NotificationLite.error(th);
                    return;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwww = true;
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
        if (this.Wwwwwwwwwwwwwwwwwwwww) {
            return;
        }
        synchronized (this) {
            if (this.Wwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            if (!this.Wwwwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwwwww = true;
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onNext(t);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return;
            }
            cd0<Object> cd0Var = this.Wwwwwwwwwwwwwwwwwwwwww;
            if (cd0Var == null) {
                cd0Var = new cd0<>(4);
                this.Wwwwwwwwwwwwwwwwwwwwww = cd0Var;
            }
            cd0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((cd0<Object>) NotificationLite.next(t));
        }
    }

    @Override // me.tvspark.j60
    public void onSubscribe(p60 p60Var) {
        boolean z = true;
        if (!this.Wwwwwwwwwwwwwwwwwwwww) {
            synchronized (this) {
                if (!this.Wwwwwwwwwwwwwwwwwwwww) {
                    if (this.Wwwwwwwwwwwwwwwwwwwwwww) {
                        cd0<Object> cd0Var = this.Wwwwwwwwwwwwwwwwwwwwww;
                        if (cd0Var == null) {
                            cd0Var = new cd0<>(4);
                            this.Wwwwwwwwwwwwwwwwwwwwww = cd0Var;
                        }
                        cd0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((cd0<Object>) NotificationLite.disposable(p60Var));
                        return;
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwwww = true;
                    z = false;
                }
            }
        }
        if (z) {
            p60Var.dispose();
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwww.onSubscribe(p60Var);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(j60Var);
    }

    @Override // me.tvspark.cd0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.g70
    public boolean test(Object obj) {
        return NotificationLite.acceptFull(obj, this.Wwwwwwwwwwwwwwwwwwwwwwww);
    }
}
