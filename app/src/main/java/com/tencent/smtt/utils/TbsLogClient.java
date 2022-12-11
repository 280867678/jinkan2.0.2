package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.widget.TextView;
import com.stub.StubApp;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: classes4.dex */
public class TbsLogClient {

    /* renamed from: a */
    public static TbsLogClient f2378a = null;

    /* renamed from: c */
    public static File f2379c = null;

    /* renamed from: d */
    public static String f2380d = null;

    /* renamed from: e */
    public static byte[] f2381e = null;

    /* renamed from: i */
    public static boolean f2382i = true;

    /* renamed from: b */
    public TextView f2383b;

    /* renamed from: f */
    public SimpleDateFormat f2384f;

    /* renamed from: g */
    public Context f2385g;

    /* renamed from: h */
    public StringBuffer f2386h = new StringBuffer();

    /* renamed from: com.tencent.smtt.utils.TbsLogClient$a */
    /* loaded from: classes4.dex */
    public class RunnableC1427a implements Runnable {

        /* renamed from: a */
        public String f2387a;

        public RunnableC1427a(String str) {
            this.f2387a = null;
            this.f2387a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            TextView textView = TbsLogClient.this.f2383b;
            if (textView != null) {
                textView.append(this.f2387a + "\n");
            }
        }
    }

    public TbsLogClient(Context context) {
        this.f2384f = null;
        this.f2385g = null;
        try {
            this.f2385g = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f2384f = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS", Locale.US);
        } catch (Exception unused) {
            this.f2384f = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
        }
    }

    /* renamed from: a */
    private void m2145a() {
        String m2198a;
        try {
            if (f2379c == null) {
                if (!Environment.getExternalStorageState().equals("mounted") || (m2198a = FileUtil.m2198a(this.f2385g, 6)) == null) {
                    f2379c = null;
                } else {
                    f2379c = new File(m2198a, "tbslog.txt");
                    f2380d = LogFileUtils.createKey();
                    f2381e = LogFileUtils.createHeaderText(f2379c.getName(), f2380d);
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (SecurityException e2) {
            e2.printStackTrace();
        }
    }

    public static void setWriteLogJIT(boolean z) {
        f2382i = z;
    }

    /* renamed from: d */
    public void m2144d(String str, String str2) {
    }

    /* renamed from: e */
    public void m2143e(String str, String str2) {
    }

    /* renamed from: i */
    public void m2142i(String str, String str2) {
    }

    public void setLogView(TextView textView) {
        this.f2383b = textView;
    }

    public void showLog(String str) {
        TextView textView = this.f2383b;
        if (textView != null) {
            textView.post(new RunnableC1427a(str));
        }
    }

    /* renamed from: v */
    public void m2141v(String str, String str2) {
    }

    /* renamed from: w */
    public void m2140w(String str, String str2) {
    }

    public void writeLog(String str) {
        try {
            String format = this.f2384f.format(Long.valueOf(System.currentTimeMillis()));
            StringBuffer stringBuffer = this.f2386h;
            stringBuffer.append(format);
            stringBuffer.append(" pid=");
            stringBuffer.append(Process.myPid());
            stringBuffer.append(" tid=");
            stringBuffer.append(Process.myTid());
            stringBuffer.append(str);
            stringBuffer.append("\n");
            if (Thread.currentThread() != Looper.getMainLooper().getThread() || f2382i) {
                writeLogToDisk();
            }
            if (this.f2386h.length() <= 524288) {
                return;
            }
            this.f2386h.delete(0, this.f2386h.length());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeLogToDisk() {
        try {
            m2145a();
            if (f2379c == null) {
                return;
            }
            LogFileUtils.writeDataToStorage(f2379c, f2380d, f2381e, this.f2386h.toString(), true);
            this.f2386h.delete(0, this.f2386h.length());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
