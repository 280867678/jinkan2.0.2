package org.fourthline.cling.model.message.header;

import me.tvspark.outline;
import org.fourthline.cling.model.Constants;
import org.fourthline.cling.model.types.HostPort;

/* loaded from: classes5.dex */
public class HostHeader extends UpnpHeader<HostPort> {
    public int port = Constants.UPNP_MULTICAST_PORT;
    public String group = Constants.IPV4_UPNP_MULTICAST_GROUP;

    public HostHeader() {
        setValue(new HostPort(Constants.IPV4_UPNP_MULTICAST_GROUP, Constants.UPNP_MULTICAST_PORT));
    }

    public HostHeader(int i) {
        setValue(new HostPort(Constants.IPV4_UPNP_MULTICAST_GROUP, i));
    }

    public HostHeader(String str, int i) {
        setValue(new HostPort(str, i));
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public String getString() {
        return getValue().toString();
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public void setString(String str) throws InvalidHeaderException {
        if (!str.contains(":")) {
            this.group = str;
            setValue(new HostPort(str, this.port));
            return;
        }
        try {
            this.port = Integer.valueOf(str.substring(str.indexOf(":") + 1)).intValue();
            String substring = str.substring(0, str.indexOf(":"));
            this.group = substring;
            setValue(new HostPort(substring, this.port));
        } catch (NumberFormatException e) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid HOST header value, can't parse port: ", str, " - ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.getMessage());
            throw new InvalidHeaderException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
    }
}
