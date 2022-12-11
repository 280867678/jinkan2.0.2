package org.fourthline.cling.model.types;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.tvspark.outline;
import org.fourthline.cling.model.Constants;

/* loaded from: classes5.dex */
public class DeviceType {
    public static final String UNKNOWN = "UNKNOWN";
    public String namespace;
    public String type;
    public int version;
    public static final Logger log = Logger.getLogger(DeviceType.class.getName());
    public static final Pattern PATTERN = Pattern.compile("urn:([a-zA-Z0-9\\-\\.]+):device:([a-zA-Z_0-9\\-]{1,64}):([0-9]+).*");

    public DeviceType(String str, String str2) {
        this(str, str2, 1);
    }

    public DeviceType(String str, String str2, int i) {
        this.version = 1;
        if (str == null || str.matches(Constants.REGEX_NAMESPACE)) {
            this.namespace = str;
            if (str2 != null && !str2.matches(Constants.REGEX_TYPE)) {
                throw new IllegalArgumentException("Device type suffix too long (64) or contains illegal characters");
            }
            this.type = str2;
            this.version = i;
            return;
        }
        throw new IllegalArgumentException("Device type namespace contains illegal characters");
    }

    public static DeviceType valueOf(String str) throws InvalidValueException {
        UDADeviceType uDADeviceType;
        String replaceAll = str.replaceAll("\\s", "");
        try {
            uDADeviceType = UDADeviceType.valueOf(replaceAll);
        } catch (Exception unused) {
            uDADeviceType = null;
        }
        if (uDADeviceType != null) {
            return uDADeviceType;
        }
        try {
            Matcher matcher = PATTERN.matcher(replaceAll);
            if (matcher.matches()) {
                return new DeviceType(matcher.group(1), matcher.group(2), Integer.valueOf(matcher.group(3)).intValue());
            }
            Matcher matcher2 = Pattern.compile("urn:([a-zA-Z0-9\\-\\.]+):device::([0-9]+).*").matcher(replaceAll);
            if (matcher2.matches() && matcher2.groupCount() >= 2) {
                Logger logger = log;
                logger.warning("UPnP specification violation, no device type token, defaulting to UNKNOWN: " + replaceAll);
                return new DeviceType(matcher2.group(1), "UNKNOWN", Integer.valueOf(matcher2.group(2)).intValue());
            }
            Matcher matcher3 = Pattern.compile("urn:([a-zA-Z0-9\\-\\.]+):device:(.+?):([0-9]+).*").matcher(replaceAll);
            if (!matcher3.matches() || matcher3.groupCount() < 3) {
                throw new InvalidValueException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Can't parse device type string (namespace/type/version): ", replaceAll));
            }
            String replaceAll2 = matcher3.group(2).replaceAll("[^a-zA-Z_0-9\\-]", "-");
            Logger logger2 = log;
            logger2.warning("UPnP specification violation, replacing invalid device type token '" + matcher3.group(2) + "' with: " + replaceAll2);
            return new DeviceType(matcher3.group(1), replaceAll2, Integer.valueOf(matcher3.group(3)).intValue());
        } catch (RuntimeException e) {
            throw new InvalidValueException(String.format("Can't parse device type string (namespace/type/version) '%s': %s", replaceAll, e.toString()));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeviceType)) {
            return false;
        }
        DeviceType deviceType = (DeviceType) obj;
        return this.version == deviceType.version && this.namespace.equals(deviceType.namespace) && this.type.equals(deviceType.type);
    }

    public String getDisplayString() {
        return getType();
    }

    public String getNamespace() {
        return this.namespace;
    }

    public String getType() {
        return this.type;
    }

    public int getVersion() {
        return this.version;
    }

    public int hashCode() {
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.type, this.namespace.hashCode() * 31, 31) + this.version;
    }

    public boolean implementsVersion(DeviceType deviceType) {
        return this.namespace.equals(deviceType.namespace) && this.type.equals(deviceType.type) && this.version >= deviceType.version;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("urn:");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getNamespace());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(":device:");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getType());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(":");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getVersion());
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
