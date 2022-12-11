package com.umeng.commonsdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.utils.onMessageSendListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class UMConfigureImpl {

    /* renamed from: a */
    public static String f3727a = "delayed_transmission_flag_new";

    /* renamed from: e */
    public static final int f3731e = 1000;

    /* renamed from: f */
    public static ScheduledExecutorService f3732f;

    /* renamed from: g */
    public static Context f3733g;

    /* renamed from: b */
    public static CopyOnWriteArrayList<onMessageSendListener> f3728b = new CopyOnWriteArrayList<>();

    /* renamed from: c */
    public static int f3729c = 0;

    /* renamed from: d */
    public static boolean f3730d = false;

    /* renamed from: h */
    public static int f3734h = 0;

    /* renamed from: i */
    public static Runnable f3735i = new Runnable() { // from class: com.umeng.commonsdk.UMConfigureImpl.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (UMConfigureImpl.f3729c == 0 || UMConfigureImpl.f3734h >= 10) {
                    if (!UMConfigureImpl.f3730d) {
                        boolean unused = UMConfigureImpl.f3730d = true;
                        UMConfigureImpl.m802b(UMConfigureImpl.f3733g);
                    }
                    if (UMConfigureImpl.f3732f != null) {
                        UMConfigureImpl.f3732f.shutdown();
                        ScheduledExecutorService unused2 = UMConfigureImpl.f3732f = null;
                    }
                }
                UMConfigureImpl.m796f();
            } catch (Exception unused3) {
            }
        }
    };

    /* renamed from: b */
    public static synchronized void m802b(Context context) {
        synchronized (UMConfigureImpl.class) {
            try {
                UMEnvelopeBuild.setTransmissionSendFlag(true);
                if (f3728b != null && f3728b.size() > 0) {
                    Iterator<onMessageSendListener> it = f3728b.iterator();
                    while (it.hasNext()) {
                        it.next().onMessageSend();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: c */
    public static void m800c(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(f3727a, 0);
            if (sharedPreferences == null) {
                return;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean(f3727a, true);
            edit.commit();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: d */
    public static boolean m798d(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(f3727a, 0);
            if (sharedPreferences == null) {
                return false;
            }
            return sharedPreferences.getBoolean(f3727a, false);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: f */
    public static /* synthetic */ int m796f() {
        int i = f3734h;
        f3734h = i + 1;
        return i;
    }

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        f3733g = context;
        try {
            if (f3729c < 1 || m798d(context)) {
                UMEnvelopeBuild.setTransmissionSendFlag(true);
            } else {
                UMEnvelopeBuild.setTransmissionSendFlag(false);
                m800c(context);
                if (f3732f == null) {
                    ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
                    f3732f = newScheduledThreadPool;
                    newScheduledThreadPool.scheduleAtFixedRate(f3735i, 0L, 100L, TimeUnit.MILLISECONDS);
                }
            }
        } catch (Exception unused) {
        }
    }

    public static synchronized void registerInterruptFlag() {
        synchronized (UMConfigureImpl.class) {
            try {
                f3729c++;
            } catch (Exception unused) {
            }
        }
    }

    public static synchronized void registerMessageSendListener(onMessageSendListener onmessagesendlistener) {
        synchronized (UMConfigureImpl.class) {
            try {
                if (f3728b != null) {
                    f3728b.add(onmessagesendlistener);
                }
                if (UMEnvelopeBuild.getTransmissionSendFlag() && f3728b != null && f3728b.size() > 0) {
                    Iterator<onMessageSendListener> it = f3728b.iterator();
                    while (it.hasNext()) {
                        it.next().onMessageSend();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public static synchronized void removeInterruptFlag() {
        synchronized (UMConfigureImpl.class) {
            try {
                f3729c--;
            } catch (Exception unused) {
            }
        }
    }

    public static synchronized void removeMessageSendListener(onMessageSendListener onmessagesendlistener) {
        synchronized (UMConfigureImpl.class) {
            try {
                if (f3728b != null) {
                    f3728b.remove(onmessagesendlistener);
                }
            } catch (Exception unused) {
            }
        }
    }
}
