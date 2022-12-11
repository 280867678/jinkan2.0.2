package me.tvspark;

import org.fourthline.cling.model.action.ActionInvocation;
import org.fourthline.cling.model.message.UpnpResponse;
import org.fourthline.cling.model.meta.Service;
import org.fourthline.cling.model.types.UDAServiceType;
import org.fourthline.cling.support.avtransport.callback.SetAVTransportURI;

/* loaded from: classes4.dex */
public class eq0 extends SetAVTransportURI {
    public final /* synthetic */ gq0 Wwwwwwwwwwwwwwwwwwwwwwww;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eq0(gq0 gq0Var, Service service, String str, String str2) {
        super(service, str, str2);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = gq0Var;
    }

    @Override // org.fourthline.cling.controlpoint.ActionCallback
    public void failure(ActionInvocation actionInvocation, UpnpResponse upnpResponse, String str) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.obtainMessage(-5).sendToTarget();
    }

    @Override // org.fourthline.cling.support.avtransport.callback.SetAVTransportURI, org.fourthline.cling.controlpoint.ActionCallback
    public void success(ActionInvocation actionInvocation) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.obtainMessage(5).sendToTarget();
        gq0 gq0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        gq0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Service findService = gq0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.findService(new UDAServiceType("AVTransport"));
        if (findService == null) {
            gq0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.obtainMessage(-6).sendToTarget();
        } else {
            gq0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.execute(new fq0(gq0Var, findService));
        }
    }
}
