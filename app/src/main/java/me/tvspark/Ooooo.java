package me.tvspark;

import android.util.Base64;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import me.tvspark.Illlllllllllllllll;
import me.tvspark.Llllll;

/* loaded from: classes4.dex */
public final class Ooooo<Model, Data> implements Llllll<Model, Data> {
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Data> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Model> implements Lllll<Model, InputStream> {
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<InputStream> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<InputStream> {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            }

            public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) throws IllegalArgumentException {
                if (str.startsWith("data:image")) {
                    int indexOf = str.indexOf(44);
                    if (indexOf == -1) {
                        throw new IllegalArgumentException("Missing comma in data URL.");
                    }
                    if (!str.substring(0, indexOf).endsWith(";base64")) {
                        throw new IllegalArgumentException("Not a base64 image data URL.");
                    }
                    return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                }
                throw new IllegalArgumentException("Not a valid image data URL.");
            }
        }

        @Override // me.tvspark.Lllll
        @NonNull
        public Llllll<Model, InputStream> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull C1884Ll c1884Ll) {
            return new Ooooo(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Data> implements Illlllllllllllllll<Data> {
        public Data Wwwwwwwwwwwwwwwwwwwwww;
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Data> Wwwwwwwwwwwwwwwwwwwwwww;
        public final String Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Data> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = str;
            this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.Illlllllllllllllll
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Data> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww;
                Data data = this.Wwwwwwwwwwwwwwwwwwwwww;
                if (((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != null) {
                    ((InputStream) data).close();
                    return;
                }
                throw null;
            } catch (IOException unused) {
            }
        }

        @Override // me.tvspark.Illlllllllllllllll
        @NonNull
        public Class<Data> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            if (((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this.Wwwwwwwwwwwwwwwwwwwwwww) != null) {
                return InputStream.class;
            }
            throw null;
        }

        /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, Data] */
        @Override // me.tvspark.Illlllllllllllllll
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Priority priority, @NonNull Illlllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<? super Data> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            try {
                ?? r2 = (Data) ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this.Wwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwwwwww = r2;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Illlllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<? super Data>) r2);
            } catch (IllegalArgumentException e) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Exception) e);
            }
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
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Data> {
    }

    public Ooooo(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Data> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.Llllll
    public Llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Data> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Model model, int i, int i2, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) {
        return new Llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(new C2243j1(model), new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(model.toString(), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
    }

    @Override // me.tvspark.Llllll
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Model model) {
        return model.toString().startsWith("data:image");
    }
}
