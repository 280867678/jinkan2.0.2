package retrofit2.adapter.rxjava2;

import io.reactivex.exceptions.CompositeException;
import me.tvspark.d60;
import me.tvspark.j60;
import me.tvspark.p60;
import me.tvspark.r40;
import retrofit2.Response;

/* loaded from: classes5.dex */
public final class BodyObservable<T> extends d60<T> {
    public final d60<Response<T>> upstream;

    /* loaded from: classes5.dex */
    public static class BodyObserver<R> implements j60<Response<R>> {
        public final j60<? super R> observer;
        public boolean terminated;

        public BodyObserver(j60<? super R> j60Var) {
            this.observer = j60Var;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            if (!this.terminated) {
                this.observer.onComplete();
            }
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            if (!this.terminated) {
                this.observer.onError(th);
                return;
            }
            AssertionError assertionError = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
            assertionError.initCause(th);
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) assertionError);
        }

        @Override // me.tvspark.j60
        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            onNext((Response) ((Response) obj));
        }

        public void onNext(Response<R> response) {
            if (response.isSuccessful()) {
                this.observer.onNext(response.body());
                return;
            }
            this.terminated = true;
            HttpException httpException = new HttpException(response);
            try {
                this.observer.onError(httpException);
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) new CompositeException(httpException, th));
            }
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            this.observer.onSubscribe(p60Var);
        }
    }

    public BodyObservable(d60<Response<T>> d60Var) {
        this.upstream = d60Var;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        this.upstream.subscribe(new BodyObserver(j60Var));
    }
}
