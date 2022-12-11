package me.tvspark;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import me.tvspark.Illllllllllllllll;

/* loaded from: classes4.dex */
public final class Illllllllll implements Illllllllllllllll<InputStream> {
    public final RecyclableBufferedInputStream Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Illllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<InputStream> {
        public final OO000 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(OO000 oo000) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = oo000;
        }

        @Override // me.tvspark.Illllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        @NonNull
        public Class<InputStream> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return InputStream.class;
        }

        @Override // me.tvspark.Illllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        @NonNull
        public Illllllllllllllll<InputStream> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(InputStream inputStream) {
            return new Illllllllll(inputStream, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    public Illllllllll(InputStream inputStream, OO000 oo000) {
        RecyclableBufferedInputStream recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, oo000);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = recyclableBufferedInputStream;
        recyclableBufferedInputStream.mark(5242880);
    }

    @Override // me.tvspark.Illllllllllllllll
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.tvspark.Illllllllllllllll
    @NonNull
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    public InputStream mo4924Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.reset();
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}
