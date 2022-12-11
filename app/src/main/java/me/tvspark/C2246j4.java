package me.tvspark;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.Nullable;
import com.stub.StubApp;

/* renamed from: me.tvspark.j4 */
/* loaded from: classes4.dex */
public final class C2246j4 {
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public PowerManager.WakeLock Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final PowerManager Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2246j4(Context context) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (PowerManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("power");
    }

    @SuppressLint({"WakelockTimeout"})
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        PowerManager.WakeLock wakeLock = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (wakeLock == null) {
            return;
        }
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || !this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.release();
        } else {
            wakeLock.acquire();
        }
    }
}
