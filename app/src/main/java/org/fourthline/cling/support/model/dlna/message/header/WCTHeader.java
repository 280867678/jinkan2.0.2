package org.fourthline.cling.support.model.dlna.message.header;

import java.util.regex.Pattern;
import me.tvspark.outline;
import org.fourthline.cling.model.message.header.InvalidHeaderException;

/* loaded from: classes5.dex */
public class WCTHeader extends DLNAHeader<Boolean> {
    public static final Pattern pattern = Pattern.compile("^[01]{1}$", 2);

    public WCTHeader() {
        setValue(false);
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public String getString() {
        return getValue().booleanValue() ? "1" : "0";
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public void setString(String str) throws InvalidHeaderException {
        if (pattern.matcher(str).matches()) {
            setValue(Boolean.valueOf(str.equals("1")));
            return;
        }
        throw new InvalidHeaderException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid SCID header value: ", str));
    }
}
