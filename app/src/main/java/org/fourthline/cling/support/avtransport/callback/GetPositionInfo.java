package org.fourthline.cling.support.avtransport.callback;

import java.util.logging.Logger;
import me.tvspark.bq0;
import me.tvspark.dp0;
import me.tvspark.o11;
import me.tvspark.outline;
import me.tvspark.qo0;
import me.tvspark.utils.cast.manager.ControlManager;
import me.tvspark.utils.cast.utils.VMLog;
import me.tvspark.vo0;
import org.fourthline.cling.controlpoint.ActionCallback;
import org.fourthline.cling.model.action.ActionInvocation;
import org.fourthline.cling.model.meta.Service;
import org.fourthline.cling.model.types.UnsignedIntegerFourBytes;
import org.fourthline.cling.support.model.PositionInfo;

/* loaded from: classes5.dex */
public abstract class GetPositionInfo extends ActionCallback {
    public static Logger log = Logger.getLogger(GetPositionInfo.class.getName());

    public GetPositionInfo(Service service) {
        this(new UnsignedIntegerFourBytes(0L), service);
    }

    public GetPositionInfo(UnsignedIntegerFourBytes unsignedIntegerFourBytes, Service service) {
        super(new ActionInvocation(service.getAction("GetPositionInfo")));
        getActionInvocation().setInput("InstanceID", unsignedIntegerFourBytes);
    }

    public abstract void received(ActionInvocation actionInvocation, PositionInfo positionInfo);

    @Override // org.fourthline.cling.controlpoint.ActionCallback
    public void success(ActionInvocation actionInvocation) {
        PositionInfo positionInfo = new PositionInfo(actionInvocation.getOutputMap());
        dp0 dp0Var = (dp0) this;
        qo0 qo0Var = new qo0();
        qo0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = positionInfo.getAbsTime();
        qo0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = positionInfo.getTrackDuration();
        vo0 vo0Var = new vo0();
        vo0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = qo0Var;
        o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(vo0Var);
        dp0Var.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = positionInfo.getAbsTime();
        ControlManager controlManager = dp0Var.Wwwwwwwwwwwwwwwwwwwwwwww;
        controlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwww = bq0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(controlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
        dp0Var.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww = positionInfo.getTrackDuration();
        ControlManager controlManager2 = dp0Var.Wwwwwwwwwwwwwwwwwwwwwwww;
        controlManager2.Wwwwwwwwwwwwwwwwwwwwwwwww = bq0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(controlManager2.Wwwwwwwwwwwwwwwwwwwwwwwwww);
        ControlManager controlManager3 = dp0Var.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (controlManager3.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(controlManager3.Wwwwwwwwwwwwwwwwwwwwwwwwww)) {
            ControlManager controlManager4 = dp0Var.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (controlManager4.Wwwwwwwwwwwwwwwwwwwwwwwwwww != 0 && controlManager4.Wwwwwwwwwwwwwwwwwwwwwwwww != 0) {
                controlManager4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("getPositionInfo success positionInfo:");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(positionInfo.toString());
        VMLog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(VMLog.Level.DEBUG, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }
}
