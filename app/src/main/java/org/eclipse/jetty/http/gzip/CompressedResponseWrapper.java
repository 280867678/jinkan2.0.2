package org.eclipse.jetty.http.gzip;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Set;
import javax.servlet.ServletOutputStream;
import me.tvspark.ae0;
import me.tvspark.ce0;
import me.tvspark.de0;
import org.eclipse.jetty.util.StringUtil;

/* loaded from: classes4.dex */
public abstract class CompressedResponseWrapper extends de0 {
    public static final int DEFAULT_BUFFER_SIZE = 8192;
    public static final int DEFAULT_MIN_COMPRESS_SIZE = 256;
    public AbstractCompressedStream _compressedStream;
    public String _etag;
    public Set<String> _mimeTypes;
    public boolean _noCompression;
    public ae0 _request;
    public PrintWriter _writer;
    public int _bufferSize = 8192;
    public int _minCompressSize = 256;
    public long _contentLength = -1;

    public CompressedResponseWrapper(ae0 ae0Var, ce0 ce0Var) {
        super(ce0Var);
        this._request = ae0Var;
    }

    private void setDeferredHeaders() {
        if (!isCommitted()) {
            long j = this._contentLength;
            if (j >= 0) {
                if (j < 2147483647L) {
                    super.setContentLength((int) j);
                } else {
                    super.setHeader("Content-Length", Long.toString(j));
                }
            }
            String str = this._etag;
            if (str == null) {
                return;
            }
            super.setHeader("ETag", str);
        }
    }

    @Override // me.tvspark.de0, me.tvspark.ce0
    public void addHeader(String str, String str2) {
        if ("content-length".equalsIgnoreCase(str)) {
            this._contentLength = Long.parseLong(str2);
            AbstractCompressedStream abstractCompressedStream = this._compressedStream;
            if (abstractCompressedStream == null) {
                return;
            }
            abstractCompressedStream.setContentLength();
        } else if ("content-type".equalsIgnoreCase(str)) {
            setContentType(str2);
        } else if ("content-encoding".equalsIgnoreCase(str)) {
            super.addHeader(str, str2);
            if (isCommitted()) {
                return;
            }
            noCompression();
        } else if ("etag".equalsIgnoreCase(str)) {
            this._etag = str2;
        } else {
            super.addHeader(str, str2);
        }
    }

    @Override // me.tvspark.de0, me.tvspark.ce0
    public boolean containsHeader(String str) {
        if (this._noCompression || !"etag".equalsIgnoreCase(str) || this._etag == null) {
            return super.containsHeader(str);
        }
        return true;
    }

    public void finish() throws IOException {
        if (this._writer != null && !this._compressedStream.isClosed()) {
            this._writer.flush();
        }
        AbstractCompressedStream abstractCompressedStream = this._compressedStream;
        if (abstractCompressedStream != null) {
            abstractCompressedStream.finish();
        } else {
            setDeferredHeaders();
        }
    }

    @Override // javax.servlet.ServletResponseWrapper, javax.servlet.ServletResponse
    public void flushBuffer() throws IOException {
        PrintWriter printWriter = this._writer;
        if (printWriter != null) {
            printWriter.flush();
        }
        AbstractCompressedStream abstractCompressedStream = this._compressedStream;
        if (abstractCompressedStream != null) {
            abstractCompressedStream.flush();
        } else {
            getResponse().flushBuffer();
        }
    }

    @Override // javax.servlet.ServletResponseWrapper, javax.servlet.ServletResponse
    public int getBufferSize() {
        return this._bufferSize;
    }

    public long getContentLength() {
        return this._contentLength;
    }

    public String getETag() {
        return this._etag;
    }

    public int getMinCompressSize() {
        return this._minCompressSize;
    }

    @Override // javax.servlet.ServletResponseWrapper, javax.servlet.ServletResponse
    public ServletOutputStream getOutputStream() throws IOException {
        if (this._compressedStream == null) {
            if (getResponse().isCommitted() || this._noCompression) {
                return getResponse().getOutputStream();
            }
            this._compressedStream = newCompressedStream(this._request, (ce0) getResponse());
        } else if (this._writer != null) {
            throw new IllegalStateException("getWriter() called");
        }
        return this._compressedStream;
    }

    public ae0 getRequest() {
        return this._request;
    }

    @Override // javax.servlet.ServletResponseWrapper, javax.servlet.ServletResponse
    public PrintWriter getWriter() throws IOException {
        if (this._writer == null) {
            if (this._compressedStream != null) {
                throw new IllegalStateException("getOutputStream() called");
            }
            if (getResponse().isCommitted() || this._noCompression) {
                return getResponse().getWriter();
            }
            AbstractCompressedStream newCompressedStream = newCompressedStream(this._request, (ce0) getResponse());
            this._compressedStream = newCompressedStream;
            this._writer = newWriter(newCompressedStream, getCharacterEncoding());
        }
        return this._writer;
    }

    public abstract AbstractCompressedStream newCompressedStream(ae0 ae0Var, ce0 ce0Var) throws IOException;

    public PrintWriter newWriter(OutputStream outputStream, String str) throws UnsupportedEncodingException {
        return str == null ? new PrintWriter(outputStream) : new PrintWriter(new OutputStreamWriter(outputStream, str));
    }

