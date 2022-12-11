package org.fourthline.cling.support.renderingcontrol.callback;

import java.util.logging.Logger;
import me.tvspark.o11;
import me.tvspark.outline;
import me.tvspark.to0;
import me.tvspark.utils.cast.utils.VMLog;
import me.tvspark.vo0;
import org.fourthline.cling.controlpoint.ActionCallback;
import org.fourthline.cling.model.action.ActionException;
import org.fourthline.cling.model.action.ActionInvocation;
import org.fourthline.cling.model.meta.Service;
import org.fourthline.cling.model.types.ErrorCode;
import org.fourthline.cling.model.types.UnsignedIntegerFourBytes;
import org.fourthline.cling.support.model.Channel;

/* loaded from: classes5.dex */
public abstract class GetVolume extends ActionCallback {
    public static Logger log = Logger.getLogger(GetVolume.class.getName());

    public GetVolume(Service service) {
        this(new UnsignedIntegerFourBytes(0L), service);
    }

    public GetVolume(UnsignedIntegerFourBytes unsignedIntegerFourBytes, Service service) {
        super(new ActionInvocation(service.getAction("GetVolume")));
        getActionInvocation().setInput("InstanceID", unsignedIntegerFourBytes);
        ActionInvocation actionInvocation = getActionInvocation();
        Channel channel = Channel.Master;
        actionInvocation.setInput("Channel", "Master");
    }

    public abstract void received(ActionInvocation actionInvocation, int i);

    @Override // org.fourthline.cling.controlpoint.ActionCallback
    public void success(ActionInvocation actionInvocation) {
        int i;
        boolean z;
        try {
            i = Integer.valueOf(actionInvocation.getOutput("CurrentVolume").getValue().toString()).intValue();
            z = true;
        } catch (Exception e) {
            actionInvocation.setFailure(new ActionException(ErrorCode.ACTION_FAILED, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Can't parse ProtocolInfo response: ", e), e));
            failure(actionInvocation, null);
            i = 0;
            z = false;
        }
        if (z) {
            to0 to0Var = new to0();
            to0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            to0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
            vo0 vo0Var = new vo0();
            vo0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = to0Var;
            o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(vo0Var);
            VMLog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(VMLog.Level.DEBUG, "getVolume success volume:" + i);
        }
    }
}
