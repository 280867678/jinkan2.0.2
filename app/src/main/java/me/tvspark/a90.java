package me.tvspark;

import io.reactivex.internal.util.NotificationLite;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class a90<T> implements Iterable<T> {
    public final T Wwwwwwwwwwwwwwwwwwwwwww;
    public final h60<T> Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> extends jd0<T> {
        public volatile Object Wwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T t) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = NotificationLite.next(t);
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            this.Wwwwwwwwwwwwwwwwwwwwwww = NotificationLite.complete();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = NotificationLite.error(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = NotificationLite.next(t);
        }
    }

    public a90(h60<T> h60Var, T t) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = h60Var;
        this.Wwwwwwwwwwwwwwwwwwwwwww = t;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        return new z80(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }
}
