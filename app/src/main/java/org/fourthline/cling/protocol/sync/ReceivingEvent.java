package org.fourthline.cling.protocol.sync;

import java.util.logging.Logger;
import me.tvspark.outline;
import org.fourthline.cling.UpnpService;
import org.fourthline.cling.model.UnsupportedDataException;
import org.fourthline.cling.model.gena.RemoteGENASubscription;
import org.fourthline.cling.model.message.StreamRequestMessage;
import org.fourthline.cling.model.message.UpnpResponse;
import org.fourthline.cling.model.message.gena.IncomingEventRequestMessage;
import org.fourthline.cling.model.message.gena.OutgoingEventResponseMessage;
import org.fourthline.cling.model.resource.ServiceEventCallbackResource;
import org.fourthline.cling.protocol.ReceivingSync;
import org.fourthline.cling.transport.RouterException;

/* loaded from: classes5.dex */
public class ReceivingEvent extends ReceivingSync<StreamRequestMessage, OutgoingEventResponseMessage> {
    public static final Logger log = Logger.getLogger(ReceivingEvent.class.getName());

    public ReceivingEvent(UpnpService upnpService, StreamRequestMessage streamRequestMessage) {
        super(upnpService, streamRequestMessage);
    }

    @Override // org.fourthline.cling.protocol.ReceivingSync
    public OutgoingEventResponseMessage executeSync() throws RouterException {
        if (!((StreamRequestMessage) getInputMessage()).isContentTypeTextUDA()) {
            Logger logger = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Received without or with invalid Content-Type: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getInputMessage());
            logger.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        ServiceEventCallbackResource serviceEventCallbackResource = (ServiceEventCallbackResource) getUpnpService().getRegistry().getResource(ServiceEventCallbackResource.class, ((StreamRequestMessage) getInputMessage()).getUri());
        if (serviceEventCallbackResource == null) {
            Logger logger2 = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("No local resource found: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(getInputMessage());
            logger2.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
            return new OutgoingEventResponseMessage(new UpnpResponse(UpnpResponse.Status.NOT_FOUND));
        }
        final IncomingEventRequestMessage incomingEventRequestMessage = new IncomingEventRequestMessage((StreamRequestMessage) getInputMessage(), serviceEventCallbackResource.getModel());
        if (incomingEventRequestMessage.getSubscrptionId() == null) {
            Logger logger3 = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Subscription ID missing in event request: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(getInputMessage());
            logger3.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
            return new OutgoingEventResponseMessage(new UpnpResponse(UpnpResponse.Status.PRECONDITION_FAILED));
        } else if (!incomingEventRequestMessage.hasValidNotificationHeaders()) {
            Logger logger4 = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Missing NT and/or NTS headers in event request: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(getInputMessage());
            logger4.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString());
            return new OutgoingEventResponseMessage(new UpnpResponse(UpnpResponse.Status.BAD_REQUEST));
        } else if (!incomingEventRequestMessage.hasValidNotificationHeaders()) {
            Logger logger5 = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid NT and/or NTS headers in event request: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.append(getInputMessage());
            logger5.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.toString());
            return new OutgoingEventResponseMessage(new UpnpResponse(UpnpResponse.Status.PRECONDITION_FAILED));
        } else if (incomingEventRequestMessage.getSequence() == null) {
            Logger logger6 = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Sequence missing in event request: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.append(getInputMessage());
            logger6.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.toString());
            return new OutgoingEventResponseMessage(new UpnpResponse(UpnpResponse.Status.PRECONDITION_FAILED));
        } else {
            try {
                getUpnpService().getConfiguration().getGenaEventProcessor().readBody(incomingEventRequestMessage);
                final RemoteGENASubscription waitRemoteSubscription = getUpnpService().getRegistry().getWaitRemoteSubscription(incomingEventRequestMessage.getSubscrptionId());
                if (waitRemoteSubscription != null) {
                    getUpnpService().getConfiguration().getRegistryListenerExecutor().execute(new Runnable() { // from class: org.fourthline.cling.protocol.sync.ReceivingEvent.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ReceivingEvent.log.fine("Calling active subscription with event state variable values");
                            waitRemoteSubscription.receive(incomingEventRequestMessage.getSequence(), incomingEventRequestMessage.getStateVariableValues());
                        }
                    });
                    return new OutgoingEventResponseMessage();
                }
                Logger logger7 = log;
                logger7.severe("Invalid subscription ID, no active subscription: " + incomingEventRequestMessage);
                return new OutgoingEventResponseMessage(new UpnpResponse(UpnpResponse.Status.PRECONDITION_FAILED));
            } catch (UnsupportedDataException e) {
                Logger logger8 = log;
                logger8.fine("Can't read event message request body, " + e);
                final RemoteGENASubscription remoteSubscription = getUpnpService().getRegistry().getRemoteSubscription(incomingEventRequestMessage.getSubscrptionId());
                if (remoteSubscription != null) {
                    getUpnpService().getConfiguration().getRegistryListenerExecutor().execute(new Runnable() { // from class: org.fourthline.cling.protocol.sync.ReceivingEvent.1
                        @Override // java.lang.Runnable
                        public void run() {
                            remoteSubscription.invalidMessage(e);
                        }
                    });
                }
                return new OutgoingEventResponseMessage(new UpnpResponse(UpnpResponse.Status.INTERNAL_SERVER_ERROR));
            }
        }
    }
}
