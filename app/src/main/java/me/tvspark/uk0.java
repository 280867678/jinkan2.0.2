package me.tvspark;

import android.text.TextUtils;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;
import org.eclipse.jetty.http.HttpHeaderValues;

/* loaded from: classes4.dex */
public final class uk0 implements Interceptor {
    public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public uk0(String str) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        return chain.proceed(chain.request().newBuilder().addHeader("Keep-Alive", "1").addHeader("Content-Type", "application/x-www-form-urlencoded").addHeader("Connection", "Keep-Alive").addHeader("Cache-Control", HttpHeaderValues.NO_CACHE).addHeader("User-Agent", TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) ? ApplicationC1880C.Wwwwwwwwwwwwwwwwwwwwww : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).build());
    }
}
