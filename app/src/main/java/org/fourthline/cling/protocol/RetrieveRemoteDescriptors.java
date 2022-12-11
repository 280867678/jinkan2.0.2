package org.fourthline.cling.protocol;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.tvspark.outline;
import org.fourthline.cling.UpnpService;
import org.fourthline.cling.binding.xml.DescriptorBindingException;
import org.fourthline.cling.binding.xml.DeviceDescriptorBinder;
import org.fourthline.cling.binding.xml.ServiceDescriptorBinder;
import org.fourthline.cling.model.ValidationError;
import org.fourthline.cling.model.ValidationException;
import org.fourthline.cling.model.message.StreamRequestMessage;
import org.fourthline.cling.model.message.StreamResponseMessage;
import org.fourthline.cling.model.message.UpnpHeaders;
import org.fourthline.cling.model.message.UpnpRequest;
import org.fourthline.cling.model.meta.Icon;
import org.fourthline.cling.model.meta.RemoteDevice;
import org.fourthline.cling.model.meta.RemoteDeviceIdentity;
import org.fourthline.cling.model.meta.RemoteService;
import org.fourthline.cling.model.types.ServiceType;
import org.fourthline.cling.model.types.UDN;
import org.fourthline.cling.registry.RegistrationException;
import org.fourthline.cling.transport.RouterException;
import org.seamless.util.Exceptions;

/* loaded from: classes5.dex */
public class RetrieveRemoteDescriptors implements Runnable {
    public List<UDN> errorsAlreadyLogged = new ArrayList();

    /* renamed from: rd */
    public RemoteDevice f4629rd;
    public final UpnpService upnpService;
    public static final Logger log = Logger.getLogger(RetrieveRemoteDescriptors.class.getName());
    public static final Set<URL> activeRetrievals = new CopyOnWriteArraySet();

    public RetrieveRemoteDescriptors(UpnpService upnpService, RemoteDevice remoteDevice) {
        this.upnpService = upnpService;
        this.f4629rd = remoteDevice;
    }

