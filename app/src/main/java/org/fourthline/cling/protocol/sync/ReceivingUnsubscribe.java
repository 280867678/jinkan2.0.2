package org.fourthline.cling.protocol.sync;

import java.util.logging.Logger;
import me.tvspark.outline;
import org.fourthline.cling.UpnpService;
import org.fourthline.cling.model.gena.LocalGENASubscription;
import org.fourthline.cling.model.message.StreamRequestMessage;
import org.fourthline.cling.model.message.StreamResponseMessage;
import org.fourthline.cling.model.message.UpnpResponse;
import org.fourthline.cling.model.message.gena.IncomingUnsubscribeRequestMessage;
import org.fourthline.cling.model.resource.ServiceEventSubscriptionResource;
import org.fourthline.cling.protocol.ReceivingSync;
import org.fourthline.cling.transport.RouterException;

/* loaded from: classes5.dex */
public class ReceivingUnsubscribe extends ReceivingSync<StreamRequestMessage, StreamResponseMessage> {
    public static final Logger log = Logger.getLogger(ReceivingUnsubscribe.class.getName());

    public ReceivingUnsubscribe(UpnpService upnpService, StreamRequestMessage streamRequestMessage) {
        super(upnpService, streamRequestMessage);
    }

    @Override // org.fourthline.cling.protocol.ReceivingSync
    public StreamResponseMessage executeSync() throws RouterException {
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
        IncomingUnsubscribeRequestMessage incomingUnsubscribeRequestMessage = new IncomingUnsubscribeRequestMessage((StreamRequestMessage) getInputMessage(), serviceEventSubscriptionResource.getModel());
        if (incomingUnsubscribeRequestMessage.getSubscriptionId() != null && (incomingUnsubscribeRequestMessage.hasNotificationHeader() || incomingUnsubscribeRequestMessage.hasCallbackHeader())) {
            Logger logger3 = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Subscription ID and NT or Callback in unsubcribe request: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(getInputMessage());
            logger3.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
            return new StreamResponseMessage(UpnpResponse.Status.BAD_REQUEST);
        }
        LocalGENASubscription localSubscription = getUpnpService().getRegistry().getLocalSubscription(incomingUnsubscribeRequestMessage.getSubscriptionId());
        if (localSubscription == null) {
            Logger logger4 = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid subscription ID for unsubscribe request: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(getInputMessage());
            logger4.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString());
            return new StreamResponseMessage(UpnpResponse.Status.PRECONDITION_FAILED);
        }
        Logger logger5 = log;
        logger5.fine("Unregistering subscription: " + localSubscription);
        if (getUpnpService().getRegistry().removeLocalSubscription(localSubscription)) {
            localSubscription.end(null);
        } else {
            log.fine("Subscription was already removed from registry");
        }
        return new StreamResponseMessage(UpnpResponse.Status.OK);
    }
}
