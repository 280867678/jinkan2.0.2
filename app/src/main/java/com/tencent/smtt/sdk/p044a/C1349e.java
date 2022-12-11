package com.tencent.smtt.sdk.p044a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.smtt.utils.TbsLog;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import me.tvspark.outline;

/* renamed from: com.tencent.smtt.sdk.a.e */
/* loaded from: classes4.dex */
public class C1349e {

    /* renamed from: a */
    public static String f2064a = "EmergencyManager";

    /* renamed from: f */
    public static final Object f2065f = new Object();

    /* renamed from: g */
    public static HandlerThread f2066g;

    /* renamed from: h */
    public static Handler f2067h;

    /* renamed from: b */
    public String f2068b;

    /* renamed from: c */
    public String f2069c;

    /* renamed from: d */
    public String f2070d;

    /* renamed from: e */
    public Handler f2071e;

    /* renamed from: com.tencent.smtt.sdk.a.e$a */
    /* loaded from: classes4.dex */
    public interface AbstractC1352a {
        /* renamed from: a */
        void mo2605a(String str);
    }

    public C1349e(Context context, String str, String str2) {
        this(context, str, str2, "POST");
    }

    public C1349e(Context context, String str, String str2, String str3) {
        this.f2068b = str;
        this.f2069c = str2;
        this.f2070d = str3;
        this.f2071e = new Handler(context.getMainLooper());
    }

    /* renamed from: b */
    public static Handler m2637b() {
        Handler handler;
        synchronized (f2065f) {
            if (f2067h == null) {
                HandlerThread handlerThread = new HandlerThread("HttpThread");
                f2066g = handlerThread;
                handlerThread.start();
                f2067h = new Handler(f2066g.getLooper());
            }
            handler = f2067h;
        }
        return handler;
    }

    /* renamed from: a */
    public String m2638a(String str) {
        String str2 = f2064a;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Request url: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f2068b);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(",params: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f2069c);
        TbsLog.m2158e(str2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str.trim()).openConnection();
            httpURLConnection.setRequestMethod(this.f2070d);
            httpURLConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            httpURLConnection.setRequestProperty("Content-Length", this.f2069c.length() + "");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.getOutputStream().write(this.f2069c.getBytes());
            int responseCode = httpURLConnection.getResponseCode();
            if (200 != responseCode) {
                String str3 = f2064a;
                TbsLog.m2158e(str3, "Bad http request, code: " + responseCode);
                return null;
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (-1 == read) {
                    return byteArrayOutputStream.toString("utf-8");
                }
                byteArrayOutputStream.write(bArr, 0, read);
                byteArrayOutputStream.flush();
            }
        } catch (Exception e) {
            String str4 = f2064a;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Http exception: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(e.getMessage());
            TbsLog.m2158e(str4, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
            return null;
        }
    }

    /* renamed from: a */
    public void m2640a(final AbstractC1352a abstractC1352a) {
        m2637b().post(new Runnable() { // from class: com.tencent.smtt.sdk.a.e.1
            @Override // java.lang.Runnable
            public void run() {
                C1349e c1349e = C1349e.this;
                final String m2638a = c1349e.m2638a(c1349e.f2068b);
                if (m2638a != null) {
                    C1349e.this.f2071e.post(new Runnable() { // from class: com.tencent.smtt.sdk.a.e.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AbstractC1352a abstractC1352a2 = abstractC1352a;
                            if (abstractC1352a2 != null) {
                                abstractC1352a2.mo2605a(m2638a);
                            }
                        }
                    });
                    return;
                }
                String str = C1349e.f2064a;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unexpected result for an empty http response: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(C1349e.this.f2068b);
                TbsLog.m2158e(str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
        });
    }
}
