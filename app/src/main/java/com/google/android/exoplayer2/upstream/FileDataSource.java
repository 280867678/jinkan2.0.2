package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import me.tvspark.AbstractC2715vj;
import me.tvspark.C1949bk;
import me.tvspark.C2374ml;
import me.tvspark.Illllllllllllllllllllllllllll;
import org.apache.commons.p056io.input.Tailer;

/* loaded from: classes3.dex */
public final class FileDataSource extends AbstractC2715vj {
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public Uri Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public RandomAccessFile Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes3.dex */
    public static class FileDataSourceException extends IOException {
        public FileDataSourceException(IOException iOException) {
            super(iOException);
        }

        public FileDataSourceException(String str, IOException iOException) {
            super(str, iOException);
        }
    }

    public FileDataSource() {
        super(false);
    }

    public static RandomAccessFile Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri uri) throws FileDataSourceException {
        try {
            String path = uri.getPath();
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(path);
            return new RandomAccessFile(path, Tailer.RAF_MODE);
        } catch (FileNotFoundException e) {
            if (TextUtils.isEmpty(uri.getQuery()) && TextUtils.isEmpty(uri.getFragment())) {
                throw new FileDataSourceException(e);
            }
            throw new FileDataSourceException(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", uri.getPath(), uri.getQuery(), uri.getFragment()), e);
        }
    }

    @Override // me.tvspark.AbstractC2863zj
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1949bk c1949bk) throws FileDataSourceException {
        try {
            Uri uri = c1949bk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = uri;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c1949bk);
            RandomAccessFile Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uri);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.seek(c1949bk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            long length = c1949bk.Wwwwwwwwwwwwwwwwwwwwwwwwwwww == -1 ? this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length() - c1949bk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww : c1949bk.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = length;
            if (length < 0) {
                throw new EOFException();
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c1949bk);
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        } catch (IOException e) {
            throw new FileDataSourceException(e);
        }
    }

    @Override // me.tvspark.AbstractC2863zj
    public void close() throws FileDataSourceException {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        try {
            try {
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.close();
                }
            } catch (IOException e) {
                throw new FileDataSourceException(e);
            }
        } finally {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = false;
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
    public int read(byte[] bArr, int i, int i2) throws FileDataSourceException {
        if (i2 == 0) {
            return 0;
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww == 0) {
            return -1;
        }
        try {
            RandomAccessFile randomAccessFile = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(randomAccessFile);
            int read = randomAccessFile.read(bArr, i, (int) Math.min(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, i2));
            if (read > 0) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww -= read;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(read);
            }
            return read;
        } catch (IOException e) {
            throw new FileDataSourceException(e);
        }
    }
}
