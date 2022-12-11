package org.apache.commons.p056io.output;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.p056io.IOUtils;

/* renamed from: org.apache.commons.io.output.DeferredFileOutputStream */
/* loaded from: classes4.dex */
public class DeferredFileOutputStream extends ThresholdingOutputStream {
    public boolean closed;
    public OutputStream currentOutputStream;
    public final File directory;
    public ByteArrayOutputStream memoryOutputStream;
    public File outputFile;
    public final String prefix;
    public final String suffix;

    public DeferredFileOutputStream(int i, File file) {
        this(i, file, null, null, null);
    }

    public DeferredFileOutputStream(int i, File file, String str, String str2, File file2) {
        super(i);
        this.closed = false;
        this.outputFile = file;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.memoryOutputStream = byteArrayOutputStream;
        this.currentOutputStream = byteArrayOutputStream;
        this.prefix = str;
        this.suffix = str2;
        this.directory = file2;
    }

    public DeferredFileOutputStream(int i, String str, String str2, File file) {
        this(i, null, str, str2, file);
        if (str != null) {
            return;
        }
        throw new IllegalArgumentException("Temporary file prefix is missing");
    }

    @Override // org.apache.commons.p056io.output.ThresholdingOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        this.closed = true;
    }

    public byte[] getData() {
        ByteArrayOutputStream byteArrayOutputStream = this.memoryOutputStream;
        if (byteArrayOutputStream != null) {
            return byteArrayOutputStream.toByteArray();
        }
        return null;
    }

    public File getFile() {
        return this.outputFile;
    }

    @Override // org.apache.commons.p056io.output.ThresholdingOutputStream
    public OutputStream getStream() throws IOException {
        return this.currentOutputStream;
    }

    public boolean isInMemory() {
        return !isThresholdExceeded();
    }

    @Override // org.apache.commons.p056io.output.ThresholdingOutputStream
    public void thresholdReached() throws IOException {
        String str = this.prefix;
        if (str != null) {
            this.outputFile = File.createTempFile(str, this.suffix, this.directory);
        }
        FileOutputStream fileOutputStream = new FileOutputStream(this.outputFile);
        try {
            this.memoryOutputStream.writeTo(fileOutputStream);
            this.currentOutputStream = fileOutputStream;
            this.memoryOutputStream = null;
        } catch (IOException e) {
            fileOutputStream.close();
            throw e;
        }
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        if (this.closed) {
            if (isInMemory()) {
                this.memoryOutputStream.writeTo(outputStream);
                return;
            }
            FileInputStream fileInputStream = new FileInputStream(this.outputFile);
            try {
                IOUtils.copy(fileInputStream, outputStream);
                return;
            } finally {
                IOUtils.closeQuietly((InputStream) fileInputStream);
            }
        }
        throw new IOException("Stream not closed");
    }
}
