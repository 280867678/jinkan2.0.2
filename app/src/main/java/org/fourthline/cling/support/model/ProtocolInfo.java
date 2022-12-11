package org.fourthline.cling.support.model;

import me.tvspark.outline;
import org.fourthline.cling.model.types.InvalidValueException;
import org.seamless.util.MimeType;

/* loaded from: classes5.dex */
public class ProtocolInfo {
    public static final String WILDCARD = "*";
    public String additionalInfo;
    public String contentFormat;
    public String network;
    public Protocol protocol;

    public ProtocolInfo(String str) throws InvalidValueException {
        this.protocol = Protocol.ALL;
        this.network = "*";
        this.contentFormat = "*";
        this.additionalInfo = "*";
        if (str != null) {
            String trim = str.trim();
            String[] split = trim.split(":");
            if (split.length != 4) {
                throw new InvalidValueException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Can't parse ProtocolInfo string: ", trim));
            }
            this.protocol = Protocol.value(split[0]);
            this.network = split[1];
            this.contentFormat = split[2];
            this.additionalInfo = split[3];
            return;
        }
        throw null;
    }

    public ProtocolInfo(Protocol protocol, String str, String str2, String str3) {
        this.protocol = Protocol.ALL;
        this.network = "*";
        this.contentFormat = "*";
        this.additionalInfo = "*";
        this.protocol = protocol;
        this.network = str;
        this.contentFormat = str2;
        this.additionalInfo = str3;
    }

    public ProtocolInfo(MimeType mimeType) {
        this.protocol = Protocol.ALL;
        this.network = "*";
        this.contentFormat = "*";
        this.additionalInfo = "*";
        this.protocol = Protocol.HTTP_GET;
        this.contentFormat = mimeType.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ProtocolInfo protocolInfo = (ProtocolInfo) obj;
        return this.additionalInfo.equals(protocolInfo.additionalInfo) && this.contentFormat.equals(protocolInfo.contentFormat) && this.network.equals(protocolInfo.network) && this.protocol == protocolInfo.protocol;
    }

    public String getAdditionalInfo() {
        return this.additionalInfo;
    }

    public String getContentFormat() {
        return this.contentFormat;
    }

    public MimeType getContentFormatMimeType() throws IllegalArgumentException {
        return MimeType.valueOf(this.contentFormat);
    }

    public String getNetwork() {
        return this.network;
    }

    public Protocol getProtocol() {
        return this.protocol;
    }

    public int hashCode() {
        return this.additionalInfo.hashCode() + outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.contentFormat, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.network, this.protocol.hashCode() * 31, 31), 31);
    }

    public String toString() {
        return this.protocol.toString() + ":" + this.network + ":" + this.contentFormat + ":" + this.additionalInfo;
    }
}
