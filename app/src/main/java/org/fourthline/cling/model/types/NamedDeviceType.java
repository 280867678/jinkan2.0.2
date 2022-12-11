package org.fourthline.cling.model.types;

import me.tvspark.outline;

/* loaded from: classes5.dex */
public class NamedDeviceType {
    public DeviceType deviceType;
    public UDN udn;

    public NamedDeviceType(UDN udn, DeviceType deviceType) {
        this.udn = udn;
        this.deviceType = deviceType;
    }

    public static NamedDeviceType valueOf(String str) throws InvalidValueException {
        String[] split = str.split("::");
        if (split.length == 2) {
            try {
                return new NamedDeviceType(UDN.valueOf(split[0]), DeviceType.valueOf(split[1]));
            } catch (Exception unused) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Can't parse UDN: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(split[0]);
                throw new InvalidValueException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
        }
        throw new InvalidValueException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Can't parse UDN::DeviceType from: ", str));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NamedDeviceType)) {
            return false;
        }
        NamedDeviceType namedDeviceType = (NamedDeviceType) obj;
        return this.deviceType.equals(namedDeviceType.deviceType) && this.udn.equals(namedDeviceType.udn);
    }

    public DeviceType getDeviceType() {
        return this.deviceType;
    }

    public UDN getUdn() {
        return this.udn;
    }

    public int hashCode() {
        return this.deviceType.hashCode() + (this.udn.hashCode() * 31);
    }

    public String toString() {
        return getUdn().toString() + "::" + getDeviceType().toString();
    }
}
