package org.eclipse.jetty.util;

/* loaded from: classes5.dex */
public class Utf8StringBuilder extends Utf8Appendable {
    public final StringBuilder _buffer = (StringBuilder) this._appendable;

    public Utf8StringBuilder() {
        super(new StringBuilder());
    }

    public Utf8StringBuilder(int i) {
        super(new StringBuilder(i));
    }

    public StringBuilder getStringBuilder() {
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
