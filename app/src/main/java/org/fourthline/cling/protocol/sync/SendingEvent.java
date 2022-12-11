package org.fourthline.cling.protocol.sync;

import java.net.URL;
import java.util.logging.Logger;
import me.tvspark.outline;
import org.fourthline.cling.UpnpService;
import org.fourthline.cling.model.gena.LocalGENASubscription;
import org.fourthline.cling.model.message.StreamResponseMessage;
import org.fourthline.cling.model.message.gena.OutgoingEventRequestMessage;
import org.fourthline.cling.model.types.UnsignedIntegerFourBytes;
import org.fourthline.cling.protocol.SendingSync;
import org.fourthline.cling.transport.RouterException;

/* loaded from: classes5.dex */
public class SendingEvent extends SendingSync<OutgoingEventRequestMessage, StreamResponseMessage> {
    public static final Logger log = Logger.getLogger(SendingEvent.class.getName());
    public final UnsignedIntegerFourBytes currentSequence;
    public final OutgoingEventRequestMessage[] requestMessages;
    public final String subscriptionId;

    public SendingEvent(UpnpService upnpService, LocalGENASubscription localGENASubscription) {
        super(upnpService, null);
        this.subscriptionId = localGENASubscription.getSubscriptionId();
        this.requestMessages = new OutgoingEventRequestMessage[localGENASubscription.getCallbackURLs().size()];
        int i = 0;
        for (URL url : localGENASubscription.getCallbackURLs()) {
            this.requestMessages[i] = new OutgoingEventRequestMessage(localGENASubscription, url);
            getUpnpService().getConfiguration().getGenaEventProcessor().writeBody(this.requestMessages[i]);
            i++;
        }
        this.currentSequence = localGENASubscription.getCurrentSequence();
        localGENASubscription.incrementSequence();
    }

    @Override // org.fourthline.cling.protocol.SendingSync
    public StreamResponseMessage executeSync() throws RouterException {
        OutgoingEventRequestMessage[] outgoingEventRequestMessageArr;
        String str;
        Logger logger = log;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Sending event for subscription: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.subscriptionId);
        logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        StreamResponseMessage streamResponseMessage = null;
        for (OutgoingEventRequestMessage outgoingEventRequestMessage : this.requestMessages) {
            int i = (this.currentSequence.getValue().longValue() > 0L ? 1 : (this.currentSequence.getValue().longValue() == 0L ? 0 : -1));
            Logger logger2 = log;
            StringBuilder sb = new StringBuilder();
            if (i == 0) {
                str = "Sending initial event message to callback URL: ";
            } else {
                sb.append("Sending event message '");
                sb.append(this.currentSequence);
                str = "' to callback URL: ";
            }
            sb.append(str);
            sb.append(outgoingEventRequestMessage.getUri());
            logger2.fine(sb.toString());
            streamResponseMessage = getUpnpService().mo5192getRouter().send(outgoingEventRequestMessage);
            log.fine("Received event callback response: " + streamResponseMessage);
        }
        return streamResponseMessage;
    }
}
