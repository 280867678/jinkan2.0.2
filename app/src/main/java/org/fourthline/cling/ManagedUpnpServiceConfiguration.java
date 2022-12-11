package org.fourthline.cling;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.fourthline.cling.DefaultUpnpServiceConfiguration;
import org.fourthline.cling.binding.xml.DeviceDescriptorBinder;
import org.fourthline.cling.binding.xml.ServiceDescriptorBinder;
import org.fourthline.cling.binding.xml.UDA10DeviceDescriptorBinderImpl;
import org.fourthline.cling.binding.xml.UDA10ServiceDescriptorBinderImpl;
import org.fourthline.cling.model.ModelUtil;
import org.fourthline.cling.model.Namespace;
import org.fourthline.cling.model.message.UpnpHeaders;
import org.fourthline.cling.model.meta.RemoteDeviceIdentity;
import org.fourthline.cling.model.meta.RemoteService;
import org.fourthline.cling.model.types.ServiceType;
import org.fourthline.cling.transport.impl.DatagramIOConfigurationImpl;
import org.fourthline.cling.transport.impl.DatagramIOImpl;
import org.fourthline.cling.transport.impl.GENAEventProcessorImpl;
import org.fourthline.cling.transport.impl.MulticastReceiverConfigurationImpl;
import org.fourthline.cling.transport.impl.MulticastReceiverImpl;
import org.fourthline.cling.transport.impl.NetworkAddressFactoryImpl;
import org.fourthline.cling.transport.impl.SOAPActionProcessorImpl;
import org.fourthline.cling.transport.impl.StreamClientConfigurationImpl;
import org.fourthline.cling.transport.impl.StreamClientImpl;
import org.fourthline.cling.transport.impl.StreamServerConfigurationImpl;
import org.fourthline.cling.transport.impl.StreamServerImpl;
import org.fourthline.cling.transport.spi.DatagramIO;
import org.fourthline.cling.transport.spi.DatagramProcessor;
import org.fourthline.cling.transport.spi.GENAEventProcessor;
import org.fourthline.cling.transport.spi.MulticastReceiver;
import org.fourthline.cling.transport.spi.NetworkAddressFactory;
import org.fourthline.cling.transport.spi.SOAPActionProcessor;
import org.fourthline.cling.transport.spi.StreamClient;
import org.fourthline.cling.transport.spi.StreamServer;

@ApplicationScoped
/* loaded from: classes5.dex */
public class ManagedUpnpServiceConfiguration implements UpnpServiceConfiguration {
    public static Logger log = Logger.getLogger(DefaultUpnpServiceConfiguration.class.getName());
    @Inject
    public DatagramProcessor datagramProcessor;
    public ExecutorService defaultExecutorService;
    public DeviceDescriptorBinder deviceDescriptorBinderUDA10;
    public GENAEventProcessor genaEventProcessor;
    public Namespace namespace;
    public ServiceDescriptorBinder serviceDescriptorBinderUDA10;
    public SOAPActionProcessor soapActionProcessor;
    public int streamListenPort;

    @Override // org.fourthline.cling.UpnpServiceConfiguration
    public DatagramIO createDatagramIO(NetworkAddressFactory networkAddressFactory) {
        return new DatagramIOImpl(new DatagramIOConfigurationImpl());
    }

    public ExecutorService createDefaultExecutorService() {
        return new DefaultUpnpServiceConfiguration.ClingExecutor();
    }

    public DeviceDescriptorBinder createDeviceDescriptorBinderUDA10() {
        return new UDA10DeviceDescriptorBinderImpl();
    }

    public GENAEventProcessor createGENAEventProcessor() {
        return new GENAEventProcessorImpl();
    }

    @Override // org.fourthline.cling.UpnpServiceConfiguration
    public MulticastReceiver createMulticastReceiver(NetworkAddressFactory networkAddressFactory) {
        return new MulticastReceiverImpl(new MulticastReceiverConfigurationImpl(networkAddressFactory.getMulticastGroup(), networkAddressFactory.getMulticastPort()));
    }

    public Namespace createNamespace() {
        return new Namespace();
    }

    @Override // org.fourthline.cling.UpnpServiceConfiguration
    public NetworkAddressFactory createNetworkAddressFactory() {
        return createNetworkAddressFactory(this.streamListenPort);
    }

    public NetworkAddressFactory createNetworkAddressFactory(int i) {
        return new NetworkAddressFactoryImpl(i);
    }

    public SOAPActionProcessor createSOAPActionProcessor() {
        return new SOAPActionProcessorImpl();
    }

    public ServiceDescriptorBinder createServiceDescriptorBinderUDA10() {
        return new UDA10ServiceDescriptorBinderImpl();
    }

    @Override // org.fourthline.cling.UpnpServiceConfiguration
    public StreamClient createStreamClient() {
        return new StreamClientImpl(new StreamClientConfigurationImpl(getSyncProtocolExecutorService()));
    }

