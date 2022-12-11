package me.tvspark;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import me.tvspark.Illlllllllllllllll;
import me.tvspark.Llllll;

/* loaded from: classes4.dex */
public class Oooooo implements Llllll<File, ByteBuffer> {

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Lllll<File, ByteBuffer> {
        @Override // me.tvspark.Lllll
        @NonNull
        public Llllll<File, ByteBuffer> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull C1884Ll c1884Ll) {
            return new Oooooo();
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Illlllllllllllllll<ByteBuffer> {
        public final File Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(File file) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = file;
        }

        @Override // me.tvspark.Illlllllllllllllll
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.Illlllllllllllllll
        @NonNull
        public Class<ByteBuffer> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return ByteBuffer.class;
        }

        @Override // me.tvspark.Illlllllllllllllll
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Priority priority, @NonNull Illlllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<? super ByteBuffer> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            try {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Illlllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<? super ByteBuffer>) C2280k1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww));
            } catch (IOException e) {
                Log.isLoggable("ByteBufferFileLoader", 3);
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

    @Override // me.tvspark.Llllll
    public Llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<ByteBuffer> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull File file, int i, int i2, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) {
        File file2 = file;
        return new Llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(new C2243j1(file2), new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file2));
    }

    @Override // me.tvspark.Llllll
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull File file) {
        return true;
    }
}
