package org.eclipse.jetty.p059io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import org.eclipse.jetty.p059io.Buffer;
import org.eclipse.jetty.util.StringUtil;

/* renamed from: org.eclipse.jetty.io.ByteArrayBuffer */
/* loaded from: classes4.dex */
public class ByteArrayBuffer extends AbstractBuffer {
    public static final int MAX_WRITE = Integer.getInteger("org.eclipse.jetty.io.ByteArrayBuffer.MAX_WRITE", 131072).intValue();
    public final byte[] _bytes;

    /* renamed from: org.eclipse.jetty.io.ByteArrayBuffer$CaseInsensitive */
    /* loaded from: classes4.dex */
    public static class CaseInsensitive extends ByteArrayBuffer implements Buffer.CaseInsensitve {
        public CaseInsensitive(String str) {
            super(str);
        }

        public CaseInsensitive(byte[] bArr, int i, int i2, int i3) {
            super(bArr, i, i2, i3);
        }

        @Override // org.eclipse.jetty.p059io.ByteArrayBuffer, org.eclipse.jetty.p059io.AbstractBuffer
        public boolean equals(Object obj) {
            return (obj instanceof Buffer) && equalsIgnoreCase((Buffer) obj);
        }
    }

    public ByteArrayBuffer(int i) {
        this(new byte[i], 0, 0, 2);
        setPutIndex(0);
    }

    public ByteArrayBuffer(int i, int i2, boolean z) {
        this(new byte[i], 0, 0, i2, z);
    }

    public ByteArrayBuffer(String str) {
        super(2, false);
        this._bytes = StringUtil.getBytes(str);
        setGetIndex(0);
        setPutIndex(this._bytes.length);
        this._access = 0;
        this._string = str;
    }

    public ByteArrayBuffer(String str, String str2) throws UnsupportedEncodingException {
        super(2, false);
        this._bytes = str.getBytes(str2);
        setGetIndex(0);
        setPutIndex(this._bytes.length);
        this._access = 0;
        this._string = str;
    }

    public ByteArrayBuffer(String str, boolean z) {
        super(2, false);
        this._bytes = StringUtil.getBytes(str);
        setGetIndex(0);
        setPutIndex(this._bytes.length);
        if (z) {
            this._access = 0;
            this._string = str;
        }
    }

    public ByteArrayBuffer(byte[] bArr) {
        this(bArr, 0, bArr.length, 2);
    }

    public ByteArrayBuffer(byte[] bArr, int i, int i2) {
        this(bArr, i, i2, 2);
    }

    public ByteArrayBuffer(byte[] bArr, int i, int i2, int i3) {
        super(2, false);
        this._bytes = bArr;
        setPutIndex(i2 + i);
        setGetIndex(i);
        this._access = i3;
    }

    public ByteArrayBuffer(byte[] bArr, int i, int i2, int i3, boolean z) {
        super(2, z);
        this._bytes = bArr;
        setPutIndex(i2 + i);
        setGetIndex(i);
        this._access = i3;
    }

    @Override // org.eclipse.jetty.p059io.Buffer
    public byte[] array() {
        return this._bytes;
    }

    @Override // org.eclipse.jetty.p059io.Buffer
    public int capacity() {
        return this._bytes.length;
    }

    @Override // org.eclipse.jetty.p059io.AbstractBuffer, org.eclipse.jetty.p059io.Buffer
    public void compact() {
        if (!isReadOnly()) {
            int markIndex = markIndex() >= 0 ? markIndex() : getIndex();
            if (markIndex <= 0) {
                return;
            }
            int putIndex = putIndex() - markIndex;
            if (putIndex > 0) {
                byte[] bArr = this._bytes;
                System.arraycopy(bArr, markIndex, bArr, 0, putIndex);
            }
            if (markIndex() > 0) {
                setMarkIndex(markIndex() - markIndex);
            }
            setGetIndex(getIndex() - markIndex);
            setPutIndex(putIndex() - markIndex);
            return;
        }
        throw new IllegalStateException(AbstractBuffer.__READONLY);
    }

