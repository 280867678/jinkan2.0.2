package org.simpleframework.xml.core;

import org.simpleframework.xml.stream.OutputNode;

/* loaded from: classes5.dex */
public interface Decorator {
    void decorate(OutputNode outputNode);

    void decorate(OutputNode outputNode, Decorator decorator);
}
