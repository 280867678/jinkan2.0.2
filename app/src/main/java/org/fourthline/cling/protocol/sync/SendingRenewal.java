package org.fourthline.cling.protocol.sync;

import java.util.concurrent.Executor;
import java.util.logging.Logger;
import me.tvspark.outline;
import org.fourthline.cling.UpnpService;
import org.fourthline.cling.model.gena.CancelReason;
import org.fourthline.cling.model.gena.RemoteGENASubscription;
import org.fourthline.cling.model.message.StreamResponseMessage;
import org.fourthline.cling.model.message.gena.IncomingSubscribeResponseMessage;
import org.fourthline.cling.model.message.gena.OutgoingRenewalRequestMessage;
import org.fourthline.cling.protocol.SendingSync;
import org.fourthline.cling.transport.RouterException;

/* loaded from: classes5.dex */
public class SendingRenewal extends SendingSync<OutgoingRenewalRequestMessage, IncomingSubscribeResponseMessage> {
    public static final Logger log = Logger.getLogger(SendingRenewal.class.getName());
    public final RemoteGENASubscription subscription;

    public SendingRenewal(UpnpService upnpService, RemoteGENASubscription remoteGENASubscription) {
        super(upnpService, new OutgoingRenewalRequestMessage(remoteGENASubscription, upnpService.getConfiguration().getEventSubscriptionHeaders(remoteGENASubscription.getService())));
        this.subscription = remoteGENASubscription;
    }

    @Override // org.fourthline.cling.protocol.SendingSync
    public IncomingSubscribeResponseMessage executeSync() throws RouterException {
        Executor registryListenerExecutor;
        Runnable runnable;
        Logger logger = log;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Sending subscription renewal request: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getInputMessage());
        logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        try {
            StreamResponseMessage send = getUpnpService().mo5192getRouter().send(getInputMessage());
            if (send == null) {
                onRenewalFailure();
                return null;
            }
            final IncomingSubscribeResponseMessage incomingSubscribeResponseMessage = new IncomingSubscribeResponseMessage(send);
            if (send.getOperation().isFailed()) {
                Logger logger2 = log;
                logger2.fine("Subscription renewal failed, response was: " + send);
                getUpnpService().getRegistry().removeRemoteSubscription(this.subscription);
                registryListenerExecutor = getUpnpService().getConfiguration().getRegistryListenerExecutor();
                runnable = new Runnable() { // from class: org.fourthline.cling.protocol.sync.SendingRenewal.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SendingRenewal.this.subscription.end(CancelReason.RENEWAL_FAILED, incomingSubscribeResponseMessage.getOperation());
                    }
                };
            } else if (incomingSubscribeResponseMessage.isValidHeaders()) {
                Logger logger3 = log;
                logger3.fine("Subscription renewed, updating in registry, response was: " + send);
                this.subscription.setActualSubscriptionDurationSeconds(incomingSubscribeResponseMessage.getSubscriptionDurationSeconds());
                getUpnpService().getRegistry().updateRemoteSubscription(this.subscription);
                return incomingSubscribeResponseMessage;
            } else {
                log.severe("Subscription renewal failed, invalid or missing (SID, Timeout) response headers");
                registryListenerExecutor = getUpnpService().getConfiguration().getRegistryListenerExecutor();
                runnable = new Runnable() { // from class: org.fourthline.cling.protocol.sync.SendingRenewal.2
                    @Override // java.lang.Runnable
                    public void run() {
                        SendingRenewal.this.subscription.end(CancelReason.RENEWAL_FAILED, incomingSubscribeResponseMessage.getOperation());
                    }
                };
            }
            registryListenerExecutor.execute(runnable);
            return incomingSubscribeResponseMessage;
        } catch (RouterException e) {
            onRenewalFailure();
            throw e;
        }
    }

    public void onRenewalFailure() {
        log.fine("Subscription renewal failed, removing subscription from registry");
        getUpnpService().getRegistry().removeRemoteSubscription(this.subscription);
        getUpnpService().getConfiguration().getRegistryListenerExecutor().execute(new Runnable() { // from class: org.fourthline.cling.protocol.sync.SendingRenewal.3
            @Override // java.lang.Runnable
            public void run() {
                SendingRenewal.this.subscription.end(CancelReason.RENEWAL_FAILED, null);
            }
        });
    }
}
