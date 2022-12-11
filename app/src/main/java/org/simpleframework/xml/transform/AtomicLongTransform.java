package org.simpleframework.xml.transform;

import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes5.dex */
public class AtomicLongTransform implements Transform<AtomicLong> {
    @Override // org.simpleframework.xml.transform.Transform
    /* renamed from: read  reason: avoid collision after fix types in other method */
    public AtomicLong mo5334read(String str) {
        return new AtomicLong(Long.valueOf(str).longValue());
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String write(AtomicLong atomicLong) {
        return atomicLong.toString();
    }
}
