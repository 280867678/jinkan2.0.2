package org.fourthline.cling;

import java.io.PrintStream;
import me.tvspark.outline;
import org.fourthline.cling.model.message.header.STAllHeader;
import org.fourthline.cling.model.meta.LocalDevice;
import org.fourthline.cling.model.meta.RemoteDevice;
import org.fourthline.cling.registry.Registry;
import org.fourthline.cling.registry.RegistryListener;

/* loaded from: classes5.dex */
public class Main {
    public static void main(String[] strArr) throws Exception {
        RegistryListener registryListener = new RegistryListener() { // from class: org.fourthline.cling.Main.1
            @Override // org.fourthline.cling.registry.RegistryListener
            public void afterShutdown() {
                System.out.println("Shutdown of registry complete!");
            }

            @Override // org.fourthline.cling.registry.RegistryListener
            public void beforeShutdown(Registry registry) {
                PrintStream printStream = System.out;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Before shutdown, the registry has devices: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(registry.getDevices().size());
                printStream.println(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }

            @Override // org.fourthline.cling.registry.RegistryListener
            public void localDeviceAdded(Registry registry, LocalDevice localDevice) {
                PrintStream printStream = System.out;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Local device added: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(localDevice.getDisplayString());
                printStream.println(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }

            @Override // org.fourthline.cling.registry.RegistryListener
            public void localDeviceRemoved(Registry registry, LocalDevice localDevice) {
                PrintStream printStream = System.out;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Local device removed: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(localDevice.getDisplayString());
                printStream.println(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }

            @Override // org.fourthline.cling.registry.RegistryListener
            public void remoteDeviceAdded(Registry registry, RemoteDevice remoteDevice) {
                PrintStream printStream = System.out;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Remote device available: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(remoteDevice.getDisplayString());
                printStream.println(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }

            @Override // org.fourthline.cling.registry.RegistryListener
            public void remoteDeviceDiscoveryFailed(Registry registry, RemoteDevice remoteDevice, Exception exc) {
                PrintStream printStream = System.out;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Discovery failed: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(remoteDevice.getDisplayString());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" => ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(exc);
                printStream.println(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }

            @Override // org.fourthline.cling.registry.RegistryListener
            public void remoteDeviceDiscoveryStarted(Registry registry, RemoteDevice remoteDevice) {
                PrintStream printStream = System.out;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Discovery started: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(remoteDevice.getDisplayString());
                printStream.println(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }

            @Override // org.fourthline.cling.registry.RegistryListener
            public void remoteDeviceRemoved(Registry registry, RemoteDevice remoteDevice) {
                PrintStream printStream = System.out;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Remote device removed: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(remoteDevice.getDisplayString());
                printStream.println(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }

            @Override // org.fourthline.cling.registry.RegistryListener
            public void remoteDeviceUpdated(Registry registry, RemoteDevice remoteDevice) {
                PrintStream printStream = System.out;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Remote device updated: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(remoteDevice.getDisplayString());
                printStream.println(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
        };
        System.out.println("Starting Cling...");
        UpnpServiceImpl upnpServiceImpl = new UpnpServiceImpl(registryListener);
        System.out.println("Sending SEARCH message to all devices...");
        upnpServiceImpl.getControlPoint().search(new STAllHeader());
        System.out.println("Waiting 10 seconds before shutting down...");
        Thread.sleep(10000L);
        System.out.println("Stopping Cling...");
        upnpServiceImpl.shutdown();
    }
}
