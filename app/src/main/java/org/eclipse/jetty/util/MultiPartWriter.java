package org.eclipse.jetty.util;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;
import me.tvspark.outline;

/* loaded from: classes5.dex */
public class MultiPartWriter extends FilterWriter {
    public static String MULTIPART_MIXED = MultiPartOutputStream.MULTIPART_MIXED;
    public static String MULTIPART_X_MIXED_REPLACE = MultiPartOutputStream.MULTIPART_X_MIXED_REPLACE;
    public static final String __CRLF = "\r\n";
    public static final String __DASHDASH = "--";
    public String boundary;
    public boolean inPart;

    public MultiPartWriter(Writer writer) throws IOException {
        super(writer);
        this.inPart = false;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("jetty");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(System.identityHashCode(this));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Long.toString(System.currentTimeMillis(), 36));
        this.boundary = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        this.inPart = false;
    }

    @Override // java.io.FilterWriter, java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.inPart) {
            ((FilterWriter) this).out.write("\r\n");
        }
        ((FilterWriter) this).out.write(__DASHDASH);
        ((FilterWriter) this).out.write(this.boundary);
        ((FilterWriter) this).out.write(__DASHDASH);
        ((FilterWriter) this).out.write("\r\n");
        this.inPart = false;
        super.close();
    }

    public void endPart() throws IOException {
        if (this.inPart) {
            ((FilterWriter) this).out.write("\r\n");
        }
        this.inPart = false;
    }

    public String getBoundary() {
        return this.boundary;
    }

    public void startPart(String str) throws IOException {
        if (this.inPart) {
            ((FilterWriter) this).out.write("\r\n");
        }
        ((FilterWriter) this).out.write(__DASHDASH);
        ((FilterWriter) this).out.write(this.boundary);
        ((FilterWriter) this).out.write("\r\n");
        ((FilterWriter) this).out.write("Content-Type: ");
        ((FilterWriter) this).out.write(str);
        ((FilterWriter) this).out.write("\r\n");
        ((FilterWriter) this).out.write("\r\n");
        this.inPart = true;
    }

    public void startPart(String str, String[] strArr) throws IOException {
        if (this.inPart) {
            ((FilterWriter) this).out.write("\r\n");
        }
        ((FilterWriter) this).out.write(__DASHDASH);
        ((FilterWriter) this).out.write(this.boundary);
        ((FilterWriter) this).out.write("\r\n");
        ((FilterWriter) this).out.write("Content-Type: ");
        ((FilterWriter) this).out.write(str);
        ((FilterWriter) this).out.write("\r\n");
        for (int i = 0; strArr != null && i < strArr.length; i++) {
            ((FilterWriter) this).out.write(strArr[i]);
            ((FilterWriter) this).out.write("\r\n");
        }
        ((FilterWriter) this).out.write("\r\n");
        this.inPart = true;
    }
}
