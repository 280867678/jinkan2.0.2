package com.p038qq.p039e.ads.nativ;

import android.view.View;

/* renamed from: com.qq.e.ads.nativ.NativeADEventListenerWithClickInfo */
/* loaded from: classes3.dex */
public abstract class NativeADEventListenerWithClickInfo implements NativeADEventListener {
    @Override // com.p038qq.p039e.ads.nativ.NativeADEventListener
    public final void onADClicked() {
    }

    public abstract void onADClicked(View view);
}
