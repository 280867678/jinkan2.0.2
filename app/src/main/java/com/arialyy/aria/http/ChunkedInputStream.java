package com.arialyy.aria.http;

import com.arialyy.aria.util.ALog;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import me.tvspark.outline;

@Deprecated
/* loaded from: classes3.dex */
public class ChunkedInputStream extends InputStream {
    public static final String TAG = "ChunkedInputStream";
    public DataInputStream din;

    /* renamed from: id */
    public String f164id;
    public int unreadBytes = 0;
    public byte[] singleByte = new byte[1];
    public boolean endOfData = false;

    public ChunkedInputStream(InputStream inputStream, String str) {
        this.din = new DataInputStream(inputStream);
        this.f164id = str;
        ALog.m4192d(TAG, String.format("Creating chunked input for %s", str));
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ALog.m4192d(TAG, String.format("%s: Closing chunked input.", this.f164id));
        this.din.close();
    }

    public boolean isEndOfData() {
        return this.endOfData;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.singleByte, 0, 1) == -1) {
            return -1;
        }
        return this.singleByte[0];
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 >= 0) {
            if (i2 == 0) {
                return 0;
            }
            if (this.unreadBytes == 0) {
                try {
                    int readInt = this.din.readInt();
                    this.unreadBytes = readInt;
                    ALog.m4192d(TAG, String.format("%s: Chunk size %s", this.f164id, Integer.valueOf(readInt)));
                    if (this.unreadBytes == 0) {
                        ALog.m4192d(TAG, String.format("%s: Hit end of data", this.f164id));
                        this.endOfData = true;
                        return -1;
                    }
                } catch (IOException e) {
                    throw new IOException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new StringBuilder(), this.f164id, ": Error while attempting to read chunk length"), e);
                }
            }
            int min = Math.min(i2, this.unreadBytes);
            try {
                this.din.readFully(bArr, i, min);
                this.unreadBytes -= min;
                return 0 + min;
            } catch (IOException e2) {
                throw new IOException(this.f164id + ": Error while attempting to read " + min + " bytes from current chunk", e2);
            }
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new StringBuilder(), this.f164id, ": Negative read length"));
    }
}
