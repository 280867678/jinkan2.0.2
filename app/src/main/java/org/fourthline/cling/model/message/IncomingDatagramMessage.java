package org.fourthline.cling.model.message;

import java.net.InetAddress;
import org.fourthline.cling.model.message.UpnpOperation;

/* loaded from: classes5.dex */
public class IncomingDatagramMessage<O extends UpnpOperation> extends UpnpMessage<O> {
    public InetAddress localAddress;
    public InetAddress sourceAddress;
    public int sourcePort;

    public IncomingDatagramMessage(IncomingDatagramMessage<O> incomingDatagramMessage) {
        super(incomingDatagramMessage);
        this.sourceAddress = incomingDatagramMessage.getSourceAddress();
        this.sourcePort = incomingDatagramMessage.getSourcePort();
        this.localAddress = incomingDatagramMessage.getLocalAddress();
    }

    public IncomingDatagramMessage(O o, InetAddress inetAddress, int i, InetAddress inetAddress2) {
        super(o);
        this.sourceAddress = inetAddress;
        this.sourcePort = i;
        this.localAddress = inetAddress2;
    }

    public InetAddress getLocalAddress() {
        return this.localAddress;
    }

    public InetAddress getSourceAddress() {
        return this.sourceAddress;
    }

    public int getSourcePort() {
        return this.sourcePort;
    }
}
