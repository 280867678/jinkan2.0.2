package com.efs.sdk.base.core.config.p008a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.efs.sdk.base.IConfigRefreshAction;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.p005a.C0694a;
import com.efs.sdk.base.core.p005a.C0696b;
import com.efs.sdk.base.core.p005a.C0698c;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.efs.sdk.base.core.util.p015b.C0773c;
import com.efs.sdk.base.core.util.p015b.C0774d;
import com.efs.sdk.base.http.HttpResponse;
import java.util.HashMap;
import me.tvspark.outline;

/* renamed from: com.efs.sdk.base.core.config.a.a */
/* loaded from: classes3.dex */
public final class C0726a implements IConfigRefreshAction {

    /* renamed from: com.efs.sdk.base.core.config.a.a$a */
    /* loaded from: classes3.dex */
    public static class C0727a {

        /* renamed from: a */
        public static final C0726a f237a = new C0726a();
    }

    /* renamed from: a */
    public static C0726a m4131a() {
        return C0727a.f237a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0094, code lost:
        r0 = "config request succ, config is:\n ".concat(java.lang.String.valueOf(r2));
     */
    @Override // com.efs.sdk.base.IConfigRefreshAction
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String refresh() {
        String concat;
        String str = "";
        if (NetworkUtil.isConnected(ControllerCenter.getGlobalEnvStruct().mAppContext)) {
            String m4122a = C0729c.m4127a().m4122a(true);
            C0698c m4175a = C0698c.m4175a();
            int i = 0;
            while (true) {
                if (i >= 3) {
                    break;
                }
                C0694a m4184a = C0694a.m4184a();
                String m4174b = m4175a.m4174b();
                String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(m4122a, "/apm_cc");
                if (m4184a.f168a) {
                    Log.m4062i("efs.px.api", "get config from server, url is ".concat(String.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)));
                }
                HashMap hashMap = new HashMap(1);
                hashMap.put("wpk-header", m4174b);
                C0773c m4018a = new C0774d(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).m4015a(hashMap).m4017a(C0696b.m4178a()).m4018a();
                m4018a.f330a.f327e = "get";
                HttpResponse m4040a = m4018a.m4040a();
                if (m4040a.succ) {
                    str = m4040a.data;
                    break;
                } else if (TextUtils.isEmpty(m4040a.getBizCode()) || !"1000".equals(m4040a.getBizCode())) {
                    break;
                } else {
                    i++;
                }
            }
            return str;
        }
        concat = "Config refresh fail, network is disconnected.";
        Log.m4062i("efs.config", concat);
        return str;
    }
}
