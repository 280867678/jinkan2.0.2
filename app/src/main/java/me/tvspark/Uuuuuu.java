package me.tvspark;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.InputStream;
import me.tvspark.Llllll;
import me.tvspark.Lllllll;

/* loaded from: classes4.dex */
public class Uuuuuu implements Llllll<Ooo, InputStream> {
    public static final Illlllllllllllllllllllllll<Integer> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illlllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);
    @Nullable
    public final Lllllll<Ooo, Ooo> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Lllll<Ooo, InputStream> {
        public final Lllllll<Ooo, Ooo> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Lllllll<>(500);

        @Override // me.tvspark.Lllll
        @NonNull
        public Llllll<Ooo, InputStream> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1884Ll c1884Ll) {
            return new Uuuuuu(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    public Uuuuuu(@Nullable Lllllll<Ooo, Ooo> lllllll) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = lllllll;
    }

    @Override // me.tvspark.Llllll
    public Llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<InputStream> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Ooo ooo, int i, int i2, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) {
        Ooo ooo2 = ooo;
        Lllllll<Ooo, Ooo> lllllll = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (lllllll != null) {
            Lllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Ooo> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Lllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ooo2, 0, 0);
            Ooo Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = lllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((C2465p1<Lllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Ooo>, Ooo>) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            Ooo ooo3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
            if (ooo3 == null) {
                Lllllll<Ooo, Ooo> lllllll2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (lllllll2 == null) {
                    throw null;
                }
                lllllll2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Lllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ooo2, 0, 0), ooo2);
            } else {
                ooo2 = ooo3;
            }
        }
        return new Llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(ooo2, new Illlllllllll(ooo2, ((Integer) illllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)).intValue()));
    }

    @Override // me.tvspark.Llllll
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Ooo ooo) {
        return true;
    }
}
