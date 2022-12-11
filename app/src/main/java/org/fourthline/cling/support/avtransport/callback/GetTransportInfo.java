package org.fourthline.cling.support.avtransport.callback;

import java.util.logging.Logger;
import me.tvspark.ep0;
import me.tvspark.o11;
import me.tvspark.qo0;
import me.tvspark.utils.cast.manager.ControlManager;
import me.tvspark.utils.cast.utils.VMLog;
import me.tvspark.vo0;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.fourthline.cling.controlpoint.ActionCallback;
import org.fourthline.cling.model.action.ActionInvocation;
import org.fourthline.cling.model.meta.Service;
import org.fourthline.cling.model.types.UnsignedIntegerFourBytes;
import org.fourthline.cling.support.model.TransportInfo;
import org.fourthline.cling.support.model.TransportState;

/* loaded from: classes5.dex */
public abstract class GetTransportInfo extends ActionCallback {
    public static Logger log = Logger.getLogger(GetTransportInfo.class.getName());

    public GetTransportInfo(Service service) {
        this(new UnsignedIntegerFourBytes(0L), service);
    }

    public GetTransportInfo(UnsignedIntegerFourBytes unsignedIntegerFourBytes, Service service) {
        super(new ActionInvocation(service.getAction("GetTransportInfo")));
        getActionInvocation().setInput("InstanceID", unsignedIntegerFourBytes);
    }

    public abstract void received(ActionInvocation actionInvocation, TransportInfo transportInfo);

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0042, code lost:
        if (r8.Wwwwwwwwwwwwwwwwwwwwwwwww != 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0055, code lost:
        r8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0053, code lost:
        if (r8.Wwwwwwwwwwwwwwwwwwwwwwwww != 0) goto L20;
     */
    @Override // org.fourthline.cling.controlpoint.ActionCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void success(ActionInvocation actionInvocation) {
        ControlManager controlManager;
        String str;
        TransportInfo transportInfo = new TransportInfo(actionInvocation.getOutputMap());
        ep0 ep0Var = (ep0) this;
        TransportState currentTransportState = transportInfo.getCurrentTransportState();
        qo0 qo0Var = new qo0();
        if (TransportState.TRANSITIONING == currentTransportState) {
            str = "TRANSITIONING";
        } else if (TransportState.PLAYING == currentTransportState) {
            str = "PLAYING";
        } else if (TransportState.PAUSED_PLAYBACK != currentTransportState) {
            if (TransportState.STOPPED == currentTransportState) {
                qo0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = AbstractLifeCycle.STOPPED;
                controlManager = ep0Var.Wwwwwwwwwwwwwwwwwwwwwwww;
                if (controlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwww != 0) {
                }
            } else {
                qo0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = AbstractLifeCycle.STOPPED;
                controlManager = ep0Var.Wwwwwwwwwwwwwwwwwwwwwwww;
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
