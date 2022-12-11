package org.fourthline.cling.model.message.header;

import java.net.MalformedURLException;
import java.net.URL;
import me.tvspark.outline;

/* loaded from: classes5.dex */
public class LocationHeader extends UpnpHeader<URL> {
    public LocationHeader() {
    }

    public LocationHeader(String str) {
        setString(str);
    }

    public LocationHeader(URL url) {
        setValue(url);
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public String getString() {
        return getValue().toString();
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public void setString(String str) throws InvalidHeaderException {
        try {
            setValue(new URL(str));
        } catch (MalformedURLException e) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid URI: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.getMessage());
            throw new InvalidHeaderException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
    }
}
