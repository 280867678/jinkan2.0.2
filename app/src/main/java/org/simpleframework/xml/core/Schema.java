package org.simpleframework.xml.core;

import org.simpleframework.xml.Version;

/* loaded from: classes5.dex */
public interface Schema {
    Caller getCaller();

    Decorator getDecorator();

    Instantiator getInstantiator();

    Version getRevision();

    Section getSection();

    Label getText();

    Label getVersion();

    boolean isPrimitive();
}
