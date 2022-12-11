package me.tvspark.utils.cast.service;

import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.IBinder;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.stub.StubApp;
import java.util.UUID;
import me.tvspark.mp0;
import me.tvspark.np0;
import me.tvspark.utils.cast.utils.VMLog;
import org.fourthline.cling.UpnpServiceConfiguration;
import org.fourthline.cling.android.AndroidUpnpServiceConfiguration;
import org.fourthline.cling.android.AndroidUpnpServiceImpl;
import org.fourthline.cling.binding.annotations.AnnotationLocalServiceBinder;
import org.fourthline.cling.model.DefaultServiceManager;
import org.fourthline.cling.model.ValidationException;
import org.fourthline.cling.model.meta.DeviceDetails;
import org.fourthline.cling.model.meta.DeviceIdentity;
import org.fourthline.cling.model.meta.LocalDevice;
import org.fourthline.cling.model.meta.LocalService;
import org.fourthline.cling.model.types.UDADeviceType;
import org.fourthline.cling.model.types.UDN;
import org.fourthline.cling.transport.impl.AsyncServletStreamServerConfigurationImpl;
import org.fourthline.cling.transport.impl.AsyncServletStreamServerImpl;
import org.fourthline.cling.transport.spi.NetworkAddressFactory;
import org.fourthline.cling.transport.spi.StreamServer;

/* loaded from: classes4.dex */
public class ClingService extends AndroidUpnpServiceImpl {
    public final String Wwwwwwwwwwwwwwwwwwwwwwww = ClingService.class.getSimpleName();
    public LocalDevice Wwwwwwwwwwwwwwwwwwwwwww = null;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AndroidUpnpServiceImpl.Binder {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            super();
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AndroidUpnpServiceConfiguration {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ClingService clingService) {
        }

        @Override // org.fourthline.cling.android.AndroidUpnpServiceConfiguration, org.fourthline.cling.DefaultUpnpServiceConfiguration, org.fourthline.cling.UpnpServiceConfiguration
        public StreamServer createStreamServer(NetworkAddressFactory networkAddressFactory) {
            return new AsyncServletStreamServerImpl(new AsyncServletStreamServerConfigurationImpl(mp0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, networkAddressFactory.getStreamListenPort()));
        }
    }

    @Override // org.fourthline.cling.android.AndroidUpnpServiceImpl
    public UpnpServiceConfiguration createConfiguration() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
    }

    @Override // org.fourthline.cling.android.AndroidUpnpServiceImpl, android.app.Service
    public IBinder onBind(Intent intent) {
        return this.binder;
    }

    @Override // org.fourthline.cling.android.AndroidUpnpServiceImpl, android.app.Service
    public void onCreate() {
        super.onCreate();
        this.binder = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        LocalService read = new AnnotationLocalServiceBinder().read(np0.class);
        read.setManager(new DefaultServiceManager(read, np0.class));
        UDN valueOf = UDN.valueOf(UUID.nameUUIDFromBytes(((WifiManager) StubApp.getOrigApplicationContext(getApplicationContext()).getSystemService(NetworkUtil.NETWORK_TYPE_WIFI)).getConnectionInfo().getMacAddress().getBytes()).toString());
        UDADeviceType uDADeviceType = new UDADeviceType("MediaServer");
        DeviceDetails deviceDetails = new DeviceDetails("VAndroidMediaServer");
        try {
            this.Wwwwwwwwwwwwwwwwwwwwwww = new LocalDevice(new DeviceIdentity(valueOf), uDADeviceType, deviceDetails, new LocalService[]{read});
            this.upnpService.getRegistry().addDevice(this.Wwwwwwwwwwwwwwwwwwwwwww);
        } catch (ValidationException e) {
            e.printStackTrace();
        }
        VMLog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, "MediaServer device created! name:%s, manufacturer:%s, model:%s", deviceDetails.getFriendlyName(), deviceDetails.getManufacturerDetails().getManufacturer(), deviceDetails.getModelDetails().getModelName());
    }

    @Override // org.fourthline.cling.android.AndroidUpnpServiceImpl, android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }
}
