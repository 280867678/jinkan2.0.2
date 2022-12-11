package okhttp3.internal.http;

import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.ww0;
import okhttp3.MediaType;
import okhttp3.ResponseBody;

@ef0
/* loaded from: classes4.dex */
public final class RealResponseBody extends ResponseBody {
    public final long contentLength;
    public final String contentTypeString;
    public final ww0 source;

    public RealResponseBody(String str, long j, ww0 ww0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ww0Var, "source");
        this.contentTypeString = str;
        this.contentLength = j;
        this.source = ww0Var;
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.contentLength;
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        String str = this.contentTypeString;
        if (str != null) {
            return MediaType.Companion.parse(str);
        }
        return null;
    }

    @Override // okhttp3.ResponseBody
    public ww0 source() {
        return this.source;
    }
}
