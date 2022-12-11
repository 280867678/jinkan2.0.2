package me.tvspark;

import com.alibaba.fastjson.parser.JSONLexer;
import java.io.IOException;
import net.minidev.json.parser.ParseException;

/* loaded from: classes4.dex */
public class wv0 extends vv0 {
    public String Wwwwwwwwwww;

    public wv0(int i) {
        super(i);
    }

    @Override // me.tvspark.uv0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i >= this.Wwwwwwwwwwww ? JSONLexer.EOI : this.Wwwwwwwwwww.charAt(i);
    }

    @Override // me.tvspark.uv0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i >= this.Wwwwwwwwwwww ? JSONLexer.EOI : this.Wwwwwwwwwww.charAt(i);
    }

    @Override // me.tvspark.vv0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        while (i < i2 - 1 && Character.isWhitespace(this.Wwwwwwwwwww.charAt(i))) {
            i++;
        }
        while (true) {
            int i3 = i2 - 1;
            if (i3 <= i || !Character.isWhitespace(this.Wwwwwwwwwww.charAt(i3))) {
                break;
            }
            i2 = i3;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwww.substring(i, i2);
    }

    public <T> T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, qw0<T> qw0Var) throws ParseException {
        pw0 pw0Var = qw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwww = str;
        this.Wwwwwwwwwwww = str.length();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
        try {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            T t = (T) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(qw0Var);
            if (this.Wwwwwwwwwwwwwwwwwwwwwww) {
                if (!this.Wwwwwwwwwwwwwwwwwwwwww) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 26) {
                    throw new ParseException(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1, 1, Character.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                }
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            return t;
        } catch (IOException e) {
            throw new ParseException(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, e);
        }
    }
}
