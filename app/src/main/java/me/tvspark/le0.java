package me.tvspark;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ResourceBundle;
import javax.servlet.ServletOutputStream;

/* loaded from: classes4.dex */
public class le0 extends de0 {
    public static final ResourceBundle Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ResourceBundle.getBundle("javax.servlet.http.LocalStrings");
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public PrintWriter Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public ke0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ke0();

    public le0(ce0 ce0Var) {
        super(ce0Var);
    }

    @Override // javax.servlet.ServletResponseWrapper, javax.servlet.ServletResponse
    public ServletOutputStream getOutputStream() throws IOException {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getString("err.ise.getOutputStream"));
    }

    @Override // javax.servlet.ServletResponseWrapper, javax.servlet.ServletResponse
    public PrintWriter getWriter() throws UnsupportedEncodingException {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new PrintWriter(new OutputStreamWriter(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, getCharacterEncoding()));
            }
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getString("err.ise.getWriter"));
    }

    @Override // javax.servlet.ServletResponseWrapper, javax.servlet.ServletResponse
    public void setContentLength(int i) {
        super.setContentLength(i);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
    }
}
