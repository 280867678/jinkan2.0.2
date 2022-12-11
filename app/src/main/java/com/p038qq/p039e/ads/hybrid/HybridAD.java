package com.p038qq.p039e.ads.hybrid;

import android.content.Context;
import com.p038qq.p039e.ads.AbstractAD;
import com.p038qq.p039e.comm.constants.ErrorCode;
import com.p038qq.p039e.comm.p040pi.HADI;
import com.p038qq.p039e.comm.p040pi.POFactory;
import com.p038qq.p039e.comm.util.AdErrorConvertor;
import com.p038qq.p039e.comm.util.GDTLogger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.qq.e.ads.hybrid.HybridAD */
/* loaded from: classes3.dex */
public class HybridAD extends AbstractAD<HADI> implements HADI {
    public HybridADSetting Wwwwwwwwwwwwwwwwww;
    public CountDownLatch Wwwwwwwwwwwwwwwwwww = new CountDownLatch(1);
    public HybridADListener Wwwwwwwwwwwwwwwwwwww;

    public HybridAD(Context context, HybridADSetting hybridADSetting, HybridADListener hybridADListener) {
        this.Wwwwwwwwwwwwwwwwww = hybridADSetting;
        this.Wwwwwwwwwwwwwwwwwwww = hybridADListener;
        m3679a(context, "NO_POS_ID");
    }

    /* renamed from: a */
    public HADI m3675a(POFactory pOFactory) {
        return pOFactory.getHybridAD(this.Wwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwww);
    }

    @Override // com.p038qq.p039e.ads.AbstractAD
    /* renamed from: a */
    public /* bridge */ /* synthetic */ HADI mo3669a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return m3675a(pOFactory);
    }

    @Override // com.p038qq.p039e.ads.AbstractAD
    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo3668a(HADI hadi) {
        m3674c();
    }

    @Override // com.p038qq.p039e.ads.AbstractAD
    /* renamed from: b */
    public void mo3667b(int i) {
        HybridADListener hybridADListener = this.Wwwwwwwwwwwwwwwwwwww;
        if (hybridADListener != null) {
            hybridADListener.onError(AdErrorConvertor.formatErrorCode(i));
        }
        this.Wwwwwwwwwwwwwwwwwww.countDown();
    }

    /* renamed from: c */
    public void m3674c() {
        this.Wwwwwwwwwwwwwwwwwww.countDown();
    }

    @Override // com.p038qq.p039e.comm.p040pi.HADI
    public void loadUrl(final String str) {
        if (!m3681a()) {
            return;
        }
        if (!m3676b()) {
            new Thread(new Runnable() { // from class: com.qq.e.ads.hybrid.HybridAD.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        HybridAD.this.Wwwwwwwwwwwwwwwwwww.await(30L, TimeUnit.SECONDS);
                        if (HybridAD.this.m3676b() && HybridAD.this.f657a != 0) {
                            ((HADI) HybridAD.this.f657a).loadUrl(str);
                        } else {
                            GDTLogger.m3646e("初始化错误：广告实例未被初始化");
                            HybridAD.this.m3680a(ErrorCode.INIT_ERROR);
                        }
                    } catch (InterruptedException unused) {
                        GDTLogger.m3646e("初始化错误：广告实例未被初始化");
                        HybridAD.this.m3680a(ErrorCode.INIT_ERROR);
                    }
                }
            }).start();
            return;
        }
        T t = this.f657a;
        if (t != 0) {
            ((HADI) t).loadUrl(str);
        } else {
            m3677a("loadUrl");
        }
    }
}
