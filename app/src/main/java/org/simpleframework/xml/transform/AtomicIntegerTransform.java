package org.simpleframework.xml.transform;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes5.dex */
public class AtomicIntegerTransform implements Transform<AtomicInteger> {
    @Override // org.simpleframework.xml.transform.Transform
    /* renamed from: read  reason: avoid collision after fix types in other method */
    public AtomicInteger mo5334read(String str) {
        return new AtomicInteger(Integer.valueOf(str).intValue());
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String write(AtomicInteger atomicInteger) {
        return atomicInteger.toString();
    }
}
