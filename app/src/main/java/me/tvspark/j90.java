package me.tvspark;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.k60;

/* loaded from: classes4.dex */
public final class j90<T, U extends Collection<? super T>> extends x80<T, U> {
    public final boolean Wwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwww;
    public final Callable<U> Wwwwwwwwwwwwwwwwwww;
    public final k60 Wwwwwwwwwwwwwwwwwwww;
    public final TimeUnit Wwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, U extends Collection<? super T>> extends e80<T, U, U> implements Runnable, p60 {
        public p60 Wwwwwwwwwwww;
        public final List<U> Wwwwwwwwwwwww = new LinkedList();
        public final k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwww;
        public final TimeUnit Wwwwwwwwwwwwwww;
        public final long Wwwwwwwwwwwwwwww;
        public final long Wwwwwwwwwwwwwwwww;
        public final Callable<U> Wwwwwwwwwwwwwwwwww;

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
            public final /* synthetic */ Collection Wwwwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Collection collection) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = collection;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwww.remove(this.Wwwwwwwwwwwwwwwwwwwwwwww);
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, false, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwww);
            }
        }

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
            public final /* synthetic */ Collection Wwwwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Collection collection) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = collection;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwww.remove(this.Wwwwwwwwwwwwwwwwwwwwwwww);
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, false, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwww);
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60<? super U> j60Var, Callable<U> callable, long j, long j2, TimeUnit timeUnit, k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            super(j60Var, new MpscLinkedQueue());
            this.Wwwwwwwwwwwwwwwwww = callable;
            this.Wwwwwwwwwwwwwwwww = j;
            this.Wwwwwwwwwwwwwwww = j2;
            this.Wwwwwwwwwwwwwww = timeUnit;
            this.Wwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            synchronized (this) {
                this.Wwwwwwwwwwwww.clear();
            }
        }

        @Override // me.tvspark.e80
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60 j60Var, Object obj) {
            j60Var.onNext((Collection) obj);
        }

        @Override // me.tvspark.p60
        public void dispose() {
            if (!this.Wwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwww = true;
                this.Wwwwwwwwwwwwww.dispose();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                this.Wwwwwwwwwwww.dispose();
            }
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.Wwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            ArrayList arrayList;
            synchronized (this) {
                arrayList = new ArrayList(this.Wwwwwwwwwwwww);
                this.Wwwwwwwwwwwww.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.Wwwwwwwwwwwwwwwwwwwwww.offer((Collection) it.next());
            }
            this.Wwwwwwwwwwwwwwwwwwww = true;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((t70) this.Wwwwwwwwwwwwwwwwwwwwww, (j60) this.Wwwwwwwwwwwwwwwwwwwwwww, false, (p60) this.Wwwwwwwwwwwwww, (e80) this);
            }
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            this.Wwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwww.dispose();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwwwwwwwwwww.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            synchronized (this) {
                for (U u : this.Wwwwwwwwwwwww) {
                    u.add(t);
                }
            }
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.Wwwwwwwwwwww, p60Var)) {
                this.Wwwwwwwwwwww = p60Var;
                try {
                    U call = this.Wwwwwwwwwwwwwwwwww.call();
                    l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, "The buffer supplied is null");
                    U u = call;
                    this.Wwwwwwwwwwwww.add(u);
                    this.Wwwwwwwwwwwwwwwwwwwwwww.onSubscribe(this);
                    k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwww;
                    long j = this.Wwwwwwwwwwwwwwww;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, j, j, this.Wwwwwwwwwwwwwww);
                    this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(u), this.Wwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwww);
                } catch (Throwable th) {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                    this.Wwwwwwwwwwwwww.dispose();
                    p60Var.dispose();
                    EmptyDisposable.error(th, this.Wwwwwwwwwwwwwwwwwwwwwww);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.Wwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            try {
                U call = this.Wwwwwwwwwwwwwwwwww.call();
                l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, "The bufferSupplier returned a null buffer");
                U u = call;
                synchronized (this) {
                    if (this.Wwwwwwwwwwwwwwwwwwwww) {
                        return;
                    }
                    this.Wwwwwwwwwwwww.add(u);
                    this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(u), this.Wwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwww);
                }
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                dispose();
                this.Wwwwwwwwwwwwwwwwwwwwwww.onError(th);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, U extends Collection<? super T>> extends e80<T, U, U> implements Runnable, p60 {
        public final AtomicReference<p60> Wwwwwwwwwwww = new AtomicReference<>();
        public U Wwwwwwwwwwwww;
        public p60 Wwwwwwwwwwwwww;
        public final k60 Wwwwwwwwwwwwwww;
        public final TimeUnit Wwwwwwwwwwwwwwww;
        public final long Wwwwwwwwwwwwwwwww;
        public final Callable<U> Wwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60<? super U> j60Var, Callable<U> callable, long j, TimeUnit timeUnit, k60 k60Var) {
            super(j60Var, new MpscLinkedQueue());
            this.Wwwwwwwwwwwwwwwwww = callable;
            this.Wwwwwwwwwwwwwwwww = j;
            this.Wwwwwwwwwwwwwwww = timeUnit;
            this.Wwwwwwwwwwwwwww = k60Var;
        }

        @Override // me.tvspark.e80
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60 j60Var, Object obj) {
            this.Wwwwwwwwwwwwwwwwwwwwwww.onNext((Collection) obj);
        }

        @Override // me.tvspark.p60
        public void dispose() {
            DisposableHelper.dispose(this.Wwwwwwwwwwww);
            this.Wwwwwwwwwwwwww.dispose();
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.Wwwwwwwwwwww.get() == DisposableHelper.DISPOSED;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            U u;
            DisposableHelper.dispose(this.Wwwwwwwwwwww);
            synchronized (this) {
                u = this.Wwwwwwwwwwwww;
                this.Wwwwwwwwwwwww = null;
            }
            if (u != null) {
                this.Wwwwwwwwwwwwwwwwwwwwww.offer(u);
                this.Wwwwwwwwwwwwwwwwwwww = true;
                if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    return;
                }
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((t70) this.Wwwwwwwwwwwwwwwwwwwwww, (j60) this.Wwwwwwwwwwwwwwwwwwwwwww, false, (p60) this, (e80) this);
            }
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.Wwwwwwwwwwww);
            synchronized (this) {
                this.Wwwwwwwwwwwww = null;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwww.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            synchronized (this) {
                U u = this.Wwwwwwwwwwwww;
                if (u == null) {
                    return;
                }
                u.add(t);
            }
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.Wwwwwwwwwwwwww, p60Var)) {
                this.Wwwwwwwwwwwwww = p60Var;
                try {
                    U call = this.Wwwwwwwwwwwwwwwwww.call();
                    l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, "The buffer supplied is null");
                    this.Wwwwwwwwwwwww = call;
                    this.Wwwwwwwwwwwwwwwwwwwwwww.onSubscribe(this);
                    if (this.Wwwwwwwwwwwwwwwwwwwww) {
                        return;
                    }
                    k60 k60Var = this.Wwwwwwwwwwwwwww;
                    long j = this.Wwwwwwwwwwwwwwwww;
                    p60 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = k60Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, j, j, this.Wwwwwwwwwwwwwwww);
                    if (this.Wwwwwwwwwwww.compareAndSet(null, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                        return;
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.dispose();
                } catch (Throwable th) {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                    dispose();
                    EmptyDisposable.error(th, this.Wwwwwwwwwwwwwwwwwwwwwww);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            U u;
            try {
                U call = this.Wwwwwwwwwwwwwwwwww.call();
                l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, "The bufferSupplier returned a null buffer");
                U u2 = call;
                synchronized (this) {
                    u = this.Wwwwwwwwwwwww;
                    if (u != null) {
                        this.Wwwwwwwwwwwww = u2;
                    }
                }
                if (u == null) {
                    DisposableHelper.dispose(this.Wwwwwwwwwwww);
                } else {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(u, false, this);
                }
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                dispose();
                this.Wwwwwwwwwwwwwwwwwwwwwww.onError(th);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, U extends Collection<? super T>> extends e80<T, U, U> implements Runnable, p60 {
        public long Wwwwwwww;
        public long Wwwwwwwww;
        public p60 Wwwwwwwwww;
        public p60 Wwwwwwwwwww;
        public U Wwwwwwwwwwww;
        public final k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwww;
        public final boolean Wwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwww;
        public final TimeUnit Wwwwwwwwwwwwwwww;
        public final long Wwwwwwwwwwwwwwwww;
        public final Callable<U> Wwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60<? super U> j60Var, Callable<U> callable, long j, TimeUnit timeUnit, int i, boolean z, k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            super(j60Var, new MpscLinkedQueue());
            this.Wwwwwwwwwwwwwwwwww = callable;
            this.Wwwwwwwwwwwwwwwww = j;
            this.Wwwwwwwwwwwwwwww = timeUnit;
            this.Wwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwww = z;
            this.Wwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.e80
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60 j60Var, Object obj) {
            j60Var.onNext((Collection) obj);
        }

        @Override // me.tvspark.p60
        public void dispose() {
            if (!this.Wwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwww = true;
                this.Wwwwwwwwwwwww.dispose();
                synchronized (this) {
                    this.Wwwwwwwwwwww = null;
                }
                this.Wwwwwwwwww.dispose();
            }
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.Wwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            U u;
            this.Wwwwwwwwwwwww.dispose();
            synchronized (this) {
                u = this.Wwwwwwwwwwww;
                this.Wwwwwwwwwwww = null;
            }
            this.Wwwwwwwwwwwwwwwwwwwwww.offer(u);
            this.Wwwwwwwwwwwwwwwwwwww = true;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((t70) this.Wwwwwwwwwwwwwwwwwwwwww, (j60) this.Wwwwwwwwwwwwwwwwwwwwwww, false, (p60) this, (e80) this);
            }
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            this.Wwwwwwwwwwwww.dispose();
            synchronized (this) {
                this.Wwwwwwwwwwww = null;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwww.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            synchronized (this) {
                U u = this.Wwwwwwwwwwww;
                if (u == null) {
                    return;
                }
                u.add(t);
                if (u.size() < this.Wwwwwwwwwwwwwww) {
                    return;
                }
                if (this.Wwwwwwwwwwwwww) {
                    this.Wwwwwwwwwwww = null;
                    this.Wwwwwwwww++;
                    this.Wwwwwwwwwww.dispose();
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(u, false, this);
                try {
                    U call = this.Wwwwwwwwwwwwwwwwww.call();
                    l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, "The buffer supplied is null");
                    U u2 = call;
                    boolean z = this.Wwwwwwwwwwwwww;
                    synchronized (this) {
                        if (!z) {
                            this.Wwwwwwwwwwww = u2;
                            return;
                        }
                        this.Wwwwwwwwwwww = u2;
                        this.Wwwwwwww++;
                        k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwww;
                        long j = this.Wwwwwwwwwwwwwwwww;
                        this.Wwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, j, j, this.Wwwwwwwwwwwwwwww);
                    }
                } catch (Throwable th) {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                    dispose();
                    this.Wwwwwwwwwwwwwwwwwwwwwww.onError(th);
                }
            }
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.Wwwwwwwwww, p60Var)) {
                this.Wwwwwwwwww = p60Var;
                try {
                    U call = this.Wwwwwwwwwwwwwwwwww.call();
                    l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, "The buffer supplied is null");
                    this.Wwwwwwwwwwww = call;
                    this.Wwwwwwwwwwwwwwwwwwwwwww.onSubscribe(this);
                    k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwww;
                    long j = this.Wwwwwwwwwwwwwwwww;
                    this.Wwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, j, j, this.Wwwwwwwwwwwwwwww);
                } catch (Throwable th) {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                    this.Wwwwwwwwwwwww.dispose();
                    p60Var.dispose();
                    EmptyDisposable.error(th, this.Wwwwwwwwwwwwwwwwwwwwwww);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                U call = this.Wwwwwwwwwwwwwwwwww.call();
                l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, "The bufferSupplier returned a null buffer");
                U u = call;
                synchronized (this) {
                    U u2 = this.Wwwwwwwwwwww;
                    if (u2 != null && this.Wwwwwwwww == this.Wwwwwwww) {
                        this.Wwwwwwwwwwww = u;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(u2, false, this);
                    }
                }
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                dispose();
                this.Wwwwwwwwwwwwwwwwwwwwwww.onError(th);
            }
        }
    }

    public j90(h60<T> h60Var, long j, long j2, TimeUnit timeUnit, k60 k60Var, Callable<U> callable, int i, boolean z) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = j;
        this.Wwwwwwwwwwwwwwwwwwwwww = j2;
        this.Wwwwwwwwwwwwwwwwwwwww = timeUnit;
        this.Wwwwwwwwwwwwwwwwwwww = k60Var;
        this.Wwwwwwwwwwwwwwwwwww = callable;
        this.Wwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwww = z;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super U> j60Var) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwww == this.Wwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwww == Integer.MAX_VALUE) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new md0(j60Var), this.Wwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwww));
            return;
        }
        k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        int i = (this.Wwwwwwwwwwwwwwwwwwwwwww > this.Wwwwwwwwwwwwwwwwwwwwww ? 1 : (this.Wwwwwwwwwwwwwwwwwwwwwww == this.Wwwwwwwwwwwwwwwwwwwwww ? 0 : -1));
        h60<T> h60Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (i == 0) {
            h60Var.subscribe(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new md0(j60Var), this.Wwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2));
        } else {
            h60Var.subscribe(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new md0(j60Var), this.Wwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2));
        }
    }
}
