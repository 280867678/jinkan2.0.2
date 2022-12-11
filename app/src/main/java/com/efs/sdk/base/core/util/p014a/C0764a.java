package com.efs.sdk.base.core.util.p014a;

import android.os.HandlerThread;

/* renamed from: com.efs.sdk.base.core.util.a.a */
/* loaded from: classes3.dex */
public final class C0764a {

    /* renamed from: a */
    public static HandlerThread f317a;

    static {
        HandlerThread handlerThread = new HandlerThread("efs-base", 10);
        f317a = handlerThread;
        handlerThread.start();
    }
}
