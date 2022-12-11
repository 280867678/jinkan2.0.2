package org.fourthline.cling.protocol.async;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import me.tvspark.outline;
import org.fourthline.cling.UpnpService;
import org.fourthline.cling.model.Location;
import org.fourthline.cling.model.NetworkAddress;
import org.fourthline.cling.model.message.discovery.OutgoingNotificationRequest;
import org.fourthline.cling.model.message.discovery.OutgoingNotificationRequestDeviceType;
import org.fourthline.cling.model.message.discovery.OutgoingNotificationRequestRootDevice;
import org.fourthline.cling.model.message.discovery.OutgoingNotificationRequestServiceType;
import org.fourthline.cling.model.message.discovery.OutgoingNotificationRequestUDN;
import org.fourthline.cling.model.meta.LocalDevice;
import org.fourthline.cling.model.types.NotificationSubtype;
import org.fourthline.cling.model.types.ServiceType;
import org.fourthline.cling.protocol.SendingAsync;
import org.fourthline.cling.transport.RouterException;

/* loaded from: classes5.dex */
public abstract class SendingNotification extends SendingAsync {
    public static final Logger log = Logger.getLogger(SendingNotification.class.getName());
    public LocalDevice device;

    public SendingNotification(UpnpService upnpService, LocalDevice localDevice) {
        super(upnpService);
        this.device = localDevice;
    }

    public List<OutgoingNotificationRequest> createDeviceMessages(LocalDevice localDevice, Location location) {
        ArrayList arrayList = new ArrayList();
        if (localDevice.isRoot()) {
            arrayList.add(new OutgoingNotificationRequestRootDevice(location, localDevice, getNotificationSubtype()));
        }
        arrayList.add(new OutgoingNotificationRequestUDN(location, localDevice, getNotificationSubtype()));
        arrayList.add(new OutgoingNotificationRequestDeviceType(location, localDevice, getNotificationSubtype()));
        return arrayList;
    }

    public List<OutgoingNotificationRequest> createServiceTypeMessages(LocalDevice localDevice, Location location) {
        ArrayList arrayList = new ArrayList();
        for (ServiceType serviceType : localDevice.findServiceTypes()) {
            arrayList.add(new OutgoingNotificationRequestServiceType(location, localDevice, getNotificationSubtype(), serviceType));
        }
        return arrayList;
    }

    @Override // org.fourthline.cling.protocol.SendingAsync
    public void execute() throws RouterException {
        List<NetworkAddress> activeStreamServers = getUpnpService().mo5192getRouter().getActiveStreamServers(null);
        if (activeStreamServers.size() == 0) {
            log.fine("Aborting notifications, no active stream servers found (network disabled?)");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (NetworkAddress networkAddress : activeStreamServers) {
            arrayList.add(new Location(networkAddress, getUpnpService().getConfiguration().getNamespace().getDescriptorPathString(getDevice())));
        }
        for (int i = 0; i < getBulkRepeat(); i++) {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    sendMessages((Location) it.next());
                }
                Logger logger = log;
                logger.finer("Sleeping " + getBulkIntervalMilliseconds() + " milliseconds");
                Thread.sleep((long) getBulkIntervalMilliseconds());
            } catch (InterruptedException e) {
                Logger logger2 = log;
                logger2.warning("Advertisement thread was interrupted: " + e);
            }
        }
    }

    public int getBulkIntervalMilliseconds() {
        return 150;
    }

    public int getBulkRepeat() {
        return 3;
    }

    public LocalDevice getDevice() {
        return this.device;
    }

    public abstract NotificationSubtype getNotificationSubtype();

    public void sendMessages(Location location) throws RouterException {
        LocalDevice[] findEmbeddedDevices;
        Logger logger = log;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Sending root device messages: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getDevice());
        logger.finer(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        for (OutgoingNotificationRequest outgoingNotificationRequest : createDeviceMessages(getDevice(), location)) {
            getUpnpService().mo5192getRouter().send(outgoingNotificationRequest);
        }
        if (getDevice().hasEmbeddedDevices()) {
            for (LocalDevice localDevice : getDevice().findEmbeddedDevices()) {
                log.finer("Sending embedded device messages: " + localDevice);
                for (OutgoingNotificationRequest outgoingNotificationRequest2 : createDeviceMessages(localDevice, location)) {
                    getUpnpService().mo5192getRouter().send(outgoingNotificationRequest2);
                }
            }
        }
        List<OutgoingNotificationRequest> createServiceTypeMessages = createServiceTypeMessages(getDevice(), location);
        if (createServiceTypeMessages.size() > 0) {
            log.finer("Sending service type messages");
            for (OutgoingNotificationRequest outgoingNotificationRequest3 : createServiceTypeMessages) {
                getUpnpService().mo5192getRouter().send(outgoingNotificationRequest3);
            }
        }
    }
}
