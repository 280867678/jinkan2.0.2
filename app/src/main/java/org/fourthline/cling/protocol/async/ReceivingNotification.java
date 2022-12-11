package org.fourthline.cling.protocol.async;

import java.util.logging.Logger;
import me.tvspark.outline;
import org.fourthline.cling.UpnpService;
import org.fourthline.cling.model.ValidationError;
import org.fourthline.cling.model.ValidationException;
import org.fourthline.cling.model.message.IncomingDatagramMessage;
import org.fourthline.cling.model.message.UpnpRequest;
import org.fourthline.cling.model.message.discovery.IncomingNotificationRequest;
import org.fourthline.cling.model.meta.RemoteDevice;
import org.fourthline.cling.model.meta.RemoteDeviceIdentity;
import org.fourthline.cling.model.types.UDN;
import org.fourthline.cling.protocol.ReceivingAsync;
import org.fourthline.cling.protocol.RetrieveRemoteDescriptors;
import org.fourthline.cling.transport.RouterException;

/* loaded from: classes5.dex */
public class ReceivingNotification extends ReceivingAsync<IncomingNotificationRequest> {
    public static final Logger log = Logger.getLogger(ReceivingNotification.class.getName());

    public ReceivingNotification(UpnpService upnpService, IncomingDatagramMessage<UpnpRequest> incomingDatagramMessage) {
        super(upnpService, new IncomingNotificationRequest(incomingDatagramMessage));
    }

    @Override // org.fourthline.cling.protocol.ReceivingAsync
    public void execute() throws RouterException {
        UDN udn = getInputMessage().getUDN();
        if (udn == null) {
            Logger logger = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Ignoring notification message without UDN: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getInputMessage());
            logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            return;
        }
        RemoteDeviceIdentity remoteDeviceIdentity = new RemoteDeviceIdentity(getInputMessage());
        Logger logger2 = log;
        logger2.fine("Received device notification: " + remoteDeviceIdentity);
        try {
            RemoteDevice remoteDevice = new RemoteDevice(remoteDeviceIdentity);
            if (!getInputMessage().isAliveMessage()) {
                if (!getInputMessage().isByeByeMessage()) {
                    Logger logger3 = log;
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Ignoring unknown notification message: ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(getInputMessage());
                    logger3.finer(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                    return;
                }
                log.fine("Received device BYEBYE advertisement");
                if (!getUpnpService().getRegistry().removeDevice(remoteDevice)) {
                    return;
                }
                Logger logger4 = log;
                logger4.fine("Removed remote device from registry: " + remoteDevice);
                return;
            }
            Logger logger5 = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Received device ALIVE advertisement, descriptor location is: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(remoteDeviceIdentity.getDescriptorURL());
            logger5.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
            if (remoteDeviceIdentity.getDescriptorURL() == null) {
                Logger logger6 = log;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Ignoring message without location URL header: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(getInputMessage());
                logger6.finer(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString());
            } else if (remoteDeviceIdentity.getMaxAgeSeconds() == null) {
                Logger logger7 = log;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Ignoring message without max-age header: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.append(getInputMessage());
                logger7.finer(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.toString());
            } else if (!getUpnpService().getRegistry().update(remoteDeviceIdentity)) {
                getUpnpService().getConfiguration().getAsyncProtocolExecutor().execute(new RetrieveRemoteDescriptors(getUpnpService(), remoteDevice));
            } else {
                Logger logger8 = log;
                logger8.finer("Remote device was already known: " + udn);
            }
        } catch (ValidationException e) {
            Logger logger9 = log;
            logger9.warning("Validation errors of device during discovery: " + remoteDeviceIdentity);
            for (ValidationError validationError : e.getErrors()) {
                log.warning(validationError.toString());
            }
        }
    }
}
