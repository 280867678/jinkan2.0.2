package com.umeng.tunnel;

import android.content.Context;
import java.util.Map;

/* loaded from: classes4.dex */
public class UMChannelAgent {
    public static final String TAG = "UMChannelAgent";
    public static final String UMENG_VCHANNEL = "com.umeng.commonsdk.vchannel.Sender";
    public static boolean vChannelReady;

    static {
        try {
            Class.forName(UMENG_VCHANNEL);
            vChannelReady = true;
        } catch (Throwable unused) {
        }
    }

    public static boolean init() {
        boolean z = vChannelReady;
        return vChannelReady;
    }

    public static void onDebugEvent(Context context, String str, Map<String, Object> map) {
        reflectOnEvent(context, str, map);
    }

    public static void reflectOnEvent(Context context, String str, Map<String, Object> map) {
        try {
            Class.forName(UMENG_VCHANNEL).getMethod("onEvent", Context.class, String.class, Map.class).invoke(null, context, str, map);
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | Exception unused) {
        }
    }

    public static void reflectSetCustomHeader(Map<String, String> map) {
        try {
            Class.forName(UMENG_VCHANNEL).getMethod("setCustomHeader", Map.class).invoke(null, map);
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | Exception unused) {
        }
    }

    public static void setCustomHeader(Map<String, String> map) {
        reflectSetCustomHeader(map);
    }
}
