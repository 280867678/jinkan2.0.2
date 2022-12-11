package com.efs.sdk.net;

import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.integrationtesting.IntegrationTestingUtil;
import com.efs.sdk.net.p017a.C0809a;
import com.efs.sdk.net.p017a.p018a.AbstractC0816f;
import com.efs.sdk.net.p017a.p018a.C0810a;
import com.efs.sdk.net.p017a.p018a.C0812c;
import com.efs.sdk.net.p017a.p018a.C0814e;
import com.efs.sdk.net.p017a.p018a.C0821g;
import com.efs.sdk.net.p017a.p018a.C0822h;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.InflaterOutputStream;
import me.tvspark.cx0;
import me.tvspark.gx0;
import me.tvspark.hx0;
import me.tvspark.ii0;
import me.tvspark.kx0;
import me.tvspark.nx0;
import me.tvspark.r40;
import me.tvspark.ww0;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: classes3.dex */
public class OkHttpInterceptor implements Interceptor {

    /* renamed from: a */
    public final AbstractC0816f f416a = C0821g.m3944c();

    /* renamed from: com.efs.sdk.net.OkHttpInterceptor$a */
    /* loaded from: classes3.dex */
    public static class C0805a extends ResponseBody {

        /* renamed from: a */
        public final ResponseBody f417a;

        /* renamed from: b */
        public final ww0 f418b;

        public C0805a(ResponseBody responseBody, InputStream inputStream) {
            this.f417a = responseBody;
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(inputStream, "$receiver");
            cx0 cx0Var = new cx0(inputStream, new nx0());
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cx0Var, "$receiver");
            this.f418b = new hx0(cx0Var);
        }

        @Override // okhttp3.ResponseBody
        public final long contentLength() {
            return this.f417a.contentLength();
        }

        @Override // okhttp3.ResponseBody
        public final MediaType contentType() {
            return this.f417a.contentType();
        }

