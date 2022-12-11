package org.fourthline.cling.protocol.async;

import java.util.logging.Logger;
import me.tvspark.outline;
import org.fourthline.cling.UpnpService;
import org.fourthline.cling.model.message.discovery.OutgoingSearchRequest;
import org.fourthline.cling.model.message.header.MXHeader;
import org.fourthline.cling.model.message.header.STAllHeader;
import org.fourthline.cling.model.message.header.UpnpHeader;
import org.fourthline.cling.protocol.SendingAsync;
import org.fourthline.cling.transport.RouterException;

/* loaded from: classes5.dex */
public class SendingSearch extends SendingAsync {
    public static final Logger log = Logger.getLogger(SendingSearch.class.getName());
    public final int mxSeconds;
    public final UpnpHeader searchTarget;

    public SendingSearch(UpnpService upnpService) {
        this(upnpService, new STAllHeader());
    }

    public SendingSearch(UpnpService upnpService, UpnpHeader upnpHeader) {
        this(upnpService, upnpHeader, MXHeader.DEFAULT_VALUE.intValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SendingSearch(UpnpService upnpService, UpnpHeader upnpHeader, int i) {
        super(upnpService);
        if (UpnpHeader.Type.ST.isValidHeaderType(upnpHeader.getClass())) {
            this.searchTarget = upnpHeader;
            this.mxSeconds = i;
            return;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Given search target instance is not a valid header class for type ST: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(upnpHeader.getClass());
        throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    @Override // org.fourthline.cling.protocol.SendingAsync
    public void execute() throws RouterException {
        Logger logger = log;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Executing search for target: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.searchTarget.getString());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" with MX seconds: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getMxSeconds());
        logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        OutgoingSearchRequest outgoingSearchRequest = new OutgoingSearchRequest(this.searchTarget, getMxSeconds());
        prepareOutgoingSearchRequest(outgoingSearchRequest);
        for (int i = 0; i < getBulkRepeat(); i++) {
            try {
                getUpnpService().mo5192getRouter().send(outgoingSearchRequest);
                Logger logger2 = log;
                logger2.finer("Sleeping " + getBulkIntervalMilliseconds() + " milliseconds");
                Thread.sleep((long) getBulkIntervalMilliseconds());
            } catch (InterruptedException unused) {
                return;
            }
        }
    }

    public int getBulkIntervalMilliseconds() {
        return 500;
    }

    public int getBulkRepeat() {
        return 5;
    }

    public int getMxSeconds() {
        return this.mxSeconds;
    }

    public UpnpHeader getSearchTarget() {
        return this.searchTarget;
    }

    public void prepareOutgoingSearchRequest(OutgoingSearchRequest outgoingSearchRequest) {
    }
}
