package com.efs.sdk.base.core.util.p014a;

import androidx.annotation.NonNull;
import com.efs.sdk.base.core.util.Log;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.efs.sdk.base.core.util.a.d */
/* loaded from: classes3.dex */
public final class C0767d {

    /* renamed from: a */
    public static ThreadPoolExecutor f318a = new ThreadPoolExecutor(2, 2, 10, TimeUnit.MINUTES, new LinkedBlockingQueue(Integer.MAX_VALUE), new ThreadPoolExecutor.DiscardOldestPolicy());

    /* renamed from: a */
    public static Future<?> m4041a(@NonNull Runnable runnable) {
        try {
            return f318a.submit(runnable);
        } catch (Throwable th) {
            Log.m4065e("efs.util.concurrent", "submit task error!", th);
            return null;
        }
    }
}
