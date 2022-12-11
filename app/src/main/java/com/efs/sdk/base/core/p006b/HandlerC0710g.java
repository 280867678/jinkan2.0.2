package com.efs.sdk.base.core.p006b;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.efs.sdk.base.core.config.p008a.C0729c;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.p006b.C0701a;
import com.efs.sdk.base.core.p010d.C0739b;
import com.efs.sdk.base.core.p011e.p012a.C0745c;
import com.efs.sdk.base.core.p011e.p012a.C0746d;
import com.efs.sdk.base.core.p013f.C0759f;
import com.efs.sdk.base.core.util.C0763a;
import com.efs.sdk.base.core.util.C0769b;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.p014a.C0764a;
import com.efs.sdk.base.core.util.p016c.C0777b;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.efs.sdk.base.core.b.g */
/* loaded from: classes3.dex */
public final class HandlerC0710g extends Handler implements AbstractC0708e {

    /* renamed from: a */
    public final ConcurrentHashMap<String, C0711a> f193a = new ConcurrentHashMap<>();

    /* renamed from: b */
    public C0746d f194b = new C0746d();

    /* renamed from: c */
    public C0745c f195c = new C0745c();

    /* renamed from: com.efs.sdk.base.core.b.g$a */
    /* loaded from: classes3.dex */
    public static class C0711a extends FileOutputStream {

        /* renamed from: a */
        public long f196a = System.currentTimeMillis();

        /* renamed from: b */
        public File f197b;

        public C0711a(@NonNull File file) {
            super(file);
            this.f197b = file;
        }
    }

    public HandlerC0710g() {
        super(C0764a.f317a.getLooper());
    }

