package org.simpleframework.xml.transform;

import java.lang.reflect.Array;

/* loaded from: classes5.dex */
public class ArrayTransform implements Transform {
    public final Transform delegate;
    public final Class entry;
    public final StringArrayTransform split = new StringArrayTransform();

    public ArrayTransform(Transform transform, Class cls) {
        this.delegate = transform;
        this.entry = cls;
    }

    private Object read(String[] strArr, int i) throws Exception {
        Object newInstance = Array.newInstance(this.entry, i);
        for (int i2 = 0; i2 < i; i2++) {
            Object mo5334read = this.delegate.mo5334read(strArr[i2]);
            if (mo5334read != null) {
                Array.set(newInstance, i2, mo5334read);
            }
        }
        return newInstance;
    }

    private String write(Object obj, int i) throws Exception {
        String[] strArr = new String[i];
        for (int i2 = 0; i2 < i; i2++) {
            Object obj2 = Array.get(obj, i2);
            if (obj2 != null) {
                strArr[i2] = this.delegate.write(obj2);
            }
        }
        return this.split.write(strArr);
    }

    @Override // org.simpleframework.xml.transform.Transform
    /* renamed from: read */
    public Object mo5334read(String str) throws Exception {
        String[] mo5334read = this.split.mo5334read(str);
        return read(mo5334read, mo5334read.length);
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String write(Object obj) throws Exception {
        return write(obj, Array.getLength(obj));
    }
}
