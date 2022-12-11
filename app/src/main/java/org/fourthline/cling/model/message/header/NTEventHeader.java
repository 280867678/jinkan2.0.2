package org.fourthline.cling.model.message.header;

import java.util.Locale;
import me.tvspark.outline;

/* loaded from: classes5.dex */
public class NTEventHeader extends UpnpHeader<String> {
    public NTEventHeader() {
        setValue("upnp:event");
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public String getString() {
        return getValue();
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public void setString(String str) throws InvalidHeaderException {
        if (str.toLowerCase(Locale.ROOT).equals(getValue())) {
            return;
        }
        throw new InvalidHeaderException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid event NT header value: ", str));
    }
}
