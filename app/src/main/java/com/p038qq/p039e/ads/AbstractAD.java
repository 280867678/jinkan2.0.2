package com.p038qq.p039e.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.p038qq.p039e.comm.C1058a;
import com.p038qq.p039e.comm.constants.ErrorCode;
import com.p038qq.p039e.comm.managers.C1060b;
import com.p038qq.p039e.comm.p040pi.POFactory;
import com.p038qq.p039e.comm.util.GDTLogger;

/* renamed from: com.qq.e.ads.AbstractAD */
/* loaded from: classes3.dex */
public abstract class AbstractAD<T> {
    public volatile boolean Wwwwwwwwwwwwwwwwwwwww;

    /* renamed from: a */
    public T f657a;
    public volatile boolean Wwwwwwwwwwwwwwwwwwwwwww = false;
    public volatile boolean Wwwwwwwwwwwwwwwwwwwwww = false;
    public final Handler Wwwwwwwwwwwwwwwwwwwwwwww = new Handler(Looper.getMainLooper());

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(final Context context, final String str, final String str2) {
        int i;
        this.Wwwwwwwwwwwwwwwwwwwww = true;
        if (C1060b.m3662b().m3660d()) {
            final String m3663a = C1060b.m3662b().m3663a();
            if (C1058a.m3664a(context)) {
                this.Wwwwwwwwwwwwwwwwwwwwww = true;
                C1060b.f664g.execute(new Runnable() { // from class: com.qq.e.ads.AbstractAD.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            final POFactory pOFactory = C1060b.m3662b().m3661c().getPOFactory();
                            AbstractAD.this.Wwwwwwwwwwwwwwwwwwwwwwww.post(new Runnable() { // from class: com.qq.e.ads.AbstractAD.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        if (pOFactory != null) {
                                            AbstractAD.this.f657a = (T) AbstractAD.this.mo3669a(context, pOFactory, m3663a, str, str2);
                                            AbstractAD.this.Wwwwwwwwwwwwwwwwwwwwwww = true;
                                            if (AbstractAD.this.f657a == null) {
                                                AbstractAD.this.m3680a(ErrorCode.POFACTORY_GET_INTERFACE_ERROR);
                                            } else {
                                                AbstractAD.this.mo3668a((AbstractAD) AbstractAD.this.f657a);
                                            }
                                        } else {
                                            AbstractAD.this.Wwwwwwwwwwwwwwwwwwwwwww = true;
                                            AbstractAD.this.m3680a(ErrorCode.PLUGIN_INIT_ERROR);
                                        }
                                    } catch (Throwable th) {
                                        GDTLogger.m3645e("初始化错误：初始化广告实例时发生异常", th);
                                        AbstractAD.this.Wwwwwwwwwwwwwwwwwwwwwww = true;
                                        AbstractAD.this.m3680a(ErrorCode.INIT_ERROR);
                                    }
                                }
                            });
                        } catch (Throwable th) {
                            GDTLogger.m3645e("初始化错误：初始化插件时发生异常", th);
                            AbstractAD.this.Wwwwwwwwwwwwwwwwwwwwwww = true;
                            AbstractAD.this.m3680a(ErrorCode.PLUGIN_INIT_ERROR);
                        }
                    }
                });
                return;
            }
            GDTLogger.m3646e("Manifest文件中Activity/Service/Permission的声明有问题或者Permission权限未授予");
            i = ErrorCode.MANIFEST_ERROR;
        } else {
            i = ErrorCode.NOT_INIT;
        }
        m3680a(i);
    }

    /* renamed from: a */
    public abstract T mo3669a(Context context, POFactory pOFactory, String str, String str2, String str3);

    /* renamed from: a */
    public final void m3680a(final int i) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            mo3667b(i);
        } else {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.post(new Runnable() { // from class: com.qq.e.ads.AbstractAD.2
                @Override // java.lang.Runnable
                public void run() {
                    AbstractAD.this.mo3667b(i);
                }
            });
        }
    }

    /* renamed from: a */
    public final void m3679a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, str, "");
            return;
        }
        GDTLogger.m3646e("初始化错误：参数错误context或posId为空");
        m3680a((int) ErrorCode.INIT_ERROR);
    }

    /* renamed from: a */
    public final void m3678a(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, str, str2);
            return;
        }
        GDTLogger.m3646e("初始化错误：参数错误，context、posId、token 不可为空");
        m3680a((int) ErrorCode.INIT_ERROR);
    }

    /* renamed from: a */
    public abstract void mo3668a(T t);

    /* renamed from: a */
    public final void m3677a(String str) {
        GDTLogger.m3646e(getClass().getSimpleName() + ":调用方法 " + str + "异常，广告实例还未初始化");
    }

    /* renamed from: a */
    public final boolean m3681a() {
        return this.Wwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwww;
    }

    /* renamed from: b */
    public abstract void mo3667b(int i);

    /* renamed from: b */
    public final boolean m3676b() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww;
    }
}
