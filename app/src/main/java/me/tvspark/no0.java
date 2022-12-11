package me.tvspark;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import me.tvspark.utils.cast.utils.VMLog;
import org.fourthline.cling.controlpoint.SubscriptionCallback;
import org.fourthline.cling.model.gena.CancelReason;
import org.fourthline.cling.model.gena.GENASubscription;
import org.fourthline.cling.model.message.UpnpResponse;
import org.fourthline.cling.model.meta.Service;
import org.fourthline.cling.model.state.StateVariableValue;
import org.fourthline.cling.support.lastchange.EventedValue;
import org.fourthline.cling.support.lastchange.InstanceID;
import org.fourthline.cling.support.lastchange.LastChangeParser;

/* loaded from: classes4.dex */
public abstract class no0 extends SubscriptionCallback {
    public no0(Service service) {
        super(service, 10800);
    }

    public abstract LastChangeParser Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<EventedValue> list);

    @Override // org.fourthline.cling.controlpoint.SubscriptionCallback
    public void ended(GENASubscription gENASubscription, CancelReason cancelReason, UpnpResponse upnpResponse) {
        VMLog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(VMLog.Level.DEBUG, "SubscriptionCallback ended");
    }

    @Override // org.fourthline.cling.controlpoint.SubscriptionCallback
    public void established(GENASubscription gENASubscription) {
    }

    @Override // org.fourthline.cling.controlpoint.SubscriptionCallback
    public void eventReceived(GENASubscription gENASubscription) {
        Map currentValues = gENASubscription.getCurrentValues();
        if (currentValues == null || !currentValues.containsKey("LastChange")) {
            return;
        }
        LastChangeParser Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        String variableValue = ((StateVariableValue) currentValues.get("LastChange")).toString();
        VMLog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Last change value: %s", variableValue);
        try {
            List<InstanceID> instanceIDs = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.parse(variableValue).getInstanceIDs();
            ArrayList arrayList = new ArrayList();
            for (InstanceID instanceID : instanceIDs) {
                arrayList.addAll(instanceID.getValues());
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrayList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // org.fourthline.cling.controlpoint.SubscriptionCallback
    public void eventsMissed(GENASubscription gENASubscription, int i) {
    }

    @Override // org.fourthline.cling.controlpoint.SubscriptionCallback
    public void failed(GENASubscription gENASubscription, UpnpResponse upnpResponse, Exception exc, String str) {
        VMLog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(VMLog.Level.DEBUG, "SubscriptionCallback failed");
    }
}
