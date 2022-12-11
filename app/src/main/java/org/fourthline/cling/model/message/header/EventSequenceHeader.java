package org.fourthline.cling.model.message.header;

import me.tvspark.outline;
import org.fourthline.cling.model.types.UnsignedIntegerFourBytes;

/* loaded from: classes5.dex */
public class EventSequenceHeader extends UpnpHeader<UnsignedIntegerFourBytes> {
    public EventSequenceHeader() {
    }

    public EventSequenceHeader(long j) {
        setValue(new UnsignedIntegerFourBytes(j));
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public String getString() {
        return getValue().toString();
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public void setString(String str) throws InvalidHeaderException {
        if (!"0".equals(str)) {
            while (str.startsWith("0")) {
                str = str.substring(1);
            }
        }
        try {
            setValue(new UnsignedIntegerFourBytes(str));
        } catch (NumberFormatException e) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid event sequence, ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.getMessage());
            throw new InvalidHeaderException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
    }
}
