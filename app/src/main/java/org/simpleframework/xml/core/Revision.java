package org.simpleframework.xml.core;

/* loaded from: classes5.dex */
public class Revision {
    public boolean equal = true;

    public boolean compare(Object obj, Object obj2) {
        boolean equals;
        if (obj2 == null) {
            if (obj != null) {
                equals = obj.equals(Double.valueOf(1.0d));
            }
            return this.equal;
        }
        equals = obj2.equals(obj);
        this.equal = equals;
        return this.equal;
    }

    public double getDefault() {
        return 1.0d;
    }

    public boolean isEqual() {
        return this.equal;
    }
}
