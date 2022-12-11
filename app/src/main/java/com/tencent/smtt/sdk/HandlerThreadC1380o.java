package com.tencent.smtt.sdk;

import android.os.HandlerThread;

/* renamed from: com.tencent.smtt.sdk.o */
/* loaded from: classes4.dex */
public class HandlerThreadC1380o extends HandlerThread {

    /* renamed from: a */
    public static HandlerThreadC1380o f2181a;

    public HandlerThreadC1380o(String str) {
        super(str);
    }

    /* renamed from: a */
    public static synchronized HandlerThreadC1380o m2510a() {
        HandlerThreadC1380o handlerThreadC1380o;
        synchronized (HandlerThreadC1380o.class) {
            if (f2181a == null) {
                HandlerThreadC1380o handlerThreadC1380o2 = new HandlerThreadC1380o("TbsHandlerThread");
                f2181a = handlerThreadC1380o2;
                handlerThreadC1380o2.start();
            }
            handlerThreadC1380o = f2181a;
        }
        return handlerThreadC1380o;
    }
}
