package org.mozilla.javascript.tools.shell;

/* loaded from: classes5.dex */
public class ConsoleWrite implements Runnable {
    public String str;
    public ConsoleTextArea textArea;

    public ConsoleWrite(ConsoleTextArea consoleTextArea, String str) {
        this.textArea = consoleTextArea;
        this.str = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.textArea.write(this.str);
    }
}
