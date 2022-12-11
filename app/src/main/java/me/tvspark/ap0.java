package me.tvspark;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import me.tvspark.utils.cast.manager.ControlManager;
import me.tvspark.utils.cast.service.ClingService;
import me.tvspark.utils.cast.service.SystemService;
import org.fourthline.cling.controlpoint.ControlPoint;
import org.fourthline.cling.model.types.UDAServiceType;
import org.fourthline.cling.support.model.item.Item;

/* loaded from: classes4.dex */
public class ap0 {
    public static ap0 Wwwwwwwwwwwwwwwwwwwwwwww;
    public so0 Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Item Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public SystemService Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public ServiceConnection Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public ClingService Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public ServiceConnection Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public xo0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwww = false;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwww = false;
    public Context Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ApplicationC1880C.Wwwwwwwwwwwwwwwwwwwwwwww;

    static {
        new UDAServiceType("ContentDirectory");
    }

    public static ap0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (Wwwwwwwwwwwwwwwwwwwwwwww == null) {
            Wwwwwwwwwwwwwwwwwwwwwwww = new ap0();
        }
        return Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new zo0(this);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.bindService(new Intent(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, SystemService.class), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 1);
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new yo0(this);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.bindService(new Intent(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, ClingService.class), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 1);
        }
    }

    public ControlPoint Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.upnpService.getControlPoint();
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(so0 so0Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = so0Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        ControlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwww = ControlManager.CastState.STOPED;
    }
}
