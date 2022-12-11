package retrofit2.adapter.rxjava2;

import io.reactivex.exceptions.CompositeException;
import me.tvspark.d60;
import me.tvspark.j60;
import me.tvspark.p60;
import me.tvspark.r40;
import retrofit2.Response;

/* loaded from: classes5.dex */
public final class ResultObservable<T> extends d60<Result<T>> {
    public final d60<Response<T>> upstream;

    /* loaded from: classes5.dex */
    public static class ResultObserver<R> implements j60<Response<R>> {
        public final j60<? super Result<R>> observer;

        public ResultObserver(j60<? super Result<R>> j60Var) {
            this.observer = j60Var;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            this.observer.onComplete();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            try {
                this.observer.onNext(Result.error(th));
                this.observer.onComplete();
            } catch (Throwable th2) {
                try {
                    this.observer.onError(th2);
                } catch (Throwable th3) {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th3);
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) new CompositeException(th2, th3));
                }
            }
        }

        @Override // me.tvspark.j60
        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            onNext((Response) ((Response) obj));
        }

        public void onNext(Response<R> response) {
            this.observer.onNext(Result.response(response));
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            this.observer.onSubscribe(p60Var);
        }
    }

    public ResultObservable(d60<Response<T>> d60Var) {
        this.upstream = d60Var;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super Result<T>> j60Var) {
        this.upstream.subscribe(new ResultObserver(j60Var));
    }
}
