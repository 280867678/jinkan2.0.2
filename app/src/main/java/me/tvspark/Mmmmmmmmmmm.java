package me.tvspark;

import android.media.MediaDataSource;
import java.nio.ByteBuffer;
import me.tvspark.C1881Cc;

/* loaded from: classes4.dex */
public class Mmmmmmmmmmm extends MediaDataSource {
    public final /* synthetic */ ByteBuffer Wwwwwwwwwwwwwwwwwwwwwwww;

    public Mmmmmmmmmmm(C1881Cc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, ByteBuffer byteBuffer) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = byteBuffer;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // android.media.MediaDataSource
    public long getSize() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.limit();
    }

    @Override // android.media.MediaDataSource
    public int readAt(long j, byte[] bArr, int i, int i2) {
        if (j >= this.Wwwwwwwwwwwwwwwwwwwwwwww.limit()) {
            return -1;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwww.position((int) j);
        int min = Math.min(i2, this.Wwwwwwwwwwwwwwwwwwwwwwww.remaining());
        this.Wwwwwwwwwwwwwwwwwwwwwwww.get(bArr, i, min);
        return min;
    }
}
