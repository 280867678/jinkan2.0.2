package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import me.tvspark.h60;
import me.tvspark.j60;
import me.tvspark.l70;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.x80;

/* loaded from: classes4.dex */
public final class ObservableBuffer<T, U extends Collection<? super T>> extends x80<T, U> {
    public final Callable<U> Wwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class BufferSkipObserver<T, U extends Collection<? super T>> extends AtomicBoolean implements j60<T>, p60 {
        public static final long serialVersionUID = -8223395059921494546L;
        public final j60<? super U> actual;
        public final Callable<U> bufferSupplier;
        public final ArrayDeque<U> buffers = new ArrayDeque<>();
        public final int count;
        public long index;

        /* renamed from: s */
        public p60 f4422s;
        public final int skip;

        public BufferSkipObserver(j60<? super U> j60Var, int i, int i2, Callable<U> callable) {
            this.actual = j60Var;
            this.count = i;
            this.skip = i2;
            this.bufferSupplier = callable;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            this.f4422s.dispose();
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.f4422s.isDisposed();
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            while (!this.buffers.isEmpty()) {
                this.actual.onNext(this.buffers.poll());
            }
            this.actual.onComplete();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            this.buffers.clear();
            this.actual.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            long j = this.index;
            this.index = 1 + j;
            if (j % this.skip == 0) {
                try {
                    U call = this.bufferSupplier.call();
                    l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, "The bufferSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
                    this.buffers.offer(call);
                } catch (Throwable th) {
                    this.buffers.clear();
                    this.f4422s.dispose();
                    this.actual.onError(th);
                    return;
                }
            }
            Iterator<U> it = this.buffers.iterator();
            while (it.hasNext()) {
                U next = it.next();
                next.add(t);
                if (this.count <= next.size()) {
                    it.remove();
                    this.actual.onNext(next);
                }
            }
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.f4422s, p60Var)) {
                this.f4422s = p60Var;
                this.actual.onSubscribe(this);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, U extends Collection<? super T>> implements j60<T>, p60 {
        public p60 Wwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwww;
        public U Wwwwwwwwwwwwwwwwwwwww;
        public final Callable<U> Wwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwww;
        public final j60<? super U> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60<? super U> j60Var, int i, Callable<U> callable) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = j60Var;
            this.Wwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwww = callable;
        }

        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            try {
                U call = this.Wwwwwwwwwwwwwwwwwwwwww.call();
                l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, "Empty buffer supplied");
                this.Wwwwwwwwwwwwwwwwwwwww = call;
                return true;
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                this.Wwwwwwwwwwwwwwwwwwwww = null;
                p60 p60Var = this.Wwwwwwwwwwwwwwwwwww;
                if (p60Var == null) {
                    EmptyDisposable.error(th, this.Wwwwwwwwwwwwwwwwwwwwwwww);
                    return false;
                }
                p60Var.dispose();
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(th);
                return false;
            }
        }

        @Override // me.tvspark.p60
        public void dispose() {
            this.Wwwwwwwwwwwwwwwwwww.dispose();
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.Wwwwwwwwwwwwwwwwwww.isDisposed();
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            U u = this.Wwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwww = null;
            if (u != null && !u.isEmpty()) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onNext(u);
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onComplete();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            this.Wwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            U u = this.Wwwwwwwwwwwwwwwwwwwww;
            if (u != null) {
                u.add(t);
                int i = this.Wwwwwwwwwwwwwwwwwwww + 1;
                this.Wwwwwwwwwwwwwwwwwwww = i;
                if (i < this.Wwwwwwwwwwwwwwwwwwwwwww) {
                    return;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onNext(u);
                this.Wwwwwwwwwwwwwwwwwwww = 0;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.Wwwwwwwwwwwwwwwwwww, p60Var)) {
                this.Wwwwwwwwwwwwwwwwwww = p60Var;
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onSubscribe(this);
            }
        }
    }

    public ObservableBuffer(h60<T> h60Var, int i, int i2, Callable<U> callable) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwww = i2;
        this.Wwwwwwwwwwwwwwwwwwwww = callable;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super U> j60Var) {
        int i = this.Wwwwwwwwwwwwwwwwwwwwww;
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (i != i2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new BufferSkipObserver(j60Var, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww));
            return;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60Var, i2, this.Wwwwwwwwwwwwwwwwwwwww);
        if (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }
}
