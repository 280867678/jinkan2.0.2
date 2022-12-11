package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import me.tvspark.c60;
import me.tvspark.r40;
import me.tvspark.s51;

/* loaded from: classes4.dex */
public final class FlowableMaterialize$MaterializeSubscriber<T> extends SinglePostCompleteSubscriber<T, c60<T>> {
    public static final long serialVersionUID = -3740826063558713822L;

    public FlowableMaterialize$MaterializeSubscriber(s51<? super c60<T>> s51Var) {
        super(s51Var);
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        complete(c60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber
    public /* bridge */ /* synthetic */ void onDrop(Object obj) {
        onDrop((c60) ((c60) obj));
    }

    public void onDrop(c60<T> c60Var) {
        if (c60Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c60Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        complete(c60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th));
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        this.produced++;
        this.actual.onNext(c60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t));
    }
}
