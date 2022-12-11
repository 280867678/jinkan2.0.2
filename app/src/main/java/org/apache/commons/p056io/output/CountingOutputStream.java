package org.apache.commons.p056io.output;

import java.io.OutputStream;

/* renamed from: org.apache.commons.io.output.CountingOutputStream */
/* loaded from: classes4.dex */
public class CountingOutputStream extends ProxyOutputStream {
    public long count = 0;

    public CountingOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // org.apache.commons.p056io.output.ProxyOutputStream
    public synchronized void beforeWrite(int i) {
        this.count += i;
    }

    public synchronized long getByteCount() {
        return this.count;
    }

    public int getCount() {
        long byteCount = getByteCount();
        if (byteCount <= 2147483647L) {
            return (int) byteCount;
        }
        throw new ArithmeticException("The byte count " + byteCount + " is too large to be converted to an int");
    }

    public synchronized long resetByteCount() {
        long j;
        j = this.count;
        this.count = 0L;
        return j;
    }

    public int resetCount() {
        long resetByteCount = resetByteCount();
        if (resetByteCount <= 2147483647L) {
            return (int) resetByteCount;
        }
        throw new ArithmeticException("The byte count " + resetByteCount + " is too large to be converted to an int");
    }
}