    /* renamed from: a */
    private boolean m4158a(C0739b c0739b, File file) {
        BufferedReader bufferedReader;
        StringBuilder sb = new StringBuilder();
        FileReader fileReader = null;
        try {
            FileReader fileReader2 = new FileReader(file);
            try {
                bufferedReader = new BufferedReader(fileReader2);
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            c0739b.m4095a(sb.toString().getBytes());
                            c0739b.m4092c();
                            this.f195c.mo4087a(c0739b);
                            c0739b.f281d = file;
                            C0769b.m4037a(bufferedReader);
                            C0769b.m4037a(fileReader2);
                            return true;
                        }
                        String m4006b = C0777b.m4006b(readLine.getBytes());
                        if (!TextUtils.isEmpty(m4006b)) {
                            sb.append(m4006b);
                            sb.append("\n");
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileReader = fileReader2;
                        try {
                            Log.m4065e("efs.cache", "local decode error", th);
                            C0769b.m4037a(bufferedReader);
                            C0769b.m4037a(fileReader);
                            return false;
                        } catch (Throwable th2) {
                            C0769b.m4037a(bufferedReader);
                            C0769b.m4037a(fileReader);
                            throw th2;
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
        }
    }

    /* renamed from: b */
    public static long m4153b(String str) {
        Map<String, String> m4119c = C0729c.m4127a().m4119c();
        String concat = "record_accumulation_time_".concat(String.valueOf(str));
        if (!m4119c.containsKey(concat)) {
            return 60000L;
        }
        String str2 = m4119c.get(concat);
        if (TextUtils.isEmpty(str2)) {
            return 60000L;
        }
        try {
            return Math.max(Long.parseLong(str2) * 1000, 1000L);
        } catch (Throwable th) {
            Log.m4065e("efs.cache", "get cache interval error", th);
            return 60000L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x007c  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private C0711a m4154b(C0739b c0739b) {
        C0711a c0711a;
        Throwable th;
        C0759f c0759f;
        C0711a putIfAbsent;
        if (this.f193a.containsKey(c0739b.f278a.f271a)) {
            return this.f193a.get(c0739b.f278a.f271a);
        }
        File file = new File(C0763a.m4045e(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid()), C0769b.m4038a(c0739b));
        try {
            c0711a = new C0711a(file);
            try {
                putIfAbsent = this.f193a.putIfAbsent(c0739b.f278a.f271a, c0711a);
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                if (!"wa".equalsIgnoreCase(c0739b.f278a.f271a)) {
                }
                return c0711a;
            }
        } catch (Throwable th3) {
            c0711a = null;
            th = th3;
        }
        if (putIfAbsent != null) {
            C0769b.m4037a(c0711a);
            C0769b.m4031b(file);
            return putIfAbsent;
        }
        Message obtain = Message.obtain();
        obtain.obj = c0739b.f278a.f271a;
        obtain.what = 1;
        sendMessageDelayed(obtain, m4153b(c0739b.f278a.f271a));
        if (!"wa".equalsIgnoreCase(c0739b.f278a.f271a)) {
            c0759f = C0759f.C0760a.f309a;
            c0759f.f307c.m4084b();
        }
        return c0711a;
    }

    /* renamed from: c */
    private void m4152c(String str) {
        C0711a c0711a;
        C0759f c0759f;
        if (this.f193a.containsKey(str) && (c0711a = this.f193a.get(str)) != null) {
            try {
                c0711a.flush();
                C0769b.m4037a(c0711a);
                mo4157a(c0711a.f197b);
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    this.f193a.remove(str);
                    if ("wa".equalsIgnoreCase(str)) {
                    }
                } finally {
                    this.f193a.remove(str);
                    if (!"wa".equalsIgnoreCase(str)) {
                        c0759f = C0759f.C0760a.f309a;
                        c0759f.f307c.m4083c();
                    }
                }
            }
        }
    }

    @Override // com.efs.sdk.base.core.p006b.AbstractC0708e
    /* renamed from: a */
    public final void mo4159a(C0739b c0739b) {
        Message obtain = Message.obtain();
        obtain.obj = c0739b;
        obtain.what = 0;
        sendMessage(obtain);
    }

    @Override // com.efs.sdk.base.core.p006b.AbstractC0708e
    /* renamed from: a */
    public final void mo4157a(File file) {
        byte[] bArr;
        C0701a unused;
        C0701a unused2;
        C0739b m4030b = C0769b.m4030b(file.getName());
        if (m4030b == null) {
            unused = C0701a.C0703b.f189a;
            C0701a.m4165b(file);
        } else if (!m4158a(m4030b, file) || (bArr = m4030b.f280c) == null || bArr.length <= 0) {
            unused2 = C0701a.C0703b.f189a;
            C0701a.m4165b(file);
        } else {
            C0769b.m4033a(new File(C0763a.m4044f(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid()), C0769b.m4038a(m4030b)), m4030b.f280c);
            C0769b.m4031b(file);
        }
    }

    @Override // com.efs.sdk.base.core.p006b.AbstractC0708e
    /* renamed from: a */
    public final void mo4155a(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.obj = str;
        obtain.what = 1;
        sendMessage(obtain);
    }

    @Override // com.efs.sdk.base.core.p006b.AbstractC0708e
    /* renamed from: a */
    public final boolean mo4156a(File file, C0739b c0739b) {
        if (!c0739b.m4094b()) {
            mo4157a(file);
            return false;
        } else if (!file.exists()) {
            return false;
        } else {
            c0739b.f281d = file;
            c0739b.m4092c();
            c0739b.m4093b(1);
            return true;
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(@NonNull Message message) {
        int i = message.what;
        if (i != 0) {
            if (i != 1) {
                return;
            }
            Object obj = message.obj;
            if (!(obj instanceof String)) {
                return;
            }
            m4152c(obj.toString());
            return;
        }
        C0739b c0739b = (C0739b) message.obj;
        for (int i2 = 0; i2 < 3; i2++) {
            try {
                C0711a m4154b = m4154b(c0739b);
                if (m4154b == null) {
                    Log.m4054w("efs.cache", "writer is null for type " + c0739b.f278a.f271a);
                    return;
                }
                if (m4154b.getChannel().position() + c0739b.f280c.length > 819200) {
                    m4152c(c0739b.f278a.f271a);
                    m4154b = m4154b(c0739b);
                    if (m4154b == null) {
                        Log.m4054w("efs.cache", "writer is null for type " + c0739b.f278a.f271a);
                        return;
                    }
                }
                m4154b.write(Base64.encode(c0739b.f280c, 11));
                m4154b.write("\n".getBytes());
                return;
            } catch (Throwable th) {
                Log.m4065e("efs.cache", "cache file error", th);
            }
        }
    }
}
