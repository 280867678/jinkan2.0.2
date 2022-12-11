package me.tvspark;

import com.google.common.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;

/* renamed from: me.tvspark.cz */
/* loaded from: classes4.dex */
public class C2001cz extends AccessibleObject implements Member {
    public final Member Wwwwwwwwwwwwwwwwwwwwwww;
    public final AccessibleObject Wwwwwwwwwwwwwwwwwwwwwwww;

    public <M extends AccessibleObject & Member> C2001cz(M m) {
        if (m != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = m;
            this.Wwwwwwwwwwwwwwwwwwwwwww = m;
            return;
        }
        throw null;
    }

    public TypeToken<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return TypeToken.m3793of((Class) getDeclaringClass());
    }

    public boolean equals(Object obj) {
        if (obj instanceof C2001cz) {
            C2001cz c2001cz = (C2001cz) obj;
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().equals(c2001cz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) && this.Wwwwwwwwwwwwwwwwwwwwwww.equals(c2001cz.Wwwwwwwwwwwwwwwwwwwwwww);
        }
        return false;
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public final <A extends Annotation> A getAnnotation(Class<A> cls) {
        return (A) this.Wwwwwwwwwwwwwwwwwwwwwwww.getAnnotation(cls);
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public final Annotation[] getAnnotations() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.getAnnotations();
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public final Annotation[] getDeclaredAnnotations() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.getDeclaredAnnotations();
    }

    @Override // java.lang.reflect.Member
    public Class<?> getDeclaringClass() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww.getDeclaringClass();
    }

    @Override // java.lang.reflect.Member
    public final int getModifiers() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww.getModifiers();
    }

    @Override // java.lang.reflect.Member
    public final String getName() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww.getName();
    }

    public int hashCode() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww.hashCode();
    }

    @Override // java.lang.reflect.AccessibleObject
    public final boolean isAccessible() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.isAccessible();
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public final boolean isAnnotationPresent(Class<? extends Annotation> cls) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.isAnnotationPresent(cls);
    }

    @Override // java.lang.reflect.Member
    public final boolean isSynthetic() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww.isSynthetic();
    }

    @Override // java.lang.reflect.AccessibleObject
    public final void setAccessible(boolean z) throws SecurityException {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.setAccessible(z);
    }

    public String toString() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
