package me.tvspark;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.security.MessageDigest;
import me.tvspark.Illlllllllllllllllllllllll;

/* loaded from: classes4.dex */
public final class Illllllllllllllllllllllll implements Illlllllllllllllllllllllllll {
    public final ArrayMap<Illlllllllllllllllllllllll<?>, Object> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new CachedHashCodeArrayMap();

    @Nullable
    public <T> T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Illlllllllllllllllllllllll<T> illlllllllllllllllllllllll) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.containsKey(illlllllllllllllllllllllll) ? (T) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(illlllllllllllllllllllllll) : illlllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.putAll((SimpleArrayMap<? extends Illlllllllllllllllllllllll<?>, ? extends Object>) illllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.Illlllllllllllllllllllllllll
    public boolean equals(Object obj) {
        if (obj instanceof Illllllllllllllllllllllll) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(((Illllllllllllllllllllllll) obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        return false;
    }

    @Override // me.tvspark.Illlllllllllllllllllllllllll
    public int hashCode() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode();
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Options{values=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append('}');
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    @Override // me.tvspark.Illlllllllllllllllllllllllll
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull MessageDigest messageDigest) {
        for (int i = 0; i < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size(); i++) {
            Illlllllllllllllllllllllll<?> keyAt = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.keyAt(i);
            Object valueAt = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.valueAt(i);
            Illlllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = keyAt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (keyAt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                keyAt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = keyAt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getBytes(Illlllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(keyAt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, valueAt, messageDigest);
        }
    }
}
