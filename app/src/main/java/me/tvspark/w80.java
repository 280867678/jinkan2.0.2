package me.tvspark;

/* loaded from: classes4.dex */
public interface w80<T> extends t70<T> {
    int consumerIndex();

    void drop();

    T peek();

    @Override // java.util.Queue, me.tvspark.w80, me.tvspark.t70
    /* renamed from: poll */
    T mo4868poll();

    int producerIndex();
}
