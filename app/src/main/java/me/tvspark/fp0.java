package me.tvspark;

import me.tvspark.utils.cast.manager.ControlManager;
import me.tvspark.utils.cast.utils.VMLog;
import org.fourthline.cling.model.action.ActionInvocation;
import org.fourthline.cling.model.message.UpnpResponse;
import org.fourthline.cling.model.meta.Service;
import org.fourthline.cling.model.types.UnsignedIntegerFourBytes;
import org.fourthline.cling.support.renderingcontrol.callback.GetVolume;

/* loaded from: classes4.dex */
public class fp0 extends GetVolume {
    public fp0(ControlManager controlManager, UnsignedIntegerFourBytes unsignedIntegerFourBytes, Service service) {
        super(unsignedIntegerFourBytes, service);
    }

    @Override // org.fourthline.cling.controlpoint.ActionCallback
    public void failure(ActionInvocation actionInvocation, UpnpResponse upnpResponse, String str) {
        VMLog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("getVolume error %s", str);
    }

    @Override // org.fourthline.cling.support.renderingcontrol.callback.GetVolume
    public void received(ActionInvocation actionInvocation, int i) {
        to0 to0Var = new to0();
        to0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        to0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        vo0 vo0Var = new vo0();
        vo0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = to0Var;
        o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(vo0Var);
        VMLog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(VMLog.Level.DEBUG, "getVolume success volume:" + i);
    }
}
