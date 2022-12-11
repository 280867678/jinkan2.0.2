package com.umeng.commonsdk.statistics.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Locale;
import me.tvspark.outline;

/* renamed from: com.umeng.commonsdk.statistics.common.d */
/* loaded from: classes4.dex */
public final class C1777d {

    /* renamed from: a */
    public static C1777d f4056a = null;

    /* renamed from: b */
    public static Context f4057b = null;

    /* renamed from: c */
    public static String f4058c = null;

    /* renamed from: e */
    public static final String f4059e = "mobclick_agent_user_";

    /* renamed from: f */
    public static final String f4060f = "mobclick_agent_header_";

    /* renamed from: g */
    public static final String f4061g = "mobclick_agent_cached_";

    /* renamed from: d */
    public C1778a f4062d;

    /* renamed from: com.umeng.commonsdk.statistics.common.d$a */
    /* loaded from: classes4.dex */
    public static class C1778a {

        /* renamed from: a */
        public final int f4063a;

        /* renamed from: b */
        public File f4064b;

        /* renamed from: c */
        public FilenameFilter f4065c;

        public C1778a(Context context) {
            this(context, ".um");
        }

        public C1778a(Context context, String str) {
            this.f4063a = 10;
            this.f4065c = new FilenameFilter() { // from class: com.umeng.commonsdk.statistics.common.d.a.1
                @Override // java.io.FilenameFilter
                public boolean accept(File file, String str2) {
                    return str2.startsWith("um");
                }
            };
            File file = new File(context.getFilesDir(), str);
            this.f4064b = file;
            if (!file.exists() || !this.f4064b.isDirectory()) {
                this.f4064b.mkdir();
            }
        }

        /* renamed from: a */
        public void m494a(AbstractC1780b abstractC1780b) {
            File file;
            File[] listFiles = this.f4064b.listFiles(this.f4065c);
            if (listFiles != null && listFiles.length >= 10) {
                Arrays.sort(listFiles);
                int length = listFiles.length - 10;
                for (int i = 0; i < length; i++) {
                    listFiles[i].delete();
                }
            }
            if (listFiles == null || listFiles.length <= 0) {
                return;
            }
            abstractC1780b.m490a(this.f4064b);
            int length2 = listFiles.length;
            for (int i2 = 0; i2 < length2; i2++) {
                try {
                } catch (Throwable unused) {
                    file = listFiles[i2];
                }
                if (abstractC1780b.m489b(listFiles[i2])) {
                    file = listFiles[i2];
                    file.delete();
                }
            }
            abstractC1780b.m488c(this.f4064b);
        }

        /* renamed from: a */
        public void m493a(byte[] bArr) {
            if (bArr == null || bArr.length == 0) {
                return;
            }
            try {
                HelperUtils.writeFile(new File(this.f4064b, String.format(Locale.US, "um_cache_%d.env", Long.valueOf(System.currentTimeMillis()))), bArr);
            } catch (Exception unused) {
            }
        }

        /* renamed from: a */
        public boolean m495a() {
            File[] listFiles = this.f4064b.listFiles();
            return listFiles != null && listFiles.length > 0;
        }

        /* renamed from: b */
        public void m492b() {
            File[] listFiles = this.f4064b.listFiles(this.f4065c);
            if (listFiles == null || listFiles.length <= 0) {
                return;
            }
            for (File file : listFiles) {
                file.delete();
            }
        }

        /* renamed from: c */
        public int m491c() {
            File[] listFiles = this.f4064b.listFiles(this.f4065c);
            if (listFiles == null || listFiles.length <= 0) {
                return 0;
            }
            return listFiles.length;
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.common.d$b */
    /* loaded from: classes4.dex */
    public interface AbstractC1780b {
        /* renamed from: a */
        void m490a(File file);

        /* renamed from: b */
        boolean m489b(File file);

        /* renamed from: c */
        void m488c(File file);
    }

    public C1777d(Context context) {
        this.f4062d = new C1778a(context);
    }

    /* renamed from: a */
    public static synchronized C1777d m503a(Context context) {
        C1777d c1777d;
        synchronized (C1777d.class) {
            f4057b = StubApp.getOrigApplicationContext(context.getApplicationContext());
            f4058c = context.getPackageName();
            if (f4056a == null) {
                f4056a = new C1777d(context);
            }
            c1777d = f4056a;
        }
        return c1777d;
    }

    /* renamed from: f */
    private SharedPreferences m496f() {
        Context context = f4057b;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("mobclick_agent_user_");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(f4058c);
        return context.getSharedPreferences(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), 0);
    }

    /* renamed from: a */
    public int m505a() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f4057b);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("vt", 0);
        }
        return 0;
    }

    /* renamed from: a */
    public void m504a(int i) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f4057b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("vt", i).commit();
        }
    }

    /* renamed from: a */
    public void m502a(String str) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f4057b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("st", str).commit();
        }
    }

    /* renamed from: a */
    public void m501a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor edit = m496f().edit();
        edit.putString("au_p", str);
        edit.putString("au_u", str2);
        edit.commit();
    }

    /* renamed from: b */
    public String m500b() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f4057b);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("st", null);
        }
        return null;
    }

    /* renamed from: c */
    public boolean m499c() {
        return UMFrUtils.envelopeFileNumber(f4057b) > 0;
    }

    /* renamed from: d */
    public String[] m498d() {
        try {
            SharedPreferences m496f = m496f();
            String string = m496f.getString("au_p", null);
            String string2 = m496f.getString("au_u", null);
            if (string != null && string2 != null) {
                return new String[]{string, string2};
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* renamed from: e */
    public void m497e() {
        m496f().edit().remove("au_p").remove("au_u").commit();
    }
}
