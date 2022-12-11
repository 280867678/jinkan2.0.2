package me.tvspark;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class kc0<T, B> extends x80<T, d60<T>> {
    public final int Wwwwwwwwwwwwwwwwwwwwww;
    public final h60<B> Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, B> extends e80<T, Object, d60<T>> implements p60 {
        public static final Object Wwwwwwwwwwww = new Object();
        public final AtomicLong Wwwwwwwwwwwww;
        public UnicastSubject<T> Wwwwwwwwwwwwww;
        public final AtomicReference<p60> Wwwwwwwwwwwwwww = new AtomicReference<>();
        public p60 Wwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwww;
        public final h60<B> Wwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60<? super d60<T>> j60Var, h60<B> h60Var, int i) {
            super(j60Var, new MpscLinkedQueue());
            AtomicLong atomicLong = new AtomicLong();
            this.Wwwwwwwwwwwww = atomicLong;
            this.Wwwwwwwwwwwwwwwwww = h60Var;
            this.Wwwwwwwwwwwwwwwww = i;
            atomicLong.lazySet(1L);
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.Wwwwwwwwwwwwwwwwwwwwww;
            j60<? super V> j60Var = this.Wwwwwwwwwwwwwwwwwwwwwww;
            UnicastSubject<T> unicastSubject = this.Wwwwwwwwwwwwww;
            int i = 1;
            while (true) {
                boolean z = this.Wwwwwwwwwwwwwwwwwwww;
                Object mo4868poll = mpscLinkedQueue.mo4868poll();
                boolean z2 = mo4868poll == null;
                if (z && z2) {
                    DisposableHelper.dispose(this.Wwwwwwwwwwwwwww);
                    Throwable th = this.Wwwwwwwwwwwwwwwwwww;
                    if (th != null) {
                        unicastSubject.onError(th);
                        return;
                    } else {
                        unicastSubject.onComplete();
                        return;
                    }
                } else if (z2) {
                    i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (mo4868poll == Wwwwwwwwwwww) {
                    unicastSubject.onComplete();
                    if (this.Wwwwwwwwwwwww.decrementAndGet() == 0) {
                        DisposableHelper.dispose(this.Wwwwwwwwwwwwwww);
                        return;
                    } else if (!this.Wwwwwwwwwwwwwwwwwwwww) {
                        UnicastSubject<T> unicastSubject2 = new UnicastSubject<>(this.Wwwwwwwwwwwwwwwww);
                        this.Wwwwwwwwwwwww.getAndIncrement();
                        this.Wwwwwwwwwwwwww = unicastSubject2;
                        j60Var.onNext(unicastSubject2);
                        unicastSubject = unicastSubject2;
                    }
                } else {
                    unicastSubject.onNext((T) NotificationLite.getValue(mo4868poll));
                }
            }
        }

        @Override // me.tvspark.p60
        public void dispose() {
            this.Wwwwwwwwwwwwwwwwwwwww = true;
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.Wwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            if (this.Wwwwwwwwwwwwwwwwwwww) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwww = true;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            if (this.Wwwwwwwwwwwww.decrementAndGet() == 0) {
                DisposableHelper.dispose(this.Wwwwwwwwwwwwwww);
            }
            this.Wwwwwwwwwwwwwwwwwwwwwww.onComplete();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            if (this.Wwwwwwwwwwwwwwwwwwww) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                return;
            }
            this.Wwwwwwwwwwwwwwwwwww = th;
            this.Wwwwwwwwwwwwwwwwwwww = true;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            if (this.Wwwwwwwwwwwww.decrementAndGet() == 0) {
                DisposableHelper.dispose(this.Wwwwwwwwwwwwwww);
            }
            this.Wwwwwwwwwwwwwwwwwwwwwww.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                this.Wwwwwwwwwwwwww.onNext(t);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-1) == 0) {
                    return;
                }
            } else {
                this.Wwwwwwwwwwwwwwwwwwwwww.offer(NotificationLite.next(t));
                if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    return;
                }
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.Wwwwwwwwwwwwwwww, p60Var)) {
                this.Wwwwwwwwwwwwwwww = p60Var;
                j60<? super V> j60Var = this.Wwwwwwwwwwwwwwwwwwwwwww;
                j60Var.onSubscribe(this);
                if (this.Wwwwwwwwwwwwwwwwwwwww) {
                    return;
                }
                UnicastSubject<T> unicastSubject = new UnicastSubject<>(this.Wwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwww = unicastSubject;
                j60Var.onNext(unicastSubject);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
                if (!this.Wwwwwwwwwwwwwww.compareAndSet(null, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    return;
                }
                this.Wwwwwwwwwwwww.getAndIncrement();
                this.Wwwwwwwwwwwwwwwwww.subscribe(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, B> extends kd0<B> {
        public boolean Wwwwwwwwwwwwwwwwwwwwww;
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, B> Wwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, B> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            if (this.Wwwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwwwwwww.onComplete();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            if (this.Wwwwwwwwwwwwwwwwwwwwww) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwwwwwww.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(B b) {
            if (this.Wwwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, B> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.offer(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwww);
            if (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                return;
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public kc0(h60<T> h60Var, h60<B> h60Var2, int i) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = h60Var2;
        this.Wwwwwwwwwwwwwwwwwwwwww = i;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super d60<T>> j60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new md0(j60Var), this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww));
    }
}
