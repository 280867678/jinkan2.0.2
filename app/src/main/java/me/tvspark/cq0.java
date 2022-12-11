package me.tvspark;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.stub.StubApp;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.utils.sniffer.dialog.DialogParse;
import org.fourthline.cling.android.AndroidUpnpService;
import org.fourthline.cling.android.AndroidUpnpServiceImpl;
import org.fourthline.cling.model.ValidationException;
import org.fourthline.cling.model.meta.Device;
import org.fourthline.cling.model.meta.DeviceDetails;
import org.fourthline.cling.model.meta.RemoteDevice;
import org.fourthline.cling.model.types.DeviceType;
import org.fourthline.cling.model.types.UDADeviceType;
import org.fourthline.cling.registry.DefaultRegistryListener;
import org.fourthline.cling.registry.Registry;

/* loaded from: classes4.dex */
public class cq0 {
    public static volatile cq0 Wwwwwwwwwwwwwwwwwwwwwwww;
    public static final DeviceType Wwwwwwwwwwwwwwwwwwwwwwwww = new UDADeviceType("MediaRenderer");
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public AndroidUpnpService Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public lq0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final List<Device> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
    public final List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
    public volatile boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
    public final Handler Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Looper.getMainLooper());
    public final ServiceConnection Wwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final DefaultRegistryListener Wwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Device Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Device device) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = device;
        }

        public boolean equals(Object obj) {
            Device device;
            return (!(obj instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) || (device = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == null) ? super.equals(obj) : device.equals(((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        public String toString() {
            DeviceDetails details;
            Device device = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            return (device == null || (details = device.getDetails()) == null) ? "" : details.getFriendlyName();
        }
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DefaultRegistryListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // org.fourthline.cling.registry.DefaultRegistryListener
        public void deviceAdded(Registry registry, Device device) {
            if (device != null && device.getType().equals(cq0.Wwwwwwwwwwwwwwwwwwwwwwwww)) {
                device.getDetails().getFriendlyName();
                cq0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.obtainMessage(1, device).sendToTarget();
            }
        }

        @Override // org.fourthline.cling.registry.DefaultRegistryListener
        public void deviceRemoved(Registry registry, Device device) {
            if (device != null && device.getType().equals(cq0.Wwwwwwwwwwwwwwwwwwwwwwwww)) {
                device.getDetails().getFriendlyName();
                cq0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.obtainMessage(2, device).sendToTarget();
            }
        }

        @Override // org.fourthline.cling.registry.DefaultRegistryListener, org.fourthline.cling.registry.RegistryListener
        public void remoteDeviceDiscoveryFailed(Registry registry, RemoteDevice remoteDevice, Exception exc) {
            exc.getMessage();
            cq0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.obtainMessage(2, remoteDevice).sendToTarget();
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements ServiceConnection {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AndroidUpnpService androidUpnpService = (AndroidUpnpService) iBinder;
            cq0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = androidUpnpService;
            androidUpnpService.getRegistry().addDevice(cq0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            cq0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getRegistry().addListener(cq0.this.Wwwwwwwwwwwwwwwwwwwwwwwwww);
            if (cq0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                cq0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            cq0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getRegistry().shutdown();
            cq0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Handler {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            cq0 cq0Var;
            cq0 cq0Var2 = cq0.this;
            if (cq0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                return;
            }
            int i = message.what;
            if (i == 0) {
                cq0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
                cq0Var = cq0.this;
            } else if (i == 1) {
                Device device = (Device) message.obj;
                if (cq0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.indexOf(device) >= 0) {
                    return;
                }
                cq0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(device);
                cq0Var = cq0.this;
            } else if (i != 2) {
                if (i != 3) {
                    return;
                }
                cq0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return;
            } else {
                int indexOf = cq0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.indexOf((Device) message.obj);
                if (indexOf < 0) {
                    return;
                }
                cq0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remove(indexOf);
                cq0Var = cq0.this;
            }
            ((DialogParse.Wwwwwwwwwwwwwwwwwwwwwwwww) cq0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public cq0(Context context) {
        if (context != null) {
            try {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new lq0();
            } catch (SocketException e) {
                e.printStackTrace();
            } catch (ValidationException e2) {
                e2.printStackTrace();
            }
            StubApp.getOrigApplicationContext(context.getApplicationContext()).bindService(new Intent(StubApp.getOrigApplicationContext(context.getApplicationContext()), AndroidUpnpServiceImpl.class), this.Wwwwwwwwwwwwwwwwwwwwwwwwwww, 1);
            return;
        }
        throw new NullPointerException("context must not be null!");
    }

    public static cq0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        if (Wwwwwwwwwwwwwwwwwwwwwwww == null) {
            synchronized (cq0.class) {
                if (Wwwwwwwwwwwwwwwwwwwwwwww == null) {
                    Wwwwwwwwwwwwwwwwwwwwwwww = new cq0(context);
                }
            }
        }
        return Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getRegistry().removeAllRemoteDevices();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getRegistry().addDevice(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getControlPoint().search();
    }

    public List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() != this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size()) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() > 0) {
                for (Device device : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(device));
                }
            }
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}
