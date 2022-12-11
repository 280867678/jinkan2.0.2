package org.fourthline.cling.android;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import org.fourthline.cling.UpnpService;
import org.fourthline.cling.UpnpServiceConfiguration;
import org.fourthline.cling.UpnpServiceImpl;
import org.fourthline.cling.controlpoint.ControlPoint;
import org.fourthline.cling.protocol.ProtocolFactory;
import org.fourthline.cling.registry.Registry;
import org.fourthline.cling.registry.RegistryListener;
import org.fourthline.cling.transport.Router;

/* loaded from: classes5.dex */
public class AndroidUpnpServiceImpl extends Service {
    public Binder binder = new Binder();
    public UpnpService upnpService;

    /* loaded from: classes5.dex */
    public class Binder extends android.os.Binder implements AndroidUpnpService {
        public Binder() {
        }

        @Override // org.fourthline.cling.android.AndroidUpnpService
        public UpnpService get() {
            return AndroidUpnpServiceImpl.this.upnpService;
        }

        @Override // org.fourthline.cling.android.AndroidUpnpService
        public UpnpServiceConfiguration getConfiguration() {
            return AndroidUpnpServiceImpl.this.upnpService.getConfiguration();
        }

        @Override // org.fourthline.cling.android.AndroidUpnpService
        public ControlPoint getControlPoint() {
            return AndroidUpnpServiceImpl.this.upnpService.getControlPoint();
        }

        @Override // org.fourthline.cling.android.AndroidUpnpService
        public Registry getRegistry() {
            return AndroidUpnpServiceImpl.this.upnpService.getRegistry();
        }
    }

    public UpnpServiceConfiguration createConfiguration() {
        return new AndroidUpnpServiceConfiguration();
    }

    public AndroidRouter createRouter(UpnpServiceConfiguration upnpServiceConfiguration, ProtocolFactory protocolFactory, Context context) {
        return new AndroidRouter(upnpServiceConfiguration, protocolFactory, context);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.binder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.upnpService = new UpnpServiceImpl(createConfiguration(), new RegistryListener[0]) { // from class: org.fourthline.cling.android.AndroidUpnpServiceImpl.1
            @Override // org.fourthline.cling.UpnpServiceImpl
            public Router createRouter(ProtocolFactory protocolFactory, Registry registry) {
                return AndroidUpnpServiceImpl.this.createRouter(getConfiguration(), protocolFactory, AndroidUpnpServiceImpl.this);
            }

            @Override // org.fourthline.cling.UpnpServiceImpl, org.fourthline.cling.UpnpService
            public synchronized void shutdown() {
                ((AndroidRouter) mo5192getRouter()).unregisterBroadcastReceiver();
                super.shutdown(true);
            }
        };
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.upnpService.shutdown();
        super.onDestroy();
    }
}
