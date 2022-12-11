package me.tvspark;

/* loaded from: classes4.dex */
public final class ji0 implements di0 {
    public final Class<?> Wwwwwwwwwwwwwwwwwwwwwwww;

    public ji0(Class<?> cls, String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls, "jClass");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "moduleName");
        this.Wwwwwwwwwwwwwwwwwwwwwwww = cls;
    }

    @Override // me.tvspark.di0
    public Class<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ji0) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, ((ji0) obj).Wwwwwwwwwwwwwwwwwwwwwwww);
    }

    public int hashCode() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.hashCode();
    }

    public String toString() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.toString() + " (Kotlin reflection is not available)";
    }
}
