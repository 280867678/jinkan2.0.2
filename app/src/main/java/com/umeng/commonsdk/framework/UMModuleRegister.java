package com.umeng.commonsdk.framework;

import android.content.Context;
import com.stub.StubApp;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class UMModuleRegister {
    public static final String ANALYTICS = "analytics";
    public static final String APPSTATUS = "appstatus";
    public static final int APPSTATUS_SWITCH_HIGH = 37136;
    public static final int APPSTATUS_SWITCH_LOW = 37121;
    public static final String INNER = "internal";
    public static final int INNER_EVENT_VALUE_HIGH = 36864;
    public static final int INNER_EVENT_VALUE_LOW = 32769;
    public static final String PROCESS = "process";
    public static final int PROCESS_EVENT_VALUE_HIGH = 37120;
    public static final int PROCESS_EVENT_VALUE_LOW = 36945;
    public static final String PUSH = "push";
    public static final int PUSH_EVENT_VALUE_HIGH = 20480;
    public static final int PUSH_EVENT_VALUE_LOW = 16385;
    public static final String SHARE = "share";
    public static final int SHARE_EVENT_VALUE_HIGH = 28672;
    public static final int SHARE_EVENT_VALUE_LOW = 24577;
    public static Context mModuleAppContext;
    public static HashMap<String, UMLogDataProtocol> mModuleMap;

    public static String eventType2ModuleName(int i) {
        String str = (i < 16385 || i > 20480) ? "analytics" : "push";
        if (i >= 24577 && i <= 28672) {
            str = "share";
        }
        if (i >= 32769 && i <= 36864) {
            str = INNER;
        }
        if (i >= 36945 && i <= 37120) {
            str = PROCESS;
        }
        return (i < 37121 || i > 37136) ? str : APPSTATUS;
    }

    public static Context getAppContext() {
        return mModuleAppContext;
    }

    public static UMLogDataProtocol getCallbackFromModuleName(String str) {
        if (mModuleMap.containsKey(str)) {
            return mModuleMap.get(str);
        }
        return null;
    }

    public static void registerAppContext(Context context) {
        if (mModuleAppContext == null) {
            mModuleAppContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }

    public static boolean registerCallback(int i, UMLogDataProtocol uMLogDataProtocol) {
        if (mModuleMap == null) {
            mModuleMap = new HashMap<>();
        }
        String eventType2ModuleName = eventType2ModuleName(i);
        if (!mModuleMap.containsKey(eventType2ModuleName)) {
            mModuleMap.put(eventType2ModuleName, uMLogDataProtocol);
            return true;
        }
        return true;
    }
}
