package org.fourthline.cling.model.types;

import me.tvspark.outline;

/* loaded from: classes5.dex */
public class NamedServiceType {
    public ServiceType serviceType;
    public UDN udn;

    public NamedServiceType(UDN udn, ServiceType serviceType) {
        this.udn = udn;
        this.serviceType = serviceType;
    }

    public static NamedServiceType valueOf(String str) throws InvalidValueException {
        String[] split = str.split("::");
        if (split.length == 2) {
            try {
                return new NamedServiceType(UDN.valueOf(split[0]), ServiceType.valueOf(split[1]));
            } catch (Exception unused) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Can't parse UDN: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(split[0]);
                throw new InvalidValueException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
        }
        throw new InvalidValueException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Can't parse UDN::ServiceType from: ", str));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NamedServiceType)) {
            return false;
        }
        NamedServiceType namedServiceType = (NamedServiceType) obj;
        return this.serviceType.equals(namedServiceType.serviceType) && this.udn.equals(namedServiceType.udn);
    }

    public ServiceType getServiceType() {
        return this.serviceType;
    }

    public UDN getUdn() {
        return this.udn;
    }

    public int hashCode() {
        return this.serviceType.hashCode() + (this.udn.hashCode() * 31);
    }

    public String toString() {
        return getUdn().toString() + "::" + getServiceType().toString();
    }
}
