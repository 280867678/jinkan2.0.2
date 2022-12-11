package me.tvspark;

import org.fourthline.cling.model.action.ActionInvocation;
import org.fourthline.cling.model.message.UpnpResponse;
import org.fourthline.cling.model.meta.Service;
import org.fourthline.cling.model.types.UDAServiceType;
import org.fourthline.cling.support.avtransport.callback.Play;

/* loaded from: classes4.dex */
public class fq0 extends Play {
    public final /* synthetic */ gq0 Wwwwwwwwwwwwwwwwwwwwwwww;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fq0(gq0 gq0Var, Service service) {
        super(service);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = gq0Var;
    }

    @Override // org.fourthline.cling.controlpoint.ActionCallback
    public void failure(ActionInvocation actionInvocation, UpnpResponse upnpResponse, String str) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.obtainMessage(-6).sendToTarget();
    }

    @Override // org.fourthline.cling.support.avtransport.callback.Play, org.fourthline.cling.controlpoint.ActionCallback
    public void success(ActionInvocation actionInvocation) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.obtainMessage(6).sendToTarget();
        gq0 gq0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        gq0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Service findService = gq0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.findService(new UDAServiceType("AVTransport"));
        if (findService == null) {
            return;
        }
        gq0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.execute(new dq0(gq0Var, findService));
    }
}
