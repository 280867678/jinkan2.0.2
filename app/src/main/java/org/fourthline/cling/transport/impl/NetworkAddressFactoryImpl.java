package org.fourthline.cling.transport.impl;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.tvspark.outline;
import org.fourthline.cling.model.Constants;
import org.fourthline.cling.transport.spi.InitializationException;
import org.fourthline.cling.transport.spi.NetworkAddressFactory;
import org.fourthline.cling.transport.spi.NoNetworkException;
import org.seamless.util.Iterators;

/* loaded from: classes5.dex */
public class NetworkAddressFactoryImpl implements NetworkAddressFactory {
    public static final int DEFAULT_TCP_HTTP_LISTEN_PORT = 0;
    public static Logger log = Logger.getLogger(NetworkAddressFactoryImpl.class.getName());
    public final List<InetAddress> bindAddresses;
    public final List<NetworkInterface> networkInterfaces;
    public int streamListenPort;
    public final Set<String> useAddresses;
    public final Set<String> useInterfaces;

    public NetworkAddressFactoryImpl() throws InitializationException {
        this(0);
    }

    public NetworkAddressFactoryImpl(int i) throws InitializationException {
        this.useInterfaces = new HashSet();
        this.useAddresses = new HashSet();
        this.networkInterfaces = new ArrayList();
        this.bindAddresses = new ArrayList();
        System.setProperty("java.net.preferIPv4Stack", "true");
        String property = System.getProperty(NetworkAddressFactory.SYSTEM_PROPERTY_NET_IFACES);
        if (property != null) {
            this.useInterfaces.addAll(Arrays.asList(property.split(",")));
        }
        String property2 = System.getProperty(NetworkAddressFactory.SYSTEM_PROPERTY_NET_ADDRESSES);
        if (property2 != null) {
            this.useAddresses.addAll(Arrays.asList(property2.split(",")));
        }
        discoverNetworkInterfaces();
        discoverBindAddresses();
        if (this.networkInterfaces.size() == 0 || this.bindAddresses.size() == 0) {
            log.warning("No usable network interface or addresses found");
            if (requiresNetworkInterface()) {
                throw new NoNetworkException("Could not discover any usable network interfaces and/or addresses");
            }
        }
        this.streamListenPort = i;
    }

    public void discoverBindAddresses() throws InitializationException {
        try {
            synchronized (this.networkInterfaces) {
                Iterator<NetworkInterface> it = this.networkInterfaces.iterator();
                while (it.hasNext()) {
                    NetworkInterface next = it.next();
                    Logger logger = log;
                    logger.finer("Discovering addresses of interface: " + next.getDisplayName());
                    int i = 0;
                    for (InetAddress inetAddress : getInetAddresses(next)) {
                        if (inetAddress == null) {
                            Logger logger2 = log;
                            logger2.warning("Network has a null address: " + next.getDisplayName());
                        } else if (isUsableAddress(next, inetAddress)) {
                            Logger logger3 = log;
                            logger3.fine("Discovered usable network interface address: " + inetAddress.getHostAddress());
                            i++;
                            synchronized (this.bindAddresses) {
                                this.bindAddresses.add(inetAddress);
                            }
                        } else {
                            Logger logger4 = log;
                            logger4.finer("Ignoring non-usable network interface address: " + inetAddress.getHostAddress());
                        }
                    }
                    if (i == 0) {
                        Logger logger5 = log;
                        logger5.finer("Network interface has no usable addresses, removing: " + next.getDisplayName());
                        it.remove();
                    }
                }
            }
        } catch (Exception e) {
            throw new InitializationException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Could not not analyze local network interfaces: ", e), e);
        }
    }

