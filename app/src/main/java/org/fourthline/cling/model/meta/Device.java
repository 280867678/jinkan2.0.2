package org.fourthline.cling.model.meta;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import org.fourthline.cling.model.Namespace;
import org.fourthline.cling.model.Validatable;
import org.fourthline.cling.model.ValidationError;
import org.fourthline.cling.model.ValidationException;
import org.fourthline.cling.model.meta.Device;
import org.fourthline.cling.model.meta.DeviceIdentity;
import org.fourthline.cling.model.meta.Service;
import org.fourthline.cling.model.profile.RemoteClientInfo;
import org.fourthline.cling.model.resource.Resource;
import org.fourthline.cling.model.types.DeviceType;
import org.fourthline.cling.model.types.ServiceId;
import org.fourthline.cling.model.types.ServiceType;
import org.fourthline.cling.model.types.UDN;

/* loaded from: classes5.dex */
public abstract class Device<DI extends DeviceIdentity, D extends Device, S extends Service> implements Validatable {
    public static final Logger log = Logger.getLogger(Device.class.getName());
    public final DeviceDetails details;
    public final D[] embeddedDevices;
    public final Icon[] icons;
    public final DI identity;
    public D parentDevice;
    public final S[] services;
    public final DeviceType type;
    public final UDAVersion version;

    public Device(DI di) throws ValidationException {
        this(di, null, null, null, null, null);
    }

    public Device(DI di, UDAVersion uDAVersion, DeviceType deviceType, DeviceDetails deviceDetails, Icon[] iconArr, S[] sArr, D[] dArr) throws ValidationException {
        boolean z;
        this.identity = di;
        this.version = uDAVersion == null ? new UDAVersion() : uDAVersion;
        this.type = deviceType;
        this.details = deviceDetails;
        ArrayList arrayList = new ArrayList();
        if (iconArr != null) {
            for (Icon icon : iconArr) {
                if (icon != null) {
                    icon.setDevice(this);
                    List<ValidationError> validate = icon.validate();
                    if (validate.isEmpty()) {
                        arrayList.add(icon);
                    } else {
                        log.warning("Discarding invalid '" + icon + "': " + validate);
                    }
                }
            }
        }
        this.icons = (Icon[]) arrayList.toArray(new Icon[arrayList.size()]);
        boolean z2 = true;
        if (sArr != null) {
            z = true;
            for (S s : sArr) {
                if (s != null) {
                    s.setDevice(this);
                    z = false;
                }
            }
        } else {
            z = true;
        }
        this.services = (sArr == null || z) ? null : sArr;
        if (dArr != null) {
            for (D d : dArr) {
                if (d != null) {
                    d.setParentDevice(this);
                    z2 = false;
                }
            }
        }
        this.embeddedDevices = (dArr == null || z2) ? null : dArr;
        List<ValidationError> validate2 = validate();
        if (validate2.size() > 0) {
            if (log.isLoggable(Level.FINEST)) {
                for (ValidationError validationError : validate2) {
                    log.finest(validationError.toString());
                }
            }
            throw new ValidationException("Validation of device graph failed, call getErrors() on exception", validate2);
        }
    }

    public Device(DI di, DeviceType deviceType, DeviceDetails deviceDetails, Icon[] iconArr, S[] sArr) throws ValidationException {
        this(di, null, deviceType, deviceDetails, iconArr, sArr, null);
    }

    public Device(DI di, DeviceType deviceType, DeviceDetails deviceDetails, Icon[] iconArr, S[] sArr, D[] dArr) throws ValidationException {
        this(di, null, deviceType, deviceDetails, iconArr, sArr, dArr);
    }

    private boolean isMatch(Service service, ServiceType serviceType, ServiceId serviceId) {
        return (serviceType == null || service.getServiceType().implementsVersion(serviceType)) && (serviceId == null || service.getServiceId().equals(serviceId));
    }

    public abstract Resource[] discoverResources(Namespace namespace);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.identity.equals(((Device) obj).identity);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Collection<D> find(DeviceType deviceType, D d) {
        HashSet hashSet = new HashSet();
        if (d.getType() != null && d.getType().implementsVersion(deviceType)) {
            hashSet.add(d);
        }
        if (d.hasEmbeddedDevices()) {
            for (Device device : d.getEmbeddedDevices()) {
                hashSet.addAll(find(deviceType, (DeviceType) device));
            }
        }
        return hashSet;
    }

