package me.tvspark;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.subjects.UnicastSubject;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.k60;

/* loaded from: classes4.dex */
public final class nc0<T> extends x80<T, d60<T>> {
    public final boolean Wwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwww;
    public final k60 Wwwwwwwwwwwwwwwwwwww;
    public final TimeUnit Wwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> extends e80<T, Object, d60<T>> implements p60, Runnable {
        public volatile boolean Wwwwwwwwwww;
        public p60 Wwwwwwwwwwww;
        public final List<UnicastSubject<T>> Wwwwwwwwwwwww = new LinkedList();
        public final int Wwwwwwwwwwwwww;
        public final k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwww;
        public final TimeUnit Wwwwwwwwwwwwwwww;
        public final long Wwwwwwwwwwwwwwwww;
        public final long Wwwwwwwwwwwwwwwwww;

        /* renamed from: me.tvspark.nc0$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C3483Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> {
            public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            public final UnicastSubject<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

            public C3483Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(UnicastSubject<T> unicastSubject, boolean z) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = unicastSubject;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
            }
        }

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
            public final /* synthetic */ UnicastSubject Wwwwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(UnicastSubject unicastSubject) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = unicastSubject;
            }

            @Override // java.lang.Runnable
            public void run() {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.offer(new C3483Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, false));
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
            public final /* synthetic */ UnicastSubject Wwwwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(UnicastSubject unicastSubject) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = unicastSubject;
            }

            @Override // java.lang.Runnable
            public void run() {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.offer(new C3483Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, false));
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60<? super d60<T>> j60Var, long j, long j2, TimeUnit timeUnit, k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, int i) {
            super(j60Var, new MpscLinkedQueue());
            this.Wwwwwwwwwwwwwwwwww = j;
            this.Wwwwwwwwwwwwwwwww = j2;
            this.Wwwwwwwwwwwwwwww = timeUnit;
            this.Wwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwww = i;
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.Wwwwwwwwwwwwwwwwwwwwww;
            j60<? super V> j60Var = this.Wwwwwwwwwwwwwwwwwwwwwww;
            List<UnicastSubject<T>> list = this.Wwwwwwwwwwwww;
            int i = 1;
            while (!this.Wwwwwwwwwww) {
                boolean z = this.Wwwwwwwwwwwwwwwwwwww;
                T t = (T) mpscLinkedQueue.mo4868poll();
                boolean z2 = t == null;
                boolean z3 = t instanceof C3483Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (z && (z2 || z3)) {
                    mpscLinkedQueue.clear();
                    this.Wwwwwwwwwwwwwww.dispose();
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
                } else if (z3) {
                    C3483Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww c3483Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (C3483Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) t;
                    if (!c3483Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        list.remove(c3483Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        c3483Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.onComplete();
                        if (list.isEmpty() && this.Wwwwwwwwwwwwwwwwwwwww) {
                            this.Wwwwwwwwwww = true;
                        }
                    } else if (!this.Wwwwwwwwwwwwwwwwwwwww) {
                        UnicastSubject<T> unicastSubject3 = new UnicastSubject<>(this.Wwwwwwwwwwwwww);
                        list.add(unicastSubject3);
                        j60Var.onNext(unicastSubject3);
                        this.Wwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(unicastSubject3), this.Wwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwww);
                    }
                } else {
                    for (UnicastSubject<T> unicastSubject4 : list) {
                        unicastSubject4.onNext(t);
                    }
                }
            }
            this.Wwwwwwwwwwww.dispose();
            this.Wwwwwwwwwwwwwww.dispose();
            mpscLinkedQueue.clear();
            list.clear();
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
            this.Wwwwwwwwwwwwwwwwwwww = true;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            this.Wwwwwwwwwwwwwww.dispose();
            this.Wwwwwwwwwwwwwwwwwwwwwww.onComplete();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            this.Wwwwwwwwwwwwwwwwwww = th;
            this.Wwwwwwwwwwwwwwwwwwww = true;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            this.Wwwwwwwwwwwwwww.dispose();
            this.Wwwwwwwwwwwwwwwwwwwwwww.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                for (UnicastSubject<T> unicastSubject : this.Wwwwwwwwwwwww) {
                    unicastSubject.onNext(t);
                }
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-1) == 0) {
                    return;
                }
            } else {
                this.Wwwwwwwwwwwwwwwwwwwwww.offer(t);
                if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    return;
                }
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.Wwwwwwwwwwww, p60Var)) {
                this.Wwwwwwwwwwww = p60Var;
                this.Wwwwwwwwwwwwwwwwwwwwwww.onSubscribe(this);
                if (this.Wwwwwwwwwwwwwwwwwwwww) {
                    return;
                }
                UnicastSubject<T> unicastSubject = new UnicastSubject<>(this.Wwwwwwwwwwwwww);
                this.Wwwwwwwwwwwww.add(unicastSubject);
                this.Wwwwwwwwwwwwwwwwwwwwwww.onNext(unicastSubject);
                this.Wwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(unicastSubject), this.Wwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwww);
                k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwww;
                long j = this.Wwwwwwwwwwwwwwwww;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, j, j, this.Wwwwwwwwwwwwwwww);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            C3483Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww c3483Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C3483Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new UnicastSubject(this.Wwwwwwwwwwwwww), true);
            if (!this.Wwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwwww.offer(c3483Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> extends e80<T, Object, d60<T>> implements j60<T>, p60, Runnable {
        public static final Object Wwwwwwwwww = new Object();
        public volatile boolean Wwwwwwwwwww;
        public final AtomicReference<p60> Wwwwwwwwwwww = new AtomicReference<>();
        public UnicastSubject<T> Wwwwwwwwwwwww;
        public p60 Wwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwww;
        public final k60 Wwwwwwwwwwwwwwww;
        public final TimeUnit Wwwwwwwwwwwwwwwww;
        public final long Wwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60<? super d60<T>> j60Var, long j, TimeUnit timeUnit, k60 k60Var, int i) {
            super(j60Var, new MpscLinkedQueue());
            this.Wwwwwwwwwwwwwwwwww = j;
            this.Wwwwwwwwwwwwwwwww = timeUnit;
            this.Wwwwwwwwwwwwwwww = k60Var;
            this.Wwwwwwwwwwwwwww = i;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0028, code lost:
            r2.onError(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x002c, code lost:
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
            r7.Wwwwwwwwwwwww = null;
            r0.clear();
            io.reactivex.internal.disposables.DisposableHelper.dispose(r7.Wwwwwwwwwwww);
            r0 = r7.Wwwwwwwwwwwwwwwwwww;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0026, code lost:
            if (r0 == null) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.Wwwwwwwwwwwwwwwwwwwwww;
            j60<? super V> j60Var = this.Wwwwwwwwwwwwwwwwwwwwwww;
            UnicastSubject<T> unicastSubject = this.Wwwwwwwwwwwww;
            int i = 1;
            while (true) {
                boolean z = this.Wwwwwwwwwww;
                boolean z2 = this.Wwwwwwwwwwwwwwwwwwww;
                Object mo4868poll = mpscLinkedQueue.mo4868poll();
                if (!z2 || (mo4868poll != null && mo4868poll != Wwwwwwwwww)) {
                    if (mo4868poll == null) {
                        i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-i);
                        if (i == 0) {
                            return;
                        }
                    } else if (mo4868poll == Wwwwwwwwww) {
                        unicastSubject.onComplete();
                        if (!z) {
                            UnicastSubject<T> unicastSubject2 = new UnicastSubject<>(this.Wwwwwwwwwwwwwww);
                            this.Wwwwwwwwwwwww = unicastSubject2;
                            j60Var.onNext(unicastSubject2);
                            unicastSubject = unicastSubject2;
                        } else {
                            this.Wwwwwwwwwwwwww.dispose();
                        }
                    } else {
                        unicastSubject.onNext((T) NotificationLite.getValue(mo4868poll));
                    }
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
            this.Wwwwwwwwwwwwwwwwwwww = true;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            DisposableHelper.dispose(this.Wwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwww.onComplete();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            this.Wwwwwwwwwwwwwwwwwww = th;
            this.Wwwwwwwwwwwwwwwwwwww = true;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            DisposableHelper.dispose(this.Wwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwww.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            if (this.Wwwwwwwwwww) {
                return;
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                this.Wwwwwwwwwwwww.onNext(t);
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
                this.Wwwwwwwwwwwww = new UnicastSubject<>(this.Wwwwwwwwwwwwwww);
                j60<? super V> j60Var = this.Wwwwwwwwwwwwwwwwwwwwwww;
                j60Var.onSubscribe(this);
                j60Var.onNext(this.Wwwwwwwwwwwww);
                if (this.Wwwwwwwwwwwwwwwwwwwww) {
                    return;
                }
                k60 k60Var = this.Wwwwwwwwwwwwwwww;
                long j = this.Wwwwwwwwwwwwwwwwww;
                DisposableHelper.replace(this.Wwwwwwwwwwww, k60Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, j, j, this.Wwwwwwwwwwwwwwwww));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.Wwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwww = true;
                DisposableHelper.dispose(this.Wwwwwwwwwwww);
            }
            this.Wwwwwwwwwwwwwwwwwwwwww.offer(Wwwwwwwwww);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> extends e80<T, Object, d60<T>> implements p60 {
        public final AtomicReference<p60> Wwwwww = new AtomicReference<>();
        public volatile boolean Wwwwwww;
        public k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwww;
        public UnicastSubject<T> Wwwwwwwww;
        public p60 Wwwwwwwwww;
        public long Wwwwwwwwwww;
        public long Wwwwwwwwwwww;
        public final long Wwwwwwwwwwwww;
        public final boolean Wwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwww;
        public final k60 Wwwwwwwwwwwwwwww;
        public final TimeUnit Wwwwwwwwwwwwwwwww;
        public final long Wwwwwwwwwwwwwwwwww;

        /* renamed from: me.tvspark.nc0$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class RunnableC3484Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
            public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?> Wwwwwwwwwwwwwwwwwwwwwww;
            public final long Wwwwwwwwwwwwwwwwwwwwwwww;

            public RunnableC3484Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = j;
                this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }

            @Override // java.lang.Runnable
            public void run() {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww;
                if (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.offer(this);
                } else {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwww = true;
                    DisposableHelper.dispose(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwww);
                }
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60<? super d60<T>> j60Var, long j, TimeUnit timeUnit, k60 k60Var, int i, long j2, boolean z) {
            super(j60Var, new MpscLinkedQueue());
            this.Wwwwwwwwwwwwwwwwww = j;
            this.Wwwwwwwwwwwwwwwww = timeUnit;
            this.Wwwwwwwwwwwwwwww = k60Var;
            this.Wwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwww = j2;
            this.Wwwwwwwwwwwwww = z;
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            UnicastSubject<T> unicastSubject;
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.Wwwwwwwwwwwwwwwwwwwwww;
            j60<? super V> j60Var = this.Wwwwwwwwwwwwwwwwwwwwwww;
            UnicastSubject<T> unicastSubject2 = this.Wwwwwwwww;
            int i = 1;
            while (!this.Wwwwwww) {
                boolean z = this.Wwwwwwwwwwwwwwwwwwww;
                Object mo4868poll = mpscLinkedQueue.mo4868poll();
                boolean z2 = mo4868poll == null;
                boolean z3 = mo4868poll instanceof RunnableC3484Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (z && (z2 || z3)) {
                    this.Wwwwwwwww = null;
                    mpscLinkedQueue.clear();
                    DisposableHelper.dispose(this.Wwwwww);
                    Throwable th = this.Wwwwwwwwwwwwwwwwwww;
                    if (th != null) {
                        unicastSubject2.onError(th);
                        return;
                    } else {
                        unicastSubject2.onComplete();
                        return;
                    }
                } else if (z2) {
                    i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (!z3) {
                    unicastSubject2.onNext((T) NotificationLite.getValue(mo4868poll));
                    long j = this.Wwwwwwwwwwww + 1;
                    if (j >= this.Wwwwwwwwwwwww) {
                        this.Wwwwwwwwwww++;
                        this.Wwwwwwwwwwww = 0L;
                        unicastSubject2.onComplete();
                        unicastSubject = new UnicastSubject<>(this.Wwwwwwwwwwwwwww);
                        this.Wwwwwwwww = unicastSubject;
                        this.Wwwwwwwwwwwwwwwwwwwwwww.onNext(unicastSubject);
                        if (this.Wwwwwwwwwwwwww) {
                            p60 p60Var = this.Wwwwww.get();
                            p60Var.dispose();
                            k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwww;
                            RunnableC3484Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww runnableC3484Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new RunnableC3484Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwww, this);
                            long j2 = this.Wwwwwwwwwwwwwwwwww;
                            p60 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(runnableC3484Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, j2, j2, this.Wwwwwwwwwwwwwwwww);
                            if (!this.Wwwwww.compareAndSet(p60Var, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.dispose();
                            }
                        }
                        unicastSubject2 = unicastSubject;
                    } else {
                        this.Wwwwwwwwwwww = j;
                    }
                } else if (this.Wwwwwwwwwww == ((RunnableC3484Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) mo4868poll).Wwwwwwwwwwwwwwwwwwwwwwww) {
                    unicastSubject = new UnicastSubject<>(this.Wwwwwwwwwwwwwww);
                    this.Wwwwwwwww = unicastSubject;
                    j60Var.onNext(unicastSubject);
                    unicastSubject2 = unicastSubject;
                }
            }
            this.Wwwwwwwwww.dispose();
            mpscLinkedQueue.clear();
            DisposableHelper.dispose(this.Wwwwww);
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
            this.Wwwwwwwwwwwwwwwwwwww = true;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            DisposableHelper.dispose(this.Wwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwww.onComplete();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            this.Wwwwwwwwwwwwwwwwwww = th;
            this.Wwwwwwwwwwwwwwwwwwww = true;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            DisposableHelper.dispose(this.Wwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwww.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            if (this.Wwwwwww) {
                return;
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                UnicastSubject<T> unicastSubject = this.Wwwwwwwww;
                unicastSubject.onNext(t);
                long j = this.Wwwwwwwwwwww + 1;
                if (j >= this.Wwwwwwwwwwwww) {
                    this.Wwwwwwwwwww++;
                    this.Wwwwwwwwwwww = 0L;
                    unicastSubject.onComplete();
                    UnicastSubject<T> unicastSubject2 = new UnicastSubject<>(this.Wwwwwwwwwwwwwww);
                    this.Wwwwwwwww = unicastSubject2;
                    this.Wwwwwwwwwwwwwwwwwwwwwww.onNext(unicastSubject2);
                    if (this.Wwwwwwwwwwwwww) {
                        this.Wwwwww.get().dispose();
                        k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwww;
                        RunnableC3484Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww runnableC3484Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new RunnableC3484Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwww, this);
                        long j2 = this.Wwwwwwwwwwwwwwwwww;
                        DisposableHelper.replace(this.Wwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(runnableC3484Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, j2, j2, this.Wwwwwwwwwwwwwwwww));
                    }
                } else {
                    this.Wwwwwwwwwwww = j;
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
            k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (DisposableHelper.validate(this.Wwwwwwwwww, p60Var)) {
                this.Wwwwwwwwww = p60Var;
                j60<? super V> j60Var = this.Wwwwwwwwwwwwwwwwwwwwwww;
                j60Var.onSubscribe(this);
                if (this.Wwwwwwwwwwwwwwwwwwwww) {
                    return;
                }
                UnicastSubject<T> unicastSubject = new UnicastSubject<>(this.Wwwwwwwwwwwwwww);
                this.Wwwwwwwww = unicastSubject;
                j60Var.onNext(unicastSubject);
                RunnableC3484Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww runnableC3484Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new RunnableC3484Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwww, this);
                if (this.Wwwwwwwwwwwwww) {
                    k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    this.Wwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    long j = this.Wwwwwwwwwwwwwwwwww;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(runnableC3484Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, j, j, this.Wwwwwwwwwwwwwwwww);
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                } else {
                    k60 k60Var = this.Wwwwwwwwwwwwwwww;
                    long j2 = this.Wwwwwwwwwwwwwwwwww;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = k60Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(runnableC3484Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, j2, j2, this.Wwwwwwwwwwwwwwwww);
                }
                DisposableHelper.replace(this.Wwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }
    }

    public nc0(h60<T> h60Var, long j, long j2, TimeUnit timeUnit, k60 k60Var, long j3, int i, boolean z) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = j;
        this.Wwwwwwwwwwwwwwwwwwwwww = j2;
        this.Wwwwwwwwwwwwwwwwwwwww = timeUnit;
        this.Wwwwwwwwwwwwwwwwwwww = k60Var;
        this.Wwwwwwwwwwwwwwwwwww = j3;
        this.Wwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwww = z;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super d60<T>> j60Var) {
        md0 md0Var = new md0(j60Var);
        long j = this.Wwwwwwwwwwwwwwwwwwwwwww;
        long j2 = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (j != j2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(md0Var, j, j2, this.Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), this.Wwwwwwwwwwwwwwwwww));
            return;
        }
        long j3 = this.Wwwwwwwwwwwwwwwwwww;
        if (j3 == Long.MAX_VALUE) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(md0Var, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwww));
        } else {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(md0Var, j, this.Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwww, j3, this.Wwwwwwwwwwwwwwwww));
        }
    }
}
