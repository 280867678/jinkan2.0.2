package org.fourthline.cling.registry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.tvspark.outline;
import org.fourthline.cling.model.gena.CancelReason;
import org.fourthline.cling.model.gena.RemoteGENASubscription;
import org.fourthline.cling.model.meta.LocalDevice;
import org.fourthline.cling.model.meta.RemoteDevice;
import org.fourthline.cling.model.meta.RemoteDeviceIdentity;
import org.fourthline.cling.model.resource.Resource;
import org.fourthline.cling.model.types.UDN;

/* loaded from: classes5.dex */
public class RemoteItems extends RegistryItems<RemoteDevice, RemoteGENASubscription> {
    public static Logger log = Logger.getLogger(Registry.class.getName());

    public RemoteItems(RegistryImpl registryImpl) {
        super(registryImpl);
    }

    @Override // org.fourthline.cling.registry.RegistryItems
    public void add(final RemoteDevice remoteDevice) {
        if (update(remoteDevice.getIdentity())) {
            log.fine("Ignoring addition, device already registered: " + remoteDevice);
            return;
        }
        Resource[] resources = getResources(remoteDevice);
        for (Resource resource : resources) {
            log.fine("Validating remote device resource; " + resource);
            if (this.registry.getResource(resource.getPathQuery()) != null) {
                throw new RegistrationException("URI namespace conflict with already registered resource: " + resource);
            }
        }
        for (Resource resource2 : resources) {
            this.registry.addResource(resource2);
            log.fine("Added remote device resource: " + resource2);
        }
        RegistryItem<UDN, RemoteDevice> registryItem = new RegistryItem<>(remoteDevice.getIdentity().getUdn(), remoteDevice, (this.registry.getConfiguration().getRemoteDeviceMaxAgeSeconds() != null ? this.registry.getConfiguration().getRemoteDeviceMaxAgeSeconds() : remoteDevice.getIdentity().getMaxAgeSeconds()).intValue());
        Logger logger = log;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Adding hydrated remote device to registry with ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(registryItem.getExpirationDetails().getMaxAgeSeconds());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" seconds expiration: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(remoteDevice);
        logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        getDeviceItems().add(registryItem);
        if (log.isLoggable(Level.FINEST)) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("\n", "-------------------------- START Registry Namespace -----------------------------------\n");
            for (Resource resource3 : this.registry.getResources()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(resource3);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("\n");
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("-------------------------- END Registry Namespace -----------------------------------");
            log.finest(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        log.fine("Completely hydrated remote device graph available, calling listeners: " + remoteDevice);
        for (final RegistryListener registryListener : this.registry.getListeners()) {
            this.registry.getConfiguration().getRegistryListenerExecutor().execute(new Runnable() { // from class: org.fourthline.cling.registry.RemoteItems.1
                @Override // java.lang.Runnable
                public void run() {
                    registryListener.remoteDeviceAdded(RemoteItems.this.registry, remoteDevice);
                }
            });
        }
    }

    @Override // org.fourthline.cling.registry.RegistryItems
    public void maintain() {
        if (getDeviceItems().isEmpty()) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (RegistryItem<UDN, RemoteDevice> registryItem : getDeviceItems()) {
            if (log.isLoggable(Level.FINEST)) {
                Logger logger = log;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Device '");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(registryItem.getItem());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("' expires in seconds: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(registryItem.getExpirationDetails().getSecondsUntilExpiration());
                logger.finest(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
            if (registryItem.getExpirationDetails().hasExpired(false)) {
                hashMap.put(registryItem.getKey(), registryItem.getItem());
            }
        }
        for (RemoteDevice remoteDevice : hashMap.values()) {
            if (log.isLoggable(Level.FINE)) {
                Logger logger2 = log;
                logger2.fine("Removing expired: " + remoteDevice);
            }
            remove(remoteDevice);
        }
        HashSet hashSet = new HashSet();
        for (RegistryItem<String, RemoteGENASubscription> registryItem2 : getSubscriptionItems()) {
            if (registryItem2.getExpirationDetails().hasExpired(true)) {
                hashSet.add(registryItem2.getItem());
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            RemoteGENASubscription remoteGENASubscription = (RemoteGENASubscription) it.next();
            if (log.isLoggable(Level.FINEST)) {
                Logger logger3 = log;
                logger3.fine("Renewing outgoing subscription: " + remoteGENASubscription);
            }
            renewOutgoingSubscription(remoteGENASubscription);
        }
    }

    @Override // org.fourthline.cling.registry.RegistryItems
    public boolean remove(RemoteDevice remoteDevice) {
        return remove(remoteDevice, false);
    }

    public boolean remove(RemoteDevice remoteDevice, boolean z) throws RegistrationException {
        Resource[] resources;
        final RemoteDevice remoteDevice2 = (RemoteDevice) get(remoteDevice.getIdentity().getUdn(), true);
        if (remoteDevice2 != null) {
            log.fine("Removing remote device from registry: " + remoteDevice);
            for (Resource resource : getResources(remoteDevice2)) {
                if (this.registry.removeResource(resource)) {
                    log.fine("Unregistered resource: " + resource);
                }
            }
            Iterator it = getSubscriptionItems().iterator();
            while (it.hasNext()) {
                final RegistryItem registryItem = (RegistryItem) it.next();
                if (((RemoteGENASubscription) registryItem.getItem()).getService().getDevice().getIdentity().getUdn().equals(remoteDevice2.getIdentity().getUdn())) {
                    Logger logger = log;
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Removing outgoing subscription: ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append((String) registryItem.getKey());
                    logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                    it.remove();
                    if (!z) {
                        this.registry.getConfiguration().getRegistryListenerExecutor().execute(new Runnable() { // from class: org.fourthline.cling.registry.RemoteItems.3
                            @Override // java.lang.Runnable
                            public void run() {
                                ((RemoteGENASubscription) registryItem.getItem()).end(CancelReason.DEVICE_WAS_REMOVED, null);
                            }
                        });
                    }
                }
            }
            if (!z) {
                for (final RegistryListener registryListener : this.registry.getListeners()) {
                    this.registry.getConfiguration().getRegistryListenerExecutor().execute(new Runnable() { // from class: org.fourthline.cling.registry.RemoteItems.4
                        @Override // java.lang.Runnable
                        public void run() {
                            registryListener.remoteDeviceRemoved(RemoteItems.this.registry, remoteDevice2);
                        }
                    });
                }
            }
            getDeviceItems().remove(new RegistryItem(remoteDevice2.getIdentity().getUdn()));
            return true;
        }
        return false;
    }

    @Override // org.fourthline.cling.registry.RegistryItems
    public void removeAll() {
        removeAll(false);
    }

    public void removeAll(boolean z) {
        for (RemoteDevice remoteDevice : (RemoteDevice[]) get().toArray(new RemoteDevice[get().size()])) {
            remove(remoteDevice, z);
        }
    }

    public void renewOutgoingSubscription(RemoteGENASubscription remoteGENASubscription) {
        RegistryImpl registryImpl = this.registry;
        registryImpl.executeAsyncProtocol(registryImpl.getProtocolFactory().createSendingRenewal(remoteGENASubscription));
    }

    public void resume() {
        log.fine("Updating remote device expiration timestamps on resume");
        ArrayList arrayList = new ArrayList();
        for (RegistryItem<UDN, RemoteDevice> registryItem : getDeviceItems()) {
            arrayList.add(registryItem.getItem().getIdentity());
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            update((RemoteDeviceIdentity) it.next());
        }
    }

    @Override // org.fourthline.cling.registry.RegistryItems
    public void shutdown() {
        log.fine("Cancelling all outgoing subscriptions to remote devices during shutdown");
        ArrayList arrayList = new ArrayList();
        for (RegistryItem<String, RemoteGENASubscription> registryItem : getSubscriptionItems()) {
            arrayList.add(registryItem.getItem());
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.registry.getProtocolFactory().createSendingUnsubscribe((RemoteGENASubscription) it.next()).run();
        }
        log.fine("Removing all remote devices from registry during shutdown");
        removeAll(true);
    }

    public void start() {
    }

    public boolean update(RemoteDeviceIdentity remoteDeviceIdentity) {
        for (LocalDevice localDevice : this.registry.getLocalDevices()) {
            if (localDevice.findDevice(remoteDeviceIdentity.getUdn()) != null) {
                log.fine("Ignoring update, a local device graph contains UDN");
                return true;
            }
        }
        RemoteDevice remoteDevice = get(remoteDeviceIdentity.getUdn(), false);
        if (remoteDevice != null) {
            if (!remoteDevice.isRoot()) {
                Logger logger = log;
                logger.fine("Updating root device of embedded: " + remoteDevice);
                remoteDevice = remoteDevice.getRoot();
            }
            final RegistryItem<UDN, RemoteDevice> registryItem = new RegistryItem<>(remoteDevice.getIdentity().getUdn(), remoteDevice, (this.registry.getConfiguration().getRemoteDeviceMaxAgeSeconds() != null ? this.registry.getConfiguration().getRemoteDeviceMaxAgeSeconds() : remoteDeviceIdentity.getMaxAgeSeconds()).intValue());
            Logger logger2 = log;
            logger2.fine("Updating expiration of: " + remoteDevice);
            getDeviceItems().remove(registryItem);
            getDeviceItems().add(registryItem);
            Logger logger3 = log;
            logger3.fine("Remote device updated, calling listeners: " + remoteDevice);
            for (final RegistryListener registryListener : this.registry.getListeners()) {
                this.registry.getConfiguration().getRegistryListenerExecutor().execute(new Runnable() { // from class: org.fourthline.cling.registry.RemoteItems.2
                    @Override // java.lang.Runnable
                    public void run() {
                        registryListener.remoteDeviceUpdated(RemoteItems.this.registry, (RemoteDevice) registryItem.getItem());
                    }
                });
            }
            return true;
        }
        return false;
    }
}
