package com.tencent.smtt.sdk;

import android.util.Pair;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.UrlRequest;
import java.util.ArrayList;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public class UrlRequestBuilderImpl extends UrlRequest.Builder {

    /* renamed from: a */
    public static final String f1967a = "UrlRequestBuilderImpl";

    /* renamed from: b */
    public final String f1968b;

    /* renamed from: c */
    public final UrlRequest.Callback f1969c;

    /* renamed from: d */
    public final Executor f1970d;

    /* renamed from: e */
    public String f1971e;

    /* renamed from: g */
    public boolean f1973g;

    /* renamed from: i */
    public String f1975i;

    /* renamed from: j */
    public byte[] f1976j;

    /* renamed from: k */
    public String f1977k;

    /* renamed from: l */
    public String f1978l;

    /* renamed from: f */
    public final ArrayList<Pair<String, String>> f1972f = new ArrayList<>();

    /* renamed from: h */
    public int f1974h = 3;

    public UrlRequestBuilderImpl(String str, UrlRequest.Callback callback, Executor executor) {
        if (str != null) {
            if (callback == null) {
                throw new NullPointerException("Callback is required.");
            }
            if (executor == null) {
                throw new NullPointerException("Executor is required.");
            }
            this.f1968b = str;
            this.f1969c = callback;
            this.f1970d = executor;
            return;
        }
        throw new NullPointerException("URL is required.");
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    /* renamed from: addHeader  reason: collision with other method in class */
    public UrlRequestBuilderImpl mo4859addHeader(String str, String str2) {
        if (str != null) {
            if (str2 == null) {
                throw new NullPointerException("Invalid header value.");
            }
            if ("Accept-Encoding".equalsIgnoreCase(str)) {
                return this;
            }
            this.f1972f.add(Pair.create(str, str2));
            return this;
        }
        throw new NullPointerException("Invalid header name.");
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequest build() throws NullPointerException {
        int i;
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            return null;
        }
        DexLoader m2271b = m2294a.m2289c().m2271b();
        UrlRequest urlRequest = (UrlRequest) m2271b.invokeStaticMethod("com.tencent.smtt.net.X5UrlRequestProvider", "GetX5UrlRequestProvider", new Class[]{String.class, Integer.TYPE, UrlRequest.Callback.class, Executor.class, Boolean.TYPE, String.class, ArrayList.class, String.class, byte[].class, String.class, String.class}, this.f1968b, Integer.valueOf(this.f1974h), this.f1969c, this.f1970d, Boolean.valueOf(this.f1973g), this.f1971e, this.f1972f, this.f1975i, this.f1976j, this.f1977k, this.f1978l);
        if (urlRequest == null) {
            i = 7;
            urlRequest = (UrlRequest) m2271b.invokeStaticMethod("com.tencent.smtt.net.X5UrlRequestProvider", "GetX5UrlRequestProvider", new Class[]{String.class, Integer.TYPE, UrlRequest.Callback.class, Executor.class, Boolean.TYPE, String.class, ArrayList.class, String.class}, this.f1968b, Integer.valueOf(this.f1974h), this.f1969c, this.f1970d, Boolean.valueOf(this.f1973g), this.f1971e, this.f1972f, this.f1975i);
        } else {
            i = 7;
        }
        if (urlRequest == null) {
            Class<?>[] clsArr = new Class[i];
            clsArr[0] = String.class;
            clsArr[1] = Integer.TYPE;
            clsArr[2] = UrlRequest.Callback.class;
            clsArr[3] = Executor.class;
            clsArr[4] = Boolean.TYPE;
            clsArr[5] = String.class;
            clsArr[6] = ArrayList.class;
            urlRequest = (UrlRequest) m2271b.invokeStaticMethod("com.tencent.smtt.net.X5UrlRequestProvider", "GetX5UrlRequestProvider", clsArr, this.f1968b, Integer.valueOf(this.f1974h), this.f1969c, this.f1970d, Boolean.valueOf(this.f1973g), this.f1971e, this.f1972f);
        }
        if (urlRequest == null) {
            urlRequest = (UrlRequest) m2271b.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "UrlRequest_getX5UrlRequestProvider", new Class[]{String.class, Integer.TYPE, UrlRequest.Callback.class, Executor.class, Boolean.TYPE, String.class, ArrayList.class, String.class, byte[].class, String.class, String.class}, this.f1968b, Integer.valueOf(this.f1974h), this.f1969c, this.f1970d, Boolean.valueOf(this.f1973g), this.f1971e, this.f1972f, this.f1975i, this.f1976j, this.f1977k, this.f1978l);
        }
        if (urlRequest == null) {
            throw new NullPointerException("UrlRequest build fail");
        }
        return urlRequest;
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    /* renamed from: disableCache  reason: collision with other method in class */
    public UrlRequestBuilderImpl mo4860disableCache() {
        this.f1973g = true;
        return this;
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    /* renamed from: setDns  reason: collision with other method in class */
    public UrlRequestBuilderImpl mo4861setDns(String str, String str2) {
        if (str == null || str2 == null) {
            throw new NullPointerException("host and address are required.");
        }
        this.f1977k = str;
        this.f1978l = str2;
        try {
            C1416x m2294a = C1416x.m2294a();
            if (m2294a != null && m2294a.m2291b()) {
                m2294a.m2289c().m2271b().invokeStaticMethod("com.tencent.smtt.net.X5UrlRequestProvider", "setDns", new Class[]{String.class, String.class}, this.f1977k, this.f1978l);
            }
        } catch (Exception unused) {
        }
        return this;
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequest.Builder setHttpMethod(String str) {
        if (str != null) {
            this.f1971e = str;
            return this;
        }
        throw new NullPointerException("Method is required.");
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    /* renamed from: setPriority  reason: collision with other method in class */
    public UrlRequestBuilderImpl mo4862setPriority(int i) {
        this.f1974h = i;
        return this;
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequest.Builder setRequestBody(String str) {
        if (str != null) {
            this.f1975i = str;
            return this;
        }
        throw new NullPointerException("Body is required.");
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequest.Builder setRequestBodyBytes(byte[] bArr) {
        if (bArr != null) {
            this.f1976j = bArr;
            return this;
        }
        throw new NullPointerException("Body is required.");
    }
}
