package org.eclipse.jetty.http;

import com.tencent.smtt.sdk.TbsListener;
import java.io.IOException;
import java.io.InterruptedIOException;
import me.tvspark.outline;
import org.eclipse.jetty.http.HttpFields;
import org.eclipse.jetty.http.HttpStatus;
import org.eclipse.jetty.p059io.Buffer;
import org.eclipse.jetty.p059io.BufferCache;
import org.eclipse.jetty.p059io.BufferUtil;
import org.eclipse.jetty.p059io.Buffers;
import org.eclipse.jetty.p059io.ByteArrayBuffer;
import org.eclipse.jetty.p059io.EndPoint;
import org.eclipse.jetty.p059io.EofException;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.mozilla.javascript.regexp.NativeRegExp;

/* loaded from: classes4.dex */
public class HttpGenerator extends AbstractGenerator {
    public static final int CHUNK_SPACE = 12;
    public static final byte[] CONNECTION_;
    public static final byte[] CONNECTION_CLOSE;
    public static final byte[] CONNECTION_KEEP_ALIVE;
    public static final byte[] CONTENT_LENGTH_0;
    public static final byte[] CRLF;
    public static final byte[] LAST_CHUNK;
    public static byte[] SERVER;
    public static final byte[] TRANSFER_ENCODING_CHUNKED;
    public static final Logger LOG = Log.getLogger(HttpGenerator.class);
    public static final Status[] __status = new Status[TbsListener.ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_OPENINQB];
    public boolean _bypass = false;
    public boolean _needCRLF = false;
    public boolean _needEOC = false;
    public boolean _bufferChunked = false;

    /* loaded from: classes4.dex */
    public static class Status {
        public Buffer _reason;
        public Buffer _responseLine;
        public Buffer _schemeCode;

        public Status() {
        }
    }

    static {
        int length = HttpVersions.HTTP_1_1_BUFFER.length();
        for (int i = 0; i < __status.length; i++) {
            HttpStatus.Code code = HttpStatus.getCode(i);
            if (code != null) {
                String message = code.getMessage();
                int i2 = length + 5;
                int length2 = message.length() + i2 + 2;
                byte[] bArr = new byte[length2];
                HttpVersions.HTTP_1_1_BUFFER.peek(0, bArr, 0, length);
                bArr[length + 0] = 32;
                bArr[length + 1] = (byte) ((i / 100) + 48);
                bArr[length + 2] = (byte) (((i % 100) / 10) + 48);
                bArr[length + 3] = (byte) ((i % 10) + 48);
                bArr[length + 4] = 32;
                for (int i3 = 0; i3 < message.length(); i3++) {
                    bArr[i2 + i3] = (byte) message.charAt(i3);
                }
                bArr[message.length() + i2] = 13;
                bArr[message.length() + length + 6] = 10;
                __status[i] = new Status();
                __status[i]._reason = new ByteArrayBuffer(bArr, i2, (length2 - length) - 7, 0);
                __status[i]._schemeCode = new ByteArrayBuffer(bArr, 0, i2, 0);
                __status[i]._responseLine = new ByteArrayBuffer(bArr, 0, length2, 0);
            }
        }
        LAST_CHUNK = new byte[]{NativeRegExp.REOP_MINIMALQUANT, 13, 10, 13, 10};
        CONTENT_LENGTH_0 = StringUtil.getBytes("Content-Length: 0\r\n");
        CONNECTION_KEEP_ALIVE = StringUtil.getBytes("Connection: keep-alive\r\n");
        CONNECTION_CLOSE = StringUtil.getBytes("Connection: close\r\n");
        CONNECTION_ = StringUtil.getBytes("Connection: ");
        CRLF = StringUtil.getBytes("\r\n");
        TRANSFER_ENCODING_CHUNKED = StringUtil.getBytes("Transfer-Encoding: chunked\r\n");
        SERVER = StringUtil.getBytes("Server: Jetty(7.0.x)\r\n");
    }

