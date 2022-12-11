package com.umeng.commonsdk.service;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.utils.UMUtils;
import me.tvspark.outline;

/* loaded from: classes4.dex */
public class UMGlobalContext {
    public static final String TAG = "UMGlobalContext";
    public String mAppVersion;
    public String mAppkey;
    public Context mApplicationContext;
    public String mChannel;
    public String mProcessName;

    /* renamed from: com.umeng.commonsdk.service.UMGlobalContext$a */
    /* loaded from: classes4.dex */
    public static class C1751a {

        /* renamed from: a */
        public static final UMGlobalContext f3982a = new UMGlobalContext();
    }

    public UMGlobalContext() {
        this.mProcessName = "";
    }

    public static Context getAppContext() {
        return C1751a.f3982a.mApplicationContext;
    }

    public static Context getAppContext(Context context) {
        if (C1751a.f3982a.mApplicationContext == null && context != null) {
            C1751a.f3982a.mApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        return C1751a.f3982a.mApplicationContext;
    }

    public static UMGlobalContext getInstance(Context context) {
        if (C1751a.f3982a.mApplicationContext == null && context != null) {
            C1751a.f3982a.mApplicationContext = context;
        }
        return C1751a.f3982a;
    }

    public String getAppVersion() {
        if (TextUtils.isEmpty(this.mAppVersion)) {
            this.mAppVersion = UMUtils.getAppVersionName(this.mApplicationContext);
        }
        return this.mAppVersion;
    }

    public String getAppkey() {
        if (TextUtils.isEmpty(this.mAppkey)) {
            this.mAppkey = UMConfigure.sAppkey;
        }
        return this.mAppkey;
    }

    public String getChannel() {
        if (TextUtils.isEmpty(this.mChannel)) {
            this.mChannel = UMConfigure.sChannel;
        }
        return this.mChannel;
    }

    public String getProcessName(Context context) {
        String currentProcessName;
        if (TextUtils.isEmpty(this.mProcessName)) {
            if (context != null) {
                Context context2 = C1751a.f3982a.mApplicationContext;
                if (context2 != null) {
                    currentProcessName = UMFrUtils.getCurrentProcessName(context2);
                    this.mProcessName = currentProcessName;
                }
            } else {
                context = C1751a.f3982a.mApplicationContext;
            }
            currentProcessName = UMFrUtils.getCurrentProcessName(context);
            this.mProcessName = currentProcessName;
        }
        return this.mProcessName;
    }

    public boolean isMainProcess(Context context) {
        return UMUtils.isMainProgress(context);
    }

    public String toString() {
        if (C1751a.f3982a.mApplicationContext != null) {
            StringBuilder sb = new StringBuilder("[");
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("appkey:");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mAppkey);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(",");
            sb.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            sb.append("channel:" + this.mChannel + ",");
            sb.append("procName:" + this.mProcessName + "]");
            return sb.toString();
        }
        return "uninitialized.";
    }
}
