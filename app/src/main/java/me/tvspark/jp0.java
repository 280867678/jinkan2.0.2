package me.tvspark;

import me.tvspark.utils.cast.manager.ControlManager;
import me.tvspark.utils.cast.utils.VMLog;
import org.fourthline.cling.model.action.ActionInvocation;
import org.fourthline.cling.model.message.UpnpResponse;
import org.fourthline.cling.model.meta.Service;
import org.fourthline.cling.model.types.UnsignedIntegerFourBytes;
import org.fourthline.cling.support.renderingcontrol.callback.SetVolume;

/* loaded from: classes4.dex */
public class jp0 extends SetVolume {
    public final /* synthetic */ AbstractC3509oo0 Wwwwwwwwwwwwwwwwwwwwwwww;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jp0(ControlManager controlManager, UnsignedIntegerFourBytes unsignedIntegerFourBytes, Service service, long j, AbstractC3509oo0 abstractC3509oo0) {
        super(unsignedIntegerFourBytes, service, j);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = abstractC3509oo0;
    }

    @Override // org.fourthline.cling.controlpoint.ActionCallback
    public void failure(ActionInvocation actionInvocation, UpnpResponse upnpResponse, String str) {
        VMLog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("setVolume error %s", str);
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1, str);
    }

    @Override // org.fourthline.cling.support.renderingcontrol.callback.SetVolume, org.fourthline.cling.controlpoint.ActionCallback
    public void success(ActionInvocation actionInvocation) {
        VMLog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(VMLog.Level.DEBUG, "setVolume success");
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }
}
