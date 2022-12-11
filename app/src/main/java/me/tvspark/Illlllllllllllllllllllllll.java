package me.tvspark;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.security.MessageDigest;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

/* loaded from: classes4.dex */
public final class Illlllllllllllllllllllllll<T> {
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Object> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public volatile byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull byte[] bArr, @NonNull T t, @NonNull MessageDigest messageDigest);
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Object> {
        @Override // me.tvspark.Illlllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull byte[] bArr, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        }
    }

    public Illlllllllllllllllllllllll(@NonNull String str, @Nullable T t, @NonNull Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        if (!TextUtils.isEmpty(str)) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = t;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "Argument must not be null");
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            return;
        }
        throw new IllegalArgumentException("Must not be null or empty");
    }

    @NonNull
    public static <T> Illlllllllllllllllllllllll<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull String str, @NonNull T t) {
        return new Illlllllllllllllllllllllll<>(str, t, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Illlllllllllllllllllllllll) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(((Illlllllllllllllllllllllll) obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        return false;
    }

    public int hashCode() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode();
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Option{key='");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(ExtendedMessageFormat.QUOTE);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append('}');
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
    }
}
