package org.simpleframework.xml.core;

import org.simpleframework.xml.transform.Matcher;
import org.simpleframework.xml.transform.Transform;

/* loaded from: classes5.dex */
public class EmptyMatcher implements Matcher {
    @Override // org.simpleframework.xml.transform.Matcher
    public Transform match(Class cls) throws Exception {
        return null;
    }
}
