package org.fourthline.cling.support.model;

import java.util.Map;
import me.tvspark.outline;
import org.fourthline.cling.model.action.ActionArgumentValue;
import org.fourthline.cling.model.meta.Service;
import org.fourthline.cling.model.types.UnsignedIntegerFourBytes;
import org.fourthline.cling.model.types.UnsignedIntegerTwoBytes;

/* loaded from: classes5.dex */
public class PortMapping {
    public String description;
    public boolean enabled;
    public UnsignedIntegerTwoBytes externalPort;
    public String internalClient;
    public UnsignedIntegerTwoBytes internalPort;
    public UnsignedIntegerFourBytes leaseDurationSeconds;
    public Protocol protocol;
    public String remoteHost;

    /* loaded from: classes5.dex */
    public enum Protocol {
        UDP,
        TCP
    }

    public PortMapping() {
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public PortMapping(int i, String str, Protocol protocol) {
        this(true, new UnsignedIntegerFourBytes(0L), null, new UnsignedIntegerTwoBytes(r0), new UnsignedIntegerTwoBytes(r0), str, protocol, null);
        long j = i;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public PortMapping(int i, String str, Protocol protocol, String str2) {
        this(true, new UnsignedIntegerFourBytes(0L), null, new UnsignedIntegerTwoBytes(r0), new UnsignedIntegerTwoBytes(r0), str, protocol, str2);
        long j = i;
    }

    public PortMapping(String str, UnsignedIntegerTwoBytes unsignedIntegerTwoBytes, Protocol protocol) {
        this(true, new UnsignedIntegerFourBytes(0L), str, unsignedIntegerTwoBytes, null, null, protocol, null);
    }

    public PortMapping(Map<String, ActionArgumentValue<Service>> map) {
        this(((Boolean) map.get("NewEnabled").getValue()).booleanValue(), (UnsignedIntegerFourBytes) map.get("NewLeaseDuration").getValue(), (String) map.get("NewRemoteHost").getValue(), (UnsignedIntegerTwoBytes) map.get("NewExternalPort").getValue(), (UnsignedIntegerTwoBytes) map.get("NewInternalPort").getValue(), (String) map.get("NewInternalClient").getValue(), Protocol.valueOf(map.get("NewProtocol").toString()), (String) map.get("NewPortMappingDescription").getValue());
    }

    public PortMapping(boolean z, UnsignedIntegerFourBytes unsignedIntegerFourBytes, String str, UnsignedIntegerTwoBytes unsignedIntegerTwoBytes, UnsignedIntegerTwoBytes unsignedIntegerTwoBytes2, String str2, Protocol protocol, String str3) {
        this.enabled = z;
        this.leaseDurationSeconds = unsignedIntegerFourBytes;
        this.remoteHost = str;
        this.externalPort = unsignedIntegerTwoBytes;
        this.internalPort = unsignedIntegerTwoBytes2;
        this.internalClient = str2;
        this.protocol = protocol;
        this.description = str3;
    }

    public String getDescription() {
        String str = this.description;
        return str == null ? "-" : str;
    }

    public UnsignedIntegerTwoBytes getExternalPort() {
        return this.externalPort;
    }

    public String getInternalClient() {
        return this.internalClient;
    }

    public UnsignedIntegerTwoBytes getInternalPort() {
        return this.internalPort;
    }

    public UnsignedIntegerFourBytes getLeaseDurationSeconds() {
        return this.leaseDurationSeconds;
    }

    public Protocol getProtocol() {
        return this.protocol;
    }

    public String getRemoteHost() {
        String str = this.remoteHost;
        return str == null ? "-" : str;
    }

    public boolean hasDescription() {
        return this.description != null;
    }

    public boolean hasRemoteHost() {
        String str = this.remoteHost;
        return str != null && str.length() > 0;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setDescription(String str) {
        if (str == null || str.equals("-") || str.length() == 0) {
            str = null;
        }
        this.description = str;
    }

    public void setEnabled(boolean z) {
        this.enabled = z;
    }

    public void setExternalPort(UnsignedIntegerTwoBytes unsignedIntegerTwoBytes) {
        this.externalPort = unsignedIntegerTwoBytes;
    }

    public void setInternalClient(String str) {
        this.internalClient = str;
    }

    public void setInternalPort(UnsignedIntegerTwoBytes unsignedIntegerTwoBytes) {
        this.internalPort = unsignedIntegerTwoBytes;
    }

    public void setLeaseDurationSeconds(UnsignedIntegerFourBytes unsignedIntegerFourBytes) {
        this.leaseDurationSeconds = unsignedIntegerFourBytes;
    }

    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }

    public void setRemoteHost(String str) {
        if (str == null || str.equals("-") || str.length() == 0) {
            str = null;
        }
        this.remoteHost = str;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(PortMapping.class.getSimpleName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(") Protocol: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getProtocol());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getExternalPort());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" => ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getInternalClient());
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
