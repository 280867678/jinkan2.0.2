package me.tvspark;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: me.tvspark.n0 */
/* loaded from: classes4.dex */
public class C2390n0 {
    public final List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();

    /* renamed from: me.tvspark.n0$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> {
        public final Illllllllllllllllllllll<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final Class<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Class<T> cls, @NonNull Illllllllllllllllllllll<T> illllllllllllllllllllll) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = cls;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = illllllllllllllllllllll;
        }
    }

    @Nullable
    public synchronized <Z> Illllllllllllllllllllll<Z> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Class<Z> cls) {
        int size = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
        for (int i = 0; i < size; i++) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i);
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isAssignableFrom(cls)) {
                return (Illllllllllllllllllllll<Z>) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
        }
        return null;
    }

    public synchronized <Z> void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Class<Z> cls, @NonNull Illllllllllllllllllllll<Z> illllllllllllllllllllll) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(cls, illllllllllllllllllllll));
    }
}
