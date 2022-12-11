package org.simpleframework.xml.convert;

import java.lang.annotation.Annotation;

/* loaded from: classes5.dex */
public interface Scanner {
    <T extends Annotation> T scan(Class<T> cls);
}
