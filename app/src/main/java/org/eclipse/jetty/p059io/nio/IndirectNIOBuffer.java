package org.eclipse.jetty.p059io.nio;

import java.nio.ByteBuffer;
import org.eclipse.jetty.p059io.ByteArrayBuffer;

/* renamed from: org.eclipse.jetty.io.nio.IndirectNIOBuffer */
/* loaded from: classes4.dex */
public class IndirectNIOBuffer extends ByteArrayBuffer implements NIOBuffer {
    public final ByteBuffer _buf;

    public IndirectNIOBuffer(int i) {
        super(i, 2, false);
        ByteBuffer wrap = ByteBuffer.wrap(this._bytes);
        this._buf = wrap;
        wrap.position(0);
        ByteBuffer byteBuffer = this._buf;
        byteBuffer.limit(byteBuffer.capacity());
    }

    public IndirectNIOBuffer(ByteBuffer byteBuffer, boolean z) {
        super(byteBuffer.array(), 0, 0, z ? 0 : 2, false);
        if (!byteBuffer.isDirect()) {
            this._buf = byteBuffer;
            this._get = byteBuffer.position();
            this._put = byteBuffer.limit();
            byteBuffer.position(0);
            byteBuffer.limit(byteBuffer.capacity());
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // org.eclipse.jetty.p059io.nio.NIOBuffer
    public ByteBuffer getByteBuffer() {
        return this._buf;
    }

    @Override // org.eclipse.jetty.p059io.nio.NIOBuffer
    public boolean isDirect() {
        return false;
    }
}
