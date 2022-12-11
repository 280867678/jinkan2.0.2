package org.fourthline.cling.model.message.header;

import me.tvspark.outline;
import org.fourthline.cling.model.types.UDN;

/* loaded from: classes5.dex */
public class UDNHeader extends UpnpHeader<UDN> {
    public UDNHeader() {
    }

    public UDNHeader(UDN udn) {
        setValue(udn);
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public String getString() {
        return getValue().toString();
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public void setString(String str) throws InvalidHeaderException {
        if (str.startsWith("uuid:")) {
            if (str.contains("::urn")) {
                throw new InvalidHeaderException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid UDA header value, must not contain '::urn': ", str));
            }
            setValue(new UDN(str.substring(5)));
            return;
        }
        throw new InvalidHeaderException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid UDA header value, must start with 'uuid:': ", str));
    }
}
