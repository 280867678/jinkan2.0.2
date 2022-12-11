package com.tencent.smtt.export.external.interfaces;

import java.nio.ByteBuffer;
import java.util.HashMap;

/* loaded from: classes4.dex */
public abstract class UrlRequest {

    /* loaded from: classes4.dex */
    public static abstract class Builder {
        public static final int REQUEST_PRIORITY_HIGHEST = 4;
        public static final int REQUEST_PRIORITY_IDLE = 0;
        public static final int REQUEST_PRIORITY_LOW = 2;
        public static final int REQUEST_PRIORITY_LOWEST = 1;
        public static final int REQUEST_PRIORITY_MEDIUM = 3;

        /* renamed from: addHeader */
        public abstract Builder mo4859addHeader(String str, String str2);

        public abstract UrlRequest build();

        /* renamed from: disableCache */
        public abstract Builder mo4860disableCache();

        /* renamed from: setDns */
        public abstract Builder mo4861setDns(String str, String str2);

        public abstract Builder setHttpMethod(String str);

        /* renamed from: setPriority */
        public abstract Builder mo4862setPriority(int i);

        public abstract Builder setRequestBody(String str);

        public abstract Builder setRequestBodyBytes(byte[] bArr);
    }

    /* loaded from: classes4.dex */
    public static abstract class Callback {
        public void onCanceled(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        }

        public abstract void onFailed(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, X5netException x5netException);

        public abstract void onReadCompleted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) throws Exception;

        public abstract void onRedirectReceived(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) throws Exception;

        public abstract void onResponseStarted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) throws Exception;

        public abstract void onSucceeded(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo);

        public void shouldInterceptResponseHeader(UrlRequest urlRequest, HashMap<String, String> hashMap) {
        }
    }

    public abstract void cancel();

    public abstract void followRedirect();

    public abstract boolean isDone();

    public abstract void read(ByteBuffer byteBuffer);

    public abstract void start();
}
