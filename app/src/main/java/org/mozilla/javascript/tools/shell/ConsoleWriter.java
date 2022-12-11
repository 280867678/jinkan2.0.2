package org.mozilla.javascript.tools.shell;

import java.io.OutputStream;
import javax.swing.SwingUtilities;

/* loaded from: classes5.dex */
public class ConsoleWriter extends OutputStream {
    public StringBuffer buffer = new StringBuffer();
    public ConsoleTextArea textArea;

    public ConsoleWriter(ConsoleTextArea consoleTextArea) {
        this.textArea = consoleTextArea;
    }

    private void flushBuffer() {
        String stringBuffer = this.buffer.toString();
        this.buffer.setLength(0);
        SwingUtilities.invokeLater(new ConsoleWrite(this.textArea, stringBuffer));
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        flush();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public synchronized void flush() {
        if (this.buffer.length() > 0) {
            flushBuffer();
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) {
        this.buffer.append((char) i);
        if (i == 10) {
            flushBuffer();
        }
    }

    public synchronized void write(char[] cArr, int i, int i2) {
        while (i < i2) {
            this.buffer.append(cArr[i]);
            if (cArr[i] == '\n') {
                flushBuffer();
            }
            i++;
        }
    }
}
