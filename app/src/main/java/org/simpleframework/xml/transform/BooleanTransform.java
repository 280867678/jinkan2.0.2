package org.simpleframework.xml.transform;

/* loaded from: classes5.dex */
public class BooleanTransform implements Transform<Boolean> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.simpleframework.xml.transform.Transform
    /* renamed from: read */
    public Boolean mo5334read(String str) {
        return Boolean.valueOf(str);
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String write(Boolean bool) {
        return bool.toString();
    }
}
