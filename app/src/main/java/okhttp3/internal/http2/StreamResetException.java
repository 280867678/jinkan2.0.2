package okhttp3.internal.http2;

import java.io.IOException;
import me.tvspark.ef0;
import me.tvspark.ii0;

@ef0
/* loaded from: classes4.dex */
public final class StreamResetException extends IOException {
    public final ErrorCode errorCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamResetException(ErrorCode errorCode) {
        super("stream was reset: " + errorCode);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(errorCode, "errorCode");
        this.errorCode = errorCode;
    }
}
