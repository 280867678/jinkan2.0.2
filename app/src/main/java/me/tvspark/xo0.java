package me.tvspark;

import java.util.List;
import me.tvspark.utils.cast.utils.VMLog;
import org.fourthline.cling.model.meta.LocalDevice;
import org.fourthline.cling.model.meta.RemoteDevice;
import org.fourthline.cling.registry.DefaultRegistryListener;
import org.fourthline.cling.registry.Registry;

/* loaded from: classes4.dex */
public class xo0 extends DefaultRegistryListener {
    @Override // org.fourthline.cling.registry.DefaultRegistryListener, org.fourthline.cling.registry.RegistryListener
    public void localDeviceAdded(Registry registry, LocalDevice localDevice) {
        VMLog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("localDeviceAdded %s", localDevice.getDisplayString());
    }

    @Override // org.fourthline.cling.registry.DefaultRegistryListener, org.fourthline.cling.registry.RegistryListener
    public void localDeviceRemoved(Registry registry, LocalDevice localDevice) {
        VMLog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("localDeviceRemoved %s", localDevice.getDisplayString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x008e, code lost:
        if (r0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(r1).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getIdentity().getUdn().getIdentifierString().equals(r7.getIdentity().getUdn().getIdentifierString()) != false) goto L23;
     */
    @Override // org.fourthline.cling.registry.DefaultRegistryListener, org.fourthline.cling.registry.RegistryListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void remoteDeviceAdded(Registry registry, RemoteDevice remoteDevice) {
        List<ro0> list;
        o11 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        wo0 wo0Var;
        boolean z = true;
        VMLog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("remoteDeviceAdded %s", remoteDevice.getDisplayString());
        lp0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = lp0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            if (!remoteDevice.getType().equals(lp0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) || (list = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == null) {
                return;
            }
            if (list.isEmpty()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(new ro0(remoteDevice));
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                wo0Var = new wo0();
            } else {
                int i = 0;
                while (true) {
                    if (i >= Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size()) {
                        break;
                    } else if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getDetails().getFriendlyName().equals(remoteDevice.getDetails().getFriendlyName())) {
                        i++;
                    }
                }
                z = false;
                if (z) {
                    return;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(new ro0(remoteDevice));
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                wo0Var = new wo0();
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wo0Var);
            return;
        }
        throw null;
    }

    @Override // org.fourthline.cling.registry.DefaultRegistryListener, org.fourthline.cling.registry.RegistryListener
    public void remoteDeviceDiscoveryFailed(Registry registry, RemoteDevice remoteDevice, Exception exc) {
        VMLog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("remoteDeviceDiscoveryFailed %s - %s", remoteDevice.getDisplayString(), exc.toString());
    }

    @Override // org.fourthline.cling.registry.DefaultRegistryListener, org.fourthline.cling.registry.RegistryListener
    public void remoteDeviceDiscoveryStarted(Registry registry, RemoteDevice remoteDevice) {
        VMLog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("remoteDeviceDiscoveryStarted %s", remoteDevice.getDisplayString());
    }

    @Override // org.fourthline.cling.registry.DefaultRegistryListener, org.fourthline.cling.registry.RegistryListener
    public void remoteDeviceRemoved(Registry registry, RemoteDevice remoteDevice) {
        VMLog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("remoteDeviceRemoved %s", remoteDevice.getDisplayString());
    }
}
