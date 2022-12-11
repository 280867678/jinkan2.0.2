package me.tvspark;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import me.tvspark.utils.cast.service.SystemService;
import me.tvspark.utils.cast.utils.VMLog;

/* loaded from: classes4.dex */
public class zo0 implements ServiceConnection {
    public final /* synthetic */ ap0 Wwwwwwwwwwwwwwwwwwwwwwww;

    public zo0(ap0 ap0Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = ap0Var;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        VMLog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("onServiceConnected - %s", componentName);
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = SystemService.this;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        VMLog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("onServiceDisconnected - %s", componentName);
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
    }
}
