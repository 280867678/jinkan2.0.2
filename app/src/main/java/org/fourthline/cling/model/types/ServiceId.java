package org.fourthline.cling.model.types;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.tvspark.outline;
import org.fourthline.cling.model.Constants;

/* loaded from: classes5.dex */
public class ServiceId {
    public static final String UNKNOWN = "UNKNOWN";

    /* renamed from: id */
    public String f4628id;
    public String namespace;
    public static final Logger log = Logger.getLogger(ServiceId.class.getName());
    public static final Pattern PATTERN = Pattern.compile("urn:([a-zA-Z0-9\\-\\.]+):serviceId:([a-zA-Z_0-9\\-:\\.]{1,64})");
    public static final Pattern BROKEN_PATTERN = Pattern.compile("urn:([a-zA-Z0-9\\-\\.]+):service:([a-zA-Z_0-9\\-:\\.]{1,64})");

    public ServiceId(String str, String str2) {
        if (str == null || str.matches(Constants.REGEX_NAMESPACE)) {
            this.namespace = str;
            if (str2 != null && !str2.matches(Constants.REGEX_ID)) {
                throw new IllegalArgumentException("Service ID suffix too long (64) or contains illegal characters");
            }
            this.f4628id = str2;
            return;
        }
        throw new IllegalArgumentException("Service ID namespace contains illegal characters");
    }

    public static ServiceId valueOf(String str) throws InvalidValueException {
        UDAServiceId uDAServiceId;
        try {
            uDAServiceId = UDAServiceId.valueOf(str);
        } catch (Exception unused) {
            uDAServiceId = null;
        }
        if (uDAServiceId != null) {
            return uDAServiceId;
        }
        Matcher matcher = PATTERN.matcher(str);
        if (matcher.matches() && matcher.groupCount() >= 2) {
            return new ServiceId(matcher.group(1), matcher.group(2));
        }
        Matcher matcher2 = BROKEN_PATTERN.matcher(str);
        if (matcher2.matches() && matcher2.groupCount() >= 2) {
            return new ServiceId(matcher2.group(1), matcher2.group(2));
        }
        Matcher matcher3 = Pattern.compile("urn:([a-zA-Z0-9\\-\\.]+):serviceId:").matcher(str);
        if (matcher3.matches() && matcher3.groupCount() >= 1) {
            Logger logger = log;
            logger.warning("UPnP specification violation, no service ID token, defaulting to UNKNOWN: " + str);
            return new ServiceId(matcher3.group(1), "UNKNOWN");
        }
        String[] split = str.split("[:]");
        if (split.length != 4) {
            throw new InvalidValueException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Can't parse service ID string (namespace/id): ", str));
        }
        Logger logger2 = log;
        logger2.warning("UPnP specification violation, trying a simple colon-split of: " + str);
        return new ServiceId(split[1], split[3]);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ServiceId)) {
            return false;
        }
        ServiceId serviceId = (ServiceId) obj;
        return this.f4628id.equals(serviceId.f4628id) && this.namespace.equals(serviceId.namespace);
    }

    public String getId() {
        return this.f4628id;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public int hashCode() {
        return this.f4628id.hashCode() + (this.namespace.hashCode() * 31);
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("urn:");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getNamespace());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(":serviceId:");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getId());
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
