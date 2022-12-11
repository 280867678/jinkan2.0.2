package com.tencent.smtt.sdk;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.sdk.TbsMediaPlayer;
import org.eclipse.jetty.http.HttpHeaderValues;

/* renamed from: com.tencent.smtt.sdk.q */
/* loaded from: classes4.dex */
public class C1390q {

    /* renamed from: a */
    public DexLoader f2206a;

    /* renamed from: b */
    public Object f2207b;

    public C1390q(DexLoader dexLoader, Context context) {
        this.f2206a = null;
        this.f2207b = null;
        this.f2206a = dexLoader;
        this.f2207b = dexLoader.newInstance("com.tencent.tbs.player.TbsMediaPlayerProxy", new Class[]{Context.class}, context);
    }

    /* renamed from: a */
    public void m2426a(float f) {
        this.f2206a.invokeMethod(this.f2207b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "setVolume", new Class[]{Float.TYPE}, Float.valueOf(f));
    }

    /* renamed from: a */
    public void m2425a(int i) {
        this.f2206a.invokeMethod(this.f2207b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "subtitle", new Class[]{Integer.TYPE}, Integer.valueOf(i));
    }

    /* renamed from: a */
    public void m2424a(long j) {
        this.f2206a.invokeMethod(this.f2207b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "seek", new Class[]{Long.TYPE}, Long.valueOf(j));
    }

    /* renamed from: a */
    public void m2423a(SurfaceTexture surfaceTexture) {
        this.f2206a.invokeMethod(this.f2207b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "setSurfaceTexture", new Class[]{SurfaceTexture.class}, surfaceTexture);
    }

    /* renamed from: a */
    public void m2422a(TbsMediaPlayer.TbsMediaPlayerListener tbsMediaPlayerListener) {
        this.f2206a.invokeMethod(this.f2207b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "setPlayerListener", new Class[]{Object.class}, tbsMediaPlayerListener);
    }

    /* renamed from: a */
    public void m2421a(String str, Bundle bundle) {
        this.f2206a.invokeMethod(this.f2207b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "startPlay", new Class[]{String.class, Bundle.class}, str, bundle);
    }

    /* renamed from: a */
    public boolean m2427a() {
        return this.f2207b != null;
    }

    /* renamed from: b */
    public float m2420b() {
        Float f = (Float) this.f2206a.invokeMethod(this.f2207b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "getVolume", new Class[0], new Object[0]);
        if (f != null) {
            return f.floatValue();
        }
        return 0.0f;
    }

    /* renamed from: b */
    public void m2419b(int i) {
        this.f2206a.invokeMethod(this.f2207b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "audio", new Class[]{Integer.TYPE}, Integer.valueOf(i));
    }

    /* renamed from: c */
    public void m2418c() {
        this.f2206a.invokeMethod(this.f2207b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "pause", new Class[0], new Object[0]);
    }

    /* renamed from: d */
    public void m2417d() {
        this.f2206a.invokeMethod(this.f2207b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "play", new Class[0], new Object[0]);
    }

    /* renamed from: e */
    public void m2416e() {
        this.f2206a.invokeMethod(this.f2207b, "com.tencent.tbs.player.TbsMediaPlayerProxy", HttpHeaderValues.CLOSE, new Class[0], new Object[0]);
    }
}
