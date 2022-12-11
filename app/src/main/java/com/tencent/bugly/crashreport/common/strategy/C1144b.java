package com.tencent.bugly.crashreport.common.strategy;

import android.content.Context;
import com.tencent.bugly.crashreport.common.info.C1140a;
import com.tencent.bugly.proguard.AbstractC1184I;
import com.tencent.bugly.proguard.C1185J;
import com.tencent.bugly.proguard.C1199X;
import com.tencent.bugly.proguard.C1208ca;
import java.util.Map;

/* renamed from: com.tencent.bugly.crashreport.common.strategy.b */
/* loaded from: classes3.dex */
public class C1144b extends Thread {

    /* renamed from: a */
    public final /* synthetic */ C1145c f1107a;

    public C1144b(C1145c c1145c) {
        this.f1107a = c1145c;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        StrategyBean strategyBean;
        StrategyBean strategyBean2;
        String str;
        StrategyBean strategyBean3;
        StrategyBean strategyBean4;
        String str2;
        String str3;
        StrategyBean strategyBean5;
        String str4;
        Context context;
        Context context2;
        try {
            Map<String, byte[]> m3169a = C1185J.m3172a().m3169a(C1145c.f1108a, (AbstractC1184I) null, true);
            if (m3169a != null) {
                byte[] bArr = m3169a.get("device");
                byte[] bArr2 = m3169a.get("gateway");
                if (bArr != null) {
                    context2 = this.f1107a.f1115h;
                    C1140a.m3421a(context2).m3402f(new String(bArr));
                }
                if (bArr2 != null) {
                    context = this.f1107a.f1115h;
                    C1140a.m3421a(context).m3404e(new String(bArr2));
                }
            }
            this.f1107a.f1114g = this.f1107a.m3340e();
            strategyBean2 = this.f1107a.f1114g;
            if (strategyBean2 != null) {
                str = C1145c.f1110c;
                if (!C1208ca.m3012b(str)) {
                    str3 = C1145c.f1110c;
                    if (C1208ca.m3006c(str3)) {
                        strategyBean5 = this.f1107a.f1114g;
                        str4 = C1145c.f1110c;
                        strategyBean5.f1100q = str4;
                        strategyBean4 = this.f1107a.f1114g;
                        str2 = C1145c.f1110c;
                        strategyBean4.f1101r = str2;
                    }
                }
                strategyBean3 = this.f1107a.f1114g;
                strategyBean3.f1100q = StrategyBean.f1084a;
                strategyBean4 = this.f1107a.f1114g;
                str2 = StrategyBean.f1085b;
                strategyBean4.f1101r = str2;
            }
        } catch (Throwable th) {
            if (!C1199X.m3080b(th)) {
                th.printStackTrace();
            }
        }
        C1145c c1145c = this.f1107a;
        strategyBean = c1145c.f1114g;
        c1145c.m3349a(strategyBean, false);
    }
}
