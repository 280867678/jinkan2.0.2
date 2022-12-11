package okhttp3;

import java.io.IOException;
import me.tvspark.ef0;
import me.tvspark.nx0;

@ef0
/* loaded from: classes4.dex */
public interface Call extends Cloneable {

    @ef0
    /* loaded from: classes4.dex */
    public interface Factory {
        Call newCall(Request request);
    }

    void cancel();

    /* renamed from: clone */
    Call mo5088clone();

    void enqueue(Callback callback);

    Response execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    Request request();

    nx0 timeout();
}
