package me.tvspark;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;

/* renamed from: me.tvspark.il */
/* loaded from: classes4.dex */
public class C2226il implements AbstractC2564rk {
    @Override // me.tvspark.AbstractC2564rk
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return SystemClock.elapsedRealtime();
    }

    @Override // me.tvspark.AbstractC2564rk
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return SystemClock.uptimeMillis();
    }

    @Override // me.tvspark.AbstractC2564rk
    public C2263jl Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Looper looper, @Nullable Handler.Callback callback) {
        return new C2263jl(new Handler(looper, callback));
    }
}
