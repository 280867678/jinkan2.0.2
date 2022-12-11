package me.tvspark;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.Loader;
import java.io.FileNotFoundException;
import java.io.IOException;
import me.tvspark.AbstractC2299kk;

/* renamed from: me.tvspark.ik */
/* loaded from: classes4.dex */
public class C2225ik implements AbstractC2299kk {
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;

    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2299kk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        IOException iOException = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if ((iOException instanceof ParserException) || (iOException instanceof FileNotFoundException) || (iOException instanceof Loader.UnexpectedLoaderException)) {
            return -9223372036854775807L;
        }
        return Math.min((wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1) * 1000, 5000);
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        return i2 == -1 ? i == 7 ? 6 : 3 : i2;
    }

    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2299kk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        IOException iOException = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (iOException instanceof HttpDataSource.InvalidResponseCodeException) {
            int i = ((HttpDataSource.InvalidResponseCodeException) iOException).responseCode;
            return (i == 403 || i == 404 || i == 410 || i == 416 || i == 500 || i == 503) ? 60000L : -9223372036854775807L;
        }
        return -9223372036854775807L;
    }

    @Override // me.tvspark.AbstractC2299kk
    public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        C2262jk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, j);
    }
}
