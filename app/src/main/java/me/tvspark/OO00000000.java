package me.tvspark;

import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

/* loaded from: classes4.dex */
public final class OO00000000 implements Illlllllllllllllllllllllllll {
    public static final C2465p1<Class<?>, byte[]> Wwwwwwwwwwwwwwwwwwwwwwwww = new C2465p1<>(50);
    public final Illlllllllllllllllllll<?> Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Illllllllllllllllllllllll Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Class<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Illlllllllllllllllllllllllll Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Illlllllllllllllllllllllllll Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final OO000 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public OO00000000(OO000 oo000, Illlllllllllllllllllllllllll illlllllllllllllllllllllllll, Illlllllllllllllllllllllllll illlllllllllllllllllllllllll2, int i, int i2, Illlllllllllllllllllll<?> illlllllllllllllllllll, Class<?> cls, Illllllllllllllllllllllll illllllllllllllllllllllll) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = oo000;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = illlllllllllllllllllllllllll;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = illlllllllllllllllllllllllll2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = illlllllllllllllllllll;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = cls;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = illllllllllllllllllllllll;
    }

    @Override // me.tvspark.Illlllllllllllllllllllllllll
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww).putInt(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww).array();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(messageDigest);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(messageDigest);
        messageDigest.update(bArr);
        Illlllllllllllllllllll<?> illlllllllllllllllllll = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        if (illlllllllllllllllllll != null) {
            illlllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(messageDigest);
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(messageDigest);
        byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((C2465p1<Class<?>, byte[]>) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.getName().getBytes(Illlllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        messageDigest.update(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(bArr);
    }

    @Override // me.tvspark.Illlllllllllllllllllllllllll
    public boolean equals(Object obj) {
        if (obj instanceof OO00000000) {
            OO00000000 oo00000000 = (OO00000000) obj;
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww == oo00000000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == oo00000000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww && C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwww, oo00000000.Wwwwwwwwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(oo00000000.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(oo00000000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(oo00000000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.equals(oo00000000.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        return false;
    }

    @Override // me.tvspark.Illlllllllllllllllllllllllll
    public int hashCode() {
        int hashCode = ((((this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode() + (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode() * 31)) * 31) + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) * 31) + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Illlllllllllllllllllll<?> illlllllllllllllllllll = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        if (illlllllllllllllllllll != null) {
            hashCode = (hashCode * 31) + illlllllllllllllllllll.hashCode();
        }
        int hashCode2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode();
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode() + ((hashCode2 + (hashCode * 31)) * 31);
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ResourceCacheKey{sourceKey=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", signature=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", width=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", height=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", decodedResourceClass=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", transformation='");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(ExtendedMessageFormat.QUOTE);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", options=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append('}');
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
