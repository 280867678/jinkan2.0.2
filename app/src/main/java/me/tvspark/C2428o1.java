package me.tvspark;

import android.annotation.TargetApi;
import android.os.SystemClock;

/* renamed from: me.tvspark.o1 */
/* loaded from: classes4.dex */
public final class C2428o1 {
    public static final double Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1.0d / Math.pow(10.0d, 6.0d);

    public static double Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        return (SystemClock.elapsedRealtimeNanos() - j) * Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @TargetApi(17)
    public static long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return SystemClock.elapsedRealtimeNanos();
    }
}
