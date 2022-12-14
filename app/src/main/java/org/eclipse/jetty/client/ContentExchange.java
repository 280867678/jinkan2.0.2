package org.eclipse.jetty.client;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import org.eclipse.jetty.http.HttpHeaders;
import org.eclipse.jetty.p059io.Buffer;
import org.eclipse.jetty.p059io.BufferUtil;
import org.eclipse.jetty.util.StringUtil;

/* loaded from: classes4.dex */
public class ContentExchange extends CachedExchange {
    public int _bufferSize = 4096;
    public String _encoding = "utf-8";
    public File _fileForUpload;
    public ByteArrayOutputStream _responseContent;

    public ContentExchange() {
        super(false);
    }

    public ContentExchange(boolean z) {
        super(z);
    }

    private synchronized InputStream getInputStream() throws IOException {
        return new FileInputStream(this._fileForUpload);
    }

    public synchronized File getFileForUpload() {
        return this._fileForUpload;
    }

    public synchronized String getResponseContent() throws UnsupportedEncodingException {
        if (this._responseContent != null) {
            return this._responseContent.toString(this._encoding);
        }
        return null;
    }

    public synchronized byte[] getResponseContentBytes() {
        if (this._responseContent != null) {
            return this._responseContent.toByteArray();
        }
        return null;
    }

    @Override // org.eclipse.jetty.client.HttpExchange
    public synchronized void onResponseContent(Buffer buffer) throws IOException {
        super.onResponseContent(buffer);
        if (this._responseContent == null) {
            this._responseContent = new ByteArrayOutputStream(this._bufferSize);
        }
        buffer.writeTo(this._responseContent);
    }

    @Override // org.eclipse.jetty.client.CachedExchange, org.eclipse.jetty.client.HttpExchange
    public synchronized void onResponseHeader(Buffer buffer, Buffer buffer2) throws IOException {
        String asciiToLowerCase;
        int indexOf;
        super.onResponseHeader(buffer, buffer2);
        int ordinal = HttpHeaders.CACHE.getOrdinal(buffer);
        if (ordinal == 12) {
            this._bufferSize = BufferUtil.toInt(buffer2);
        } else if (ordinal == 16 && (indexOf = (asciiToLowerCase = StringUtil.asciiToLowerCase(buffer2.toString())).indexOf("charset=")) > 0) {
            String substring = asciiToLowerCase.substring(indexOf + 8);
            this._encoding = substring;
            int indexOf2 = substring.indexOf(59);
            if (indexOf2 > 0) {
                this._encoding = this._encoding.substring(0, indexOf2);
            }
        }
    }

    @Override // org.eclipse.jetty.client.CachedExchange, org.eclipse.jetty.client.HttpExchange
    public synchronized void onResponseStatus(Buffer buffer, int i, Buffer buffer2) throws IOException {
        if (this._responseContent != null) {
            this._responseContent.reset();
        }
        super.onResponseStatus(buffer, i, buffer2);
    }

    @Override // org.eclipse.jetty.client.HttpExchange
    public synchronized void onRetry() throws IOException {
        if (this._fileForUpload != null) {
            setRequestContent(null);
            setRequestContentSource(getInputStream());
        } else {
            super.onRetry();
        }
    }

    public synchronized void setFileForUpload(File file) throws IOException {
        this._fileForUpload = file;
        setRequestContentSource(getInputStream());
    }
}
