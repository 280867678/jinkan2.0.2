package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import me.tvspark.AbstractC2715vj;
import me.tvspark.C1949bk;
import me.tvspark.C2374ml;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public final class AssetDataSource extends AbstractC2715vj {
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public InputStream Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public Uri Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final AssetManager Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes3.dex */
    public static final class AssetDataSourceException extends IOException {
        public AssetDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public AssetDataSource(Context context) {
        super(false);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = context.getAssets();
    }

    @Override // me.tvspark.AbstractC2863zj
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1949bk c1949bk) throws AssetDataSourceException {
        try {
            Uri uri = c1949bk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = uri;
            String path = uri.getPath();
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(path);
            String str = path;
            if (str.startsWith("/android_asset/")) {
                str = str.substring(15);
            } else if (str.startsWith("/")) {
                str = str.substring(1);
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c1949bk);
            InputStream open = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.open(str, 1);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = open;
            if (open.skip(c1949bk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) < c1949bk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                throw new EOFException();
            }
            if (c1949bk.Wwwwwwwwwwwwwwwwwwwwwwwwwwww != -1) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = c1949bk.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            } else {
                long available = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.available();
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = available;
                if (available == 2147483647L) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = -1L;
                }
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = true;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c1949bk);
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        } catch (IOException e) {
            throw new AssetDataSourceException(e);
        }
    }

    @Override // me.tvspark.AbstractC2863zj
    public void close() throws AssetDataSourceException {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        try {
            try {
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.close();
                }
            } catch (IOException e) {
                throw new AssetDataSourceException(e);
            }
        } finally {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwww = false;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }
    }

    @Override // me.tvspark.AbstractC2863zj
    @Nullable
    public Uri getUri() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2752wj
    public int read(byte[] bArr, int i, int i2) throws AssetDataSourceException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e) {
                throw new AssetDataSourceException(e);
            }
        }
        InputStream inputStream = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(inputStream);
        int read = inputStream.read(bArr, i, i2);
        if (read == -1) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww != -1) {
                throw new AssetDataSourceException(new EOFException());
            }
            return -1;
        }
        long j2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (j2 != -1) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = j2 - read;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(read);
        return read;
    }
}
