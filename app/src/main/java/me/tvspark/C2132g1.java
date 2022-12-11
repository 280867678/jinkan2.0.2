package me.tvspark;

import android.content.Context;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* renamed from: me.tvspark.g1 */
/* loaded from: classes4.dex */
public final class C2132g1 implements Illlllllllllllllllllllllllll {
    public final Illlllllllllllllllllllllllll Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2132g1(int i, Illlllllllllllllllllllllllll illlllllllllllllllllllllllll) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = illlllllllllllllllllllllllll;
    }

    @NonNull
    public static Illlllllllllllllllllllllllll Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Context context) {
        return new C2132g1(context.getResources().getConfiguration().uiMode & 48, C2169h1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context));
    }

    @Override // me.tvspark.Illlllllllllllllllllllllllll
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull MessageDigest messageDigest) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(messageDigest);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).array());
    }

    @Override // me.tvspark.Illlllllllllllllllllllllllll
    public boolean equals(Object obj) {
        if (obj instanceof C2132g1) {
            C2132g1 c2132g1 = (C2132g1) obj;
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == c2132g1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(c2132g1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        return false;
    }

    @Override // me.tvspark.Illlllllllllllllllllllllllll
    public int hashCode() {
        return C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }
}
