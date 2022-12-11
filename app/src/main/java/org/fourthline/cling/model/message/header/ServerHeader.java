package org.fourthline.cling.model.message.header;

import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import org.fourthline.cling.model.ServerClientTokens;

/* loaded from: classes5.dex */
public class ServerHeader extends UpnpHeader<ServerClientTokens> {
    public ServerHeader() {
        setValue(new ServerClientTokens());
    }

    public ServerHeader(ServerClientTokens serverClientTokens) {
        setValue(serverClientTokens);
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public String getString() {
        return getValue().getHttpToken();
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public void setString(String str) throws InvalidHeaderException {
        String[] split;
        String str2;
        ServerClientTokens serverClientTokens = new ServerClientTokens();
        serverClientTokens.setOsName("UNKNOWN");
        serverClientTokens.setOsVersion("UNKNOWN");
        serverClientTokens.setProductName("UNKNOWN");
        serverClientTokens.setProductVersion("UNKNOWN");
        if (str.contains("UPnP/1.1")) {
            serverClientTokens.setMinorVersion(1);
        } else if (!str.contains("UPnP/1.")) {
            throw new InvalidHeaderException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Missing 'UPnP/1.' in server information: ", str));
        }
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            try {
                if (str.charAt(i2) == ' ') {
                    i++;
                }
            } catch (Exception unused) {
                serverClientTokens.setOsName("UNKNOWN");
                serverClientTokens.setOsVersion("UNKNOWN");
                serverClientTokens.setProductName("UNKNOWN");
                serverClientTokens.setProductVersion("UNKNOWN");
            }
        }
        if (str.contains(",")) {
            String[] split2 = str.split(",");
            split = split2[0].split("/");
            str2 = split2[2];
        } else if (i > 2) {
            String trim = str.substring(0, str.indexOf("UPnP/1.")).trim();
            str2 = str.substring(str.indexOf("UPnP/1.") + 8).trim();
            split = trim.split("/");
        } else {
            String[] split3 = str.split(StringUtils.SPACE);
            split = split3[0].split("/");
            str2 = split3[2];
        }
        String[] split4 = str2.split("/");
        serverClientTokens.setOsName(split[0].trim());
        if (split.length > 1) {
            serverClientTokens.setOsVersion(split[1].trim());
        }
        serverClientTokens.setProductName(split4[0].trim());
        if (split4.length > 1) {
            serverClientTokens.setProductVersion(split4[1].trim());
        }
        setValue(serverClientTokens);
    }
}
