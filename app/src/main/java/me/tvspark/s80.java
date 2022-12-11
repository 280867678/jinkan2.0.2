package me.tvspark;

import io.reactivex.internal.operators.flowable.FlowableSamplePublisher$SamplePublisherSubscriber;

/* loaded from: classes4.dex */
public final class s80<T> implements s51<Object> {
    public final FlowableSamplePublisher$SamplePublisherSubscriber<T> Wwwwwwwwwwwwwwwwwwwwwwww;

    public s80(FlowableSamplePublisher$SamplePublisherSubscriber<T> flowableSamplePublisher$SamplePublisherSubscriber) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = flowableSamplePublisher$SamplePublisherSubscriber;
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.complete();
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.error(th);
    }

    @Override // me.tvspark.s51
    public void onNext(Object obj) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.emit();
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww.setOther(t51Var)) {
            t51Var.request(Long.MAX_VALUE);
        }
    }
}
