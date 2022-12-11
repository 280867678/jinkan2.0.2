package org.eclipse.jetty.server.handler;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Locale;
import javax.servlet.ServletException;
import me.tvspark.ae0;
import me.tvspark.ce0;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.http.HttpHeaders;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Response;
import org.eclipse.jetty.util.DateCache;
import org.eclipse.jetty.util.RolloverFileOutputStream;

/* loaded from: classes4.dex */
public class DebugHandler extends HandlerWrapper {
    public DateCache _date = new DateCache("HH:mm:ss", Locale.US);
    public OutputStream _out;
    public PrintStream _print;

    @Override // org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.AggregateLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        if (this._out == null) {
            this._out = new RolloverFileOutputStream("./logs/yyyy_mm_dd.debug.log", true);
        }
        this._print = new PrintStream(this._out);
        super.doStart();
    }

    @Override // org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.AggregateLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        super.doStop();
        this._print.close();
    }

    public OutputStream getOutputStream() {
        return this._out;
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0227  */
    @Override // org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.Handler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handle(String str, Request request, ae0 ae0Var, ce0 ce0Var) throws IOException, ServletException {
        String str2;
        boolean z;
        PrintStream printStream;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        PrintStream printStream2;
        StringBuilder sb;
        PrintStream printStream3;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        String str3 = "";
        String str4 = ".";
        Response response = request.getResponse();
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        String str5 = (String) ae0Var.getAttribute("org.eclipse.jetty.thread.name");
        if (str5 == null) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(name, ":");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(request.getScheme());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("://");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(request.getLocalAddr());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(":");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(request.getLocalPort());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(request.getUri());
            str2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            z = false;
        } else {
            str2 = str5;
            z = true;
        }
        String str6 = null;
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                String now = this._date.now();
                try {
                    int lastMs = this._date.lastMs();
                    if (z) {
                        printStream2 = this._print;
                        sb = new StringBuilder();
                        sb.append(now);
                        sb.append(lastMs > 99 ? str4 : lastMs > 9 ? ".0" : ".00");
                        sb.append(lastMs);
                        sb.append(":");
                        sb.append(str2);
                        sb.append(" RETRY");
                    } else {
                        printStream2 = this._print;
                        sb = new StringBuilder();
                        sb.append(now);
                        sb.append(lastMs > 99 ? str4 : lastMs > 9 ? ".0" : ".00");
                        sb.append(lastMs);
                        sb.append(":");
                        sb.append(str2);
                        sb.append(StringUtils.SPACE);
                        sb.append(request.getRemoteAddr());
                        sb.append(StringUtils.SPACE);
                        sb.append(ae0Var.getMethod());
                        sb.append(StringUtils.SPACE);
                        sb.append(request.getHeader(HttpHeaders.COOKIE));
                        sb.append("; ");
                        sb.append(request.getHeader("User-Agent"));
                    }
                    printStream2.println(sb.toString());
                    currentThread.setName(str2);
                    getHandler().handle(str, request, ae0Var, ce0Var);
                    currentThread.setName(name);
                    String now2 = this._date.now();
                    int lastMs2 = this._date.lastMs();
                    if (request.getAsyncContinuation().isSuspended()) {
                        ae0Var.setAttribute("org.eclipse.jetty.thread.name", str2);
                        printStream3 = this._print;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(now2);
                        if (lastMs2 <= 99) {
                            str4 = lastMs2 > 9 ? ".0" : ".00";
                        }
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(str4);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(lastMs2);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(":");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(str2);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" SUSPEND");
                    } else {
                        printStream3 = this._print;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(now2);
                        if (lastMs2 <= 99) {
                            str4 = lastMs2 > 9 ? ".0" : ".00";
                        }
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(str4);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(lastMs2);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(":");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(str2);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(StringUtils.SPACE);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(response.getStatus());
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(str3);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(StringUtils.SPACE);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(response.getContentType());
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(StringUtils.SPACE);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(response.getContentCount());
                    }
                    printStream3.println(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                } catch (IOException e) {
                    e = e;
                    e.toString();
                    throw e;
                } catch (Error e2) {
                    e = e2;
                    e.toString();
                    throw e;
                } catch (RuntimeException e3) {
                    e = e3;
                    e.toString();
                    throw e;
                } catch (ServletException e4) {
                    e = e4;
                    String str7 = e.toString() + ":" + e.getCause();
                    throw e;
                }
            } catch (Throwable th2) {
                th = th2;
                str6 = ".0";
                String str8 = str6;
                currentThread.setName(name);
                String now3 = this._date.now();
                int lastMs3 = this._date.lastMs();
                if (!request.getAsyncContinuation().isSuspended()) {
                    ae0Var.setAttribute("org.eclipse.jetty.thread.name", str2);
                    printStream = this._print;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(now3);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(lastMs3 <= 99 ? lastMs3 > 9 ? ".0" : ".00" : str4);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(lastMs3);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(":");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str2);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" SUSPEND");
                } else {
                    printStream = this._print;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(now3);
                    if (lastMs3 <= 99) {
                        str4 = lastMs3 > 9 ? ".0" : ".00";
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str4);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(lastMs3);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(":");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str2);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(StringUtils.SPACE);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(response.getStatus());
                    if (str8 != null) {
                        str3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("/", str8);
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str3);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(StringUtils.SPACE);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(response.getContentType());
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(StringUtils.SPACE);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(response.getContentCount());
                }
                printStream.println(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
        } catch (Error e6) {
            e = e6;
        } catch (RuntimeException e7) {
            e = e7;
        } catch (ServletException e8) {
            e = e8;
        } catch (Throwable th3) {
            th = th3;
            String str82 = str6;
            currentThread.setName(name);
            String now32 = this._date.now();
            int lastMs32 = this._date.lastMs();
            if (!request.getAsyncContinuation().isSuspended()) {
            }
            printStream.println(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            throw th;
        }
    }

    public void setOutputStream(OutputStream outputStream) {
        this._out = outputStream;
    }
}
