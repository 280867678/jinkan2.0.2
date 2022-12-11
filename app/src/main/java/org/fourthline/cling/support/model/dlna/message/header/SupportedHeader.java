package org.fourthline.cling.support.model.dlna.message.header;

import me.tvspark.outline;
import org.fourthline.cling.model.message.header.InvalidHeaderException;

/* loaded from: classes5.dex */
public class SupportedHeader extends DLNAHeader<String[]> {
    public SupportedHeader() {
        setValue(new String[0]);
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public String getString() {
        String[] value = getValue();
        String str = value.length > 0 ? value[0] : "";
        for (int i = 1; i < value.length; i++) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, ",");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(value[i]);
            str = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        return str;
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public void setString(String str) throws InvalidHeaderException {
        if (str.length() != 0) {
            if (str.endsWith(";")) {
                str = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, -1, 0);
            }
            setValue(str.split("\\s*,\\s*"));
            return;
        }
        throw new InvalidHeaderException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid Supported header value: ", str));
    }
}
