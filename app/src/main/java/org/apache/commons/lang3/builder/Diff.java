package org.apache.commons.lang3.builder;

import java.lang.reflect.Type;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.reflect.TypeUtils;
import org.apache.commons.lang3.tuple.Pair;

/* loaded from: classes4.dex */
public abstract class Diff<T> extends Pair<T, T> {
    public static final long serialVersionUID = 1;
    public final String fieldName;
    public final Type type = (Type) ObjectUtils.defaultIfNull(TypeUtils.getTypeArguments(getClass(), Diff.class).get(Diff.class.getTypeParameters()[0]), Object.class);

    public Diff(String str) {
        this.fieldName = str;
    }

    public final String getFieldName() {
        return this.fieldName;
    }

    public final Type getType() {
        return this.type;
    }

    @Override // java.util.Map.Entry
    public final T setValue(T t) {
        throw new UnsupportedOperationException("Cannot alter Diff object.");
    }

    @Override // org.apache.commons.lang3.tuple.Pair
    public final String toString() {
        return String.format("[%s: %s, %s]", this.fieldName, mo5161getLeft(), mo5162getRight());
    }
}