    public void noCompression() {
        if (!this._noCompression) {
            setDeferredHeaders();
        }
        this._noCompression = true;
        AbstractCompressedStream abstractCompressedStream = this._compressedStream;
        if (abstractCompressedStream != null) {
            try {
                abstractCompressedStream.doNotCompress(false);
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    @Override // javax.servlet.ServletResponseWrapper, javax.servlet.ServletResponse
    public void reset() {
        super.reset();
        AbstractCompressedStream abstractCompressedStream = this._compressedStream;
        if (abstractCompressedStream != null) {
            abstractCompressedStream.resetBuffer();
        }
        this._writer = null;
        this._compressedStream = null;
        this._noCompression = false;
        this._contentLength = -1L;
    }

    @Override // javax.servlet.ServletResponseWrapper, javax.servlet.ServletResponse
    public void resetBuffer() {
        super.resetBuffer();
        AbstractCompressedStream abstractCompressedStream = this._compressedStream;
        if (abstractCompressedStream != null) {
            abstractCompressedStream.resetBuffer();
        }
        this._writer = null;
        this._compressedStream = null;
    }

    @Override // me.tvspark.de0, me.tvspark.ce0
    public void sendError(int i) throws IOException {
        resetBuffer();
        super.sendError(i);
    }

    @Override // me.tvspark.de0, me.tvspark.ce0
    public void sendError(int i, String str) throws IOException {
        resetBuffer();
        super.sendError(i, str);
    }

    @Override // me.tvspark.de0, me.tvspark.ce0
    public void sendRedirect(String str) throws IOException {
        resetBuffer();
        super.sendRedirect(str);
    }

    @Override // javax.servlet.ServletResponseWrapper, javax.servlet.ServletResponse
    public void setBufferSize(int i) {
        this._bufferSize = i;
        AbstractCompressedStream abstractCompressedStream = this._compressedStream;
        if (abstractCompressedStream != null) {
            abstractCompressedStream.setBufferSize(i);
        }
    }

    @Override // javax.servlet.ServletResponseWrapper, javax.servlet.ServletResponse
    public void setContentLength(int i) {
        if (this._noCompression) {
            super.setContentLength(i);
        } else {
            setContentLength(i);
        }
    }

    public void setContentLength(long j) {
        this._contentLength = j;
        AbstractCompressedStream abstractCompressedStream = this._compressedStream;
        if (abstractCompressedStream != null) {
            abstractCompressedStream.setContentLength();
        } else if (!this._noCompression || j < 0) {
        } else {
            ce0 ce0Var = (ce0) getResponse();
            long j2 = this._contentLength;
            if (j2 < 2147483647L) {
                ce0Var.setContentLength((int) j2);
            } else {
                ce0Var.setHeader("Content-Length", Long.toString(j2));
            }
        }
    }

    @Override // javax.servlet.ServletResponseWrapper, javax.servlet.ServletResponse
    public void setContentType(String str) {
        int indexOf;
        super.setContentType(str);
        if (!this._noCompression) {
            if (str != null && (indexOf = str.indexOf(";")) > 0) {
                str = str.substring(0, indexOf);
            }
            AbstractCompressedStream abstractCompressedStream = this._compressedStream;
            if (abstractCompressedStream != null && abstractCompressedStream.getOutputStream() != null) {
                return;
            }
            if (this._mimeTypes != null || str == null || !str.contains("gzip")) {
                Set<String> set = this._mimeTypes;
                if (set == null) {
                    return;
                }
                if (str != null && set.contains(StringUtil.asciiToLowerCase(str))) {
                    return;
                }
            }
            noCompression();
        }
    }

    @Override // me.tvspark.de0, me.tvspark.ce0
    public void setHeader(String str, String str2) {
        if (!this._noCompression) {
            if ("content-length".equalsIgnoreCase(str)) {
                setContentLength(Long.parseLong(str2));
                return;
            } else if ("content-type".equalsIgnoreCase(str)) {
                setContentType(str2);
                return;
            } else if ("content-encoding".equalsIgnoreCase(str)) {
                super.setHeader(str, str2);
                if (isCommitted()) {
                    return;
                }
                noCompression();
                return;
            } else if ("etag".equalsIgnoreCase(str)) {
                this._etag = str2;
                return;
            }
        }
        super.setHeader(str, str2);
    }

    @Override // me.tvspark.de0, me.tvspark.ce0
    public void setIntHeader(String str, int i) {
        if (!"content-length".equalsIgnoreCase(str)) {
            super.setIntHeader(str, i);
            return;
        }
        this._contentLength = i;
        AbstractCompressedStream abstractCompressedStream = this._compressedStream;
        if (abstractCompressedStream == null) {
            return;
        }
        abstractCompressedStream.setContentLength();
    }

    public void setMimeTypes(Set<String> set) {
        this._mimeTypes = set;
    }

    public void setMinCompressSize(int i) {
        this._minCompressSize = i;
    }

    @Override // me.tvspark.de0, me.tvspark.ce0
    public void setStatus(int i) {
        super.setStatus(i);
        if (i < 200 || i == 204 || i == 205 || i >= 300) {
            noCompression();
        }
    }

    @Override // me.tvspark.de0, me.tvspark.ce0
    public void setStatus(int i, String str) {
        super.setStatus(i, str);
        if (i < 200 || i == 204 || i == 205 || i >= 300) {
            noCompression();
        }
    }
}
