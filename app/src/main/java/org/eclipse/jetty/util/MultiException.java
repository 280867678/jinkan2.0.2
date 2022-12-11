package org.eclipse.jetty.util;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;
import okhttp3.HttpUrl;

/* loaded from: classes5.dex */
public class MultiException extends Exception {
    public Object nested;

    public MultiException() {
        super("Multiple exceptions");
    }

    public void add(Throwable th) {
        if (!(th instanceof MultiException)) {
            this.nested = LazyList.add(this.nested, th);
            return;
        }
        MultiException multiException = (MultiException) th;
        for (int i = 0; i < LazyList.size(multiException.nested); i++) {
            this.nested = LazyList.add(this.nested, LazyList.get(multiException.nested, i));
        }
    }

    public Throwable getThrowable(int i) {
        return (Throwable) LazyList.get(this.nested, i);
    }

    public List<Throwable> getThrowables() {
        return LazyList.getList(this.nested);
    }

    public void ifExceptionThrow() throws Exception {
        int size = LazyList.size(this.nested);
        if (size != 0) {
            if (size == 1) {
                Throwable th = (Throwable) LazyList.get(this.nested, 0);
                if (th instanceof Error) {
                    throw ((Error) th);
                }
                if (th instanceof Exception) {
                    throw ((Exception) th);
                }
            }
            throw this;
        }
    }

    public void ifExceptionThrowMulti() throws MultiException {
        if (LazyList.size(this.nested) <= 0) {
            return;
        }
        throw this;
    }

    public void ifExceptionThrowRuntime() throws Error {
        int size = LazyList.size(this.nested);
        if (size != 0) {
            if (size != 1) {
                throw new RuntimeException(this);
            }
            Throwable th = (Throwable) LazyList.get(this.nested, 0);
            if (th instanceof Error) {
                throw ((Error) th);
            }
            if (!(th instanceof RuntimeException)) {
                throw new RuntimeException(th);
            }
            throw ((RuntimeException) th);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        super.printStackTrace();
        for (int i = 0; i < LazyList.size(this.nested); i++) {
            ((Throwable) LazyList.get(this.nested, i)).printStackTrace();
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        for (int i = 0; i < LazyList.size(this.nested); i++) {
            ((Throwable) LazyList.get(this.nested, i)).printStackTrace(printStream);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        for (int i = 0; i < LazyList.size(this.nested); i++) {
            ((Throwable) LazyList.get(this.nested, i)).printStackTrace(printWriter);
        }
    }

    public int size() {
        return LazyList.size(this.nested);
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb;
        if (LazyList.size(this.nested) > 0) {
            sb = new StringBuilder();
            sb.append(MultiException.class.getSimpleName());
            sb.append(LazyList.getList(this.nested));
        } else {
            sb = new StringBuilder();
            sb.append(MultiException.class.getSimpleName());
            sb.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        }
        return sb.toString();
    }
}