    @Override // org.eclipse.jetty.p059io.AbstractBuffer
    public boolean equals(Object obj) {
        int i;
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof Buffer)) {
            return false;
        }
        if (obj instanceof Buffer.CaseInsensitve) {
            return equalsIgnoreCase((Buffer) obj);
        }
        Buffer buffer = (Buffer) obj;
        if (buffer.length() != length()) {
            return false;
        }
        int i2 = this._hash;
        if (i2 != 0 && (obj instanceof AbstractBuffer) && (i = ((AbstractBuffer) obj)._hash) != 0 && i2 != i) {
            return false;
        }
        int index = getIndex();
        int putIndex = buffer.putIndex();
        int putIndex2 = putIndex();
        while (true) {
            int i3 = putIndex2 - 1;
            if (putIndex2 <= index) {
                return true;
            }
            putIndex--;
            if (this._bytes[i3] != buffer.peek(putIndex)) {
                return false;
            }
            putIndex2 = i3;
        }
    }

    @Override // org.eclipse.jetty.p059io.AbstractBuffer, org.eclipse.jetty.p059io.Buffer
    public boolean equalsIgnoreCase(Buffer buffer) {
        int i;
        if (buffer == this) {
            return true;
        }
        if (buffer == null || buffer.length() != length()) {
            return false;
        }
        int i2 = this._hash;
        if (i2 != 0 && (buffer instanceof AbstractBuffer) && (i = ((AbstractBuffer) buffer)._hash) != 0 && i2 != i) {
            return false;
        }
        int index = getIndex();
        int putIndex = buffer.putIndex();
        byte[] array = buffer.array();
        if (array != null) {
            int putIndex2 = putIndex();
            while (true) {
                int i3 = putIndex2 - 1;
                if (putIndex2 <= index) {
                    break;
                }
                byte b = this._bytes[i3];
                putIndex--;
                byte b2 = array[putIndex];
                if (b != b2) {
                    if (97 <= b && b <= 122) {
                        b = (byte) ((b - 97) + 65);
                    }
                    if (97 <= b2 && b2 <= 122) {
                        b2 = (byte) ((b2 - 97) + 65);
                    }
                    if (b != b2) {
                        return false;
                    }
                }
                putIndex2 = i3;
            }
        } else {
            int putIndex3 = putIndex();
            while (true) {
                int i4 = putIndex3 - 1;
                if (putIndex3 <= index) {
                    break;
                }
                byte b3 = this._bytes[i4];
                putIndex--;
                byte peek = buffer.peek(putIndex);
                if (b3 != peek) {
                    if (97 <= b3 && b3 <= 122) {
                        b3 = (byte) ((b3 - 97) + 65);
                    }
                    if (97 <= peek && peek <= 122) {
                        peek = (byte) ((peek - 97) + 65);
                    }
                    if (b3 != peek) {
                        return false;
                    }
                }
                putIndex3 = i4;
            }
        }
        return true;
    }

    @Override // org.eclipse.jetty.p059io.AbstractBuffer, org.eclipse.jetty.p059io.Buffer
    public byte get() {
        byte[] bArr = this._bytes;
        int i = this._get;
        this._get = i + 1;
        return bArr[i];
    }

    @Override // org.eclipse.jetty.p059io.AbstractBuffer
    public int hashCode() {
        if (this._hash == 0 || this._hashGet != this._get || this._hashPut != this._put) {
            int index = getIndex();
            int putIndex = putIndex();
            while (true) {
                int i = putIndex - 1;
                if (putIndex <= index) {
                    break;
                }
                byte b = this._bytes[i];
                if (97 <= b && b <= 122) {
                    b = (byte) ((b - 97) + 65);
                }
                this._hash = (this._hash * 31) + b;
                putIndex = i;
            }
            if (this._hash == 0) {
                this._hash = -1;
            }
            this._hashGet = this._get;
            this._hashPut = this._put;
        }
        return this._hash;
    }

    @Override // org.eclipse.jetty.p059io.Buffer
    public byte peek(int i) {
        return this._bytes[i];
    }

    @Override // org.eclipse.jetty.p059io.Buffer
    public int peek(int i, byte[] bArr, int i2, int i3) {
        if ((i + i3 <= capacity() || (i3 = capacity() - i) != 0) && i3 >= 0) {
            System.arraycopy(this._bytes, i, bArr, i2, i3);
            return i3;
        }
        return -1;
    }

    @Override // org.eclipse.jetty.p059io.AbstractBuffer, org.eclipse.jetty.p059io.Buffer
    public int poke(int i, Buffer buffer) {
        int i2 = 0;
        this._hash = 0;
        int length = buffer.length();
        if (i + length > capacity()) {
            length = capacity() - i;
        }
        byte[] array = buffer.array();
        if (array != null) {
            System.arraycopy(array, buffer.getIndex(), this._bytes, i, length);
        } else {
            int index = buffer.getIndex();
            while (i2 < length) {
                this._bytes[i] = buffer.peek(index);
                i2++;
                i++;
                index++;
            }
        }
        return length;
    }

    @Override // org.eclipse.jetty.p059io.AbstractBuffer, org.eclipse.jetty.p059io.Buffer
    public int poke(int i, byte[] bArr, int i2, int i3) {
        this._hash = 0;
        if (i + i3 > capacity()) {
            i3 = capacity() - i;
        }
        System.arraycopy(bArr, i2, this._bytes, i, i3);
        return i3;
    }

    @Override // org.eclipse.jetty.p059io.Buffer
    public void poke(int i, byte b) {
        this._bytes[i] = b;
    }

    @Override // org.eclipse.jetty.p059io.AbstractBuffer, org.eclipse.jetty.p059io.Buffer
    public int readFrom(InputStream inputStream, int i) throws IOException {
        if (i < 0 || i > space()) {
            i = space();
        }
        int putIndex = putIndex();
        int i2 = 0;
        int i3 = i;
        int i4 = 0;
        while (i2 < i) {
            i4 = inputStream.read(this._bytes, putIndex, i3);
            if (i4 < 0) {
                break;
            }
            if (i4 > 0) {
                putIndex += i4;
                i2 += i4;
                i3 -= i4;
                setPutIndex(putIndex);
            }
            if (inputStream.available() <= 0) {
                break;
            }
        }
        if (i4 >= 0 || i2 != 0) {
            return i2;
        }
        return -1;
    }

    @Override // org.eclipse.jetty.p059io.AbstractBuffer, org.eclipse.jetty.p059io.Buffer
    public int space() {
        return this._bytes.length - this._put;
    }

    @Override // org.eclipse.jetty.p059io.AbstractBuffer, org.eclipse.jetty.p059io.Buffer
    public void writeTo(OutputStream outputStream) throws IOException {
        int length = length();
        int i = MAX_WRITE;
        if (i <= 0 || length <= i) {
            outputStream.write(this._bytes, getIndex(), length);
        } else {
            int index = getIndex();
            while (length > 0) {
                int i2 = MAX_WRITE;
                if (length <= i2) {
                    i2 = length;
                }
                outputStream.write(this._bytes, index, i2);
                index += i2;
                length -= i2;
            }
        }
        if (!isImmutable()) {
            clear();
        }
    }
}
