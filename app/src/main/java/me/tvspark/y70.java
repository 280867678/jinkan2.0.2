package me.tvspark;

/* loaded from: classes4.dex */
public final class y70<T> extends w70<T> {
    @Override // me.tvspark.j60
    public void onError(Throwable th) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwwwwwwwwwwww = th;
        countDown();
    }

    @Override // me.tvspark.j60
    public void onNext(T t) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = t;
    }
}
