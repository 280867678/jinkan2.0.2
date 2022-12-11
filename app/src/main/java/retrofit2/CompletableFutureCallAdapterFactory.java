package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import retrofit2.CallAdapter;

/* loaded from: classes5.dex */
public final class CompletableFutureCallAdapterFactory extends CallAdapter.Factory {
    public static final CallAdapter.Factory INSTANCE = new CompletableFutureCallAdapterFactory();

    /* loaded from: classes5.dex */
    public static final class BodyCallAdapter<R> implements CallAdapter<R, CompletableFuture<R>> {
        public final Type responseType;

        /* loaded from: classes5.dex */
        public class BodyCallback implements Callback<R> {
            public final CompletableFuture<R> future;

            public BodyCallback(CompletableFuture<R> completableFuture) {
                this.future = completableFuture;
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<R> call, Throwable th) {
                this.future.completeExceptionally(th);
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<R> call, Response<R> response) {
                if (response.isSuccessful()) {
                    this.future.complete(response.body());
                } else {
                    this.future.completeExceptionally(new HttpException(response));
                }
            }
        }

        public BodyCallAdapter(Type type) {
            this.responseType = type;
        }

        @Override // retrofit2.CallAdapter
        /* renamed from: adapt  reason: collision with other method in class */
        public CompletableFuture<R> mo5338adapt(Call<R> call) {
            CallCancelCompletableFuture callCancelCompletableFuture = new CallCancelCompletableFuture(call);
            call.enqueue(new BodyCallback(callCancelCompletableFuture));
            return callCancelCompletableFuture;
        }

        @Override // retrofit2.CallAdapter
        public Type responseType() {
            return this.responseType;
        }
    }

    /* loaded from: classes5.dex */
    public static final class CallCancelCompletableFuture<T> extends CompletableFuture<T> {
        public final Call<?> call;

        public CallCancelCompletableFuture(Call<?> call) {
            this.call = call;
        }

        @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
        public boolean cancel(boolean z) {
            if (z) {
                this.call.cancel();
            }
            return super.cancel(z);
        }
    }

    /* loaded from: classes5.dex */
    public static final class ResponseCallAdapter<R> implements CallAdapter<R, CompletableFuture<Response<R>>> {
        public final Type responseType;

        /* loaded from: classes5.dex */
        public class ResponseCallback implements Callback<R> {
            public final CompletableFuture<Response<R>> future;

            public ResponseCallback(CompletableFuture<Response<R>> completableFuture) {
                this.future = completableFuture;
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<R> call, Throwable th) {
                this.future.completeExceptionally(th);
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<R> call, Response<R> response) {
                this.future.complete(response);
            }
        }

        public ResponseCallAdapter(Type type) {
            this.responseType = type;
        }

        @Override // retrofit2.CallAdapter
        /* renamed from: adapt  reason: collision with other method in class */
        public CompletableFuture<Response<R>> mo5338adapt(Call<R> call) {
            CallCancelCompletableFuture callCancelCompletableFuture = new CallCancelCompletableFuture(call);
            call.enqueue(new ResponseCallback(callCancelCompletableFuture));
            return callCancelCompletableFuture;
        }

        @Override // retrofit2.CallAdapter
        public Type responseType() {
            return this.responseType;
        }
    }

    @Override // retrofit2.CallAdapter.Factory
    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (CallAdapter.Factory.getRawType(type) != CompletableFuture.class) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
        }
        Type parameterUpperBound = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) type);
        if (CallAdapter.Factory.getRawType(parameterUpperBound) != Response.class) {
            return new BodyCallAdapter(parameterUpperBound);
        }
        if (!(parameterUpperBound instanceof ParameterizedType)) {
            throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
        }
        return new ResponseCallAdapter(CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound));
    }
}