    public void discoverNetworkInterfaces() throws InitializationException {
        try {
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) it.next();
                Logger logger = log;
                logger.finer("Analyzing network interface: " + networkInterface.getDisplayName());
                if (isUsableNetworkInterface(networkInterface)) {
                    Logger logger2 = log;
                    logger2.fine("Discovered usable network interface: " + networkInterface.getDisplayName());
                    synchronized (this.networkInterfaces) {
                        this.networkInterfaces.add(networkInterface);
                    }
                } else {
                    Logger logger3 = log;
                    logger3.finer("Ignoring non-usable network interface: " + networkInterface.getDisplayName());
                }
            }
        } catch (Exception e) {
            throw new InitializationException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Could not not analyze local network interfaces: ", e), e);
        }
    }

    @Override // org.fourthline.cling.transport.spi.NetworkAddressFactory
    public Short getAddressNetworkPrefixLength(InetAddress inetAddress) {
        synchronized (this.networkInterfaces) {
            for (NetworkInterface networkInterface : this.networkInterfaces) {
                for (InterfaceAddress interfaceAddress : getInterfaceAddresses(networkInterface)) {
                    if (interfaceAddress != null && interfaceAddress.getAddress().equals(inetAddress)) {
                        short networkPrefixLength = interfaceAddress.getNetworkPrefixLength();
                        if (networkPrefixLength <= 0 || networkPrefixLength >= 32) {
                            return null;
                        }
                        return Short.valueOf(networkPrefixLength);
                    }
                }
            }
            return null;
        }
    }

    public InetAddress getBindAddressInSubnetOf(InetAddress inetAddress) {
        synchronized (this.networkInterfaces) {
            for (NetworkInterface networkInterface : this.networkInterfaces) {
                for (InterfaceAddress interfaceAddress : getInterfaceAddresses(networkInterface)) {
                    synchronized (this.bindAddresses) {
                        if (interfaceAddress != null && this.bindAddresses.contains(interfaceAddress.getAddress())) {
                            if (isInSubnet(inetAddress.getAddress(), interfaceAddress.getAddress().getAddress(), interfaceAddress.getNetworkPrefixLength())) {
                                return interfaceAddress.getAddress();
                            }
                        }
                    }
                }
            }
            return null;
        }
    }

    @Override // org.fourthline.cling.transport.spi.NetworkAddressFactory
    public Iterator<InetAddress> getBindAddresses() {
        return new Iterators.Synchronized<InetAddress>(this.bindAddresses) { // from class: org.fourthline.cling.transport.impl.NetworkAddressFactoryImpl.2
            @Override // org.seamless.util.Iterators.Synchronized
            public void synchronizedRemove(int i) {
                synchronized (NetworkAddressFactoryImpl.this.bindAddresses) {
                    NetworkAddressFactoryImpl.this.bindAddresses.remove(i);
                }
            }
        };
    }

    @Override // org.fourthline.cling.transport.spi.NetworkAddressFactory
    public InetAddress getBroadcastAddress(InetAddress inetAddress) {
        synchronized (this.networkInterfaces) {
            for (NetworkInterface networkInterface : this.networkInterfaces) {
                for (InterfaceAddress interfaceAddress : getInterfaceAddresses(networkInterface)) {
                    if (interfaceAddress != null && interfaceAddress.getAddress().equals(inetAddress)) {
                        return interfaceAddress.getBroadcast();
                    }
                }
            }
            return null;
        }
    }

    @Override // org.fourthline.cling.transport.spi.NetworkAddressFactory
    public byte[] getHardwareAddress(InetAddress inetAddress) {
        try {
            NetworkInterface byInetAddress = NetworkInterface.getByInetAddress(inetAddress);
            if (byInetAddress == null) {
                return null;
            }
            return byInetAddress.getHardwareAddress();
        } catch (Throwable th) {
            Logger logger = log;
            Level level = Level.WARNING;
            logger.log(level, "Cannot get hardware address for: " + inetAddress, th);
            return null;
        }
    }

    public List<InetAddress> getInetAddresses(NetworkInterface networkInterface) {
        return Collections.list(networkInterface.getInetAddresses());
    }

    public List<InterfaceAddress> getInterfaceAddresses(NetworkInterface networkInterface) {
        return networkInterface.getInterfaceAddresses();
    }

    @Override // org.fourthline.cling.transport.spi.NetworkAddressFactory
    public InetAddress getLocalAddress(NetworkInterface networkInterface, boolean z, InetAddress inetAddress) {
        InetAddress bindAddressInSubnetOf = getBindAddressInSubnetOf(inetAddress);
        if (bindAddressInSubnetOf != null) {
            return bindAddressInSubnetOf;
        }
        Logger logger = log;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Could not find local bind address in same subnet as: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(inetAddress.getHostAddress());
        logger.finer(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        for (InetAddress inetAddress2 : getInetAddresses(networkInterface)) {
            if (z && (inetAddress2 instanceof Inet6Address)) {
                return inetAddress2;
            }
            if (!z && (inetAddress2 instanceof Inet4Address)) {
                return inetAddress2;
            }
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Can't find any IPv4 or IPv6 address on interface: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(networkInterface.getDisplayName());
        throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
    }

    @Override // org.fourthline.cling.transport.spi.NetworkAddressFactory
    public InetAddress getMulticastGroup() {
        try {
            return InetAddress.getByName(Constants.IPV4_UPNP_MULTICAST_GROUP);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // org.fourthline.cling.transport.spi.NetworkAddressFactory
    public int getMulticastPort() {
        return Constants.UPNP_MULTICAST_PORT;
    }

    @Override // org.fourthline.cling.transport.spi.NetworkAddressFactory
    public Iterator<NetworkInterface> getNetworkInterfaces() {
        return new Iterators.Synchronized<NetworkInterface>(this.networkInterfaces) { // from class: org.fourthline.cling.transport.impl.NetworkAddressFactoryImpl.1
            @Override // org.seamless.util.Iterators.Synchronized
            public void synchronizedRemove(int i) {
                synchronized (NetworkAddressFactoryImpl.this.networkInterfaces) {
                    NetworkAddressFactoryImpl.this.networkInterfaces.remove(i);
                }
            }
        };
    }

    @Override // org.fourthline.cling.transport.spi.NetworkAddressFactory
    public int getStreamListenPort() {
        return this.streamListenPort;
    }

    @Override // org.fourthline.cling.transport.spi.NetworkAddressFactory
    public boolean hasUsableNetwork() {
        return this.networkInterfaces.size() > 0 && this.bindAddresses.size() > 0;
    }

    public boolean isInSubnet(byte[] bArr, byte[] bArr2, short s) {
        if (bArr.length == bArr2.length && s / 8 <= bArr.length) {
            int i = 0;
            while (s >= 8 && i < bArr.length) {
                if (bArr[i] != bArr2[i]) {
                    return false;
                }
                i++;
                s = (short) (s - 8);
            }
            if (i == bArr.length) {
                return true;
            }
            byte b = (byte) (~((1 << (8 - s)) - 1));
            return (bArr[i] & b) == (bArr2[i] & b);
        }
        return false;
    }

    public boolean isUsableAddress(NetworkInterface networkInterface, InetAddress inetAddress) {
        Logger logger;
        StringBuilder sb;
        String str;
        if (!(inetAddress instanceof Inet4Address)) {
            logger = log;
            sb = new StringBuilder();
            str = "Skipping unsupported non-IPv4 address: ";
        } else if (inetAddress.isLoopbackAddress()) {
            logger = log;
            sb = new StringBuilder();
            str = "Skipping loopback address: ";
        } else if (this.useAddresses.size() <= 0 || this.useAddresses.contains(inetAddress.getHostAddress())) {
            return true;
        } else {
            logger = log;
            sb = new StringBuilder();
            str = "Skipping unwanted address: ";
        }
        sb.append(str);
        sb.append(inetAddress);
        logger.finer(sb.toString());
        return false;
    }

    public boolean isUsableNetworkInterface(NetworkInterface networkInterface) throws Exception {
        Logger logger;
        StringBuilder sb;
        String str;
        String name;
        if (!networkInterface.isUp()) {
            logger = log;
            sb = new StringBuilder();
            str = "Skipping network interface (down): ";
        } else if (getInetAddresses(networkInterface).size() == 0) {
            logger = log;
            sb = new StringBuilder();
            str = "Skipping network interface without bound IP addresses: ";
        } else if (networkInterface.getName().toLowerCase(Locale.ROOT).startsWith("vmnet") || (networkInterface.getDisplayName() != null && networkInterface.getDisplayName().toLowerCase(Locale.ROOT).contains("vmnet"))) {
            logger = log;
            sb = new StringBuilder();
            str = "Skipping network interface (VMWare): ";
        } else if (networkInterface.getName().toLowerCase(Locale.ROOT).startsWith("vnic")) {
            logger = log;
            sb = new StringBuilder();
            str = "Skipping network interface (Parallels): ";
        } else if (networkInterface.getName().toLowerCase(Locale.ROOT).startsWith("vboxnet")) {
            logger = log;
            sb = new StringBuilder();
            str = "Skipping network interface (Virtual Box): ";
        } else if (networkInterface.getName().toLowerCase(Locale.ROOT).contains("virtual")) {
            logger = log;
            sb = new StringBuilder();
            str = "Skipping network interface (named '*virtual*'): ";
        } else if (networkInterface.getName().toLowerCase(Locale.ROOT).startsWith("ppp")) {
            logger = log;
            sb = new StringBuilder();
            str = "Skipping network interface (PPP): ";
        } else if (!networkInterface.isLoopback()) {
            if (this.useInterfaces.size() > 0 && !this.useInterfaces.contains(networkInterface.getName())) {
                logger = log;
                sb = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Skipping unwanted network interface (-Dorg.fourthline.cling.network.useInterfaces): ");
                name = networkInterface.getName();
                sb.append(name);
                logger.finer(sb.toString());
                return false;
            } else if (networkInterface.supportsMulticast()) {
                return true;
            } else {
                Logger logger2 = log;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Network interface may not be multicast capable: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(networkInterface.getDisplayName());
                logger2.warning(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                return true;
            }
        } else {
            logger = log;
            sb = new StringBuilder();
            str = "Skipping network interface (ignoring loopback): ";
        }
        sb.append(str);
        name = networkInterface.getDisplayName();
        sb.append(name);
        logger.finer(sb.toString());
        return false;
    }

    @Override // org.fourthline.cling.transport.spi.NetworkAddressFactory
    public void logInterfaceInformation() {
        synchronized (this.networkInterfaces) {
            if (this.networkInterfaces.isEmpty()) {
                log.info("No network interface to display!");
                return;
            }
            for (NetworkInterface networkInterface : this.networkInterfaces) {
                try {
                    logInterfaceInformation(networkInterface);
                } catch (SocketException e) {
                    log.log(Level.WARNING, "Exception while logging network interface information", (Throwable) e);
                }
            }
        }
    }

    public void logInterfaceInformation(NetworkInterface networkInterface) throws SocketException {
        log.info("---------------------------------------------------------------------------------");
        log.info(String.format("Interface display name: %s", networkInterface.getDisplayName()));
        if (networkInterface.getParent() != null) {
            log.info(String.format("Parent Info: %s", networkInterface.getParent()));
        }
        log.info(String.format("Name: %s", networkInterface.getName()));
        Iterator it = Collections.list(networkInterface.getInetAddresses()).iterator();
        while (it.hasNext()) {
            log.info(String.format("InetAddress: %s", (InetAddress) it.next()));
        }
        for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) {
            if (interfaceAddress == null) {
                log.warning("Skipping null InterfaceAddress!");
            } else {
                log.info(" Interface Address");
                Logger logger = log;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("  Address: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(interfaceAddress.getAddress());
                logger.info(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                Logger logger2 = log;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("  Broadcast: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(interfaceAddress.getBroadcast());
                logger2.info(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                Logger logger3 = log;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("  Prefix length: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append((int) interfaceAddress.getNetworkPrefixLength());
                logger3.info(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
            }
        }
        Iterator it2 = Collections.list(networkInterface.getSubInterfaces()).iterator();
        while (it2.hasNext()) {
            NetworkInterface networkInterface2 = (NetworkInterface) it2.next();
            if (networkInterface2 == null) {
                log.warning("Skipping null NetworkInterface sub-interface");
            } else {
                log.info(String.format("\tSub Interface Display name: %s", networkInterface2.getDisplayName()));
                log.info(String.format("\tSub Interface Name: %s", networkInterface2.getName()));
            }
        }
        log.info(String.format("Up? %s", Boolean.valueOf(networkInterface.isUp())));
        log.info(String.format("Loopback? %s", Boolean.valueOf(networkInterface.isLoopback())));
        log.info(String.format("PointToPoint? %s", Boolean.valueOf(networkInterface.isPointToPoint())));
        log.info(String.format("Supports multicast? %s", Boolean.valueOf(networkInterface.supportsMulticast())));
        log.info(String.format("Virtual? %s", Boolean.valueOf(networkInterface.isVirtual())));
        log.info(String.format("Hardware address: %s", Arrays.toString(networkInterface.getHardwareAddress())));
        log.info(String.format("MTU: %s", Integer.valueOf(networkInterface.getMTU())));
    }

    public boolean requiresNetworkInterface() {
        return true;
    }
}
