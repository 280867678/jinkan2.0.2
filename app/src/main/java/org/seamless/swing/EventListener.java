package org.seamless.swing;

import org.seamless.swing.Event;

/* loaded from: classes5.dex */
public interface EventListener<E extends Event> {
    void handleEvent(E e);
}
