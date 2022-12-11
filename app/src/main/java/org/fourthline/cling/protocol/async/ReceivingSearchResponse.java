package org.fourthline.cling.protocol.async;

import java.util.logging.Logger;
import me.tvspark.outline;
import org.fourthline.cling.UpnpService;
import org.fourthline.cling.model.ValidationError;
import org.fourthline.cling.model.ValidationException;
import org.fourthline.cling.model.message.IncomingDatagramMessage;
import org.fourthline.cling.model.message.UpnpResponse;
import org.fourthline.cling.model.message.discovery.IncomingSearchResponse;
import org.fourthline.cling.model.meta.RemoteDevice;
import org.fourthline.cling.model.meta.RemoteDeviceIdentity;
import org.fourthline.cling.model.types.UDN;
import org.fourthline.cling.protocol.ReceivingAsync;
import org.fourthline.cling.protocol.RetrieveRemoteDescriptors;
import org.fourthline.cling.transport.RouterException;

/* loaded from: classes5.dex */
public class ReceivingSearchResponse extends ReceivingAsync<IncomingSearchResponse> {
    public static final Logger log = Logger.getLogger(ReceivingSearchResponse.class.getName());

    public ReceivingSearchResponse(UpnpService upnpService, IncomingDatagramMessage<UpnpResponse> incomingDatagramMessage) {
        super(upnpService, new IncomingSearchResponse(incomingDatagramMessage));
    }

    @Override // org.fourthline.cling.protocol.ReceivingAsync
    public void execute() throws RouterException {
        if (!getInputMessage().isSearchResponseMessage()) {
            Logger logger = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Ignoring invalid search response message: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getInputMessage());
            logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            return;
        }
        UDN rootDeviceUDN = getInputMessage().getRootDeviceUDN();
        if (rootDeviceUDN == null) {
            Logger logger2 = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Ignoring search response message without UDN: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(getInputMessage());
            logger2.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
            return;
        }
        RemoteDeviceIdentity remoteDeviceIdentity = new RemoteDeviceIdentity(getInputMessage());
        Logger logger3 = log;
        logger3.fine("Received device search response: " + remoteDeviceIdentity);
        if (getUpnpService().getRegistry().update(remoteDeviceIdentity)) {
            Logger logger4 = log;
            logger4.fine("Remote device was already known: " + rootDeviceUDN);
            return;
        }
        try {
            RemoteDevice remoteDevice = new RemoteDevice(remoteDeviceIdentity);
            if (remoteDeviceIdentity.getDescriptorURL() == null) {
                Logger logger5 = log;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Ignoring message without location URL header: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(getInputMessage());
                logger5.finer(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
            } else if (remoteDeviceIdentity.getMaxAgeSeconds() != null) {
                getUpnpService().getConfiguration().getAsyncProtocolExecutor().execute(new RetrieveRemoteDescriptors(getUpnpService(), remoteDevice));
            } else {
                Logger logger6 = log;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Ignoring message without max-age header: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(getInputMessage());
                logger6.finer(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString());
            }
        } catch (ValidationException e) {
            Logger logger7 = log;
            logger7.warning("Validation errors of device during discovery: " + remoteDeviceIdentity);
            for (ValidationError validationError : e.getErrors()) {
                log.warning(validationError.toString());
            }
        }
    }
}
