package me.tvspark;

import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* renamed from: me.tvspark.j1 */
/* loaded from: classes4.dex */
public final class C2243j1 implements Illlllllllllllllllllllllllll {
    public final Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2243j1(@NonNull Object obj) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, "Argument must not be null");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = obj;
    }

    @Override // me.tvspark.Illlllllllllllllllllllllllll
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull MessageDigest messageDigest) {
        messageDigest.update(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString().getBytes(Illlllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
    }

    @Override // me.tvspark.Illlllllllllllllllllllllllll
    public boolean equals(Object obj) {
        if (obj instanceof C2243j1) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(((C2243j1) obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        return false;
    }

    @Override // me.tvspark.Illlllllllllllllllllllllllll
    public int hashCode() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode();
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ObjectKey{object=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append('}');
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
