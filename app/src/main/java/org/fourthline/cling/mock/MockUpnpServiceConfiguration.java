package org.fourthline.cling.mock;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import javax.enterprise.inject.Alternative;
import org.fourthline.cling.DefaultUpnpServiceConfiguration;
import org.fourthline.cling.transport.impl.NetworkAddressFactoryImpl;
import org.fourthline.cling.transport.spi.NetworkAddressFactory;

@Alternative
/* loaded from: classes5.dex */
public class MockUpnpServiceConfiguration extends DefaultUpnpServiceConfiguration {
    public final boolean maintainsRegistry;
    public final boolean multiThreaded;

    public MockUpnpServiceConfiguration() {
        this(false, false);
    }

    public MockUpnpServiceConfiguration(boolean z) {
        this(z, false);
    }

    public MockUpnpServiceConfiguration(boolean z, boolean z2) {
        super(false);
        this.maintainsRegistry = z;
        this.multiThreaded = z2;
    }

    @Override // org.fourthline.cling.DefaultUpnpServiceConfiguration
    public NetworkAddressFactory createNetworkAddressFactory(int i) {
        return new NetworkAddressFactoryImpl(i) { // from class: org.fourthline.cling.mock.MockUpnpServiceConfiguration.1
            @Override // org.fourthline.cling.transport.impl.NetworkAddressFactoryImpl
            public boolean isUsableAddress(NetworkInterface networkInterface, InetAddress inetAddress) {
                return inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address);
            }

            @Override // org.fourthline.cling.transport.impl.NetworkAddressFactoryImpl
            public boolean isUsableNetworkInterface(NetworkInterface networkInterface) throws Exception {
                return networkInterface.isLoopback();
            }
        };
    }

    @Override // org.fourthline.cling.DefaultUpnpServiceConfiguration
    public ExecutorService getDefaultExecutorService() {
        return isMultiThreaded() ? super.getDefaultExecutorService() : new AbstractExecutorService() { // from class: org.fourthline.cling.mock.MockUpnpServiceConfiguration.3
            public boolean terminated;

            @Override // java.util.concurrent.ExecutorService
            public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
                shutdown();
                return this.terminated;
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                runnable.run();
            }

            @Override // java.util.concurrent.ExecutorService
            public boolean isShutdown() {
                return this.terminated;
            }

            @Override // java.util.concurrent.ExecutorService
            public boolean isTerminated() {
                return this.terminated;
            }

            @Override // java.util.concurrent.ExecutorService
            public void shutdown() {
                this.terminated = true;
            }

            @Override // java.util.concurrent.ExecutorService
            public List<Runnable> shutdownNow() {
                shutdown();
                return null;
            }
        };
    }

    @Override // org.fourthline.cling.DefaultUpnpServiceConfiguration, org.fourthline.cling.UpnpServiceConfiguration
    public Executor getRegistryMaintainerExecutor() {
        return isMaintainsRegistry() ? new Executor() { // from class: org.fourthline.cling.mock.MockUpnpServiceConfiguration.2
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                new Thread(runnable).start();
            }
        } : getDefaultExecutorService();
    }

    public boolean isMaintainsRegistry() {
        return this.maintainsRegistry;
    }

    public boolean isMultiThreaded() {
        return this.multiThreaded;
    }
}
