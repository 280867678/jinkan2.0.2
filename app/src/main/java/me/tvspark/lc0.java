package me.tvspark;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class lc0<T, B, V> extends x80<T, d60<T>> {
    public final int Wwwwwwwwwwwwwwwwwwwww;
    public final f70<? super B, ? extends h60<V>> Wwwwwwwwwwwwwwwwwwwwww;
    public final h60<B> Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, B> {
        public final B Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final UnicastSubject<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(UnicastSubject<T> unicastSubject, B b) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = unicastSubject;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = b;
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, B, V> extends e80<T, Object, d60<T>> implements p60 {
        public p60 Wwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwww;
        public final f70<? super B, ? extends h60<V>> Wwwwwwwwwwwwwwwww;
        public final h60<B> Wwwwwwwwwwwwwwwwww;
        public final AtomicReference<p60> Wwwwwwwwwwwww = new AtomicReference<>();
        public final AtomicLong Wwwwwwwwwww = new AtomicLong();
        public final o60 Wwwwwwwwwwwwwww = new o60();
        public final List<UnicastSubject<T>> Wwwwwwwwwwww = new ArrayList();

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60<? super d60<T>> j60Var, h60<B> h60Var, f70<? super B, ? extends h60<V>> f70Var, int i) {
            super(j60Var, new MpscLinkedQueue());
            this.Wwwwwwwwwwwwwwwwww = h60Var;
            this.Wwwwwwwwwwwwwwwww = f70Var;
            this.Wwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwww.lazySet(1L);
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.Wwwwwwwwwwwwwwwwwwwwww;
            j60<? super V> j60Var = this.Wwwwwwwwwwwwwwwwwwwwwww;
            List<UnicastSubject<T>> list = this.Wwwwwwwwwwww;
            int i = 1;
            while (true) {
                boolean z = this.Wwwwwwwwwwwwwwwwwwww;
                Object mo4868poll = mpscLinkedQueue.mo4868poll();
                boolean z2 = mo4868poll == null;
                if (z && z2) {
                    this.Wwwwwwwwwwwwwww.dispose();
                    DisposableHelper.dispose(this.Wwwwwwwwwwwww);
                    Throwable th = this.Wwwwwwwwwwwwwwwwwww;
                    if (th != null) {
                        for (UnicastSubject<T> unicastSubject : list) {
                            unicastSubject.onError(th);
                        }
                    } else {
                        for (UnicastSubject<T> unicastSubject2 : list) {
                            unicastSubject2.onComplete();
                        }
                    }
                    list.clear();
                    return;
                } else if (z2) {
                    i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (mo4868poll instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) mo4868poll;
                    UnicastSubject<T> unicastSubject3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (unicastSubject3 != null) {
                        if (list.remove(unicastSubject3)) {
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.onComplete();
                            if (this.Wwwwwwwwwww.decrementAndGet() == 0) {
                                this.Wwwwwwwwwwwwwww.dispose();
                                DisposableHelper.dispose(this.Wwwwwwwwwwwww);
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.Wwwwwwwwwwwwwwwwwwwww) {
                        UnicastSubject<T> unicastSubject4 = new UnicastSubject<>(this.Wwwwwwwwwwwwwwww);
                        list.add(unicastSubject4);
                        j60Var.onNext(unicastSubject4);
                        try {
                            h60<V> apply = this.Wwwwwwwwwwwwwwwww.apply((B) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, "The ObservableSource supplied is null");
                            h60<V> h60Var = apply;
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, unicastSubject4);
                            if (this.Wwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                this.Wwwwwwwwwww.getAndIncrement();
                                h60Var.subscribe(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            }
                        } catch (Throwable th2) {
                            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
                            this.Wwwwwwwwwwwwwwwwwwwww = true;
                            j60Var.onError(th2);
                        }
                    }
                } else {
                    for (UnicastSubject<T> unicastSubject5 : list) {
                        unicastSubject5.onNext((T) NotificationLite.getValue(mo4868poll));
                    }
                }
            }
        }

        @Override // me.tvspark.e80
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60<? super d60<T>> j60Var, Object obj) {
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwww.offer(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww, null));
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
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
            if (this.Wwwwwwwwwww.decrementAndGet() == 0) {
                this.Wwwwwwwwwwwwwww.dispose();
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
            if (this.Wwwwwwwwwww.decrementAndGet() == 0) {
                this.Wwwwwwwwwwwwwww.dispose();
            }
            this.Wwwwwwwwwwwwwwwwwwwwwww.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                for (UnicastSubject<T> unicastSubject : this.Wwwwwwwwwwww) {
                    unicastSubject.onNext(t);
                }
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
            if (DisposableHelper.validate(this.Wwwwwwwwwwwwww, p60Var)) {
                this.Wwwwwwwwwwwwww = p60Var;
                this.Wwwwwwwwwwwwwwwwwwwwwww.onSubscribe(this);
                if (this.Wwwwwwwwwwwwwwwwwwwww) {
                    return;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
                if (!this.Wwwwwwwwwwwww.compareAndSet(null, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    return;
                }
                this.Wwwwwwwwwww.getAndIncrement();
                this.Wwwwwwwwwwwwwwwwww.subscribe(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, B> extends kd0<B> {
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, B, ?> Wwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, B, ?> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            this.Wwwwwwwwwwwwwwwwwwwwwww.onComplete();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, B, ?> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwww.dispose();
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwww.dispose();
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(B b) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, B, ?> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.offer(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null, b));
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, V> extends kd0<V> {
        public boolean Wwwwwwwwwwwwwwwwwwwww;
        public final UnicastSubject<T> Wwwwwwwwwwwwwwwwwwwwww;
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, ?, V> Wwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, ?, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, UnicastSubject<T> unicastSubject) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwww = unicastSubject;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            if (this.Wwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            if (this.Wwwwwwwwwwwwwwwwwwwww) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwww = true;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, ?, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwww.dispose();
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwww.dispose();
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(V v) {
            if (this.Wwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwww = true;
            DisposableHelper.dispose(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        }
    }

    public lc0(h60<T> h60Var, h60<B> h60Var2, f70<? super B, ? extends h60<V>> f70Var, int i) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = h60Var2;
        this.Wwwwwwwwwwwwwwwwwwwwww = f70Var;
        this.Wwwwwwwwwwwwwwwwwwwww = i;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super d60<T>> j60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new md0(j60Var), this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww));
    }
}
