package org.fourthline.cling.android;

import java.lang.reflect.Field;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.tvspark.outline;
import org.fourthline.cling.transport.impl.NetworkAddressFactoryImpl;
import org.fourthline.cling.transport.spi.InitializationException;

/* loaded from: classes5.dex */
public class AndroidNetworkAddressFactory extends NetworkAddressFactoryImpl {
    public static final Logger log = Logger.getLogger(AndroidUpnpServiceConfiguration.class.getName());

    public AndroidNetworkAddressFactory(int i) {
        super(i);
    }

    @Override // org.fourthline.cling.transport.impl.NetworkAddressFactoryImpl
    public void discoverNetworkInterfaces() throws InitializationException {
        try {
            super.discoverNetworkInterfaces();
        } catch (Exception e) {
            Logger logger = log;
            logger.warning("Exception while enumerating network interfaces, trying once more: " + e);
            super.discoverNetworkInterfaces();
        }
    }

    @Override // org.fourthline.cling.transport.impl.NetworkAddressFactoryImpl, org.fourthline.cling.transport.spi.NetworkAddressFactory
    public InetAddress getLocalAddress(NetworkInterface networkInterface, boolean z, InetAddress inetAddress) {
        for (InetAddress inetAddress2 : getInetAddresses(networkInterface)) {
            if (z && (inetAddress2 instanceof Inet6Address)) {
                return inetAddress2;
            }
            if (!z && (inetAddress2 instanceof Inet4Address)) {
                return inetAddress2;
            }
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Can't find any IPv4 or IPv6 address on interface: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(networkInterface.getDisplayName());
        throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    @Override // org.fourthline.cling.transport.impl.NetworkAddressFactoryImpl
    public boolean isUsableAddress(NetworkInterface networkInterface, InetAddress inetAddress) {
        Field declaredField;
        Object obj;
        boolean isUsableAddress = super.isUsableAddress(networkInterface, inetAddress);
        if (isUsableAddress) {
            String hostAddress = inetAddress.getHostAddress();
            try {
                try {
                    Field declaredField2 = InetAddress.class.getDeclaredField("holder");
                    declaredField2.setAccessible(true);
                    obj = declaredField2.get(inetAddress);
                    declaredField = obj.getClass().getDeclaredField("hostName");
                } catch (NoSuchFieldException unused) {
                    declaredField = InetAddress.class.getDeclaredField("hostName");
                    obj = inetAddress;
                }
                if (declaredField == null || hostAddress == null) {
                    return false;
                }
                declaredField.setAccessible(true);
                declaredField.set(obj, hostAddress);
            } catch (Exception e) {
                Logger logger = log;
                Level level = Level.SEVERE;
                logger.log(level, "Failed injecting hostName to work around Android InetAddress DNS bug: " + inetAddress, (Throwable) e);
                return false;
            }
        }
        return isUsableAddress;
    }

    @Override // org.fourthline.cling.transport.impl.NetworkAddressFactoryImpl
    public boolean requiresNetworkInterface() {
        return false;
    }
}
