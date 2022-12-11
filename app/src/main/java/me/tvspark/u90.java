package me.tvspark;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Collection;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class u90<T, K> extends x80<T, T> {
    public final Callable<? extends Collection<? super K>> Wwwwwwwwwwwwwwwwwwwwww;
    public final f70<? super T, K> Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, K> extends u70<T, T> {
        public final f70<? super T, K> Wwwwwwwwwwwwwwwwww;
        public final Collection<? super K> Wwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60<? super T> j60Var, f70<? super T, K> f70Var, Collection<? super K> collection) {
            super(j60Var);
            this.Wwwwwwwwwwwwwwwwww = f70Var;
            this.Wwwwwwwwwwwwwwwwwww = collection;
        }

        @Override // me.tvspark.u70, me.tvspark.t70
        public void clear() {
            this.Wwwwwwwwwwwwwwwwwww.clear();
            super.clear();
        }

        @Override // me.tvspark.u70, me.tvspark.j60
        public void onComplete() {
            if (!this.Wwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwww = true;
                this.Wwwwwwwwwwwwwwwwwww.clear();
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onComplete();
            }
        }

        @Override // me.tvspark.u70, me.tvspark.j60
        public void onError(Throwable th) {
            if (this.Wwwwwwwwwwwwwwwwwwwww) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwww.clear();
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            if (this.Wwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            if (this.Wwwwwwwwwwwwwwwwwwww != 0) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onNext(null);
                return;
            }
            try {
                K apply = this.Wwwwwwwwwwwwwwwwww.apply(t);
                l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, "The keySelector returned a null key");
                if (!this.Wwwwwwwwwwwwwwwwwww.add(apply)) {
                    return;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onNext(t);
            } catch (Throwable th) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            }
        }

        @Override // me.tvspark.t70
        /* renamed from: poll */
        public T mo4868poll() throws Exception {
            T mo4868poll;
            Collection<? super K> collection;
            Object obj;
            do {
                mo4868poll = this.Wwwwwwwwwwwwwwwwwwwwww.mo4868poll();
                if (mo4868poll == null) {
                    break;
                }
                collection = this.Wwwwwwwwwwwwwwwwwww;
                obj = (K) this.Wwwwwwwwwwwwwwwwww.apply(mo4868poll);
                l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, "The keySelector returned a null key");
            } while (!collection.add(obj));
            return mo4868poll;
        }

        @Override // me.tvspark.p70
        public int requestFusion(int i) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        }
    }

    public u90(h60<T> h60Var, f70<? super T, K> f70Var, Callable<? extends Collection<? super K>> callable) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = f70Var;
        this.Wwwwwwwwwwwwwwwwwwwwww = callable;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        try {
            Collection<? super K> call = this.Wwwwwwwwwwwwwwwwwwwwww.call();
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
            this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60Var, this.Wwwwwwwwwwwwwwwwwwwwwww, call));
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            EmptyDisposable.error(th, j60Var);
        }
    }
}
