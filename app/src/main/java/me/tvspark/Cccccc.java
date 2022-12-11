package me.tvspark;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes4.dex */
public final class Cccccc extends Xxx {
    public static final byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = "com.bumptech.glide.load.resource.bitmap.RoundedCorners".getBytes(Illlllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public Cccccc(int i) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i > 0, "roundingRadius must be greater than 0.");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    @Override // me.tvspark.Xxx
    public Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull OO0 oo0, @NonNull Bitmap bitmap, int i, int i2) {
        return Cccc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(oo0, bitmap, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.Illlllllllllllllllllllllllll
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull MessageDigest messageDigest) {
        messageDigest.update(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).array());
    }

    @Override // me.tvspark.Illlllllllllllllllllllllllll
    public boolean equals(Object obj) {
        return (obj instanceof Cccccc) && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == ((Cccccc) obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.Illlllllllllllllllllllllllll
    public int hashCode() {
        return (C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) * 31) - 569625254;
    }
}
