package org.fourthline.cling.protocol.sync;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import me.tvspark.outline;
import org.fourthline.cling.UpnpService;
import org.fourthline.cling.model.NetworkAddress;
import org.fourthline.cling.model.gena.RemoteGENASubscription;
import org.fourthline.cling.model.message.StreamResponseMessage;
import org.fourthline.cling.model.message.gena.IncomingSubscribeResponseMessage;
import org.fourthline.cling.model.message.gena.OutgoingSubscribeRequestMessage;
import org.fourthline.cling.protocol.SendingSync;
import org.fourthline.cling.transport.RouterException;

/* loaded from: classes5.dex */
public class SendingSubscribe extends SendingSync<OutgoingSubscribeRequestMessage, IncomingSubscribeResponseMessage> {
    public static final Logger log = Logger.getLogger(SendingSubscribe.class.getName());
    public final RemoteGENASubscription subscription;

    public SendingSubscribe(UpnpService upnpService, RemoteGENASubscription remoteGENASubscription, List<NetworkAddress> list) {
        super(upnpService, new OutgoingSubscribeRequestMessage(remoteGENASubscription, remoteGENASubscription.getEventCallbackURLs(list, upnpService.getConfiguration().getNamespace()), upnpService.getConfiguration().getEventSubscriptionHeaders(remoteGENASubscription.getService())));
        this.subscription = remoteGENASubscription;
    }

    @Override // org.fourthline.cling.protocol.SendingSync
    public IncomingSubscribeResponseMessage executeSync() throws RouterException {
        Executor registryListenerExecutor;
        Runnable runnable;
        if (!getInputMessage().hasCallbackURLs()) {
            log.fine("Subscription failed, no active local callback URLs available (network disabled?)");
            getUpnpService().getConfiguration().getRegistryListenerExecutor().execute(new Runnable() { // from class: org.fourthline.cling.protocol.sync.SendingSubscribe.1
                @Override // java.lang.Runnable
                public void run() {
                    SendingSubscribe.this.subscription.fail(null);
                }
            });
            return null;
        }
        Logger logger = log;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Sending subscription request: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getInputMessage());
        logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        try {
            getUpnpService().getRegistry().registerPendingRemoteSubscription(this.subscription);
            StreamResponseMessage send = getUpnpService().mo5192getRouter().send(getInputMessage());
            if (send == null) {
                onSubscriptionFailure();
                return null;
            }
            final IncomingSubscribeResponseMessage incomingSubscribeResponseMessage = new IncomingSubscribeResponseMessage(send);
            if (send.getOperation().isFailed()) {
                Logger logger2 = log;
                logger2.fine("Subscription failed, response was: " + incomingSubscribeResponseMessage);
                registryListenerExecutor = getUpnpService().getConfiguration().getRegistryListenerExecutor();
                runnable = new Runnable() { // from class: org.fourthline.cling.protocol.sync.SendingSubscribe.2
                    @Override // java.lang.Runnable
                    public void run() {
                        SendingSubscribe.this.subscription.fail(incomingSubscribeResponseMessage.getOperation());
                    }
                };
            } else if (!incomingSubscribeResponseMessage.isValidHeaders()) {
                log.severe("Subscription failed, invalid or missing (SID, Timeout) response headers");
                registryListenerExecutor = getUpnpService().getConfiguration().getRegistryListenerExecutor();
                runnable = new Runnable() { // from class: org.fourthline.cling.protocol.sync.SendingSubscribe.3
                    @Override // java.lang.Runnable
                    public void run() {
                        SendingSubscribe.this.subscription.fail(incomingSubscribeResponseMessage.getOperation());
                    }
                };
            } else {
                Logger logger3 = log;
                logger3.fine("Subscription established, adding to registry, response was: " + send);
                this.subscription.setSubscriptionId(incomingSubscribeResponseMessage.getSubscriptionId());
                this.subscription.setActualSubscriptionDurationSeconds(incomingSubscribeResponseMessage.getSubscriptionDurationSeconds());
                getUpnpService().getRegistry().addRemoteSubscription(this.subscription);
                registryListenerExecutor = getUpnpService().getConfiguration().getRegistryListenerExecutor();
                runnable = new Runnable() { // from class: org.fourthline.cling.protocol.sync.SendingSubscribe.4
                    @Override // java.lang.Runnable
                    public void run() {
                        SendingSubscribe.this.subscription.establish();
                    }
                };
            }
            registryListenerExecutor.execute(runnable);
            return incomingSubscribeResponseMessage;
        } catch (RouterException unused) {
            onSubscriptionFailure();
            return null;
        } finally {
            getUpnpService().getRegistry().unregisterPendingRemoteSubscription(this.subscription);
        }
    }

    public void onSubscriptionFailure() {
        log.fine("Subscription failed");
        getUpnpService().getConfiguration().getRegistryListenerExecutor().execute(new Runnable() { // from class: org.fourthline.cling.protocol.sync.SendingSubscribe.5
            @Override // java.lang.Runnable
            public void run() {
                SendingSubscribe.this.subscription.fail(null);
            }
        });
    }
}
