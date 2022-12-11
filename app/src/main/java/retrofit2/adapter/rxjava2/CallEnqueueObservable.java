package retrofit2.adapter.rxjava2;

import io.reactivex.exceptions.CompositeException;
import me.tvspark.d60;
import me.tvspark.j60;
import me.tvspark.p60;
import me.tvspark.r40;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes5.dex */
public final class CallEnqueueObservable<T> extends d60<Response<T>> {
    public final Call<T> originalCall;

    /* loaded from: classes5.dex */
    public static final class CallCallback<T> implements p60, Callback<T> {
        public final Call<?> call;
        public volatile boolean disposed;
        public final j60<? super Response<T>> observer;
        public boolean terminated = false;

        public CallCallback(Call<?> call, j60<? super Response<T>> j60Var) {
            this.call = call;
            this.observer = j60Var;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            this.disposed = true;
            this.call.cancel();
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<T> call, Throwable th) {
            if (call.isCanceled()) {
                return;
            }
            try {
                this.observer.onError(th);
            } catch (Throwable th2) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) new CompositeException(th, th2));
            }
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<T> call, Response<T> response) {
            if (this.disposed) {
                return;
            }
            try {
                this.observer.onNext(response);
                if (this.disposed) {
                    return;
                }
                this.terminated = true;
                this.observer.onComplete();
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                if (this.terminated) {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                } else if (this.disposed) {
                } else {
                    try {
                        this.observer.onError(th);
                    } catch (Throwable th2) {
                        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
                        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) new CompositeException(th, th2));
                    }
                }
            }
        }
    }

    public CallEnqueueObservable(Call<T> call) {
        this.originalCall = call;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super Response<T>> j60Var) {
        Call<T> mo5340clone = this.originalCall.mo5340clone();
        CallCallback callCallback = new CallCallback(mo5340clone, j60Var);
        j60Var.onSubscribe(callCallback);
        if (!callCallback.isDisposed()) {
            mo5340clone.enqueue(callCallback);
        }
    }
}
