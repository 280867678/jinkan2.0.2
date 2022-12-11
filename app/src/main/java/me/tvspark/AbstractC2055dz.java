package me.tvspark;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;

/* renamed from: me.tvspark.dz */
/* loaded from: classes4.dex */
public abstract class AbstractC2055dz<T, R> extends C2001cz implements GenericDeclaration {

    /* renamed from: me.tvspark.dz$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> extends AbstractC2055dz<T, Object> {
        public final Method Wwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Method method) {
            super(method);
            this.Wwwwwwwwwwwwwwwwwwwwww = method;
        }

        @Override // java.lang.reflect.GenericDeclaration
        public final TypeVariable<?>[] getTypeParameters() {
            return this.Wwwwwwwwwwwwwwwwwwwwww.getTypeParameters();
        }
    }

    /* renamed from: me.tvspark.dz$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> extends AbstractC2055dz<T, T> {
        public final Constructor<?> Wwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Constructor<?> constructor) {
            super(constructor);
            this.Wwwwwwwwwwwwwwwwwwwwww = constructor;
        }

        @Override // java.lang.reflect.GenericDeclaration
        public final TypeVariable<?>[] getTypeParameters() {
            TypeVariable<Class<? super T>>[] typeParameters = getDeclaringClass().getTypeParameters();
            TypeVariable<Constructor<?>>[] typeParameters2 = this.Wwwwwwwwwwwwwwwwwwwwww.getTypeParameters();
            TypeVariable<?>[] typeVariableArr = new TypeVariable[typeParameters.length + typeParameters2.length];
            System.arraycopy(typeParameters, 0, typeVariableArr, 0, typeParameters.length);
            System.arraycopy(typeParameters2, 0, typeVariableArr, typeParameters.length, typeParameters2.length);
            return typeVariableArr;
        }
    }

    public <M extends AccessibleObject & Member> AbstractC2055dz(M m) {
        super(m);
    }

    @Override // me.tvspark.C2001cz, java.lang.reflect.Member
    public final Class<? super T> getDeclaringClass() {
        return (Class<? super T>) super.getDeclaringClass();
    }
}
