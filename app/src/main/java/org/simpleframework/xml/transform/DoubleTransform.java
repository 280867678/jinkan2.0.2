package org.simpleframework.xml.transform;

/* loaded from: classes5.dex */
public class DoubleTransform implements Transform<Double> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.simpleframework.xml.transform.Transform
    /* renamed from: read */
    public Double mo5334read(String str) {
        return Double.valueOf(str);
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String write(Double d) {
        return d.toString();
    }
}
