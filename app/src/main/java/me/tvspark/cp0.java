package me.tvspark;

import me.tvspark.utils.cast.manager.ControlManager;
import me.tvspark.utils.cast.utils.VMLog;
import org.fourthline.cling.model.action.ActionInvocation;
import org.fourthline.cling.model.message.UpnpResponse;
import org.fourthline.cling.model.meta.Service;
import org.fourthline.cling.model.types.UnsignedIntegerFourBytes;
import org.fourthline.cling.support.avtransport.callback.SetAVTransportURI;

/* loaded from: classes4.dex */
public class cp0 extends SetAVTransportURI {
    public final /* synthetic */ AbstractC3509oo0 Wwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwww;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cp0(ControlManager controlManager, UnsignedIntegerFourBytes unsignedIntegerFourBytes, Service service, String str, String str2, String str3, AbstractC3509oo0 abstractC3509oo0) {
        super(unsignedIntegerFourBytes, service, str, str2);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = str3;
        this.Wwwwwwwwwwwwwwwwwwwwwww = abstractC3509oo0;
    }

    @Override // org.fourthline.cling.controlpoint.ActionCallback
    public void failure(ActionInvocation actionInvocation, UpnpResponse upnpResponse, String str) {
        VMLog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("setAVTransportURI - error %s url:%s", str, this.Wwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1, str);
    }

    @Override // org.fourthline.cling.support.avtransport.callback.SetAVTransportURI, org.fourthline.cling.controlpoint.ActionCallback
    public void success(ActionInvocation actionInvocation) {
        VMLog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("setAVTransportURI success url:%s", this.Wwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }
}
