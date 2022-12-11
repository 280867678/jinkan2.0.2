package me.tvspark;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* loaded from: classes4.dex */
public class Zzzzzzzzz extends Xxx {
    public static final byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = "com.bumptech.glide.load.resource.bitmap.CenterInside".getBytes(Illlllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);

    @Override // me.tvspark.Xxx
    public Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull OO0 oo0, @NonNull Bitmap bitmap, int i, int i2) {
        return Cccc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(oo0, bitmap, i, i2);
    }

    @Override // me.tvspark.Illlllllllllllllllllllllllll
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull MessageDigest messageDigest) {
        messageDigest.update(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.Illlllllllllllllllllllllllll
    public boolean equals(Object obj) {
        return obj instanceof Zzzzzzzzz;
    }

    @Override // me.tvspark.Illlllllllllllllllllllllllll
    public int hashCode() {
        return -670243078;
    }
}
