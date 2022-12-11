package org.fourthline.cling.protocol.sync;

import java.util.logging.Logger;
import me.tvspark.outline;
import org.fourthline.cling.UpnpService;
import org.fourthline.cling.model.gena.CancelReason;
import org.fourthline.cling.model.gena.RemoteGENASubscription;
import org.fourthline.cling.model.message.StreamResponseMessage;
import org.fourthline.cling.model.message.gena.OutgoingUnsubscribeRequestMessage;
import org.fourthline.cling.protocol.SendingSync;
import org.fourthline.cling.transport.RouterException;

/* loaded from: classes5.dex */
public class SendingUnsubscribe extends SendingSync<OutgoingUnsubscribeRequestMessage, StreamResponseMessage> {
    public static final Logger log = Logger.getLogger(SendingUnsubscribe.class.getName());
    public final RemoteGENASubscription subscription;

    public SendingUnsubscribe(UpnpService upnpService, RemoteGENASubscription remoteGENASubscription) {
        super(upnpService, new OutgoingUnsubscribeRequestMessage(remoteGENASubscription, upnpService.getConfiguration().getEventSubscriptionHeaders(remoteGENASubscription.getService())));
        this.subscription = remoteGENASubscription;
    }

    @Override // org.fourthline.cling.protocol.SendingSync
    public StreamResponseMessage executeSync() throws RouterException {
        Logger logger = log;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Sending unsubscribe request: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getInputMessage());
        logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        try {
            StreamResponseMessage send = getUpnpService().mo5192getRouter().send(getInputMessage());
            onUnsubscribe(send);
            return send;
        } catch (Throwable th) {
            onUnsubscribe(null);
            throw th;
        }
    }

    public void onUnsubscribe(final StreamResponseMessage streamResponseMessage) {
        getUpnpService().getRegistry().removeRemoteSubscription(this.subscription);
        getUpnpService().getConfiguration().getRegistryListenerExecutor().execute(new Runnable() { // from class: org.fourthline.cling.protocol.sync.SendingUnsubscribe.1
            @Override // java.lang.Runnable
            public void run() {
                RemoteGENASubscription remoteGENASubscription;
                StreamResponseMessage streamResponseMessage2 = streamResponseMessage;
                CancelReason cancelReason = null;
                if (streamResponseMessage2 == null) {
                    SendingUnsubscribe.log.fine("Unsubscribe failed, no response received");
                    SendingUnsubscribe.this.subscription.end(CancelReason.UNSUBSCRIBE_FAILED, null);
                    return;
                }
                if (streamResponseMessage2.getOperation().isFailed()) {
                    Logger logger = SendingUnsubscribe.log;
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unsubscribe failed, response was: ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(streamResponseMessage);
                    logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                    remoteGENASubscription = SendingUnsubscribe.this.subscription;
                    cancelReason = CancelReason.UNSUBSCRIBE_FAILED;
                } else {
                    Logger logger2 = SendingUnsubscribe.log;
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unsubscribe successful, response was: ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(streamResponseMessage);
                    logger2.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                    remoteGENASubscription = SendingUnsubscribe.this.subscription;
                }
                remoteGENASubscription.end(cancelReason, streamResponseMessage.getOperation());
            }
        });
    }
}
