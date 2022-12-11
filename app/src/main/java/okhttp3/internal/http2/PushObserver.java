package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import me.tvspark.ww0;

@ef0
/* loaded from: classes4.dex */
public interface PushObserver {
    public static final Companion Companion = new Companion(null);
    public static final PushObserver CANCEL = new PushObserver() { // from class: okhttp3.internal.http2.PushObserver$Companion$CANCEL$1
        @Override // okhttp3.internal.http2.PushObserver
        public boolean onData(int i, ww0 ww0Var, int i2, boolean z) throws IOException {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ww0Var, "source");
            ww0Var.skip(i2);
            return true;
        }

        @Override // okhttp3.internal.http2.PushObserver
        public boolean onHeaders(int i, List<Header> list, boolean z) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "responseHeaders");
            return true;
        }

        @Override // okhttp3.internal.http2.PushObserver
        public boolean onRequest(int i, List<Header> list) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "requestHeaders");
            return true;
        }

        @Override // okhttp3.internal.http2.PushObserver
        public void onReset(int i, ErrorCode errorCode) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(errorCode, "errorCode");
        }
    };

    @ef0
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = null;

        public Companion() {
        }

        public /* synthetic */ Companion(gi0 gi0Var) {
            this();
        }
    }

    boolean onData(int i, ww0 ww0Var, int i2, boolean z) throws IOException;

    boolean onHeaders(int i, List<Header> list, boolean z);

    boolean onRequest(int i, List<Header> list);

    void onReset(int i, ErrorCode errorCode);
}
