package org.fourthline.cling.transport.impl;

import java.net.DatagramPacket;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.logging.Logger;
import me.tvspark.outline;
import org.fourthline.cling.model.UnsupportedDataException;
import org.fourthline.cling.transport.Router;
import org.fourthline.cling.transport.spi.DatagramProcessor;
import org.fourthline.cling.transport.spi.InitializationException;
import org.fourthline.cling.transport.spi.MulticastReceiver;
import org.fourthline.cling.transport.spi.NetworkAddressFactory;

/* loaded from: classes5.dex */
public class MulticastReceiverImpl implements MulticastReceiver<MulticastReceiverConfigurationImpl> {
    public static Logger log = Logger.getLogger(MulticastReceiver.class.getName());
    public final MulticastReceiverConfigurationImpl configuration;
    public DatagramProcessor datagramProcessor;
    public InetSocketAddress multicastAddress;
    public NetworkInterface multicastInterface;
    public NetworkAddressFactory networkAddressFactory;
    public Router router;
    public MulticastSocket socket;

    public MulticastReceiverImpl(MulticastReceiverConfigurationImpl multicastReceiverConfigurationImpl) {
        this.configuration = multicastReceiverConfigurationImpl;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.fourthline.cling.transport.spi.MulticastReceiver
    /* renamed from: getConfiguration */
    public MulticastReceiverConfigurationImpl mo5227getConfiguration() {
        return this.configuration;
    }

    @Override // org.fourthline.cling.transport.spi.MulticastReceiver
    public synchronized void init(NetworkInterface networkInterface, Router router, NetworkAddressFactory networkAddressFactory, DatagramProcessor datagramProcessor) throws InitializationException {
        this.router = router;
        this.networkAddressFactory = networkAddressFactory;
        this.datagramProcessor = datagramProcessor;
        this.multicastInterface = networkInterface;
        try {
            Logger logger = log;
            logger.info("Creating wildcard socket (for receiving multicast datagrams) on port: " + this.configuration.getPort());
            this.multicastAddress = new InetSocketAddress(this.configuration.getGroup(), this.configuration.getPort());
            MulticastSocket multicastSocket = new MulticastSocket(this.configuration.getPort());
            this.socket = multicastSocket;
            multicastSocket.setReuseAddress(true);
            this.socket.setReceiveBufferSize(32768);
            Logger logger2 = log;
            logger2.info("Joining multicast group: " + this.multicastAddress + " on network interface: " + this.multicastInterface.getDisplayName());
            this.socket.joinGroup(this.multicastAddress, this.multicastInterface);
        } catch (Exception e) {
            throw new InitializationException("Could not initialize " + getClass().getSimpleName() + ": " + e);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Logger logger = log;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Entering blocking receiving loop, listening for UDP datagrams on: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.socket.getLocalAddress());
        logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        while (true) {
            try {
                int maxDatagramBytes = mo5227getConfiguration().getMaxDatagramBytes();
                DatagramPacket datagramPacket = new DatagramPacket(new byte[maxDatagramBytes], maxDatagramBytes);
                this.socket.receive(datagramPacket);
                InetAddress localAddress = this.networkAddressFactory.getLocalAddress(this.multicastInterface, this.multicastAddress.getAddress() instanceof Inet6Address, datagramPacket.getAddress());
                Logger logger2 = log;
                logger2.fine("UDP datagram received from: " + datagramPacket.getAddress().getHostAddress() + ":" + datagramPacket.getPort() + " on local interface: " + this.multicastInterface.getDisplayName() + " and address: " + localAddress.getHostAddress());
                this.router.received(this.datagramProcessor.read(localAddress, datagramPacket));
            } catch (SocketException unused) {
                log.fine("Socket closed");
                try {
                    if (this.socket.isClosed()) {
                        return;
                    }
                    log.fine("Closing multicast socket");
                    this.socket.close();
                    return;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } catch (UnsupportedDataException e2) {
                Logger logger3 = log;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Could not read datagram: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(e2.getMessage());
                logger3.info(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
            } catch (Exception e3) {
                throw new RuntimeException(e3);
            }
        }
    }

    @Override // org.fourthline.cling.transport.spi.MulticastReceiver
    public synchronized void stop() {
        if (this.socket != null && !this.socket.isClosed()) {
            try {
                log.fine("Leaving multicast group");
                this.socket.leaveGroup(this.multicastAddress, this.multicastInterface);
            } catch (Exception e) {
                Logger logger = log;
                logger.fine("Could not leave multicast group: " + e);
            }
            this.socket.close();
        }
    }
}
