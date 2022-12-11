package retrofit2.adapter.rxjava2;

import retrofit2.Response;

/* loaded from: classes5.dex */
public final class Result<T> {
    public final Throwable error;
    public final Response<T> response;

    public Result(Response<T> response, Throwable th) {
        this.response = response;
        this.error = th;
    }

    public static <T> Result<T> error(Throwable th) {
        if (th != null) {
            return new Result<>(null, th);
        }
        throw new NullPointerException("error == null");
    }

    public static <T> Result<T> response(Response<T> response) {
        if (response != null) {
            return new Result<>(response, null);
        }
        throw new NullPointerException("response == null");
    }

    public Throwable error() {
        return this.error;
    }

    public boolean isError() {
        return this.error != null;
    }

    public Response<T> response() {
        return this.response;
    }
}
