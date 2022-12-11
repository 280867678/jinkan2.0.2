package org.mozilla.javascript.tools.shell;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.mozilla.javascript.Context;

/* loaded from: classes5.dex */
public class PipeThread extends Thread {
    public InputStream from;
    public boolean fromProcess;

    /* renamed from: to */
    public OutputStream f4747to;

    public PipeThread(boolean z, InputStream inputStream, OutputStream outputStream) {
        setDaemon(true);
        this.fromProcess = z;
        this.from = inputStream;
        this.f4747to = outputStream;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            Global.pipe(this.fromProcess, this.from, this.f4747to);
        } catch (IOException e) {
            throw Context.throwAsScriptRuntimeEx(e);
        }
    }
}
