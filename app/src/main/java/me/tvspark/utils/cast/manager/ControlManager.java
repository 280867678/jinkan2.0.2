package me.tvspark.utils.cast.manager;

import me.tvspark.AbstractC3509oo0;
import me.tvspark.ap0;
import me.tvspark.dp0;
import me.tvspark.ep0;
import me.tvspark.fp0;
import me.tvspark.lp0;
import me.tvspark.mo0;
import me.tvspark.po0;
import me.tvspark.ro0;
import me.tvspark.utils.cast.utils.VMLog;
import org.fourthline.cling.model.action.ActionInvocation;
import org.fourthline.cling.model.message.UpnpResponse;
import org.fourthline.cling.model.meta.Service;
import org.fourthline.cling.model.types.UDAServiceType;
import org.fourthline.cling.model.types.UnsignedIntegerFourBytes;
import org.fourthline.cling.support.avtransport.callback.Play;
import org.fourthline.cling.support.avtransport.callback.Stop;

/* loaded from: classes4.dex */
public class ControlManager {
    public static ControlManager Wwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public po0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public mo0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
    public CastState Wwwwwwwwwwwwwwwwwwwwwwww = CastState.STOPED;
    public Service Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("AVTransport");
    public Service Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("RenderingControl");
    public UnsignedIntegerFourBytes Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new UnsignedIntegerFourBytes("0");

    /* loaded from: classes4.dex */
    public enum CastState {
        TRANSITIONING,
        PLAYING,
        PAUSED,
        STOPED
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Stop {
        public final /* synthetic */ AbstractC3509oo0 Wwwwwwwwwwwwwwwwwwwwwwww;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ControlManager controlManager, UnsignedIntegerFourBytes unsignedIntegerFourBytes, Service service, AbstractC3509oo0 abstractC3509oo0) {
            super(unsignedIntegerFourBytes, service);
            this.Wwwwwwwwwwwwwwwwwwwwwwww = abstractC3509oo0;
        }

        @Override // org.fourthline.cling.controlpoint.ActionCallback
        public void failure(ActionInvocation actionInvocation, UpnpResponse upnpResponse, String str) {
            VMLog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Stop error %s", str);
            this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1, str);
        }

        @Override // org.fourthline.cling.support.avtransport.callback.Stop, org.fourthline.cling.controlpoint.ActionCallback
        public void success(ActionInvocation actionInvocation) {
            VMLog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(VMLog.Level.INFO, "Stop success");
            this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Play {
        public final /* synthetic */ AbstractC3509oo0 Wwwwwwwwwwwwwwwwwwwwwwww;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ControlManager controlManager, UnsignedIntegerFourBytes unsignedIntegerFourBytes, Service service, AbstractC3509oo0 abstractC3509oo0) {
            super(unsignedIntegerFourBytes, service);
            this.Wwwwwwwwwwwwwwwwwwwwwwww = abstractC3509oo0;
        }

        @Override // org.fourthline.cling.controlpoint.ActionCallback
        public void failure(ActionInvocation actionInvocation, UpnpResponse upnpResponse, String str) {
            VMLog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Play error %s", str);
            this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1, str);
        }

        @Override // org.fourthline.cling.support.avtransport.callback.Play, org.fourthline.cling.controlpoint.ActionCallback
        public void success(ActionInvocation actionInvocation) {
            VMLog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(VMLog.Level.INFO, "Play success");
            this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends po0 {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ControlManager controlManager, Service service) {
            super(service);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends mo0 {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ControlManager controlManager, Service service) {
            super(service);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                ControlManager controlManager = ControlManager.this;
                if (controlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    try {
                        if (!controlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                            ap0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().execute(new dp0(controlManager, controlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, controlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                        }
                        ControlManager controlManager2 = ControlManager.this;
                        if (!controlManager2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                            ap0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().execute(new ep0(controlManager2, controlManager2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, controlManager2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                        }
                        ControlManager controlManager3 = ControlManager.this;
                        if (!controlManager3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                            ap0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().execute(new fp0(controlManager3, controlManager3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, controlManager3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                        }
                        if (ControlManager.this.Wwwwwwwwwwwwwwwwwwwwwwww == CastState.PAUSED) {
                            Thread.sleep(2000L);
                        } else {
                            Thread.sleep(1000L);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    return;
                }
            }
        }
    }

    public static ControlManager Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (Wwwwwwwwwwwwwwwwwwwwwww == null) {
            Wwwwwwwwwwwwwwwwwwwwwww = new ControlManager();
        }
        return Wwwwwwwwwwwwwwwwwwwwwww;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("AVTransport");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("RenderingControl");
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        VMLog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(VMLog.Level.DEBUG, "unInitScreenCastCallback");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = "00:00:00";
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = 0L;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = "00:00:00";
        this.Wwwwwwwwwwwwwwwwwwwwwwwww = 0L;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        VMLog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(VMLog.Level.DEBUG, "initScreenCastCallback");
        new Thread(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()).start();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        ap0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().execute(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        ap0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().execute(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC3509oo0 abstractC3509oo0) {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            abstractC3509oo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(101, "AVTService is null");
        } else {
            ap0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().execute(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, abstractC3509oo0));
        }
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("RenderingControl");
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null;
    }

    public Service Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        UDAServiceType uDAServiceType = new UDAServiceType(str);
        ro0 ro0Var = lp0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (ro0Var == null) {
            return null;
        }
        return ro0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.findService(uDAServiceType);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC3509oo0 abstractC3509oo0) {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            abstractC3509oo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(101, "AVTService is null");
        } else {
            ap0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().execute(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, abstractC3509oo0));
        }
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("AVTransport");
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null;
    }
}
