package org.apache.commons.lang3.concurrent;

import org.apache.commons.lang3.ObjectUtils;

/* loaded from: classes4.dex */
public class ConstantInitializer<T> implements ConcurrentInitializer<T> {
    public static final String FMT_TO_STRING = "ConstantInitializer@%d [ object = %s ]";
    public final T object;

    public ConstantInitializer(T t) {
        this.object = t;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConstantInitializer) {
            return ObjectUtils.equals(getObject(), ((ConstantInitializer) obj).getObject());
        }
        return false;
    }

    @Override // org.apache.commons.lang3.concurrent.ConcurrentInitializer
    public T get() throws ConcurrentException {
        return getObject();
    }

    public final T getObject() {
        return this.object;
    }

    public int hashCode() {
        if (getObject() != null) {
            return getObject().hashCode();
        }
        return 0;
    }

    public String toString() {
        return String.format(FMT_TO_STRING, Integer.valueOf(System.identityHashCode(this)), String.valueOf(getObject()));
    }
}
