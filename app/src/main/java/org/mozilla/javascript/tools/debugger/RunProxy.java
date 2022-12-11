package org.mozilla.javascript.tools.debugger;

import org.mozilla.javascript.tools.debugger.Dim;

/* loaded from: classes5.dex */
public class RunProxy implements Runnable {
    public static final int ENTER_INTERRUPT = 4;
    public static final int LOAD_FILE = 2;
    public static final int OPEN_FILE = 1;
    public static final int UPDATE_SOURCE_TEXT = 3;
    public String alertMessage;
    public SwingGui debugGui;
    public String fileName;
    public Dim.StackFrame lastFrame;
    public Dim.SourceInfo sourceInfo;
    public String text;
    public String threadTitle;
    public int type;

    public RunProxy(SwingGui swingGui, int i) {
        this.debugGui = swingGui;
        this.type = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        SwingGui swingGui;
        String message;
        StringBuilder sb;
        String str;
        int i = this.type;
        if (i == 1) {
            try {
                this.debugGui.dim.compileScript(this.fileName, this.text);
                return;
            } catch (RuntimeException e) {
                swingGui = this.debugGui;
                message = e.getMessage();
                sb = new StringBuilder();
                str = "Error Compiling ";
            }
        } else if (i != 2) {
            if (i != 3) {
                if (i != 4) {
                    throw new IllegalArgumentException(String.valueOf(this.type));
                }
                this.debugGui.enterInterruptImpl(this.lastFrame, this.threadTitle, this.alertMessage);
                return;
            }
            String url = this.sourceInfo.url();
            if (this.debugGui.updateFileWindow(this.sourceInfo) || url.equals("<stdin>")) {
                return;
            }
            this.debugGui.createFileWindow(this.sourceInfo, -1);
            return;
        } else {
            try {
                this.debugGui.dim.evalScript(this.fileName, this.text);
                return;
            } catch (RuntimeException e2) {
                swingGui = this.debugGui;
                message = e2.getMessage();
                sb = new StringBuilder();
                str = "Run error for ";
            }
        }
        sb.append(str);
        sb.append(this.fileName);
        MessageDialogWrapper.showMessageDialog(swingGui, message, sb.toString(), 0);
    }
}
