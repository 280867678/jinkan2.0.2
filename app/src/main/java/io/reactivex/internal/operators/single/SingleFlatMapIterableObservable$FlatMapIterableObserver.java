package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import java.util.Iterator;
import me.tvspark.f70;
import me.tvspark.j60;
import me.tvspark.l70;
import me.tvspark.m60;
import me.tvspark.p60;
import me.tvspark.r40;

/* loaded from: classes4.dex */
public final class SingleFlatMapIterableObservable$FlatMapIterableObserver<T, R> extends BasicIntQueueDisposable<R> implements m60<T> {
    public static final long serialVersionUID = -8938804753851907758L;
    public final j60<? super R> actual;
    public volatile boolean cancelled;

    /* renamed from: d */
    public p60 f4469d;

    /* renamed from: it */
    public volatile Iterator<? extends R> f4470it;
    public final f70<? super T, ? extends Iterable<? extends R>> mapper;
    public boolean outputFused;

    public SingleFlatMapIterableObservable$FlatMapIterableObserver(j60<? super R> j60Var, f70<? super T, ? extends Iterable<? extends R>> f70Var) {
        this.actual = j60Var;
        this.mapper = f70Var;
    }

    @Override // me.tvspark.t70
    public void clear() {
        this.f4470it = null;
    }

    @Override // me.tvspark.p60
    public void dispose() {
        this.cancelled = true;
        this.f4469d.dispose();
        this.f4469d = DisposableHelper.DISPOSED;
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // me.tvspark.t70
    public boolean isEmpty() {
        return this.f4470it == null;
    }

    @Override // me.tvspark.m60
    public void onError(Throwable th) {
        this.f4469d = DisposableHelper.DISPOSED;
        this.actual.onError(th);
    }

    @Override // me.tvspark.m60
    public void onSubscribe(p60 p60Var) {
        if (DisposableHelper.validate(this.f4469d, p60Var)) {
            this.f4469d = p60Var;
            this.actual.onSubscribe(this);
        }
    }

    @Override // me.tvspark.m60
    public void onSuccess(T t) {
        j60<? super R> j60Var = this.actual;
        try {
            Iterator<? extends R> it = this.mapper.apply(t).iterator();
            if (!it.hasNext()) {
                j60Var.onComplete();
            } else if (this.outputFused) {
                this.f4470it = it;
                j60Var.onNext(null);
                j60Var.onComplete();
            } else {
                while (!this.cancelled) {
                    try {
                        j60Var.onNext((R) it.next());
                        if (this.cancelled) {
                            return;
                        }
                        if (!it.hasNext()) {
                            j60Var.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        th = th;
                        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                        j60Var.onError(th);
                        return;
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            j60Var = this.actual;
        }
    }

    @Override // me.tvspark.t70
    /* renamed from: poll */
    public R mo4868poll() throws Exception {
        Iterator<? extends R> it = this.f4470it;
        if (it != null) {
            R next = it.next();
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next, "The iterator returned a null value");
            if (!it.hasNext()) {
                this.f4470it = null;
            }
            return next;
        }
        return null;
    }

    @Override // me.tvspark.p70
    public int requestFusion(int i) {
        if ((i & 2) != 0) {
            this.outputFused = true;
            return 2;
        }
        return 0;
    }
}
