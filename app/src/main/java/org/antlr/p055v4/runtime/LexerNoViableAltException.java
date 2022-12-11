package org.antlr.p055v4.runtime;

import java.util.Locale;
import me.tvspark.ny0;
import me.tvspark.sx0;
import me.tvspark.z01;
import me.tvspark.zx0;

/* renamed from: org.antlr.v4.runtime.LexerNoViableAltException */
/* loaded from: classes4.dex */
public class LexerNoViableAltException extends RecognitionException {
    public final ny0 deadEndConfigs;
    public final int startIndex;

    public LexerNoViableAltException(zx0 zx0Var, sx0 sx0Var, int i, ny0 ny0Var) {
        super(zx0Var, sx0Var, null);
        this.startIndex = i;
        this.deadEndConfigs = ny0Var;
    }

    public ny0 getDeadEndConfigs() {
        return this.deadEndConfigs;
    }

    @Override // org.antlr.p055v4.runtime.RecognitionException
    /* renamed from: getInputStream */
    public sx0 mo5113getInputStream() {
        return (sx0) super.mo5113getInputStream();
    }

    public int getStartIndex() {
        return this.startIndex;
    }

    @Override // java.lang.Throwable
    public String toString() {
        String str;
        char[] charArray;
        String str2;
        int i = this.startIndex;
        if (i < 0 || i >= mo5113getInputStream().size()) {
            str = "";
        } else {
            sx0 mo5113getInputStream = mo5113getInputStream();
            int i2 = this.startIndex;
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = mo5113getInputStream.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z01.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, i2));
            StringBuilder sb = new StringBuilder();
            for (char c : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toCharArray()) {
                if (c == '\t') {
                    str2 = "\\t";
                } else if (c == '\n') {
                    str2 = "\\n";
                } else if (c == '\r') {
                    str2 = "\\r";
                } else {
                    sb.append(c);
                }
                sb.append(str2);
            }
            str = sb.toString();
        }
        return String.format(Locale.getDefault(), "%s('%s')", LexerNoViableAltException.class.getSimpleName(), str);
    }
}
