package me.tvspark;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.HashSet;
import java.util.Set;

/* renamed from: me.tvspark.lz */
/* loaded from: classes4.dex */
public abstract class AbstractC2351lz {
    public final Set<Type> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new HashSet();

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class<?> cls) {
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(GenericArrayType genericArrayType) {
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ParameterizedType parameterizedType) {
    }

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TypeVariable<?> typeVariable);

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WildcardType wildcardType);

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Type... typeArr) {
        for (Type type : typeArr) {
            if (type != null && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(type)) {
                try {
                    if (type instanceof TypeVariable) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((TypeVariable) type);
                    } else if (type instanceof WildcardType) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((WildcardType) type);
                    } else if (type instanceof ParameterizedType) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ParameterizedType) type);
                    } else if (type instanceof Class) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Class) type);
                    } else if (!(type instanceof GenericArrayType)) {
                        throw new AssertionError("Unknown type: " + type);
                    } else {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((GenericArrayType) type);
                    }
                } catch (Throwable th) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remove(type);
                    throw th;
                }
            }
        }
    }
}
