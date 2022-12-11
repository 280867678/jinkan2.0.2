package org.eclipse.jetty.util;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import me.tvspark.outline;

/* loaded from: classes5.dex */
public class MultiPartOutputStream extends FilterOutputStream {
    public String boundary;
    public byte[] boundaryBytes;
    public boolean inPart;
    public static final byte[] __CRLF = {13, 10};
    public static final byte[] __DASHDASH = {45, 45};
    public static String MULTIPART_MIXED = "multipart/mixed";
    public static String MULTIPART_X_MIXED_REPLACE = "multipart/x-mixed-replace";

    public MultiPartOutputStream(OutputStream outputStream) throws IOException {
        super(outputStream);
        this.inPart = false;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("jetty");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(System.identityHashCode(this));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Long.toString(System.currentTimeMillis(), 36));
        String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        this.boundary = sb;
        this.boundaryBytes = sb.getBytes("ISO-8859-1");
        this.inPart = false;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.inPart) {
            ((FilterOutputStream) this).out.write(__CRLF);
        }
        ((FilterOutputStream) this).out.write(__DASHDASH);
        ((FilterOutputStream) this).out.write(this.boundaryBytes);
        ((FilterOutputStream) this).out.write(__DASHDASH);
        ((FilterOutputStream) this).out.write(__CRLF);
        this.inPart = false;
        super.close();
    }

    public String getBoundary() {
        return this.boundary;
    }

    public OutputStream getOut() {
        return ((FilterOutputStream) this).out;
    }

    public void startPart(String str) throws IOException {
        if (this.inPart) {
            ((FilterOutputStream) this).out.write(__CRLF);
        }
        this.inPart = true;
        ((FilterOutputStream) this).out.write(__DASHDASH);
        ((FilterOutputStream) this).out.write(this.boundaryBytes);
        ((FilterOutputStream) this).out.write(__CRLF);
        if (str != null) {
            OutputStream outputStream = ((FilterOutputStream) this).out;
            outputStream.write(("Content-Type: " + str).getBytes("ISO-8859-1"));
        }
        ((FilterOutputStream) this).out.write(__CRLF);
        ((FilterOutputStream) this).out.write(__CRLF);
    }

    public void startPart(String str, String[] strArr) throws IOException {
        if (this.inPart) {
            ((FilterOutputStream) this).out.write(__CRLF);
        }
        this.inPart = true;
        ((FilterOutputStream) this).out.write(__DASHDASH);
        ((FilterOutputStream) this).out.write(this.boundaryBytes);
        ((FilterOutputStream) this).out.write(__CRLF);
        if (str != null) {
            OutputStream outputStream = ((FilterOutputStream) this).out;
            outputStream.write(("Content-Type: " + str).getBytes("ISO-8859-1"));
        }
        ((FilterOutputStream) this).out.write(__CRLF);
        for (int i = 0; strArr != null && i < strArr.length; i++) {
            ((FilterOutputStream) this).out.write(strArr[i].getBytes("ISO-8859-1"));
            ((FilterOutputStream) this).out.write(__CRLF);
        }
        ((FilterOutputStream) this).out.write(__CRLF);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        ((FilterOutputStream) this).out.write(bArr, i, i2);
    }
}
