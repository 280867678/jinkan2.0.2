package org.eclipse.jetty.p059io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* renamed from: org.eclipse.jetty.io.UncheckedPrintWriter */
/* loaded from: classes4.dex */
public class UncheckedPrintWriter extends PrintWriter {
    public static final Logger LOG = Log.getLogger(UncheckedPrintWriter.class);
    public boolean _autoFlush;
    public IOException _ioException;
    public boolean _isClosed;
    public String _lineSeparator;

    public UncheckedPrintWriter(OutputStream outputStream) {
        this(outputStream, false);
    }

    public UncheckedPrintWriter(OutputStream outputStream, boolean z) {
        this(new BufferedWriter(new OutputStreamWriter(outputStream)), z);
    }

    public UncheckedPrintWriter(Writer writer) {
        this(writer, false);
    }

    public UncheckedPrintWriter(Writer writer, boolean z) {
        super(writer, z);
        this._autoFlush = false;
        this._isClosed = false;
        this._autoFlush = z;
        this._lineSeparator = System.getProperty("line.separator");
    }

    private void isOpen() throws IOException {
        if (this._ioException == null) {
            if (this._isClosed) {
                throw new IOException("Stream closed");
            }
            return;
        }
        throw new RuntimeIOException(this._ioException);
    }

    private void newLine() {
        try {
            synchronized (((PrintWriter) this).lock) {
                isOpen();
                ((PrintWriter) this).out.write(this._lineSeparator);
                if (this._autoFlush) {
                    ((PrintWriter) this).out.flush();
                }
            }
        } catch (InterruptedIOException unused) {
            Thread.currentThread().interrupt();
        } catch (IOException e) {
            setError(e);
        }
    }

    private void setError(Throwable th) {
        super.setError();
        if (th instanceof IOException) {
            this._ioException = (IOException) th;
        } else {
            IOException iOException = new IOException(String.valueOf(th));
            this._ioException = iOException;
            iOException.initCause(th);
        }
        LOG.debug(th);
    }

    @Override // java.io.PrintWriter
    public boolean checkError() {
        return this._ioException != null || super.checkError();
    }

    @Override // java.io.PrintWriter, java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            synchronized (((PrintWriter) this).lock) {
                ((PrintWriter) this).out.close();
                this._isClosed = true;
            }
        } catch (IOException e) {
            setError(e);
        }
    }

    @Override // java.io.PrintWriter, java.io.Writer, java.io.Flushable
    public void flush() {
        try {
            synchronized (((PrintWriter) this).lock) {
                isOpen();
                ((PrintWriter) this).out.flush();
            }
        } catch (IOException e) {
            setError(e);
        }
    }

    @Override // java.io.PrintWriter
    public void print(char c) {
        write(c);
    }

    @Override // java.io.PrintWriter
    public void print(double d) {
        write(String.valueOf(d));
    }

    @Override // java.io.PrintWriter
    public void print(float f) {
        write(String.valueOf(f));
    }

    @Override // java.io.PrintWriter
    public void print(int i) {
        write(String.valueOf(i));
    }

    @Override // java.io.PrintWriter
    public void print(long j) {
        write(String.valueOf(j));
    }

    @Override // java.io.PrintWriter
    public void print(Object obj) {
        write(String.valueOf(obj));
    }

    @Override // java.io.PrintWriter
    public void print(String str) {
        if (str == null) {
            str = "null";
        }
        write(str);
    }

    @Override // java.io.PrintWriter
    public void print(boolean z) {
        write(z ? "true" : "false");
    }

    @Override // java.io.PrintWriter
    public void print(char[] cArr) {
        write(cArr);
    }

    @Override // java.io.PrintWriter
    public void println() {
        newLine();
    }

    @Override // java.io.PrintWriter
    public void println(char c) {
        synchronized (((PrintWriter) this).lock) {
            print(c);
            println();
        }
    }

    @Override // java.io.PrintWriter
    public void println(double d) {
        synchronized (((PrintWriter) this).lock) {
            print(d);
            println();
        }
    }

    @Override // java.io.PrintWriter
    public void println(float f) {
        synchronized (((PrintWriter) this).lock) {
            print(f);
            println();
        }
    }

    @Override // java.io.PrintWriter
    public void println(int i) {
        synchronized (((PrintWriter) this).lock) {
            print(i);
            println();
        }
    }

    @Override // java.io.PrintWriter
    public void println(long j) {
        synchronized (((PrintWriter) this).lock) {
            print(j);
            println();
        }
    }

    @Override // java.io.PrintWriter
    public void println(Object obj) {
        synchronized (((PrintWriter) this).lock) {
            print(obj);
            println();
        }
    }

    @Override // java.io.PrintWriter
    public void println(String str) {
        synchronized (((PrintWriter) this).lock) {
            print(str);
            println();
        }
    }

    @Override // java.io.PrintWriter
    public void println(boolean z) {
        synchronized (((PrintWriter) this).lock) {
            print(z);
            println();
        }
    }

    @Override // java.io.PrintWriter
    public void println(char[] cArr) {
        synchronized (((PrintWriter) this).lock) {
            print(cArr);
            println();
        }
    }

    @Override // java.io.PrintWriter
    public void setError() {
        setError(new IOException());
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(int i) {
        try {
            synchronized (((PrintWriter) this).lock) {
                isOpen();
                ((PrintWriter) this).out.write(i);
            }
        } catch (InterruptedIOException unused) {
            Thread.currentThread().interrupt();
        } catch (IOException e) {
            setError(e);
        }
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(String str) {
        write(str, 0, str.length());
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(String str, int i, int i2) {
        try {
            synchronized (((PrintWriter) this).lock) {
                isOpen();
                ((PrintWriter) this).out.write(str, i, i2);
            }
        } catch (InterruptedIOException unused) {
            Thread.currentThread().interrupt();
        } catch (IOException e) {
            setError(e);
        }
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(char[] cArr) {
        write(cArr, 0, cArr.length);
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        try {
            synchronized (((PrintWriter) this).lock) {
                isOpen();
                ((PrintWriter) this).out.write(cArr, i, i2);
            }
        } catch (InterruptedIOException unused) {
            Thread.currentThread().interrupt();
        } catch (IOException e) {
            setError(e);
        }
    }
}
