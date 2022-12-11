package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Bundle;
import com.tencent.smtt.export.external.DexLoader;

/* renamed from: com.tencent.smtt.sdk.r */
/* loaded from: classes4.dex */
public class C1391r {

    /* renamed from: a */
    public DexLoader f2208a;

    /* renamed from: b */
    public Object f2209b = null;

    public C1391r(DexLoader dexLoader) {
        this.f2208a = null;
        this.f2208a = dexLoader;
    }

    /* renamed from: a */
    public Object m2414a(Context context, Object obj, Bundle bundle) {
        DexLoader dexLoader = this.f2208a;
        if (dexLoader != null) {
            this.f2209b = dexLoader.newInstance("com.tencent.tbs.cache.TbsVideoCacheTaskProxy", new Class[]{Context.class, Object.class, Bundle.class}, context, obj, bundle);
        }
        return this.f2209b;
    }

    /* renamed from: a */
    public void m2415a() {
        DexLoader dexLoader = this.f2208a;
        if (dexLoader != null) {
            dexLoader.invokeMethod(this.f2209b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "pauseTask", new Class[0], new Object[0]);
        }
    }

    /* renamed from: a */
    public void m2413a(boolean z) {
        DexLoader dexLoader = this.f2208a;
        if (dexLoader != null) {
            dexLoader.invokeMethod(this.f2209b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "removeTask", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    /* renamed from: b */
    public void m2412b() {
        DexLoader dexLoader = this.f2208a;
        if (dexLoader != null) {
            dexLoader.invokeMethod(this.f2209b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "resumeTask", new Class[0], new Object[0]);
        }
    }

    /* renamed from: c */
    public void m2411c() {
        DexLoader dexLoader = this.f2208a;
        if (dexLoader != null) {
            dexLoader.invokeMethod(this.f2209b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "stopTask", new Class[0], new Object[0]);
        }
    }

    /* renamed from: d */
    public long m2410d() {
        DexLoader dexLoader = this.f2208a;
        if (dexLoader != null) {
            Object invokeMethod = dexLoader.invokeMethod(this.f2209b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "getContentLength", new Class[0], new Object[0]);
            if (!(invokeMethod instanceof Long)) {
                return 0L;
            }
            return ((Long) invokeMethod).longValue();
        }
        return 0L;
    }

    /* renamed from: e */
    public int m2409e() {
        DexLoader dexLoader = this.f2208a;
        if (dexLoader != null) {
            Object invokeMethod = dexLoader.invokeMethod(this.f2209b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "getDownloadedSize", new Class[0], new Object[0]);
            if (invokeMethod instanceof Integer) {
                return ((Integer) invokeMethod).intValue();
            }
        }
        return 0;
    }

    /* renamed from: f */
    public int m2408f() {
        DexLoader dexLoader = this.f2208a;
        if (dexLoader != null) {
            Object invokeMethod = dexLoader.invokeMethod(this.f2209b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "getProgress", new Class[0], new Object[0]);
            if (invokeMethod instanceof Integer) {
                return ((Integer) invokeMethod).intValue();
            }
        }
        return 0;
    }
}
