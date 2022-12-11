package org.apache.commons.lang3.mutable;

import java.io.Serializable;

/* loaded from: classes4.dex */
public class MutableObject<T> implements Mutable<T>, Serializable {
    public static final long serialVersionUID = 86241875189L;
    public T value;

    public MutableObject() {
    }

    public MutableObject(T t) {
        this.value = t;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (MutableObject.class != obj.getClass()) {
            return false;
        }
        return this.value.equals(((MutableObject) obj).value);
    }

    @Override // org.apache.commons.lang3.mutable.Mutable
    /* renamed from: getValue */
    public T mo5179getValue() {
        return this.value;
    }

    public int hashCode() {
        T t = this.value;
        if (t == null) {
            return 0;
        }
        return t.hashCode();
    }

    @Override // org.apache.commons.lang3.mutable.Mutable
    public void setValue(T t) {
        this.value = t;
    }

    public String toString() {
        T t = this.value;
        return t == null ? "null" : t.toString();
    }
}
