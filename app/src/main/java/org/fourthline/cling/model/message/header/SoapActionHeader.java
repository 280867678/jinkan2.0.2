package org.fourthline.cling.model.message.header;

import java.net.URI;
import me.tvspark.outline;
import org.fourthline.cling.model.types.SoapActionType;

/* loaded from: classes5.dex */
public class SoapActionHeader extends UpnpHeader<SoapActionType> {
    public SoapActionHeader() {
    }

    public SoapActionHeader(String str) throws InvalidHeaderException {
        setString(str);
    }

    public SoapActionHeader(URI uri) {
        setValue(SoapActionType.valueOf(uri.toString()));
    }

    public SoapActionHeader(SoapActionType soapActionType) {
        setValue(soapActionType);
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public String getString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("\"");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getValue().toString());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("\"");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public void setString(String str) throws InvalidHeaderException {
        try {
            if (!str.startsWith("\"") && str.endsWith("\"")) {
                throw new InvalidHeaderException("Invalid SOAP action header, must be enclosed in doublequotes:" + str);
            }
            setValue(SoapActionType.valueOf(str.substring(1, str.length() - 1)));
        } catch (RuntimeException e) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid SOAP action header value, ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.getMessage());
            throw new InvalidHeaderException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
    }
}
