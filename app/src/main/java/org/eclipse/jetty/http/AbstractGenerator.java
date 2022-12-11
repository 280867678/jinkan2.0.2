package org.eclipse.jetty.http;

import java.io.IOException;
import me.tvspark.outline;
import org.eclipse.jetty.p059io.Buffer;
import org.eclipse.jetty.p059io.Buffers;
import org.eclipse.jetty.p059io.ByteArrayBuffer;
import org.eclipse.jetty.p059io.EndPoint;
import org.eclipse.jetty.p059io.EofException;
import org.eclipse.jetty.p059io.View;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes4.dex */
public abstract class AbstractGenerator implements Generator {
    public static final Logger LOG = Log.getLogger(AbstractGenerator.class);
    public static final byte[] NO_BYTES = new byte[0];
    public static final int STATE_CONTENT = 2;
    public static final int STATE_END = 4;
    public static final int STATE_FLUSHING = 3;
    public static final int STATE_HEADER = 0;
    public Buffer _buffer;
    public final Buffers _buffers;
    public Buffer _content;
    public Buffer _date;
    public final EndPoint _endp;
    public Buffer _header;
    public Buffer _method;
    public Buffer _reason;
    public boolean _sendServerVersion;
    public String _uri;
    public int _state = 0;
    public int _status = 0;
    public int _version = 11;
    public long _contentWritten = 0;
    public long _contentLength = -3;
    public boolean _last = false;
    public boolean _head = false;
    public boolean _noContent = false;
    public Boolean _persistent = null;

    public AbstractGenerator(Buffers buffers, EndPoint endPoint) {
        this._buffers = buffers;
        this._endp = endPoint;
    }

    public void blockForOutput(long j) throws IOException {
        if (this._endp.isBlocking()) {
            try {
                flushBuffer();
            } catch (IOException e) {
                this._endp.close();
                throw e;
            }
        } else if (this._endp.blockWritable(j)) {
            flushBuffer();
        } else {
            this._endp.close();
            throw new EofException("timeout");
        }
    }

