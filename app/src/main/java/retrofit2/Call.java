package retrofit2;

import java.io.IOException;
import me.tvspark.nx0;
import okhttp3.Request;

/* loaded from: classes5.dex */
public interface Call<T> extends Cloneable {
    void cancel();

    /* renamed from: clone */
    Call<T> mo5340clone();

    void enqueue(Callback<T> callback);

    Response<T> execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    Request request();

    nx0 timeout();
}
