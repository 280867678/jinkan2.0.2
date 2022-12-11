package org.eclipse.jetty.p059io;

import java.text.DateFormatSymbols;
import java.util.Locale;
import org.eclipse.jetty.util.DateCache;

/* renamed from: org.eclipse.jetty.io.BufferDateCache */
/* loaded from: classes4.dex */
public class BufferDateCache extends DateCache {
    public Buffer _buffer;
    public String _last;

    public BufferDateCache() {
    }

    public BufferDateCache(String str) {
        super(str);
    }

    public BufferDateCache(String str, DateFormatSymbols dateFormatSymbols) {
        super(str, dateFormatSymbols);
    }

    public BufferDateCache(String str, Locale locale) {
        super(str, locale);
    }

    public synchronized Buffer formatBuffer(long j) {
        String format = super.format(j);
        if (format == this._last) {
            return this._buffer;
        }
        this._last = format;
        ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(format);
        this._buffer = byteArrayBuffer;
        return byteArrayBuffer;
    }
}