    public void describe() throws RouterException {
        if (getUpnpService().mo5192getRouter() == null) {
            log.warning("Router not yet initialized");
            return;
        }
        try {
            StreamRequestMessage streamRequestMessage = new StreamRequestMessage(UpnpRequest.Method.GET, this.f4629rd.getIdentity().getDescriptorURL());
            UpnpHeaders descriptorRetrievalHeaders = getUpnpService().getConfiguration().getDescriptorRetrievalHeaders(this.f4629rd.getIdentity());
            if (descriptorRetrievalHeaders != null) {
                streamRequestMessage.getHeaders().putAll(descriptorRetrievalHeaders);
            }
            Logger logger = log;
            logger.fine("Sending device descriptor retrieval message: " + streamRequestMessage);
            StreamResponseMessage send = getUpnpService().mo5192getRouter().send(streamRequestMessage);
            if (send == null) {
                Logger logger2 = log;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Device descriptor retrieval failed, no response: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f4629rd.getIdentity().getDescriptorURL());
                logger2.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            } else if (send.getOperation().isFailed()) {
                Logger logger3 = log;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Device descriptor retrieval failed: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.f4629rd.getIdentity().getDescriptorURL());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(", ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(send.getOperation().getResponseDetails());
                logger3.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
            } else {
                if (!send.isContentTypeTextUDA()) {
                    Logger logger4 = log;
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Received device descriptor without or with invalid Content-Type: ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(this.f4629rd.getIdentity().getDescriptorURL());
                    logger4.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
                }
                String bodyString = send.getBodyString();
                if (bodyString == null || bodyString.length() == 0) {
                    Logger logger5 = log;
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Received empty device descriptor:");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(this.f4629rd.getIdentity().getDescriptorURL());
                    logger5.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString());
                    return;
                }
                Logger logger6 = log;
                logger6.fine("Received root device descriptor: " + send);
                describe(bodyString);
            }
        } catch (IllegalArgumentException e) {
            Logger logger7 = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Device descriptor retrieval failed: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.append(this.f4629rd.getIdentity().getDescriptorURL());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.append(", possibly invalid URL: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.append(e);
            logger7.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.toString());
        }
    }

    public void describe(String str) throws RouterException {
        RegistrationException e;
        RemoteDevice remoteDevice;
        ValidationException e2;
        DescriptorBindingException e3;
        DescriptorBindingException descriptorBindingException;
        RemoteDevice remoteDevice2 = null;
        try {
            remoteDevice = (RemoteDevice) getUpnpService().getConfiguration().getDeviceDescriptorBinderUDA10().describe((DeviceDescriptorBinder) this.f4629rd, str);
            try {
                log.fine("Remote device described (without services) notifying listeners: " + remoteDevice);
                boolean notifyDiscoveryStart = getUpnpService().getRegistry().notifyDiscoveryStart(remoteDevice);
                log.fine("Hydrating described device's services: " + remoteDevice);
                RemoteDevice describeServices = describeServices(remoteDevice);
                if (describeServices != null) {
                    log.fine("Adding fully hydrated remote device to registry: " + describeServices);
                    getUpnpService().getRegistry().addDevice(describeServices);
                    return;
                }
                if (!this.errorsAlreadyLogged.contains(this.f4629rd.getIdentity().getUdn())) {
                    this.errorsAlreadyLogged.add(this.f4629rd.getIdentity().getUdn());
                    log.warning("Device service description failed: " + this.f4629rd);
                }
                if (!notifyDiscoveryStart) {
                    return;
                }
                getUpnpService().getRegistry().notifyDiscoveryFailure(remoteDevice, new DescriptorBindingException("Device service description failed: " + this.f4629rd));
            } catch (DescriptorBindingException e4) {
                e3 = e4;
                Logger logger = log;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Could not hydrate device or its services from descriptor: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f4629rd);
                logger.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                Logger logger2 = log;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Cause was: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(Exceptions.unwrap(e3));
                logger2.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                descriptorBindingException = e3;
                if (remoteDevice == null || 0 == 0) {
                    return;
                }
                getUpnpService().getRegistry().notifyDiscoveryFailure(remoteDevice, descriptorBindingException);
            } catch (ValidationException e5) {
                e2 = e5;
                remoteDevice2 = remoteDevice;
                if (this.errorsAlreadyLogged.contains(this.f4629rd.getIdentity().getUdn())) {
                    return;
                }
                this.errorsAlreadyLogged.add(this.f4629rd.getIdentity().getUdn());
                Logger logger3 = log;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Could not validate device model: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(this.f4629rd);
                logger3.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
                for (ValidationError validationError : e2.getErrors()) {
                    log.warning(validationError.toString());
                }
                if (remoteDevice2 == null || 0 == 0) {
                    return;
                }
                getUpnpService().getRegistry().notifyDiscoveryFailure(remoteDevice2, e2);
            } catch (RegistrationException e6) {
                e = e6;
                Logger logger4 = log;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Adding hydrated device to registry failed: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(this.f4629rd);
                logger4.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString());
                Logger logger5 = log;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Cause was: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.append(e.toString());
                logger5.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.toString());
                descriptorBindingException = e;
                if (remoteDevice == null || 0 == 0) {
                    return;
                }
                getUpnpService().getRegistry().notifyDiscoveryFailure(remoteDevice, descriptorBindingException);
            }
        } catch (DescriptorBindingException e7) {
            e3 = e7;
            remoteDevice = null;
        } catch (ValidationException e8) {
            e2 = e8;
        } catch (RegistrationException e9) {
            e = e9;
            remoteDevice = null;
        }
    }

    public RemoteService describeService(RemoteService remoteService) throws RouterException, DescriptorBindingException, ValidationException {
        try {
            URL normalizeURI = remoteService.getDevice().normalizeURI(remoteService.getDescriptorURI());
            StreamRequestMessage streamRequestMessage = new StreamRequestMessage(UpnpRequest.Method.GET, normalizeURI);
            UpnpHeaders descriptorRetrievalHeaders = getUpnpService().getConfiguration().getDescriptorRetrievalHeaders(remoteService.getDevice().getIdentity());
            if (descriptorRetrievalHeaders != null) {
                streamRequestMessage.getHeaders().putAll(descriptorRetrievalHeaders);
            }
            Logger logger = log;
            logger.fine("Sending service descriptor retrieval message: " + streamRequestMessage);
            StreamResponseMessage send = getUpnpService().mo5192getRouter().send(streamRequestMessage);
            if (send == null) {
                Logger logger2 = log;
                logger2.warning("Could not retrieve service descriptor, no response: " + remoteService);
                return null;
            } else if (send.getOperation().isFailed()) {
                Logger logger3 = log;
                logger3.warning("Service descriptor retrieval failed: " + normalizeURI + ", " + send.getOperation().getResponseDetails());
                return null;
            } else {
                if (!send.isContentTypeTextUDA()) {
                    Logger logger4 = log;
                    logger4.fine("Received service descriptor without or with invalid Content-Type: " + normalizeURI);
                }
                String bodyString = send.getBodyString();
                if (bodyString == null || bodyString.length() == 0) {
                    Logger logger5 = log;
                    logger5.warning("Received empty service descriptor:" + normalizeURI);
                    return null;
                }
                Logger logger6 = log;
                logger6.fine("Received service descriptor, hydrating service model: " + send);
                return (RemoteService) getUpnpService().getConfiguration().getServiceDescriptorBinderUDA10().describe((ServiceDescriptorBinder) remoteService, bodyString);
            }
        } catch (IllegalArgumentException unused) {
            Logger logger7 = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Could not normalize service descriptor URL: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(remoteService.getDescriptorURI());
            logger7.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            return null;
        }
    }

    public RemoteDevice describeServices(RemoteDevice remoteDevice) throws RouterException, DescriptorBindingException, ValidationException {
        RemoteDevice[] embeddedDevices;
        RemoteDevice describeServices;
        ArrayList arrayList = new ArrayList();
        if (remoteDevice.hasServices()) {
            for (RemoteService remoteService : filterExclusiveServices(remoteDevice.mo5197getServices())) {
                RemoteService describeService = describeService(remoteService);
                if (describeService != null) {
                    arrayList.add(describeService);
                } else {
                    log.warning("Skipping invalid service '" + remoteService + "' of: " + remoteDevice);
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        if (remoteDevice.hasEmbeddedDevices()) {
            for (RemoteDevice remoteDevice2 : remoteDevice.getEmbeddedDevices()) {
                if (remoteDevice2 != null && (describeServices = describeServices(remoteDevice2)) != null) {
                    arrayList2.add(describeServices);
                }
            }
        }
        Icon[] iconArr = new Icon[remoteDevice.getIcons().length];
        for (int i = 0; i < remoteDevice.getIcons().length; i++) {
            iconArr[i] = remoteDevice.getIcons()[i].deepCopy();
        }
        return remoteDevice.newInstance(((RemoteDeviceIdentity) remoteDevice.getIdentity()).getUdn(), remoteDevice.getVersion(), remoteDevice.getType(), remoteDevice.getDetails(), iconArr, remoteDevice.mo5200toServiceArray((Collection<RemoteService>) arrayList), (List<RemoteDevice>) arrayList2);
    }

    public List<RemoteService> filterExclusiveServices(RemoteService[] remoteServiceArr) {
        ServiceType[] exclusiveServiceTypes = getUpnpService().getConfiguration().getExclusiveServiceTypes();
        if (exclusiveServiceTypes == null || exclusiveServiceTypes.length == 0) {
            return Arrays.asList(remoteServiceArr);
        }
        ArrayList arrayList = new ArrayList();
        for (RemoteService remoteService : remoteServiceArr) {
            for (ServiceType serviceType : exclusiveServiceTypes) {
                if (remoteService.getServiceType().implementsVersion(serviceType)) {
                    log.fine("Including exclusive service: " + remoteService);
                    arrayList.add(remoteService);
                } else {
                    log.fine("Excluding unwanted service: " + serviceType);
                }
            }
        }
        return arrayList;
    }

    public UpnpService getUpnpService() {
        return this.upnpService;
    }

    @Override // java.lang.Runnable
    public void run() {
        Logger logger;
        StringBuilder sb;
        String str;
        URL descriptorURL = this.f4629rd.getIdentity().getDescriptorURL();
        if (activeRetrievals.contains(descriptorURL)) {
            logger = log;
            sb = new StringBuilder();
            str = "Exiting early, active retrieval for URL already in progress: ";
        } else if (getUpnpService().getRegistry().getRemoteDevice(this.f4629rd.getIdentity().getUdn(), true) == null) {
            try {
                try {
                    activeRetrievals.add(descriptorURL);
                    describe();
                } catch (RouterException e) {
                    Logger logger2 = log;
                    Level level = Level.WARNING;
                    logger2.log(level, "Descriptor retrieval failed: " + descriptorURL, (Throwable) e);
                }
                return;
            } finally {
                activeRetrievals.remove(descriptorURL);
            }
        } else {
            logger = log;
            sb = new StringBuilder();
            str = "Exiting early, already discovered: ";
        }
        sb.append(str);
        sb.append(descriptorURL);
        logger.finer(sb.toString());
    }
}
