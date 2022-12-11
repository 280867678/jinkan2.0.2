package org.fourthline.cling.transport.impl;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.tvspark.outline;
import org.fourthline.cling.model.UnsupportedDataException;
import org.fourthline.cling.model.message.OutgoingDatagramMessage;
import org.fourthline.cling.transport.Router;
import org.fourthline.cling.transport.spi.DatagramIO;
import org.fourthline.cling.transport.spi.DatagramProcessor;
import org.fourthline.cling.transport.spi.InitializationException;

/* loaded from: classes5.dex */
public class DatagramIOImpl implements DatagramIO<DatagramIOConfigurationImpl> {
    public static Logger log = Logger.getLogger(DatagramIO.class.getName());
    public final DatagramIOConfigurationImpl configuration;
    public DatagramProcessor datagramProcessor;
    public InetSocketAddress localAddress;
    public Router router;
    public MulticastSocket socket;

    public DatagramIOImpl(DatagramIOConfigurationImpl datagramIOConfigurationImpl) {
        this.configuration = datagramIOConfigurationImpl;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.fourthline.cling.transport.spi.DatagramIO
    /* renamed from: getConfiguration */
    public DatagramIOConfigurationImpl mo5226getConfiguration() {
        return this.configuration;
    }

    @Override // org.fourthline.cling.transport.spi.DatagramIO
    public synchronized void init(InetAddress inetAddress, Router router, DatagramProcessor datagramProcessor) throws InitializationException {
        this.router = router;
        this.datagramProcessor = datagramProcessor;
        try {
            Logger logger = log;
            logger.info("Creating bound socket (for datagram input/output) on: " + inetAddress);
            this.localAddress = new InetSocketAddress(inetAddress, 0);
            MulticastSocket multicastSocket = new MulticastSocket(this.localAddress);
            this.socket = multicastSocket;
            multicastSocket.setTimeToLive(this.configuration.getTimeToLive());
            this.socket.setReceiveBufferSize(262144);
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
                int maxDatagramBytes = mo5226getConfiguration().getMaxDatagramBytes();
                DatagramPacket datagramPacket = new DatagramPacket(new byte[maxDatagramBytes], maxDatagramBytes);
                this.socket.receive(datagramPacket);
                Logger logger2 = log;
                logger2.fine("UDP datagram received from: " + datagramPacket.getAddress().getHostAddress() + ":" + datagramPacket.getPort() + " on: " + this.localAddress);
                this.router.received(this.datagramProcessor.read(this.localAddress.getAddress(), datagramPacket));
            } catch (SocketException unused) {
                log.fine("Socket closed");
                try {
                    if (this.socket.isClosed()) {
                        return;
                    }
                    log.fine("Closing unicast socket");
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

    @Override // org.fourthline.cling.transport.spi.DatagramIO
    public synchronized void send(DatagramPacket datagramPacket) {
        if (log.isLoggable(Level.FINE)) {
            Logger logger = log;
            logger.fine("Sending message from address: " + this.localAddress);
        }
        try {
            this.socket.send(datagramPacket);
        } catch (RuntimeException e) {
            throw e;
        } catch (SocketException unused) {
            Logger logger2 = log;
            logger2.fine("Socket closed, aborting datagram send to: " + datagramPacket.getAddress());
        } catch (Exception e2) {
            Logger logger3 = log;
            Level level = Level.SEVERE;
            logger3.log(level, "Exception sending datagram to: " + datagramPacket.getAddress() + ": " + e2, (Throwable) e2);
        }
    }

    @Override // org.fourthline.cling.transport.spi.DatagramIO
    public synchronized void send(OutgoingDatagramMessage outgoingDatagramMessage) {
        if (log.isLoggable(Level.FINE)) {
            Logger logger = log;
            logger.fine("Sending message from address: " + this.localAddress);
        }
        DatagramPacket write = this.datagramProcessor.write(outgoingDatagramMessage);
        if (log.isLoggable(Level.FINE)) {
            Logger logger2 = log;
            logger2.fine("Sending UDP datagram packet to: " + outgoingDatagramMessage.getDestinationAddress() + ":" + outgoingDatagramMessage.getDestinationPort());
        }
        send(write);
    }

    @Override // org.fourthline.cling.transport.spi.DatagramIO
    public synchronized void stop() {
        if (this.socket != null && !this.socket.isClosed()) {
            this.socket.close();
        }
    }
}
