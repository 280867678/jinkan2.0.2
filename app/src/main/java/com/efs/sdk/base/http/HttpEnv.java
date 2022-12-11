package com.efs.sdk.base.http;

import androidx.annotation.NonNull;
import com.efs.sdk.base.core.util.p014a.AbstractC0765b;
import com.efs.sdk.base.core.util.p015b.C0770a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class HttpEnv {
    public List<AbstractC0765b<HttpResponse>> mHttpListenerList;
    public IHttpUtil mHttpUtil;

    /* loaded from: classes3.dex */
    public static class SingletonHolder {
        public static final HttpEnv INSTANCE = new HttpEnv();
    }

    public HttpEnv() {
        this.mHttpUtil = C0770a.m4026a();
        this.mHttpListenerList = new ArrayList(1);
    }

    public static HttpEnv getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void addListener(@NonNull AbsHttpListener absHttpListener) {
        this.mHttpListenerList.add(absHttpListener);
    }

    public List<AbstractC0765b<HttpResponse>> getHttpListenerList() {
        return new ArrayList(this.mHttpListenerList);
    }

    public IHttpUtil getHttpUtil() {
        return this.mHttpUtil;
    }

    public void removeListener(@NonNull AbsHttpListener absHttpListener) {
        this.mHttpListenerList.remove(absHttpListener);
    }

    public void setHttpUtil(IHttpUtil iHttpUtil) {
        this.mHttpUtil = iHttpUtil;
    }
}
