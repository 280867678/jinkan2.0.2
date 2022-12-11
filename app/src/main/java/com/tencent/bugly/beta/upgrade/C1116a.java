package com.tencent.bugly.beta.upgrade;

import androidx.core.app.NotificationCompat;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.global.RunnableC1092d;
import com.tencent.bugly.beta.utils.C1125e;
import com.tencent.bugly.proguard.AbstractC1192P;
import com.tencent.bugly.proguard.C1176A;
import com.tencent.bugly.proguard.C1177B;
import com.tencent.bugly.proguard.C1179D;
import com.tencent.bugly.proguard.C1189M;
import com.tencent.bugly.proguard.C1199X;
import com.tencent.bugly.proguard.C1208ca;
import com.tencent.bugly.proguard.C1234p;
import com.tencent.bugly.proguard.C1237qa;
import com.tencent.bugly.proguard.C1238r;
import com.tencent.bugly.proguard.C1241sa;
import com.tencent.bugly.proguard.C1250z;
import java.util.ArrayList;

/* renamed from: com.tencent.bugly.beta.upgrade.a */
/* loaded from: classes3.dex */
public class C1116a implements AbstractC1192P {

    /* renamed from: a */
    public final int f865a;

    /* renamed from: b */
    public final int f866b;

    /* renamed from: c */
    public final Object[] f867c;

    /* renamed from: d */
    public boolean f868d = false;

    public C1116a(int i, int i2, Object... objArr) {
        this.f865a = i;
        this.f866b = i2;
        this.f867c = objArr;
    }

    @Override // com.tencent.bugly.proguard.AbstractC1192P
    /* renamed from: a */
    public void mo3121a(int i) {
    }

    @Override // com.tencent.bugly.proguard.AbstractC1192P
    /* renamed from: a */
    public synchronized void mo3120a(int i, C1237qa c1237qa, long j, long j2, boolean z, String str) {
        C1177B c1177b;
        C1241sa c1241sa;
        RunnableC1092d runnableC1092d;
        C1179D c1179d;
        C1179D c1179d2;
        try {
            if (!this.f868d && i == this.f866b) {
                Object[] objArr = new Object[4];
                objArr[0] = z ? "succ" : NotificationCompat.CATEGORY_ERROR;
                objArr[1] = Integer.valueOf(i);
                objArr[2] = Long.valueOf(j);
                objArr[3] = Long.valueOf(j2);
                C1199X.m3078c("upload %s:[%d] [sended %d] [recevied %d]", objArr);
                int i2 = this.f865a;
                if (i2 == 1) {
                    boolean booleanValue = ((Boolean) this.f867c[0]).booleanValue();
                    boolean booleanValue2 = ((Boolean) this.f867c[1]).booleanValue();
                    if (this.f866b != 804) {
                        return;
                    }
                    C1177B c1177b2 = null;
                    if (!z || c1237qa == null || c1237qa.f1605e.length == 0 || (c1179d = (C1179D) C1189M.m3130a(C1208ca.m3020a(c1237qa.f1605e, 2), C1179D.class)) == null) {
                        c1177b = null;
                        c1241sa = null;
                    } else {
                        c1241sa = c1179d.f1353d;
                        c1177b = c1179d.f1354e;
                    }
                    C1118c.f870a.m3573a(c1241sa);
                    BetaGrayStrategy betaGrayStrategy = (BetaGrayStrategy) this.f867c[2];
                    if (c1177b != null) {
                        c1177b2 = c1177b;
                    } else if (betaGrayStrategy != null) {
                        c1177b2 = betaGrayStrategy.f858a;
                    }
                    if (c1177b2 != null) {
                        int i3 = c1177b2.f1343u;
                        int i4 = -1;
                        if (i3 == 1) {
                            C1118c c1118c = C1118c.f870a;
                            if (z) {
                                i4 = 0;
                            }
                            c1118c.m3570a(booleanValue, booleanValue2, i4, c1177b, str);
                        } else if (i3 != 2) {
                            if (i3 != 3) {
                                C1199X.m3078c("unexpected updatetype", new Object[0]);
                            } else {
                                C1238r c1238r = C1238r.f1611a;
                                if (z) {
                                    i4 = 0;
                                }
                                c1238r.m2869a(i4, c1177b, false);
                                if (C1118c.f870a.f875f != null) {
                                    runnableC1092d = new RunnableC1092d(18, C1118c.f870a.f875f, 1, Boolean.valueOf(booleanValue));
                                } else if (booleanValue && !booleanValue2) {
                                    runnableC1092d = new RunnableC1092d(5, Beta.strToastYourAreTheLatestVersion);
                                }
                                C1125e.m3490a(runnableC1092d);
                            }
                        }
                    } else {
                        if (C1118c.f870a.f875f != null) {
                            runnableC1092d = new RunnableC1092d(18, C1118c.f870a.f875f, 1, Boolean.valueOf(booleanValue));
                        } else if (booleanValue && !booleanValue2) {
                            runnableC1092d = new RunnableC1092d(5, Beta.strToastYourAreTheLatestVersion);
                        }
                        C1125e.m3490a(runnableC1092d);
                    }
                } else if (i2 == 2) {
                    C1176A c1176a = (C1176A) this.f867c[0];
                    if (this.f866b == 803 && c1176a != null && c1176a.m3191a() != null) {
                        if (z) {
                            if (c1237qa != null && (c1179d2 = (C1179D) C1189M.m3130a(c1237qa.f1605e, C1179D.class)) != null) {
                                C1118c.f870a.m3573a(c1179d2.f1353d);
                            }
                            ArrayList<C1250z> m3191a = c1176a.m3191a();
                            if (m3191a.size() > 1) {
                                C1234p.f1572a.m2881a();
                            } else if (m3191a.size() == 1) {
                                C1234p.f1572a.m2879a(m3191a.get(0).f1683e);
                            }
                        }
                    }
                    return;
                }
                this.f868d = true;
            }
        } catch (Exception e) {
            if (!C1199X.m3083a(e)) {
                e.printStackTrace();
            }
        }
    }
}
