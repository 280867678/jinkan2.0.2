package com.efs.sdk.base.core.p007c;

import android.os.Handler;
import android.os.Message;
import com.efs.sdk.base.core.config.C0734b;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.p006b.AbstractC0709f;
import com.efs.sdk.base.core.p006b.C0701a;
import com.efs.sdk.base.core.p006b.C0712h;
import com.efs.sdk.base.core.p007c.C0722f;
import com.efs.sdk.base.core.p010d.C0739b;
import com.efs.sdk.base.core.p013f.C0755b;
import com.efs.sdk.base.core.p013f.C0758e;
import com.efs.sdk.base.core.p013f.C0759f;
import com.efs.sdk.base.core.util.C0763a;
import com.efs.sdk.base.core.util.C0769b;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.efs.sdk.base.core.util.p014a.C0764a;
import com.efs.sdk.base.core.util.p014a.C0767d;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.efs.sdk.base.core.c.d */
/* loaded from: classes3.dex */
public final class HandlerC0719d extends Handler {

    /* renamed from: a */
    public int f206a;

    /* renamed from: b */
    public AbstractC0718c f207b;

    /* renamed from: c */
    public AbstractC0718c f208c;

    /* renamed from: d */
    public List<String> f209d;

    /* renamed from: e */
    public AtomicInteger f210e;

    /* renamed from: f */
    public AbstractC0709f f211f;

    /* renamed from: com.efs.sdk.base.core.c.d$a */
    /* loaded from: classes3.dex */
    public static class C0720a {

        /* renamed from: a */
        public static final HandlerC0719d f212a = new HandlerC0719d((byte) 0);
    }

    public HandlerC0719d() {
        super(C0764a.f317a.getLooper());
        this.f206a = 5;
        this.f209d = new ArrayList();
        this.f210e = new AtomicInteger(0);
        this.f207b = new C0713a();
        this.f208c = new C0758e();
        this.f211f = new C0712h();
    }

    public /* synthetic */ HandlerC0719d(byte b) {
        this();
    }

    /* renamed from: a */
    public static HandlerC0719d m4141a() {
        return C0720a.f212a;
    }

    /* renamed from: a */
    public final void m4140a(Object obj, int i) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = obj;
        obtain.arg1 = i;
        sendMessage(obtain);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        C0722f c0722f;
        C0734b c0734b;
        C0701a c0701a;
        List<File> list;
        C0759f c0759f;
        super.handleMessage(message);
        c0722f = C0722f.C0724a.f220a;
        if (c0722f.m4138a()) {
            int i = message.what;
            if (i != 0) {
                if (i != 1) {
                    return;
                }
                Object obj = message.obj;
                if (obj != null) {
                    this.f209d.remove(obj.toString());
                }
                int incrementAndGet = message.arg1 != 0 ? this.f210e.incrementAndGet() : 0;
                if (!this.f209d.isEmpty()) {
                    return;
                }
                if (incrementAndGet < 5) {
                    sendEmptyMessage(0);
                    return;
                }
                this.f210e.set(0);
                sendEmptyMessageDelayed(0, ControllerCenter.getGlobalEnvStruct().getLogSendDelayMills());
                Log.m4062i("efs.send_log", "request error cnt gt 5, next request delay 10s");
                return;
            }
            c0734b = C0734b.C0735a.f259a;
            String m4104a = c0734b.m4104a();
            if (NetworkUtil.NETWORK_CLASS_DENIED.equalsIgnoreCase(m4104a) || NetworkUtil.NETWORK_CLASS_DISCONNECTED.equalsIgnoreCase(m4104a)) {
                Log.m4062i("efs.send_log", "log cann't be send because net status is ".concat(String.valueOf(m4104a)));
                sendEmptyMessageDelayed(0, ControllerCenter.getGlobalEnvStruct().getLogSendIntervalMills());
                return;
            }
            List<C0739b> emptyList = Collections.emptyList();
            try {
                c0701a = C0701a.C0703b.f189a;
                int i2 = this.f206a;
                AbstractC0709f abstractC0709f = this.f211f;
                c0701a.m4168a();
                c0701a.m4168a();
                File m4044f = C0763a.m4044f(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
                if (!m4044f.exists()) {
                    list = Collections.emptyList();
                } else {
                    List<File> m4028d = C0769b.m4028d(m4044f);
                    if (c0701a.f186b) {
                        c0759f = C0759f.C0760a.f309a;
                        int size = m4028d.size();
                        if (c0759f.f306b != null && ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
                            C0755b c0755b = new C0755b("efs_core", "log_lag", c0759f.f305a.f299c);
                            c0755b.put("cnt", Integer.valueOf(size));
                            c0759f.f306b.send(c0755b);
                        }
                        c0701a.f186b = false;
                    }
                    Collections.sort(m4028d, c0701a.f188d);
                    ArrayList arrayList = new ArrayList(i2);
                    for (int size2 = m4028d.size() - 1; size2 >= 0 && arrayList.size() < i2; size2--) {
                        File file = m4028d.get(size2);
                        if (file.exists() && (abstractC0709f == null || !abstractC0709f.mo4151a(file))) {
                            arrayList.add(file);
                        }
                    }
                    list = arrayList;
                }
                ArrayList arrayList2 = new ArrayList(i2);
                for (File file2 : list) {
                    C0739b m4167a = c0701a.m4167a(file2);
                    if (m4167a == null) {
                        Log.m4054w("efs.cache", "file upload error, name is " + file2.getName());
                    } else {
                        arrayList2.add(m4167a);
                    }
                }
                emptyList = arrayList2;
            } catch (Throwable unused) {
            }
            for (C0739b c0739b : emptyList) {
                if ("wa".equals(c0739b.f278a.f271a) || HandlerC0714b.m4150a().m4148a(c0739b.f278a.f271a, c0739b.m4099a())) {
                    AbstractC0718c abstractC0718c = this.f207b;
                    if ("wa".equals(c0739b.f278a.f271a)) {
                        abstractC0718c = this.f208c;
                    }
                    String uuid = UUID.randomUUID().toString();
                    this.f209d.add(uuid);
                    if (C0767d.m4041a(new RunnableC0721e(c0739b, abstractC0718c, uuid)) == null) {
                        m4140a(uuid, -1);
                    }
                }
            }
            if (this.f209d.size() > 0) {
                return;
            }
            sendEmptyMessageDelayed(0, ControllerCenter.getGlobalEnvStruct().getLogSendIntervalMills());
        }
    }
}
