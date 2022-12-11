package org.simpleframework.xml.transform;

/* loaded from: classes5.dex */
public class EnumTransform implements Transform<Enum> {
    public final Class type;

    public EnumTransform(Class cls) {
        this.type = cls;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.simpleframework.xml.transform.Transform
    /* renamed from: read */
    public Enum mo5334read(String str) throws Exception {
        return Enum.valueOf(this.type, str);
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String write(Enum r1) throws Exception {
        return r1.name();
    }
}
