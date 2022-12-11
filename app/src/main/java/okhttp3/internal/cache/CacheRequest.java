package okhttp3.internal.cache;

import java.io.IOException;
import me.tvspark.ef0;
import me.tvspark.kx0;

@ef0
/* loaded from: classes4.dex */
public interface CacheRequest {
    void abort();

    kx0 body() throws IOException;
}
