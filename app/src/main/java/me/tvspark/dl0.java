package me.tvspark;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes4.dex */
public class dl0 implements Interceptor {
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public dl0(int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response proceed;
        int i;
        Request request = chain.request();
        while (true) {
            proceed = chain.proceed(request);
            if (proceed.isSuccessful() || (i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) >= this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                break;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i + 1;
            proceed.close();
        }
        return proceed;
    }
}
