package org.fourthline.cling.model.message.header;

import me.tvspark.outline;
import org.fourthline.cling.model.types.BytesRange;
import org.fourthline.cling.model.types.InvalidValueException;

/* loaded from: classes5.dex */
public class ContentRangeHeader extends UpnpHeader<BytesRange> {
    public static final String PREFIX = "bytes ";

    public ContentRangeHeader() {
    }

    public ContentRangeHeader(String str) {
        setString(str);
    }

    public ContentRangeHeader(BytesRange bytesRange) {
        setValue(bytesRange);
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public String getString() {
        return getValue().getString(true, PREFIX);
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public void setString(String str) throws InvalidHeaderException {
        try {
            setValue(BytesRange.valueOf(str, PREFIX));
        } catch (InvalidValueException e) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid Range Header: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.getMessage());
            throw new InvalidHeaderException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
    }
}
