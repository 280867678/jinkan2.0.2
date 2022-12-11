package me.tvspark;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public final class g90<T, U extends Collection<? super T>, Open, Close> extends x80<T, U> {
    public final f70<? super Open, ? extends h60<? extends Close>> Wwwwwwwwwwwwwwwwwwwww;
    public final h60<? extends Open> Wwwwwwwwwwwwwwwwwwwwww;
    public final Callable<U> Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, U extends Collection<? super T>, Open, Close> extends kd0<Open> {
        public boolean Wwwwwwwwwwwwwwwwwwwwww;
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, U, Open, Close> Wwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, U, Open, Close> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            if (this.Wwwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwww = true;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, U, Open, Close> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this) || wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwww.decrementAndGet() != 0) {
                return;
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
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
        public void onNext(Open open) {
            if (this.Wwwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, U, Open, Close>) open);
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, U extends Collection<? super T>, Open, Close> extends kd0<Close> {
        public boolean Wwwwwwwwwwwwwwwwwwwww;
        public final U Wwwwwwwwwwwwwwwwwwwwww;
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, U, Open, Close> Wwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(U u, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, U, Open, Close> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwww = u;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            if (this.Wwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, U, Open, Close>) this.Wwwwwwwwwwwwwwwwwwwwww, (p60) this);
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            if (this.Wwwwwwwwwwwwwwwwwwwww) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            } else {
                this.Wwwwwwwwwwwwwwwwwwwwwww.onError(th);
            }
        }

        @Override // me.tvspark.j60
        public void onNext(Close close) {
            onComplete();
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, U extends Collection<? super T>, Open, Close> extends e80<T, U, U> implements p60 {
        public p60 Wwwwwwwwwwwwww;
        public final Callable<U> Wwwwwwwwwwwwwwww;
        public final f70<? super Open, ? extends h60<? extends Close>> Wwwwwwwwwwwwwwwww;
        public final h60<? extends Open> Wwwwwwwwwwwwwwwwww;
        public final AtomicInteger Wwwwwwwwwwww = new AtomicInteger();
        public final List<U> Wwwwwwwwwwwww = new LinkedList();
        public final o60 Wwwwwwwwwwwwwww = new o60();

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60<? super U> j60Var, h60<? extends Open> h60Var, f70<? super Open, ? extends h60<? extends Close>> f70Var, Callable<U> callable) {
            super(j60Var, new MpscLinkedQueue());
            this.Wwwwwwwwwwwwwwwwww = h60Var;
            this.Wwwwwwwwwwwwwwwww = f70Var;
            this.Wwwwwwwwwwwwwwww = callable;
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            ArrayList arrayList;
            synchronized (this) {
                arrayList = new ArrayList(this.Wwwwwwwwwwwww);
                this.Wwwwwwwwwwwww.clear();
            }
            t70<U> t70Var = this.Wwwwwwwwwwwwwwwwwwwwww;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                t70Var.offer((Collection) it.next());
            }
            this.Wwwwwwwwwwwwwwwwwwww = true;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((t70) t70Var, (j60) this.Wwwwwwwwwwwwwwwwwwwwwww, false, (p60) this, (e80) this);
            }
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Open open) {
            if (this.Wwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            try {
                U call = this.Wwwwwwwwwwwwwwww.call();
                l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, "The buffer supplied is null");
                U u = call;
                try {
                    h60<? extends Close> apply = this.Wwwwwwwwwwwwwwwww.apply(open);
                    l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, "The buffer closing Observable is null");
                    h60<? extends Close> h60Var = apply;
                    if (this.Wwwwwwwwwwwwwwwwwwwww) {
                        return;
                    }
                    synchronized (this) {
                        if (this.Wwwwwwwwwwwwwwwwwwwww) {
                            return;
                        }
                        this.Wwwwwwwwwwwww.add(u);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(u, this);
                        this.Wwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        this.Wwwwwwwwwwww.getAndIncrement();
                        h60Var.subscribe(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    }
                } catch (Throwable th) {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                    onError(th);
                }
            } catch (Throwable th2) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
                onError(th2);
            }
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(U u, p60 p60Var) {
            boolean remove;
            synchronized (this) {
                remove = this.Wwwwwwwwwwwww.remove(u);
            }
            if (remove) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(u, false, this);
            }
            if (!this.Wwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(p60Var) || this.Wwwwwwwwwwww.decrementAndGet() != 0) {
                return;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // me.tvspark.e80
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60 j60Var, Object obj) {
            j60Var.onNext((Collection) obj);
        }

        @Override // me.tvspark.p60
        public void dispose() {
            if (!this.Wwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwww = true;
                this.Wwwwwwwwwwwwwww.dispose();
            }
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.Wwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            if (this.Wwwwwwwwwwww.decrementAndGet() == 0) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            dispose();
            this.Wwwwwwwwwwwwwwwwwwwww = true;
            synchronized (this) {
                this.Wwwwwwwwwwwww.clear();
            }
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
            if (DisposableHelper.validate(this.Wwwwwwwwwwwwww, p60Var)) {
                this.Wwwwwwwwwwwwww = p60Var;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
                this.Wwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwwwwwww.onSubscribe(this);
                this.Wwwwwwwwwwww.lazySet(1);
                this.Wwwwwwwwwwwwwwwwww.subscribe(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }
    }

    public g90(h60<T> h60Var, h60<? extends Open> h60Var2, f70<? super Open, ? extends h60<? extends Close>> f70Var, Callable<U> callable) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwww = h60Var2;
        this.Wwwwwwwwwwwwwwwwwwwww = f70Var;
        this.Wwwwwwwwwwwwwwwwwwwwwww = callable;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super U> j60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new md0(j60Var), this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww));
    }
}
