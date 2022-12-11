package me.tvspark;

import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes4.dex */
public abstract class jd0<T> implements j60<T> {
    public p60 Wwwwwwwwwwwwwwwwwwwwwwww;

    @Override // me.tvspark.j60
    public final void onSubscribe(p60 p60Var) {
        if (DisposableHelper.validate(this.Wwwwwwwwwwwwwwwwwwwwwwww, p60Var)) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = p60Var;
        }
    }
}
