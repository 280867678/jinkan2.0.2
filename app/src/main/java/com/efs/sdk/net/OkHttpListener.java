package com.efs.sdk.net;

import android.text.TextUtils;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.integrationtesting.IntegrationTestingUtil;
import com.efs.sdk.base.protocol.record.EfsJSONLog;
import com.efs.sdk.net.p017a.C0809a;
import com.efs.sdk.net.p017a.C0824b;
import com.efs.sdk.net.p017a.C0825c;
import com.efs.sdk.net.p019b.C0826a;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes3.dex */
public class OkHttpListener extends EventListener {

    /* renamed from: a */
    public static AtomicInteger f426a = new AtomicInteger(0);

    /* renamed from: b */
    public String f427b;

    /* renamed from: c */
    public boolean f428c;

    /* renamed from: d */
    public List f429d = new ArrayList();

    /* renamed from: a */
    private void m3971a() {
        try {
            C0825c m3964c = C0809a.m3968a().m3964c(this.f427b);
            if (m3964c == null) {
                return;
            }
            Map<String, Long> map = m3964c.f488D;
            Map<String, Long> map2 = m3964c.f489E;
            map2.put(C0825c.f477s, Long.valueOf(C0826a.m3940a(map, C0825c.f459a, C0825c.f460b)));
            map2.put(C0825c.f478t, Long.valueOf(C0826a.m3940a(map, C0825c.f462d, C0825c.f463e)));
            map2.put(C0825c.f479u, Long.valueOf(C0826a.m3940a(map, C0825c.f465g, C0825c.f466h)));
            map2.put(C0825c.f480v, Long.valueOf(C0826a.m3940a(map, C0825c.f464f, C0825c.f467i)));
            map2.put(C0825c.f481w, Long.valueOf(C0826a.m3940a(map, C0825c.f469k, C0825c.f470l)));
            map2.put(C0825c.f482x, Long.valueOf(C0826a.m3940a(map, C0825c.f471m, C0825c.f472n)));
            map2.put(C0825c.f483y, Long.valueOf(C0826a.m3940a(map, C0825c.f473o, C0825c.f474p)));
            map2.put(C0825c.f484z, Long.valueOf(C0826a.m3940a(map, C0825c.f475q, C0825c.f476r)));
            m3969b();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m3970a(String str) {
        Map<String, Long> map;
        try {
            C0825c m3964c = C0809a.m3968a().m3964c(this.f427b);
            if (m3964c == null || (map = m3964c.f488D) == null) {
                return;
            }
            map.put(str, Long.valueOf(System.currentTimeMillis()));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x01df A[Catch: all -> 0x02ea, TryCatch #0 {all -> 0x02ea, blocks: (B:3:0x0002, B:6:0x001a, B:8:0x002d, B:10:0x003c, B:11:0x0047, B:13:0x004f, B:14:0x005a, B:16:0x0062, B:17:0x006d, B:19:0x0075, B:20:0x0080, B:22:0x0088, B:23:0x0093, B:25:0x009b, B:26:0x00a6, B:28:0x00ae, B:29:0x00b9, B:31:0x00c1, B:32:0x00cc, B:34:0x00d4, B:35:0x00df, B:37:0x00e7, B:38:0x00f2, B:40:0x00fa, B:41:0x0105, B:43:0x010d, B:45:0x0115, B:46:0x0137, B:48:0x013f, B:49:0x014a, B:51:0x0152, B:52:0x015d, B:54:0x0165, B:56:0x016d, B:57:0x018f, B:59:0x019b, B:60:0x019d, B:64:0x01a9, B:66:0x01b1, B:68:0x01be, B:69:0x01c4, B:70:0x01d7, B:72:0x01df, B:73:0x01e8, B:75:0x01f0, B:77:0x01f8, B:78:0x0215, B:79:0x0219, B:81:0x0221, B:82:0x0252, B:84:0x025a, B:85:0x0265, B:87:0x026d, B:88:0x0278, B:90:0x0280, B:91:0x028b, B:93:0x02ce, B:97:0x01c8, B:99:0x01d0, B:100:0x023f, B:101:0x02e4), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01f0 A[Catch: all -> 0x02ea, TryCatch #0 {all -> 0x02ea, blocks: (B:3:0x0002, B:6:0x001a, B:8:0x002d, B:10:0x003c, B:11:0x0047, B:13:0x004f, B:14:0x005a, B:16:0x0062, B:17:0x006d, B:19:0x0075, B:20:0x0080, B:22:0x0088, B:23:0x0093, B:25:0x009b, B:26:0x00a6, B:28:0x00ae, B:29:0x00b9, B:31:0x00c1, B:32:0x00cc, B:34:0x00d4, B:35:0x00df, B:37:0x00e7, B:38:0x00f2, B:40:0x00fa, B:41:0x0105, B:43:0x010d, B:45:0x0115, B:46:0x0137, B:48:0x013f, B:49:0x014a, B:51:0x0152, B:52:0x015d, B:54:0x0165, B:56:0x016d, B:57:0x018f, B:59:0x019b, B:60:0x019d, B:64:0x01a9, B:66:0x01b1, B:68:0x01be, B:69:0x01c4, B:70:0x01d7, B:72:0x01df, B:73:0x01e8, B:75:0x01f0, B:77:0x01f8, B:78:0x0215, B:79:0x0219, B:81:0x0221, B:82:0x0252, B:84:0x025a, B:85:0x0265, B:87:0x026d, B:88:0x0278, B:90:0x0280, B:91:0x028b, B:93:0x02ce, B:97:0x01c8, B:99:0x01d0, B:100:0x023f, B:101:0x02e4), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x025a A[Catch: all -> 0x02ea, TryCatch #0 {all -> 0x02ea, blocks: (B:3:0x0002, B:6:0x001a, B:8:0x002d, B:10:0x003c, B:11:0x0047, B:13:0x004f, B:14:0x005a, B:16:0x0062, B:17:0x006d, B:19:0x0075, B:20:0x0080, B:22:0x0088, B:23:0x0093, B:25:0x009b, B:26:0x00a6, B:28:0x00ae, B:29:0x00b9, B:31:0x00c1, B:32:0x00cc, B:34:0x00d4, B:35:0x00df, B:37:0x00e7, B:38:0x00f2, B:40:0x00fa, B:41:0x0105, B:43:0x010d, B:45:0x0115, B:46:0x0137, B:48:0x013f, B:49:0x014a, B:51:0x0152, B:52:0x015d, B:54:0x0165, B:56:0x016d, B:57:0x018f, B:59:0x019b, B:60:0x019d, B:64:0x01a9, B:66:0x01b1, B:68:0x01be, B:69:0x01c4, B:70:0x01d7, B:72:0x01df, B:73:0x01e8, B:75:0x01f0, B:77:0x01f8, B:78:0x0215, B:79:0x0219, B:81:0x0221, B:82:0x0252, B:84:0x025a, B:85:0x0265, B:87:0x026d, B:88:0x0278, B:90:0x0280, B:91:0x028b, B:93:0x02ce, B:97:0x01c8, B:99:0x01d0, B:100:0x023f, B:101:0x02e4), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x026d A[Catch: all -> 0x02ea, TryCatch #0 {all -> 0x02ea, blocks: (B:3:0x0002, B:6:0x001a, B:8:0x002d, B:10:0x003c, B:11:0x0047, B:13:0x004f, B:14:0x005a, B:16:0x0062, B:17:0x006d, B:19:0x0075, B:20:0x0080, B:22:0x0088, B:23:0x0093, B:25:0x009b, B:26:0x00a6, B:28:0x00ae, B:29:0x00b9, B:31:0x00c1, B:32:0x00cc, B:34:0x00d4, B:35:0x00df, B:37:0x00e7, B:38:0x00f2, B:40:0x00fa, B:41:0x0105, B:43:0x010d, B:45:0x0115, B:46:0x0137, B:48:0x013f, B:49:0x014a, B:51:0x0152, B:52:0x015d, B:54:0x0165, B:56:0x016d, B:57:0x018f, B:59:0x019b, B:60:0x019d, B:64:0x01a9, B:66:0x01b1, B:68:0x01be, B:69:0x01c4, B:70:0x01d7, B:72:0x01df, B:73:0x01e8, B:75:0x01f0, B:77:0x01f8, B:78:0x0215, B:79:0x0219, B:81:0x0221, B:82:0x0252, B:84:0x025a, B:85:0x0265, B:87:0x026d, B:88:0x0278, B:90:0x0280, B:91:0x028b, B:93:0x02ce, B:97:0x01c8, B:99:0x01d0, B:100:0x023f, B:101:0x02e4), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0280 A[Catch: all -> 0x02ea, TryCatch #0 {all -> 0x02ea, blocks: (B:3:0x0002, B:6:0x001a, B:8:0x002d, B:10:0x003c, B:11:0x0047, B:13:0x004f, B:14:0x005a, B:16:0x0062, B:17:0x006d, B:19:0x0075, B:20:0x0080, B:22:0x0088, B:23:0x0093, B:25:0x009b, B:26:0x00a6, B:28:0x00ae, B:29:0x00b9, B:31:0x00c1, B:32:0x00cc, B:34:0x00d4, B:35:0x00df, B:37:0x00e7, B:38:0x00f2, B:40:0x00fa, B:41:0x0105, B:43:0x010d, B:45:0x0115, B:46:0x0137, B:48:0x013f, B:49:0x014a, B:51:0x0152, B:52:0x015d, B:54:0x0165, B:56:0x016d, B:57:0x018f, B:59:0x019b, B:60:0x019d, B:64:0x01a9, B:66:0x01b1, B:68:0x01be, B:69:0x01c4, B:70:0x01d7, B:72:0x01df, B:73:0x01e8, B:75:0x01f0, B:77:0x01f8, B:78:0x0215, B:79:0x0219, B:81:0x0221, B:82:0x0252, B:84:0x025a, B:85:0x0265, B:87:0x026d, B:88:0x0278, B:90:0x0280, B:91:0x028b, B:93:0x02ce, B:97:0x01c8, B:99:0x01d0, B:100:0x023f, B:101:0x02e4), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02ce A[Catch: all -> 0x02ea, TryCatch #0 {all -> 0x02ea, blocks: (B:3:0x0002, B:6:0x001a, B:8:0x002d, B:10:0x003c, B:11:0x0047, B:13:0x004f, B:14:0x005a, B:16:0x0062, B:17:0x006d, B:19:0x0075, B:20:0x0080, B:22:0x0088, B:23:0x0093, B:25:0x009b, B:26:0x00a6, B:28:0x00ae, B:29:0x00b9, B:31:0x00c1, B:32:0x00cc, B:34:0x00d4, B:35:0x00df, B:37:0x00e7, B:38:0x00f2, B:40:0x00fa, B:41:0x0105, B:43:0x010d, B:45:0x0115, B:46:0x0137, B:48:0x013f, B:49:0x014a, B:51:0x0152, B:52:0x015d, B:54:0x0165, B:56:0x016d, B:57:0x018f, B:59:0x019b, B:60:0x019d, B:64:0x01a9, B:66:0x01b1, B:68:0x01be, B:69:0x01c4, B:70:0x01d7, B:72:0x01df, B:73:0x01e8, B:75:0x01f0, B:77:0x01f8, B:78:0x0215, B:79:0x0219, B:81:0x0221, B:82:0x0252, B:84:0x025a, B:85:0x0265, B:87:0x026d, B:88:0x0278, B:90:0x0280, B:91:0x028b, B:93:0x02ce, B:97:0x01c8, B:99:0x01d0, B:100:0x023f, B:101:0x02e4), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m3969b() {
        int i;
        EfsReporter reporter;
        Long l;
        try {
            C0825c m3964c = C0809a.m3968a().m3964c(this.f427b);
            C0824b m3967a = C0809a.m3968a().m3967a(this.f427b);
            if (m3964c == null || m3967a == null) {
                return;
            }
            Map<String, Long> map = m3964c.f488D;
            Map<String, Long> map2 = m3964c.f489E;
            Log.m4062i("NetTrace-Listener", m3967a.toString());
            if (TextUtils.isEmpty(m3964c.f486B)) {
                Log.m4070d("NetTrace-Listener", "url is null.");
                return;
            }
            EfsJSONLog efsJSONLog = new EfsJSONLog("netperf");
            if (map.containsKey(C0825c.f462d)) {
                efsJSONLog.put("wd_dns", map.get(C0825c.f462d));
            }
            if (map.containsKey(C0825c.f463e)) {
                efsJSONLog.put("wd_dnstm", map.get(C0825c.f463e));
            }
            if (map2.containsKey(C0825c.f478t)) {
                efsJSONLog.put("wl_dns", map2.get(C0825c.f478t));
            }
            if (map.containsKey(C0825c.f464f)) {
                efsJSONLog.put("wd_tcp", map.get(C0825c.f464f));
            }
            if (map.containsKey(C0825c.f467i)) {
                efsJSONLog.put("wd_tcptm", map.get(C0825c.f467i));
            }
            if (map2.containsKey(C0825c.f480v)) {
                efsJSONLog.put("wl_tcp", map2.get(C0825c.f480v));
            }
            if (map.containsKey(C0825c.f465g)) {
                efsJSONLog.put("wd_ssl", map.get(C0825c.f465g));
            }
            if (map.containsKey(C0825c.f466h)) {
                efsJSONLog.put("wd_ssltm", map.get(C0825c.f466h));
            }
            if (map2.containsKey(C0825c.f479u)) {
                efsJSONLog.put("wl_ssl", map2.get(C0825c.f479u));
            }
            if (map.containsKey(C0825c.f469k)) {
                efsJSONLog.put("wd_ds", map.get(C0825c.f469k));
            }
            if (map.containsKey(C0825c.f472n)) {
                efsJSONLog.put("wd_dstm", map.get(C0825c.f472n));
            }
            if (map2.containsKey(C0825c.f481w) && map2.containsKey(C0825c.f482x)) {
                efsJSONLog.put("wl_ds", Long.valueOf(map2.get(C0825c.f481w).longValue() + map2.get(C0825c.f482x).longValue()));
            }
            if (map.containsKey(C0825c.f473o)) {
                efsJSONLog.put("wd_srt", map.get(C0825c.f473o));
            }
            if (map.containsKey(C0825c.f476r)) {
                efsJSONLog.put("wd_srttm", map.get(C0825c.f476r));
            }
            if (map2.containsKey(C0825c.f483y) && map2.containsKey(C0825c.f484z)) {
                efsJSONLog.put("wl_srt", Long.valueOf(map2.get(C0825c.f483y).longValue() + map2.get(C0825c.f484z).longValue()));
            }
            String str = null;
            String[] split = m3964c.f486B.split("\\?");
            if (split != null) {
                str = split[0];
            }
            if (this.f429d == null || str == null || this.f429d.contains(str)) {
                efsJSONLog.put("wd_ttfb", 0);
                efsJSONLog.put("wd_ttfbtm", 0);
                i = 0;
            } else {
                this.f429d.add(str);
                if (!map.containsKey(C0825c.f472n)) {
                    if (map.containsKey(C0825c.f470l)) {
                        l = map.get(C0825c.f470l);
                    }
                    if (map.containsKey(C0825c.f473o)) {
                        efsJSONLog.put("wd_ttfbtm", map.get(C0825c.f473o));
                    }
                    if (map.containsKey(C0825c.f473o)) {
                        if (map.containsKey(C0825c.f472n)) {
                            i = Long.valueOf(map.get(C0825c.f473o).longValue() - map.get(C0825c.f472n).longValue());
                        } else if (map.containsKey(C0825c.f470l)) {
                            i = Long.valueOf(map.get(C0825c.f473o).longValue() - map.get(C0825c.f470l).longValue());
                        }
                    }
                    if (map.containsKey(C0825c.f459a)) {
                        efsJSONLog.put("wd_rt", map.get(C0825c.f459a));
                    }
                    if (map.containsKey(C0825c.f460b)) {
                        efsJSONLog.put("wd_rttm", map.get(C0825c.f460b));
                    }
                    if (map2.containsKey(C0825c.f477s)) {
                        efsJSONLog.put("wl_rt", map2.get(C0825c.f477s));
                    }
                    efsJSONLog.put("wk_res", m3964c.f486B);
                    efsJSONLog.put("wk_method", m3967a.f454e);
                    efsJSONLog.put("wk_rc", Integer.valueOf(m3967a.f456g));
                    efsJSONLog.put("wl_up", Long.valueOf(m3967a.f455f));
                    efsJSONLog.put("wl_down", Long.valueOf(m3967a.f458i));
                    efsJSONLog.put("wl_total", Long.valueOf(m3967a.f455f + m3967a.f458i));
                    reporter = NetManager.getReporter();
                    if (reporter == null) {
                        return;
                    }
                    reporter.send(efsJSONLog);
                    C0809a.m3968a().m3963d(this.f427b);
                    C0809a.m3968a().m3965b(this.f427b);
                    return;
                }
                l = map.get(C0825c.f472n);
                efsJSONLog.put("wd_ttfb", l);
                if (map.containsKey(C0825c.f473o)) {
                }
                if (map.containsKey(C0825c.f473o)) {
                }
                if (map.containsKey(C0825c.f459a)) {
                }
                if (map.containsKey(C0825c.f460b)) {
                }
                if (map2.containsKey(C0825c.f477s)) {
                }
                efsJSONLog.put("wk_res", m3964c.f486B);
                efsJSONLog.put("wk_method", m3967a.f454e);
                efsJSONLog.put("wk_rc", Integer.valueOf(m3967a.f456g));
                efsJSONLog.put("wl_up", Long.valueOf(m3967a.f455f));
                efsJSONLog.put("wl_down", Long.valueOf(m3967a.f458i));
                efsJSONLog.put("wl_total", Long.valueOf(m3967a.f455f + m3967a.f458i));
                reporter = NetManager.getReporter();
                if (reporter == null) {
                }
            }
            efsJSONLog.put("wl_ttfb", i);
            if (map.containsKey(C0825c.f459a)) {
            }
            if (map.containsKey(C0825c.f460b)) {
            }
            if (map2.containsKey(C0825c.f477s)) {
            }
            efsJSONLog.put("wk_res", m3964c.f486B);
            efsJSONLog.put("wk_method", m3967a.f454e);
            efsJSONLog.put("wk_rc", Integer.valueOf(m3967a.f456g));
            efsJSONLog.put("wl_up", Long.valueOf(m3967a.f455f));
            efsJSONLog.put("wl_down", Long.valueOf(m3967a.f458i));
            efsJSONLog.put("wl_total", Long.valueOf(m3967a.f455f + m3967a.f458i));
            reporter = NetManager.getReporter();
            if (reporter == null) {
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static EventListener.Factory get() {
        return new EventListener.Factory() { // from class: com.efs.sdk.net.OkHttpListener.1
            @Override // okhttp3.EventListener.Factory
            public final EventListener create(Call call) {
                return new OkHttpListener();
            }
        };
    }

    @Override // okhttp3.EventListener
    public void callEnd(Call call) {
        super.callEnd(call);
        try {
            Log.m4070d("NetTrace-Listener", "callEnd");
            if (!this.f428c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.m4070d("NetTrace-Listener", "callEnd net enable false.");
                return;
            }
            m3970a(C0825c.f460b);
            m3971a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void callFailed(Call call, IOException iOException) {
        super.callFailed(call, iOException);
        try {
            Log.m4070d("NetTrace-Listener", "callFailed");
            if (!this.f428c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.m4070d("NetTrace-Listener", "callFailed net enable false.");
                return;
            }
            m3970a(C0825c.f461c);
            m3971a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void callStart(Call call) {
        super.callStart(call);
        try {
            Log.m4070d("NetTrace-Listener", "callStart");
            if (NetManager.getNetConfigManager() != null && NetManager.getNetConfigManager().enableTracer()) {
                this.f428c = true;
            }
            if (!this.f428c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.m4070d("NetTrace-Listener", "callStart net enable false.");
                return;
            }
            this.f427b = String.valueOf(f426a.getAndIncrement());
            Log.m4062i("NetTrace-Listener", "requestId is" + this.f427b);
            m3970a(C0825c.f459a);
            String httpUrl = call.request().url().toString();
            C0825c m3964c = C0809a.m3968a().m3964c(this.f427b);
            if (m3964c == null) {
                return;
            }
            m3964c.f486B = httpUrl;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        super.connectEnd(call, inetSocketAddress, proxy, protocol);
        try {
            Log.m4070d("NetTrace-Listener", "connectEnd");
            if (!this.f428c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.m4070d("NetTrace-Listener", "connectEnd net enable false.");
                return;
            }
            m3970a(C0825c.f467i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        super.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
        try {
            Log.m4070d("NetTrace-Listener", "connectFailed");
            if (!this.f428c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.m4070d("NetTrace-Listener", "connectFailed net enable false.");
                return;
            }
            m3970a(C0825c.f468j);
            m3971a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        super.connectStart(call, inetSocketAddress, proxy);
        try {
            Log.m4070d("NetTrace-Listener", "connectStart");
            if (!this.f428c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.m4070d("NetTrace-Listener", "connectStart net enable false.");
                return;
            }
            m3970a(C0825c.f464f);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        super.dnsEnd(call, str, list);
        try {
            Log.m4070d("NetTrace-Listener", "dnsEnd");
            if (!this.f428c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.m4070d("NetTrace-Listener", "dnsEnd net enable false.");
                return;
            }
            m3970a(C0825c.f463e);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void dnsStart(Call call, String str) {
        super.dnsStart(call, str);
        try {
            Log.m4070d("NetTrace-Listener", "dnsStart");
            if (!this.f428c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.m4070d("NetTrace-Listener", "dnsStart net enable false.");
                return;
            }
            m3970a(C0825c.f462d);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void requestBodyEnd(Call call, long j) {
        super.requestBodyEnd(call, j);
        try {
            Log.m4070d("NetTrace-Listener", "requestBodyEnd");
            if (!this.f428c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.m4070d("NetTrace-Listener", "requestBodyEnd net enable false.");
                return;
            }
            m3970a(C0825c.f472n);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void requestBodyStart(Call call) {
        super.requestBodyStart(call);
        try {
            Log.m4070d("NetTrace-Listener", "requestBodyStart");
            if (!this.f428c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.m4070d("NetTrace-Listener", "requestBodyStart net enable false.");
                return;
            }
            m3970a(C0825c.f471m);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void requestHeadersEnd(Call call, Request request) {
        super.requestHeadersEnd(call, request);
        try {
            Log.m4070d("NetTrace-Listener", "requestHeadersEnd");
            if (!this.f428c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.m4070d("NetTrace-Listener", "requestHeadersEnd net enable false.");
                return;
            }
            m3970a(C0825c.f470l);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void requestHeadersStart(Call call) {
        super.requestHeadersStart(call);
        try {
            Log.m4070d("NetTrace-Listener", "requestHeadersStart");
            if (!this.f428c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.m4070d("NetTrace-Listener", "requestHeadersStart net enable false.");
                return;
            }
            m3970a(C0825c.f469k);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void responseBodyEnd(Call call, long j) {
        super.responseBodyEnd(call, j);
        try {
            Log.m4070d("NetTrace-Listener", "responseBodyEnd");
            if (!this.f428c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.m4070d("NetTrace-Listener", "responseBodyEnd net enable false.");
                return;
            }
            m3970a(C0825c.f476r);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void responseBodyStart(Call call) {
        super.responseBodyStart(call);
        try {
            Log.m4070d("NetTrace-Listener", "responseBodyStart");
            if (!this.f428c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.m4070d("NetTrace-Listener", "responseBodyStart net enable false.");
                return;
            }
            m3970a(C0825c.f475q);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void responseHeadersEnd(Call call, Response response) {
        super.responseHeadersEnd(call, response);
        try {
            Log.m4070d("NetTrace-Listener", "responseHeadersEnd");
            if (!this.f428c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.m4070d("NetTrace-Listener", "responseHeadersEnd net enable false.");
                return;
            }
            m3970a(C0825c.f474p);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void responseHeadersStart(Call call) {
        super.responseHeadersStart(call);
        try {
            Log.m4070d("NetTrace-Listener", "responseHeadersStart");
            if (!this.f428c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.m4070d("NetTrace-Listener", "responseHeadersStart net enable false.");
                return;
            }
            m3970a(C0825c.f473o);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void secureConnectEnd(Call call, Handshake handshake) {
        super.secureConnectEnd(call, handshake);
        try {
            Log.m4070d("NetTrace-Listener", "secureConnectEnd");
            if (!this.f428c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.m4070d("NetTrace-Listener", "secureConnectEnd net enable false.");
                return;
            }
            m3970a(C0825c.f466h);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void secureConnectStart(Call call) {
        super.secureConnectStart(call);
        try {
            Log.m4070d("NetTrace-Listener", "secureConnectStart");
            if (!this.f428c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.m4070d("NetTrace-Listener", "secureConnectStart net enable false.");
                return;
            }
            m3970a(C0825c.f465g);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