        @Override // okhttp3.ResponseBody
        public final ww0 source() {
            return this.f418b;
        }
    }

    /* renamed from: com.efs.sdk.net.OkHttpInterceptor$b */
    /* loaded from: classes3.dex */
    public static class C0806b implements AbstractC0816f.AbstractC0817a {

        /* renamed from: a */
        public final String f419a;

        /* renamed from: b */
        public final Request f420b;

        /* renamed from: c */
        public C0822h f421c;

        public C0806b(String str, Request request, C0822h c0822h) {
            this.f419a = str;
            this.f420b = request;
            this.f421c = c0822h;
        }

        @Override // com.efs.sdk.net.p017a.p018a.AbstractC0816f.AbstractC0818b
        /* renamed from: a */
        public final String mo3952a() {
            return this.f419a;
        }

        @Override // com.efs.sdk.net.p017a.p018a.AbstractC0816f.AbstractC0817a
        /* renamed from: b */
        public final String mo3955b() {
            return this.f420b.url().toString();
        }

        @Override // com.efs.sdk.net.p017a.p018a.AbstractC0816f.AbstractC0817a
        /* renamed from: c */
        public final String mo3954c() {
            return this.f420b.method();
        }

        @Override // com.efs.sdk.net.p017a.p018a.AbstractC0816f.AbstractC0817a
        /* renamed from: d */
        public final byte[] mo3953d() {
            RequestBody body = this.f420b.body();
            if (body == null) {
                return null;
            }
            C0822h c0822h = this.f421c;
            String header = this.f420b.header("Content-Encoding");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            C0810a c0810a = new C0810a("gzip".equals(header) ? C0814e.m3958a(byteArrayOutputStream) : "deflate".equals(header) ? new InflaterOutputStream(byteArrayOutputStream) : byteArrayOutputStream);
            c0822h.f448c = c0810a;
            c0822h.f447b = byteArrayOutputStream;
            kx0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((OutputStream) c0810a);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "$receiver");
            gx0 gx0Var = new gx0(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            try {
                body.writeTo(gx0Var);
                gx0Var.close();
                C0822h c0822h2 = this.f421c;
                c0822h2.m3942b();
                return c0822h2.f447b.toByteArray();
            } catch (Throwable th) {
                gx0Var.close();
                throw th;
            }
        }
    }

    /* renamed from: com.efs.sdk.net.OkHttpInterceptor$c */
    /* loaded from: classes3.dex */
    public static class C0807c implements AbstractC0816f.AbstractC0819c {

        /* renamed from: a */
        public final String f422a;

        /* renamed from: b */
        public final Request f423b;

        /* renamed from: c */
        public final Response f424c;

        /* renamed from: d */
        public final Connection f425d;

        public C0807c(String str, Request request, Response response, Connection connection) {
            this.f422a = str;
            this.f423b = request;
            this.f424c = response;
            this.f425d = connection;
        }

        @Override // com.efs.sdk.net.p017a.p018a.AbstractC0816f.AbstractC0820d
        /* renamed from: a */
        public final String mo3951a() {
            return this.f422a;
        }

        @Override // com.efs.sdk.net.p017a.p018a.AbstractC0816f.AbstractC0820d
        /* renamed from: b */
        public final int mo3950b() {
            return this.f424c.code();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(18:1|2|3|(1:5)|(3:56|57|(1:59)(6:60|16|(3:39|40|(1:42)(1:43))|(1:21)|22|(6:24|(1:26)(1:36)|27|(1:29)|30|(2:32|33)(1:35))(2:37|38)))|(1:9)(1:55)|10|11|12|13|14|15|16|(0)|(2:19|21)|22|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0085, code lost:
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0086, code lost:
        r8 = r3;
        r3 = r0;
        r0 = r5;
        r5 = r4;
        r4 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x008c, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x008d, code lost:
        r5 = r4;
        r4 = r3;
        r3 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ac A[Catch: all -> 0x00a8, TryCatch #2 {all -> 0x00a8, blocks: (B:40:0x00a1, B:19:0x00ac, B:21:0x00b2, B:22:0x00bf, B:24:0x00c5, B:26:0x00d5, B:27:0x00e0, B:29:0x00e4, B:30:0x00e8, B:32:0x00fb, B:37:0x010e, B:38:0x0115), top: B:39:0x00a1 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c5 A[Catch: all -> 0x00a8, TryCatch #2 {all -> 0x00a8, blocks: (B:40:0x00a1, B:19:0x00ac, B:21:0x00b2, B:22:0x00bf, B:24:0x00c5, B:26:0x00d5, B:27:0x00e0, B:29:0x00e4, B:30:0x00e8, B:32:0x00fb, B:37:0x010e, B:38:0x0115), top: B:39:0x00a1 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x010e A[Catch: all -> 0x00a8, TryCatch #2 {all -> 0x00a8, blocks: (B:40:0x00a1, B:19:0x00ac, B:21:0x00b2, B:22:0x00bf, B:24:0x00c5, B:26:0x00d5, B:27:0x00e0, B:29:0x00e4, B:30:0x00e8, B:32:0x00fb, B:37:0x010e, B:38:0x0115), top: B:39:0x00a1 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Response intercept(Interceptor.Chain chain) {
        C0822h c0822h;
        String str;
        boolean z;
        C0822h c0822h2;
        String str2;
        Connection connection;
        MediaType mediaType;
        InputStream inputStream;
        String str3;
        Request request = chain.request();
        String str4 = null;
        boolean z2 = false;
        try {
            Log.m4070d("NetTrace-Interceptor", "begin intercept");
            if (NetManager.getNetConfigManager() != null) {
                z2 = NetManager.getNetConfigManager().enableTracer();
            }
        } catch (Throwable th) {
            th = th;
            c0822h = null;
            str = null;
            z = false;
        }
        if (!z2) {
            try {
            } catch (Throwable th2) {
                th = th2;
                str = null;
                z = z2;
                c0822h = null;
                th.printStackTrace();
                c0822h2 = c0822h;
                z2 = z;
                str2 = str;
                Response proceed = chain.proceed(request);
                if (!z2) {
                }
                if (c0822h2 != null) {
                }
                connection = chain.connection();
                if (connection != null) {
                }
            }
            if (!IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.m4070d("NetTrace-Interceptor", "net enable is false~");
                c0822h2 = null;
                str2 = null;
                Response proceed2 = chain.proceed(request);
                if (!z2) {
                    try {
                        if (!IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                            return proceed2;
                        }
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                        return proceed2;
                    }
                }
                if (c0822h2 != null && c0822h2.m3943a()) {
                    c0822h2.m3942b();
                    AbstractC0816f abstractC0816f = c0822h2.f446a;
                    c0822h2.f447b.size();
                    abstractC0816f.mo3949a();
                }
                connection = chain.connection();
                if (connection != null) {
                    throw new IllegalStateException("No connection associated with this request; did you use addInterceptor instead of addNetworkInterceptor?");
                }
                this.f416a.mo3947a(new C0807c(str2, request, proceed2, connection));
                ResponseBody body = proceed2.body();
                if (body != null) {
                    mediaType = body.contentType();
                    inputStream = body.byteStream();
                } else {
                    mediaType = null;
                    inputStream = null;
                }
                AbstractC0816f abstractC0816f2 = this.f416a;
                if (mediaType != null) {
                    str4 = mediaType.toString();
                }
                String header = proceed2.header("Content-Encoding");
                new C0812c(this.f416a, str2);
                InputStream mo3946a = abstractC0816f2.mo3946a(str2, str4, header, inputStream);
                return mo3946a != null ? proceed2.newBuilder().body(new C0805a(body, mo3946a)).build() : proceed2;
            }
        }
        if (request != null) {
            str3 = "intercept request is " + request.toString();
        } else {
            str3 = "intercept request is null~";
        }
        Log.m4070d("NetTrace-Interceptor", str3);
        str2 = this.f416a.mo3945b();
        Log.m4070d("NetTrace-Interceptor", "intercept request id is ".concat(String.valueOf(str2)));
        C0809a.m3968a().m3967a(str2).f452c = request.url().toString();
        c0822h2 = new C0822h(this.f416a, str2);
        this.f416a.mo3948a(new C0806b(str2, request, c0822h2));
        Response proceed22 = chain.proceed(request);
        if (!z2) {
        }
        if (c0822h2 != null) {
            c0822h2.m3942b();
            AbstractC0816f abstractC0816f3 = c0822h2.f446a;
            c0822h2.f447b.size();
            abstractC0816f3.mo3949a();
        }
        connection = chain.connection();
        if (connection != null) {
        }
    }
}
