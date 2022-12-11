package me.tvspark;

import io.reactivex.internal.operators.flowable.FlowableGroupBy$GroupBySubscriber;
import io.reactivex.internal.operators.flowable.FlowableGroupBy$State;

/* loaded from: classes4.dex */
public final class o80<K, T> extends q60<K, T> {
    public final FlowableGroupBy$State<T, K> Wwwwwwwwwwwwwwwwwwwwww;

    public o80(K k, FlowableGroupBy$State<T, K> flowableGroupBy$State) {
        super(k);
        this.Wwwwwwwwwwwwwwwwwwwwww = flowableGroupBy$State;
    }

    public static <T, K> o80<K, T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(K k, int i, FlowableGroupBy$GroupBySubscriber<?, K, T> flowableGroupBy$GroupBySubscriber, boolean z) {
        return new o80<>(k, new FlowableGroupBy$State(i, flowableGroupBy$GroupBySubscriber, k, z));
    }

    @Override // me.tvspark.x50
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s51<? super T> s51Var) {
        this.Wwwwwwwwwwwwwwwwwwwwww.subscribe(s51Var);
    }
}
