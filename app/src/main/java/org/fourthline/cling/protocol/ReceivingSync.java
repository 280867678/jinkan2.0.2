package org.fourthline.cling.protocol;

import java.util.logging.Logger;
import me.tvspark.outline;
import org.fourthline.cling.UpnpService;
import org.fourthline.cling.model.message.StreamRequestMessage;
import org.fourthline.cling.model.message.StreamResponseMessage;
import org.fourthline.cling.model.profile.RemoteClientInfo;
import org.fourthline.cling.transport.RouterException;

/* loaded from: classes5.dex */
public abstract class ReceivingSync<IN extends StreamRequestMessage, OUT extends StreamResponseMessage> extends ReceivingAsync<IN> {
    public static final Logger log = Logger.getLogger(UpnpService.class.getName());
    public OUT outputMessage;
    public final RemoteClientInfo remoteClientInfo;

    public ReceivingSync(UpnpService upnpService, IN in) {
        super(upnpService, in);
        this.remoteClientInfo = new RemoteClientInfo(in);
    }

    @Override // org.fourthline.cling.protocol.ReceivingAsync
    public final void execute() throws RouterException {
        OUT executeSync = executeSync();
        this.outputMessage = executeSync;
        if (executeSync == null || getRemoteClientInfo().getExtraResponseHeaders().size() <= 0) {
            return;
        }
        Logger logger = log;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Setting extra headers on response message: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getRemoteClientInfo().getExtraResponseHeaders().size());
        logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        this.outputMessage.getHeaders().putAll(getRemoteClientInfo().getExtraResponseHeaders());
    }

    public abstract OUT executeSync() throws RouterException;

    public OUT getOutputMessage() {
        return this.outputMessage;
    }

    public RemoteClientInfo getRemoteClientInfo() {
        return this.remoteClientInfo;
    }

    public void responseException(Throwable th) {
    }

    public void responseSent(StreamResponseMessage streamResponseMessage) {
    }

    @Override // org.fourthline.cling.protocol.ReceivingAsync
    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getClass().getSimpleName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
