package org.mozilla.javascript.tools.shell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.charset.Charset;
import org.mozilla.javascript.Kit;
import org.mozilla.javascript.Scriptable;

/* loaded from: classes5.dex */
public abstract class ShellConsole {
    public static final Class[] NO_ARG = new Class[0];
    public static final Class[] BOOLEAN_ARG = {Boolean.TYPE};
    public static final Class[] STRING_ARG = {String.class};
    public static final Class[] CHARSEQ_ARG = {CharSequence.class};

    /* loaded from: classes5.dex */
    public static class ConsoleInputStream extends InputStream {
        public static final byte[] EMPTY = new byte[0];
        public final ShellConsole console;

        /* renamed from: cs */
        public final Charset f4750cs;
        public byte[] buffer = EMPTY;
        public int cursor = -1;
        public boolean atEOF = false;

        public ConsoleInputStream(ShellConsole shellConsole, Charset charset) {
            this.console = shellConsole;
            this.f4750cs = charset;
        }

        private boolean ensureInput() throws IOException {
            if (this.atEOF) {
                return false;
            }
            int i = this.cursor;
            if (i < 0 || i > this.buffer.length) {
                if (readNextLine() == -1) {
                    this.atEOF = true;
                    return false;
                }
                this.cursor = 0;
            }
            return true;
        }

        private int readNextLine() throws IOException {
            String readLine = this.console.readLine(null);
            if (readLine == null) {
                this.buffer = EMPTY;
                return -1;
            }
            byte[] bytes = readLine.getBytes(this.f4750cs);
            this.buffer = bytes;
            return bytes.length;
        }

        @Override // java.io.InputStream
        public synchronized int read() throws IOException {
            int i;
            if (!ensureInput()) {
                i = -1;
            } else if (this.cursor != this.buffer.length) {
                byte[] bArr = this.buffer;
                int i2 = this.cursor;
                this.cursor = i2 + 1;
                return bArr[i2];
            } else {
                this.cursor++;
                i = 10;
            }
            return i;
        }

