package org.eclipse.jetty.p059io;

import org.eclipse.jetty.p059io.Buffer;

/* renamed from: org.eclipse.jetty.io.View */
/* loaded from: classes4.dex */
public class View extends AbstractBuffer {
    public Buffer _buffer;

    /* renamed from: org.eclipse.jetty.io.View$CaseInsensitive */
    /* loaded from: classes4.dex */
    public static class CaseInsensitive extends View implements Buffer.CaseInsensitve {
        public CaseInsensitive() {
        }

        public CaseInsensitive(Buffer buffer) {
            super(buffer);
        }

        public CaseInsensitive(Buffer buffer, int i, int i2, int i3, int i4) {
            super(buffer, i, i2, i3, i4);
        }

        @Override // org.eclipse.jetty.p059io.View, org.eclipse.jetty.p059io.AbstractBuffer
        public boolean equals(Object obj) {
            return this == obj || ((obj instanceof Buffer) && ((Buffer) obj).equalsIgnoreCase(this)) || super.equals(obj);
        }
    }

    public View() {
        super(2, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public View(Buffer buffer) {
        super(2, !buffer.isImmutable());
        int i = 1;
        this._buffer = buffer.buffer();
        setPutIndex(buffer.putIndex());
        setGetIndex(buffer.getIndex());
        setMarkIndex(buffer.markIndex());
        this._access = !buffer.isReadOnly() ? 2 : i;
    }

    public View(Buffer buffer, int i, int i2, int i3, int i4) {
        super(2, !buffer.isImmutable());
        this._buffer = buffer.buffer();
        setPutIndex(i3);
        setGetIndex(i2);
        setMarkIndex(i);
        this._access = i4;
    }

    @Override // org.eclipse.jetty.p059io.Buffer
    public byte[] array() {
        return this._buffer.array();
    }

    @Override // org.eclipse.jetty.p059io.AbstractBuffer, org.eclipse.jetty.p059io.Buffer
    public Buffer buffer() {
        return this._buffer.buffer();
    }

    @Override // org.eclipse.jetty.p059io.Buffer
    public int capacity() {
        return this._buffer.capacity();
    }

    @Override // org.eclipse.jetty.p059io.AbstractBuffer, org.eclipse.jetty.p059io.Buffer
    public void clear() {
        setMarkIndex(-1);
        setGetIndex(0);
        setPutIndex(this._buffer.getIndex());
        setGetIndex(this._buffer.getIndex());
    }

    @Override // org.eclipse.jetty.p059io.AbstractBuffer, org.eclipse.jetty.p059io.Buffer
    public void compact() {
    }

    @Override // org.eclipse.jetty.p059io.AbstractBuffer
    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof Buffer) && obj.equals(this)) || super.equals(obj);
    }

    @Override // org.eclipse.jetty.p059io.AbstractBuffer, org.eclipse.jetty.p059io.Buffer
    public boolean isReadOnly() {
        return this._buffer.isReadOnly();
    }

    @Override // org.eclipse.jetty.p059io.AbstractBuffer, org.eclipse.jetty.p059io.Buffer
    public boolean isVolatile() {
        return true;
    }

    @Override // org.eclipse.jetty.p059io.Buffer
    public byte peek(int i) {
        return this._buffer.peek(i);
    }

    @Override // org.eclipse.jetty.p059io.Buffer
    public int peek(int i, byte[] bArr, int i2, int i3) {
        return this._buffer.peek(i, bArr, i2, i3);
    }

    @Override // org.eclipse.jetty.p059io.AbstractBuffer, org.eclipse.jetty.p059io.Buffer
    public Buffer peek(int i, int i2) {
        return this._buffer.peek(i, i2);
    }

    @Override // org.eclipse.jetty.p059io.AbstractBuffer, org.eclipse.jetty.p059io.Buffer
    public int poke(int i, Buffer buffer) {
        return this._buffer.poke(i, buffer);
    }

    @Override // org.eclipse.jetty.p059io.AbstractBuffer, org.eclipse.jetty.p059io.Buffer
    public int poke(int i, byte[] bArr, int i2, int i3) {
        return this._buffer.poke(i, bArr, i2, i3);
    }

    @Override // org.eclipse.jetty.p059io.Buffer
    public void poke(int i, byte b) {
        this._buffer.poke(i, b);
    }

    @Override // org.eclipse.jetty.p059io.AbstractBuffer
    public String toString() {
        return this._buffer == null ? "INVALID" : super.toString();
    }

    public void update(int i, int i2) {
        int i3 = this._access;
        this._access = 2;
        setGetIndex(0);
        setPutIndex(i2);
        setGetIndex(i);
        setMarkIndex(-1);
        this._access = i3;
    }

    public void update(Buffer buffer) {
        int i = 2;
        this._access = 2;
        this._buffer = buffer.buffer();
        setGetIndex(0);
        setPutIndex(buffer.putIndex());
        setGetIndex(buffer.getIndex());
        setMarkIndex(buffer.markIndex());
        if (buffer.isReadOnly()) {
            i = 1;
        }
        this._access = i;
    }
}
