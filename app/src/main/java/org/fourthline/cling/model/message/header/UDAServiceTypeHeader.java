package org.fourthline.cling.model.message.header;

import java.net.URI;
import me.tvspark.outline;
import org.fourthline.cling.model.types.UDAServiceType;

/* loaded from: classes5.dex */
public class UDAServiceTypeHeader extends ServiceTypeHeader {
    public UDAServiceTypeHeader() {
    }

    public UDAServiceTypeHeader(URI uri) {
        super(uri);
    }

    public UDAServiceTypeHeader(UDAServiceType uDAServiceType) {
        super(uDAServiceType);
    }

    @Override // org.fourthline.cling.model.message.header.ServiceTypeHeader, org.fourthline.cling.model.message.header.UpnpHeader
    public void setString(String str) throws InvalidHeaderException {
        try {
            setValue(UDAServiceType.valueOf(str));
        } catch (Exception e) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid UDA service type header value, ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.getMessage());
            throw new InvalidHeaderException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
    }
}
