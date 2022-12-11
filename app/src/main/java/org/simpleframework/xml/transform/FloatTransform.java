package org.simpleframework.xml.transform;

/* loaded from: classes5.dex */
public class FloatTransform implements Transform<Float> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.simpleframework.xml.transform.Transform
    /* renamed from: read */
    public Float mo5334read(String str) {
        return Float.valueOf(str);
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String write(Float f) {
        return f.toString();
    }
}
