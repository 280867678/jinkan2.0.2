package org.fourthline.cling.model.message.header;

import java.net.URI;
import me.tvspark.outline;
import org.fourthline.cling.model.types.DeviceType;

/* loaded from: classes5.dex */
public class DeviceTypeHeader extends UpnpHeader<DeviceType> {
    public DeviceTypeHeader() {
    }

    public DeviceTypeHeader(URI uri) {
        setString(uri.toString());
    }

    public DeviceTypeHeader(DeviceType deviceType) {
        setValue(deviceType);
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public String getString() {
        return getValue().toString();
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public void setString(String str) throws InvalidHeaderException {
        try {
            setValue(DeviceType.valueOf(str));
        } catch (RuntimeException e) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid device type header value, ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.getMessage());
            throw new InvalidHeaderException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
    }
}
