package org.apache.commons.lang3.reflect;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import org.apache.commons.lang3.Validate;

/* loaded from: classes4.dex */
public abstract class TypeLiteral<T> implements Typed<T> {

    /* renamed from: T */
    public static final TypeVariable<Class<TypeLiteral>> f4555T = TypeLiteral.class.getTypeParameters()[0];
    public final Type value = (Type) Validate.notNull(TypeUtils.getTypeArguments(TypeLiteral.class, TypeLiteral.class).get(f4555T), "%s does not assign type parameter %s", TypeLiteral.class, TypeUtils.toLongString(f4555T));
    public final String toString = String.format("%s<%s>", TypeLiteral.class.getSimpleName(), TypeUtils.toString(this.value));

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof TypeLiteral) {
            return TypeUtils.equals(this.value, ((TypeLiteral) obj).value);
        }
        return false;
    }

    @Override // org.apache.commons.lang3.reflect.Typed
    public Type getType() {
        return this.value;
    }

    public int hashCode() {
        return this.value.hashCode() | 592;
    }

    public String toString() {
        return this.toString;
    }
}
