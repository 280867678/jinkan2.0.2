package me.tvspark;

import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import me.tvspark.cd0;

/* loaded from: classes4.dex */
public final class qd0<T> extends sd0<T> {
    public long Wwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwww;
    public final Lock Wwwwwwwwwwwwwwwwwwww;
    public final Lock Wwwwwwwwwwwwwwwwwwwww;
    public final ReadWriteLock Wwwwwwwwwwwwwwwwwwwwww;
    public final AtomicReference<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T>[]> Wwwwwwwwwwwwwwwwwwwwwww = new AtomicReference<>(Wwwwwwwwwwwwwwww);
    public final AtomicReference<Object> Wwwwwwwwwwwwwwwwwwwwwwww = new AtomicReference<>();
    public static final Object[] Wwwwwwwwwwwwwwwww = new Object[0];
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] Wwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[0];
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] Wwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[0];

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> implements p60, cd0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Object> {
        public long Wwwwwwwwwwwwwwwww;
        public volatile boolean Wwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwww;
        public cd0<Object> Wwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwww;
        public final qd0<T> Wwwwwwwwwwwwwwwwwwwwwww;
        public final j60<? super T> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60<? super T> j60Var, qd0<T> qd0Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = j60Var;
            this.Wwwwwwwwwwwwwwwwwwwwwww = qd0Var;
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            cd0<Object> cd0Var;
            while (!this.Wwwwwwwwwwwwwwwwww) {
                synchronized (this) {
                    cd0Var = this.Wwwwwwwwwwwwwwwwwwww;
                    if (cd0Var == null) {
                        this.Wwwwwwwwwwwwwwwwwwwww = false;
                        return;
                    }
                    this.Wwwwwwwwwwwwwwwwwwww = null;
                }
                cd0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((cd0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<? super Object>) this);
            }
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            if (this.Wwwwwwwwwwwwwwwwww) {
                return;
            }
            synchronized (this) {
                if (this.Wwwwwwwwwwwwwwwwww) {
                    return;
                }
                if (this.Wwwwwwwwwwwwwwwwwwwwww) {
                    return;
                }
                qd0<T> qd0Var = this.Wwwwwwwwwwwwwwwwwwwwwww;
                Lock lock = qd0Var.Wwwwwwwwwwwwwwwwwwwww;
                lock.lock();
                this.Wwwwwwwwwwwwwwwww = qd0Var.Wwwwwwwwwwwwwwwwww;
                Object obj = qd0Var.Wwwwwwwwwwwwwwwwwwwwwwww.get();
                lock.unlock();
                this.Wwwwwwwwwwwwwwwwwwwww = obj != null;
                this.Wwwwwwwwwwwwwwwwwwwwww = true;
                if (obj == null || test(obj)) {
                    return;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, long j) {
            if (this.Wwwwwwwwwwwwwwwwww) {
                return;
            }
            if (!this.Wwwwwwwwwwwwwwwwwww) {
                synchronized (this) {
                    if (this.Wwwwwwwwwwwwwwwwww) {
                        return;
                    }
                    if (this.Wwwwwwwwwwwwwwwww == j) {
                        return;
                    }
                    if (this.Wwwwwwwwwwwwwwwwwwwww) {
                        cd0<Object> cd0Var = this.Wwwwwwwwwwwwwwwwwwww;
                        if (cd0Var == null) {
                            cd0Var = new cd0<>(4);
                            this.Wwwwwwwwwwwwwwwwwwww = cd0Var;
                        }
                        cd0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((cd0<Object>) obj);
                        return;
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwww = true;
                    this.Wwwwwwwwwwwwwwwwwww = true;
                }
            }
            test(obj);
        }

        @Override // me.tvspark.p60
        public void dispose() {
            if (!this.Wwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwww = true;
                this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this);
            }
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.Wwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.cd0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.g70
        public boolean test(Object obj) {
            return this.Wwwwwwwwwwwwwwwwww || NotificationLite.accept(obj, this.Wwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    public qd0() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.Wwwwwwwwwwwwwwwwwwwwww = reentrantReadWriteLock;
        this.Wwwwwwwwwwwwwwwwwwwww = reentrantReadWriteLock.readLock();
        this.Wwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww.writeLock();
    }

    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T>[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T>[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr = this.Wwwwwwwwwwwwwwwwwwwwwww.get();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T>[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr2 = Wwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr != wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr2 && (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr = this.Wwwwwwwwwwwwwwwwwwwwwww.getAndSet(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr2)) != Wwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
        }
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
        this.Wwwwwwwwwwwwwwwwwwww.lock();
        try {
            this.Wwwwwwwwwwwwwwwwww++;
            this.Wwwwwwwwwwwwwwwwwwwwwwww.lazySet(obj);
        } finally {
            this.Wwwwwwwwwwwwwwwwwwww.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T>[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr2;
        do {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr = this.Wwwwwwwwwwwwwwwwwwwwwww.get();
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr == Wwwwwwwwwwwwwww || wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr == Wwwwwwwwwwwwwwww) {
                return;
            }
            int length = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr.length;
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr[i2] == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
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
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr2 = Wwwwwwwwwwwwwwww;
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr3 = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[length - 1];
                System.arraycopy(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr, 0, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr3, 0, i);
                System.arraycopy(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr, i + 1, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr3, i, (length - i) - 1);
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr3;
            }
        } while (!this.Wwwwwwwwwwwwwwwwwwwwwww.compareAndSet(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr2));
    }

    @Override // me.tvspark.j60
    public void onComplete() {
        if (this.Wwwwwwwwwwwwwwwwwww) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwww = true;
        Object complete = NotificationLite.complete();
        for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(complete)) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(complete, this.Wwwwwwwwwwwwwwwwww);
        }
    }

    @Override // me.tvspark.j60
    public void onError(Throwable th) {
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        if (this.Wwwwwwwwwwwwwwwwwww) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        this.Wwwwwwwwwwwwwwwwwww = true;
        Object error = NotificationLite.error(th);
        for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(error)) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(error, this.Wwwwwwwwwwwwwwwwww);
        }
    }

    @Override // me.tvspark.j60
    public void onNext(T t) {
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        } else if (!this.Wwwwwwwwwwwwwwwwwww) {
            Object next = NotificationLite.next(t);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next);
            for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : this.Wwwwwwwwwwwwwwwwwwwwwww.get()) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next, this.Wwwwwwwwwwwwwwwwww);
            }
        }
    }

    @Override // me.tvspark.j60
    public void onSubscribe(p60 p60Var) {
        if (this.Wwwwwwwwwwwwwwwwwww) {
            p60Var.dispose();
        }
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        boolean z;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(j60Var, this);
        j60Var.onSubscribe(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        while (true) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T>[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr = this.Wwwwwwwwwwwwwwwwwwwwwww.get();
            z = false;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr != Wwwwwwwwwwwwwww) {
                int length = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr.length;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T>[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr2 = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[length + 1];
                System.arraycopy(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr, 0, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr2, 0, length);
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr2[length] = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (this.Wwwwwwwwwwwwwwwwwwwwwww.compareAndSet(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr2)) {
                    z = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (z) {
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                return;
            } else {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return;
            }
        }
        Object obj = this.Wwwwwwwwwwwwwwwwwwwwwwww.get();
        if (NotificationLite.isComplete(obj)) {
            j60Var.onComplete();
        } else {
            j60Var.onError(NotificationLite.getError(obj));
        }
    }
}
