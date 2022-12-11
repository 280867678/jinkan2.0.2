package me.tvspark;

import android.content.Context;
import android.net.wifi.WifiManager;
import androidx.annotation.Nullable;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.stub.StubApp;

/* renamed from: me.tvspark.k4 */
/* loaded from: classes4.dex */
public final class C2283k4 {
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public WifiManager.WifiLock Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final WifiManager Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2283k4(Context context) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (WifiManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService(NetworkUtil.NETWORK_TYPE_WIFI);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        WifiManager.WifiLock wifiLock = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (wifiLock == null) {
            return;
        }
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || !this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.release();
        } else {
            wifiLock.acquire();
        }
    }
}
