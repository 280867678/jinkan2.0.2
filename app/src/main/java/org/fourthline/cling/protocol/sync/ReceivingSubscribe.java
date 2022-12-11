package org.fourthline.cling.protocol.sync;

import java.net.URL;
import java.util.List;
import java.util.logging.Logger;
import me.tvspark.outline;
import org.fourthline.cling.UpnpService;
import org.fourthline.cling.model.gena.CancelReason;
import org.fourthline.cling.model.gena.LocalGENASubscription;
import org.fourthline.cling.model.message.StreamRequestMessage;
import org.fourthline.cling.model.message.StreamResponseMessage;
import org.fourthline.cling.model.message.UpnpResponse;
import org.fourthline.cling.model.message.gena.IncomingSubscribeRequestMessage;
import org.fourthline.cling.model.message.gena.OutgoingSubscribeResponseMessage;
import org.fourthline.cling.model.meta.LocalService;
import org.fourthline.cling.model.resource.ServiceEventSubscriptionResource;
import org.fourthline.cling.protocol.ReceivingSync;
import org.fourthline.cling.transport.RouterException;
import org.seamless.util.Exceptions;

/* loaded from: classes5.dex */
public class ReceivingSubscribe extends ReceivingSync<StreamRequestMessage, OutgoingSubscribeResponseMessage> {
    public static final Logger log = Logger.getLogger(ReceivingSubscribe.class.getName());
    public LocalGENASubscription subscription;

    public ReceivingSubscribe(UpnpService upnpService, StreamRequestMessage streamRequestMessage) {
        super(upnpService, streamRequestMessage);
    }

