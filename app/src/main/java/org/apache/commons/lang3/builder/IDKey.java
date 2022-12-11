package org.apache.commons.lang3.builder;

/* loaded from: classes4.dex */
public final class IDKey {

    /* renamed from: id */
    public final int f4554id;
    public final Object value;

    public IDKey(Object obj) {
        this.f4554id = System.identityHashCode(obj);
        this.value = obj;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof IDKey)) {
            return false;
        }
        IDKey iDKey = (IDKey) obj;
        return this.f4554id == iDKey.f4554id && this.value == iDKey.value;
    }

    public int hashCode() {
        return this.f4554id;
    }
}
