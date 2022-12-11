package org.fourthline.cling.model.profile;

import me.tvspark.outline;
import org.fourthline.cling.model.message.UpnpHeaders;
import org.fourthline.cling.model.message.header.UpnpHeader;
import org.fourthline.cling.model.message.header.UserAgentHeader;

/* loaded from: classes5.dex */
public class ClientInfo {
    public final UpnpHeaders requestHeaders;

    public ClientInfo() {
        this(new UpnpHeaders());
    }

    public ClientInfo(UpnpHeaders upnpHeaders) {
        this.requestHeaders = upnpHeaders;
    }

    public UpnpHeaders getRequestHeaders() {
        return this.requestHeaders;
    }

    public String getRequestUserAgent() {
        return getRequestHeaders().getFirstHeaderString(UpnpHeader.Type.USER_AGENT);
    }

    public void setRequestUserAgent(String str) {
        getRequestHeaders().add(UpnpHeader.Type.USER_AGENT, new UserAgentHeader(str));
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getClass().getSimpleName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(") User-Agent: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getRequestUserAgent());
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
