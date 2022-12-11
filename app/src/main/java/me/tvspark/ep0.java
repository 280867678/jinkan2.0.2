package me.tvspark;

import me.tvspark.utils.cast.manager.ControlManager;
import me.tvspark.utils.cast.utils.VMLog;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.fourthline.cling.model.action.ActionInvocation;
import org.fourthline.cling.model.message.UpnpResponse;
import org.fourthline.cling.model.meta.Service;
import org.fourthline.cling.model.types.UnsignedIntegerFourBytes;
import org.fourthline.cling.support.avtransport.callback.GetTransportInfo;
import org.fourthline.cling.support.model.TransportInfo;
import org.fourthline.cling.support.model.TransportState;

/* loaded from: classes4.dex */
public class ep0 extends GetTransportInfo {
    public final /* synthetic */ ControlManager Wwwwwwwwwwwwwwwwwwwwwwww;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ep0(ControlManager controlManager, UnsignedIntegerFourBytes unsignedIntegerFourBytes, Service service) {
        super(unsignedIntegerFourBytes, service);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = controlManager;
    }

    @Override // org.fourthline.cling.controlpoint.ActionCallback
    public void failure(ActionInvocation actionInvocation, UpnpResponse upnpResponse, String str) {
        VMLog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(VMLog.Level.ERROR, "getTransportInfo failed");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0036, code lost:
        if (r0.Wwwwwwwwwwwwwwwwwwwwwwwww != 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
        r0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0047, code lost:
        if (r0.Wwwwwwwwwwwwwwwwwwwwwwwww != 0) goto L20;
     */
    @Override // org.fourthline.cling.support.avtransport.callback.GetTransportInfo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void received(ActionInvocation actionInvocation, TransportInfo transportInfo) {
        ControlManager controlManager;
        String str;
        TransportState currentTransportState = transportInfo.getCurrentTransportState();
        qo0 qo0Var = new qo0();
        if (TransportState.TRANSITIONING == currentTransportState) {
            str = "TRANSITIONING";
        } else if (TransportState.PLAYING == currentTransportState) {
            str = "PLAYING";
        } else if (TransportState.PAUSED_PLAYBACK != currentTransportState) {
            if (TransportState.STOPPED == currentTransportState) {
                qo0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = AbstractLifeCycle.STOPPED;
                controlManager = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                if (controlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwww != 0) {
                }
            } else {
                qo0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = AbstractLifeCycle.STOPPED;
                controlManager = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                if (controlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwww != 0) {
                }
            }
            vo0 vo0Var = new vo0();
            vo0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = qo0Var;
            o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(vo0Var);
            VMLog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(VMLog.Level.DEBUG, "getTransportInfo success transportInfo:" + currentTransportState.getValue());
        } else {
            str = "PAUSED_PLAYBACK";
        }
        qo0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
        vo0 vo0Var2 = new vo0();
        vo0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = qo0Var;
        o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(vo0Var2);
        VMLog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(VMLog.Level.DEBUG, "getTransportInfo success transportInfo:" + currentTransportState.getValue());
    }
}
