package me.tvspark;

import androidx.annotation.NonNull;
import java.io.IOException;
import java.nio.ByteBuffer;
import me.tvspark.Illllllllllllllll;

/* loaded from: classes4.dex */
public class Mmmmmmmmmm implements Illllllllllllllll<ByteBuffer> {
    public final ByteBuffer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Illllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<ByteBuffer> {
        @Override // me.tvspark.Illllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        @NonNull
        public Class<ByteBuffer> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return ByteBuffer.class;
        }

        @Override // me.tvspark.Illllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        @NonNull
        public Illllllllllllllll<ByteBuffer> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteBuffer byteBuffer) {
            return new Mmmmmmmmmm(byteBuffer);
        }
    }

    public Mmmmmmmmmm(ByteBuffer byteBuffer) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = byteBuffer;
    }

    @Override // me.tvspark.Illllllllllllllll
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
    }

    @Override // me.tvspark.Illllllllllllllll
    @NonNull
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    public ByteBuffer mo4924Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.position(0);
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}
