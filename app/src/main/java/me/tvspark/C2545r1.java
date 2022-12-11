package me.tvspark;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* renamed from: me.tvspark.r1 */
/* loaded from: classes4.dex */
public class C2545r1 {
    public Class<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Class<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Class<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2545r1() {
    }

    public C2545r1(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = cls;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = cls2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = cls3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2545r1.class != obj.getClass()) {
            return false;
        }
        C2545r1 c2545r1 = (C2545r1) obj;
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(c2545r1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(c2545r1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2545r1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public int hashCode() {
        int hashCode = (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode() + (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode() * 31)) * 31;
        Class<?> cls = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("MultiClassKey{first=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", second=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append('}');
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
