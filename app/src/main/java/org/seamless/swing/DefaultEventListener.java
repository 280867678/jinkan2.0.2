package org.seamless.swing;

/* loaded from: classes5.dex */
public interface DefaultEventListener<PAYLOAD> extends EventListener<DefaultEvent<PAYLOAD>> {
    void handleEvent(DefaultEvent<PAYLOAD> defaultEvent);
}
