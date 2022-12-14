package org.fourthline.cling.model.gena;

import java.beans.PropertyChangeSupport;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import me.tvspark.outline;
import org.fourthline.cling.model.Location;
import org.fourthline.cling.model.Namespace;
import org.fourthline.cling.model.NetworkAddress;
import org.fourthline.cling.model.UnsupportedDataException;
import org.fourthline.cling.model.message.UpnpResponse;
import org.fourthline.cling.model.meta.RemoteService;
import org.fourthline.cling.model.state.StateVariableValue;
import org.fourthline.cling.model.types.UnsignedIntegerFourBytes;

/* loaded from: classes5.dex */
public abstract class RemoteGENASubscription extends GENASubscription<RemoteService> {
    public PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public RemoteGENASubscription(RemoteService remoteService, int i) {
        super(remoteService, i);
    }

    public synchronized void end(CancelReason cancelReason, UpnpResponse upnpResponse) {
        ended(cancelReason, upnpResponse);
    }

    public abstract void ended(CancelReason cancelReason, UpnpResponse upnpResponse);

    public synchronized void establish() {
        established();
    }

    public abstract void eventsMissed(int i);

    public synchronized void fail(UpnpResponse upnpResponse) {
        failed(upnpResponse);
    }

    public abstract void failed(UpnpResponse upnpResponse);

    public synchronized List<URL> getEventCallbackURLs(List<NetworkAddress> list, Namespace namespace) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (NetworkAddress networkAddress : list) {
            arrayList.add(new Location(networkAddress, namespace.getEventCallbackPathString(getService())).getURL());
        }
        return arrayList;
    }

    public synchronized URL getEventSubscriptionURL() {
        return getService().getDevice().normalizeURI(getService().getEventSubscriptionURI());
    }

    public abstract void invalidMessage(UnsupportedDataException unsupportedDataException);

    public synchronized void receive(UnsignedIntegerFourBytes unsignedIntegerFourBytes, Collection<StateVariableValue> collection) {
        if (this.currentSequence != null) {
            if (this.currentSequence.getValue().equals(Long.valueOf(this.currentSequence.getBits().getMaxValue())) && unsignedIntegerFourBytes.getValue().longValue() == 1) {
                System.err.println("TODO: HANDLE ROLLOVER");
                return;
            } else if (this.currentSequence.getValue().longValue() >= unsignedIntegerFourBytes.getValue().longValue()) {
                return;
            } else {
                int longValue = (int) (unsignedIntegerFourBytes.getValue().longValue() - (this.currentSequence.getValue().longValue() + 1));
                if (longValue != 0) {
                    eventsMissed(longValue);
                }
            }
        }
        this.currentSequence = unsignedIntegerFourBytes;
        for (StateVariableValue stateVariableValue : collection) {
            this.currentValues.put(stateVariableValue.getStateVariable().getName(), stateVariableValue);
        }
        eventReceived();
    }

    @Override // org.fourthline.cling.model.gena.GENASubscription
    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(SID: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getSubscriptionId());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(") ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getService());
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
