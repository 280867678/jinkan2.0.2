package com.p038qq.p039e.comm.managers.devtool;

import android.content.Context;
import android.text.TextUtils;

/* renamed from: com.qq.e.comm.managers.devtool.DevTools */
/* loaded from: classes3.dex */
public class DevTools {
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public String getDemoGameUrl() {
        String str = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        return str;
    }

    public void testDemoGame(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context.getPackageName().equals("com.qq.e.union.demo.union")) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
        }
    }
}
