package org.eclipse.jetty.util;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

/* renamed from: org.eclipse.jetty.util.IO */
/* loaded from: classes5.dex */
public class C3009IO {
    public static final String CRLF = "\r\n";
    public static final Logger LOG = Log.getLogger(C3009IO.class);
    public static final byte[] CRLF_BYTES = {13, 10};
    public static int bufferSize = 65536;
    public static NullOS __nullStream = new NullOS();
    public static ClosedIS __closedStream = new ClosedIS();
    public static NullWrite __nullWriter = new NullWrite();
    public static PrintWriter __nullPrintWriter = new PrintWriter(__nullWriter);

    /* renamed from: org.eclipse.jetty.util.IO$ClosedIS */
    /* loaded from: classes5.dex */
    public static class ClosedIS extends InputStream {
        public ClosedIS() {
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            return -1;
        }
    }

    /* renamed from: org.eclipse.jetty.util.IO$Job */
    /* loaded from: classes5.dex */
    public static class Job implements Runnable {

        /* renamed from: in */
        public InputStream f4593in;
        public OutputStream out;
        public Reader read;
        public Writer write;

        public Job(InputStream inputStream, OutputStream outputStream) {
            this.f4593in = inputStream;
            this.out = outputStream;
            this.read = null;
            this.write = null;
        }

        public Job(Reader reader, Writer writer) {
            this.f4593in = null;
            this.out = null;
            this.read = reader;
            this.write = writer;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.f4593in != null) {
                    C3009IO.copy(this.f4593in, this.out, -1L);
                } else {
                    C3009IO.copy(this.read, this.write, -1L);
                }
            } catch (IOException e) {
                C3009IO.LOG.ignore(e);
                try {
                    if (this.out != null) {
                        this.out.close();
                    }
                    if (this.write == null) {
                        return;
                    }
                    this.write.close();
                } catch (IOException e2) {
                    C3009IO.LOG.ignore(e2);
                }
            }
        }
    }

    /* renamed from: org.eclipse.jetty.util.IO$NullOS */
    /* loaded from: classes5.dex */
    public static class NullOS extends OutputStream {
        public NullOS() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.OutputStream
        public void write(int i) {
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
        }
    }

    /* renamed from: org.eclipse.jetty.util.IO$NullWrite */
    /* loaded from: classes5.dex */
    public static class NullWrite extends Writer {
        public NullWrite() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(int i) {
        }

        @Override // java.io.Writer
        public void write(String str) {
        }

        @Override // java.io.Writer
        public void write(String str, int i, int i2) {
        }

        @Override // java.io.Writer
        public void write(char[] cArr) {
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
        }
    }

    /* renamed from: org.eclipse.jetty.util.IO$Singleton */
    /* loaded from: classes5.dex */
    public static class Singleton {
        public static final QueuedThreadPool __pool;

        static {
            QueuedThreadPool queuedThreadPool = new QueuedThreadPool();
            __pool = queuedThreadPool;
            try {
                queuedThreadPool.start();
            } catch (Exception e) {
                C3009IO.LOG.warn(e);
                System.exit(1);
            }
        }
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                LOG.ignore(e);
            }
        }
    }

    public static void close(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                LOG.ignore(e);
            }
        }
    }

    public static void close(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                LOG.ignore(e);
            }
        }
    }

    public static void close(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                LOG.ignore(e);
            }
        }
    }

    public static void close(Writer writer) {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                LOG.ignore(e);
            }
        }
    }

    public static void copy(File file, File file2) throws IOException {
        if (file.isDirectory()) {
            copyDir(file, file2);
        } else {
            copyFile(file, file2);
        }
    }

    public static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        copy(inputStream, outputStream, -1L);
    }

    public static void copy(InputStream inputStream, OutputStream outputStream, long j) throws IOException {
        byte[] bArr = new byte[bufferSize];
        if (j >= 0) {
            while (j > 0) {
                int i = bufferSize;
                if (j < i) {
                    i = (int) j;
                }
                int read = inputStream.read(bArr, 0, i);
                if (read == -1) {
                    return;
                }
                j -= read;
                outputStream.write(bArr, 0, read);
            }
            return;
        }
        while (true) {
            int read2 = inputStream.read(bArr, 0, bufferSize);
            if (read2 < 0) {
                return;
            }
            outputStream.write(bArr, 0, read2);
        }
    }

    public static void copy(Reader reader, Writer writer) throws IOException {
        copy(reader, writer, -1L);
    }

    public static void copy(Reader reader, Writer writer, long j) throws IOException {
        int read;
        char[] cArr = new char[bufferSize];
        if (j >= 0) {
            while (j > 0) {
                int i = bufferSize;
                if (j < i) {
                    i = (int) j;
                }
                int read2 = reader.read(cArr, 0, i);
                if (read2 == -1) {
                    return;
                }
                j -= read2;
                writer.write(cArr, 0, read2);
            }
        } else if (writer instanceof PrintWriter) {
            PrintWriter printWriter = (PrintWriter) writer;
            while (!printWriter.checkError() && (read = reader.read(cArr, 0, bufferSize)) != -1) {
                writer.write(cArr, 0, read);
            }
        } else {
            while (true) {
                int read3 = reader.read(cArr, 0, bufferSize);
                if (read3 == -1) {
                    return;
                }
                writer.write(cArr, 0, read3);
            }
        }
    }

    public static void copyDir(File file, File file2) throws IOException {
        if (!file2.exists()) {
            file2.mkdirs();
        } else if (!file2.isDirectory()) {
            throw new IllegalArgumentException(file2.toString());
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (int i = 0; i < listFiles.length; i++) {
                String name = listFiles[i].getName();
                if (!".".equals(name) && !"..".equals(name)) {
                    copy(listFiles[i], new File(file2, name));
                }
            }
        }
    }

    public static void copyFile(File file, File file2) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        copy(fileInputStream, fileOutputStream);
        fileInputStream.close();
        fileOutputStream.close();
    }

    public static void copyThread(InputStream inputStream, OutputStream outputStream) {
        try {
            Job job = new Job(inputStream, outputStream);
            if (Singleton.__pool.dispatch(job)) {
                return;
            }
            job.run();
        } catch (Exception e) {
            LOG.warn(e);
        }
    }

    public static void copyThread(Reader reader, Writer writer) {
        try {
            Job job = new Job(reader, writer);
            if (Singleton.__pool.dispatch(job)) {
                return;
            }
            job.run();
        } catch (Exception e) {
            LOG.warn(e);
        }
    }

    public static boolean delete(File file) {
        if (!file.exists()) {
            return false;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            for (int i = 0; listFiles != null && i < listFiles.length; i++) {
                delete(listFiles[i]);
            }
        }
        return file.delete();
    }

    public static InputStream getClosedStream() {
        return __closedStream;
    }

    public static PrintWriter getNullPrintWriter() {
        return __nullPrintWriter;
    }

    public static OutputStream getNullStream() {
        return __nullStream;
    }

    public static Writer getNullWriter() {
        return __nullWriter;
    }

    public static byte[] readBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copy(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static String toString(InputStream inputStream) throws IOException {
        return toString(inputStream, null);
    }

    public static String toString(InputStream inputStream, String str) throws IOException {
        StringWriter stringWriter = new StringWriter();
        copy(str == null ? new InputStreamReader(inputStream) : new InputStreamReader(inputStream, str), stringWriter);
        return stringWriter.toString();
    }

    public static String toString(Reader reader) throws IOException {
        StringWriter stringWriter = new StringWriter();
        copy(reader, stringWriter);
        return stringWriter.toString();
    }
}
