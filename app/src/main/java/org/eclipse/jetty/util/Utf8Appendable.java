package org.eclipse.jetty.util;

import java.io.IOException;
import me.tvspark.outline;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.mozilla.javascript.regexp.NativeRegExp;

/* loaded from: classes5.dex */
public abstract class Utf8Appendable {
    public static final char REPLACEMENT = 65533;
    public static final int UTF8_ACCEPT = 0;
    public static final int UTF8_REJECT = 12;
    public final Appendable _appendable;
    public int _codep;
    public int _state = 0;
    public static final Logger LOG = Log.getLogger(Utf8Appendable.class);
    public static final byte[] BYTE_TABLE = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 10, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 3, 3, 11, 6, 6, 6, 5, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8};
    public static final byte[] TRANS_TABLE = {0, 12, 24, 36, 60, 96, 84, 12, 12, 12, NativeRegExp.REOP_MINIMALQUANT, 72, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 0, 12, 12, 12, 12, 12, 0, 12, 0, 12, 12, 12, 24, 12, 12, 12, 12, 12, 24, 12, 24, 12, 12, 12, 12, 12, 12, 12, 12, 12, 24, 12, 12, 12, 12, 12, 24, 12, 12, 12, 12, 12, 12, 12, 24, 12, 12, 12, 12, 12, 12, 12, 12, 12, 36, 12, 36, 12, 12, 12, 36, 12, 12, 12, 12, 12, 36, 12, 36, 12, 12, 12, 36, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    /* loaded from: classes5.dex */
    public static class NotUtf8Exception extends IllegalArgumentException {
        public NotUtf8Exception(String str) {
            super(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Not valid UTF8! ", str));
        }
    }

    public Utf8Appendable(Appendable appendable) {
        this._appendable = appendable;
    }

    public void append(byte b) {
        try {
            appendByte(b);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void append(byte[] bArr, int i, int i2) {
        int i3 = i2 + i;
        while (i < i3) {
            try {
                appendByte(bArr[i]);
                i++;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean append(byte[] bArr, int i, int i2, int i3) {
        int i4 = i2 + i;
        while (i < i4) {
            try {
                if (length() > i3) {
                    return false;
                }
                appendByte(bArr[i]);
                i++;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }

    public void appendByte(byte b) throws IOException {
        if (b > 0 && this._state == 0) {
            this._appendable.append((char) (b & 255));
            return;
        }
        int i = b & 255;
        byte b2 = BYTE_TABLE[i];
        int i2 = this._state == 0 ? (255 >> b2) & i : (i & 63) | (this._codep << 6);
        this._codep = i2;
        byte b3 = TRANS_TABLE[this._state + b2];
        if (b3 == 0) {
            this._state = b3;
            if (i2 < 55296) {
                this._appendable.append((char) i2);
                return;
            }
            for (char c : Character.toChars(i2)) {
                this._appendable.append(c);
            }
        } else if (b3 == 12) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("byte ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(TypeUtil.toHexString(b));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" in state ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._state / 12);
            String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            this._codep = 0;
            this._state = 0;
            this._appendable.append((char) 65533);
            throw new NotUtf8Exception(sb);
        } else {
            this._state = b3;
        }
    }

    public void checkState() {
        if (isUtf8SequenceComplete()) {
            return;
        }
        this._codep = 0;
        this._state = 0;
        try {
            this._appendable.append((char) 65533);
            throw new NotUtf8Exception("incomplete UTF8 sequence");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isUtf8SequenceComplete() {
        return this._state == 0;
    }

    public abstract int length();

    public void reset() {
        this._state = 0;
    }

    public String toReplacedString() {
        if (!isUtf8SequenceComplete()) {
            this._codep = 0;
            this._state = 0;
            try {
                this._appendable.append((char) 65533);
                NotUtf8Exception notUtf8Exception = new NotUtf8Exception("incomplete UTF8 sequence");
                LOG.warn(notUtf8Exception.toString(), new Object[0]);
                LOG.debug(notUtf8Exception);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return this._appendable.toString();
    }
}
