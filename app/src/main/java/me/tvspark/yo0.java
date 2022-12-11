package me.tvspark;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import me.tvspark.utils.cast.service.ClingService;
import me.tvspark.utils.cast.utils.VMLog;

/* loaded from: classes4.dex */
public class yo0 implements ServiceConnection {
    public final /* synthetic */ ap0 Wwwwwwwwwwwwwwwwwwwwwwww;

    public yo0(ap0 ap0Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = ap0Var;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        VMLog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("onServiceConnected - %s", componentName);
        ClingService clingService = ClingService.this;
        ap0 ap0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        ap0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = clingService;
        ap0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new xo0();
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.upnpService.getRegistry().addListener(this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().search();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        VMLog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("onServiceDisconnected - %s", componentName);
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
    }
}
