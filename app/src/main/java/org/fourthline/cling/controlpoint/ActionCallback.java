package org.fourthline.cling.controlpoint;

import me.tvspark.outline;
import org.fourthline.cling.model.action.ActionException;
import org.fourthline.cling.model.action.ActionInvocation;
import org.fourthline.cling.model.message.UpnpResponse;
import org.fourthline.cling.model.message.control.IncomingActionResponseMessage;
import org.fourthline.cling.model.meta.LocalService;
import org.fourthline.cling.model.meta.RemoteService;
import org.fourthline.cling.model.meta.Service;
import org.fourthline.cling.protocol.sync.SendingAction;

/* loaded from: classes5.dex */
public abstract class ActionCallback implements Runnable {
    public final ActionInvocation actionInvocation;
    public ControlPoint controlPoint;

    /* loaded from: classes5.dex */
    public static final class Default extends ActionCallback {
        public Default(ActionInvocation actionInvocation, ControlPoint controlPoint) {
            super(actionInvocation, controlPoint);
        }

        @Override // org.fourthline.cling.controlpoint.ActionCallback
        public void failure(ActionInvocation actionInvocation, UpnpResponse upnpResponse, String str) {
        }

        @Override // org.fourthline.cling.controlpoint.ActionCallback
        public void success(ActionInvocation actionInvocation) {
        }
    }

    public ActionCallback(ActionInvocation actionInvocation) {
        this.actionInvocation = actionInvocation;
    }

    public ActionCallback(ActionInvocation actionInvocation, ControlPoint controlPoint) {
        this.actionInvocation = actionInvocation;
        this.controlPoint = controlPoint;
    }

    public String createDefaultFailureMessage(ActionInvocation actionInvocation, UpnpResponse upnpResponse) {
        ActionException failure = actionInvocation.getFailure();
        String str = "Error: ";
        if (failure != null) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(failure.getMessage());
            str = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        if (upnpResponse != null) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, " (HTTP response was: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(upnpResponse.getResponseDetails());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        return str;
    }

    public void failure(ActionInvocation actionInvocation, UpnpResponse upnpResponse) {
        failure(actionInvocation, upnpResponse, createDefaultFailureMessage(actionInvocation, upnpResponse));
    }

    public abstract void failure(ActionInvocation actionInvocation, UpnpResponse upnpResponse, String str);

    public ActionInvocation getActionInvocation() {
        return this.actionInvocation;
    }

    public synchronized ControlPoint getControlPoint() {
        return this.controlPoint;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0026, code lost:
        if (r4.actionInvocation.getFailure() != null) goto L8;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Service service = this.actionInvocation.getAction().getService();
        if (!(service instanceof LocalService)) {
            if (!(service instanceof RemoteService)) {
                return;
            }
            if (getControlPoint() == null) {
                throw new IllegalStateException("Callback must be executed through ControlPoint");
            }
            RemoteService remoteService = (RemoteService) service;
            try {
                SendingAction createSendingAction = getControlPoint().getProtocolFactory().createSendingAction(this.actionInvocation, remoteService.getDevice().normalizeURI(remoteService.getControlURI()));
                createSendingAction.run();
                IncomingActionResponseMessage outputMessage = createSendingAction.getOutputMessage();
                if (outputMessage != null) {
                    if (outputMessage.getOperation().isFailed()) {
                        failure(this.actionInvocation, outputMessage.getOperation());
                        return;
                    }
                    success(this.actionInvocation);
                    return;
                }
                failure(this.actionInvocation, null);
                return;
            } catch (IllegalArgumentException unused) {
                ActionInvocation actionInvocation = this.actionInvocation;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("bad control URL: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(remoteService.getControlURI());
                failure(actionInvocation, null, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                return;
            }
        }
        ((LocalService) service).getExecutor(this.actionInvocation.getAction()).execute(this.actionInvocation);
    }

    public synchronized ActionCallback setControlPoint(ControlPoint controlPoint) {
        this.controlPoint = controlPoint;
        return this;
    }

    public abstract void success(ActionInvocation actionInvocation);

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(ActionCallback) ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.actionInvocation);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
