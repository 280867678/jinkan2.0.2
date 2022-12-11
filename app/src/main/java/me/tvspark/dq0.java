package me.tvspark;

import org.fourthline.cling.model.action.ActionInvocation;
import org.fourthline.cling.model.message.UpnpResponse;
import org.fourthline.cling.model.meta.Service;
import org.fourthline.cling.support.avtransport.callback.GetMediaInfo;
import org.fourthline.cling.support.model.MediaInfo;

/* loaded from: classes4.dex */
public class dq0 extends GetMediaInfo {
    public final /* synthetic */ gq0 Wwwwwwwwwwwwwwwwwwwwwwww;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dq0(gq0 gq0Var, Service service) {
        super(service);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = gq0Var;
    }

    @Override // org.fourthline.cling.controlpoint.ActionCallback
    public void failure(ActionInvocation actionInvocation, UpnpResponse upnpResponse, String str) {
    }

    @Override // org.fourthline.cling.support.avtransport.callback.GetMediaInfo
    public void received(ActionInvocation actionInvocation, MediaInfo mediaInfo) {
        mediaInfo.getMediaDuration();
        mediaInfo.getCurrentURI();
        mediaInfo.getCurrentURIMetaData();
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.obtainMessage(16, mediaInfo).sendToTarget();
    }

    @Override // org.fourthline.cling.support.avtransport.callback.GetMediaInfo, org.fourthline.cling.controlpoint.ActionCallback
    public void success(ActionInvocation actionInvocation) {
        super.success(actionInvocation);
    }
}
