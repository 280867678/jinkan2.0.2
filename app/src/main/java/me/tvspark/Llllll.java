package me.tvspark;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public interface Llllll<Model, Data> {

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Data> {
        public final Illlllllllllllllll<Data> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final List<Illlllllllllllllllllllllllll> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final Illlllllllllllllllllllllllll Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Illlllllllllllllllllllllllll illlllllllllllllllllllllllll, @NonNull Illlllllllllllllll<Data> illlllllllllllllll) {
            List<Illlllllllllllllllllllllllll> emptyList = Collections.emptyList();
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(illlllllllllllllllllllllllll, "Argument must not be null");
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = illlllllllllllllllllllllllll;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(emptyList, "Argument must not be null");
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = emptyList;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(illlllllllllllllll, "Argument must not be null");
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = illlllllllllllllll;
        }
    }

    @Nullable
    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Data> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Model model, int i, int i2, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll);

    boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Model model);
}
