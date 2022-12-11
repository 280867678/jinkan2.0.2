package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import androidx.core.app.NotificationCompat;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.C1140a;
import com.tencent.bugly.crashreport.common.info.C1141b;
import com.tencent.bugly.crashreport.common.strategy.C1145c;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* renamed from: com.tencent.bugly.proguard.U */
/* loaded from: classes3.dex */
public class RunnableC1196U implements Runnable {

    /* renamed from: a */
    public int f1425a;

    /* renamed from: b */
    public int f1426b;

    /* renamed from: c */
    public final Context f1427c;

    /* renamed from: d */
    public final int f1428d;

    /* renamed from: e */
    public final byte[] f1429e;

    /* renamed from: f */
    public final C1140a f1430f;

    /* renamed from: g */
    public final C1145c f1431g;

    /* renamed from: h */
    public final C1191O f1432h;

    /* renamed from: i */
    public final C1195T f1433i;

    /* renamed from: j */
    public final int f1434j;

    /* renamed from: k */
    public final AbstractC1192P f1435k;

    /* renamed from: l */
    public final AbstractC1192P f1436l;

    /* renamed from: m */
    public String f1437m;

    /* renamed from: n */
    public final String f1438n;

    /* renamed from: o */
    public final Map<String, String> f1439o;

    /* renamed from: p */
    public int f1440p;

    /* renamed from: q */
    public long f1441q;

    /* renamed from: r */
    public long f1442r;

    /* renamed from: s */
    public boolean f1443s;

    public RunnableC1196U(Context context, int i, int i2, byte[] bArr, String str, String str2, AbstractC1192P abstractC1192P, boolean z, int i3, int i4, boolean z2, Map<String, String> map) {
        this.f1425a = 2;
        this.f1426b = BuglyStrategy.C1080a.MAX_USERDATA_VALUE_LENGTH;
        this.f1437m = null;
        this.f1440p = 0;
        this.f1441q = 0L;
        this.f1442r = 0L;
        this.f1443s = false;
        this.f1427c = context;
        this.f1430f = C1140a.m3421a(context);
        this.f1429e = bArr;
        this.f1431g = C1145c.m3344b();
        this.f1432h = C1191O.m3127a(context);
        C1195T m3119a = C1195T.m3119a();
        this.f1433i = m3119a;
        this.f1434j = i;
        this.f1437m = str;
        this.f1438n = str2;
        this.f1435k = abstractC1192P;
        this.f1436l = m3119a.f1416d;
        this.f1428d = i2;
        if (i3 > 0) {
            this.f1425a = i3;
        }
        if (i4 > 0) {
            this.f1426b = i4;
        }
        this.f1443s = z2;
        this.f1439o = map;
    }

    public RunnableC1196U(Context context, int i, int i2, byte[] bArr, String str, String str2, AbstractC1192P abstractC1192P, boolean z, boolean z2) {
        this(context, i, i2, bArr, str, str2, abstractC1192P, z, 2, BuglyStrategy.C1080a.MAX_USERDATA_VALUE_LENGTH, z2, null);
    }

    /* renamed from: a */
    public static String m3096a(String str) {
        if (C1208ca.m3012b(str)) {
            return str;
        }
        try {
            return String.format("%s?aid=%s", str, UUID.randomUUID().toString());
        } catch (Throwable th) {
            C1199X.m3080b(th);
            return str;
        }
    }