    @Override // org.fourthline.cling.protocol.ReceivingSync
    public OutgoingSubscribeResponseMessage executeSync() throws RouterException {
        ServiceEventSubscriptionResource serviceEventSubscriptionResource = (ServiceEventSubscriptionResource) getUpnpService().getRegistry().getResource(ServiceEventSubscriptionResource.class, ((StreamRequestMessage) getInputMessage()).getUri());
        if (serviceEventSubscriptionResource == null) {
            Logger logger = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("No local resource found: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getInputMessage());
            logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            return null;
        }
        Logger logger2 = log;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Found local event subscription matching relative request URI: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(((StreamRequestMessage) getInputMessage()).getUri());
        logger2.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        IncomingSubscribeRequestMessage incomingSubscribeRequestMessage = new IncomingSubscribeRequestMessage((StreamRequestMessage) getInputMessage(), serviceEventSubscriptionResource.getModel());
        if (incomingSubscribeRequestMessage.getSubscriptionId() != null && (incomingSubscribeRequestMessage.hasNotificationHeader() || incomingSubscribeRequestMessage.getCallbackURLs() != null)) {
            Logger logger3 = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Subscription ID and NT or Callback in subscribe request: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(getInputMessage());
            logger3.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
            return new OutgoingSubscribeResponseMessage(UpnpResponse.Status.BAD_REQUEST);
        } else if (incomingSubscribeRequestMessage.getSubscriptionId() != null) {
            return processRenewal(serviceEventSubscriptionResource.getModel(), incomingSubscribeRequestMessage);
        } else {
            if (incomingSubscribeRequestMessage.hasNotificationHeader() && incomingSubscribeRequestMessage.getCallbackURLs() != null) {
                return processNewSubscription(serviceEventSubscriptionResource.getModel(), incomingSubscribeRequestMessage);
            }
            Logger logger4 = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("No subscription ID, no NT or Callback, neither subscription or renewal: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(getInputMessage());
            logger4.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString());
            return new OutgoingSubscribeResponseMessage(UpnpResponse.Status.PRECONDITION_FAILED);
        }
    }

    public OutgoingSubscribeResponseMessage processNewSubscription(LocalService localService, IncomingSubscribeRequestMessage incomingSubscribeRequestMessage) {
        List<URL> callbackURLs = incomingSubscribeRequestMessage.getCallbackURLs();
        if (callbackURLs == null || callbackURLs.size() == 0) {
            Logger logger = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Missing or invalid Callback URLs in subscribe request: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getInputMessage());
            logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            return new OutgoingSubscribeResponseMessage(UpnpResponse.Status.PRECONDITION_FAILED);
        } else if (!incomingSubscribeRequestMessage.hasNotificationHeader()) {
            Logger logger2 = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Missing or invalid NT header in subscribe request: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(getInputMessage());
            logger2.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
            return new OutgoingSubscribeResponseMessage(UpnpResponse.Status.PRECONDITION_FAILED);
        } else {
            try {
                this.subscription = new LocalGENASubscription(localService, getUpnpService().getConfiguration().isReceivedSubscriptionTimeoutIgnored() ? null : incomingSubscribeRequestMessage.getRequestedTimeoutSeconds(), callbackURLs) { // from class: org.fourthline.cling.protocol.sync.ReceivingSubscribe.1
                    @Override // org.fourthline.cling.model.gena.LocalGENASubscription
                    public void ended(CancelReason cancelReason) {
                    }

                    @Override // org.fourthline.cling.model.gena.GENASubscription
                    public void established() {
                    }

                    @Override // org.fourthline.cling.model.gena.GENASubscription
                    public void eventReceived() {
                        ReceivingSubscribe.this.getUpnpService().getConfiguration().getSyncProtocolExecutorService().execute(ReceivingSubscribe.this.getUpnpService().getProtocolFactory().createSendingEvent(this));
                    }
                };
                Logger logger3 = log;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Adding subscription to registry: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(this.subscription);
                logger3.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
                getUpnpService().getRegistry().addLocalSubscription(this.subscription);
                log.fine("Returning subscription response, waiting to send initial event");
                return new OutgoingSubscribeResponseMessage(this.subscription);
            } catch (Exception e) {
                Logger logger4 = log;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Couldn't create local subscription to service: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(Exceptions.unwrap(e));
                logger4.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString());
                return new OutgoingSubscribeResponseMessage(UpnpResponse.Status.INTERNAL_SERVER_ERROR);
            }
        }
    }

    public OutgoingSubscribeResponseMessage processRenewal(LocalService localService, IncomingSubscribeRequestMessage incomingSubscribeRequestMessage) {
        LocalGENASubscription localSubscription = getUpnpService().getRegistry().getLocalSubscription(incomingSubscribeRequestMessage.getSubscriptionId());
        this.subscription = localSubscription;
        if (localSubscription == null) {
            Logger logger = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid subscription ID for renewal request: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getInputMessage());
            logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            return new OutgoingSubscribeResponseMessage(UpnpResponse.Status.PRECONDITION_FAILED);
        }
        Logger logger2 = log;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Renewing subscription: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.subscription);
        logger2.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        this.subscription.setSubscriptionDuration(incomingSubscribeRequestMessage.getRequestedTimeoutSeconds());
        if (getUpnpService().getRegistry().updateLocalSubscription(this.subscription)) {
            return new OutgoingSubscribeResponseMessage(this.subscription);
        }
        Logger logger3 = log;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Subscription went away before it could be renewed: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(getInputMessage());
        logger3.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
        return new OutgoingSubscribeResponseMessage(UpnpResponse.Status.PRECONDITION_FAILED);
    }

    @Override // org.fourthline.cling.protocol.ReceivingSync
    public void responseException(Throwable th) {
        if (this.subscription == null) {
            return;
        }
        Logger logger = log;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Response could not be send to subscriber, removing local GENA subscription: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.subscription);
        logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        getUpnpService().getRegistry().removeLocalSubscription(this.subscription);
    }

    @Override // org.fourthline.cling.protocol.ReceivingSync
    public void responseSent(StreamResponseMessage streamResponseMessage) {
        if (this.subscription == null) {
            return;
        }
        if (streamResponseMessage != null && !streamResponseMessage.getOperation().isFailed() && this.subscription.getCurrentSequence().getValue().longValue() == 0) {
            log.fine("Establishing subscription");
            this.subscription.registerOnService();
            this.subscription.establish();
            log.fine("Response to subscription sent successfully, now sending initial event asynchronously");
            getUpnpService().getConfiguration().getAsyncProtocolExecutor().execute(getUpnpService().getProtocolFactory().createSendingEvent(this.subscription));
        } else if (this.subscription.getCurrentSequence().getValue().longValue() != 0) {
        } else {
            log.fine("Subscription request's response aborted, not sending initial event");
            if (streamResponseMessage == null) {
                log.fine("Reason: No response at all from subscriber");
            } else {
                Logger logger = log;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Reason: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(streamResponseMessage.getOperation());
                logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
            Logger logger2 = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Removing subscription from registry: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.subscription);
            logger2.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
            getUpnpService().getRegistry().removeLocalSubscription(this.subscription);
        }
    }
}
