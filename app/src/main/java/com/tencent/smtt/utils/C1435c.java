package com.tencent.smtt.utils;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import org.apache.commons.p056io.input.Tailer;

/* renamed from: com.tencent.smtt.utils.c */
/* loaded from: classes4.dex */
public class C1435c implements Closeable {

    /* renamed from: a */
    public final RandomAccessFile f2406a;

    /* renamed from: b */
    public final File f2407b;

    /* renamed from: c */
    public final byte[] f2408c;

    /* renamed from: d */
    public boolean f2409d;

    public C1435c(File file) throws FileNotFoundException {
        this.f2408c = new byte[8];
        this.f2407b = file;
        this.f2406a = new RandomAccessFile(this.f2407b, Tailer.RAF_MODE);
    }

    public C1435c(String str) throws FileNotFoundException {
        this(new File(str));
    }

    /* renamed from: a */
    public final int m2102a(byte[] bArr) throws IOException {
        return this.f2406a.read(bArr);
    }

    /* renamed from: a */
    public final int m2101a(char[] cArr) throws IOException {
        byte[] bArr = new byte[cArr.length];
        int read = this.f2406a.read(bArr);
        for (int i = 0; i < cArr.length; i++) {
            cArr[i] = (char) bArr[i];
        }
        return read;
    }

    /* renamed from: a */
    public final short m2105a() throws IOException {
        short readShort = this.f2406a.readShort();
        if (this.f2409d) {
            return (short) (((readShort & 65280) >>> 8) | ((readShort & 255) << 8));
        }
        return readShort;
    }

    /* renamed from: a */
    public void m2104a(long j) throws IOException {
        this.f2406a.seek(j);
    }

    /* renamed from: a */
    public void m2103a(boolean z) {
        this.f2409d = z;
    }

    /* renamed from: b */
    public final int m2100b() throws IOException {
        int readInt = this.f2406a.readInt();
        if (this.f2409d) {
            return ((readInt & (-16777216)) >>> 24) | ((readInt & 255) << 24) | ((65280 & readInt) << 8) | ((16711680 & readInt) >>> 8);
        }
        return readInt;
    }

    /* renamed from: c */
    public final long m2099c() throws IOException {
        if (this.f2409d) {
            this.f2406a.readFully(this.f2408c, 0, 8);
            byte[] bArr = this.f2408c;
            return ((bArr[1] & 255) << 8) | (bArr[7] << 56) | ((bArr[6] & 255) << 48) | ((bArr[5] & 255) << 40) | ((bArr[4] & 255) << 32) | ((bArr[3] & 255) << 24) | ((bArr[2] & 255) << 16) | (bArr[0] & 255);
        }
        return this.f2406a.readLong();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.f2406a.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
