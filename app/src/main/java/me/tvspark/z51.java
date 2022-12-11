package me.tvspark;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.p038qq.p039e.comm.p040pi.ACTD;
import com.stub.StubApp;

/* loaded from: classes4.dex */
public class z51 {
    public static volatile x51 Wwwwwwwwwwwwwwwwwwwwwwwww;
    public static volatile z51 Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static Handler Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static HandlerThread Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Object();
    public static a61 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static Context Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public static z51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            synchronized (z51.class) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = StubApp.getOrigApplicationContext(context.getApplicationContext());
                Wwwwwwwwwwwwwwwwwwwwwwwwww = new z51();
            }
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwww == null) {
            synchronized (z51.class) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = StubApp.getOrigApplicationContext(context.getApplicationContext());
                HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = handlerThread;
                handlerThread.start();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new y51(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getLooper());
                Wwwwwwwwwwwwwwwwwwwwwwwww = new x51(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str) {
        synchronized (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Message obtainMessage = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.obtainMessage();
            obtainMessage.what = 11;
            Bundle bundle = new Bundle();
            bundle.putInt("type", i);
            if (i == 1 || i == 2) {
                bundle.putString(ACTD.APPID_KEY, str);
            }
            obtainMessage.setData(bundle);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.sendMessage(obtainMessage);
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.wait(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (SystemClock.uptimeMillis() - uptimeMillis < 2000) {
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 4) {
                            }
                        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                        }
                    } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    }
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            }
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        String str;
        try {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                str = (String) cls.getMethod("get", String.class, String.class).invoke(cls, "persist.sys.identifierid.supported", "unknown");
            } catch (Exception e) {
                e.printStackTrace();
                str = "0";
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = "1".equals(str);
            }
        } catch (Throwable unused) {
            str = "0";
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = "1".equals(str);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = "1".equals(str);
    }
}
