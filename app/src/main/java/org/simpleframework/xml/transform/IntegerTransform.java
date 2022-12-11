package org.simpleframework.xml.transform;

/* loaded from: classes5.dex */
public class IntegerTransform implements Transform<Integer> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.simpleframework.xml.transform.Transform
    /* renamed from: read */
    public Integer mo5334read(String str) {
        return Integer.valueOf(str);
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String write(Integer num) {
        return num.toString();
    }
}
