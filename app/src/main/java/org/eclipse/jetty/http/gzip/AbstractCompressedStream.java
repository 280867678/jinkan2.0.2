package org.eclipse.jetty.http.gzip;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.zip.DeflaterOutputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletOutputStream;
import me.tvspark.ae0;
import me.tvspark.ce0;
import org.eclipse.jetty.util.ByteArrayOutputStream2;

/* loaded from: classes4.dex */
public abstract class AbstractCompressedStream extends ServletOutputStream {
    public ByteArrayOutputStream2 _bOut;
    public boolean _closed;
    public DeflaterOutputStream _compressedOutputStream;
    public boolean _doNotCompress;
    public final String _encoding;
    public OutputStream _out;
    public final ce0 _response;
    public final String _vary;
    public final CompressedResponseWrapper _wrapper;

    public AbstractCompressedStream(String str, ae0 ae0Var, CompressedResponseWrapper compressedResponseWrapper, String str2) throws IOException {
        this._encoding = str;
        this._wrapper = compressedResponseWrapper;
        this._response = (ce0) compressedResponseWrapper.getResponse();
        this._vary = str2;
        if (this._wrapper.getMinCompressSize() == 0) {
            doCompress();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
        if (r4 < r6._wrapper.getMinCompressSize()) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0060, code lost:
        doNotCompress(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005e, code lost:
        if (r4 < r6._wrapper.getMinCompressSize()) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void checkOut(int i) throws IOException {
        if (!this._closed) {
            if (this._out != null) {
                ByteArrayOutputStream2 byteArrayOutputStream2 = this._bOut;
                if (byteArrayOutputStream2 == null || i < byteArrayOutputStream2.getBuf().length - this._bOut.getCount()) {
                    return;
                }
                long contentLength = this._wrapper.getContentLength();
                if (contentLength >= 0) {
                }
                doCompress();
                return;
            } else if (i > this._wrapper.getBufferSize()) {
                long contentLength2 = this._wrapper.getContentLength();
                if (contentLength2 >= 0) {
                }
                doCompress();
                return;
            } else {
                ByteArrayOutputStream2 byteArrayOutputStream22 = new ByteArrayOutputStream2(this._wrapper.getBufferSize());
                this._bOut = byteArrayOutputStream22;
                this._out = byteArrayOutputStream22;
                return;
            }
        }
        throw new IOException("CLOSED");
    }

    public void addHeader(String str, String str2) {
        this._response.addHeader(str, str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0046, code lost:
        if (r6._out == null) goto L23;
     */
    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void close() throws IOException {
        if (this._closed) {
            return;
        }
        if (this._wrapper.getRequest().getAttribute(RequestDispatcher.INCLUDE_REQUEST_URI) != null) {
            flush();
            return;
        }
        if (this._bOut != null) {
            long contentLength = this._wrapper.getContentLength();
            if (contentLength < 0) {
                contentLength = this._bOut.getCount();
                this._wrapper.setContentLength(contentLength);
            }
            if (contentLength >= this._wrapper.getMinCompressSize()) {
                doCompress();
            }
            doNotCompress(false);
        }
        DeflaterOutputStream deflaterOutputStream = this._compressedOutputStream;
        if (deflaterOutputStream != null) {
            deflaterOutputStream.close();
        } else {
            this._out.close();
        }
        this._closed = true;
    }

    public abstract DeflaterOutputStream createStream() throws IOException;

    public void doCompress() throws IOException {
        if (this._compressedOutputStream == null) {
            if (this._response.isCommitted()) {
                throw new IllegalStateException();
            }
            String str = this._encoding;
            if (str != null) {
                setHeader("Content-Encoding", str);
                if (this._response.containsHeader("Content-Encoding")) {
                    addHeader("Vary", this._vary);
                    DeflaterOutputStream createStream = createStream();
                    this._compressedOutputStream = createStream;
                    this._out = createStream;
                    if (createStream != null) {
                        ByteArrayOutputStream2 byteArrayOutputStream2 = this._bOut;
                        if (byteArrayOutputStream2 != null) {
                            createStream.write(byteArrayOutputStream2.getBuf(), 0, this._bOut.getCount());
                            this._bOut = null;
                        }
                        String eTag = this._wrapper.getETag();
                        if (eTag == null) {
                            return;
                        }
                        setHeader("ETag", eTag.substring(0, eTag.length() - 1) + '-' + this._encoding + '\"');
                        return;
                    }
                }
            }
            doNotCompress(true);
        }
    }

    public void doNotCompress(boolean z) throws IOException {
        if (this._compressedOutputStream == null) {
            if (this._out != null && this._bOut == null) {
                return;
            }
            if (z) {
                addHeader("Vary", this._vary);
            }
            if (this._wrapper.getETag() != null) {
                setHeader("ETag", this._wrapper.getETag());
            }
            this._doNotCompress = true;
            this._out = this._response.getOutputStream();
            setContentLength();
            ByteArrayOutputStream2 byteArrayOutputStream2 = this._bOut;
            if (byteArrayOutputStream2 != null) {
                this._out.write(byteArrayOutputStream2.getBuf(), 0, this._bOut.getCount());
            }
            this._bOut = null;
            return;
        }
        throw new IllegalStateException("Compressed output stream is already assigned.");
    }

    public void finish() throws IOException {
        if (!this._closed) {
            if (this._out == null || this._bOut != null) {
                long contentLength = this._wrapper.getContentLength();
                if (contentLength < 0 || contentLength >= this._wrapper.getMinCompressSize()) {
                    doCompress();
                } else {
                    doNotCompress(false);
                }
            }
            DeflaterOutputStream deflaterOutputStream = this._compressedOutputStream;
            if (deflaterOutputStream == null || this._closed) {
                return;
            }
            this._closed = true;
            deflaterOutputStream.close();
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        if (this._out == null || this._bOut != null) {
            long contentLength = this._wrapper.getContentLength();
            if (contentLength <= 0 || contentLength >= this._wrapper.getMinCompressSize()) {
                doCompress();
            } else {
                doNotCompress(false);
            }
        }
        this._out.flush();
    }

    public OutputStream getOutputStream() {
        return this._out;
    }

    public boolean isClosed() {
        return this._closed;
    }

    public PrintWriter newWriter(OutputStream outputStream, String str) throws UnsupportedEncodingException {
        return str == null ? new PrintWriter(outputStream) : new PrintWriter(new OutputStreamWriter(outputStream, str));
    }

    public void resetBuffer() {
        if (this._response.isCommitted() || this._compressedOutputStream != null) {
            throw new IllegalStateException("Committed");
        }
        this._closed = false;
        this._out = null;
        this._bOut = null;
        this._doNotCompress = false;
    }

    public void setBufferSize(int i) {
        ByteArrayOutputStream2 byteArrayOutputStream2 = this._bOut;
        if (byteArrayOutputStream2 == null || byteArrayOutputStream2.getBuf().length >= i) {
            return;
        }
        ByteArrayOutputStream2 byteArrayOutputStream22 = new ByteArrayOutputStream2(i);
        byteArrayOutputStream22.write(this._bOut.getBuf(), 0, this._bOut.size());
        this._bOut = byteArrayOutputStream22;
    }

    public void setContentLength() {
        if (this._doNotCompress) {
            long contentLength = this._wrapper.getContentLength();
            if (contentLength < 0) {
                return;
            }
            int i = (contentLength > 2147483647L ? 1 : (contentLength == 2147483647L ? 0 : -1));
            ce0 ce0Var = this._response;
            if (i < 0) {
                ce0Var.setContentLength((int) contentLength);
            } else {
                ce0Var.setHeader("Content-Length", Long.toString(contentLength));
            }
        }
    }

    public void setHeader(String str, String str2) {
        this._response.setHeader(str, str2);
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        checkOut(1);
        this._out.write(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        checkOut(bArr.length);
        this._out.write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        checkOut(i2);
        this._out.write(bArr, i, i2);
    }
}
