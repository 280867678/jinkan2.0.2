package org.fourthline.cling.protocol.async;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.tvspark.outline;
import org.fourthline.cling.UpnpService;
import org.fourthline.cling.model.DiscoveryOptions;
import org.fourthline.cling.model.Location;
import org.fourthline.cling.model.NetworkAddress;
import org.fourthline.cling.model.message.IncomingDatagramMessage;
import org.fourthline.cling.model.message.UpnpRequest;
import org.fourthline.cling.model.message.discovery.IncomingSearchRequest;
import org.fourthline.cling.model.message.discovery.OutgoingSearchResponse;
import org.fourthline.cling.model.message.discovery.OutgoingSearchResponseDeviceType;
import org.fourthline.cling.model.message.discovery.OutgoingSearchResponseRootDevice;
import org.fourthline.cling.model.message.discovery.OutgoingSearchResponseServiceType;
import org.fourthline.cling.model.message.discovery.OutgoingSearchResponseUDN;
import org.fourthline.cling.model.message.header.DeviceTypeHeader;
import org.fourthline.cling.model.message.header.MXHeader;
import org.fourthline.cling.model.message.header.RootDeviceHeader;
import org.fourthline.cling.model.message.header.STAllHeader;
import org.fourthline.cling.model.message.header.ServiceTypeHeader;
import org.fourthline.cling.model.message.header.UDNHeader;
import org.fourthline.cling.model.message.header.UpnpHeader;
import org.fourthline.cling.model.meta.Device;
import org.fourthline.cling.model.meta.LocalDevice;
import org.fourthline.cling.model.types.DeviceType;
import org.fourthline.cling.model.types.ServiceType;
import org.fourthline.cling.model.types.UDN;
import org.fourthline.cling.protocol.ReceivingAsync;
import org.fourthline.cling.transport.RouterException;

/* loaded from: classes5.dex */
public class ReceivingSearch extends ReceivingAsync<IncomingSearchRequest> {
    public static final boolean LOG_ENABLED;
    public static final Logger log;
    public final Random randomGenerator = new Random();

    static {
        Logger logger = Logger.getLogger(ReceivingSearch.class.getName());
        log = logger;
        LOG_ENABLED = logger.isLoggable(Level.FINE);
    }

    public ReceivingSearch(UpnpService upnpService, IncomingDatagramMessage<UpnpRequest> incomingDatagramMessage) {
        super(upnpService, new IncomingSearchRequest(incomingDatagramMessage));
    }

