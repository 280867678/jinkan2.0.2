package org.fourthline.cling.model.message.header;

import me.tvspark.outline;
import org.fourthline.cling.model.types.NotificationSubtype;

/* loaded from: classes5.dex */
public class STAllHeader extends UpnpHeader<NotificationSubtype> {
    public STAllHeader() {
        setValue(NotificationSubtype.ALL);
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public String getString() {
        return getValue().getHeaderString();
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public void setString(String str) throws InvalidHeaderException {
        if (str.equals(NotificationSubtype.ALL.getHeaderString())) {
            return;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid ST header value (not ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(NotificationSubtype.ALL);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("): ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str);
        throw new InvalidHeaderException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }
}
