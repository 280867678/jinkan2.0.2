package org.simpleframework.xml.strategy;

import java.lang.annotation.Annotation;

/* loaded from: classes5.dex */
public interface Type {
    <T extends Annotation> T getAnnotation(Class<T> cls);

    Class getType();

    String toString();
}
