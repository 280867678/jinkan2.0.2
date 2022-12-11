package org.fourthline.cling.transport.spi;

import java.net.InetAddress;
import org.fourthline.cling.transport.Router;
import org.fourthline.cling.transport.spi.StreamServerConfiguration;

/* loaded from: classes5.dex */
public interface StreamServer<C extends StreamServerConfiguration> extends Runnable {
    /* renamed from: getConfiguration */
    C mo5229getConfiguration();

    int getPort();

    void init(InetAddress inetAddress, Router router) throws InitializationException;

    void stop();
}