    public List<OutgoingSearchResponse> createDeviceMessages(LocalDevice localDevice, NetworkAddress networkAddress) {
        ArrayList arrayList = new ArrayList();
        if (localDevice.isRoot()) {
            arrayList.add(new OutgoingSearchResponseRootDevice(getInputMessage(), getDescriptorLocation(networkAddress, localDevice), localDevice));
        }
        arrayList.add(new OutgoingSearchResponseUDN(getInputMessage(), getDescriptorLocation(networkAddress, localDevice), localDevice));
        arrayList.add(new OutgoingSearchResponseDeviceType(getInputMessage(), getDescriptorLocation(networkAddress, localDevice), localDevice));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            prepareOutgoingSearchResponse((OutgoingSearchResponse) it.next());
        }
        return arrayList;
    }

    public List<OutgoingSearchResponse> createServiceTypeMessages(LocalDevice localDevice, NetworkAddress networkAddress) {
        ArrayList arrayList = new ArrayList();
        for (ServiceType serviceType : localDevice.findServiceTypes()) {
            OutgoingSearchResponseServiceType outgoingSearchResponseServiceType = new OutgoingSearchResponseServiceType(getInputMessage(), getDescriptorLocation(networkAddress, localDevice), localDevice, serviceType);
            prepareOutgoingSearchResponse(outgoingSearchResponseServiceType);
            arrayList.add(outgoingSearchResponseServiceType);
        }
        return arrayList;
    }

    @Override // org.fourthline.cling.protocol.ReceivingAsync
    public void execute() throws RouterException {
        Logger logger;
        String str;
        StringBuilder sb;
        String str2;
        if (getUpnpService().mo5192getRouter() == null) {
            logger = log;
            str = "Router hasn't completed initialization, ignoring received search message";
        } else {
            if (!getInputMessage().isMANSSDPDiscover()) {
                logger = log;
                sb = new StringBuilder();
                str2 = "Invalid search request, no or invalid MAN ssdp:discover header: ";
            } else {
                UpnpHeader searchTarget = getInputMessage().getSearchTarget();
                if (searchTarget == null) {
                    logger = log;
                    sb = new StringBuilder();
                    str2 = "Invalid search request, did not contain ST header: ";
                } else {
                    List<NetworkAddress> activeStreamServers = getUpnpService().mo5192getRouter().getActiveStreamServers(getInputMessage().getLocalAddress());
                    if (activeStreamServers.size() != 0) {
                        for (NetworkAddress networkAddress : activeStreamServers) {
                            sendResponses(searchTarget, networkAddress);
                        }
                        return;
                    }
                    logger = log;
                    str = "Aborting search response, no active stream servers found (network disabled?)";
                }
            }
            sb.append(str2);
            sb.append(getInputMessage());
            str = sb.toString();
        }
        logger.fine(str);
    }

    public Location getDescriptorLocation(NetworkAddress networkAddress, LocalDevice localDevice) {
        return new Location(networkAddress, getUpnpService().getConfiguration().getNamespace().getDescriptorPathString(localDevice));
    }

    public boolean isAdvertisementDisabled(LocalDevice localDevice) {
        DiscoveryOptions discoveryOptions = getUpnpService().getRegistry().getDiscoveryOptions(localDevice.getIdentity().getUdn());
        return discoveryOptions != null && !discoveryOptions.isAdvertised();
    }

    public void prepareOutgoingSearchResponse(OutgoingSearchResponse outgoingSearchResponse) {
    }

    public void sendResponses(UpnpHeader upnpHeader, NetworkAddress networkAddress) throws RouterException {
        if (upnpHeader instanceof STAllHeader) {
            sendSearchResponseAll(networkAddress);
        } else if (upnpHeader instanceof RootDeviceHeader) {
            sendSearchResponseRootDevices(networkAddress);
        } else if (upnpHeader instanceof UDNHeader) {
            sendSearchResponseUDN((UDN) upnpHeader.getValue(), networkAddress);
        } else if (upnpHeader instanceof DeviceTypeHeader) {
            sendSearchResponseDeviceType((DeviceType) upnpHeader.getValue(), networkAddress);
        } else if (upnpHeader instanceof ServiceTypeHeader) {
            sendSearchResponseServiceType((ServiceType) upnpHeader.getValue(), networkAddress);
        } else {
            Logger logger = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Non-implemented search request target: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(upnpHeader.getClass());
            logger.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
    }

    public void sendSearchResponseAll(NetworkAddress networkAddress) throws RouterException {
        LocalDevice[] findEmbeddedDevices;
        if (LOG_ENABLED) {
            log.fine("Responding to 'all' search with advertisement messages for all local devices");
        }
        for (LocalDevice localDevice : getUpnpService().getRegistry().getLocalDevices()) {
            if (!isAdvertisementDisabled(localDevice)) {
                if (LOG_ENABLED) {
                    log.finer("Sending root device messages: " + localDevice);
                }
                for (OutgoingSearchResponse outgoingSearchResponse : createDeviceMessages(localDevice, networkAddress)) {
                    getUpnpService().mo5192getRouter().send(outgoingSearchResponse);
                }
                if (localDevice.hasEmbeddedDevices()) {
                    for (LocalDevice localDevice2 : localDevice.findEmbeddedDevices()) {
                        if (LOG_ENABLED) {
                            log.finer("Sending embedded device messages: " + localDevice2);
                        }
                        for (OutgoingSearchResponse outgoingSearchResponse2 : createDeviceMessages(localDevice2, networkAddress)) {
                            getUpnpService().mo5192getRouter().send(outgoingSearchResponse2);
                        }
                    }
                }
                List<OutgoingSearchResponse> createServiceTypeMessages = createServiceTypeMessages(localDevice, networkAddress);
                if (createServiceTypeMessages.size() > 0) {
                    if (LOG_ENABLED) {
                        log.finer("Sending service type messages");
                    }
                    for (OutgoingSearchResponse outgoingSearchResponse3 : createServiceTypeMessages) {
                        getUpnpService().mo5192getRouter().send(outgoingSearchResponse3);
                    }
                }
            }
        }
    }

    public void sendSearchResponseDeviceType(DeviceType deviceType, NetworkAddress networkAddress) throws RouterException {
        Logger logger = log;
        logger.fine("Responding to device type search: " + deviceType);
        for (Device device : getUpnpService().getRegistry().getDevices(deviceType)) {
            if (device instanceof LocalDevice) {
                LocalDevice localDevice = (LocalDevice) device;
                if (!isAdvertisementDisabled(localDevice)) {
                    Logger logger2 = log;
                    logger2.finer("Sending matching device type search result for: " + device);
                    OutgoingSearchResponseDeviceType outgoingSearchResponseDeviceType = new OutgoingSearchResponseDeviceType(getInputMessage(), getDescriptorLocation(networkAddress, localDevice), localDevice);
                    prepareOutgoingSearchResponse(outgoingSearchResponseDeviceType);
                    getUpnpService().mo5192getRouter().send(outgoingSearchResponseDeviceType);
                }
            }
        }
    }

    public void sendSearchResponseRootDevices(NetworkAddress networkAddress) throws RouterException {
        log.fine("Responding to root device search with advertisement messages for all local root devices");
        for (LocalDevice localDevice : getUpnpService().getRegistry().getLocalDevices()) {
            if (!isAdvertisementDisabled(localDevice)) {
                OutgoingSearchResponseRootDevice outgoingSearchResponseRootDevice = new OutgoingSearchResponseRootDevice(getInputMessage(), getDescriptorLocation(networkAddress, localDevice), localDevice);
                prepareOutgoingSearchResponse(outgoingSearchResponseRootDevice);
                getUpnpService().mo5192getRouter().send(outgoingSearchResponseRootDevice);
            }
        }
    }

    public void sendSearchResponseServiceType(ServiceType serviceType, NetworkAddress networkAddress) throws RouterException {
        Logger logger = log;
        logger.fine("Responding to service type search: " + serviceType);
        for (Device device : getUpnpService().getRegistry().getDevices(serviceType)) {
            if (device instanceof LocalDevice) {
                LocalDevice localDevice = (LocalDevice) device;
                if (!isAdvertisementDisabled(localDevice)) {
                    Logger logger2 = log;
                    logger2.finer("Sending matching service type search result: " + device);
                    OutgoingSearchResponseServiceType outgoingSearchResponseServiceType = new OutgoingSearchResponseServiceType(getInputMessage(), getDescriptorLocation(networkAddress, localDevice), localDevice, serviceType);
                    prepareOutgoingSearchResponse(outgoingSearchResponseServiceType);
                    getUpnpService().mo5192getRouter().send(outgoingSearchResponseServiceType);
                }
            }
        }
    }

    public void sendSearchResponseUDN(UDN udn, NetworkAddress networkAddress) throws RouterException {
        Device device = getUpnpService().getRegistry().getDevice(udn, false);
        if (device == null || !(device instanceof LocalDevice)) {
            return;
        }
        LocalDevice localDevice = (LocalDevice) device;
        if (isAdvertisementDisabled(localDevice)) {
            return;
        }
        Logger logger = log;
        logger.fine("Responding to UDN device search: " + udn);
        OutgoingSearchResponseUDN outgoingSearchResponseUDN = new OutgoingSearchResponseUDN(getInputMessage(), getDescriptorLocation(networkAddress, localDevice), localDevice);
        prepareOutgoingSearchResponse(outgoingSearchResponseUDN);
        getUpnpService().mo5192getRouter().send(outgoingSearchResponseUDN);
    }

    @Override // org.fourthline.cling.protocol.ReceivingAsync
    public boolean waitBeforeExecution() throws InterruptedException {
        Integer mx = getInputMessage().getMX();
        if (mx == null) {
            Logger logger = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid search request, did not contain MX header: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getInputMessage());
            logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            return false;
        }
        if (mx.intValue() > 120 || mx.intValue() <= 0) {
            mx = MXHeader.DEFAULT_VALUE;
        }
        if (getUpnpService().getRegistry().getLocalDevices().size() <= 0) {
            return true;
        }
        int nextInt = this.randomGenerator.nextInt(mx.intValue() * 1000);
        Logger logger2 = log;
        logger2.fine("Sleeping " + nextInt + " milliseconds to avoid flooding with search responses");
        Thread.sleep((long) nextInt);
        return true;
    }
}
