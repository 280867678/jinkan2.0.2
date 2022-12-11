package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.ParserException;
import me.tvspark.AbstractC2740w7;
import me.tvspark.C2078el;

/* loaded from: classes3.dex */
public abstract class TagPayloadReader {
    public final AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes3.dex */
    public static final class UnsupportedFormatException extends ParserException {
        public UnsupportedFormatException(String str) {
            super(str);
        }
    }

    public TagPayloadReader(AbstractC2740w7 abstractC2740w7) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2740w7;
    }

    public abstract boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, long j) throws ParserException;

    public abstract boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el) throws ParserException;

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, long j) throws ParserException {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el) && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, j);
    }
}
