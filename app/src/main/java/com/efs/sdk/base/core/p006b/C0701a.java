package com.efs.sdk.base.core.p006b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.p005a.C0694a;
import com.efs.sdk.base.core.p010d.C0739b;
import com.efs.sdk.base.core.p013f.C0759f;
import com.efs.sdk.base.core.util.C0763a;
import com.efs.sdk.base.core.util.C0769b;
import com.efs.sdk.base.core.util.C0778d;
import com.efs.sdk.base.core.util.Log;
import java.io.File;
import java.util.Comparator;
import java.util.List;

/* renamed from: com.efs.sdk.base.core.b.a */
/* loaded from: classes3.dex */
public final class C0701a {

    /* renamed from: a */
    public boolean f185a;

    /* renamed from: b */
    public boolean f186b;

    /* renamed from: c */
    public C0704b f187c;

    /* renamed from: d */
    public C0702a f188d;

    /* renamed from: com.efs.sdk.base.core.b.a$a */
    /* loaded from: classes3.dex */
    public static class C0702a implements Comparator<File> {
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(File file, File file2) {
            int i = ((file.lastModified() - file2.lastModified()) > 0L ? 1 : ((file.lastModified() - file2.lastModified()) == 0L ? 0 : -1));
            if (i > 0) {
                return 1;
            }
            return i == 0 ? 0 : -1;
        }
    }

    /* renamed from: com.efs.sdk.base.core.b.a$b */
    /* loaded from: classes3.dex */
    public static class C0703b {

        /* renamed from: a */
        public static final C0701a f189a = new C0701a((byte) 0);

        /* renamed from: a */
        public static /* synthetic */ C0701a m4163a() {
            return f189a;
        }
    }

    public C0701a() {
        this.f185a = false;
        this.f186b = true;
        this.f187c = new C0704b();
        this.f188d = new C0702a();
    }

    public /* synthetic */ C0701a(byte b) {
        this();
    }

    /* renamed from: a */
    public static boolean m4166a(String str) {
        try {
            long parseLong = Long.parseLong(str.substring(str.lastIndexOf("_") + 1));
            C0694a.m4184a();
            return Math.abs(C0694a.m4180b() - parseLong) >= 604800000;
        } catch (Throwable unused) {
            return true;
        }
    }

    /* renamed from: b */
    public static void m4165b(@NonNull File file) {
        C0759f c0759f;
        if (!file.getName().startsWith("wa_")) {
            c0759f = C0759f.C0760a.f309a;
            c0759f.f307c.m4081e();
        }
        C0769b.m4031b(file);
    }

    /* renamed from: c */
    public static void m4164c(File file) {
        C0759f c0759f;
        StringBuilder sb = new StringBuilder("file is expire: ");
        sb.append(file.getName());
        sb.append(", now is ");
        C0694a.m4184a();
        sb.append(C0694a.m4180b());
        Log.m4062i("efs.cache", sb.toString());
        if (!file.getName().startsWith("wa_")) {
            c0759f = C0759f.C0760a.f309a;
            c0759f.f307c.m4082d();
        }
        C0769b.m4031b(file);
    }

    @Nullable
    /* renamed from: a */
    public final C0739b m4167a(File file) {
        try {
            if (!file.exists()) {
                return null;
            }
            if (m4166a(file.getName())) {
                m4164c(file);
                return null;
            }
            C0739b m4030b = C0769b.m4030b(file.getName());
            if (m4030b == null) {
                m4165b(file);
                return null;
            }
            AbstractC0708e m4162a = this.f187c.m4162a(m4030b.f278a.f272b);
            if (m4162a == null) {
                m4165b(file);
                return null;
            } else if (m4162a.mo4156a(file, m4030b)) {
                return m4030b;
            } else {
                m4165b(file);
                return null;
            }
        } catch (Throwable th) {
            Log.m4052w("efs.cache", th);
            m4165b(file);
            return null;
        }
    }

    /* renamed from: a */
    public final void m4168a() {
        String[] list;
        AbstractC0708e m4162a;
        File m4046d = C0763a.m4046d(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
        if (!m4046d.exists() || !m4046d.isDirectory() || (list = m4046d.list()) == null || list.length <= 0) {
            return;
        }
        for (String str : list) {
            ControllerCenter.getGlobalEnvStruct();
            if (!C0778d.m4003a(str)) {
                File file = new File(m4046d, str);
                List<File> m4028d = C0769b.m4028d(file);
                if (!m4028d.isEmpty()) {
                    for (File file2 : m4028d) {
                        if (m4166a(file2.getName())) {
                            m4164c(file2);
                        } else {
                            C0739b m4030b = C0769b.m4030b(file2.getName());
                            if (m4030b == null || (m4162a = this.f187c.m4162a(m4030b.f278a.f272b)) == null) {
                                m4165b(file2);
                            } else {
                                m4162a.mo4157a(file2);
                            }
                        }
                    }
                }
                C0769b.m4031b(file);
            }
        }
    }
}
