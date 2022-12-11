package com.p038qq.p039e.comm.managers.plugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.p038qq.p039e.comm.constants.Sig;
import com.p038qq.p039e.comm.managers.C1060b;
import com.p038qq.p039e.comm.managers.status.SDKStatus;
import com.p038qq.p039e.comm.p040pi.POFactory;
import com.p038qq.p039e.comm.util.GDTLogger;
import com.stub.StubApp;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import me.tvspark.outline;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.qq.e.comm.managers.plugin.PM */
/* loaded from: classes3.dex */
public class C1062PM {
    public static final Map<Class<?>, String> Wwwwwwwwwwwwwwwwww = new C1064b();
    public String Wwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwww;
    public Future<Boolean> Wwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwww;
    public volatile POFactory Wwwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC1072f Wwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public FileLock Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public RandomAccessFile Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public DexClassLoader Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public volatile int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public File Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Context Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final ExecutorService Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Executors.newSingleThreadExecutor();
    public boolean Wwwwwwwwwwwwwwwwwwwww = false;

    /* renamed from: com.qq.e.comm.managers.plugin.PM$a */
    /* loaded from: classes3.dex */
    public class CallableC1063a implements Callable<Boolean> {
        public CallableC1063a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x006c  */
        @Override // java.util.concurrent.Callable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Boolean call() throws Exception {
            StringBuilder sb;
            boolean z;
            long currentTimeMillis = System.currentTimeMillis();
            C1062PM c1062pm = C1062PM.this;
            if (!c1062pm.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                c1062pm.Wwwwwwwwwwwwwwwwwwwwwwwwww = c1062pm.tryLockUpdate();
            }
            C1062PM c1062pm2 = C1062PM.this;
            if (c1062pm2 != null) {
                try {
                    GDTLogger.m3647d("TimeStap_BEFORE_PLUGIN_INIT:" + System.currentTimeMillis());
                } catch (Throwable th) {
                    try {
                        GDTLogger.m3645e("插件加载出现异常", th);
                        C1065a.m3659a(th, th.getMessage());
                        sb = new StringBuilder();
                        z = false;
                    } catch (Throwable th2) {
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("TimeStap_AFTER_PLUGIN_INIT:");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(System.currentTimeMillis());
                        GDTLogger.m3647d(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                        throw th2;
                    }
                }
                if (!c1062pm2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    if (!c1062pm2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                        z = false;
                        sb = new StringBuilder();
                        sb.append("TimeStap_AFTER_PLUGIN_INIT:");
                        sb.append(System.currentTimeMillis());
                        GDTLogger.m3647d(sb.toString());
                        if (z) {
                            C1062PM c1062pm3 = C1062PM.this;
                            if (c1062pm3 == null) {
                                throw null;
                            }
                            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("PluginFile:\t");
                            File file = c1062pm3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(file == null ? "null" : file.getAbsolutePath());
                            GDTLogger.m3647d(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                            if (c1062pm3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null || c1062pm3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                                c1062pm3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                            } else {
                                try {
                                    c1062pm3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new DexClassLoader(c1062pm3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getAbsolutePath(), c1062pm3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getDir(C1074h.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0).getAbsolutePath(), null, c1062pm3.getClass().getClassLoader());
                                    AbstractC1072f abstractC1072f = c1062pm3.Wwwwwwwwwwwwwwwwwwwwwwwww;
                                    if (abstractC1072f != null) {
                                        abstractC1072f.m3653a();
                                    }
                                } catch (Throwable th3) {
                                    GDTLogger.m3645e("插件ClassLoader构造发生异常", th3);
                                    AbstractC1072f abstractC1072f2 = c1062pm3.Wwwwwwwwwwwwwwwwwwwwwwwww;
                                    if (abstractC1072f2 != null) {
                                        abstractC1072f2.m3652b();
                                    }
                                    C1065a.m3659a(th3, th3.getMessage());
                                }
                            }
                        }
                        C1062PM.this.Wwwwwwwwwwwwwwwwwwwwwww = (int) (System.currentTimeMillis() - currentTimeMillis);
                        return Boolean.TRUE;
                    }
                }
                z = true;
                sb = new StringBuilder();
                sb.append("TimeStap_AFTER_PLUGIN_INIT:");
                sb.append(System.currentTimeMillis());
                GDTLogger.m3647d(sb.toString());
                if (z) {
                }
                C1062PM.this.Wwwwwwwwwwwwwwwwwwwwwww = (int) (System.currentTimeMillis() - currentTimeMillis);
                return Boolean.TRUE;
            }
            throw null;
        }
    }

    /* renamed from: com.qq.e.comm.managers.plugin.PM$b */
    /* loaded from: classes3.dex */
    public static class C1064b extends HashMap<Class<?>, String> {
        public C1064b() {
            put(POFactory.class, "com.qq.e.comm.plugin.POFactoryImpl");
        }
    }

