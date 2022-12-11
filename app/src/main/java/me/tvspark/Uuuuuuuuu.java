package me.tvspark;

import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import me.tvspark.Illlllllllllllllll;
import me.tvspark.Llllll;

/* loaded from: classes4.dex */
public class Uuuuuuuuu<Model> implements Llllll<Model, Model> {
    public static final Uuuuuuuuu<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Uuuuuuuuu<>();

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Model> implements Illlllllllllllllll<Model> {
        public final Model Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Model model) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = model;
        }

        @Override // me.tvspark.Illlllllllllllllll
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.Illlllllllllllllll
        @NonNull
        public Class<Model> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return (Class<Model>) this.Wwwwwwwwwwwwwwwwwwwwwwww.getClass();
        }

        @Override // me.tvspark.Illlllllllllllllll
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Priority priority, @NonNull Illlllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<? super Model> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Illlllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<? super Model>) ((Model) this.Wwwwwwwwwwwwwwwwwwwwwwww));
        }

        @Override // me.tvspark.Illlllllllllllllll
        public void cancel() {
        }

        @Override // me.tvspark.Illlllllllllllllll
        @NonNull
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Model> implements Lllll<Model, Model> {
        public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>();

        @Override // me.tvspark.Lllll
        @NonNull
        public Llllll<Model, Model> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1884Ll c1884Ll) {
            return Uuuuuuuuu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    @Override // me.tvspark.Llllll
    public Llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Model> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Model model, int i, int i2, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) {
        return new Llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(new C2243j1(model), new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(model));
    }

    @Override // me.tvspark.Llllll
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Model model) {
        return true;
    }
}
