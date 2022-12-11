package me.tvspark;

import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* loaded from: classes4.dex */
public final class IIlllllll implements Illlllllllllllllllllllllllll {
    public final Illlllllllllllllllllllllllll Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Illlllllllllllllllllllllllll Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public IIlllllll(Illlllllllllllllllllllllllll illlllllllllllllllllllllllll, Illlllllllllllllllllllllllll illlllllllllllllllllllllllll2) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = illlllllllllllllllllllllllll;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = illlllllllllllllllllllllllll2;
    }

    @Override // me.tvspark.Illlllllllllllllllllllllllll
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull MessageDigest messageDigest) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(messageDigest);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(messageDigest);
    }

    @Override // me.tvspark.Illlllllllllllllllllllllllll
    public boolean equals(Object obj) {
        if (obj instanceof IIlllllll) {
            IIlllllll iIlllllll = (IIlllllll) obj;
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(iIlllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(iIlllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        return false;
    }

    @Override // me.tvspark.Illlllllllllllllllllllllllll
    public int hashCode() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode() + (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode() * 31);
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("DataCacheKey{sourceKey=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", signature=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append('}');
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