    public C1062PM(Context context, AbstractC1072f abstractC1072f) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.Wwwwwwwwwwwwwwwwwwwwwwwww = abstractC1072f;
        C1066b.m3658a(context);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwww = false;
        SharedPreferences sharedPreferences = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getSharedPreferences("start_crash", 0);
        if (sharedPreferences.getInt("crash_count", 0) >= 2) {
            this.Wwwwwwwwwwwwwwwwwwww = true;
            sharedPreferences.edit().remove("crash_count").commit();
            GDTLogger.m3646e("加载本地插件");
        }
        this.Wwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.submit(new CallableC1063a());
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwwwww) {
            return false;
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
            C1073g c1073g = new C1073g(C1074h.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), new File(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getDir(C1074h.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0), "gdt_plugin.next.sig"));
            if (c1073g.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                File Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C1074h.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                File Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C1074h.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                boolean z = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(c1073g.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) || C1074h.m3649a(c1073g.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) && (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(c1073g.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) || C1074h.m3649a(c1073g.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                GDTLogger.m3647d("NextExist,Updated=" + z);
            }
        }
        C1073g c1073g2 = new C1073g(C1074h.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), C1074h.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        if (!c1073g2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return false;
        }
        if (c1073g2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < SDKStatus.getBuildInPluginVersion()) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("last updated plugin version =");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(";asset plugin version=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(SDKStatus.getBuildInPluginVersion());
            GDTLogger.m3647d(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            return false;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c1073g2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c1073g2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C1074h.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwww = c1073g2.m3651d();
        this.Wwwwwwwwwwwwwwwwwwwww = true;
        return true;
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
            return false;
        }
        try {
            C1066b.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, C1074h.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), C1074h.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Sig.ASSET_PLUGIN_SIG;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C1074h.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = SDKStatus.getBuildInPluginVersion();
            return true;
        } catch (Throwable th) {
            GDTLogger.m3646e("插件初始化失败 ");
            C1065a.m3659a(th, th.getMessage());
            return false;
        }
    }

    public final JSONObject Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        JSONObject jSONObject = new JSONObject();
        try {
            int pluginVersion = getPluginVersion();
            if (pluginVersion > 10000) {
                jSONObject.put("vas", this.Wwwwwwwwwwwwwwwwwww);
            }
            jSONObject.put("pv", pluginVersion);
            jSONObject.put("sig", this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            jSONObject.put("appId", C1060b.m3662b().m3663a());
            jSONObject.put("pn", C1066b.m3658a(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
            jSONObject.put("ict", this.Wwwwwwwwwwwwwwwwwwwwwww);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public <T> T getFactory(Class<T> cls) throws C1071e {
        Future<Boolean> future = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (future != null) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        GDTLogger.m3647d("GetFactoryInstaceforInterface:" + cls);
        ClassLoader classLoader = Sig.ASSET_PLUGIN_SIG == null ? C1062PM.class.getClassLoader() : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("PluginClassLoader is parent");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(C1062PM.class.getClassLoader() == classLoader);
        GDTLogger.m3647d(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        if (classLoader != null) {
            try {
                String str = Wwwwwwwwwwwwwwwwww.get(cls);
                if (TextUtils.isEmpty(str)) {
                    throw new C1071e("factory  implemention name is not specified for interface:" + cls.getName());
                }
                Class<?> loadClass = classLoader.loadClass(str);
                T cast = cls.cast(loadClass.getDeclaredMethod("getInstance", Context.class, JSONObject.class).invoke(loadClass, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()));
                GDTLogger.m3647d("ServiceDelegateFactory =" + cast);
                return cast;
            } catch (Throwable th) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Fail to getfactory implement instance for interface:");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(cls.getName());
                throw new C1071e(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString(), th);
            }
        }
        throw new C1071e(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Fail to init GDTADPLugin,PluginClassLoader == null;while loading factory impl for:", (Class) cls));
    }

    public POFactory getPOFactory() throws C1071e {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww == null) {
            synchronized (this) {
                if (this.Wwwwwwwwwwwwwwwwwwwwwwww == null) {
                    try {
                        this.Wwwwwwwwwwwwwwwwwwwwwwww = (POFactory) getFactory(POFactory.class);
                    } catch (C1071e e) {
                        if (!this.Wwwwwwwwwwwwwwwwwwwww) {
                            throw e;
                        }
                        GDTLogger.m3646e("插件加载错误，回退到内置版本");
                        this.Wwwwwwwwwwwwwwwwwwww = true;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        this.Wwwwwwwwwwwwwwwwwwwwwwww = (POFactory) getFactory(POFactory.class);
                    }
                }
            }
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    public int getPluginVersion() {
        Future<Boolean> future = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (future != null) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public boolean tryLockUpdate() {
        try {
            File Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C1074h.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.exists()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.createNewFile();
                C1074h.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("lock", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.exists()) {
                return false;
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "rw");
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = randomAccessFile;
            FileLock tryLock = randomAccessFile.getChannel().tryLock();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = tryLock;
            if (tryLock == null) {
                return false;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.writeByte(37);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
