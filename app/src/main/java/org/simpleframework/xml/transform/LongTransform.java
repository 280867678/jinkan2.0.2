package org.simpleframework.xml.transform;

/* loaded from: classes5.dex */
public class LongTransform implements Transform<Long> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.simpleframework.xml.transform.Transform
    /* renamed from: read */
    public Long mo5334read(String str) {
        return Long.valueOf(str);
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String write(Long l) {
        return l.toString();
    }
}
