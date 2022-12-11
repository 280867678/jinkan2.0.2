package org.eclipse.jetty.p059io.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import org.apache.commons.p056io.input.Tailer;
import org.eclipse.jetty.p059io.AbstractBuffer;
import org.eclipse.jetty.p059io.Buffer;

/* renamed from: org.eclipse.jetty.io.nio.RandomAccessFileBuffer */
/* loaded from: classes4.dex */
public class RandomAccessFileBuffer extends AbstractBuffer implements Buffer {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public final int _capacity;
    public final FileChannel _channel;
    public final RandomAccessFile _file;

    public RandomAccessFileBuffer(File file) throws FileNotFoundException {
        super(2, true);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        this._file = randomAccessFile;
        this._channel = randomAccessFile.getChannel();
        this._capacity = Integer.MAX_VALUE;
        setGetIndex(0);
        setPutIndex((int) file.length());
    }

    public RandomAccessFileBuffer(File file, int i) throws FileNotFoundException {
        super(2, true);
        this._capacity = i;
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        this._file = randomAccessFile;
        this._channel = randomAccessFile.getChannel();
        setGetIndex(0);
        setPutIndex((int) file.length());
    }

    public RandomAccessFileBuffer(File file, int i, int i2) throws FileNotFoundException {
        super(i2, true);
        this._capacity = i;
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, i2 == 2 ? "rw" : Tailer.RAF_MODE);
        this._file = randomAccessFile;
        this._channel = randomAccessFile.getChannel();
        setGetIndex(0);
        setPutIndex((int) file.length());
    }

    @Override // org.eclipse.jetty.p059io.Buffer
    public byte[] array() {
        return null;
    }

    @Override // org.eclipse.jetty.p059io.Buffer
    public int capacity() {
        return this._capacity;
    }

    @Override // org.eclipse.jetty.p059io.AbstractBuffer, org.eclipse.jetty.p059io.Buffer
    public void clear() {
        try {
            synchronized (this._file) {
                super.clear();
                this._file.setLength(0L);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override // org.eclipse.jetty.p059io.AbstractBuffer, org.eclipse.jetty.p059io.Buffer
    public byte peek() {
        byte readByte;
        synchronized (this._file) {
            try {
                try {
                    if (this._get != this._file.getFilePointer()) {
                        this._file.seek(this._get);
                    }
                    readByte = this._file.readByte();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return readByte;
    }

    @Override // org.eclipse.jetty.p059io.Buffer
    public byte peek(int i) {
        byte readByte;
        synchronized (this._file) {
            try {
                try {
                    this._file.seek(i);
                    readByte = this._file.readByte();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return readByte;
    }

    @Override // org.eclipse.jetty.p059io.Buffer
    public int peek(int i, byte[] bArr, int i2, int i3) {
        int read;
        synchronized (this._file) {
            try {
                try {
                    this._file.seek(i);
                    read = this._file.read(bArr, i2, i3);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return read;
    }

    @Override // org.eclipse.jetty.p059io.AbstractBuffer, org.eclipse.jetty.p059io.Buffer
    public int poke(int i, byte[] bArr, int i2, int i3) {
        synchronized (this._file) {
            try {
                try {
                    this._file.seek(i);
                    this._file.write(bArr, i2, i3);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i3;
    }

    @Override // org.eclipse.jetty.p059io.Buffer
    public void poke(int i, byte b) {
        synchronized (this._file) {
            try {
                try {
                    this._file.seek(i);
                    this._file.writeByte(b);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int writeTo(WritableByteChannel writableByteChannel, int i, int i2) throws IOException {
        int transferTo;
        synchronized (this._file) {
            transferTo = (int) this._channel.transferTo(i, i2, writableByteChannel);
        }
        return transferTo;
    }
}
