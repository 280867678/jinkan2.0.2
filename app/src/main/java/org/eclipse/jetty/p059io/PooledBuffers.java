package org.eclipse.jetty.p059io;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.jetty.p059io.Buffers;

/* renamed from: org.eclipse.jetty.io.PooledBuffers */
/* loaded from: classes4.dex */
public class PooledBuffers extends AbstractBuffers {
    public final int _maxSize;
    public final boolean _otherBuffers;
    public final boolean _otherHeaders;
    public final AtomicInteger _size = new AtomicInteger();
    public final Queue<Buffer> _headers = new ConcurrentLinkedQueue();
    public final Queue<Buffer> _buffers = new ConcurrentLinkedQueue();
    public final Queue<Buffer> _others = new ConcurrentLinkedQueue();

    public PooledBuffers(Buffers.Type type, int i, Buffers.Type type2, int i2, Buffers.Type type3, int i3) {
        super(type, i, type2, i2, type3);
        boolean z = true;
        this._otherHeaders = type == type3;
        this._otherBuffers = type2 != type3 ? false : z;
        this._maxSize = i3;
    }

    @Override // org.eclipse.jetty.p059io.Buffers
    public Buffer getBuffer() {
        Buffer poll = this._buffers.poll();
        if (poll == null) {
            return newBuffer();
        }
        this._size.decrementAndGet();
        return poll;
    }

    @Override // org.eclipse.jetty.p059io.Buffers
    public Buffer getBuffer(int i) {
        Buffer poll;
        if (!this._otherHeaders || i != getHeaderSize()) {
            if (this._otherBuffers && i == getBufferSize()) {
                return getBuffer();
            }
            while (true) {
                poll = this._others.poll();
                if (poll == null || poll.capacity() == i) {
                    break;
                }
                this._size.decrementAndGet();
            }
            if (poll == null) {
                return newBuffer(i);
            }
            this._size.decrementAndGet();
            return poll;
        }
        return getHeader();
    }

    @Override // org.eclipse.jetty.p059io.Buffers
    public Buffer getHeader() {
        Buffer poll = this._headers.poll();
        if (poll == null) {
            return newHeader();
        }
        this._size.decrementAndGet();
        return poll;
    }

    @Override // org.eclipse.jetty.p059io.Buffers
    public void returnBuffer(Buffer buffer) {
        buffer.clear();
        if (buffer.isVolatile() || buffer.isImmutable()) {
            return;
        }
        if (this._size.incrementAndGet() > this._maxSize) {
            this._size.decrementAndGet();
        } else {
            (isHeader(buffer) ? this._headers : isBuffer(buffer) ? this._buffers : this._others).add(buffer);
        }
    }

    @Override // org.eclipse.jetty.p059io.AbstractBuffers
    public String toString() {
        return String.format("%s [%d/%d@%d,%d/%d@%d,%d/%d@-]", PooledBuffers.class.getSimpleName(), Integer.valueOf(this._headers.size()), Integer.valueOf(this._maxSize), Integer.valueOf(this._headerSize), Integer.valueOf(this._buffers.size()), Integer.valueOf(this._maxSize), Integer.valueOf(this._bufferSize), Integer.valueOf(this._others.size()), Integer.valueOf(this._maxSize));
    }
}
