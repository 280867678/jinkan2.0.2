package org.simpleframework.xml.core;

/* loaded from: classes5.dex */
public interface Instance {
    Object getInstance() throws Exception;

    Class getType();

    boolean isReference();

    Object setInstance(Object obj) throws Exception;
}
