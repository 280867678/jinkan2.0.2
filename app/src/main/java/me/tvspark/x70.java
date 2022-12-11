package me.tvspark;

/* loaded from: classes4.dex */
public final class x70<T> extends w70<T> {
    @Override // me.tvspark.j60
    public void onError(Throwable th) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww == null) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = th;
        }
        countDown();
    }

    @Override // me.tvspark.j60
    public void onNext(T t) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww == null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = t;
            this.Wwwwwwwwwwwwwwwwwwwwww.dispose();
            countDown();
        }
    }
}
