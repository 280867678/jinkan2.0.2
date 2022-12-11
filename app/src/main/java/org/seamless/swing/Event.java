package org.seamless.swing;

/* loaded from: classes5.dex */
public interface Event<PAYLOAD> {
    void addFiredInController(Controller controller);

    boolean alreadyFired(Controller controller);

    PAYLOAD getPayload();
}