        @Override // java.io.InputStream
        public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
            if (bArr != null) {
                if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
                    throw new IndexOutOfBoundsException();
                }
                if (i2 == 0) {
                    return 0;
                }
                if (!ensureInput()) {
                    return -1;
                }
                int min = Math.min(i2, this.buffer.length - this.cursor);
                for (int i3 = 0; i3 < min; i3++) {
                    bArr[i + i3] = this.buffer[this.cursor + i3];
                }
                if (min < i2) {
                    bArr[i + min] = 10;
                    min++;
                }
                this.cursor += min;
                return min;
            }
            throw new NullPointerException();
        }
    }

    /* loaded from: classes5.dex */
    public static class JLineShellConsoleV1 extends ShellConsole {

        /* renamed from: in */
        public final InputStream f4751in;
        public final Object reader;

        public JLineShellConsoleV1(Object obj, Charset charset) {
            this.reader = obj;
            this.f4751in = new ConsoleInputStream(this, charset);
        }

        @Override // org.mozilla.javascript.tools.shell.ShellConsole
        public void flush() throws IOException {
            ShellConsole.tryInvoke(this.reader, "flushConsole", ShellConsole.NO_ARG, new Object[0]);
        }

        @Override // org.mozilla.javascript.tools.shell.ShellConsole
        public InputStream getIn() {
            return this.f4751in;
        }

        @Override // org.mozilla.javascript.tools.shell.ShellConsole
        public void print(String str) throws IOException {
            ShellConsole.tryInvoke(this.reader, "printString", ShellConsole.STRING_ARG, str);
        }

        @Override // org.mozilla.javascript.tools.shell.ShellConsole
        public void println() throws IOException {
            ShellConsole.tryInvoke(this.reader, "printNewline", ShellConsole.NO_ARG, new Object[0]);
        }

        @Override // org.mozilla.javascript.tools.shell.ShellConsole
        public void println(String str) throws IOException {
            ShellConsole.tryInvoke(this.reader, "printString", ShellConsole.STRING_ARG, str);
            ShellConsole.tryInvoke(this.reader, "printNewline", ShellConsole.NO_ARG, new Object[0]);
        }

        @Override // org.mozilla.javascript.tools.shell.ShellConsole
        public String readLine() throws IOException {
            return (String) ShellConsole.tryInvoke(this.reader, "readLine", ShellConsole.NO_ARG, new Object[0]);
        }

        @Override // org.mozilla.javascript.tools.shell.ShellConsole
        public String readLine(String str) throws IOException {
            return (String) ShellConsole.tryInvoke(this.reader, "readLine", ShellConsole.STRING_ARG, str);
        }
    }

    /* loaded from: classes5.dex */
    public static class JLineShellConsoleV2 extends ShellConsole {

        /* renamed from: in */
        public final InputStream f4752in;
        public final Object reader;

        public JLineShellConsoleV2(Object obj, Charset charset) {
            this.reader = obj;
            this.f4752in = new ConsoleInputStream(this, charset);
        }

        @Override // org.mozilla.javascript.tools.shell.ShellConsole
        public void flush() throws IOException {
            ShellConsole.tryInvoke(this.reader, "flush", ShellConsole.NO_ARG, new Object[0]);
        }

        @Override // org.mozilla.javascript.tools.shell.ShellConsole
        public InputStream getIn() {
            return this.f4752in;
        }

        @Override // org.mozilla.javascript.tools.shell.ShellConsole
        public void print(String str) throws IOException {
            ShellConsole.tryInvoke(this.reader, "print", ShellConsole.CHARSEQ_ARG, str);
        }

        @Override // org.mozilla.javascript.tools.shell.ShellConsole
        public void println() throws IOException {
            ShellConsole.tryInvoke(this.reader, "println", ShellConsole.NO_ARG, new Object[0]);
        }

        @Override // org.mozilla.javascript.tools.shell.ShellConsole
        public void println(String str) throws IOException {
            ShellConsole.tryInvoke(this.reader, "println", ShellConsole.CHARSEQ_ARG, str);
        }

        @Override // org.mozilla.javascript.tools.shell.ShellConsole
        public String readLine() throws IOException {
            return (String) ShellConsole.tryInvoke(this.reader, "readLine", ShellConsole.NO_ARG, new Object[0]);
        }

        @Override // org.mozilla.javascript.tools.shell.ShellConsole
        public String readLine(String str) throws IOException {
            return (String) ShellConsole.tryInvoke(this.reader, "readLine", ShellConsole.STRING_ARG, str);
        }
    }

    /* loaded from: classes5.dex */
    public static class SimpleShellConsole extends ShellConsole {

        /* renamed from: in */
        public final InputStream f4753in;
        public final PrintWriter out;
        public final BufferedReader reader;

        public SimpleShellConsole(InputStream inputStream, PrintStream printStream, Charset charset) {
            this.f4753in = inputStream;
            this.out = new PrintWriter(printStream);
            this.reader = new BufferedReader(new InputStreamReader(inputStream, charset));
        }

        @Override // org.mozilla.javascript.tools.shell.ShellConsole
        public void flush() throws IOException {
            this.out.flush();
        }

        @Override // org.mozilla.javascript.tools.shell.ShellConsole
        public InputStream getIn() {
            return this.f4753in;
        }

        @Override // org.mozilla.javascript.tools.shell.ShellConsole
        public void print(String str) throws IOException {
            this.out.print(str);
        }

        @Override // org.mozilla.javascript.tools.shell.ShellConsole
        public void println() throws IOException {
            this.out.println();
        }

        @Override // org.mozilla.javascript.tools.shell.ShellConsole
        public void println(String str) throws IOException {
            this.out.println(str);
        }

        @Override // org.mozilla.javascript.tools.shell.ShellConsole
        public String readLine() throws IOException {
            return this.reader.readLine();
        }

        @Override // org.mozilla.javascript.tools.shell.ShellConsole
        public String readLine(String str) throws IOException {
            if (str != null) {
                this.out.write(str);
                this.out.flush();
            }
            return this.reader.readLine();
        }
    }

    public static ShellConsole getConsole(InputStream inputStream, PrintStream printStream, Charset charset) {
        return new SimpleShellConsole(inputStream, printStream, charset);
    }

    public static ShellConsole getConsole(Scriptable scriptable, Charset charset) {
        Class<?> classOrNull;
        ClassLoader classLoader = ShellConsole.class.getClassLoader();
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        if (classLoader == null) {
            return null;
        }
        try {
            classOrNull = Kit.classOrNull(classLoader, "jline.console.ConsoleReader");
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
        }
        if (classOrNull != null) {
            return getJLineShellConsoleV2(classLoader, classOrNull, scriptable, charset);
        }
        Class<?> classOrNull2 = Kit.classOrNull(classLoader, "jline.ConsoleReader");
        if (classOrNull2 != null) {
            return getJLineShellConsoleV1(classLoader, classOrNull2, scriptable, charset);
        }
        return null;
    }

    public static JLineShellConsoleV1 getJLineShellConsoleV1(ClassLoader classLoader, Class<?> cls, Scriptable scriptable, Charset charset) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Object newInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
        tryInvoke(newInstance, "setBellEnabled", BOOLEAN_ARG, Boolean.FALSE);
        Class<?> classOrNull = Kit.classOrNull(classLoader, "jline.Completor");
        tryInvoke(newInstance, "addCompletor", new Class[]{classOrNull}, Proxy.newProxyInstance(classLoader, new Class[]{classOrNull}, new FlexibleCompletor(classOrNull, scriptable)));
        return new JLineShellConsoleV1(newInstance, charset);
    }

    public static JLineShellConsoleV2 getJLineShellConsoleV2(ClassLoader classLoader, Class<?> cls, Scriptable scriptable, Charset charset) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Object newInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
        tryInvoke(newInstance, "setBellEnabled", BOOLEAN_ARG, Boolean.FALSE);
        Class<?> classOrNull = Kit.classOrNull(classLoader, "jline.console.completer.Completer");
        tryInvoke(newInstance, "addCompleter", new Class[]{classOrNull}, Proxy.newProxyInstance(classLoader, new Class[]{classOrNull}, new FlexibleCompletor(classOrNull, scriptable)));
        return new JLineShellConsoleV2(newInstance, charset);
    }

    public static Object tryInvoke(Object obj, String str, Class[] clsArr, Object... objArr) {
        try {
            Method declaredMethod = obj.getClass().getDeclaredMethod(str, clsArr);
            if (declaredMethod == null) {
                return null;
            }
            return declaredMethod.invoke(obj, objArr);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    public abstract void flush() throws IOException;

    public abstract InputStream getIn();

    public abstract void print(String str) throws IOException;

    public abstract void println() throws IOException;

    public abstract void println(String str) throws IOException;

    public abstract String readLine() throws IOException;

    public abstract String readLine(String str) throws IOException;
}
