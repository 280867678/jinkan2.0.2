package me.tvspark;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import me.tvspark.Illlllllllllllllll;
import me.tvspark.Llllll;

/* loaded from: classes4.dex */
public class Oooo<Data> implements Llllll<File, Data> {
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Data> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<InputStream> {

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<InputStream> {
            @Override // me.tvspark.Oooo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
            public Class<InputStream> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                return InputStream.class;
            }

            @Override // me.tvspark.Oooo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
            public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // me.tvspark.Oooo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
            public InputStream Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(File file) throws FileNotFoundException {
                return new FileInputStream(file);
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            super(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Data> {
        Class<Data> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

        Data Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(File file) throws FileNotFoundException;

        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Data data) throws IOException;
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Data> implements Illlllllllllllllll<Data> {
        public Data Wwwwwwwwwwwwwwwwwwwwww;
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Data> Wwwwwwwwwwwwwwwwwwwwwww;
        public final File Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(File file, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Data> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = file;
            this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.Illlllllllllllllll
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            Data data = this.Wwwwwwwwwwwwwwwwwwwwww;
            if (data != null) {
                try {
                    this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Data>) data);
                } catch (IOException unused) {
                }
            }
        }

        @Override // me.tvspark.Illlllllllllllllll
        @NonNull
        public Class<Data> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object, Data] */
        @Override // me.tvspark.Illlllllllllllllll
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Priority priority, @NonNull Illlllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<? super Data> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            try {
                Data Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Illlllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<? super Data>) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            } catch (FileNotFoundException e) {
                Log.isLoggable("FileLoader", 3);
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
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<ParcelFileDescriptor> {

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<ParcelFileDescriptor> {
            @Override // me.tvspark.Oooo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
            public Class<ParcelFileDescriptor> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                return ParcelFileDescriptor.class;
            }

            @Override // me.tvspark.Oooo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
            public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                parcelFileDescriptor.close();
            }

            @Override // me.tvspark.Oooo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
            public ParcelFileDescriptor Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(File file) throws FileNotFoundException {
                return ParcelFileDescriptor.open(file, 268435456);
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            super(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Data> implements Lllll<File, Data> {
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Data> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Data> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.Lllll
        @NonNull
        public final Llllll<File, Data> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull C1884Ll c1884Ll) {
            return new Oooo(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    public Oooo(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Data> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.Llllll
    public Llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull File file, int i, int i2, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) {
        File file2 = file;
        return new Llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new C2243j1(file2), new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file2, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
    }

    @Override // me.tvspark.Llllll
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull File file) {
        return true;
    }
}