    public HttpGenerator(Buffers buffers, EndPoint endPoint) {
        super(buffers, endPoint);
    }

    private int flushMask() {
        Buffer buffer;
        Buffer buffer2 = this._header;
        int i = 0;
        int i2 = (buffer2 == null || buffer2.length() <= 0) ? 0 : 4;
        Buffer buffer3 = this._buffer;
        int i3 = i2 | ((buffer3 == null || buffer3.length() <= 0) ? 0 : 2);
        if (this._bypass && (buffer = this._content) != null && buffer.length() > 0) {
            i = 1;
        }
        return i3 | i;
    }

    public static Buffer getReasonBuffer(int i) {
        Status[] statusArr = __status;
        Status status = i < statusArr.length ? statusArr[i] : null;
        if (status != null) {
            return status._reason;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0196  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void prepareBuffers() {
        int length;
        Buffer buffer;
        Buffer buffer2;
        Buffer buffer3;
        int space;
        byte[] bArr;
        Buffer buffer4;
        Buffer buffer5;
        Buffer buffer6;
        Buffer buffer7;
        Buffer buffer8;
        if (!this._bufferChunked) {
            if (!this._bypass && (buffer7 = this._content) != null && buffer7.length() > 0 && (buffer8 = this._buffer) != null && buffer8.space() > 0) {
                this._content.skip(this._buffer.put(this._content));
                if (this._content.length() == 0) {
                    this._content = null;
                }
            }
            if (this._contentLength == -2) {
                if (!this._bypass || (!((buffer5 = this._buffer) == null || buffer5.length() == 0) || (buffer6 = this._content) == null)) {
                    Buffer buffer9 = this._buffer;
                    if (buffer9 != null && (length = buffer9.length()) > 0) {
                        this._bufferChunked = true;
                        if (this._buffer.getIndex() == 12) {
                            Buffer buffer10 = this._buffer;
                            buffer10.poke(buffer10.getIndex() - 2, HttpTokens.CRLF, 0, 2);
                            Buffer buffer11 = this._buffer;
                            buffer11.setGetIndex(buffer11.getIndex() - 2);
                            BufferUtil.prependHexInt(this._buffer, length);
                            if (this._needCRLF) {
                                Buffer buffer12 = this._buffer;
                                buffer12.poke(buffer12.getIndex() - 2, HttpTokens.CRLF, 0, 2);
                                Buffer buffer13 = this._buffer;
                                buffer13.setGetIndex(buffer13.getIndex() - 2);
                                this._needCRLF = false;
                            }
                        } else {
                            if (this._header == null) {
                                this._header = this._buffers.getHeader();
                            }
                            if (this._needCRLF) {
                                if (this._header.length() > 0) {
                                    throw new IllegalStateException("EOC");
                                }
                                this._header.put(HttpTokens.CRLF);
                                this._needCRLF = false;
                            }
                            BufferUtil.putHexInt(this._header, length);
                            this._header.put(HttpTokens.CRLF);
                        }
                        if (this._buffer.space() >= 2) {
                            this._buffer.put(HttpTokens.CRLF);
                        }
                    }
                    if (this._needEOC && ((buffer = this._content) == null || buffer.length() == 0)) {
                        if (this._header == null && this._buffer == null) {
                            this._header = this._buffers.getHeader();
                        }
                        if (this._needCRLF) {
                            if (this._buffer == null && (buffer4 = this._header) != null) {
                                int space2 = buffer4.space();
                                byte[] bArr2 = HttpTokens.CRLF;
                                if (space2 >= bArr2.length) {
                                    this._header.put(bArr2);
                                    this._needCRLF = false;
                                }
                            }
                            Buffer buffer14 = this._buffer;
                            if (buffer14 != null) {
                                int space3 = buffer14.space();
                                byte[] bArr3 = HttpTokens.CRLF;
                                if (space3 >= bArr3.length) {
                                    this._buffer.put(bArr3);
                                    this._needCRLF = false;
                                }
                            }
                        }
                        if (!this._needCRLF && this._needEOC) {
                            if (this._buffer == null && (buffer3 = this._header) != null) {
                                space = buffer3.space();
                                bArr = LAST_CHUNK;
                                if (space >= bArr.length) {
                                    if (!this._head) {
                                        this._header.put(bArr);
                                        this._bufferChunked = true;
                                    }
                                    this._needEOC = false;
                                }
                            }
                            buffer2 = this._buffer;
                            if (buffer2 != null) {
                                int space4 = buffer2.space();
                                byte[] bArr4 = LAST_CHUNK;
                                if (space4 >= bArr4.length) {
                                    if (!this._head) {
                                        this._buffer.put(bArr4);
                                        this._bufferChunked = true;
                                    }
                                    this._needEOC = false;
                                }
                            }
                        }
                    }
                } else {
                    int length2 = buffer6.length();
                    this._bufferChunked = true;
                    if (this._header == null) {
                        this._header = this._buffers.getHeader();
                    }
                    if (this._needCRLF) {
                        if (this._header.length() > 0) {
                            throw new IllegalStateException("EOC");
                        }
                        this._header.put(HttpTokens.CRLF);
                        this._needCRLF = false;
                    }
                    BufferUtil.putHexInt(this._header, length2);
                    this._header.put(HttpTokens.CRLF);
                }
                this._needCRLF = true;
                if (this._needEOC) {
                    if (this._header == null) {
                        this._header = this._buffers.getHeader();
                    }
                    if (this._needCRLF) {
                    }
                    if (!this._needCRLF) {
                        if (this._buffer == null) {
                            space = buffer3.space();
                            bArr = LAST_CHUNK;
                            if (space >= bArr.length) {
                            }
                        }
                        buffer2 = this._buffer;
                        if (buffer2 != null) {
                        }
                    }
                }
            }
        }
        Buffer buffer15 = this._content;
        if (buffer15 == null || buffer15.length() != 0) {
            return;
        }
        this._content = null;
    }

    public static void setServerVersion(String str) {
        SERVER = StringUtil.getBytes("Server: Jetty(" + str + ")\r\n");
    }

    @Override // org.eclipse.jetty.http.Generator
    public void addContent(Buffer buffer, boolean z) throws IOException {
        Buffer buffer2;
        Buffer buffer3;
        if (!this._noContent) {
            if (this._last || this._state == 4) {
                LOG.warn("Ignoring extra content {}", buffer);
                buffer.clear();
                return;
            }
            this._last = z;
            Buffer buffer4 = this._content;
            if ((buffer4 != null && buffer4.length() > 0) || this._bufferChunked) {
                if (this._endp.isOutputShutdown()) {
                    throw new EofException();
                }
                flushBuffer();
                Buffer buffer5 = this._content;
                if (buffer5 != null && buffer5.length() > 0) {
                    if (this._bufferChunked) {
                        buffer3 = this._buffers.getBuffer(buffer.length() + this._content.length() + 12);
                        buffer3.put(this._content);
                        buffer3.put(HttpTokens.CRLF);
                        BufferUtil.putHexInt(buffer3, buffer.length());
                        buffer3.put(HttpTokens.CRLF);
                    } else {
                        buffer3 = this._buffers.getBuffer(buffer.length() + this._content.length());
                        buffer3.put(this._content);
                    }
                    buffer3.put(buffer);
                    buffer = buffer3;
                }
            }
            this._content = buffer;
            this._contentWritten += buffer.length();
            if (this._head) {
                buffer.clear();
            } else if (this._endp != null && (((buffer2 = this._buffer) == null || buffer2.length() == 0) && this._content.length() > 0 && (this._last || (isCommitted() && this._content.length() > 1024)))) {
                this._bypass = true;
                return;
            } else if (this._bufferChunked) {
                return;
            } else {
                if (this._buffer == null) {
                    this._buffer = this._buffers.getBuffer();
                }
                this._content.skip(this._buffer.put(this._content));
                if (this._content.length() != 0) {
                    return;
                }
            }
            this._content = null;
            return;
        }
        throw new IllegalStateException("NO CONTENT");
    }

    @Override // org.eclipse.jetty.http.AbstractGenerator, org.eclipse.jetty.http.Generator
    public void complete() throws IOException {
        if (this._state == 4) {
            return;
        }
        super.complete();
        if (this._state < 3) {
            this._state = 3;
            if (this._contentLength == -2) {
                this._needEOC = true;
            }
        }
        flushBuffer();
    }

    @Override // org.eclipse.jetty.http.AbstractGenerator, org.eclipse.jetty.http.Generator
    public void completeHeader(HttpFields httpFields, boolean z) throws IOException {
        HttpFields.Field field;
        StringBuilder sb;
        HttpFields.Field field2;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        long j;
        boolean z6;
        String str;
        Buffer buffer;
        if (this._state != 0) {
            return;
        }
        if (isResponse() && this._status == 0) {
            throw new EofException();
        }
        if (this._last && !z) {
            throw new IllegalStateException("last?");
        }
        this._last |= z;
        if (this._header == null) {
            this._header = this._buffers.getHeader();
        }
        try {
            int i = 48;
            boolean z7 = true;
            if (isRequest()) {
                this._persistent = true;
                if (this._version == 9) {
                    this._contentLength = 0L;
                    this._header.put(this._method);
                    this._header.put((byte) 32);
                    this._header.put(this._uri.getBytes("UTF-8"));
                    this._header.put(HttpTokens.CRLF);
                    this._state = 3;
                    this._noContent = true;
                    return;
                }
                this._header.put(this._method);
                this._header.put((byte) 32);
                this._header.put(this._uri.getBytes("UTF-8"));
                this._header.put((byte) 32);
                this._header.put(this._version == 10 ? HttpVersions.HTTP_1_0_BUFFER : HttpVersions.HTTP_1_1_BUFFER);
                this._header.put(HttpTokens.CRLF);
            } else if (this._version == 9) {
                this._persistent = false;
                this._contentLength = -1L;
                this._state = 2;
                return;
            } else {
                if (this._persistent == null) {
                    this._persistent = Boolean.valueOf(this._version > 10);
                }
                Status status = this._status < __status.length ? __status[this._status] : null;
                if (status == null) {
                    this._header.put(HttpVersions.HTTP_1_1_BUFFER);
                    this._header.put((byte) 32);
                    this._header.put((byte) ((this._status / 100) + 48));
                    this._header.put((byte) (((this._status % 100) / 10) + 48));
                    this._header.put((byte) ((this._status % 10) + 48));
                    this._header.put((byte) 32);
                    if (this._reason == null) {
                        this._header.put((byte) ((this._status / 100) + 48));
                        this._header.put((byte) (((this._status % 100) / 10) + 48));
                        this._header.put((byte) ((this._status % 10) + 48));
                    } else {
                        this._header.put(this._reason);
                    }
                    this._header.put(HttpTokens.CRLF);
                } else if (this._reason == null) {
                    this._header.put(status._responseLine);
                } else {
                    this._header.put(status._schemeCode);
                    this._header.put(this._reason);
                    this._header.put(HttpTokens.CRLF);
                }
                if (this._status < 200 && this._status >= 100) {
                    this._noContent = true;
                    this._content = null;
                    if (this._buffer != null) {
                        this._buffer.clear();
                    }
                    if (this._status != 101) {
                        this._header.put(HttpTokens.CRLF);
                        this._state = 2;
                        return;
                    }
                } else if (this._status == 204 || this._status == 304) {
                    this._noContent = true;
                    this._content = null;
                    if (this._buffer != null) {
                        this._buffer.clear();
                    }
                }
            }
            if (this._status >= 200 && this._date != null) {
                this._header.put(HttpHeaders.DATE_BUFFER);
                this._header.put(HttpTokens.COLON);
                this._header.put((byte) 32);
                this._header.put(this._date);
                this._header.put(CRLF);
            }
            int i2 = -1;
            int i3 = 11;
            if (httpFields != null) {
                int size = httpFields.size();
                sb = null;
                int i4 = 0;
                field2 = null;
                z2 = false;
                field = null;
                z3 = false;
                z4 = false;
                z5 = false;
                while (i4 < size) {
                    HttpFields.Field field3 = httpFields.getField(i4);
                    if (field3 != null) {
                        int nameOrdinal = field3.getNameOrdinal();
                        if (nameOrdinal == z7) {
                            if (isRequest()) {
                                field3.putTo(this._header);
                            }
                            int valueOrdinal = field3.getValueOrdinal();
                            if (valueOrdinal != i2) {
                                if (valueOrdinal != z7) {
                                    if (valueOrdinal != 5) {
                                        if (valueOrdinal != i3) {
                                            if (sb == null) {
                                                sb = new StringBuilder();
                                            } else {
                                                sb.append(',');
                                            }
                                            sb.append(field3.getValue());
                                        } else if (isResponse()) {
                                            buffer = this._header;
                                        }
                                    } else if (this._version == 10) {
                                        if (isResponse()) {
                                            this._persistent = Boolean.valueOf(z7);
                                        }
                                        z3 = true;
                                    }
                                }
                                if (isResponse()) {
                                    this._persistent = false;
                                }
                                if (!this._persistent.booleanValue() && isResponse() && this._contentLength == -3) {
                                    this._contentLength = -1L;
                                }
                                z4 = true;
                            } else {
                                String[] split = field3.getValue().split(",");
                                int i5 = 0;
                                while (split != null && i5 < split.length) {
                                    BufferCache.CachedBuffer cachedBuffer = HttpHeaderValues.CACHE.get(split[i5].trim());
                                    if (cachedBuffer != null) {
                                        int ordinal = cachedBuffer.getOrdinal();
                                        if (ordinal == z7) {
                                            if (isResponse()) {
                                                this._persistent = false;
                                            }
                                            if (!this._persistent.booleanValue() && isResponse() && this._contentLength == -3) {
                                                this._contentLength = -1L;
                                            }
                                            z3 = false;
                                            z4 = true;
                                        } else if (ordinal != 5) {
                                            if (sb == null) {
                                                sb = new StringBuilder();
                                            } else {
                                                sb.append(',');
                                            }
                                            str = split[i5];
                                        } else if (this._version == 10) {
                                            if (isResponse()) {
                                                this._persistent = Boolean.valueOf(z7);
                                            }
                                            z3 = true;
                                        }
                                        i5++;
                                        z7 = true;
                                    } else {
                                        if (sb == null) {
                                            sb = new StringBuilder();
                                        } else {
                                            sb.append(',');
                                        }
                                        str = split[i5];
                                    }
                                    sb.append(str);
                                    i5++;
                                    z7 = true;
                                }
                            }
                        } else if (nameOrdinal != 5) {
                            if (nameOrdinal == 12) {
                                long longValue = field3.getLongValue();
                                this._contentLength = longValue;
                                if (longValue >= this._contentWritten && (!this._last || longValue == this._contentWritten)) {
                                    field2 = field3;
                                    buffer = this._header;
                                }
                                field2 = null;
                                buffer = this._header;
                            } else if (nameOrdinal == 16) {
                                if (BufferUtil.isPrefix(MimeTypes.MULTIPART_BYTERANGES_BUFFER, field3.getValueBuffer())) {
                                    this._contentLength = -4L;
                                }
                                field3.putTo(this._header);
                                z2 = true;
                            } else if (nameOrdinal != i) {
                                buffer = this._header;
                            } else if (getSendServerVersion()) {
                                field3.putTo(this._header);
                                z5 = true;
                            }
                        } else if (this._version == i3) {
                            field = field3;
                        }
                        field3.putTo(buffer);
                    }
                    i4++;
                    i2 = -1;
                    z7 = true;
                    i3 = 11;
                    i = 48;
                }
            } else {
                field = null;
                sb = null;
                field2 = null;
                z2 = false;
                z3 = false;
                z4 = false;
                z5 = false;
            }
            HttpFields.Field field4 = field;
            int i6 = (int) this._contentLength;
            if (i6 != -3) {
                if (i6 == -1) {
                    this._persistent = Boolean.valueOf(isRequest());
                } else if (i6 == 0 && field2 == null && isResponse() && this._status >= 200 && this._status != 204 && this._status != 304) {
                    this._header.put(CONTENT_LENGTH_0);
                }
            } else if (isResponse() && this._noContent) {
                this._contentLength = 0L;
                this._contentWritten = 0L;
            } else if (this._last) {
                this._contentLength = this._contentWritten;
                if (field2 == null && ((isResponse() || this._contentLength > 0 || z2) && !this._noContent)) {
                    this._header.put(HttpHeaders.CONTENT_LENGTH_BUFFER);
                    this._header.put(HttpTokens.COLON);
                    this._header.put((byte) 32);
                    BufferUtil.putDecLong(this._header, this._contentLength);
                    this._header.put(HttpTokens.CRLF);
                }
            } else {
                if (this._persistent.booleanValue() && this._version >= 11) {
                    j = -2;
                    this._contentLength = j;
                    if (isRequest() && this._contentLength == -1) {
                        this._contentLength = 0L;
                        this._noContent = true;
                    }
                }
                j = -1;
                this._contentLength = j;
                if (isRequest()) {
                    this._contentLength = 0L;
                    this._noContent = true;
                }
            }
            if (this._contentLength == -2) {
                if (field4 == null || 2 == field4.getValueOrdinal()) {
                    this._header.put(TRANSFER_ENCODING_CHUNKED);
                } else if (!field4.getValue().endsWith("chunked")) {
                    throw new IllegalArgumentException("BAD TE");
                } else {
                    field4.putTo(this._header);
                }
            }
            if (this._contentLength == -1) {
                this._persistent = false;
                z6 = false;
            } else {
                z6 = z3;
            }
            if (isResponse()) {
                if (!this._persistent.booleanValue() && (z4 || this._version > 10)) {
                    this._header.put(CONNECTION_CLOSE);
                    if (sb != null) {
                        this._header.setPutIndex(this._header.putIndex() - 2);
                        this._header.put(NativeRegExp.REOP_ASSERTNOTTEST);
                        this._header.put(sb.toString().getBytes());
                        this._header.put(CRLF);
                    }
                } else if (z6) {
                    this._header.put(CONNECTION_KEEP_ALIVE);
                    if (sb != null) {
                        this._header.setPutIndex(this._header.putIndex() - 2);
                        this._header.put(NativeRegExp.REOP_ASSERTNOTTEST);
                        this._header.put(sb.toString().getBytes());
                        this._header.put(CRLF);
                    }
                } else if (sb != null) {
                    this._header.put(CONNECTION_);
                    this._header.put(sb.toString().getBytes());
                    this._header.put(CRLF);
                }
            }
            if (!z5 && this._status > 199 && getSendServerVersion()) {
                this._header.put(SERVER);
            }
            this._header.put(HttpTokens.CRLF);
            this._state = 2;
        } catch (ArrayIndexOutOfBoundsException e) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Header>");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._header.capacity());
            throw new RuntimeException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x010e, code lost:
        return r3;
     */
    @Override // org.eclipse.jetty.http.AbstractGenerator, org.eclipse.jetty.http.Generator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int flushBuffer() throws IOException {
        EndPoint endPoint;
        Buffer buffer;
        EndPoint endPoint2;
        Buffer buffer2;
        Buffer buffer3;
        try {
            if (this._state == 0) {
                throw new IllegalStateException("State==HEADER");
            }
            prepareBuffers();
            if (this._endp == null) {
                if (this._needCRLF && this._buffer != null) {
                    this._buffer.put(HttpTokens.CRLF);
                }
                if (this._needEOC && this._buffer != null && !this._head) {
                    this._buffer.put(LAST_CHUNK);
                }
                this._needCRLF = false;
                this._needEOC = false;
                return 0;
            }
            int i = -1;
            int flushMask = flushMask();
            int i2 = 0;
            while (true) {
                switch (flushMask) {
                    case 0:
                        if (this._header != null) {
                            this._header.clear();
                        }
                        this._bypass = false;
                        this._bufferChunked = false;
                        if (this._buffer != null) {
                            this._buffer.clear();
                            if (this._contentLength == -2) {
                                this._buffer.setPutIndex(12);
                                this._buffer.setGetIndex(12);
                                if (this._content != null && this._content.length() < this._buffer.space() && this._state != 3) {
                                    this._buffer.put(this._content);
                                    this._content.clear();
                                    this._content = null;
                                }
                            }
                        }
                        if (this._needCRLF || this._needEOC || !(this._content == null || this._content.length() == 0)) {
                            prepareBuffers();
                        } else {
                            if (this._state == 3) {
                                this._state = 4;
                            }
                            if (this._state == 4 && this._persistent != null && !this._persistent.booleanValue() && this._status != 100 && this._method == null) {
                                this._endp.shutdownOutput();
                            }
                        }
                        i = 0;
                        break;
                    case 1:
                        endPoint = this._endp;
                        buffer = this._content;
                        i = endPoint.flush(buffer);
                        break;
                    case 2:
                        endPoint = this._endp;
                        buffer = this._buffer;
                        i = endPoint.flush(buffer);
                        break;
                    case 3:
                        endPoint2 = this._endp;
                        buffer2 = this._buffer;
                        buffer3 = this._content;
                        i = endPoint2.flush(buffer2, buffer3, null);
                        break;
                    case 4:
                        endPoint = this._endp;
                        buffer = this._header;
                        i = endPoint.flush(buffer);
                        break;
                    case 5:
                        endPoint2 = this._endp;
                        buffer2 = this._header;
                        buffer3 = this._content;
                        i = endPoint2.flush(buffer2, buffer3, null);
                        break;
                    case 6:
                        endPoint2 = this._endp;
                        buffer2 = this._header;
                        buffer3 = this._buffer;
                        i = endPoint2.flush(buffer2, buffer3, null);
                        break;
                    case 7:
                        throw new IllegalStateException();
                }
                if (i > 0) {
                    i2 += i;
                }
                int flushMask2 = flushMask();
                if (i > 0 || (flushMask2 != 0 && flushMask == 0)) {
                    flushMask = flushMask2;
                }
            }
        } catch (IOException e) {
            LOG.ignore(e);
            if (!(e instanceof EofException)) {
                throw new EofException(e);
            }
            throw e;
        }
    }

    public int getBytesBuffered() {
        Buffer buffer = this._header;
        int i = 0;
        int length = buffer == null ? 0 : buffer.length();
        Buffer buffer2 = this._buffer;
        int length2 = length + (buffer2 == null ? 0 : buffer2.length());
        Buffer buffer3 = this._content;
        if (buffer3 != null) {
            i = buffer3.length();
        }
        return length2 + i;
    }

    @Override // org.eclipse.jetty.http.AbstractGenerator, org.eclipse.jetty.http.Generator
    public boolean isBufferFull() {
        Buffer buffer;
        return super.isBufferFull() || this._bufferChunked || this._bypass || (this._contentLength == -2 && (buffer = this._buffer) != null && buffer.space() < 12);
    }

    public boolean isEmpty() {
        Buffer buffer;
        Buffer buffer2;
        Buffer buffer3 = this._header;
        return (buffer3 == null || buffer3.length() == 0) && ((buffer = this._buffer) == null || buffer.length() == 0) && ((buffer2 = this._content) == null || buffer2.length() == 0);
    }

    @Override // org.eclipse.jetty.http.AbstractGenerator
    public boolean isRequest() {
        return this._method != null;
    }

    @Override // org.eclipse.jetty.http.AbstractGenerator
    public boolean isResponse() {
        return this._method == null;
    }

    @Override // org.eclipse.jetty.http.AbstractGenerator
    public int prepareUncheckedAddContent() throws IOException {
        if (!this._noContent && !this._last && this._state != 4) {
            Buffer buffer = this._content;
            if ((buffer != null && buffer.length() > 0) || this._bufferChunked) {
                flushBuffer();
                if ((buffer != null && buffer.length() > 0) || this._bufferChunked) {
                    throw new IllegalStateException("FULL");
                }
            }
            if (this._buffer == null) {
                this._buffer = this._buffers.getBuffer();
            }
            this._contentWritten -= this._buffer.length();
            if (this._head) {
                return Integer.MAX_VALUE;
            }
            return this._buffer.space() - (this._contentLength == -2 ? 12 : 0);
        }
        return -1;
    }

    @Override // org.eclipse.jetty.http.AbstractGenerator, org.eclipse.jetty.http.Generator
    public void reset() {
        EndPoint endPoint;
        Boolean bool = this._persistent;
        if (bool != null && !bool.booleanValue() && (endPoint = this._endp) != null && !endPoint.isOutputShutdown()) {
            try {
                this._endp.shutdownOutput();
            } catch (IOException e) {
                LOG.ignore(e);
            }
        }
        super.reset();
        Buffer buffer = this._buffer;
        if (buffer != null) {
            buffer.clear();
        }
        Buffer buffer2 = this._header;
        if (buffer2 != null) {
            buffer2.clear();
        }
        if (this._content != null) {
            this._content = null;
        }
        this._bypass = false;
        this._needCRLF = false;
        this._needEOC = false;
        this._bufferChunked = false;
        this._method = null;
        this._uri = null;
        this._noContent = false;
    }

    public void send1xx(int i) throws IOException {
        if (this._state != 0) {
            return;
        }
        if (i < 100 || i > 199) {
            throw new IllegalArgumentException("!1xx");
        }
        Status status = __status[i];
        if (status == null) {
            throw new IllegalArgumentException(i + "?");
        }
        if (this._header == null) {
            this._header = this._buffers.getHeader();
        }
        this._header.put(status._responseLine);
        this._header.put(HttpTokens.CRLF);
        while (this._header.length() > 0) {
            try {
                int flush = this._endp.flush(this._header);
                if (flush < 0 || !this._endp.isOpen()) {
                    throw new EofException();
                } else if (flush == 0) {
                    Thread.sleep(100L);
                }
            } catch (InterruptedException e) {
                LOG.debug(e);
                throw new InterruptedIOException(e.toString());
            }
        }
    }

    public void sendResponse(Buffer buffer) throws IOException {
        Buffer buffer2;
        if (this._noContent || this._state != 0 || (((buffer2 = this._content) != null && buffer2.length() > 0) || this._bufferChunked || this._head)) {
            throw new IllegalStateException();
        }
        this._last = true;
        this._content = buffer;
        this._bypass = true;
        this._state = 3;
        long length = buffer.length();
        this._contentWritten = length;
        this._contentLength = length;
    }

    public String toString() {
        Buffer buffer = this._header;
        Buffer buffer2 = this._buffer;
        Buffer buffer3 = this._content;
        Object[] objArr = new Object[5];
        objArr[0] = HttpGenerator.class.getSimpleName();
        objArr[1] = Integer.valueOf(this._state);
        int i = -1;
        objArr[2] = Integer.valueOf(buffer == null ? -1 : buffer.length());
        objArr[3] = Integer.valueOf(buffer2 == null ? -1 : buffer2.length());
        if (buffer3 != null) {
            i = buffer3.length();
        }
        objArr[4] = Integer.valueOf(i);
        return String.format("%s{s=%d,h=%d,b=%d,c=%d}", objArr);
    }
}
