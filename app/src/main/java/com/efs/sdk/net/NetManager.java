package com.efs.sdk.net;

import android.content.Context;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.util.Log;
import java.util.Map;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/* loaded from: classes3.dex */
public class NetManager {
    public static final String TAG = "OkHttpManager";
    public static NetConfigManager mNetConfigManager;
    public static EfsReporter mReporter;

    public static void get(String str, Callback callback) {
        new OkHttpClient.Builder().eventListenerFactory(OkHttpListener.get()).addNetworkInterceptor(new OkHttpInterceptor()).build().newCall(new Request.Builder().url(str).build()).enqueue(callback);
    }

    public static NetConfigManager getNetConfigManager() {
        return mNetConfigManager;
    }

    public static EfsReporter getReporter() {
        return mReporter;
    }

    public static void init(Context context, EfsReporter efsReporter) {
        if (context == null || efsReporter == null) {
            Log.m4066e(TAG, "init net manager error! parameter is null!");
            return;
        }
        mReporter = efsReporter;
        mNetConfigManager = new NetConfigManager(context, efsReporter);
    }

    public static void post(String str, Map<String, Object> map, Callback callback) {
        StringBuilder sb = new StringBuilder();
        for (String str2 : map.keySet()) {
            sb.append(str2);
            sb.append("=");
            sb.append(map.get(str2));
            sb.append("&");
        }
        new OkHttpClient.Builder().eventListenerFactory(OkHttpListener.get()).addNetworkInterceptor(new OkHttpInterceptor()).build().newCall(new Request.Builder().url(str).post(RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), sb.toString())).build()).enqueue(callback);
    }
}
