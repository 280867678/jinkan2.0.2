package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.d60;
import me.tvspark.h60;
import me.tvspark.j60;
import me.tvspark.p60;
import me.tvspark.x80;

/* loaded from: classes4.dex */
public final class ObservableWindow<T> extends x80<T, d60<T>> {
    public final int Wwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class WindowExactObserver<T> extends AtomicInteger implements j60<T>, p60, Runnable {
        public static final long serialVersionUID = -7481782523886138128L;
        public final j60<? super d60<T>> actual;
        public volatile boolean cancelled;
        public final int capacityHint;
        public final long count;

        /* renamed from: s */
        public p60 f4460s;
        public long size;
        public UnicastSubject<T> window;

        public WindowExactObserver(j60<? super d60<T>> j60Var, long j, int i) {
            this.actual = j60Var;
            this.count = j;
            this.capacityHint = i;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            this.cancelled = true;
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            UnicastSubject<T> unicastSubject = this.window;
            if (unicastSubject != null) {
                this.window = null;
                unicastSubject.onComplete();
            }
            this.actual.onComplete();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            UnicastSubject<T> unicastSubject = this.window;
            if (unicastSubject != null) {
                this.window = null;
                unicastSubject.onError(th);
            }
            this.actual.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            UnicastSubject<T> unicastSubject = this.window;
            if (unicastSubject == null && !this.cancelled) {
                UnicastSubject<T> unicastSubject2 = new UnicastSubject<>(this.capacityHint, this);
                this.window = unicastSubject2;
                this.actual.onNext(unicastSubject2);
                unicastSubject = unicastSubject2;
            }
            if (unicastSubject != null) {
                unicastSubject.onNext(t);
                long j = this.size + 1;
                this.size = j;
                if (j < this.count) {
                    return;
                }
                this.size = 0L;
                this.window = null;
                unicastSubject.onComplete();
                if (!this.cancelled) {
                    return;
                }
                this.f4460s.dispose();
            }
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.f4460s, p60Var)) {
                this.f4460s = p60Var;
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.cancelled) {
                this.f4460s.dispose();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class WindowSkipObserver<T> extends AtomicBoolean implements j60<T>, p60, Runnable {
        public static final long serialVersionUID = 3366976432059579510L;
        public final j60<? super d60<T>> actual;
        public volatile boolean cancelled;
        public final int capacityHint;
        public final long count;
        public long firstEmission;
        public long index;

        /* renamed from: s */
        public p60 f4461s;
        public final long skip;
        public final AtomicInteger wip = new AtomicInteger();
        public final ArrayDeque<UnicastSubject<T>> windows = new ArrayDeque<>();

        public WindowSkipObserver(j60<? super d60<T>> j60Var, long j, long j2, int i) {
            this.actual = j60Var;
            this.count = j;
            this.skip = j2;
            this.capacityHint = i;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            this.cancelled = true;
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.windows;
            while (!arrayDeque.isEmpty()) {
                arrayDeque.poll().onComplete();
            }
            this.actual.onComplete();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.windows;
            while (!arrayDeque.isEmpty()) {
                arrayDeque.poll().onError(th);
            }
            this.actual.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.windows;
            long j = this.index;
            long j2 = this.skip;
            if (j % j2 == 0 && !this.cancelled) {
                this.wip.getAndIncrement();
                UnicastSubject<T> unicastSubject = new UnicastSubject<>(this.capacityHint, this);
                arrayDeque.offer(unicastSubject);
                this.actual.onNext(unicastSubject);
            }
            long j3 = this.firstEmission + 1;
            Iterator<UnicastSubject<T>> it = arrayDeque.iterator();
            while (it.hasNext()) {
                it.next().onNext(t);
            }
            if (j3 >= this.count) {
                arrayDeque.poll().onComplete();
                if (arrayDeque.isEmpty() && this.cancelled) {
                    this.f4461s.dispose();
                    return;
                }
                j3 -= j2;
            }
            this.firstEmission = j3;
            this.index = j + 1;
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.f4461s, p60Var)) {
                this.f4461s = p60Var;
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.wip.decrementAndGet() != 0 || !this.cancelled) {
                return;
            }
            this.f4461s.dispose();
        }
    }

    public ObservableWindow(h60<T> h60Var, long j, long j2, int i) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = j;
        this.Wwwwwwwwwwwwwwwwwwwwww = j2;
        this.Wwwwwwwwwwwwwwwwwwwww = i;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super d60<T>> j60Var) {
        int i = (this.Wwwwwwwwwwwwwwwwwwwwwww > this.Wwwwwwwwwwwwwwwwwwwwww ? 1 : (this.Wwwwwwwwwwwwwwwwwwwwwww == this.Wwwwwwwwwwwwwwwwwwwwww ? 0 : -1));
        h60<T> h60Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (i == 0) {
            h60Var.subscribe(new WindowExactObserver(j60Var, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww));
        } else {
            h60Var.subscribe(new WindowSkipObserver(j60Var, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww));
        }
    }
}
