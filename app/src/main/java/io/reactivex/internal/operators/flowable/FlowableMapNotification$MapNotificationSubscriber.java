package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import java.util.concurrent.Callable;
import me.tvspark.f70;
import me.tvspark.l70;
import me.tvspark.r40;
import me.tvspark.s51;

/* loaded from: classes4.dex */
public final class FlowableMapNotification$MapNotificationSubscriber<T, R> extends SinglePostCompleteSubscriber<T, R> {
    public static final long serialVersionUID = 2757120512858778108L;
    public final Callable<? extends R> onCompleteSupplier;
    public final f70<? super Throwable, ? extends R> onErrorMapper;
    public final f70<? super T, ? extends R> onNextMapper;

    public FlowableMapNotification$MapNotificationSubscriber(s51<? super R> s51Var, f70<? super T, ? extends R> f70Var, f70<? super Throwable, ? extends R> f70Var2, Callable<? extends R> callable) {
        super(s51Var);
        this.onNextMapper = f70Var;
        this.onErrorMapper = f70Var2;
        this.onCompleteSupplier = callable;
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        try {
            R call = this.onCompleteSupplier.call();
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, "The onComplete publisher returned is null");
            complete(call);
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            this.actual.onError(th);
        }
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        try {
            R apply = this.onErrorMapper.apply(th);
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, "The onError publisher returned is null");
            complete(apply);
        } catch (Throwable th2) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
            this.actual.onError(th2);
        }
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        try {
            R apply = this.onNextMapper.apply(t);
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, "The onNext publisher returned is null");
            this.produced++;
            this.actual.onNext(apply);
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            this.actual.onError(th);
        }
    }
}