    /* renamed from: a */
    public static boolean m3094a(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            C1199X.m3076e("[Upload] Headers is empty.", new Object[0]);
            return false;
        } else if (!map.containsKey(NotificationCompat.CATEGORY_STATUS)) {
            C1199X.m3076e("[Upload] Headers does not contain %s", NotificationCompat.CATEGORY_STATUS);
            return false;
        } else if (!map.containsKey("Bugly-Version")) {
            C1199X.m3076e("[Upload] Headers does not contain %s", "Bugly-Version");
            return false;
        } else {
            String str = map.get("Bugly-Version");
            if (!str.contains("bugly")) {
                C1199X.m3076e("[Upload] Bugly version is not valid: %s", str);
                return false;
            }
            C1199X.m3084a("[Upload] Bugly version from headers is: %s", str);
            return true;
        }
    }

    /* renamed from: a */
    public void m3101a() {
        this.f1433i.m3114a(this.f1434j, System.currentTimeMillis());
        AbstractC1192P abstractC1192P = this.f1435k;
        if (abstractC1192P != null) {
            abstractC1192P.mo3121a(this.f1428d);
        }
        AbstractC1192P abstractC1192P2 = this.f1436l;
        if (abstractC1192P2 != null) {
            abstractC1192P2.mo3121a(this.f1428d);
        }
    }

    /* renamed from: a */
    public void m3100a(int i, String str) {
        C1199X.m3081b("[Upload] Failed to upload(%d): %s", Integer.valueOf(i), str);
    }

    /* renamed from: a */
    public void m3099a(long j) {
        this.f1442r += j;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x002b  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m3097a(C1237qa c1237qa, boolean z, int i, String str, int i2) {
        String str2;
        AbstractC1192P abstractC1192P;
        AbstractC1192P abstractC1192P2;
        int i3 = this.f1428d;
        if (i3 != 630) {
            if (i3 != 640) {
                if (i3 != 830) {
                    if (i3 != 840) {
                        str2 = String.valueOf(i3);
                        if (z) {
                            C1199X.m3078c("[Upload] Success: %s", str2);
                        } else {
                            C1199X.m3081b("[Upload] Failed to upload(%d) %s: %s", Integer.valueOf(i), str2, str);
                        }
                        if (this.f1441q + this.f1442r > 0) {
                            this.f1433i.m3111a(this.f1433i.m3105a(this.f1443s) + this.f1441q + this.f1442r, this.f1443s);
                        }
                        abstractC1192P = this.f1435k;
                        if (abstractC1192P != null) {
                            abstractC1192P.mo3120a(this.f1428d, c1237qa, this.f1441q, this.f1442r, z, str);
                        }
                        abstractC1192P2 = this.f1436l;
                        if (abstractC1192P2 == null) {
                            return;
                        }
                        abstractC1192P2.mo3120a(this.f1428d, c1237qa, this.f1441q, this.f1442r, z, str);
                        return;
                    }
                }
            }
            str2 = "userinfo";
            if (z) {
            }
            if (this.f1441q + this.f1442r > 0) {
            }
            abstractC1192P = this.f1435k;
            if (abstractC1192P != null) {
            }
            abstractC1192P2 = this.f1436l;
            if (abstractC1192P2 == null) {
            }
        }
        str2 = "crash";
        if (z) {
        }
        if (this.f1441q + this.f1442r > 0) {
        }
        abstractC1192P = this.f1435k;
        if (abstractC1192P != null) {
        }
        abstractC1192P2 = this.f1436l;
        if (abstractC1192P2 == null) {
        }
    }

    /* renamed from: a */
    public void m3095a(String str, long j, String str2) {
        this.f1440p++;
        this.f1441q += j;
    }

    /* renamed from: a */
    public boolean m3098a(C1237qa c1237qa, C1140a c1140a, C1145c c1145c) {
        if (c1237qa == null) {
            C1199X.m3076e("resp == null!", new Object[0]);
            return false;
        }
        byte b = c1237qa.f1603c;
        if (b != 0) {
            C1199X.m3081b("resp result error %d", Byte.valueOf(b));
            return false;
        }
        try {
            if (!C1208ca.m3012b(c1237qa.f1609i) && !C1140a.m3394m().m3390q().equals(c1237qa.f1609i)) {
                C1185J.m3172a().m3166a(C1145c.f1108a, "device", c1237qa.f1609i.getBytes("UTF-8"), (AbstractC1184I) null, true);
                c1140a.m3402f(c1237qa.f1609i);
            }
        } catch (Throwable th) {
            C1199X.m3080b(th);
        }
        c1140a.f1069u = c1237qa.f1607g;
        int i = c1237qa.f1604d;
        if (i == 510) {
            byte[] bArr = c1237qa.f1605e;
            if (bArr == null) {
                C1199X.m3081b("[Upload] Strategy data is null. Response cmd: %d", Integer.valueOf(i));
                return false;
            }
            C1241sa c1241sa = (C1241sa) C1189M.m3130a(bArr, C1241sa.class);
            if (c1241sa == null) {
                C1199X.m3081b("[Upload] Failed to decode strategy from server. Response cmd: %d", Integer.valueOf(c1237qa.f1604d));
                return false;
            }
            c1145c.m3346a(c1241sa);
        }
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = 0;
        try {
            this.f1440p = 0;
            this.f1441q = 0L;
            this.f1442r = 0L;
            byte[] bArr = this.f1429e;
            if (C1141b.m3374c(this.f1427c) == null) {
                m3097a(null, false, 0, "network is not available", 0);
            } else if (bArr == null || bArr.length == 0) {
                m3097a(null, false, 0, "request package is empty!", 0);
            } else {
                C1199X.m3084a("[Upload] Run upload task with cmd: %d", Integer.valueOf(this.f1428d));
                if (this.f1427c != null && this.f1430f != null && this.f1431g != null && this.f1432h != null) {
                    StrategyBean m3342c = this.f1431g.m3342c();
                    if (m3342c == null) {
                        m3097a(null, false, 0, "illegal local strategy", 0);
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("tls", "1");
                    hashMap.put("prodId", this.f1430f.m3405e());
                    hashMap.put("bundleId", this.f1430f.f1041g);
                    hashMap.put("appVer", this.f1430f.f1008E);
                    if (this.f1439o != null) {
                        hashMap.putAll(this.f1439o);
                    }
                    hashMap.put("cmd", Integer.toString(this.f1428d));
                    hashMap.put("platformId", Byte.toString((byte) 1));
                    hashMap.put("sdkVer", this.f1430f.f1051l);
                    hashMap.put("strategylastUpdateTime", Long.toString(m3342c.f1098o));
                    byte[] m3008b = C1208ca.m3008b(bArr, 2);
                    if (m3008b == null) {
                        m3097a(null, false, 0, "failed to zip request body", 0);
                        return;
                    }
                    m3101a();
                    String str = this.f1437m;
                    int i2 = 0;
                    int i3 = 0;
                    while (true) {
                        int i4 = i3 + 1;
                        if (i3 >= this.f1425a) {
                            m3097a(null, false, i2, "failed after many attempts", 0);
                            return;
                        }
                        if (i4 > 1) {
                            C1199X.m3076e("[Upload] Failed to upload last time, wait and try(%d) again.", Integer.valueOf(i4));
                            C1208ca.m3007c(this.f1426b);
                            if (i4 == this.f1425a) {
                                C1199X.m3076e("[Upload] Use the back-up url at the last time: %s", this.f1438n);
                                str = this.f1438n;
                            }
                        }
                        C1199X.m3084a("[Upload] Send %d bytes", Integer.valueOf(m3008b.length));
                        str = m3096a(str);
                        C1199X.m3084a("[Upload] Upload to %s with cmd %d (pid=%d | tid=%d).", str, Integer.valueOf(this.f1428d), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                        byte[] m3125a = this.f1432h.m3125a(str, m3008b, this, hashMap);
                        if (m3125a == null) {
                            m3100a(1, "Failed to upload for no response!");
                        } else {
                            Map<String, String> map = this.f1432h.f1407c;
                            if (m3094a(map)) {
                                int parseInt = Integer.parseInt(map.get(NotificationCompat.CATEGORY_STATUS));
                                C1199X.m3084a("[Upload] Status from server is %d (pid=%d | tid=%d).", Integer.valueOf(parseInt), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                                if (parseInt != 0) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("status of server is ");
                                    sb.append(parseInt);
                                    m3097a(null, false, 1, sb.toString(), parseInt);
                                    return;
                                }
                                C1199X.m3084a("[Upload] Received %d bytes", Integer.valueOf(m3125a.length));
                                if (m3125a.length == 0) {
                                    for (Map.Entry<String, String> entry : map.entrySet()) {
                                        C1199X.m3084a("[Upload] HTTP headers from server: key = %s, value = %s", entry.getKey(), entry.getValue());
                                    }
                                    m3097a(null, false, 1, "response data from server is empty", 0);
                                    return;
                                }
                                byte[] m3020a = C1208ca.m3020a(m3125a, 2);
                                if (m3020a != null) {
                                    m3125a = m3020a;
                                }
                                C1237qa m3131a = C1189M.m3131a(m3125a, m3342c, true);
                                if (m3131a == null) {
                                    m3097a(null, false, 1, "failed to decode response package", 0);
                                    return;
                                }
                                Object[] objArr = new Object[2];
                                objArr[0] = Integer.valueOf(m3131a.f1604d);
                                if (m3131a.f1605e != null) {
                                    i = m3131a.f1605e.length;
                                }
                                objArr[1] = Integer.valueOf(i);
                                C1199X.m3084a("[Upload] Response cmd is: %d, length of sBuffer is: %d", objArr);
                                if (!m3098a(m3131a, this.f1430f, this.f1431g)) {
                                    m3097a(m3131a, false, 2, "failed to process response package", 0);
                                    return;
                                } else {
                                    m3097a(m3131a, true, 2, "successfully uploaded", 0);
                                    return;
                                }
                            }
                            C1199X.m3084a("[Upload] Headers from server is not valid, just try again (pid=%d | tid=%d).", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                            m3100a(1, "[Upload] Failed to upload for no status header.");
                            if (map != null) {
                                for (Map.Entry<String, String> entry2 : map.entrySet()) {
                                    C1199X.m3084a(String.format("[key]: %s, [value]: %s", entry2.getKey(), entry2.getValue()), new Object[0]);
                                }
                            }
                            C1199X.m3084a("[Upload] Failed to upload for no status header.", new Object[0]);
                        }
                        i3 = i4;
                        i2 = 1;
                    }
                }
                m3097a(null, false, 0, "illegal access error", 0);
            }
        } catch (Throwable th) {
            if (C1199X.m3080b(th)) {
                return;
            }
            th.printStackTrace();
        }
    }
}
