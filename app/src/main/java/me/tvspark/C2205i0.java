package me.tvspark;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: me.tvspark.i0 */
/* loaded from: classes4.dex */
public class C2205i0 {
    public final List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();

    /* renamed from: me.tvspark.i0$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> {
        public final AbstractC1883Kk<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final Class<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Class<T> cls, @NonNull AbstractC1883Kk<T> abstractC1883Kk) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = cls;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC1883Kk;
        }
    }

    @Nullable
    public synchronized <T> AbstractC1883Kk<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Class<T> cls) {
        for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isAssignableFrom(cls)) {
                return (AbstractC1883Kk<T>) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
        }
        return null;
    }

    public synchronized <T> void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Class<T> cls, @NonNull AbstractC1883Kk<T> abstractC1883Kk) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(cls, abstractC1883Kk));
    }
}