    @Override // org.eclipse.jetty.http.Generator
    public void complete() throws IOException {
        if (this._state != 0) {
            long j = this._contentLength;
            if (j < 0 || j == this._contentWritten || this._head) {
                return;
            }
            if (LOG.isDebugEnabled()) {
                Logger logger = LOG;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ContentLength written==");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._contentWritten);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" != contentLength==");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._contentLength);
                logger.debug(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), new Object[0]);
            }
            this._persistent = false;
            return;
        }
        throw new IllegalStateException("State==HEADER");
    }

    @Override // org.eclipse.jetty.http.Generator
    public abstract void completeHeader(HttpFields httpFields, boolean z) throws IOException;

    public void completeUncheckedAddContent() {
        Buffer buffer;
        if (this._noContent) {
            buffer = this._buffer;
            if (buffer == null) {
                return;
            }
        } else {
            this._contentWritten += this._buffer.length();
            if (!this._head) {
                return;
            }
            buffer = this._buffer;
        }
        buffer.clear();
    }

    public void flush(long j) throws IOException {
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = j + currentTimeMillis;
        Buffer buffer = this._content;
        Buffer buffer2 = this._buffer;
        if ((buffer == null || buffer.length() <= 0) && ((buffer2 == null || buffer2.length() <= 0) && !isBufferFull())) {
            return;
        }
        flushBuffer();
        while (currentTimeMillis < j2) {
            if ((buffer == null || buffer.length() <= 0) && (buffer2 == null || buffer2.length() <= 0)) {
                return;
            }
            if (!this._endp.isOpen() || this._endp.isOutputShutdown()) {
                throw new EofException();
            }
            blockForOutput(j2 - currentTimeMillis);
            currentTimeMillis = System.currentTimeMillis();
        }
    }

    @Override // org.eclipse.jetty.http.Generator
    public abstract int flushBuffer() throws IOException;

    @Override // org.eclipse.jetty.http.Generator
    public int getContentBufferSize() {
        if (this._buffer == null) {
            this._buffer = this._buffers.getBuffer();
        }
        return this._buffer.capacity();
    }

    @Override // org.eclipse.jetty.http.Generator
    public long getContentWritten() {
        return this._contentWritten;
    }

    public boolean getSendServerVersion() {
        return this._sendServerVersion;
    }

    public int getState() {
        return this._state;
    }

    public Buffer getUncheckedBuffer() {
        return this._buffer;
    }

    public int getVersion() {
        return this._version;
    }

    @Override // org.eclipse.jetty.http.Generator
    public void increaseContentBufferSize(int i) {
        if (this._buffer == null) {
            this._buffer = this._buffers.getBuffer();
        }
        if (i > this._buffer.capacity()) {
            Buffer buffer = this._buffers.getBuffer(i);
            buffer.put(this._buffer);
            this._buffers.returnBuffer(this._buffer);
            this._buffer = buffer;
        }
    }

    @Override // org.eclipse.jetty.http.Generator
    public boolean isAllContentWritten() {
        long j = this._contentLength;
        return j >= 0 && this._contentWritten >= j;
    }

    @Override // org.eclipse.jetty.http.Generator
    public boolean isBufferFull() {
        Buffer buffer = this._buffer;
        if (buffer == null || buffer.space() != 0) {
            Buffer buffer2 = this._content;
            return buffer2 != null && buffer2.length() > 0;
        }
        if (this._buffer.length() == 0 && !this._buffer.isImmutable()) {
            this._buffer.compact();
        }
        return this._buffer.space() == 0;
    }

    @Override // org.eclipse.jetty.http.Generator
    public boolean isCommitted() {
        return this._state != 0;
    }

    @Override // org.eclipse.jetty.http.Generator
    public boolean isComplete() {
        return this._state == 4;
    }

    public boolean isHead() {
        return this._head;
    }

    @Override // org.eclipse.jetty.http.Generator
    public boolean isIdle() {
        return this._state == 0 && this._method == null && this._status == 0;
    }

    public boolean isOpen() {
        return this._endp.isOpen();
    }

    @Override // org.eclipse.jetty.http.Generator
    public boolean isPersistent() {
        Boolean bool = this._persistent;
        return bool != null ? bool.booleanValue() : isRequest() || this._version > 10;
    }

    public abstract boolean isRequest();

    public abstract boolean isResponse();

    public boolean isState(int i) {
        return this._state == i;
    }

    @Override // org.eclipse.jetty.http.Generator
    public boolean isWritten() {
        return this._contentWritten > 0;
    }

    public abstract int prepareUncheckedAddContent() throws IOException;

    @Override // org.eclipse.jetty.http.Generator
    public void reset() {
        this._state = 0;
        this._status = 0;
        this._version = 11;
        this._reason = null;
        this._last = false;
        this._head = false;
        this._noContent = false;
        this._persistent = null;
        this._contentWritten = 0L;
        this._contentLength = -3L;
        this._date = null;
        this._content = null;
        this._method = null;
    }

    @Override // org.eclipse.jetty.http.Generator
    public void resetBuffer() {
        if (this._state < 3) {
            this._last = false;
            this._persistent = null;
            this._contentWritten = 0L;
            this._contentLength = -3L;
            this._content = null;
            Buffer buffer = this._buffer;
            if (buffer == null) {
                return;
            }
            buffer.clear();
            return;
        }
        throw new IllegalStateException("Flushed");
    }

    @Override // org.eclipse.jetty.http.Generator
    public void returnBuffers() {
        Buffer buffer = this._buffer;
        if (buffer != null && buffer.length() == 0) {
            this._buffers.returnBuffer(this._buffer);
            this._buffer = null;
        }
        Buffer buffer2 = this._header;
        if (buffer2 == null || buffer2.length() != 0) {
            return;
        }
        this._buffers.returnBuffer(this._header);
        this._header = null;
    }

    @Override // org.eclipse.jetty.http.Generator
    public void sendError(int i, String str, String str2, boolean z) throws IOException {
        if (z) {
            this._persistent = false;
        }
        if (isCommitted()) {
            LOG.debug("sendError on committed: {} {}", Integer.valueOf(i), str);
            return;
        }
        LOG.debug("sendError: {} {}", Integer.valueOf(i), str);
        setResponse(i, str);
        if (str2 != null) {
            completeHeader(null, false);
            addContent(new View(new ByteArrayBuffer(str2)), true);
        } else if (i >= 400) {
            completeHeader(null, false);
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Error: ");
            if (str == null) {
                str = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("", i);
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str);
            addContent(new View(new ByteArrayBuffer(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString())), true);
        } else {
            completeHeader(null, true);
        }
        complete();
    }

    @Override // org.eclipse.jetty.http.Generator
    public void setContentLength(long j) {
        if (j < 0) {
            j = -3;
        }
        this._contentLength = j;
    }

    @Override // org.eclipse.jetty.http.Generator
    public void setDate(Buffer buffer) {
        this._date = buffer;
    }

    @Override // org.eclipse.jetty.http.Generator
    public void setHead(boolean z) {
        this._head = z;
    }

    @Override // org.eclipse.jetty.http.Generator
    public void setPersistent(boolean z) {
        this._persistent = Boolean.valueOf(z);
    }

    @Override // org.eclipse.jetty.http.Generator
    public void setRequest(String str, String str2) {
        this._method = (str == null || "GET".equals(str)) ? HttpMethods.GET_BUFFER : HttpMethods.CACHE.lookup(str);
        this._uri = str2;
        if (this._version == 9) {
            this._noContent = true;
        }
    }

    @Override // org.eclipse.jetty.http.Generator
    public void setResponse(int i, String str) {
        if (this._state == 0) {
            this._method = null;
            this._status = i;
            if (str == null) {
                return;
            }
            byte[] bytes = StringUtil.getBytes(str);
            int length = bytes.length;
            if (length > 1024) {
                length = 1024;
            }
            this._reason = new ByteArrayBuffer(length);
            for (int i2 = 0; i2 < length; i2++) {
                byte b = bytes[i2];
                if (b == 13 || b == 10) {
                    this._reason.put((byte) 32);
                } else {
                    this._reason.put(b);
                }
            }
            return;
        }
        throw new IllegalStateException("STATE!=START");
    }

    @Override // org.eclipse.jetty.http.Generator
    public void setSendServerVersion(boolean z) {
        this._sendServerVersion = z;
    }

    @Override // org.eclipse.jetty.http.Generator
    public void setVersion(int i) {
        if (this._state != 0) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("STATE!=START ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._state);
            throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        this._version = i;
        if (i != 9 || this._method == null) {
            return;
        }
        this._noContent = true;
    }

    public void uncheckedAddContent(int i) {
        this._buffer.put((byte) i);
    }
}
