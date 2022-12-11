package org.simpleframework.xml.transform;

import java.lang.reflect.Array;

/* loaded from: classes5.dex */
public class CharacterArrayTransform implements Transform {
    public final Class entry;

    public CharacterArrayTransform(Class cls) {
        this.entry = cls;
    }

    private Object read(char[] cArr, int i) throws Exception {
        Object newInstance = Array.newInstance(this.entry, i);
        for (int i2 = 0; i2 < i; i2++) {
            Array.set(newInstance, i2, Character.valueOf(cArr[i2]));
        }
        return newInstance;
    }

    private String write(Object obj, int i) throws Exception {
        StringBuilder sb = new StringBuilder(i);
        for (int i2 = 0; i2 < i; i2++) {
            Object obj2 = Array.get(obj, i2);
            if (obj2 != null) {
                sb.append(obj2);
            }
        }
        return sb.toString();
    }

    @Override // org.simpleframework.xml.transform.Transform
    /* renamed from: read */
    public Object mo5334read(String str) throws Exception {
        char[] charArray = str.toCharArray();
        return this.entry == Character.TYPE ? charArray : read(charArray, charArray.length);
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String write(Object obj) throws Exception {
        return this.entry == Character.TYPE ? new String((char[]) obj) : write(obj, Array.getLength(obj));
    }
}
