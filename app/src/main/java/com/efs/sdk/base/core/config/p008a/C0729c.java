package com.efs.sdk.base.core.config.p008a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import com.efs.sdk.base.IConfigRefreshAction;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.p007c.C0722f;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.p014a.C0764a;
import com.efs.sdk.base.observer.IConfigCallback;
import com.efs.sdk.base.observer.IEfsReporterObserver;
import com.just.agentweb.DefaultWebClient;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.efs.sdk.base.core.config.a.c */
/* loaded from: classes3.dex */
public final class C0729c implements Handler.Callback {

    /* renamed from: a */
    public static final Random f245a = new Random();

    /* renamed from: b */
    public IConfigRefreshAction f246b;

    /* renamed from: c */
    public boolean f247c;

    /* renamed from: d */
    public C0728b f248d;

    /* renamed from: e */
    public Map<IConfigCallback, String[]> f249e;

    /* renamed from: f */
    public Handler f250f;

    /* renamed from: g */
    public SharedPreferences$OnSharedPreferenceChangeListenerC0733e f251g;

    /* renamed from: h */
    public long f252h;

    /* renamed from: com.efs.sdk.base.core.config.a.c$a */
    /* loaded from: classes3.dex */
    public static class C0731a {

        /* renamed from: a */
        public static final C0729c f254a = new C0729c((byte) 0);
    }

    public C0729c() {
        this.f247c = true;
        this.f249e = new HashMap();
        this.f250f = new Handler(C0764a.f317a.getLooper(), this);
        this.f251g = new SharedPreferences$OnSharedPreferenceChangeListenerC0733e();
        this.f248d = C0728b.m4129a();
        this.f252h = ControllerCenter.getGlobalEnvStruct().configRefreshDelayMills;
    }

    public /* synthetic */ C0729c(byte b) {
        this();
    }

    /* renamed from: a */
    public static C0729c m4127a() {
        return C0731a.f254a;
    }

    /* renamed from: a */
    private boolean m4125a(C0728b c0728b) {
        if (this.f248d.f238a >= c0728b.f238a) {
            return true;
        }
        Log.m4062i("efs.config", "current config version (" + this.f248d.f238a + ") is older than another (" + c0728b.f238a + ")");
        return false;
    }

    /* renamed from: e */
    private void m4117e() {
        C0722f c0722f;
        String str;
        c0722f = C0722f.C0724a.f220a;
        if (!c0722f.m4138a()) {
            str = "has no permission to refresh config from remote";
        } else if (this.f247c) {
            String refresh = m4115g().refresh();
            Log.m4062i("efs.config", "from server. efs config is ".concat(String.valueOf(refresh)));
            if (TextUtils.isEmpty(refresh)) {
                return;
            }
            m4123a(refresh);
            return;
        } else {
            str = "disable refresh config from remote";
        }
        Log.m4062i("efs.config", str);
    }

    /* renamed from: f */
    private void m4116f() {
        boolean z;
        try {
            z = this.f251g.m4108a(this.f248d);
        } catch (Throwable unused) {
            z = false;
        }
        if (!z) {
            this.f250f.sendEmptyMessageDelayed(3, 3000L);
        }
    }

    @NonNull
    /* renamed from: g */
    private IConfigRefreshAction m4115g() {
        IConfigRefreshAction iConfigRefreshAction = this.f246b;
        return iConfigRefreshAction == null ? C0726a.m4131a() : iConfigRefreshAction;
    }

    /* renamed from: h */
    private boolean m4114h() {
        SharedPreferences$OnSharedPreferenceChangeListenerC0733e.m4107b();
        long j = 0;
        try {
            SharedPreferences$OnSharedPreferenceChangeListenerC0733e sharedPreferences$OnSharedPreferenceChangeListenerC0733e = this.f251g;
            sharedPreferences$OnSharedPreferenceChangeListenerC0733e.m4106c();
            if (sharedPreferences$OnSharedPreferenceChangeListenerC0733e.f256a != null) {
                j = sharedPreferences$OnSharedPreferenceChangeListenerC0733e.f256a.getLong("last_refresh_time", 0L);
            }
        } catch (Throwable unused) {
        }
        return System.currentTimeMillis() - j >= (this.f248d.f241d * 60) * 1000;
    }

    /* renamed from: i */
    private void m4113i() {
        try {
            for (ValueCallback<Pair<Message, Message>> valueCallback : ControllerCenter.getGlobalEnvStruct().getCallback(1)) {
                Message obtain = Message.obtain(null, 1, new JSONObject(this.f248d.f243f).toString());
                Message obtain2 = Message.obtain();
                valueCallback.onReceiveValue(new Pair<>(obtain, obtain2));
                obtain.recycle();
                obtain2.recycle();
            }
            for (IEfsReporterObserver iEfsReporterObserver : ControllerCenter.getGlobalEnvStruct().getEfsReporterObservers()) {
                iEfsReporterObserver.onConfigChange();
            }
        } catch (Throwable th) {
            Log.m4064e("efs.config", th);
        }
    }

