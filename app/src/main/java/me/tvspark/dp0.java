package me.tvspark;

import me.tvspark.utils.cast.manager.ControlManager;
import me.tvspark.utils.cast.utils.VMLog;
import org.fourthline.cling.model.action.ActionInvocation;
import org.fourthline.cling.model.message.UpnpResponse;
import org.fourthline.cling.model.meta.Service;
import org.fourthline.cling.model.types.UnsignedIntegerFourBytes;
import org.fourthline.cling.support.avtransport.callback.GetPositionInfo;
import org.fourthline.cling.support.model.PositionInfo;

/* loaded from: classes4.dex */
public class dp0 extends GetPositionInfo {
    public final /* synthetic */ ControlManager Wwwwwwwwwwwwwwwwwwwwwwww;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dp0(ControlManager controlManager, UnsignedIntegerFourBytes unsignedIntegerFourBytes, Service service) {
        super(unsignedIntegerFourBytes, service);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = controlManager;
    }

    @Override // org.fourthline.cling.controlpoint.ActionCallback
    public void failure(ActionInvocation actionInvocation, UpnpResponse upnpResponse, String str) {
        VMLog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(VMLog.Level.ERROR, "getPositionInfo failed");
    }

    @Override // org.fourthline.cling.support.avtransport.callback.GetPositionInfo
    public void received(ActionInvocation actionInvocation, PositionInfo positionInfo) {
        if (positionInfo != null) {
            qo0 qo0Var = new qo0();
            qo0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = positionInfo.getAbsTime();
            qo0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = positionInfo.getTrackDuration();
            vo0 vo0Var = new vo0();
            vo0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = qo0Var;
            o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(vo0Var);
            this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = positionInfo.getAbsTime();
            ControlManager controlManager = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            controlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwww = bq0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(controlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww = positionInfo.getTrackDuration();
            ControlManager controlManager2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            controlManager2.Wwwwwwwwwwwwwwwwwwwwwwwww = bq0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(controlManager2.Wwwwwwwwwwwwwwwwwwwwwwwwww);
            ControlManager controlManager3 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (controlManager3.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(controlManager3.Wwwwwwwwwwwwwwwwwwwwwwwwww)) {
                ControlManager controlManager4 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                if (controlManager4.Wwwwwwwwwwwwwwwwwwwwwwwwwww != 0 && controlManager4.Wwwwwwwwwwwwwwwwwwwwwwwww != 0) {
                    controlManager4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
            }
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("getPositionInfo success positionInfo:");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(positionInfo.toString());
        VMLog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(VMLog.Level.DEBUG, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }
}
