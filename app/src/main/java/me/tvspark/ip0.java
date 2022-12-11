package me.tvspark;

import me.tvspark.utils.cast.manager.ControlManager;
import me.tvspark.utils.cast.utils.VMLog;
import org.fourthline.cling.model.action.ActionInvocation;
import org.fourthline.cling.model.message.UpnpResponse;
import org.fourthline.cling.model.meta.Service;
import org.fourthline.cling.model.types.UnsignedIntegerFourBytes;
import org.fourthline.cling.support.avtransport.callback.Seek;

/* loaded from: classes4.dex */
public class ip0 extends Seek {
    public final /* synthetic */ AbstractC3509oo0 Wwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwww;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ip0(ControlManager controlManager, UnsignedIntegerFourBytes unsignedIntegerFourBytes, Service service, String str, String str2, AbstractC3509oo0 abstractC3509oo0) {
        super(unsignedIntegerFourBytes, service, str);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = str2;
        this.Wwwwwwwwwwwwwwwwwwwwwww = abstractC3509oo0;
    }

    @Override // org.fourthline.cling.controlpoint.ActionCallback
    public void failure(ActionInvocation actionInvocation, UpnpResponse upnpResponse, String str) {
        VMLog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Seek error %s", str);
        this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1, str);
    }

    @Override // org.fourthline.cling.support.avtransport.callback.Seek, org.fourthline.cling.controlpoint.ActionCallback
    public void success(ActionInvocation actionInvocation) {
        VMLog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Seek success - %s", this.Wwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }
}
