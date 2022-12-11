package org.eclipse.jetty.util;

/* loaded from: classes5.dex */
public class Utf8StringBuffer extends Utf8Appendable {
    public final StringBuffer _buffer = (StringBuffer) this._appendable;

    public Utf8StringBuffer() {
        super(new StringBuffer());
    }

    public Utf8StringBuffer(int i) {
        super(new StringBuffer(i));
    }

    public StringBuffer getStringBuffer() {
        checkState();
        return this._buffer;
    }

    @Override // org.eclipse.jetty.util.Utf8Appendable
    public int length() {
        return this._buffer.length();
    }

    @Override // org.eclipse.jetty.util.Utf8Appendable
    public void reset() {
        super.reset();
        this._buffer.setLength(0);
    }

    public String toString() {
        checkState();
        return this._buffer.toString();
    }
}
