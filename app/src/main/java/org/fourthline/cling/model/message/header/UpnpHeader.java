package org.fourthline.cling.model.message.header;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.tvspark.outline;
import org.seamless.util.Exceptions;

/* loaded from: classes5.dex */
public abstract class UpnpHeader<T> {
    public static final Logger log = Logger.getLogger(UpnpHeader.class.getName());
    public T value;

    /* loaded from: classes5.dex */
    public enum Type {
        USN("USN", USNRootDeviceHeader.class, DeviceUSNHeader.class, ServiceUSNHeader.class, UDNHeader.class),
        NT("NT", RootDeviceHeader.class, UDADeviceTypeHeader.class, UDAServiceTypeHeader.class, DeviceTypeHeader.class, ServiceTypeHeader.class, UDNHeader.class, NTEventHeader.class),
        NTS("NTS", NTSHeader.class),
        HOST("HOST", HostHeader.class),
        SERVER("SERVER", ServerHeader.class),
        LOCATION("LOCATION", LocationHeader.class),
        MAX_AGE("CACHE-CONTROL", MaxAgeHeader.class),
        USER_AGENT("USER-AGENT", UserAgentHeader.class),
        CONTENT_TYPE("CONTENT-TYPE", ContentTypeHeader.class),
        MAN("MAN", MANHeader.class),
        MX("MX", MXHeader.class),
        ST("ST", STAllHeader.class, RootDeviceHeader.class, UDADeviceTypeHeader.class, UDAServiceTypeHeader.class, DeviceTypeHeader.class, ServiceTypeHeader.class, UDNHeader.class),
        EXT("EXT", EXTHeader.class),
        SOAPACTION("SOAPACTION", SoapActionHeader.class),
        TIMEOUT("TIMEOUT", TimeoutHeader.class),
        CALLBACK("CALLBACK", CallbackHeader.class),
        SID("SID", SubscriptionIdHeader.class),
        SEQ("SEQ", EventSequenceHeader.class),
        RANGE("RANGE", RangeHeader.class),
        CONTENT_RANGE("CONTENT-RANGE", ContentRangeHeader.class),
        PRAGMA("PRAGMA", PragmaHeader.class),
        EXT_IFACE_MAC("X-CLING-IFACE-MAC", InterfaceMacHeader.class),
        EXT_AV_CLIENT_INFO("X-AV-CLIENT-INFO", AVClientInfoHeader.class);
        
        public static Map<String, Type> byName = new HashMap<String, Type>() { // from class: org.fourthline.cling.model.message.header.UpnpHeader.Type.1
            {
                Type[] values;
                for (Type type : Type.values()) {
                    put(type.getHttpName(), type);
                }
            }
        };
        public Class<? extends UpnpHeader>[] headerTypes;
        public String httpName;

        @SafeVarargs
        Type(String str, Class... clsArr) {
            this.httpName = str;
            this.headerTypes = clsArr;
        }

        public static Type getByHttpName(String str) {
            if (str == null) {
                return null;
            }
            return byName.get(str.toUpperCase(Locale.ROOT));
        }

        public Class<? extends UpnpHeader>[] getHeaderTypes() {
            return this.headerTypes;
        }

        public String getHttpName() {
            return this.httpName;
        }

        public boolean isValidHeaderType(Class<? extends UpnpHeader> cls) {
            for (Class<? extends UpnpHeader> cls2 : getHeaderTypes()) {
                if (cls2.isAssignableFrom(cls)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static UpnpHeader newInstance(Type type, String str) {
        UpnpHeader upnpHeader;
        Exception e;
        UpnpHeader upnpHeader2 = null;
        for (int i = 0; i < type.getHeaderTypes().length && upnpHeader2 == null; i++) {
            Class<? extends UpnpHeader> cls = type.getHeaderTypes()[i];
            try {
                try {
                    log.finest("Trying to parse '" + type + "' with class: " + cls.getSimpleName());
                    upnpHeader = cls.newInstance();
                    if (str != null) {
                        try {
                            upnpHeader.setString(str);
                        } catch (Exception e2) {
                            e = e2;
                            log.severe("Error instantiating header of type '" + type + "' with value: " + str);
                            log.log(Level.SEVERE, "Exception root cause: ", Exceptions.unwrap(e));
                            upnpHeader2 = upnpHeader;
                        }
                    }
                } catch (InvalidHeaderException e3) {
                    Logger logger = log;
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid header value for tested type: ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(cls.getSimpleName());
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" - ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e3.getMessage());
                    logger.finest(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                    upnpHeader2 = null;
                }
            } catch (Exception e4) {
                upnpHeader = upnpHeader2;
                e = e4;
            }
            upnpHeader2 = upnpHeader;
        }
        return upnpHeader2;
    }

    public abstract String getString();

    public T getValue() {
        return this.value;
    }

    public abstract void setString(String str) throws InvalidHeaderException;

    public void setValue(T t) {
        this.value = t;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getClass().getSimpleName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(") '");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getValue());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("'");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