    /* renamed from: a */
    public final String m4122a(boolean z) {
        StringBuilder sb;
        if (z) {
            sb = new StringBuilder(DefaultWebClient.HTTPS_SCHEME);
        } else {
            sb = new StringBuilder();
            sb.append(this.f248d.f239b);
        }
        sb.append(this.f248d.f240c);
        return sb.toString();
    }

    /* renamed from: a */
    public final void m4126a(int i) {
        if (i <= this.f248d.f238a) {
            Log.m4062i("efs.config", "current config version is " + i + ", no need to refresh");
            return;
        }
        Message obtain = Message.obtain();
        obtain.arg1 = i;
        obtain.what = 1;
        this.f250f.sendMessage(obtain);
    }

    /* renamed from: a */
    public final void m4123a(String str) {
        C0728b m4129a = C0728b.m4129a();
        if (!C0732d.m4111a(str, m4129a)) {
            this.f250f.sendEmptyMessageDelayed(1, 3000L);
        } else if (m4125a(m4129a)) {
        } else {
            this.f248d = m4129a;
            m4116f();
            m4113i();
            m4118d();
        }
    }

    /* renamed from: b */
    public final void m4121b() {
        this.f250f.sendEmptyMessage(0);
        this.f250f.sendEmptyMessageDelayed(2, this.f252h);
    }

    /* renamed from: c */
    public final Map<String, String> m4119c() {
        return new HashMap(this.f248d.f243f);
    }

    /* renamed from: d */
    public final void m4118d() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.efs.sdk.base.core.config.a.c.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    for (IConfigCallback iConfigCallback : C0729c.this.f249e.keySet()) {
                        String[] strArr = (String[]) C0729c.this.f249e.get(iConfigCallback);
                        HashMap hashMap = new HashMap();
                        if (strArr != null && strArr.length != 0) {
                            for (String str : strArr) {
                                if (C0729c.this.f248d.f243f.containsKey(str)) {
                                    hashMap.put(str, C0729c.this.m4119c().get(str));
                                    Log.m4062i("efs.config", "--->>> configCallback key is " + str + " ## value is " + C0729c.this.m4119c().get(str));
                                }
                            }
                        }
                        iConfigCallback.onChange(hashMap);
                    }
                    C0729c.this.f249e.clear();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(@NonNull Message message) {
        C0728b c0728b;
        String str;
        C0722f c0722f;
        int i = message.what;
        if (i != 0) {
            if (i == 1) {
                int i2 = message.arg1;
                if (i2 <= this.f248d.f238a) {
                    Log.m4062i("efs.config", "current config version is " + i2 + ", no need to refresh");
                    str = "current config version(" + this.f248d.f238a + ") is " + i2 + ", no need to refresh";
                } else {
                    m4117e();
                }
            } else if (i == 2) {
                try {
                    c0722f = C0722f.C0724a.f220a;
                    if (c0722f.m4138a()) {
                        if (!m4114h()) {
                            Log.m4062i("efs.config", "No update is required, less than 8h since the last update");
                        } else {
                            m4117e();
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } else if (i == 3) {
                m4116f();
            }
            return true;
        }
        boolean m4109a = SharedPreferences$OnSharedPreferenceChangeListenerC0733e.m4109a();
        Log.m4062i("efs.config", "delete old config is ".concat(String.valueOf(m4109a)));
        if (m4109a) {
            this.f250f.sendEmptyMessage(1);
            return true;
        }
        SharedPreferences$OnSharedPreferenceChangeListenerC0733e sharedPreferences$OnSharedPreferenceChangeListenerC0733e = this.f251g;
        sharedPreferences$OnSharedPreferenceChangeListenerC0733e.m4106c();
        if (sharedPreferences$OnSharedPreferenceChangeListenerC0733e.f256a == null) {
            c0728b = null;
        } else {
            C0728b m4129a = C0728b.m4129a();
            m4129a.f238a = sharedPreferences$OnSharedPreferenceChangeListenerC0733e.f256a.getInt("cver", -1);
            Set<String> keySet = sharedPreferences$OnSharedPreferenceChangeListenerC0733e.f256a.getAll().keySet();
            HashMap hashMap = new HashMap();
            for (String str2 : keySet) {
                String string = sharedPreferences$OnSharedPreferenceChangeListenerC0733e.f256a.getString(str2, "");
                if (!TextUtils.isEmpty(string)) {
                    hashMap.put(str2, string);
                }
            }
            m4129a.m4128a(hashMap);
            c0728b = m4129a;
        }
        if (c0728b == null) {
            str = "first load local config false.";
        } else if (m4125a(c0728b)) {
            str = "current config to same.";
        } else {
            this.f248d = c0728b;
            if (-1 != c0728b.f238a) {
                m4113i();
                m4118d();
                str = "load config from storage and notify observer";
            } else {
                str = "load config from storage";
            }
        }
        Log.m4062i("efs.config", str);
        return true;
    }
}
