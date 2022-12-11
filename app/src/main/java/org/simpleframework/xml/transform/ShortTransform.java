package org.simpleframework.xml.transform;

/* loaded from: classes5.dex */
public class ShortTransform implements Transform<Short> {
    @Override // org.simpleframework.xml.transform.Transform
    /* renamed from: read  reason: collision with other method in class */
    public Short mo5334read(String str) {
        return Short.valueOf(str);
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String write(Short sh) {
        return sh.toString();
    }
}
