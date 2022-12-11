package org.fourthline.cling.transport.spi;

import java.util.logging.Logger;
import me.tvspark.outline;
import org.fourthline.cling.model.message.StreamRequestMessage;
import org.fourthline.cling.model.message.StreamResponseMessage;
import org.fourthline.cling.model.message.UpnpResponse;
import org.fourthline.cling.protocol.ProtocolCreationException;
import org.fourthline.cling.protocol.ProtocolFactory;
import org.fourthline.cling.protocol.ReceivingSync;
import org.seamless.util.Exceptions;

/* loaded from: classes5.dex */
public abstract class UpnpStream implements Runnable {
    public static Logger log = Logger.getLogger(UpnpStream.class.getName());
    public final ProtocolFactory protocolFactory;
    public ReceivingSync syncProtocol;

    public UpnpStream(ProtocolFactory protocolFactory) {
        this.protocolFactory = protocolFactory;
    }

    public ProtocolFactory getProtocolFactory() {
        return this.protocolFactory;
    }

    public StreamResponseMessage process(StreamRequestMessage streamRequestMessage) {
        Logger logger = log;
        logger.fine("Processing stream request message: " + streamRequestMessage);
        try {
            this.syncProtocol = getProtocolFactory().createReceivingSync(streamRequestMessage);
            Logger logger2 = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Running protocol for synchronous message processing: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.syncProtocol);
            logger2.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            this.syncProtocol.run();
            StreamResponseMessage outputMessage = this.syncProtocol.getOutputMessage();
            if (outputMessage == null) {
                log.finer("Protocol did not return any response message");
                return null;
            }
            Logger logger3 = log;
            logger3.finer("Protocol returned response: " + outputMessage);
            return outputMessage;
        } catch (ProtocolCreationException e) {
            Logger logger4 = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Processing stream request failed - ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(Exceptions.unwrap(e).toString());
            logger4.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
            return new StreamResponseMessage(UpnpResponse.Status.NOT_IMPLEMENTED);
        }
    }

    public void responseException(Throwable th) {
        ReceivingSync receivingSync = this.syncProtocol;
        if (receivingSync != null) {
            receivingSync.responseException(th);
        }
    }

    public void responseSent(StreamResponseMessage streamResponseMessage) {
        ReceivingSync receivingSync = this.syncProtocol;
        if (receivingSync != null) {
            receivingSync.responseSent(streamResponseMessage);
        }
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getClass().getSimpleName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
