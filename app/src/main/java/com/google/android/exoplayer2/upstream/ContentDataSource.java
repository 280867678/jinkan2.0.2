package com.google.android.exoplayer2.upstream;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;
import me.tvspark.AbstractC2715vj;
import me.tvspark.C1949bk;
import me.tvspark.C2374ml;
import org.apache.commons.p056io.input.Tailer;

/* loaded from: classes3.dex */
public final class ContentDataSource extends AbstractC2715vj {
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public FileInputStream Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public AssetFileDescriptor Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public Uri Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final ContentResolver Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes3.dex */
    public static class ContentDataSourceException extends IOException {
        public ContentDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public ContentDataSource(Context context) {
        super(false);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = context.getContentResolver();
    }

    @Override // me.tvspark.AbstractC2863zj
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1949bk c1949bk) throws ContentDataSourceException {
        try {
            Uri uri = c1949bk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = uri;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c1949bk);
            AssetFileDescriptor openAssetFileDescriptor = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.openAssetFileDescriptor(uri, Tailer.RAF_MODE);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = openAssetFileDescriptor;
            if (openAssetFileDescriptor == null) {
                String valueOf = String.valueOf(uri);
                StringBuilder sb = new StringBuilder(valueOf.length() + 36);
                sb.append("Could not open file descriptor for: ");
                sb.append(valueOf);
                throw new FileNotFoundException(sb.toString());
            }
            FileInputStream fileInputStream = new FileInputStream(openAssetFileDescriptor.getFileDescriptor());
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = fileInputStream;
            long startOffset = openAssetFileDescriptor.getStartOffset();
            long skip = fileInputStream.skip(c1949bk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww + startOffset) - startOffset;
            if (skip != c1949bk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                throw new EOFException();
            }
            if (c1949bk.Wwwwwwwwwwwwwwwwwwwwwwwwwwww != -1) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwww = c1949bk.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            } else {
                long length = openAssetFileDescriptor.getLength();
                if (length == -1) {
                    FileChannel channel = fileInputStream.getChannel();
                    long size = channel.size();
                    if (size == 0) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = -1L;
                    } else {
                        long position = size - channel.position();
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = position;
                        if (position < 0) {
                            throw new EOFException();
                        }
                    }
                } else {
                    long j = length - skip;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwww = j;
                    if (j < 0) {
                        throw new EOFException();
                    }
                }
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwww = true;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c1949bk);
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        } catch (IOException e) {
            throw new ContentDataSourceException(e);
        }
    }

    @Override // me.tvspark.AbstractC2863zj
    public void close() throws ContentDataSourceException {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        try {
            try {
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.close();
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                try {
                    try {
                        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.close();
                        }
                    } catch (IOException e) {
                        throw new ContentDataSourceException(e);
                    }
                } finally {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                    if (this.Wwwwwwwwwwwwwwwwwwwwwwwww) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwww = false;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    }
                }
            } catch (IOException e2) {
                throw new ContentDataSourceException(e2);
            }
        } catch (Throwable th) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            try {
                try {
                    if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.close();
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                    if (this.Wwwwwwwwwwwwwwwwwwwwwwwww) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwww = false;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    }
                    throw th;
                } catch (IOException e3) {
                    throw new ContentDataSourceException(e3);
                }
            } finally {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwww) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwww = false;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
            }
        }
    }

    @Override // me.tvspark.AbstractC2863zj
    @Nullable
    public Uri getUri() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2752wj
    public int read(byte[] bArr, int i, int i2) throws ContentDataSourceException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e) {
                throw new ContentDataSourceException(e);
            }
        }
        FileInputStream fileInputStream = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fileInputStream);
        int read = fileInputStream.read(bArr, i, i2);
        if (read == -1) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwww != -1) {
                throw new ContentDataSourceException(new EOFException());
            }
            return -1;
        }
        long j2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        if (j2 != -1) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = j2 - read;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(read);
        return read;
    }
}