    @Override // org.fourthline.cling.UpnpServiceConfiguration
    public StreamServer createStreamServer(NetworkAddressFactory networkAddressFactory) {
        return new StreamServerImpl(new StreamServerConfigurationImpl(networkAddressFactory.getStreamListenPort()));
    }

    @Override // org.fourthline.cling.UpnpServiceConfiguration
    public int getAliveIntervalMillis() {
        return 0;
    }

    @Override // org.fourthline.cling.UpnpServiceConfiguration
    public Executor getAsyncProtocolExecutor() {
        return getDefaultExecutorService();
    }

    @Override // org.fourthline.cling.UpnpServiceConfiguration
    public Executor getDatagramIOExecutor() {
        return getDefaultExecutorService();
    }

    @Override // org.fourthline.cling.UpnpServiceConfiguration
    public DatagramProcessor getDatagramProcessor() {
        return this.datagramProcessor;
    }

    public ExecutorService getDefaultExecutorService() {
        return this.defaultExecutorService;
    }

    @Override // org.fourthline.cling.UpnpServiceConfiguration
    public UpnpHeaders getDescriptorRetrievalHeaders(RemoteDeviceIdentity remoteDeviceIdentity) {
        return null;
    }

    @Override // org.fourthline.cling.UpnpServiceConfiguration
    public DeviceDescriptorBinder getDeviceDescriptorBinderUDA10() {
        return this.deviceDescriptorBinderUDA10;
    }

    @Override // org.fourthline.cling.UpnpServiceConfiguration
    public UpnpHeaders getEventSubscriptionHeaders(RemoteService remoteService) {
        return null;
    }

    @Override // org.fourthline.cling.UpnpServiceConfiguration
    public ServiceType[] getExclusiveServiceTypes() {
        return new ServiceType[0];
    }

    @Override // org.fourthline.cling.UpnpServiceConfiguration
    public GENAEventProcessor getGenaEventProcessor() {
        return this.genaEventProcessor;
    }

    @Override // org.fourthline.cling.UpnpServiceConfiguration
    public Executor getMulticastReceiverExecutor() {
        return getDefaultExecutorService();
    }

    @Override // org.fourthline.cling.UpnpServiceConfiguration
    public Namespace getNamespace() {
        return this.namespace;
    }

    @Override // org.fourthline.cling.UpnpServiceConfiguration
    public Executor getRegistryListenerExecutor() {
        return getDefaultExecutorService();
    }

    @Override // org.fourthline.cling.UpnpServiceConfiguration
    public Executor getRegistryMaintainerExecutor() {
        return getDefaultExecutorService();
    }

    @Override // org.fourthline.cling.UpnpServiceConfiguration
    public int getRegistryMaintenanceIntervalMillis() {
        return 1000;
    }

    @Override // org.fourthline.cling.UpnpServiceConfiguration
    public Integer getRemoteDeviceMaxAgeSeconds() {
        return null;
    }

    @Override // org.fourthline.cling.UpnpServiceConfiguration
    public ServiceDescriptorBinder getServiceDescriptorBinderUDA10() {
        return this.serviceDescriptorBinderUDA10;
    }

    @Override // org.fourthline.cling.UpnpServiceConfiguration
    public SOAPActionProcessor getSoapActionProcessor() {
        return this.soapActionProcessor;
    }

    @Override // org.fourthline.cling.UpnpServiceConfiguration
    public ExecutorService getStreamServerExecutorService() {
        return getDefaultExecutorService();
    }

    @Override // org.fourthline.cling.UpnpServiceConfiguration
    public ExecutorService getSyncProtocolExecutorService() {
        return getDefaultExecutorService();
    }

    @PostConstruct
    public void init() {
        if (!ModelUtil.ANDROID_RUNTIME) {
            this.streamListenPort = 0;
            this.defaultExecutorService = createDefaultExecutorService();
            this.soapActionProcessor = createSOAPActionProcessor();
            this.genaEventProcessor = createGENAEventProcessor();
            this.deviceDescriptorBinderUDA10 = createDeviceDescriptorBinderUDA10();
            this.serviceDescriptorBinderUDA10 = createServiceDescriptorBinderUDA10();
            this.namespace = createNamespace();
            return;
        }
        throw new Error("Unsupported runtime environment, use org.fourthline.cling.android.AndroidUpnpServiceConfiguration");
    }

    @Override // org.fourthline.cling.UpnpServiceConfiguration
    public boolean isReceivedSubscriptionTimeoutIgnored() {
        return false;
    }

    @Override // org.fourthline.cling.UpnpServiceConfiguration
    public void shutdown() {
        log.fine("Shutting down default executor service");
        getDefaultExecutorService().shutdownNow();
    }
}