    public Collection<D> find(ServiceType serviceType, D d) {
        Collection<S> findServices = findServices(serviceType, null, d);
        HashSet hashSet = new HashSet();
        for (S s : findServices) {
            hashSet.add(s.getDevice());
        }
        return hashSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public D find(UDN udn, D d) {
        if (d.getIdentity() == null || d.getIdentity().getUdn() == null || !d.getIdentity().getUdn().equals(udn)) {
            if (!d.hasEmbeddedDevices()) {
                return null;
            }
            for (Device device : d.getEmbeddedDevices()) {
                D d2 = (D) find(udn, (UDN) device);
                if (d2 != null) {
                    return d2;
                }
            }
            return null;
        }
        return d;
    }

    public abstract D findDevice(UDN udn);

    public D[] findDevices(DeviceType deviceType) {
        return toDeviceArray(find(deviceType, (DeviceType) this));
    }

    public D[] findDevices(ServiceType serviceType) {
        return toDeviceArray(find(serviceType, (ServiceType) this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Collection<D> findEmbeddedDevices(D d) {
        HashSet hashSet = new HashSet();
        if (!d.isRoot() && d.getIdentity().getUdn() != null) {
            hashSet.add(d);
        }
        if (d.hasEmbeddedDevices()) {
            for (Device device : d.getEmbeddedDevices()) {
                hashSet.addAll(findEmbeddedDevices(device));
            }
        }
        return hashSet;
    }

    public D[] findEmbeddedDevices() {
        return toDeviceArray(findEmbeddedDevices(this));
    }

    public Icon[] findIcons() {
        D[] findEmbeddedDevices;
        ArrayList arrayList = new ArrayList();
        if (hasIcons()) {
            arrayList.addAll(Arrays.asList(getIcons()));
        }
        for (D d : findEmbeddedDevices()) {
            if (d.hasIcons()) {
                arrayList.addAll(Arrays.asList(d.getIcons()));
            }
        }
        return (Icon[]) arrayList.toArray(new Icon[arrayList.size()]);
    }

    public S findService(ServiceId serviceId) {
        Collection<S> findServices = findServices(null, serviceId, this);
        if (findServices.size() == 1) {
            return findServices.iterator().next();
        }
        return null;
    }

    public S findService(ServiceType serviceType) {
        Collection<S> findServices = findServices(serviceType, null, this);
        if (findServices.size() > 0) {
            return findServices.iterator().next();
        }
        return null;
    }

    public ServiceType[] findServiceTypes() {
        Collection<S> findServices = findServices(null, null, this);
        HashSet hashSet = new HashSet();
        for (S s : findServices) {
            hashSet.add(s.getServiceType());
        }
        return (ServiceType[]) hashSet.toArray(new ServiceType[hashSet.size()]);
    }

    public Collection<S> findServices(ServiceType serviceType, ServiceId serviceId, D d) {
        Service[] mo5197getServices;
        Service[] mo5197getServices2;
        HashSet hashSet = new HashSet();
        if (d.hasServices()) {
            for (Service service : d.mo5197getServices()) {
                if (isMatch(service, serviceType, serviceId)) {
                    hashSet.add(service);
                }
            }
        }
        Collection<D> findEmbeddedDevices = findEmbeddedDevices(d);
        if (findEmbeddedDevices != null) {
            for (D d2 : findEmbeddedDevices) {
                if (d2.hasServices()) {
                    for (Service service2 : d2.mo5197getServices()) {
                        if (isMatch(service2, serviceType, serviceId)) {
                            hashSet.add(service2);
                        }
                    }
                }
            }
        }
        return hashSet;
    }

    public S[] findServices() {
        return mo5200toServiceArray(findServices(null, null, this));
    }

    public S[] findServices(ServiceType serviceType) {
        return mo5200toServiceArray(findServices(serviceType, null, this));
    }

    public DeviceDetails getDetails() {
        return this.details;
    }

    public DeviceDetails getDetails(RemoteClientInfo remoteClientInfo) {
        return getDetails();
    }

    public String getDisplayString() {
        String str;
        String str2 = null;
        String str3 = "";
        if (getDetails() == null || getDetails().getModelDetails() == null) {
            str = null;
        } else {
            ModelDetails modelDetails = getDetails().getModelDetails();
            if (modelDetails.getModelName() != null) {
                str2 = (modelDetails.getModelNumber() == null || !modelDetails.getModelName().endsWith(modelDetails.getModelNumber())) ? modelDetails.getModelName() : modelDetails.getModelName().substring(0, modelDetails.getModelName().length() - modelDetails.getModelNumber().length());
            }
            str = (str2 == null || (modelDetails.getModelNumber() != null && !str2.startsWith(modelDetails.getModelNumber()))) ? modelDetails.getModelNumber() : str3;
        }
        StringBuilder sb = new StringBuilder();
        if (getDetails() != null && getDetails().getManufacturerDetails() != null) {
            if (str2 != null && getDetails().getManufacturerDetails().getManufacturer() != null) {
                if (str2.startsWith(getDetails().getManufacturerDetails().getManufacturer())) {
                    str2 = str2.substring(getDetails().getManufacturerDetails().getManufacturer().length());
                }
                str2 = str2.trim();
            }
            if (getDetails().getManufacturerDetails().getManufacturer() != null) {
                sb.append(getDetails().getManufacturerDetails().getManufacturer());
            }
        }
        sb.append((str2 == null || str2.length() <= 0) ? str3 : outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(StringUtils.SPACE, str2));
        if (str != null && str.length() > 0) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(StringUtils.SPACE);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str.trim());
            str3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        sb.append(str3);
        return sb.toString();
    }

    public abstract D[] getEmbeddedDevices();

    public Icon[] getIcons() {
        return this.icons;
    }

    public DI getIdentity() {
        return this.identity;
    }

    public D getParentDevice() {
        return this.parentDevice;
    }

    public abstract D getRoot();

    /* renamed from: getServices */
    public abstract S[] mo5197getServices();

    public DeviceType getType() {
        return this.type;
    }

    public UDAVersion getVersion() {
        return this.version;
    }

    public boolean hasEmbeddedDevices() {
        return getEmbeddedDevices() != null && getEmbeddedDevices().length > 0;
    }

    public boolean hasIcons() {
        return getIcons() != null && getIcons().length > 0;
    }

    public boolean hasServices() {
        return mo5197getServices() != null && mo5197getServices().length > 0;
    }

    public int hashCode() {
        return this.identity.hashCode();
    }

    public boolean isFullyHydrated() {
        for (S s : findServices()) {
            if (s.hasStateVariables()) {
                return true;
            }
        }
        return false;
    }

    public boolean isRoot() {
        return getParentDevice() == null;
    }

    public abstract D newInstance(UDN udn, UDAVersion uDAVersion, DeviceType deviceType, DeviceDetails deviceDetails, Icon[] iconArr, S[] sArr, List<D> list) throws ValidationException;

    /* renamed from: newInstance */
    public abstract S mo5198newInstance(ServiceType serviceType, ServiceId serviceId, URI uri, URI uri2, URI uri3, Action<S>[] actionArr, StateVariable<S>[] stateVariableArr) throws ValidationException;

    /* renamed from: newServiceArray */
    public abstract S[] mo5199newServiceArray(int i);

    public void setParentDevice(D d) {
        if (this.parentDevice == null) {
            this.parentDevice = d;
            return;
        }
        throw new IllegalStateException("Final value has been set already, model is immutable");
    }

    public abstract D[] toDeviceArray(Collection<D> collection);

    /* renamed from: toServiceArray */
    public abstract S[] mo5200toServiceArray(Collection<S> collection);

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getClass().getSimpleName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(") Identity: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getIdentity().toString());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", Root: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(isRoot());
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    @Override // org.fourthline.cling.model.Validatable
    public List<ValidationError> validate() {
        D[] embeddedDevices;
        S[] mo5197getServices;
        ArrayList arrayList = new ArrayList();
        if (getType() != null) {
            arrayList.addAll(getVersion().validate());
            if (getIdentity() != null) {
                arrayList.addAll(getIdentity().validate());
            }
            if (getDetails() != null) {
                arrayList.addAll(getDetails().validate());
            }
            if (hasServices()) {
                for (S s : mo5197getServices()) {
                    if (s != null) {
                        arrayList.addAll(s.validate());
                    }
                }
            }
            if (hasEmbeddedDevices()) {
                for (D d : getEmbeddedDevices()) {
                    if (d != null) {
                        arrayList.addAll(d.validate());
                    }
                }
            }
        }
        return arrayList;
    }
}
