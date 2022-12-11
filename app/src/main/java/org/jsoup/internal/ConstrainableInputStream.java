package org.jsoup.internal;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import org.apache.commons.lang3.time.StopWatch;
import org.jsoup.helper.Validate;

/* loaded from: classes5.dex */
public final class ConstrainableInputStream extends BufferedInputStream {
    public static final int DefaultSize = 32768;
    public final boolean capped;
    public boolean interrupted;
    public final int maxSize;
    public int remaining;
    public long startTime;
    public long timeout = 0;

    public ConstrainableInputStream(InputStream inputStream, int i, int i2) {
        super(inputStream, i);
        boolean z = true;
        Validate.isTrue(i2 >= 0);
        this.maxSize = i2;
        this.remaining = i2;
        this.capped = i2 == 0 ? false : z;
        this.startTime = System.nanoTime();
    }

    private boolean expired() {
        return this.timeout != 0 && System.nanoTime() - this.startTime > this.timeout;
    }

    public static ConstrainableInputStream wrap(InputStream inputStream, int i, int i2) {
        return inputStream instanceof ConstrainableInputStream ? (ConstrainableInputStream) inputStream : new ConstrainableInputStream(inputStream, i, i2);
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (this.interrupted || (this.capped && this.remaining <= 0)) {
            return -1;
        }
        if (Thread.interrupted()) {
            this.interrupted = true;
            return -1;
        } else if (expired()) {
            throw new SocketTimeoutException("Read timeout");
        } else {
            if (this.capped && i2 > (i3 = this.remaining)) {
                i2 = i3;
            }
            try {
                int read = super.read(bArr, i, i2);
                this.remaining -= read;
                return read;
            } catch (SocketTimeoutException unused) {
                return 0;
            }
        }
    }

    public ByteBuffer readToByteBuffer(int i) throws IOException {
        boolean z = true;
        Validate.isTrue(i >= 0, "maxSize must be 0 (unlimited) or larger");
        if (i <= 0) {
            z = false;
        }
        int i2 = 32768;
        if (z && i < 32768) {
            i2 = i;
        }
        byte[] bArr = new byte[i2];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i2);
        while (true) {
            int read = read(bArr);
            if (read == -1) {
                break;
            }
            if (z) {
                if (read >= i) {
                    byteArrayOutputStream.write(bArr, 0, i);
                    break;
                }
                i -= read;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
        return ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        super.reset();
        this.remaining = this.maxSize - ((BufferedInputStream) this).markpos;
    }

    public ConstrainableInputStream timeout(long j, long j2) {
        this.startTime = j;
        this.timeout = j2 * StopWatch.NANO_2_MILLIS;
        return this;
    }
}
