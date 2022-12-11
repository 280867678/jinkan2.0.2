package retrofit2.adapter.rxjava2;

import io.reactivex.exceptions.CompositeException;
import me.tvspark.d60;
import me.tvspark.j60;
import me.tvspark.p60;
import me.tvspark.r40;
import retrofit2.Call;
import retrofit2.Response;

/* loaded from: classes5.dex */
public final class CallExecuteObservable<T> extends d60<Response<T>> {
    public final Call<T> originalCall;

    /* loaded from: classes5.dex */
    public static final class CallDisposable implements p60 {
        public final Call<?> call;
        public volatile boolean disposed;

        public CallDisposable(Call<?> call) {
            this.call = call;
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
    }

    public CallExecuteObservable(Call<T> call) {
        this.originalCall = call;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super Response<T>> j60Var) {
        boolean z;
        Call<T> mo5340clone = this.originalCall.mo5340clone();
        CallDisposable callDisposable = new CallDisposable(mo5340clone);
        j60Var.onSubscribe(callDisposable);
        if (callDisposable.isDisposed()) {
            return;
        }
        try {
            Response<T> execute = mo5340clone.execute();
            if (!callDisposable.isDisposed()) {
                j60Var.onNext(execute);
            }
            if (callDisposable.isDisposed()) {
                return;
            }
            try {
                j60Var.onComplete();
            } catch (Throwable th) {
                th = th;
                z = true;
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                if (z) {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                } else if (callDisposable.isDisposed()) {
                } else {
                    try {
                        j60Var.onError(th);
                    } catch (Throwable th2) {
                        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
                        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) new CompositeException(th, th2));
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            z = false;
        }
    }
}
