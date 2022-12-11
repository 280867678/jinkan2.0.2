package org.fourthline.cling.model.message.header;

import me.tvspark.outline;
import org.fourthline.cling.model.types.UDN;

/* loaded from: classes5.dex */
public class USNRootDeviceHeader extends UpnpHeader<UDN> {
    public static final String ROOT_DEVICE_SUFFIX = "::upnp:rootdevice";

    public USNRootDeviceHeader() {
    }

    public USNRootDeviceHeader(UDN udn) {
        setValue(udn);
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public String getString() {
        return getValue().toString() + ROOT_DEVICE_SUFFIX;
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public void setString(String str) throws InvalidHeaderException {
        if (!str.startsWith("uuid:") || !str.endsWith(ROOT_DEVICE_SUFFIX)) {
            throw new InvalidHeaderException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid root device USN header value, must start with 'uuid:' and end with '::upnp:rootdevice' but is '", str, "'"));
        }
        setValue(new UDN(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, -17, 5)));
    }
}
