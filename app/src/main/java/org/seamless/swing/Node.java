package org.seamless.swing;

import java.util.List;

/* loaded from: classes5.dex */
public interface Node<T> {
    List<T> getChildren();

    Long getId();

    T getParent();
}
