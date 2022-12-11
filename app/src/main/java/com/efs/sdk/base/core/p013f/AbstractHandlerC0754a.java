package com.efs.sdk.base.core.p013f;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.p014a.C0764a;

/* renamed from: com.efs.sdk.base.core.f.a */
/* loaded from: classes3.dex */
public abstract class AbstractHandlerC0754a extends Handler {

    /* renamed from: a */
    public ControllerCenter f292a;

    public AbstractHandlerC0754a() {
        super(C0764a.f317a.getLooper());
        sendEmptyMessageDelayed(0, 60000L);
    }

    /* renamed from: a */
    public abstract void mo4073a();

    @Override // android.os.Handler
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        mo4073a();
        sendEmptyMessageDelayed(0, 60000L);
    }
}
