package org.eclipse.jetty.server.handler;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.GZIPOutputStream;
import javax.servlet.ServletException;
import me.tvspark.ae0;
import me.tvspark.ce0;
import org.eclipse.jetty.continuation.Continuation;
import org.eclipse.jetty.continuation.ContinuationListener;
import org.eclipse.jetty.continuation.ContinuationSupport;
import org.eclipse.jetty.http.gzip.AbstractCompressedStream;
import org.eclipse.jetty.http.gzip.CompressedResponseWrapper;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes4.dex */
public class GzipHandler extends HandlerWrapper {
    public static final Logger LOG = Log.getLogger(GzipHandler.class);
    public Set<String> _excluded;
    public Set<String> _mimeTypes;
    public int _bufferSize = 8192;
    public int _minGzipSize = 256;
    public String _vary = "Accept-Encoding, User-Agent";

    public int getBufferSize() {
        return this._bufferSize;
    }

    public Set<String> getExcluded() {
        return this._excluded;
    }

    public Set<String> getMimeTypes() {
        return this._mimeTypes;
    }

    public int getMinGzipSize() {
        return this._minGzipSize;
    }

    public String getVary() {
        return this._vary;
    }

    @Override // org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.Handler
    public void handle(String str, Request request, ae0 ae0Var, ce0 ce0Var) throws IOException, ServletException {
        if (this._handler == null || !isStarted()) {
            return;
        }
        String header = ae0Var.getHeader("accept-encoding");
        if (header == null || header.indexOf("gzip") < 0 || ce0Var.containsHeader("Content-Encoding") || "HEAD".equalsIgnoreCase(ae0Var.getMethod())) {
            this._handler.handle(str, request, ae0Var, ce0Var);
            return;
        }
        if (this._excluded != null) {
            if (this._excluded.contains(ae0Var.getHeader("User-Agent"))) {
                this._handler.handle(str, request, ae0Var, ce0Var);
                return;
            }
        }
        final CompressedResponseWrapper newGzipResponseWrapper = newGzipResponseWrapper(ae0Var, ce0Var);
        try {
            this._handler.handle(str, request, ae0Var, newGzipResponseWrapper);
            Continuation continuation = ContinuationSupport.getContinuation(ae0Var);
            if (!continuation.isSuspended() || !continuation.isResponseWrapped()) {
                newGzipResponseWrapper.finish();
            } else {
                continuation.addContinuationListener(new ContinuationListener() { // from class: org.eclipse.jetty.server.handler.GzipHandler.1
                    @Override // org.eclipse.jetty.continuation.ContinuationListener
                    public void onComplete(Continuation continuation2) {
                        try {
                            newGzipResponseWrapper.finish();
                        } catch (IOException e) {
                            GzipHandler.LOG.warn(e);
                        }
                    }

                    @Override // org.eclipse.jetty.continuation.ContinuationListener
                    public void onTimeout(Continuation continuation2) {
                    }
                });
            }
        } catch (Throwable th) {
            Continuation continuation2 = ContinuationSupport.getContinuation(ae0Var);
            if (continuation2.isSuspended() && continuation2.isResponseWrapped()) {
                continuation2.addContinuationListener(new ContinuationListener() { // from class: org.eclipse.jetty.server.handler.GzipHandler.1
                    @Override // org.eclipse.jetty.continuation.ContinuationListener
                    public void onComplete(Continuation continuation22) {
                        try {
                            newGzipResponseWrapper.finish();
                        } catch (IOException e) {
                            GzipHandler.LOG.warn(e);
                        }
                    }

                    @Override // org.eclipse.jetty.continuation.ContinuationListener
                    public void onTimeout(Continuation continuation22) {
                    }
                });
            } else if (!ce0Var.isCommitted()) {
                newGzipResponseWrapper.resetBuffer();
                newGzipResponseWrapper.noCompression();
            } else {
                newGzipResponseWrapper.finish();
            }
            throw th;
        }
    }

    public CompressedResponseWrapper newGzipResponseWrapper(ae0 ae0Var, ce0 ce0Var) {
        return new CompressedResponseWrapper(ae0Var, ce0Var) { // from class: org.eclipse.jetty.server.handler.GzipHandler.2
            {
                super.setMimeTypes(GzipHandler.this._mimeTypes);
                super.setBufferSize(GzipHandler.this._bufferSize);
                super.setMinCompressSize(GzipHandler.this._minGzipSize);
            }

            @Override // org.eclipse.jetty.http.gzip.CompressedResponseWrapper
            public AbstractCompressedStream newCompressedStream(ae0 ae0Var2, ce0 ce0Var2) throws IOException {
                return new AbstractCompressedStream("gzip", ae0Var2, this, GzipHandler.this._vary) { // from class: org.eclipse.jetty.server.handler.GzipHandler.2.1
                    @Override // org.eclipse.jetty.http.gzip.AbstractCompressedStream
                    public DeflaterOutputStream createStream() throws IOException {
                        return new GZIPOutputStream(this._response.getOutputStream(), GzipHandler.this._bufferSize);
                    }
                };
            }

            @Override // org.eclipse.jetty.http.gzip.CompressedResponseWrapper
            public PrintWriter newWriter(OutputStream outputStream, String str) throws UnsupportedEncodingException {
                return GzipHandler.this.newWriter(outputStream, str);
            }
        };
    }

    public PrintWriter newWriter(OutputStream outputStream, String str) throws UnsupportedEncodingException {
        return str == null ? new PrintWriter(outputStream) : new PrintWriter(new OutputStreamWriter(outputStream, str));
    }

    public void setBufferSize(int i) {
        this._bufferSize = i;
    }

    public void setExcluded(String str) {
        if (str != null) {
            this._excluded = new HashSet();
            StringTokenizer stringTokenizer = new StringTokenizer(str, ",", false);
            while (stringTokenizer.hasMoreTokens()) {
                this._excluded.add(stringTokenizer.nextToken());
            }
        }
    }

    public void setExcluded(Set<String> set) {
        this._excluded = set;
    }

    public void setMimeTypes(String str) {
        if (str != null) {
            this._mimeTypes = new HashSet();
            StringTokenizer stringTokenizer = new StringTokenizer(str, ",", false);
            while (stringTokenizer.hasMoreTokens()) {
                this._mimeTypes.add(stringTokenizer.nextToken());
            }
        }
    }

    public void setMimeTypes(Set<String> set) {
        this._mimeTypes = set;
    }

    public void setMinGzipSize(int i) {
        this._minGzipSize = i;
    }

    public void setVary(String str) {
        this._vary = str;
    }
}
