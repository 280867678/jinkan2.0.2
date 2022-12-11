package com.p038qq.p039e.ads;

import com.p038qq.p039e.ads.cfg.DownAPPConfirmPolicy;
import com.p038qq.p039e.comm.p040pi.ADI;
import com.p038qq.p039e.comm.util.AdError;

/* renamed from: com.qq.e.ads.NativeAbstractAD */
/* loaded from: classes3.dex */
public abstract class NativeAbstractAD<T extends ADI> extends AbstractAD<T> {
    public DownAPPConfirmPolicy Wwwwwwwwwwwwwwwwwwww;

    /* renamed from: com.qq.e.ads.NativeAbstractAD$BasicADListener */
    /* loaded from: classes3.dex */
    public interface BasicADListener {
        void onNoAD(AdError adError);
    }

    /* renamed from: a */
    public void mo3671a(T t) {
        DownAPPConfirmPolicy downAPPConfirmPolicy = this.Wwwwwwwwwwwwwwwwwwww;
        if (downAPPConfirmPolicy != null) {
            setDownAPPConfirmPolicy(downAPPConfirmPolicy);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.p038qq.p039e.ads.AbstractAD
    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo3668a(Object obj) {
        mo3671a((NativeAbstractAD<T>) ((ADI) obj));
    }

    public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        this.Wwwwwwwwwwwwwwwwwwww = downAPPConfirmPolicy;
        T t = this.f657a;
        if (t == 0 || downAPPConfirmPolicy == null) {
            return;
        }
        ((ADI) t).setDownAPPConfirmPolicy(downAPPConfirmPolicy);
    }
}
