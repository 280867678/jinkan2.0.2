package me.tvspark;

import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes4.dex */
public abstract class u70<T, R> implements j60<T>, o70<R> {
    public int Wwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwww;
    public o70<T> Wwwwwwwwwwwwwwwwwwwwww;
    public p60 Wwwwwwwwwwwwwwwwwwwwwww;
    public final j60<? super R> Wwwwwwwwwwwwwwwwwwwwwwww;

    public u70(j60<? super R> j60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = j60Var;
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        o70<T> o70Var = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (o70Var == null || (i & 4) != 0) {
            return 0;
        }
        int requestFusion = o70Var.requestFusion(i);
        if (requestFusion != 0) {
            this.Wwwwwwwwwwwwwwwwwwww = requestFusion;
        }
        return requestFusion;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Throwable th) {
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
        this.Wwwwwwwwwwwwwwwwwwwwwww.dispose();
        onError(th);
    }

    @Override // me.tvspark.t70
    public void clear() {
        this.Wwwwwwwwwwwwwwwwwwwwww.clear();
    }

    @Override // me.tvspark.p60
    public void dispose() {
        this.Wwwwwwwwwwwwwwwwwwwwwww.dispose();
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww.isDisposed();
    }

    @Override // me.tvspark.t70
    public boolean isEmpty() {
        return this.Wwwwwwwwwwwwwwwwwwwwww.isEmpty();
    }

    @Override // me.tvspark.t70
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // me.tvspark.j60
    public void onComplete() {
        if (this.Wwwwwwwwwwwwwwwwwwwww) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwww = true;
        this.Wwwwwwwwwwwwwwwwwwwwwwww.onComplete();
    }

    @Override // me.tvspark.j60
    public void onError(Throwable th) {
        if (this.Wwwwwwwwwwwwwwwwwwwww) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwww = true;
        this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(th);
    }

    @Override // me.tvspark.j60
    public final void onSubscribe(p60 p60Var) {
        if (DisposableHelper.validate(this.Wwwwwwwwwwwwwwwwwwwwwww, p60Var)) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = p60Var;
            if (p60Var instanceof o70) {
                this.Wwwwwwwwwwwwwwwwwwwwww = (o70) p60Var;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onSubscribe(this);
        }
    }
}
