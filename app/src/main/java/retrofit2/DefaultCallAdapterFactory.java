package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.concurrent.Executor;
import me.tvspark.nx0;
import okhttp3.Request;
import retrofit2.CallAdapter;
import retrofit2.DefaultCallAdapterFactory;

/* loaded from: classes5.dex */
public final class DefaultCallAdapterFactory extends CallAdapter.Factory {
    public final Executor callbackExecutor;

    /* loaded from: classes5.dex */
    public static final class ExecutorCallbackCall<T> implements Call<T> {
        public final Executor callbackExecutor;
        public final Call<T> delegate;

        /* renamed from: retrofit2.DefaultCallAdapterFactory$ExecutorCallbackCall$1 */
        /* loaded from: classes5.dex */
        public class C34131 implements Callback<T> {
            public final /* synthetic */ Callback val$callback;

            public C34131(Callback callback) {
                this.val$callback = callback;
            }

            public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Callback callback, Throwable th) {
                callback.onFailure(ExecutorCallbackCall.this, th);
            }

            public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Callback callback, Response response) {
                if (ExecutorCallbackCall.this.delegate.isCanceled()) {
                    callback.onFailure(ExecutorCallbackCall.this, new IOException("Canceled"));
                } else {
                    callback.onResponse(ExecutorCallbackCall.this, response);
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<T> call, final Throwable th) {
                Executor executor = ExecutorCallbackCall.this.callbackExecutor;
                final Callback callback = this.val$callback;
                executor.execute(new Runnable() { // from class: me.tvspark.b81
                    @Override // java.lang.Runnable
                    public final void run() {
                        DefaultCallAdapterFactory.ExecutorCallbackCall.C34131.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(callback, th);
                    }
                });
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call, final Response<T> response) {
                Executor executor = ExecutorCallbackCall.this.callbackExecutor;
                final Callback callback = this.val$callback;
                executor.execute(new Runnable() { // from class: me.tvspark.a81
                    @Override // java.lang.Runnable
                    public final void run() {
                        DefaultCallAdapterFactory.ExecutorCallbackCall.C34131.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(callback, response);
                    }
                });
            }
        }

        public ExecutorCallbackCall(Executor executor, Call<T> call) {
            this.callbackExecutor = executor;
            this.delegate = call;
        }

        @Override // retrofit2.Call
        public void cancel() {
            this.delegate.cancel();
        }

        @Override // retrofit2.Call
        /* renamed from: clone  reason: collision with other method in class */
        public Call<T> mo5340clone() {
            return new ExecutorCallbackCall(this.callbackExecutor, this.delegate.mo5340clone());
        }

        @Override // retrofit2.Call
        public void enqueue(Callback<T> callback) {
            Objects.requireNonNull(callback, "callback == null");
            this.delegate.enqueue(new C34131(callback));
        }

        @Override // retrofit2.Call
        public Response<T> execute() throws IOException {
            return this.delegate.execute();
        }

        @Override // retrofit2.Call
        public boolean isCanceled() {
            return this.delegate.isCanceled();
        }

        @Override // retrofit2.Call
        public boolean isExecuted() {
            return this.delegate.isExecuted();
        }

        @Override // retrofit2.Call
        public Request request() {
            return this.delegate.request();
        }

        @Override // retrofit2.Call
        public nx0 timeout() {
            return this.delegate.timeout();
        }
    }

    public DefaultCallAdapterFactory(Executor executor) {
        this.callbackExecutor = executor;
    }

    @Override // retrofit2.CallAdapter.Factory
    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        final Executor executor = null;
        if (CallAdapter.Factory.getRawType(type) != Call.class) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
        }
        final Type parameterUpperBound = Utils.getParameterUpperBound(0, (ParameterizedType) type);
        if (!Utils.isAnnotationPresent(annotationArr, SkipCallbackExecutor.class)) {
            executor = this.callbackExecutor;
        }
        return new CallAdapter<Object, Call<?>>() { // from class: retrofit2.DefaultCallAdapterFactory.1
            @Override // retrofit2.CallAdapter
            /* renamed from: adapt  reason: collision with other method in class */
            public Call<?> mo5338adapt(Call<Object> call) {
                Executor executor2 = executor;
                return executor2 == null ? call : new ExecutorCallbackCall(executor2, call);
            }

            @Override // retrofit2.CallAdapter
            public Type responseType() {
                return parameterUpperBound;
            }
        };
    }
}
