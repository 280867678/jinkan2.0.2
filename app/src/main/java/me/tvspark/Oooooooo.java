package me.tvspark;

import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import me.tvspark.Illlllllllllllllll;
import me.tvspark.Llllll;

/* loaded from: classes4.dex */
public class Oooooooo<Data> implements Llllll<byte[], Data> {
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Data> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Lllll<byte[], InputStream> {

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<InputStream> {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            }

            @Override // me.tvspark.Oooooooo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
            public Class<InputStream> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                return InputStream.class;
            }

            @Override // me.tvspark.Oooooooo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
            public InputStream Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }
        }

        @Override // me.tvspark.Lllll
        @NonNull
        public Llllll<byte[], InputStream> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull C1884Ll c1884Ll) {
            return new Oooooooo(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this));
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Data> implements Illlllllllllllllll<Data> {
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Data> Wwwwwwwwwwwwwwwwwwwwwww;
        public final byte[] Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Data> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = bArr;
            this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.Illlllllllllllllll
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.Illlllllllllllllll
        @NonNull
        public Class<Data> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // me.tvspark.Illlllllllllllllll
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Priority priority, @NonNull Illlllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<? super Data> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Illlllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<? super Data>) ((Data) this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww)));
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
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Data> {
        Class<Data> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

        Data Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr);
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Lllll<byte[], ByteBuffer> {

        /* renamed from: me.tvspark.Oooooooo$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C3462Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<ByteBuffer> {
            public C3462Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            }

            @Override // me.tvspark.Oooooooo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
            public Class<ByteBuffer> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                return ByteBuffer.class;
            }

            @Override // me.tvspark.Oooooooo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
            public ByteBuffer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }
        }

        @Override // me.tvspark.Lllll
        @NonNull
        public Llllll<byte[], ByteBuffer> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull C1884Ll c1884Ll) {
            return new Oooooooo(new C3462Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this));
        }
    }

    public Oooooooo(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Data> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.Llllll
    public Llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull byte[] bArr, int i, int i2, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) {
        byte[] bArr2 = bArr;
        return new Llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new C2243j1(bArr2), new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr2, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
    }

    @Override // me.tvspark.Llllll
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull byte[] bArr) {
        return true;
    }
}
