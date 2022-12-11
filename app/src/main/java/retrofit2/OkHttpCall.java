package retrofit2;

import java.io.IOException;
import java.util.Objects;
import me.tvspark.hx0;
import me.tvspark.ii0;
import me.tvspark.nx0;
import me.tvspark.uw0;
import me.tvspark.ww0;
import me.tvspark.yw0;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.ResponseBody;

/* loaded from: classes5.dex */
public final class OkHttpCall<T> implements Call<T> {
    public final Object[] args;
    public final Call.Factory callFactory;
    public volatile boolean canceled;
    public Throwable creationFailure;
    public boolean executed;
    public okhttp3.Call rawCall;
    public final RequestFactory requestFactory;
    public final Converter<ResponseBody, T> responseConverter;

    /* loaded from: classes5.dex */
    public static final class ExceptionCatchingResponseBody extends ResponseBody {
        public final ResponseBody delegate;
        public final ww0 delegateSource;
        public IOException thrownException;

        public ExceptionCatchingResponseBody(ResponseBody responseBody) {
            this.delegate = responseBody;
            yw0 yw0Var = new yw0(responseBody.source()) { // from class: retrofit2.OkHttpCall.ExceptionCatchingResponseBody.1
                @Override // me.tvspark.yw0, me.tvspark.mx0
                public long read(uw0 uw0Var, long j) throws IOException {
                    try {
                        return super.read(uw0Var, j);
                    } catch (IOException e) {
                        ExceptionCatchingResponseBody.this.thrownException = e;
                        throw e;
                    }
                }
            };
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(yw0Var, "$receiver");
            this.delegateSource = new hx0(yw0Var);
        }

        @Override // okhttp3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.delegate.close();
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            return this.delegate.contentLength();
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            return this.delegate.contentType();
        }

        @Override // okhttp3.ResponseBody
        public ww0 source() {
            return this.delegateSource;
        }

        public void throwIfCaught() throws IOException {
            IOException iOException = this.thrownException;
            if (iOException == null) {
                return;
            }
            throw iOException;
        }
    }

    /* loaded from: classes5.dex */
    public static final class NoContentResponseBody extends ResponseBody {
        public final long contentLength;
        public final MediaType contentType;

        public NoContentResponseBody(MediaType mediaType, long j) {
            this.contentType = mediaType;
            this.contentLength = j;
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            return this.contentLength;
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            return this.contentType;
        }

        @Override // okhttp3.ResponseBody
        public ww0 source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    public OkHttpCall(RequestFactory requestFactory, Object[] objArr, Call.Factory factory, Converter<ResponseBody, T> converter) {
        this.requestFactory = requestFactory;
        this.args = objArr;
        this.callFactory = factory;
        this.responseConverter = converter;
    }

    private okhttp3.Call createRawCall() throws IOException {
        okhttp3.Call newCall = this.callFactory.newCall(this.requestFactory.create(this.args));
        if (newCall != null) {
            return newCall;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }

    private okhttp3.Call getRawCall() throws IOException {
        okhttp3.Call call = this.rawCall;
        if (call != null) {
            return call;
        }
        Throwable th = this.creationFailure;
        if (th != null) {
            if (th instanceof IOException) {
                throw ((IOException) th);
            }
            if (!(th instanceof RuntimeException)) {
                throw ((Error) th);
            }
            throw ((RuntimeException) th);
        }
        try {
            okhttp3.Call createRawCall = createRawCall();
            this.rawCall = createRawCall;
            return createRawCall;
        } catch (IOException | Error | RuntimeException e) {
            Utils.throwIfFatal(e);
            this.creationFailure = e;
            throw e;
        }
    }

    @Override // retrofit2.Call
    public void cancel() {
        okhttp3.Call call;
        this.canceled = true;
        synchronized (this) {
            call = this.rawCall;
        }
        if (call != null) {
            call.cancel();
        }
    }

    @Override // retrofit2.Call
    /* renamed from: clone */
    public OkHttpCall<T> mo5340clone() {
        return new OkHttpCall<>(this.requestFactory, this.args, this.callFactory, this.responseConverter);
    }

    @Override // retrofit2.Call
    public void enqueue(final Callback<T> callback) {
        okhttp3.Call call;
        Throwable th;
        Objects.requireNonNull(callback, "callback == null");
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already executed.");
            }
            this.executed = true;
            call = this.rawCall;
            th = this.creationFailure;
            if (call == null && th == null) {
                okhttp3.Call createRawCall = createRawCall();
                this.rawCall = createRawCall;
                call = createRawCall;
            }
        }
        if (th != null) {
            callback.onFailure(this, th);
            return;
        }
        if (this.canceled) {
            call.cancel();
        }
        call.enqueue(new okhttp3.Callback() { // from class: retrofit2.OkHttpCall.1
            private void callFailure(Throwable th2) {
                try {
                    callback.onFailure(OkHttpCall.this, th2);
                } catch (Throwable th3) {
                    Utils.throwIfFatal(th3);
                    th3.printStackTrace();
                }
            }

            @Override // okhttp3.Callback
            public void onFailure(okhttp3.Call call2, IOException iOException) {
                callFailure(iOException);
            }

            @Override // okhttp3.Callback
            public void onResponse(okhttp3.Call call2, okhttp3.Response response) {
                try {
                    try {
                        callback.onResponse(OkHttpCall.this, OkHttpCall.this.parseResponse(response));
                    } catch (Throwable th2) {
                        Utils.throwIfFatal(th2);
                        th2.printStackTrace();
                    }
                } catch (Throwable th3) {
                    Utils.throwIfFatal(th3);
                    callFailure(th3);
                }
            }
        });
    }

    @Override // retrofit2.Call
    public Response<T> execute() throws IOException {
        okhttp3.Call rawCall;
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already executed.");
            }
            this.executed = true;
            rawCall = getRawCall();
        }
        if (this.canceled) {
            rawCall.cancel();
        }
        return parseResponse(rawCall.execute());
    }

    @Override // retrofit2.Call
    public boolean isCanceled() {
        boolean z = true;
        if (this.canceled) {
            return true;
        }
        synchronized (this) {
            if (this.rawCall == null || !this.rawCall.isCanceled()) {
                z = false;
            }
        }
        return z;
    }

    @Override // retrofit2.Call
    public synchronized boolean isExecuted() {
        return this.executed;
    }

    public Response<T> parseResponse(okhttp3.Response response) throws IOException {
        ResponseBody body = response.body();
        okhttp3.Response build = response.newBuilder().body(new NoContentResponseBody(body.contentType(), body.contentLength())).build();
        int code = build.code();
        if (code < 200 || code >= 300) {
            try {
                return Response.error(Utils.buffer(body), build);
            } finally {
                body.close();
            }
        } else if (code == 204 || code == 205) {
            body.close();
            return Response.success((Object) null, build);
        } else {
            ExceptionCatchingResponseBody exceptionCatchingResponseBody = new ExceptionCatchingResponseBody(body);
            try {
                return Response.success(this.responseConverter.convert(exceptionCatchingResponseBody), build);
            } catch (RuntimeException e) {
                exceptionCatchingResponseBody.throwIfCaught();
                throw e;
            }
        }
    }

    @Override // retrofit2.Call
    public synchronized Request request() {
        try {
        } catch (IOException e) {
            throw new RuntimeException("Unable to create request.", e);
        }
        return getRawCall().request();
    }

    @Override // retrofit2.Call
    public synchronized nx0 timeout() {
        try {
        } catch (IOException e) {
            throw new RuntimeException("Unable to create call.", e);
        }
        return getRawCall().timeout();
    }
}
