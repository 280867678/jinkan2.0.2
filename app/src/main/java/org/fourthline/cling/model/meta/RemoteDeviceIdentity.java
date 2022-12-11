package org.fourthline.cling.model.meta;

import java.net.InetAddress;
import java.net.URL;
import me.tvspark.outline;
import org.fourthline.cling.model.ModelUtil;
import org.fourthline.cling.model.message.discovery.IncomingNotificationRequest;
import org.fourthline.cling.model.message.discovery.IncomingSearchResponse;
import org.fourthline.cling.model.types.UDN;

/* loaded from: classes5.dex */
public class RemoteDeviceIdentity extends DeviceIdentity {
    public final URL descriptorURL;
    public final InetAddress discoveredOnLocalAddress;
    public final byte[] interfaceMacAddress;

    public RemoteDeviceIdentity(IncomingNotificationRequest incomingNotificationRequest) {
        this(incomingNotificationRequest.getUDN(), incomingNotificationRequest.getMaxAge(), incomingNotificationRequest.getLocationURL(), incomingNotificationRequest.getInterfaceMacHeader(), incomingNotificationRequest.getLocalAddress());
    }

    public RemoteDeviceIdentity(IncomingSearchResponse incomingSearchResponse) {
        this(incomingSearchResponse.getRootDeviceUDN(), incomingSearchResponse.getMaxAge(), incomingSearchResponse.getLocationURL(), incomingSearchResponse.getInterfaceMacHeader(), incomingSearchResponse.getLocalAddress());
    }

    public RemoteDeviceIdentity(UDN udn, Integer num, URL url, byte[] bArr, InetAddress inetAddress) {
        super(udn, num);
        this.descriptorURL = url;
        this.interfaceMacAddress = bArr;
        this.discoveredOnLocalAddress = inetAddress;
    }

    public RemoteDeviceIdentity(UDN udn, RemoteDeviceIdentity remoteDeviceIdentity) {
        this(udn, remoteDeviceIdentity.getMaxAgeSeconds(), remoteDeviceIdentity.getDescriptorURL(), remoteDeviceIdentity.getInterfaceMacAddress(), remoteDeviceIdentity.getDiscoveredOnLocalAddress());
    }

    public URL getDescriptorURL() {
        return this.descriptorURL;
    }

    public InetAddress getDiscoveredOnLocalAddress() {
        return this.discoveredOnLocalAddress;
    }

    public byte[] getInterfaceMacAddress() {
        return this.interfaceMacAddress;
    }

    public byte[] getWakeOnLANBytes() {
        if (getInterfaceMacAddress() == null) {
            return null;
        }
        int i = 6;
        int length = (getInterfaceMacAddress().length * 16) + 6;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < 6; i2++) {
            bArr[i2] = -1;
        }
        while (i < length) {
            System.arraycopy(getInterfaceMacAddress(), 0, bArr, i, getInterfaceMacAddress().length);
            i += getInterfaceMacAddress().length;
        }
        return bArr;
    }

    @Override // org.fourthline.cling.model.meta.DeviceIdentity
    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        String str;
        if (ModelUtil.ANDROID_RUNTIME) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new StringBuilder();
            str = "(RemoteDeviceIdentity) UDN: ";
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(RemoteDeviceIdentity.class.getSimpleName());
            str = ") UDN: ";
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getUdn());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", Descriptor: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getDescriptorURL());
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
