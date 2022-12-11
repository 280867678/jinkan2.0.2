package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import me.tvspark.AbstractC2715vj;
import me.tvspark.C1949bk;
import me.tvspark.C2374ml;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public final class RawResourceDataSource extends AbstractC2715vj {
    public boolean Wwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public InputStream Wwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public AssetFileDescriptor Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public Uri Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Resources Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes3.dex */
    public static class RawResourceDataSourceException extends IOException {
        public RawResourceDataSourceException(IOException iOException) {
            super(iOException);
        }

        public RawResourceDataSourceException(String str) {
            super(str);
        }
    }

    public RawResourceDataSource(Context context) {
        super(false);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = context.getResources();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = context.getPackageName();
    }

    public static Uri buildRawResourceUri(int i) {
        StringBuilder sb = new StringBuilder(26);
        sb.append("rawresource:///");
        sb.append(i);
        return Uri.parse(sb.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0036, code lost:
        if (r1.matches("\\d+") != false) goto L53;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x010b  */
    @Override // me.tvspark.AbstractC2863zj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1949bk c1949bk) throws RawResourceDataSourceException {
        int parseInt;
        AssetFileDescriptor openRawResourceFd;
        Uri uri = c1949bk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = uri;
        try {
            if (!TextUtils.equals("rawresource", uri.getScheme())) {
                if (TextUtils.equals("android.resource", uri.getScheme()) && uri.getPathSegments().size() == 1) {
                    String lastPathSegment = uri.getLastPathSegment();
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(lastPathSegment);
                }
                if (!TextUtils.equals("android.resource", uri.getScheme())) {
                    throw new RawResourceDataSourceException("URI must either use scheme rawresource or android.resource");
                }
                String path = uri.getPath();
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(path);
                String str = path;
                if (str.startsWith("/")) {
                    str = str.substring(1);
                }
                String host = uri.getHost();
                String valueOf = String.valueOf(TextUtils.isEmpty(host) ? "" : String.valueOf(host).concat(":"));
                String valueOf2 = String.valueOf(str);
                parseInt = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getIdentifier(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), "raw", this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                if (parseInt == 0) {
                    throw new RawResourceDataSourceException("Resource not found.");
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c1949bk);
                openRawResourceFd = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.openRawResourceFd(parseInt);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = openRawResourceFd;
                if (openRawResourceFd != null) {
                    String valueOf3 = String.valueOf(uri);
                    StringBuilder sb = new StringBuilder(valueOf3.length() + 24);
                    sb.append("Resource is compressed: ");
                    sb.append(valueOf3);
                    throw new RawResourceDataSourceException(sb.toString());
                }
                FileInputStream fileInputStream = new FileInputStream(openRawResourceFd.getFileDescriptor());
                this.Wwwwwwwwwwwwwwwwwwwwwwwwww = fileInputStream;
                try {
                    fileInputStream.skip(openRawResourceFd.getStartOffset());
                    if (fileInputStream.skip(c1949bk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) < c1949bk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        throw new EOFException();
                    }
                    long j = c1949bk.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    long j2 = -1;
                    if (j != -1) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwww = j;
                    } else {
                        long length = openRawResourceFd.getLength();
                        if (length != -1) {
                            j2 = length - c1949bk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        }
                        this.Wwwwwwwwwwwwwwwwwwwwwwwww = j2;
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwwwww = true;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c1949bk);
                    return this.Wwwwwwwwwwwwwwwwwwwwwwwww;
                } catch (IOException e) {
                    throw new RawResourceDataSourceException(e);
                }
            }
            String lastPathSegment2 = uri.getLastPathSegment();
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(lastPathSegment2);
            parseInt = Integer.parseInt(lastPathSegment2);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c1949bk);
            openRawResourceFd = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.openRawResourceFd(parseInt);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = openRawResourceFd;
            if (openRawResourceFd != null) {
            }
        } catch (NumberFormatException unused) {
            throw new RawResourceDataSourceException("Resource identifier must be an integer.");
        }
    }

    @Override // me.tvspark.AbstractC2863zj
    public void close() throws RawResourceDataSourceException {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        try {
            try {
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwww.close();
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwww = null;
                try {
                    try {
                        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.close();
                        }
                    } catch (IOException e) {
                        throw new RawResourceDataSourceException(e);
                    }
                } finally {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                    if (this.Wwwwwwwwwwwwwwwwwwwwwwww) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwww = false;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    }
                }
            } catch (IOException e2) {
                throw new RawResourceDataSourceException(e2);
            }
        } catch (Throwable th) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = null;
            try {
                try {
                    if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.close();
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                    if (this.Wwwwwwwwwwwwwwwwwwwwwwww) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwww = false;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    }
                    throw th;
                } catch (IOException e3) {
                    throw new RawResourceDataSourceException(e3);
                }
            } finally {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                if (this.Wwwwwwwwwwwwwwwwwwwwwwww) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwww = false;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
            }
        }
    }

    @Override // me.tvspark.AbstractC2863zj
    @Nullable
    public Uri getUri() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2752wj
    public int read(byte[] bArr, int i, int i2) throws RawResourceDataSourceException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e) {
                throw new RawResourceDataSourceException(e);
            }
        }
        InputStream inputStream = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(inputStream);
        int read = inputStream.read(bArr, i, i2);
        if (read == -1) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwww != -1) {
                throw new RawResourceDataSourceException(new EOFException());
            }
            return -1;
        }
        long j2 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
        if (j2 != -1) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwww = j2 - read;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(read);
        return read;
    }
}
