package me.tvspark;

import android.content.Context;
import androidx.annotation.NonNull;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;

/* loaded from: classes4.dex */
public class Illllllllllllllllllllllllll<T> implements Illlllllllllllllllllll<T> {
    public final Collection<? extends Illlllllllllllllllllll<T>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    @SafeVarargs
    public Illllllllllllllllllllllllll(@NonNull Illlllllllllllllllllll<T>... illlllllllllllllllllllArr) {
        if (illlllllllllllllllllllArr.length != 0) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Arrays.asList(illlllllllllllllllllllArr);
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }

    @Override // me.tvspark.Illlllllllllllllllllll
    @NonNull
    public AbstractC1886O0<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Context context, @NonNull AbstractC1886O0<T> abstractC1886O0, int i, int i2) {
        AbstractC1886O0<T> abstractC1886O02 = abstractC1886O0;
        for (Illlllllllllllllllllll<T> illlllllllllllllllllll : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            AbstractC1886O0<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = illlllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, abstractC1886O02, i, i2);
            if (abstractC1886O02 != null && !abstractC1886O02.equals(abstractC1886O0) && !abstractC1886O02.equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                abstractC1886O02.recycle();
            }
            abstractC1886O02 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return abstractC1886O02;
    }

    @Override // me.tvspark.Illlllllllllllllllllllllllll
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull MessageDigest messageDigest) {
        for (Illlllllllllllllllllll<T> illlllllllllllllllllll : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            illlllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(messageDigest);
        }
    }

    @Override // me.tvspark.Illlllllllllllllllllllllllll
    public boolean equals(Object obj) {
        if (obj instanceof Illllllllllllllllllllllllll) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(((Illllllllllllllllllllllllll) obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        return false;
    }

    @Override // me.tvspark.Illlllllllllllllllllllllllll
    public int hashCode() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode();
    }
}
