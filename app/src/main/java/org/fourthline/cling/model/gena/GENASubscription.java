package org.fourthline.cling.model.gena;

import java.util.LinkedHashMap;
import java.util.Map;
import me.tvspark.outline;
import org.fourthline.cling.model.meta.Service;
import org.fourthline.cling.model.state.StateVariableValue;
import org.fourthline.cling.model.types.UnsignedIntegerFourBytes;

/* loaded from: classes5.dex */
public abstract class GENASubscription<S extends Service> {
    public int actualDurationSeconds;
    public UnsignedIntegerFourBytes currentSequence;
    public Map<String, StateVariableValue<S>> currentValues;
    public int requestedDurationSeconds;
    public S service;
    public String subscriptionId;

    public GENASubscription(S s) {
        this.requestedDurationSeconds = 1800;
        this.currentValues = new LinkedHashMap();
        this.service = s;
    }

    public GENASubscription(S s, int i) {
        this(s);
        this.requestedDurationSeconds = i;
    }

    public abstract void established();

    public abstract void eventReceived();

    public synchronized int getActualDurationSeconds() {
        return this.actualDurationSeconds;
    }

    public synchronized UnsignedIntegerFourBytes getCurrentSequence() {
        return this.currentSequence;
    }

    public synchronized Map<String, StateVariableValue<S>> getCurrentValues() {
        return this.currentValues;
    }

    public synchronized int getRequestedDurationSeconds() {
        return this.requestedDurationSeconds;
    }

    public synchronized S getService() {
        return this.service;
    }

    public synchronized String getSubscriptionId() {
        return this.subscriptionId;
    }

    public synchronized void setActualSubscriptionDurationSeconds(int i) {
        this.actualDurationSeconds = i;
    }

    public synchronized void setSubscriptionId(String str) {
        this.subscriptionId = str;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(GENASubscription, SID: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getSubscriptionId());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", SEQUENCE: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getCurrentSequence());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
