package org.fourthline.cling.model;

import org.fourthline.cling.model.types.ServiceId;
import org.fourthline.cling.model.types.UDN;

/* loaded from: classes5.dex */
public class ServiceReference {
    public static final String DELIMITER = "/";
    public final ServiceId serviceId;
    public final UDN udn;

    public ServiceReference(String str) {
        ServiceId serviceId;
        String[] split = str.split("/");
        if (split.length == 2) {
            this.udn = UDN.valueOf(split[0]);
            serviceId = ServiceId.valueOf(split[1]);
        } else {
            serviceId = null;
            this.udn = null;
        }
        this.serviceId = serviceId;
    }

    public ServiceReference(UDN udn, ServiceId serviceId) {
        this.udn = udn;
        this.serviceId = serviceId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ServiceReference.class != obj.getClass()) {
            return false;
        }
        ServiceReference serviceReference = (ServiceReference) obj;
        return this.serviceId.equals(serviceReference.serviceId) && this.udn.equals(serviceReference.udn);
    }

    public ServiceId getServiceId() {
        return this.serviceId;
    }

    public UDN getUdn() {
        return this.udn;
    }

    public int hashCode() {
        return this.serviceId.hashCode() + (this.udn.hashCode() * 31);
    }

    public String toString() {
        if (this.udn == null || this.serviceId == null) {
            return "";
        }
        return this.udn.toString() + "/" + this.serviceId.toString();
    }
}
